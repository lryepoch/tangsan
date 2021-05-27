package com.lryepoch.config;

import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.unit.DataSize;
import org.springframework.util.unit.DataUnit;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.servlet.MultipartConfigElement;

/**
 * @author lryepoch
 * @date 2021/5/27 19:07
 * @description TODO
 */
@Configuration
public class MyPicConfig implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //用户头像
        registry.addResourceHandler("/avatorImages/**")
                .addResourceLocations("file:/Users/hongweiyin/Documents/github-workspace/music-website/music-server/avatorImages/");

        //歌曲以及图片
        registry.addResourceHandler("/img/songPic/**")
                .addResourceLocations("file:/Users/hongweiyin/Documents/github-workspace/music-website/music-server/img/songPic/");
        registry.addResourceHandler("/song/**")
                .addResourceLocations("file:/Users/hongweiyin/Documents/github-workspace/music-website/music-server/song/");

    }

    @Bean
    public MultipartConfigElement multipartConfigElement() {
        MultipartConfigFactory factory = new MultipartConfigFactory();
        //文件最大10M,DataUnit提供5中类型B,KB,MB,GB,TB
        factory.setMaxFileSize(DataSize.of(10, DataUnit.MEGABYTES));
        /// 设置总上传数据总大小10M
        factory.setMaxRequestSize(DataSize.of(10, DataUnit.MEGABYTES));
        return factory.createMultipartConfig();
    }
}
