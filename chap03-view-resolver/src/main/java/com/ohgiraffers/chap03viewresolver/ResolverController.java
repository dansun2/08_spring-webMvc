package com.ohgiraffers.chap03viewresolver;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/*")
public class ResolverController  {
    
    @GetMapping("string")
    public String stringReturning(Model model){
        model.addAttribute("forwardMessage", "문자열로 뷰 이름 반환함..");
        
        /*
        * 문자열로 뷰 이름을 반환한다는 것은 반환 후
        * ThymeleafViewRewolver에게 resources/templates/를 prefix로 .html을 suffix로 하여
        * resources/templates/result.html 파일로 응답 뷰를 설정하라는 의미가 된다.
         */
        return "result";
    }

    @GetMapping("string-redirect")
    public String StringRedirect(){
        return "redirect:/";
    }
    
}
