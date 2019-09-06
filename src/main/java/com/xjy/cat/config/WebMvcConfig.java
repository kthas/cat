package com.xjy.cat.config;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.io.File;

/**
 * 设置静态资源访问路径，存储用户头像，帖子图片等非常驻静态资源
 *
 */
@Configuration
@PropertySource("classpath:constant.properties")
public class WebMvcConfig implements WebMvcConfigurer {

    @Value("${properties.uploadPath}")
    private String uploadPath;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/images/**").addResourceLocations("file:"+uploadPath+ File.separator);
    }
}
