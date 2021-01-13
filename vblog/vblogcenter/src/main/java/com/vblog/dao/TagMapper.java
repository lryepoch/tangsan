package com.vblog.dao;

import com.vblog.entity.Tag;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

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

    int saveTags(String[] tags);

    List<Integer> getTagsIdByTagName(String[] tagNames);
}
