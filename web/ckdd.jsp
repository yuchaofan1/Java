<%@ page import="yznu.cn.jgy.dao.dbp" %>
<%@ page import="yznu.cn.jgy.pojo.My_Book" %>
<%@ page import="yznu.cn.jgy.dao.dbpindent" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="yznu.cn.jgy.pojo.My_order" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<body>
<center>
<h3>购书网图书订单清单:</h3>
    <%int IndentNo=Integer.parseInt(request.getParameter("IndentNo"));
        String BookName=request.getParameter("BookName");
        dbp dp=new dbp();
        ArrayList<My_Book> Books=dp.select(BookName);
        dbpindent db=new dbpindent();
        ArrayList<My_order> indents=db.st(IndentNo);
        float s=indents.get(0).getTotaPeice();
        float dj=Books.get(0).getPrince();
        float sl=s/dj;%>
<table border="1">
<tr>
    <td>图书名称</td>
    <td>作者</td>
    <td>图书类别</td>
    <td>单价</td>
    <td>数量</td>
</tr>
<tr>
    <td><%=Books.get(0).getBookName()%></td>
    <td><%=Books.get(0).getAuthor()%></td>
    <td><%=Books.get(0).getBookClass()%></td>
    <td><%=Books.get(0).getPrince()%></td>
    <td><%=sl%></td>
</tr>
<tr><td colspan="5">购买的总金额是：<%=indents.get(0).getTotaPeice()%>总数量是:<%=sl%></td>
</tr>
</table>
<form action="Myser">
    <table border="1"><tr>
        <td>下单用户:</td>
        <td><%=indents.get(0).getUserName()%></td>
</tr>
    <tr>
        <td>下单时间:</td>
        <td><%=indents.get(0).getSubmitTime()%></td>
    </tr>
        <tr>
        <td>交货时间:</td>
            <td><%=indents.get(0).getConsignmentTime()%></td>
        </tr>
        <tr>
            <td>总金额:</td>
            <td><%=indents.get(0).getTotaPeice()%></td>
        </tr>
        <tr>
            <td>下单时IP:</td>
            <td><%=indents.get(0).getIPAddress()%></td>
        </tr>
        <tr>
            <td>用户备注:</td><td>附言:</td>
        </tr>
        <tr>
        <td>是否付款:</td>
        <td><%=indents.get(0).getIsPayoff()%></td>
        </tr>
        <tr>
            <td>是否交货:</td>
            <td><%=indents.get(0).getIsSales()%></td>
        </tr>
    </table>

<td>订单号：</td>&nbsp;&nbsp;&nbsp;
    <input type=“hidden" name="IndentNo" value="<%=indents.get(0).getIndentNo()%>">
    <input type="hidden" name="status" value="update">
</form>
    <a href="MyOrder">关闭窗口</a>
    </center>
</body>
</html>