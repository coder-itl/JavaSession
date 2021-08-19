package com.coderitl.servlet;

import com.coderitl.entity.UserInfo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/showalljsp")
public class ShowAllUserInfoJsp extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        // 获取
        List<UserInfo> userInfos = (List) req.getAttribute("userinfo");
        PrintWriter printWriter = resp.getWriter();
        if (userInfos != null) {
            printWriter.println("<html>");
            printWriter.println("<head>");
            printWriter.println("<meta charset='UTF-8'>");
            printWriter.println("<title>查询所有</title>");
            printWriter.println("</head>");

            printWriter.println("<body>");
            printWriter.println("<table border='1'>");
            printWriter.println("<tr>");
            printWriter.println("<td>id </td>");
            printWriter.println("<td> username</td>");
            printWriter.println("<td> password </td>");
            printWriter.println("</tr>");


            for (UserInfo userInfo : userInfos) {
                printWriter.println("<tr>");
                printWriter.println("<td>" + userInfo.getId() + "</td>");
                printWriter.println("<td>" + userInfo.getUsername() + "</td>");
                printWriter.println("<td>" + userInfo.getPassword() + "</td>");
                printWriter.println("</tr>");
            }


            printWriter.println("</table>");
            printWriter.println("</body>");
            printWriter.println("</html>");
        } else {
            printWriter.println("<h1>没有用户信息</h1>");
        }
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
