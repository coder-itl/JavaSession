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
import java.util.List;

@WebServlet("/showallcontrol")
public class ShowAllUserInfoControl extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 只负责调用业务逻辑
        UserInfoService userInfoService = new UserInfoServiceImpl();
        List<UserInfo> userInfos = userInfoService.showAll();
        // 通过 request 作用域存储数据
        req.setAttribute("userinfo", userInfos);
        // 通过转发，跳转到显示结果的 servlet
        req.getRequestDispatcher("/showalljsp").forward(req, resp);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
