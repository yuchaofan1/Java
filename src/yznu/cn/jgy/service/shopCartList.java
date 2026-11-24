package yznu.cn.jgy.service;

import yznu.cn.jgy.dao.cart;
import yznu.cn.jgy.pojo.My_cart;
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

@WebServlet(value = "/shopCartList")
public class shopCartList extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession();
        My_users user = (My_users) session.getAttribute("currentUser");
        cart cart = new cart();
        ArrayList<My_cart> books = cart.select(user.getId());
        request.setAttribute("Books",books);
        RequestDispatcher dispatcher = request.getRequestDispatcher("shoperlist.jsp");
        dispatcher.forward(request, response);
    }
}