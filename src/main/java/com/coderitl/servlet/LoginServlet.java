package com.coderitl.servlet;

import com.coderitl.entity.UserInfo;
import com.coderitl.service.UserInfoService;
import com.coderitl.service.impl.UserInfoServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");
        try {
            // 1. 收参
            String username = req.getParameter("username");
            String password = req.getParameter("password");
            // 2. 调用业务逻辑
            UserInfoService userInfoService = new UserInfoServiceImpl();
            UserInfo userInfo = userInfoService.userLogin(username, password);
            PrintWriter printWriter = resp.getWriter();
            // 3. 处理结果
            if (userInfo != null) {
                // 响应给客户端一个正确结果的页面 显示登录成功
                printWriter.println("<h1>登录成功</h1>");
                printWriter.println("<h1>登录成功</h1>");
                printWriter.println("<h1>登录成功</h1>");
            } else {
                // 给客户端响应一个失败的页面 显示登录失败
                printWriter.println("<h1>登录失败</h1>");
                printWriter.println("<h1>登录失败</h1>");
                printWriter.println("<h1>登录失败</h1>");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
