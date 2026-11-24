
<%@ page language="java" import="yznu.cn.jgy.pojo.*,java.util.*,java.sql.*,yznu.cn.jgy.dao.*,yznu.cn.jgy.util.*" pageEncoding="UTF-8" %>
<html>
<body background="image/982.jfif">
<center>
 <%--   <img src="image/983.jfif"> <br><br>--%>
    <a href="displaySer">首页</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    <a href="displaySer">在线购物</a>&nbsp;&nbsp;&nbsp;&nbsp;
    <a href="shopCartList">我的购物车</a>&nbsp;&nbsp;&nbsp;&nbsp;
    <a href="UserInfoSer">个人信息</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    <a href="index.jsp">切换用户</a>
    <center>
        <center>
            <table>
                <tr><td>
                    <table>
                        本店图书分类<br>
                        <a href=" Myser?status=zj">传记</a><p>
                        <a href=" Myser?status=xs">小说</a><p>
                        <a href=" Myser?status=jsj">计算机</a><p>
                    </table>
                </td>
                    <table border="1">
                        <center>我的购物车商品列表</center>
                        <tr>
                            <td>图书名称</td><td>作者</td><td>图书类别</td><td>单价</td><td>数量</td><td>选择</td>
                        </tr><%
                        My_users user = (My_users)session.getAttribute( "currentUser");
                        ArrayList<My_cart> books=(ArrayList <My_cart>)request.getAttribute("Books");
                        double totalAmount = 0.0;
                        if (books!=null)
                        {
                            for(int i=0;i<books.size();i++)
                            {
                                int quantity=books.get(i).getAmount();
                                double price=books.get(i).getPrince();
                                totalAmount+=quantity * price;
                    %>
                        <tr>
                            <td><%=books.get(i).getBookName()%></td>
                            <td><%=books.get(i).getAuthor()%></td>
                            <td><%=books.get(i).getBookClass()%></td>
                            <td><%=books.get(i).getPrince()%></td>
                            <td><%=books.get(i).getAmount()%></td>
                          <%--  <td><%=books.get(i).getPrince()*books.get(i).getAmount() %></td>--%>
                            <td><a href="update.jsp?BookName=<%=books.get(i).getBookName()%>&Amount=<%=books.get(i).getAmount()%>&BookId=<%=books.get(i).getBookId()%>">修改</a>&nbsp;&nbsp;
                                <a href="Myser?id=<%=user.getId()%>&status=deleteBook&BookId=<%=books.get(i).getBookId()%>">删除</a></td>
                        </tr>
                        <%}
                        }

                        %>
                    </table>
        </center>
        <center>
            <div class="container">
                <textarea weight=100 name="附言" rows="5" cols="30">附言:</textarea>
                <p class="text">总计:<%=totalAmount%>元</p>
            </div>
            <br><br><br>
        </center>
        <a href="displaySer">继续购书</a>&nbsp;&nbsp;&nbsp;
        <a href="Myser?status=tijiao&id=<%=user.getId()%>&UserName=<%=user.getUserName()%>">提交购物车</a>&nbsp;
        <a href="Myser?status=qingkong&id=<%=user.getId()%>">清空购物车</a>
        <br><br><br><br>
        <font color="#808080" size="4"> 购书网欢迎您的光临!</font>
</body>
</html>
