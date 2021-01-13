package com.vblog.dao;

import com.vblog.entity.User;
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
public interface UserMapper extends BaseMapper<User> {

    List<User> getUserByNickname(String nickname);

    User getUserById(Integer id);

    User loadUserByUsername(String username);

    int reg(User user);
}
