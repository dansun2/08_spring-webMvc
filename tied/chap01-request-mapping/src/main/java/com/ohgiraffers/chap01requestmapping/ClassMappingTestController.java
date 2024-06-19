package com.ohgiraffers.chap01requestmapping;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/*
* 클래스 레벨에 @RequestMapping 어노테이션 사용이 가능하다.
* 클래스 레벨에 url의 공통 부분을 이용해 설정하고 나면 매번 핸들러 메소드에 url의 중복되는 내용은 작성하지 않아도 된다.
* 이 때 와일드 카드를 이용해서 조금 더 포괄적인 url 패턴을 설정할 수 있다.
* */

@Controller // RestController랑 Controller 차이 잘 모르겠음
@RequestMapping("/orders/*")
public class ClassMappingTestController {

    // class 레벨 매핑
    // @RequestMapping과 비교했을 때, RequestMapping의 method 속성을 RequestMethod.GET으로 설정하는 것과 동일하다.
    @GetMapping("/regist")
    public String registOrder(Model model){
        model.addAttribute("message", "get 방식의 주문 등록용 핸들러 메소드를 호출함");
        // @Controller 사용시
        // view name을 반환해서 전달하고 템플릿 엔진 안에 있는 view resolver에서 그 이름을 읽어서 실제 뷰(ex:html)를 찾아 렌더링함
        // 주로 웹페이지를 반환하는데 사용됨

        // @RestController 사용시
        // JSON이나 XML 데이터 객체를 반환하여 클라이언트 애플리케이션과 통신해야 할 때 사용됨
        // RESTful 웹 서비스를 구현할 때 사용됨. 주로 클라이언트가 데이터를 요청하는경우 반환함(ex:웹 애플리케이션, 모바일 앱)
        // 동적인 페이지 포트는 8080 정적인거는  80포트래 html 형식으로 나오는건 동적인 페이지

        return "mappingResult";
    }
    @PostMapping("/regist")
    public String registOrderPost(Model model){
        model.addAttribute("message","post 방식의 주문 등록용 핸들러 메소드를 호출함");

        return "mappingResult";
    }

    // 여러 개의 패턴 매핑
    // value 속성에 중괄호를 이용해 매핑할 url을 나열한다.
    @RequestMapping(value = {"modify", "delete"}, method = RequestMethod.POST) // 원래는 폼 요청으로 할 수 있는데 포스트맨으로 가능
    public String modifyAndDelete(Model model){
        model.addAttribute("message","post 방식의 주문 정보 수정과 주문 정보 삭제 공통 처리용 핸들러 메소드 호출함");
        return "mappingResult";
    }

    // RESTful API를 효과적으로 설계하기 위한 HTTP 메소드들에 대한 간략한 요약
    // GET : 데이터를 조회함. 서버의 상태나 데이터를 변경하지 않음.
    // POST : 데이터를 전송하여 새로운 리소스를 생성하거나 서버에서 처리를 요청함.
    // PUT : 리소스를 생성하거나 전체를 업데이트함. 동일한 요청을 반복해도 동일한 결과를 보장함.
    // DELETE : 리소스를 삭제함. 동일한 요청을 반복해도 동일한 결과를 보장함.


    /*
    * path variable
    * @PathVariable 어노테이션을 이용해 요청 path로부터 변수를 받아올 수 있다.
    * path variable로 전달되는 {변수명} 값은 반드시 매개변수명과 동일해야 한다.
    * 만약 동일하지 않으면 @PathVariable("이름")을 설정해주어야 한다.
    * 이는 Rest형 웹 서비스를 설계할 때 유용하게 사용된다.
    *
    * */

    @GetMapping("/detail/{orderNo}")
    public String selectOrderDetail( Model model,@PathVariable("orderNo") int orderNo ) {
        model.addAttribute("message", orderNo + "번 주문 상세 내용 조회용 핸들러");
        return "mappingResult";
    }

    @GetMapping("/")
    public String registOrders(Model model, @RequestParam String test, @RequestParam String value){
//      /orders?test=hi~~&value=test
        model.addAttribute("message", test + " : " + value);
        return "mappingResult";
    }

    /*
    * 그 외의 다른 요청
    * @RequestMapping 어노테이션에 아무런 url을 설정하지 않으면 요청 처리에 대한 핸들러 메소드가
    * 준비되지 않았을 때 해당 메소드를 호출한다.
    * */
    @RequestMapping
    public String OtherRequest(Model model){
        model.addAttribute("message", "order 요청이긴 하지만 다른 기능 준비 안함");
        return "orderError";
    }
}
