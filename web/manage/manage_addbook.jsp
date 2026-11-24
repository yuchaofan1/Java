<%--
  Created by IntelliJ IDEA.
  User: 86175
  Date: 2023/12/29
  Time: 0:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body background="../image/1.jpg">
<center>
    <br>
    <h1 align="center">添加新的图书信息</h1>
    <br/><br/><br/><br/>
    <div style=" width:30%; height:30px ; float : left ;">
        <a href="../index.jsp">首页</a><br><br>
        <a href="manage_booklist.jsp">商店图书查询</a><br><br>
        <a href="manage_addbook.jsp">添加图书资料</a><br><br>
        <a href="manage_orderlist.jsp">订单信息查询</a><br><br>
        <a href="manage_userlist.jsp">用户信息查询</a> <br><br>
        <a href="../index.jsp">退出</a>
    </div>
</center>
<form action="../Myser">
    <table style="height:430px;">
        <tr>
            <td>图书名称：</td>
            <td><input type="text" name="tsmc"/></td>
        </tr>
        <tr>
            <td>作者：</td>
            <td><input type="text" name="zz"/></td>
        </tr>
        <tr>
            <td>出版社：</td>
            <td><input type="text" name="cbs"/></td>
        </tr>
        <td>所属类别:</td>
        <td><select name="item">
            <option value="传记">传记</option>
            <option value="小说">小说</option>
            <option value="计算机类">计算机类</option>
        </select></td>
        </t>
        <tr>
            <td>书号:</td>
            <td><input type="text" name="sh"/></td>
        </tr>
        <tr>
            <td>定价:</td>
            <td><input type="text" name="dj"/></td>
        </tr>
        <tr>
            <td>总数量:</td>
            <td><input type="text" name="zsl"></td>
        </tr>
        <tr>
            <td>图书简介:</td>
        </tr>
        <tr>
            <td></td>
            <td><textarea name="tsjj" rows="5" cols="20"></textarea></td>
        </tr>
        <tr>
            <td><input type="submit" value="提交"><input type="reset" value="重置"></td>
        </tr>
        <tr>
            <td><input type="hidden" name="status" value="addts"/></td>
        </tr>
    </table>
</form>
<br>
</body>
</html>
