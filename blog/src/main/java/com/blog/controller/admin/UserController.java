package com.blog.controller.admin;

import com.blog.bean.Role;
import com.blog.bean.User;
import com.blog.config.ResultUtil;
import com.blog.config.ResultEnum;
import com.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author lryepoch
 * @date 2020/5/28 18:57
 * @description TODO 超级管理员管理用户权限
 */
@RestController
@RequestMapping("/admin")
public class UserController {
    @Autowired
    UserService userService;

    /**
    * @description 根据昵称查询指定用户
    * @author lryepoch
    * @date 2020/5/29 9:43
    *
    */
    @GetMapping("/user")
    public ResultUtil getUserByNickname(String nickname){
        List<User> users= userService.getUserByNickname(nickname);
        if (users != null) {
            return ResultUtil.success();
        }
        return ResultUtil.fail(ResultEnum.ERR.getCode(), ResultEnum.ERR.getMsg());
    }

    /**
    * @description 查询所有角色，以便于修改用户角色
    * @author lryepoch
    * @date 2020/5/29 9:43
    *
    */
    @GetMapping("/roles")
    public ResultUtil getAllRole(){
        List<Role> roles = userService.getAllRole();
        if (roles != null) {
            return ResultUtil.success();
        }
        return ResultUtil.fail(ResultEnum.ERR.getCode(), ResultEnum.ERR.getMsg());
    }

    /**
    * @description 根据用户id查询指定用户
    * @author lryepoch
    * @date 2020/5/29 9:43
    *
    */
    @GetMapping("/user/{id}")
    public ResultUtil getUserById(@PathVariable Integer id){
        User user = userService.getUserById(id);
        if (user != null) {
            return ResultUtil.success();
        }
        return ResultUtil.fail(ResultEnum.ERR.getCode(), ResultEnum.ERR.getMsg());
    }

    /**
    * @description 根据用户id删除指定用户
    * @author lryepoch
    * @date 2020/5/29 9:44
    *
    */
    @DeleteMapping("/user/{uid}")
    public ResultUtil deleteUserById(@PathVariable Integer uid){
        int result = userService.deleteUserById(uid);
        if (result != 0) {
            return ResultUtil.success();
        }
        return ResultUtil.fail(ResultEnum.ERR.getCode(), ResultEnum.ERR.getMsg());
    }

    /**
    * @description 修改指定用户的状态
    * @author lryepoch
    * @date 2020/5/29 9:44
    *
    */
    @PutMapping("/user/enabled")
    public ResultUtil updateUserEnabled(Integer state, Integer uid){
        int result = userService.updateUserEnabled(state,uid);
        if (result != 0) {
            return ResultUtil.success();
        }
        return ResultUtil.fail(ResultEnum.ERR.getCode(), ResultEnum.ERR.getMsg());
    }

    /**
    * @description 更新用户的所属角色
    * @author lryepoch
    * @date 2020/5/29 9:45
    *
    */
    @PutMapping("/user/role")
    public ResultUtil updateUserRoles(Integer[] rids, Integer uid){
        int result = userService.updateUserRoles(rids,uid);
        if (result != 0) {
            return ResultUtil.success();
        }
        return ResultUtil.fail(ResultEnum.ERR.getCode(), ResultEnum.ERR.getMsg());
    }
}
