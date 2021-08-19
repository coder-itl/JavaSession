package com.coderitl.jsp;

import com.coderitl.entity.UserInfo;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "ShowAllJsp", value = "/ShowAllJsp")
public class ShowAllJsp extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        List<UserInfo> userinfoList = (List) request.getAttribute("userInfo");
        PrintWriter printWriter = response.getWriter();
        if (userinfoList != null) {
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


            for (UserInfo userInfo : userinfoList) {
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
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
