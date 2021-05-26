package com.lryepoch;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@SpringBootApplication
@MapperScan("com.lryepoch.dao")
public class MusicServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(MusicServerApplication.class, args);
    }
}
