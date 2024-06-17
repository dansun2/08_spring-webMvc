package com.ohgiraffers.chap03viewresolver;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {


    // String 일때는 view 네임을 찾고
    @RequestMapping(value = {"/"})
    public String main(){
        return "main1";
    }

    /*
    * RequestToViewNameTranslator(interface)->얘를 구현한 구현체가 있다.=>템플릿엔진에서.
    * spring에서 반환 타입이 void인 경우 요청 url을 기반으로 뷰를 해석하려고 하는데
    * 이 때, RequestToViewNameTranslator를 사용하여 url을 뷰의 이름으로 변환한다.
    * */

    // void일 경우는 url에 맞는 페이지가 열린다.
    @RequestMapping(value = "/main1")
    public void mainPage(){}
}
