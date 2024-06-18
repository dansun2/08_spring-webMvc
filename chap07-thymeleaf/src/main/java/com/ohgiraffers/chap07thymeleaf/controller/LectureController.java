package com.ohgiraffers.chap07thymeleaf.controller;

import com.ohgiraffers.chap07thymeleaf.model.dto.MemberDTO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller

//lecture라는 요청이 들어오면 이 밑에 클래스에서 찾겠다.
@RequestMapping("lecture")
public class LectureController {

    // get 방식의 요청이 들어오면 expression이 있는지 찾고 있으면 밑에 return 실행
    @RequestMapping(value = "expression", method = RequestMethod.GET) // 축약하면 @GetMapping("expression")
    public ModelAndView expression(ModelAndView mv){
        mv.addObject("member", new MemberDTO("홍길동",20,'남',"서울시 서초구"));
        mv.addObject("hello", "hello!<h3>Thymeleaf</h3>");
        mv.setViewName("lecture/expression");
        return mv;
    }
    @GetMapping("conditional")
    public ModelAndView conditional(ModelAndView mv){

        mv.setViewName("/lecture/conditional");
        return mv;
    }


    @GetMapping("etc")
    public void etc(){}


}
