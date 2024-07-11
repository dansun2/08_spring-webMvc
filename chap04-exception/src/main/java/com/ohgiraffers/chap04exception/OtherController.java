package com.ohgiraffers.chap04exception;

import org.springframework.web.bind.annotation.GetMapping;

public class OtherController {
    @GetMapping("other-controller-null")
    public String otherNullPointerExceptionTest(){
        String str = null;

        System.out.println(str.charAt(0));
        return "/";
    }
}
