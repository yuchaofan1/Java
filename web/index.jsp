<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册页面</title>
</head>
<body background="image/980.png">
<font color="#1e90ff">
<h1 align="center">在线购书商城</h1>
</font>
<center>
    <img src="image/xiaohui.png">
    <p>
</center>
<hr>
<center>
    <table width="1141" height="402">
        <tr>
            <td>
                <table>
                    <center>
                        <form action="loginSer" method="post">
                            <img src="image/yfdl(1).png"/>
                            <p>&nbsp;
                            <h4>用户登录</h4>
                            用户名：<input type="text" name="UserName"><br>
                            密码：&nbsp;&nbsp;&nbsp;<input type="text" name="PassWord"><br>

                            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <input type="submit" name="s" value="登录">
                            <input type="reset" name="q" value="取消">
                            <a href="register.html"><input type="button" name="z" value="注册"/></a><br>
                            <a href="manage/manage_login.jsp"><input type="button" name="gly" value="管理员登录"></a>
                            <%-- <input type="submit" name="z" value="注册" ><font color="red">如果你还没有注册，请<a href="register.html">注册<br></a><br>--%>
                            <%--<button value="注册" name="w" type="submit"<a href="register.html">注册<br></a>></button>--%>
                            <p>&nbsp;
                            <p>&nbsp;
                            <font color="red">
                                <b>如果你没有注册用户或输入的用户还没有注册，请点击注册按钮<br>
                                    自动跳转到注册页面！</b></font>
                        </form>
                    </center>
                </table>
            </td>
            <td>
                <font color="white">
                <table>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;本书图书精品
                    <p>
                        <br>使用JSP开发WEB应用
                    <p>
                        作者：王永茂 著</p>
                    I3BN:11111111111<p>
                        出版社： 北京北大方正软件技术学院
                    <p>
                        内容简介：
                    <p>
                        掌握JSP2.0规范技术，包括开发和部署JSP，创建标签和<br>标签文件；联合使用JSP，Javabean，表达语言<br>(EL),自定义标签以及JSTL标签库创建Web应用，最后<br>结合servlet技术完成web应用开发；独立设计基于mvc的<br>企业应用。
                    </p>
                </table>
                </font>
            </td>
            <td>
                <font color="white">
                <table>
                    本店图书分类：<br>
                    <a>传记</a>
                    <p>
                        <a>小说</a>
                    <p>
                        <a>计算机</a>
                    <p>
                </table>
                </font>
            </td>
        </tr>
    </table>
</center>
</body>
</html>
