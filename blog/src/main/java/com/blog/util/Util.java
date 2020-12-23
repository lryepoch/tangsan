package com.blog.util;

import com.blog.bean.User;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * @author lryepoch
 * @date 2020/5/28 10:43
 * @description TODO 保留系统当前的安全上下文细节，其中就包括当前使用系统的用户的信息
 */
public class Util {
    public static User getCurrentUser() {
        User user = (User) SecurityContextHolder.getContext().getAuthentication();
        return user;
    }
}
