package yznu.cn.jgy.service;

import com.sun.jdi.Value;
import yznu.cn.jgy.dao.dbpindent;
import yznu.cn.jgy.pojo.My_order;
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
@WebServlet(value = "/MyOrder")
public class MyOrder extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        HttpSession session=request.getSession();
        My_users user=(My_users)session.getAttribute("currentUser");

        dbpindent dbind=new dbpindent();
        ArrayList<My_order> indents =dbind.select( user.getId());
        request.setAttribute("indents", indents);
        RequestDispatcher dispatcher=request.getRequestDispatcher("MyOrder.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       doPost(req, resp);
    }
}
