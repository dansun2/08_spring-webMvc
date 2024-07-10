package com.ohgiraffers.dispatcherservlet.handler;

import com.ohgiraffers.dispatcherservlet.controller.Controller;
import io.github.classgraph.ClassGraph;
import io.github.classgraph.ClassInfoList;
import io.github.classgraph.ScanResult;

import java.lang.reflect.InvocationTargetException;

public class HandlerMapping {
    public Controller getController(String url) {
        // Controller를 반환하기 위한 변수를 생성함
        Controller controller = null;
        
        // 전달받은 url과 매핑될 변수를 생성함
        String type = null;

        // 전달된 url이 다음 케이스와 같다면 type에 해당 클래스 이름으로 초기화함
        if(url.equals("/test")){
            type = "TestController";
        }else if(url.equals("/main")){
            type = "MainController";
        }else if(url.equals("/redirect")){
            type = "RedirectController";
        }

        // ""<- 경로에 있는 모든 클래스를 스캔함
        // 현재 패키지경로 하위에 있는 클래스, 메서드, 필드 등을 모두 가져오겠다.
        try(ScanResult scanResult = new ClassGraph().enableAllInfo().acceptPackages("com.ohgiraffers.dispatcherservlet").scan()){
            
            // ""<-클래스의 인터페이스를 상속받은 모든 클래스를 조회하고 classInfos에 저장함
            // 지금은 MainController, RedirectController, TestController가 있다.
            ClassInfoList classInfos = scanResult.getClassesImplementing("com.ohgiraffers.dispatcherservlet.controller.Controller");
            
            // classInfos의 요소를 순회해서 loadClasses로 풀패키지 경로를 읽어옴
            for(Class<?> implClass : classInfos.loadClasses()){
                
                // 각 요소가 순회할 때 요소의 이름이 상위에서 정의한 Type과 일치한다면?
                if(implClass.getName().equals("com.ohgiraffers.dispatcherservlet.controller." + type)){
                    
                    // 해당 클래스의 생성자를 호출하여 인스턴스를 생성함
                    controller = (Controller) implClass.getDeclaredConstructor().newInstance(); // 반환되는게 Object타입이라 (Controller)로 변환해줘야함
                }
            }
            // 없으면 에러가 남
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }

        // Controller를 반환함
        return controller;
    }
}
