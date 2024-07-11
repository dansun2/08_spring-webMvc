package com.ohgiraffers.chap04exception;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(NullPointerException.class)
    public String nullPointerExceptionHandler(NullPointerException exception) {
        System.out.println("global 레벨의 exception 처리");
        return "error/nullpointer";
    }

    @ExceptionHandler(MemberRegistException.class)
    public String userExceptionHandler(Model model, MemberRegistException memberRegistException){
        System.out.println("global 레벨의 exception 처리(memberRegist)");
        model.addAttribute("exception", memberRegistException);
        return "error/memberRegist";
    }

    @ExceptionHandler(Exception.class)
    public String nullPointerExceptionHandler(Exception exception){
        System.out.println("global exception 처리");
        return "error/default";
    }
}
