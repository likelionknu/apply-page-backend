package com.springboot.applypage.config;

import com.springboot.applypage.interceptor.Interceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class InterceptorConfiguration implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new Interceptor())
                .addPathPatterns("/*"); // 해당 경로에 접근하기 전에 인터셉터가 가로챈다.
                //.excludePathPatterns("/boards"); // 해당 경로는 인터셉터가 가로채지 않는다.
    }
}