package com.vblog.service;

import com.vblog.entity.Article;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author lryepoch
 * @since 2021-01-13
 */
public interface ArticleService extends IService<Article> {

    List<Article> getArticleByState(Integer state, Integer page, Integer count, String keywords);

    int getArticleCountByState(Integer i, Integer uid, String keywords);

    int updateArticleState(Integer[] aids, Integer state);

    int addNewArticle(Article article);

    Article getArticleById(Integer aid);

    int restoreArticle(Integer articleId);

    List<String> getCategories();

    List<Integer> getDataStatistics();
}
