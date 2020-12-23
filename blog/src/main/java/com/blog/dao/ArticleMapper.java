package com.blog.dao;

import com.blog.bean.Article;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author lryepoch
 * @date 2020/5/28 9:32
 * @description TODO
 */
@Mapper
public interface ArticleMapper {
    int addArticle(Article article);

    int updateArticle(Article article);

    Article getArticleById(Integer aid);

    void pvAdd(Integer aid);

    List<Map<String,Integer>> getData(int uid);

    int deleteArticles(@Param("aids") Integer[] aids);

    int updateArticles(@Param("aids") Integer[] aids, @Param("state") Integer state);

    List<Article> getArticleByState(@Param("state") Integer state, @Param("start") int start, @Param("count") Integer count, @Param("uid") Integer uid, @Param("keyword") String keyword);

}
