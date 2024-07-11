package com.ohgiraffers.chap05interceptor;

import jakarta.annotation.Nullable;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/*
* 핸들러 인터셉터 상속받기
* */
@Component
public class StopWatchInterceptor implements HandlerInterceptor {
    private final MenuService menuService;

    public StopWatchInterceptor(MenuService menuService) {
        this.menuService = menuService;
    }

    @Override // 전처리를 위한 핸들러 filter -> dispatcherservlet -> interceptor -> controller
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("preHandle 동작함");
        long startTime = System.currentTimeMillis();
        request.setAttribute("startTime", startTime);

        return true;
    }

    @Override // 후처리를 위한 핸들러 filter -> controller -> interceptor ->dispatcherservlet
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                           @Nullable ModelAndView modelAndView) throws Exception {
        System.out.println("postHandle 호출함");
        long startTime = (long) request.getAttribute("startTime");
        request.removeAttribute("startTime"); // 윗줄에서 시간을 꺼내서 담았으니까 제거
        long endTime = System.currentTimeMillis(); // currentTimeMillis는 현재 시간을 초단위로 분석함
        modelAndView.addObject("interval", endTime - startTime); // 이 작업을 하는데 걸린 최종적인 시간이 얼마인지 계산
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex) throws Exception {
        System.out.println("afterCompletion 호출함");

        menuService.method();
    }
}
