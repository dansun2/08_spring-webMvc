package com.ohgiraffers.chap02handler;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/first/")
public class FirstController {

    /*
    * Default Request URL 매핑 : 반환 타입이 'void'인 경우, spring은 요청 url을 기반으로
    * 뷰를 해석하려고 하는데 예를 들어 "/example" 이라는 url로 요청이 들어오고 그 해당하는 컨트롤러가
    * 'void'를 반환한다면, spring은 요청 url('/example')을 뷰의 이름으로 간주한다.
    *
    * spring mvc는 RequestToViewNameTranslator 인터페이스를 사용하여 요청 url을 뷰의 이름으로 반환하게 되는데
    * 기본적으로 DefaultRequestToViewNameTranslator가 사용된다. 이 Translator는 요청 경로를 기반으로 뷰 이름을 생성하게 된다.
    * */
    @GetMapping("regist")
    public void regist(){
    }
}
