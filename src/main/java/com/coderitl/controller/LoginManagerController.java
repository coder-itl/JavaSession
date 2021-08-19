package com.coderitl.controller;

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

@WebServlet("/loginManager")
public class LoginManagerController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
// 1. 处理乱码
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");

        // 2. 收参
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        // 3. 调用业务逻辑
        ManagerService managerService = new ManagerServiceImpl();
        Manager mgr = managerService.login(username, password);

        // 4. 处理结果
        if (mgr != null) {
            // 登陆成功 将管理员信息存储在 Session
            HttpSession session = req.getSession();
            // 存储登录成功的 mgr
            session.setAttribute("mgr", mgr);
            // 跳转目标方式
            resp.sendRedirect("/Session_war_exploded/ShowAllController");
        } else {
            resp.sendRedirect("/Session_war_exploded/loginmgr.html");
        }
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
