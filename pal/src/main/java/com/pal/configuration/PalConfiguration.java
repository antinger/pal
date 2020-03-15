package com.pal.configuration;

import javax.servlet.MultipartConfigElement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.pal.interceptor.LoginRequiredInterceptor;
import com.pal.interceptor.PassportInterceptor;

@Configuration
public class PalConfiguration implements WebMvcConfigurer {
	
	@Autowired
	LoginRequiredInterceptor loginRequiredInterceptor;
	
	@Autowired
	PassportInterceptor passportInterceptor;
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(passportInterceptor).addPathPatterns("/user/*/");
		registry.addInterceptor(loginRequiredInterceptor).addPathPatterns("/user/*/");
		WebMvcConfigurer.super.addInterceptors(registry);
	}
	
	//配置图片上传功能
	@Bean
    public MultipartConfigElement multipartConfigElement() {
        MultipartConfigFactory factory = new MultipartConfigFactory();
        return factory.createMultipartConfig();
    }
	
}
