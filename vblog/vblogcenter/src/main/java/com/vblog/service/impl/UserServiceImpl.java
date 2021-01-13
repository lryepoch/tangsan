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
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
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
    @Resource
    private UserMapper userMapper;
    @Resource
    private RoleUserService roleUserService;
    @Resource
    RoleMapper roleMapper;

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
    public boolean updateUserEmail(String email) {
        User user = new User();
        user.setId(SubjectUtil.getCurrentUser().getId());
        user.setEmail(email);
        return updateById(user);
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

}
