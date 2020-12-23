package com.blog.dao;

import com.blog.bean.Role;
import com.blog.bean.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author lryepoch
 * @date 2020/5/28 19:03
 * @description TODO
 */
@Mapper
public interface UserMapper {
    List<User> getUserByNickname(String nickname);

    List<Role> getAllRole();

    User getUserById(Integer id);

    int deleteUserById(Integer uid);

    int updateUserEnabled(@Param("state") Integer state, @Param("uid") Integer uid);

    int updateUserRoles(@Param("rids") Integer[] rids, @Param("uid") Integer uid);

    void deleteUserRolesById(Integer uid);

    User loadUserByUsername(String username);
}
