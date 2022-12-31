package com.renkaen.cat_hospital;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
@Configuration//解决跨域问题
public class CorsConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")  //设置所有的请求可以进行跨域
                .allowedOrigins("http://localhost:3000")  //允许跨域的ip
                .allowedMethods("*")  //请求的方法 可以不设置 有默认的
                .allowedHeaders("*"); //请求头 可以不设置 有默认的
    }
}
