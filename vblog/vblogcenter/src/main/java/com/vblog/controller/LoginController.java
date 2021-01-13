package com.vblog.controller;

import com.vblog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lryepoch
 * @date 2021/1/13 12:37
 * @description TODO
 */
@RestController
public class LoginController {
    @Autowired
    UserService userService;
}
