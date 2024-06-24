package com.ohgiraffers.chap02handler;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

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

    /*
    * 1. WebRequest로 요청 파라미터 전달 받기
    *   파라미터 선언부에 WebRequest 타입을 선언하면 해당 메소드 호출 시 인자로 값을 전달해준다.
    *   핸들러 메소드 매개변수로 HttpServletRequest HttpServletResponse도 사용 가능하다.
    *   상위 타입인 ServletRequest ServletResponse도 사용 가능하다.
    *   WebRequest는 HttpServletRequest의 요청 정보를 거의 대부분 그대로 가지고 있는 API로 Servlet에 종속적이지 않다.
    *   HttpServlet은 Servlet API의 일부이고,
    *   WebRequest는 spring의 일부이기 때문에 spring 기반의 프로젝트에서 더 자주 사용된다.
    * */

    @PostMapping("regist")
    public ModelAndView regist(ModelAndView modelAndView, WebRequest webRequest) {
        String name = webRequest.getParameter("name");
        int price = Integer.parseInt(webRequest.getParameter("price"));
        int category = Integer.parseInt(webRequest.getParameter("category"));

        String message = name + "을 신규 메뉴 목록의 " + category + "번 카테고리에 " + price + "원으로 등록하였습니다.";
        System.out.println(message);

        modelAndView.addObject("message", message);
        modelAndView.addObject("/first/messagePrinter");
        return modelAndView;
    }
}
