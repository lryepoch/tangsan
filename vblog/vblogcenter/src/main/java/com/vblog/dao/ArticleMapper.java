package com.vblog.dao;

import com.vblog.entity.Article;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.swagger.models.auth.In;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author lryepoch
 * @since 2021-01-13
 */
public interface ArticleMapper extends BaseMapper<Article> {

    List<Article> getArticleByState(@Param("state") Integer state, @Param("start") Integer start, @Param("count") Integer count, @Param("uid") Integer uid, @Param("keywords") String keywords);

    int getArticleCountByState(@Param("state") Integer state, @Param("uid") Integer uid, @Param("keywords") String keywords);

    int deleteArticleById(@Param("aids") Integer[] aids);

    int updateArticleState(@Param("aids") Integer aids[], @Param("state") Integer state);

    int updateArticle(Article article);

    void pvIncrement(Integer id);

    List<String> getCategories(Integer uid);

    List<Integer> getDataStatistics(Integer id);
}
