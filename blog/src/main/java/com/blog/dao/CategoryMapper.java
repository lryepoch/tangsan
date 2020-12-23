package com.blog.dao;

import com.blog.bean.Category;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author lryepoch
 * @date 2020/5/27 18:53
 * @description TODO
 */
@Mapper
public interface CategoryMapper {
    List<Category> getAllCategory();

    int check(String cateName);

    int addCategory(String cateName);

    int updateCategory(String cateName);

    int deleteCategory(@Param("ids") String[] ids);
}
