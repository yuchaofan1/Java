<%@ page import="yznu.cn.jgy.pojo.My_users" %>
<%@ page import="java.nio.charset.StandardCharsets" %><%--
  Created by IntelliJ IDEA.
  User: 86175
  Date: 2023/12/25
  Time: 15:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body background="image/1.jpg">
<%My_users user=(My_users)session.getAttribute("currentUser"); %>
<br><br><br><br>
<h2 align="center">购书网欢迎您选购图书！</h2>
<br><br><br><br>
<center>
    <form action="Myser">
        <table>
            <font color="white">
            <tr><td>图书名称：</td><td><%= request.getParameter("BookName") %></td></tr>
            <tr><td>您要购买的数量:</td><td><input type="text" name="bookcount" size="4">本</td></font>
            <tr><td><input type ="submit" value="购买">&nbsp;&nbsp;<input type="reset"value="取消"></td></tr>

            <tr> <input type="hidden" name="status" value="add"></tr>
            <tr> <input type="hidden" name="userId" value="<%=user.getId()%>"></tr>
            <tr> <input type="hidden"name="BookName" value="<%=request.getParameter("BookName")%>"></tr>
        </table>
    </form>
 <a href="showindex.html">查看购买列表</a><br><br/>
    <a href="displaySer">关闭窗口</a>
    <br><br><br><br>
    <h2 align="center">购书网欢迎您的光临！
</center>
</body>
</html>