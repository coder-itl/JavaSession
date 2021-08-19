package com.coderitl.controller;

import com.coderitl.entity.Manager;
import com.coderitl.entity.UserInfo;
import com.coderitl.service.UserInfoService;
import com.coderitl.service.impl.UserInfoServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/ShowAllController")
public class ShowAllController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        // 使用 Session 做权限管理
        HttpSession session = request.getSession();
        // TODO: 什么时候该强转数据类型
        Manager mgr = (Manager) session.getAttribute("mgr");
        if (mgr != null) {
            // 处理 userinfo: showall 数据展示
            UserInfoService userInfoService = new UserInfoServiceImpl();
            List<UserInfo> userinfoList = userInfoService.showAll();
            // 通过 request 作用域存储数据
            request.setAttribute("userInfo", userinfoList);
            // 转发数据
            request.getRequestDispatcher("/ShowAllJsp").forward(request, response);
        } else {
            // 没有登录
            response.sendRedirect("/Session_war_exploded/loginmgr.html");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
