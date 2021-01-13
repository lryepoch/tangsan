package com.vblog;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author lryepoch
 * @date 2020/5/27 15:18
 * @description TODO 启动类
 */
@SpringBootApplication
@MapperScan("com.vblog.dao")
public class VblogApplication {
    public static void main(String[] args) {
        SpringApplication.run(VblogApplication.class, args);
    }
}
