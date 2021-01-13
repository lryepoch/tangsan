package com.vblog.dao;

import com.vblog.entity.Role;
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
public interface RoleMapper extends BaseMapper<Role> {

    List<Role> getRolesByUid(Integer uid);
}
