package com.ohgiraffers.chap05interceptor;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/*")
public class InterceptorTestController {

    @GetMapping("stopwatch")
    public String handlerMethod() throws InterruptedException {
        System.out.println("핸들러 메소드 호출함...");
        Thread.sleep(1000); // thread를 1초간 멈춘다.
        return "result";
    }
}
