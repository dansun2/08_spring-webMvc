package com.ohgiraffers.chap05interceptor;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfiguration implements WebMvcConfigurer {

    private StopWatchInterceptor stopWatchInterceptor;

    public WebConfiguration(StopWatchInterceptor stopWatchInterceptor) {
        this.stopWatchInterceptor = stopWatchInterceptor;
    }

    @Override // 인터셉터를 등록시켜주는 부분
    public void addInterceptors(InterceptorRegistry registry) {
         registry.addInterceptor(stopWatchInterceptor)
                 .addPathPatterns("/*") // 어떤 요청이 들어왔을때 인터셉터를 동작시키겠느냐
                 .excludePathPatterns("/css/**")
                 .excludePathPatterns("/images/**")
                 .excludePathPatterns("/js/**")
                 .excludePathPatterns("/error");

    }
}
