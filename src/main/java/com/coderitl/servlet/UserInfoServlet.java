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
public class UserInfoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // servlet 做什么? :=> 1. 设置字符集
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        try {
            // 2. 收参 :=> 主要是从 form 表单获取对应的输入信息
            String username = request.getParameter("username");
            String password = request.getParameter("password");

            // 3. 处理获取的数据信息 调用业务逻辑
            UserInfoService userInfoService = new UserInfoServiceImpl();

            UserInfo userInfo = userInfoService.userLogin(username, password);
            System.out.println(userInfo.toString());

            // 通过 printWriter 输出
            PrintWriter printWriter = response.getWriter();
            if (userInfo != null) {
                // 用户登录成功 就显示数据
                printWriter.println("<h1>登陆成功</h1>");
            } else {
                // 用户登陆失败 失败就进行登录重定向
                printWriter.println("<h1>登陆失败</h1>");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
