package com.coderitl.servlet.controller;

import com.coderitl.entity.Manager;
import com.coderitl.service.ManagerService;
import com.coderitl.service.impl.ManagerServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/mangerLogin")
public class LoginManagerController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1. 处理乱码
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        // 2. 收参
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        // 调用业务逻辑
        ManagerService managerService = new ManagerServiceImpl();
        Manager mgr = managerService.login(username, password);
        if (mgr != null) {
            // 管理员存在 创建 Session
            HttpSession session = req.getSession();
            session.setAttribute("mgr", mgr);
            // 重定向到显示所有数据页面
            resp.sendRedirect("/JavaServlet_war_exploded/managershowall");
        } else {
            // 重定向到重新登录页面
            resp.sendRedirect("/JavaServlet_war_exploded/managerLogin.html");
        }

    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
