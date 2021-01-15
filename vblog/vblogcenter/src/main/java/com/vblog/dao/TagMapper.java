package com.vblog.dao;

import com.vblog.entity.Tag;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
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
public interface TagMapper extends BaseMapper<Tag> {

    int saveTags(@Param("tags") String[] tags);

    List<Integer> getTagsIdByTagName(@Param("tagNames") String[] tagNames);

    int deleteTagsByAid(Integer aid);
}
