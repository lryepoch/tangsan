package com.vblog.service;

import com.vblog.entity.User;
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
public interface UserService extends IService<User> {

    boolean updateUserEmail(String email);

    List<User> getUserByNickname(String nickname);

    User getUserById(Integer id);

    boolean updateUserEnabled(Boolean enabled, Integer uid);

    int deleteUserById(Integer uid);

    boolean updateUserRoles(Integer[] rids, Integer id);

    int reg(User user);
}
