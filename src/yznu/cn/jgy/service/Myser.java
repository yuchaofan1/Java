package yznu.cn.jgy.service;


import yznu.cn.jgy.dao.UserInfo;
import yznu.cn.jgy.dao.cart;
import yznu.cn.jgy.dao.dbp;
import yznu.cn.jgy.dao.dbpindent;
import yznu.cn.jgy.pojo.My_Book;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
@WebServlet(value = "/Myser")

public class Myser extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String status = request.getParameter("status");
        // System. out. println("status="+status);
        dbp db = new dbp();
        cart cart = new cart();
        //根据ID查询某本图片的详细信息
        if (status.equals("select")) {
            int Id = Integer.parseInt(request.getParameter("Id"));
            System.out.println("---------------------------------");
            System.out.println(request.getParameter("Id"));
            ArrayList<My_Book>Books=db.select(Id);
            request.setAttribute("Books",Books);
            RequestDispatcher dispatcher = request.getRequestDispatcher("tsxx.jsp");
            dispatcher.forward(request, response);
        }
       //修改用户
        if (status.equals("xgyh"))
        {
            System.out.println("**************************************");
            System.out.println(request.getParameter("Id"));
            int id=Integer.parseInt(request.getParameter("Id"));
            String PassWord=request.getParameter("PassWord");
            String Address=request.getParameter("Address");
            String Phone=request.getParameter("Phone");
            String Post=request.getParameter("Post");
            String Email=request.getParameter("Email");
            db.xgyh(id,PassWord,Address,Phone,Post,Email);
            response.sendRedirect("UserInfoSer");

        }
        //删除用户
        if (status.equals("delete")) {
            int Id = Integer.parseInt(request.getParameter("Id"));
            UserInfo userinfo = new UserInfo();
            userinfo.delete(Id);
            response.sendRedirect("manage/manage_userlist.jsp");
        }

//更新订单的发货及付款情况
        if (status.equals("update")) {
            int IntdentNo = Integer.parseInt(request.getParameter("IndentNo"));
            String fk = request.getParameter("fk");
            String jh = request.getParameter("jh");
            dbpindent dbp = new dbpindent();
            dbp.updateddxx(IntdentNo, fk, jh);
            response.sendRedirect("manage/manage_orderlist.jsp");
        }
        //查询传记类图书
        if (status.equals("zj")) {
            ArrayList<My_Book> Books = db.sousuo("传记");
            request.setAttribute("Books", Books);
            RequestDispatcher dispatcher = request.getRequestDispatcher("booklist.jsp");
            dispatcher.forward(request, response);
        }
        //查询小说类图书
        if (status.equals("xs")) {
            ArrayList<My_Book> Books = db.sousuo("小说");
            request.setAttribute("Books", Books);
            RequestDispatcher dispatcher = request.getRequestDispatcher("booklist.jsp");
            dispatcher.forward(request, response);
        }
        //查询计算机类图书
        if (status.equals("jsj")) {
            ArrayList<My_Book> Books = db.sousuo("计算机");
            request.setAttribute("Books", Books);
            RequestDispatcher dispatcher = request.getRequestDispatcher("booklist.jsp");
            dispatcher.forward(request, response);
        }
        //查询所有图书
        if (status.equals("All")) {
            ArrayList<My_Book> Books = db.select();
            request.setAttribute("Books", Books);
            RequestDispatcher dispatcher = request.getRequestDispatcher("booklist.jsp");
            dispatcher.forward(request, response);
        }
        //加入购物车
        if (status.equals("add")) {
            String BookName = request.getParameter("BookName");
            int count = Integer.parseInt(request.getParameter("bookcount"));
            int userId = Integer.parseInt(request.getParameter("userId"));
          /*  int userName = Integer.parseInt(request.getParameter("userName"));*/
            ArrayList<My_Book> Books = db.select(BookName);//查询有没有这本书
            System.out.println("Books=" + Books);
          /*  int leav_number=Books.get(0).getLeav_number();*/
            if (Books != null)
                cart.add(Books, count, userId, BookName);
            response.sendRedirect("shopCartList");
        }
        //添加图书
        if (status.equals("addts")) {
            String BookName = request.getParameter("tsmc");
            String Author = request.getParameter("zz");
            String Publish = request.getParameter("cbs");
            String BookClass = request.getParameter("item");
            String BookNo = request.getParameter("sh");
            String Prince = request.getParameter("dj");
            String Amount = request.getParameter("zsl");
            String Content = request.getParameter("tsjj");
            db.addts(BookName, Author, Publish, BookClass, BookNo, Prince, Amount, Content);
            response.sendRedirect("manage/dists.jsp ");
        }
        //修改购物车中图书数量
        if (status.equals("updateBook")) {
            int BookId = Integer.parseInt(request.getParameter("BookId"));
            int Amount = Integer.parseInt(request.getParameter("Amount"));
            int leave_number = Amount - Integer.parseInt(request.getParameter("BookCountOld"));
            String BookName = request.getParameter(" BookName ");
            System.out.println("leave_number=" + leave_number);
            cart.update(BookId, Amount, BookName, leave_number);
            response.sendRedirect("shopCartList");
        }
        //从购物车中删除图书
        if (status.equals("deleteBook")) {
            int BookId = Integer.parseInt(request.getParameter("BookId"));
            int id = Integer.parseInt(request.getParameter("id"));
            cart.delete(BookId, id);
            response.sendRedirect("shopCartList");
        }
        //修改图书信息
        if (status.equals("updatebook")) {
            int Id = Integer.parseInt(request.getParameter("Id"));
            Float Prince = Float.parseFloat(request.getParameter("Prince"));
            int Amount = Integer.parseInt(request.getParameter("Amount"));
            int Leav_number = Integer.parseInt(request.getParameter("Leav_number"));
            db.updatebook(Id, Prince, Amount, Leav_number);
            response.sendRedirect("manage/manage_booklist.jsp");
        }
        //删除图书
        if (status.equals("deletebook")) {
            int Id = Integer.parseInt(request.getParameter("Id"));
            db.deletebook(Id);
            response.sendRedirect("manage/manage_booklist.jsp");
        }
        //清空购物车
        if (status.equals("gingkong")) {
            int id = Integer.parseInt(request.getParameter("id"));
            cart.qingkong(id);
            response.sendRedirect("shopCartList");
        }
        //提交购物车，添加账单信息
        if (status.equals("tijiao")) {
            String IpAddress = request.getRemoteAddr().toString();
            System.out.print(IpAddress);
            Date date = new Date();
            Timestamp time = new Timestamp(date.getTime());
            int id = Integer.parseInt(request.getParameter("id"));//用户id
            String UserName = request.getParameter("UserName");
            cart.tijiao(id, UserName, IpAddress, time);
            cart.delete(id);
            response.sendRedirect("MyOrder");
        }

        if (status.equals("deleteindent")) {
            int IndentNo = Integer.parseInt(request.getParameter("IndentNo"));
            dbpindent dpind = new dbpindent();
            dpind.deleteindent(IndentNo);
            response.sendRedirect("manage/manage_orderlist.jsp");
            out.flush();
            out.close();
        }

    }
}
