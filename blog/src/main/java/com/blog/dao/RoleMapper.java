package com.blog.dao;

import com.blog.bean.Role;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author lryepoch
 * @date 2020/5/29 15:21
 * @description TODO
 */
@Mapper
public interface RoleMapper {
    List<Role> getRolesByUid(Integer uid);
}
