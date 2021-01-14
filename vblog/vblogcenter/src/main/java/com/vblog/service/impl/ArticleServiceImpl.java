package com.vblog.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.vblog.dao.TagMapper;
import com.vblog.entity.Article;
import com.vblog.dao.ArticleMapper;
import com.vblog.entity.ArticleTag;
import com.vblog.entity.Tag;
import com.vblog.service.ArticleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.vblog.service.ArticleTagService;
import com.vblog.service.TagService;
import com.vblog.util.SubjectUtil;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author lryepoch
 * @since 2021-01-13
 */
@Service
public class ArticleServiceImpl extends ServiceImpl<ArticleMapper, Article> implements ArticleService {
    @Autowired
    private ArticleMapper articleMapper;
    @Autowired
    private TagMapper tagMapper;
    @Autowired
    private ArticleTagService articleTagService;

    @Override
    public List<Article> getArticleByState(Integer state, Integer page, Integer count, String keywords) {
        int start = (page - 1) * count;
        Integer uId = SubjectUtil.getCurrentUser().getId();
        return articleMapper.getArticleByState(state, start, count, uId, keywords);
    }

    @Override
    public int getArticleCountByState(Integer state, Integer uid, String keywords) {
        return articleMapper.getArticleCountByState(state, uid, keywords);
    }

    ////0表示草稿箱，1表示已发表，2表示已删除
    @Override
    public int updateArticleState(Integer[] aids, Integer state) {
        if (state == 2) {
            return articleMapper.deleteArticleById(aids);//回收站中永久删除
        } else {
            return articleMapper.updateArticleState(aids, 2);//放入到回收站中
        }
    }

    @Override
    public int addNewArticle(Article article) {
        //如果没有文章摘要，直接截取正文前部分内容作为文章摘要
        if (article.getSummary() == null || "".equals(article.getSummary())) {
            String stripHtml = stripHtml(article.getHtmlContent());
            article.setSummary(stripHtml.substring(0, stripHtml.length() > 50 ? 50 : stripHtml.length()));
        }
        //0表示草稿箱，1表示已发表，2表示已删除
        if (article.getId() == -1) {
            //添加操作
            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            if (article.getState() == 1) {
                //设置发表日期
                article.setPublishTime(timestamp);
            }
            article.setEditTime(timestamp);
            //设置当前用户
            article.setUId(SubjectUtil.getCurrentUser().getId());
            int i = articleMapper.addNewArticle(article);
            //给博客添加标签
            String[] dynamicTags = article.getDynamicTags();
            if (dynamicTags != null && dynamicTags.length > 0) {
                boolean tags = addTagsToArticle(dynamicTags, article.getId());
                if (!tags) {
                    return -1;
                }
            }
            return i;
        } else {
            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            if (article.getState() == 1) {
                //设置发表日期
                article.setPublishTime(timestamp);
            }
            //更新
            article.setEditTime(new Timestamp(System.currentTimeMillis()));
            int i = articleMapper.updateArticle(article);
            //修改标签
            String[] dynamicTags = article.getDynamicTags();
            if (dynamicTags != null && dynamicTags.length > 0) {
                boolean tags = addTagsToArticle(dynamicTags, article.getId());
                if (!tags) {
                    return -1;
                }
            }
            return i;
        }
    }

    private boolean addTagsToArticle(String[] dynamicTags, Integer aid) {
        //1.删除博客标签关系表数据
        QueryWrapper<ArticleTag> wrapper = new QueryWrapper<>();
        wrapper.lambda().eq(ArticleTag::getAId, aid);
        articleTagService.remove(wrapper);
        //2.将新增标签存入数据库表
        tagMapper.saveTags(dynamicTags);
        //3.查询这些标签的id
        List<Integer> tIds = tagMapper.getTagsIdByTagName(dynamicTags);
        //4.重新给文章设置标签
        List<ArticleTag> articleTags = new ArrayList<>();
        ArticleTag articleTag;
        for (Integer tid:tIds){
            articleTag = new ArticleTag();
            articleTag.setAId(aid);
            articleTag.setTId(tid);
            articleTags.add(articleTag);
        }
        return articleTagService.saveBatch(articleTags);
    }

    private String stripHtml(String content) {
        content = content.replaceAll("<p .*?>", "");
        content = content.replaceAll("<br\\s*/?>", "");
        content = content.replaceAll("\\<.*?>", "");
        return content;
    }

    @Override
    public Article getArticleById(Integer aid) {
        Article article = articleMapper.selectById(aid);
        //文章所在页面浏览量加1
        articleMapper.pvIncrement(aid);
        return article;
    }

    @Override
    public boolean restoreArticle(Integer articleId) {
        Article article = new Article();
        article.setId(articleId);
        article.setState(1);
        return updateById(article);
    }

    /**
     * 获取最近七天的日期
     * @return
     */
    @Override
    public List<String> getCategories() {
        return articleMapper.getCategories(SubjectUtil.getCurrentUser().getId());
    }

    /**
     * 获取最近七天的数据
     * @return
     */
    @Override
    public List<Integer> getDataStatistics() {
        return articleMapper.getDataStatistics(SubjectUtil.getCurrentUser().getId());
    }
}
