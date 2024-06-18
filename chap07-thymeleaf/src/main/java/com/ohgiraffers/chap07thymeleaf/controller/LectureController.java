package com.ohgiraffers.chap07thymeleaf.controller;

import com.ohgiraffers.chap07thymeleaf.model.dto.MemberDTO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        mv.addObject("num", 1);
        mv.addObject("str", "사과");
        List<MemberDTO> memberDTOList = new ArrayList<>();
        memberDTOList.add(new MemberDTO("홍길동", 10, '남', "서초구"));
        memberDTOList.add(new MemberDTO("홍길순", 20, '여', "서초구"));
        memberDTOList.add(new MemberDTO("홍동길", 24, '남', "강남구"));
        memberDTOList.add(new MemberDTO("홍도윤", 32, '여', "노원구"));
        memberDTOList.add(new MemberDTO("홍묵", 276, '남', "관악구"));
        memberDTOList.add(new MemberDTO("홍보고", 21, '남', "중구"));
        mv.addObject("memberList", memberDTOList);



        mv.setViewName("/lecture/conditional");
        return mv;
    }


    @GetMapping("etc")
    public void etc(){}


}
