package com.ohgiraffers.dispatcherservlet.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class RedirectController implements Controller{
    @Override
    public String handlerRequest(HttpServletRequest request, HttpServletResponse response) {
        return "redirect:main";
    }
}
