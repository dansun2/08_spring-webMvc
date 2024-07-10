package com.ohgiraffers.dispatcherservlet.handler;

import com.ohgiraffers.dispatcherservlet.controller.Controller;

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
    }
}
