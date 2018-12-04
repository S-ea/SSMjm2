package com.zhengguan.SSMjm.commutil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "TestCORSServlet",value = "/pdt")
public class TestCORSServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setCharacterEncoding("UTF-8");
        response.setHeader("content-type", "text/html;charset=UTF-8");
        response.addHeader("Access-Control-Allow-Origin", "http://127.0.0.1:8020");
        response.addHeader("Access-Control-Allow-Methods", "GET, HEAD, POST, TRACE, OPTIONS,PUT,DELETE");
        response.addHeader("Access-Control-Allow-Headers", "Origin,X-Requested-With,Content-Type,Accept");
        response.addHeader("Access-Control-Allow-Credentials", "true");
        response.getWriter().write("{\"name\":\"Book\",\"sex\":\"男\"}");
    }

    @Override
    protected void doOptions(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
