package com.ohgiraffers.chap05interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

/*
* 핸들러 인터셉터 상속받기
* */
@Component
public class StopWatchInterceptor implements HandlerInterceptor {
    private final MenuService menuService;

    public StopWatchInterceptor(MenuService menuService) {
        this.menuService = menuService;
    }
}
