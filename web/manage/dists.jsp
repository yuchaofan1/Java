<%@ page import="yznu.cn.jgy.pojo.My_Book" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="yznu.cn.jgy.util.DBUtil" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.Statement" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<center>
    <%
    DBUtil db=new DBUtil();
        Connection conn= db.getConnection();
        Statement stmt;
        ResultSet rs;
    %>

    <%
    stmt= conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
    rs=stmt.executeQuery("select * from my_book");
    rs.last();
    %>
</center>


<center>


        总结果为：
            <font size=4 color=green>
                <%=rs.getRow()%>
                条
            </font>
        <table border="1">
<tr>
        <td>图书名称</td>
         <td>作者</td>
        <td>出版社</td>
        <td>图书类别</td>
        <td>书号</td>
        <td>单价</td>
        <td>总数量</td>
        <td>图书简介</td></tr>
        <%
            rs.beforeFirst();
        while(rs.next())

        {%>

        <tr align=center>
            <td><b><%=rs.getString("BookName")%></b></td>
            <td><b><%=rs.getString("Author") %></b></td>
            <td><b><%=rs.getString("Publish")%></b></td>
            <td><b><%=rs.getString("BookClass")%></b></td>
            <td><b><%=rs.getString("BookNo") %></b></td>
            <td><b><%=rs.getFloat("Prince") %></b></td>
            <td><b><%=rs.getInt("Amount")%></b></td>
            <td><b><%=rs.getString("Content")%></b></td>
        </tr>
<%}
        rs.close();
        stmt.close();
        conn.close();
        %>
</table>
<br/><br/>
<a href="manage_userlist.jsp"><b>返回</b></a >
</center>
<br><br><br><br><br>
<center>
    <font color="grey" size=4>购书网欢迎您人光临！</font>
</center>
</body>
</html>
