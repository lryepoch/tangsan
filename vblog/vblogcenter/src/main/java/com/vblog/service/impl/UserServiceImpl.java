package com.vblog.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.vblog.dao.RoleMapper;
import com.vblog.entity.Role;
import com.vblog.entity.RoleUser;
import com.vblog.entity.User;
import com.vblog.dao.UserMapper;
import com.vblog.service.RoleUserService;
import com.vblog.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.vblog.util.SubjectUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author lryepoch
 * @since 2021-01-13
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService, UserDetailsService {
    @Autowired
    UserMapper userMapper;
    @Autowired
    RoleUserService roleUserService;
    @Autowired
    RoleMapper roleMapper;
    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userMapper.loadUserByUsername(username);
        if (user == null) {
            //避免返回null，这里返回一个不含有任何值的User对象，在后期的密码比对过程中一样会验证失败
            return new User();
        }
        //查询用户的角色信息，并返回存入user中
        List<Role> roles = roleMapper.getRolesByUid(user.getId());
        user.setRoles(roles);
        return user;
    }


    @Override
    public int updateUserEmail(String email) {
        return userMapper.updateStateById(email, SubjectUtil.getCurrentUser().getId());
    }

    @Override
    public List<User> getUserByNickname(String nickname) {
        return userMapper.getUserByNickname(nickname);
    }

    @Override
    public User getUserById(Integer id) {
        return userMapper.getUserById(id);
    }

    @Override
    public boolean updateUserEnabled(Boolean enabled, Integer uid) {
        User user = new User();
        user.setId(uid);
        user.setEnabled(enabled);
        return updateById(user);
    }

    @Override
    public int deleteUserById(Integer uid) {
        return userMapper.deleteById(uid);
    }

    @Override
    public boolean updateUserRoles(Integer[] rids, Integer id) {
        QueryWrapper<RoleUser> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(RoleUser::getUId, id);
        roleUserService.remove(queryWrapper);

        RoleUser roleUser;
        List<RoleUser> list = new ArrayList<>();
        for (Integer rid : rids) {
            roleUser = new RoleUser();
            roleUser.setRId(rid);
            roleUser.setUId(id);
            list.add(roleUser);
        }
        return roleUserService.saveBatch(list);
    }

    /**
     * 0表示成功
     * 1表示用户名重复
     * 2表示失败
     */
    @Override
    public int reg(User user) {
        User loadUserByUsername = userMapper.loadUserByUsername(user.getUsername());
        if (loadUserByUsername != null) {
            return 1;
        }
        //插入用户，插入之前先对密码进行加密
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        //用户可用
        user.setEnabled(true);
        int result = userMapper.reg(user);
        //配置用户的角色，默认都是普通用户
        String[] roles = new String[]{"2"};
        int i = roleMapper.addRoles(roles, user.getId());
        boolean flag = i == roles.length && result == 1;
        if (flag) {
            return 0;
        } else {
            return 2;
        }
    }

}
