package com.vblog.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.util.DigestUtils;

/**
 * @author lryepoch
 * @date 2021/1/13 17:27
 * @description TODO 密码xxx
 */
@Component
@Slf4j
public class MyPasswordEncoder implements PasswordEncoder {
    @Override
    public String encode(CharSequence rawPassword) {
        log.info("进入MyPasswordEncoder->encode，rawPassword：{}", rawPassword);
        return DigestUtils.md5DigestAsHex(rawPassword.toString().getBytes());
    }

    @Override
    public boolean matches(CharSequence rawPassword, String encodedPassword) {
        log.info("进入MyPasswordEncoder->matches, rawPassword：{} - encodedPassword：{}", rawPassword, encodedPassword);
        return encodedPassword.equals(DigestUtils.md5DigestAsHex(rawPassword.toString().getBytes()));
    }
}
