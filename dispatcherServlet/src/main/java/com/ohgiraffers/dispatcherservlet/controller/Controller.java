package com.ohgiraffers.dispatcherservlet.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public interface Controller {
    String handlerRequest(HttpServletRequest request, HttpServletResponse response);

}
