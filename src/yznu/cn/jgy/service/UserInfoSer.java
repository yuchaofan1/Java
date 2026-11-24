package yznu.cn.jgy.service;

import yznu.cn.jgy.dao.Interface.IUserInfo;
import yznu.cn.jgy.dao.UserInfo;
import yznu.cn.jgy.pojo.My_users;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
@WebServlet("/UserInfoSer")
public class UserInfoSer extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        HttpSession session=request.getSession();
        My_users user=(My_users)session.getAttribute("currentUser");
//        session.setAttribute("currentUser",);
        UserInfo userinfo=new UserInfo();
        ArrayList<My_users> users= userinfo.select(user.getId());
        request.setAttribute("users",users);
        RequestDispatcher dispatcher=request.getRequestDispatcher("grxx.jsp");
        dispatcher.forward(request,response);
    }
}
