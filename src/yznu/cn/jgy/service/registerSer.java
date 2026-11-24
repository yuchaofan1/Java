package yznu.cn.jgy.service;
import yznu.cn.jgy.dao.UserInfo;
import yznu.cn.jgy.pojo.My_users;
import javax.servlet.ServletException;
import java.sql.Date;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
@WebServlet(value = "/registerSer")
public class registerSer extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        this.doPost(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String IpAddress = request.getRemoteAddr().toString();
        System.out.print(request.getParameter("UserName"));
        String UserName = null;
        String PassWord = null;
        String PassWord1 = null;
        String Names = null;
        String Sex = null;
        String Address = null;
        String Post = null;
        String Phone = null;
        String Email = null;

        UserName = request.getParameter("UserName");
        PassWord = request.getParameter("PassWord");
        PassWord1 = request.getParameter("PassWord1");
        Names = request.getParameter("Names");
        System.out.println("Names=" + Names);
        Sex = request.getParameter("sex");
        Address = request.getParameter("Address");
        Phone = request.getParameter("Phone");
        Post = request.getParameter("Post");
        Email = request.getParameter("Email");


        HttpSession session = request.getSession();
        session.setAttribute("UserName", UserName);
        UserInfo userinfo = new UserInfo();
        My_users user = new My_users();
        user.setUserName(UserName);
        user.setPassWord(PassWord);
        user.setNames(Names);
        user.setSex(Sex);
        user.setAddress(Address);
        user.setPhone(Phone);
        user.setPost(Post);
        user.setEmail(Email);
        user.setRegIpAddress(IpAddress);
        if (UserName.length() != 0 && PassWord.length() != 0 && PassWord1.length() != 0 && Names.length() != 0) {
            if (userinfo.getUser(UserName) == null)//该用户名没有被注册
            {
                if (PassWord.equals(PassWord1))//密码和确认密码相同
                {
                    if (userinfo.addUser(user))//调用注册方法
                    {
                        out.print(user.getUserName() + "，注册成功，去登录！<a href=index.jsp>登录界面</a>");
                    }
                } else
                    out.print("你两次输人的密码不同，请重新注册！<a href=register.html>注册页面</a>");
            } else
                out.print("该用户名已被注册，请重新注册！<a href=register.html注册页面</a >");
        } else
            out.print("必须输入用户名，原密码，确认密码，真实姓名，请重新注册！<a href = register.html> 注册页面</a>");
    }
}