package com.ohgiraffers.section01.xmlconfig;

import com.ohgiraffers.common.MemberDTO;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Application01 {

    public static void main(String[] args){
        // xml방식으로 정의되어 있는 설정파일을 읽어와서 ApplicationContext에 집어넣겠다(설정한 bean들이 담김)
        ApplicationContext context = new GenericXmlApplicationContext("section01/xmlconfig/spring-context.xml");

        // 1. bean의 id를 이용해서 bean을 가져오는 방법
        // MemberDTO member = (MemberDTO) context.getBean("member");

        // 2. bean의 클래스 메타 정보를 전달하여 가져오는 방법
        // MemberDTO member = context.getBean(MemberDTO.class);

        // 3. bean의 id와 클래스 메타 정보를 전달하여 가져오는 방법 인터페이스 클래스때 많이 사용함...
        MemberDTO member = context.getBean("member", MemberDTO.class);
        System.out.println(member);
    }
}
