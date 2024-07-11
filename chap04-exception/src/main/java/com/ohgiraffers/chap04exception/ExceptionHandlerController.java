package com.ohgiraffers.chap04exception;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ExceptionHandlerController {

    @GetMapping("controller-null")
    public String nullPointerExceptionTest(){
        String str = null;

        System.out.println(str.charAt(0)); // str은 null이니까 chatAt(0)을 하면 널포인트 익셉션이 발생함(없는 값을 가져오려고 하니까)
        return "/";
    }

    // 클래스 레벨 익셉션
    @ExceptionHandler(NullPointerException.class) // 이 클래스 내부에서 널포인트 익셉션이 발생하면 내가 여기서 처리하겠다
    public String nullPointerExceptionHandler(NullPointerException exception){
        System.out.println("controller 레벨의 exception 처리");
        return "error/nullpointer";
    }

    // 사용자 정의 익셉션
    @GetMapping("controller-user")
    public String userExceptionTest() throws MemberRegistException {
        boolean check = true;

        if(check){
            throw new MemberRegistException("회원가입이 불가능합니다.");
        }

        return "/";
    }
    @ExceptionHandler(MemberRegistException.class)
    public String userExceptionHandler(Model model, MemberRegistException memberRegistException){
        System.out.println("controller 레벨의 exception 처리");
        model.addAttribute("exception", memberRegistException);
        return "error/memberRegist";
    }
}
