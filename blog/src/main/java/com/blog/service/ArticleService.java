package com.blog.service;

import com.blog.bean.Article;
import com.blog.dao.ArticleMapper;
import com.blog.dao.TagMapper;
import com.blog.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.List;

/**
 * @author lryepoch
 * @date 2020/5/28 9:32
 * @description TODO
 */
@Service
public class ArticleService {
    @Autowired
    private ArticleMapper articleMapper;
    @Autowired
    private TagMapper tagMapper;

    public int addArticle(Article article) {
        //如果文章摘要为空，则截取正文一部分
        if ("".equals(article.getSummary()) || article.getSummary() == null) {
            String html = stripHtml(article.getContent());
            article.setSummary(html.substring(0,html.length()>50?50:html.length()));
        }
        //添加操作
        if (article.getId() == -1) {
            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            if (article.getState()==1){
                //设置发表时间
                article.setPublishTime(timestamp);
            }
            article.setEditTime(timestamp);
            //设置当前用户
            article.setUid(Util.getCurrentUser().getId());
            //添加
            int result=articleMapper.addArticle(article);

            //打标签
            String[] dynamicTags = article.getDynamicTags();
            if (dynamicTags!=null&&dynamicTags.length>0){
                int flag = addTagsToArticle(dynamicTags,article.getId());
                if (flag == -1){
                    return flag;
                }
            }
            return result;
            //到此，状态以及浏览数字段还没确定

            //文章修改操作
        } else {
            //修改对象：已发布、草稿箱；如果是已发布，则需要更新发布时间
            if (article.getState()==1){
                article.setPublishTime(new Timestamp(System.currentTimeMillis()));
            }
            article.setEditTime(new Timestamp(System.currentTimeMillis()));
            //修改
            int result = articleMapper.updateArticle(article);

            //修改标签
            String[] dynamicTags = article.getDynamicTags();
            if (dynamicTags!=null&&dynamicTags.length>0){
                int flag = addTagsToArticle(dynamicTags,article.getId());
                if (flag == -1){
                    return flag;
                }
            }
            return result;
        }
    }

    /**
    * @description 给文章添加标签
    * @author lryepoch
    * @date 2020/5/28 11:32
    *
    */
    private int addTagsToArticle(String[] dynamicTags, Integer aid) {
        //1.删除该文章目前所有标签
        tagMapper.deleteTagsByAid(aid);
        //2.将上传的新标签全部存入数据库
        tagMapper.saveTags(dynamicTags);
        //3.查询这些标签的id
        List<Integer> ids = tagMapper.getTagIdByTagName(dynamicTags);
        //4.将文章和标签插入到关系表中
        int result = tagMapper.addTagsToArticle2(ids,aid);
        return result == dynamicTags.length?result:-1;
    }

    /**
    * @description 如果摘要为空，则截取正文开头内容作为摘要
    * @author lryepoch
    * @date 2020/5/28 11:31
    *
    */
    private String stripHtml(String content) {
        content = content.replaceAll("<p .*?>","");
        content = content.replaceAll("<br\\s*/?>","");
        content = content.replaceAll("\\<.*?>","");
        return content;
    }

    public Article getArticleById(Integer aid) {
        Article article = articleMapper.getArticleById(aid);
        articleMapper.pvAdd(aid);
        return article;
    }

    public List getData() {
        int uid = Util.getCurrentUser().getId();
        return articleMapper.getData(uid);
    }

    public int updateArticleState(Integer[] aids, Integer state) {
        if (state==2){
            return articleMapper.deleteArticles(aids);
        } else {
         return articleMapper.updateArticles(aids,state);
        }
    }

    public List<Article> getArticleByState(Integer state, Integer page, Integer count, String keyword) {
        int start = (page-1)*count;
        Integer uid = Util.getCurrentUser().getId();
        return articleMapper.getArticleByState(state,start,count,uid,keyword);
    }
}
