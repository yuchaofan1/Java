<%@ page import="yznu.cn.jgy.pojo.My_order" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Title</title>
</head>
<body background="image/982.jfif">
<center>

  <a href="displaySer" >首页</a> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
  <a href="displaySer">在线购物</a>  &nbsp; &nbsp; &nbsp;&nbsp;&nbsp;&nbsp;
 <a href="shoperlist.jsp">我的购物车</a>  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
  <a href="UserInfoSer">个人信息</a>&nbsp;&nbsp;&nbsp; &nbsp; &nbsp;&nbsp;
  <a href="index.jsp">切换用户</a>
</center>
<hr>
<center>
  <table>
    <tr><td>
      <table>
          <a href="MyOrder">查看订单情况</a><br/>
        <a href="UserInfoSer">修改个人信息</a><br/>
        <a href="shopCartList">查看我的购物车</a><br/></table>
    </td>
      <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        <% ArrayList<My_order>indents=(ArrayList<My_order>)request.getAttribute("indents");%>
        您的订单消息
        <table border="2">
          <tr><td>订单号</td><td>提交时间</td><td>总金额</td><td>付款</td><td>发货</td><td>详情</td></tr>
          <%
            if(indents!=null){
              for(int i=0;i<indents.size();i++){
          %>
          <tr>
            <td><%=indents.get(i).getIndentNo()%></td>
            <td><%=indents.get(i).getSubmitTime()%></td>
            <td><%=indents.get(i).getTotaPeice()%></td>
            <td><%=indents.get(i).getIsPayoff()%></td>
            <td><%= indents.get(i).getIsSales()%></td>
          <td><a href="ckdd.jsp?IndentNo=<%=indents.get(i).getIndentNo()%>&BookName=<%=indents.get(i).getBookName()%>">查看</a></td>
          </tr>
          <%
              }
            }
          %>
        </table>
      </td>
    </tr>
  </table>
</center>
</body>
</html>
