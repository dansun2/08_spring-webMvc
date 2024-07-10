package com.ohgiraffers.dispatcherservlet.handler;

import com.ohgiraffers.dispatcherservlet.controller.Controller;
import io.github.classgraph.ClassGraph;
import io.github.classgraph.ClassInfoList;
import io.github.classgraph.ScanResult;

import java.lang.reflect.InvocationTargetException;

public class HandlerMapping {
    public Controller getController(String url) {
        Object controller = null;
        String type = null;

        if(url.equals("/test")){
            type = "TestController";
        }else if(url.equals("/main")){
            type = "MainController";
        }else if(url.equals("/redirect")){
            type = "RedirectController";
        }

        // 현재 패키지경로 하위에 있는 클래스, 메서드, 필드 등을 모두 가져오겠다.
        try(ScanResult scanResult = new ClassGraph().enableAllInfo().acceptPackages("com.ohgiraffers.dispatcherservlet").scan()){
            // 얘를 구현한 구현체의 목록들(상속받는 애들)을 classInfos로 받아오겠다.
            ClassInfoList classInfos = scanResult.getClassesImplementing("com.ohgiraffers.dispatcherservlet.controller.Controller");
            for(Class<?> implClass : classInfos.loadClasses()){
                if(implClass.getName().equals("com.ohgiraffers.dispatcherservlet.controller." + type)){
                    controller = implClass.getDeclaredConstructor().newInstance();

                }
            }
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    }
}
