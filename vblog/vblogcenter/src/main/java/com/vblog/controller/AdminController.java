package com.vblog.controller;

import com.vblog.config.RespBean;
import com.vblog.entity.Article;
import com.vblog.entity.Role;
import com.vblog.entity.User;
import com.vblog.service.ArticleService;
import com.vblog.service.RoleService;
import com.vblog.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author lryepoch
 * @date 2021/1/13 14:06
 * @description TODO
 */
@Api(description = "超级管理员专属Controller")
@RestController
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    ArticleService articleService;
    @Autowired
    UserService userService;
    @Autowired
    RoleService roleService;

    @ApiOperation(value = "????????")
    @RequestMapping(value = "/article/all", method = RequestMethod.GET)
    public Map<String, Object> getArticleByStateByAdmin(@RequestParam(value = "page", defaultValue = "1") Integer page,
                                                        @RequestParam(value = "count", defaultValue = "5") Integer count,
                                                        String keywords) {
        //0表示草稿箱，1表示已发表，2表示已删除
        List<Article> articles = articleService.getArticleByState(-2, page, count, keywords);
        Map<String, Object> map = new HashMap<>();
        map.put("articles", articles);
        map.put("totalCount", articleService.getArticleCountByState(1, null, keywords));
        return map;
    }

    @ApiOperation(value = "删除博客")
    @RequestMapping(value = "/article/dustbin", method = RequestMethod.PUT)
    public RespBean updateArticleState(Integer[] aids, Integer state) {
        if (articleService.updateArticleState(aids, state) == aids.length) {
            return new RespBean("success", "删除成功!");
        }
        return new RespBean("error", "删除失败!");
    }

    @ApiOperation(value = "根据昵称查询用户详细信息，包括拥有的角色")
    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public List<User> getUserByNickname(String nickname) {
        return userService.getUserByNickname(nickname);
    }

    @ApiOperation(value = "根据id查询用户详细信息，包括拥有的角色")
    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    public User getUserById(@PathVariable Integer id) {
        return userService.getUserById(id);
    }

    @ApiOperation(value = "查询所有角色")
    @RequestMapping(value = "/roles", method = RequestMethod.GET)
    public List<Role> getAllRole() {
        return roleService.list();
    }

    @ApiOperation(value = "更新用户状态")
    @RequestMapping(value = "/user/enabled", method = RequestMethod.PUT)
    public RespBean updateUserEnabled(Boolean enabled, Integer uid) {
        if (userService.updateUserEnabled(enabled, uid)) {
            return new RespBean("success", "更新成功!");
        } else {
            return new RespBean("error", "更新失败!");
        }
    }

    @ApiOperation(value = "根据id删除用户")
    @RequestMapping(value = "/user/{uid}", method = RequestMethod.DELETE)
    public RespBean deleteUserById(@PathVariable Integer uid) {
        if (userService.deleteUserById(uid) == 1) {
            return new RespBean("success", "删除成功!");
        } else {
            return new RespBean("error", "删除失败!");
        }
    }

    @ApiOperation(value = "更新用户角色")
    @RequestMapping(value = "/user/role", method = RequestMethod.PUT)
    public RespBean updateUserRoles(Integer[] rids, Integer id) {
        if (userService.updateUserRoles(rids, id)) {
            return new RespBean("success", "更新成功!");
        } else {
            return new RespBean("error", "更新失败!");
        }
    }
}
