package com.coderitl.servlet.controller;

import com.coderitl.entity.Manager;
import com.coderitl.entity.UserInfo;
import com.coderitl.service.UserInfoService;
import com.coderitl.service.impl.UserInfoServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/managershowall")
public class ManagerShowAll extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 使用 Session 做权限管理
        HttpSession session = req.getSession();
        // TODO: 什么时候该强转数据类型
        Manager mgr = (Manager) session.getAttribute("mgr");
        if (mgr != null) {
            // 只负责调用业务逻辑
            UserInfoService userInfoService = new UserInfoServiceImpl();
            List<UserInfo> userInfos = userInfoService.showAll();
            // 通过 request 作用域存储数据
            req.setAttribute("userinfo", userInfos);
            // 通过转发，跳转到显示结果的 servlet
            req.getRequestDispatcher("/showalljsp").forward(req, resp);
        } else {
            resp.sendRedirect("/JavaServlet_war_exploded/managerLogin.html");
        }


    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
