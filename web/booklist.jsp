<%--
  Created by IntelliJ IDEA.
  User: 86175
  Date: 2023/12/20
  Time: 22:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="yznu.cn.jgy.pojo.My_Book" %>
<%@ page import="java.util.ArrayList" %>
<html>
<body background="image/1.jpg">
<center>
    <%--<img src="image/xiaohui.png"><p>--%>
    <a href="displaySer">首页</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    <a href="displaySer">在线购物</a> &nbsp; &nbsp; &nbsp;&nbsp;&nbsp;
    <a href="shopCartList">我的购物车</a> &nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    <a href="UserInfoSer">个人信息</a> &nbsp; &nbsp; &nbsp;&nbsp;&nbsp;&nbsp;
    <a href="index.jsp">切换用户</a>
</center>
<hr>
<p>
    <center>
<table>
    <tr>
        <td>
            <table>
                本店图书分类：<br>
                <a href="Myser?status=zj">传记</a>
                <p>
                    <a href="Myser?status=xs">小说</a>
                <p>
                    <a href="Myser?status=jsj">计算机</a>
                <p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    <br>
                    类别：<font color="#000000" sizi="5"><br>
                <form action="Myser">
                    <br>

                    <font color="#000000" sizi="5"><br>
                        <select name="status">
                            <option value="All">所有类别</option>
                            <option value="zj">传记</option>
                            <option value="xs">小说</option>
                            <option value="jsj">计算机</option>
                        </select>
                    </font>
                    <br>&nbsp;&nbsp;
                    <input type="submit" name="s" value="查询">
                    </font>
                </form>
            </table>

        </td>
    </tr>
</table>
<center>
    <td>
        <table border="1">
            <h3>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;电子书店图书列表<br>
            </h3><%ArrayList<My_Book> Books = (ArrayList<My_Book>) request.getAttribute("Books");%>总结果为：
            <font size=4 color=green>
                <%=Books.size()%>
                条
            </font>
            <tr>
                <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;图书名称
                </td>
                <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;作者</td>
                <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;图书类别</td>
                <td>&nbsp;&nbsp;&nbsp;&nbsp;出版社</td>
                <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;单价</td>
                <td>&nbsp;&nbsp;&nbsp;选择</td>
            </tr>
            <%
                for (int i = 0; i < Books.size(); i++) {%>
            <td><b><%=Books.get(i).getBookName()%>
            </b></td>
            <td><b><%=Books.get(i).getAuthor()%>
            </b></td>
            <td><b><%=Books.get(i).getBookClass()%>
            </b></td>
            <td><b><%=Books.get(i).getPublish()%>
            </b></td>
            <td><b><%=Books.get(i).getPrince()%>
            </b></td>
            <td><b><a href="buyBook.jsp?BookName=<%=Books.get(i).getBookName()%>">购书</a><a href="Myser?status=select&Id=<%=Books.get(i).getId()%>">详细资料</a></b></td>
            </tr>
            <%
                }
            %>
        </table>
    </td>
    </tr>
    </table>
</center>
<br><br><br><br><br>
<center>
    <font color="white" size=4>购书网欢迎您的光临！</font>
</center>
</body>
</html>
