package com.imooc.minipro;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
//@MapperScan("com.imooc.minipro.dao")
public class  MiniproApplication {

    public static void main(String[] args) {
        SpringApplication.run(MiniproApplication.class, args);
    }

}
