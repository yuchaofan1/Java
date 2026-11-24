<%@ page import="yznu.cn.jgy.pojo.My_Book" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="yznu.cn.jgy.pojo.My_users" %><%--
  Created by IntelliJ IDEA.
  User: 86175
  Date: 2023/12/27
  Time: 17:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
<head>
    <title>购书信息</title>
</head>
    <%
        ArrayList<My_Book> books = (ArrayList<My_Book>) request.getAttribute("Books");
        My_users user = (My_users) session.getAttribute("currentUser");
    %>
    <center>
        <br><br>
        <h1>购书网欢迎您购物！</h1>
        <br><br><br><br>
        <form action="buyBook.jsp">
            <table>
                <tr>
                    <td>图书名称：</td><td clospan="2"><%=books.get(0).getBookName()%></td>
                </tr>
                <tr>
                    <td>作者：</td><td clospan="2"><%=books.get(0).getAuthor()%></td>
                </tr>
                <tr>
                    <td>所属类别:</td><td clospan="2"><%=books.get(0).getBookClass()%></td>
                </tr>
                <tr>
                    <td>出版社:</td><td clospan="2"><%=books.get(0).getPublish()%></td>
                </tr>
                <tr>
                    <td>书号</td><td clospan="2"><%=books.get(0).getBookNo()%></td>
                </tr>
                <tr>
                    <td>书价:</td><td clospan="2"><%=books.get(0).getPrince()%></td>
                </tr>
                <tr>
                    <td>内容介绍:</td><td clospan="2"><%=books.get(0).getConternt()%></td>
                </tr>
                <tr><td>
                    <input type="hidden" name="status" value="add">
                    <input type="hidden" name="userId" value="<%=user.getId()%>">
                    <input type="hidden" name="BookName" value="<%=books.get(0).getBookName()%>">
                </td></tr>
                <tr><td>
                    <input type="submit" value="购买">
                </td></tr>
            </table>
        </form>
        <a href="displaySer">关闭窗口</a>
    </center>
</body>
</html>
