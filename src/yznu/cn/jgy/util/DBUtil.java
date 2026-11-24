package yznu.cn.jgy.util;

//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.SQLException;
//
//public class DBUtil{
//
//
//    //private String driverName="com.mysql.jdbc.Driver";
//    private String driverName="com.mysql.cj.jdbc.Driver";
//    private String url="jdbc:mysql://localhost/bookshop?user=root&password=123456"
//            + "&useUnicode=true&characterEncoding=UTF-8";
//    Connection con;
//    public Connection getConnection(){
//        con=null;
//        try {
//            Class.forName(driverName);
//            con = DriverManager.getConnection(url);
//            System.out.println("数据库连接成功！！");
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        }
//
//        return con;
//    }
//}

//---------------------------------------------
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil{
    private static final String driverName = "com.mysql.jdbc.Driver";
    private static final String url = "jdbc:mysql://localhost:3306/bookshop?useUnicode=true&characterEncoding=utf-8";
    private static final String user = "root";
    private static final String pwd = "123456";

    public Connection getConnection(){
        Connection con = null;
        try {
            Class.forName(driverName);
            con = DriverManager.getConnection(url, user, pwd);
            System.out.println("✅ 数据库连接成功 con=" + con);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.err.println("❌ 找不到驱动类：检查5.x的mysql驱动jar是否导入");
        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("❌ 连接SQL失败：账号/密码/端口");
        }
        return con;
    }
}
