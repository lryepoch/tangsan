package com.vblog.controller;


import com.vblog.config.RespBean;
import com.vblog.service.UserService;
import com.vblog.util.SubjectUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author lryepoch
 * @since 2021-01-13
 */
@Api(description = "用户操作")
@RestController
public class UserController {
    @Autowired
    UserService userService;

    @ApiOperation(value = "获取当前用户名")
    @GetMapping("/currentUserName")
    public String currentUserName() {
        return SubjectUtil.getCurrentUser().getNickname();
    }

    @ApiOperation(value = "获取当前用户ID")
    @GetMapping("/currentUserId")
    public Integer currentUserId() {
        return SubjectUtil.getCurrentUser().getId();
    }

    @ApiOperation(value = "获取当前用户邮箱")
    @GetMapping("/currentUserEmail")
    public String currentUserEmail() {
        return SubjectUtil.getCurrentUser().getEmail();
    }

    @ApiOperation(value = "是否是超级管理员")
    @GetMapping("/isAdmin")
    public Boolean isAdmin() {
        List<GrantedAuthority> authorities = SubjectUtil.getCurrentUser().getAuthorities();
        for (GrantedAuthority authority : authorities) {
            if (authority.getAuthority().contains("超级管理员")) {
                return true;
            }
        }
        return false;
    }

    @ApiOperation(value = "开启用户邮箱评论")
    @RequestMapping(value = "/updateUserEmail", method = RequestMethod.PUT)
    public RespBean updateUserEmail(String email) {
        if (userService.updateUserEmail(email) != 0) {
            return new RespBean("success", "开启成功!");
        }
        return new RespBean("error", "开启失败!");
    }
}


