package yznu.cn.jgy.service;

import yznu.cn.jgy.dao.UserInfo;


import javax.servlet.RequestDispatcher;

import javax.servlet.ServletException;


import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
@WebServlet(value = "/loginSer")
public class loginSer extends HttpServlet  {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession();
        String UserName = null;
        String PassWord = null;
        UserInfo userinfo = new UserInfo();
        UserName = request.getParameter("UserName");
        PassWord = request.getParameter("PassWord");
       /* UserName = new String(request.getParameter("UserName").getBytes("iso_8859-1"));
        PassWord = new String(request.getParameter("PassWord").getBytes("iso-8859-1"));*/
        if (UserName.length() != 0 && PassWord.length() != 0) {
            if (userinfo.getUser(UserName) == null) {
                response.sendRedirect("register.html");
            } else if (userinfo.getUser(UserName, PassWord) == null)
                response.sendRedirect("fail.jsp?i=1");


            else {
                session.setAttribute("currentUser", userinfo.getUser(UserName, PassWord));
                RequestDispatcher dispatcher = request.getRequestDispatcher("displaySer");
                dispatcher.forward(request, response);
            }
        } else
            response.sendRedirect("fail.jsp?i=2");
    }
}