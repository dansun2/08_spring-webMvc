package com.ohgiraffers.dispatcherservlet;

import java.io.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(value = "/")
public class HelloServlet extends HttpServlet {

    @Override // 요청이 들어왔을 때 가장 먼저 실행되는 메서드. 요청이 들어왔을때 빈이나 소스를 주입해주는 역할
    public void init() throws ServletException {
        super.init();
    }

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
//        super.service(req, res); // 스코프 체인상으로 다음 체인에 넘김..(필터레이어랑 인터셉터?공부해)

        // 원하는 속성들을 원하는대로 꺼내쓰기 위해서 형변환함
        HttpServletRequest httpRequest = (HttpServletRequest) req;
        HttpServletResponse httpResponse = (HttpServletResponse) res;

        String method = httpRequest.getMethod();

        if("GET".equals(method)){
            doGet(httpRequest, httpResponse);
        }else if("POST".equals(method)){
            doPost(httpRequest, httpResponse);
        }else if("PUT".equals(method)){
            doPut(httpRequest, httpResponse);
        }else if("DELETE".equals(method)){
            doDelete(httpRequest, httpResponse);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp); // view resolver야 니가 요청을 담아서 다음으로 보내~난 할 일 끝났어
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPut(req, resp);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doDelete(req, resp);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response){
        String path = request.getRequestURI().substring(request.getContextPath().length()); // **잘모르겠음. 사용자가 요청한 url을 가져오겠다. 그리고 기본경로를 자르고 뒤에거만 가져온다?
    }
}