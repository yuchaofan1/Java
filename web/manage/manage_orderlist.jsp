<%@ page import="yznu.cn.jgy.dao.dbpindent" %>
<%@ page import="yznu.cn.jgy.pojo.My_order" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: 86175
  Date: 2023/12/29
  Time: 2:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<center>
    <br> <br> <br>
    <h1 align="center">在线购书商城订单情况</h1>
    <br> <br>
    <div style="widh:30%;heicht:30px;float:left;">
        <a href="index.jsp">回管理首页</a><br>
        <a href="manage_booklist.jsp">商店图书查询</a><br><br>
        <a href="manage_addbook.jsp">添加图书资料</a><br><br>
        <a href="manage_orderlist.jsp">订单信息查询</a><br><br>
        <a href="mannge_userlisl.jsp">用户信息查询</a><br><br>
        <a href="../index.jsp">退出</a>
    </div>

</center>
<table border="1" cellpadding="2" align="center">
    <tr>
        <td>订单编号</td>
        <td>用户名</td>
        <td>下单时间</td>

        <td>总金额</td>
        <td>订货</td>
        <td>付款</td>
        <td>发货</td>
        <td>查看</td>
    </tr>

    </tr>
    <% dbpindent dbind = new dbpindent();
        dbind.update();
        ArrayList<My_order> indents = dbind.select();
    %>
    <%
        if (indents != null)
            for (int i = 0; i < indents.size(); i++) {


    %>
    <tr align="center">
        <td><b><%=indents.get(i).getIndentNo()%>
        </b></td>
        <td><b><%=indents.get(i).getUserName()%>
        </b></td>
        <td><b><%=indents.get(i).getSubmitTime() %>
        </b></td>
        <td><b><%=indents.get(i).getTotaPeice()%>
        </b></td>
        <td><b><%=indents.get(i).getIPAddress()%>
        </b></td>
        <td><b><%=indents.get(i).getIsPayoff()%>
        </b></td>
        <td><b><%=indents.get(i).getIsSales()%>
        </b></td>
        <td><b><a href="manage_indentlist.jsp?IndentNo=<%=indents.get(i).getIndentNo()%>&BookName=<%=indents.get(i).getBookName()%>">详细情况</a>
            <a href="../Myser?status=deleteindent&IndentNo=<%=indents.get(i).getIndentNo()%>">删除</a></b></td>
    </tr>
    <%
            }
    %>
</table>
<br>
</body>
</html>