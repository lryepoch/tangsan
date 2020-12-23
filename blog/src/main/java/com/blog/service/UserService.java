package com.blog.service;

import com.blog.bean.Role;
import com.blog.bean.User;
import com.blog.dao.RoleMapper;
import com.blog.dao.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @author lryepoch
 * @date 2020/5/28 19:03
 * @description TODO
 */
@Service
public class UserService implements UserDetailsService {
    @Autowired
    UserMapper userMapper;
    @Autowired
    RoleMapper roleMapper;

    @RequestMapping("/user")
    public List<User> getUserByNickname(String nickname) {
        return userMapper.getUserByNickname(nickname);
    }

    public List<Role> getAllRole() {
        return userMapper.getAllRole();
    }

    public User getUserById(Integer id) {
        return userMapper.getUserById(id);
    }

    public int deleteUserById(Integer uid) {
        return userMapper.deleteUserById(uid);
    }

    public int updateUserEnabled(Integer state, Integer uid) {
        return userMapper.updateUserEnabled(state,uid);
    }

    public int updateUserRoles(Integer[] rids, Integer uid) {
        userMapper.deleteUserRolesById(uid);
        return userMapper.updateUserRoles(rids,uid);
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = userMapper.loadUserByUsername(s);
        if (user==null){
            return new User();
        }

        List<Role> roles = roleMapper.getRolesByUid(user.getId());
        user.setRoles(roles);
        return user;
    }

}
