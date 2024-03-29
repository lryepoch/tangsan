package com.lryepoch.controller;


import com.alibaba.fastjson.JSONObject;
import com.lryepoch.service.AdminService;
import com.lryepoch.utils.Consts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * <p>
 * 管理员控制器
 * </p>
 *
 * @author lryepoch
 * @since 2021-05-24
 */
@RestController
public class AdminController {
    @Autowired
    private AdminService adminService;

    /**
    * 判断是否登录成功
    */
    @PostMapping(value = "/admin/login/status")
    public Object loginStatus(HttpServletRequest request, HttpSession session) {
        JSONObject jsonObject = new JSONObject();
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        boolean flag = adminService.verifyPassword(name, password);
        if (flag) {
            jsonObject.put(Consts.CODE, 1);
            jsonObject.put(Consts.MSG, "登录成功");
            session.setAttribute(Consts.NAME, name);
            return jsonObject;
        }
        jsonObject.put(Consts.CODE, 0);
        jsonObject.put(Consts.MSG, "用户名或者密码错误");
        return jsonObject;
    }

}

