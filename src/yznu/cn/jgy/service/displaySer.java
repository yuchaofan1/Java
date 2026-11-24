package yznu.cn.jgy.service;

import com.sun.net.httpserver.HttpServer;
import yznu.cn.jgy.pojo.My_Book;
import yznu.cn.jgy.dao.dbp;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(value = "/displaySer")
public class displaySer extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        this.doPost(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        dbp db = new dbp();
        ArrayList<My_Book> books = db.select();
        if (books != null) {
            request.setAttribute("Books", books);
            RequestDispatcher dispatcher = request.getRequestDispatcher("booklist.jsp");
            dispatcher.forward(request, response);
        }
    }
}