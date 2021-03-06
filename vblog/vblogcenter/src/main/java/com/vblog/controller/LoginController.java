package com.vblog.controller;


import com.vblog.config.RespBean;
import com.vblog.entity.User;
import com.vblog.service.UserService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Api(description = "登录操作")
@RestController
@Slf4j
public class LoginController {
    @Autowired
    UserService userService;

    @RequestMapping("/login_error")
    public RespBean loginError() {
        log.info("进入LoginController->loginError()……");
        return new RespBean("error", "登录失败!");
    }

    @RequestMapping("/login_success")
    public RespBean loginSuccess() {
        log.info("进入LoginController->loginSuccess()……");
        return new RespBean("success", "登录成功!");
    }

    /**
     * 如果自动跳转到这个页面，说明用户未登录，返回相应的提示即可
     * <p>
     * 如果要支持表单登录，可以在这个方法中判断请求的类型，进而决定返回JSON还是HTML页面
     *
     * @return
     */
    @RequestMapping("/login_page")
    public RespBean loginPage() {
        log.info("进入LoginController->loginPage()……");
        return new RespBean("error", "尚未登录，请登录!");
    }

    /**
     * @description 用户注册
     * @author      lryepoch
     * @date        2020/5/5 23:16
     */
    @PostMapping("/reg")
    public RespBean reg(User user) {
        log.info("进入LoginController->reg()……");
        int result = userService.reg(user);
        if (result == 0) {
            return new RespBean("success", "注册成功!");
        } else if (result == 1) {
            return new RespBean("error", "用户名重复，注册失败!");
        } else {
            return new RespBean("error", "注册失败!");
        }
    }
}
