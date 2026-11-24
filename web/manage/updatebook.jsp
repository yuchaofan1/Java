
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<center>

    <h1>修改图书信息</h1>
    <form action="../Myser">
        <table>
            <tr>
                <td>图书编号:</td><td><%=request.getParameter("Id")%></td>
            <tr>
                <td>图书名称：</td><td><%=request.getParameter("BookName")%></td>
            </tr>
            <tr>
                <td>作者：</td><td><%=request.getParameter("Author")%></td>
            </tr>
            <tr>
                <td>图书类别:</td><td><%=request.getParameter("BookClass")%></td>
            </tr>
            <tr>
                <td>单价：</td><td><input type="text" name="Prince" value="<%=request.getParameter("Prince")%>"></td>
            </tr>
            <tr>
                <td>总数量:</td><td><input type="text"name="Amount" value="<%=request.getParameter("Amount")%>"></td>
            </tr>
            <tr>
                <td>剩余数量：</td><td><input type="text" name="Leav_number" value="<%=request.getParameter("Leav_number")%>"/></td>
            </tr>
            <tr>
                <td><input type="submit" value="修改"/></td>
            </tr>
            <tr>
                <input type="hidden" name="status" value="updatebook"/>
                <input type="hidden" name="Id" value="<%=request.getParameter("Id")%>"/>
            </tr>
        </table>

    </form>
</center>

</body>
</html>
