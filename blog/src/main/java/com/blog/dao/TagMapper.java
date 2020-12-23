package com.blog.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author lryepoch
 * @date 2020/5/28 11:33
 * @description TODO
 */
@Mapper
public interface TagMapper {

    void deleteTagsByAid(Integer aid);

    void saveTags(@Param("tags") String[] dynamicTags);

    List<Integer> getTagIdByTagName(@Param("tagNames") String[] dynamicTags);

    int addTagsToArticle2(@Param("tagIds") List<Integer> ids, @Param("aid") Integer aid);
}
