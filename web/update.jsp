<%--
  Created by IntelliJ IDEA.
  User: 86175
  Date: 2023/12/25
  Time: 15:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body background="image/982.jfif">
<table>
<h1>修改图书数量界面</h1>
<br><br> <br><br>
<form action="Myser">
    <table bgcolor="gray"border="1">
        <tr>
            <td>图书名称：</td><td><%=request.getParameter("BookName")%></td>
        </tr>
        <tr>
            <td>购买数量：</td><td><input type="text" name="Amount" value="<%=Integer.parseInt(request.getParameter("Amount"))%>"></td>
        </tr>
        <tr><td><input type="submit" value="修改"/></td></tr>
    </table>
    <tr> <td> <input type="hidden" name="BookId" value="<%= Integer.parseInt(request.getParameter("BookId"))%>"/></td></tr>
    <tr> <td> <input type="hidden" name="BookName" id="BookName" value="<%=request.getParameter("BookName")%>"/></td></tr>
    <tr> <td> <input type="hidden" name="BookCountOld"id="BookCountOld" value="<%=Integer.parseInt(request.getParameter("Amount"))%>"/></td></tr>
    <tr> <td> <input type="hidden" name="status" value="updateBook"/></td></tr>
</form>
<a href="shopCartList"><input type="submit" name="f" value="返回"></a>
</center>
</table>
</body>
</html>
