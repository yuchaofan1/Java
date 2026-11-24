package yznu.cn.jgy.dao;

import yznu.cn.jgy.pojo.My_users;
import yznu.cn.jgy.util.DBUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;

public class UserInfo {


    public My_users getUser(String UserName) {//根据用户名获取密码
        Statement stm = null;
        ResultSet rs = null;
        Connection con;
        DBUtil db = new DBUtil();
        con = (Connection) db.getConnection();
        try {
            stm = con.createStatement();
            String str = "SELECT * from My_users where UserName='" + UserName + "'";
            rs = stm.executeQuery(str);
            if (rs != null)
                if (rs.next()) {
                    My_users user = new My_users();
                    user.setId(rs.getInt("Id"));
                    user.setUserName(rs.getString("UserName"));
                    user.setPassWord(rs.getString("PassWord"));
                    user.setNames(rs.getString("Names"));
                    user.setSex(rs.getString("Sex"));
                    user.setAddress(rs.getString("Address"));
                    user.setPhone(rs.getString("Phone"));
                    user.setPost(rs.getString("Post"));
                    user.setEmail(rs.getString("Email"));
                    user.setRegTime(rs.getDate("RegTime"));
                    user.setRegIpAddress(rs.getString("RegIpAddress"));
                    return user;
                }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (rs != null)
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            if (stm != null)
                try {
                    stm.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
        }
        return null;

    }


    public My_users getUser(String UserName, String PassWord) {
        Statement stm = null;
        ResultSet rs = null;
        Connection con;
        DBUtil db = new DBUtil();
        con = (Connection) db.getConnection();
        try {
            stm = con.createStatement();
            String str = "SELECT * from My_users where UserName='" + UserName + "'and Password='" + PassWord + "'";
            rs = stm.executeQuery(str);
            if (rs != null)
                if (rs.next()) {
                    My_users user = new My_users();
                    user.setId(rs.getInt("Id"));
                    user.setUserName(rs.getString("UserName"));
                    user.setPassWord(rs.getString("PassWord"));
                    user.setNames(rs.getString("Names"));
                    user.setSex(rs.getString("Sex"));
                    user.setAddress(rs.getString("Address"));
                    user.setPhone(rs.getString("Phone"));
                    user.setPost(rs.getString("Post"));
                    user.setEmail(rs.getString("Email"));
                    user.setRegTime(rs.getDate("RegTime"));
                    user.setRegIpAddress(rs.getString("RegIpAddress"));
                    return user;
                }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (rs != null)
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            if (stm != null)
                try {
                    stm.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
        }
        return null;

    }

    public boolean addUser(My_users u) {
        PreparedStatement pstm = null;
        Connection con;
        DBUtil db = new DBUtil();
        con = (Connection) db.getConnection();
        Date date = new Date();
        Timestamp s = new Timestamp(date.getTime());
        try {
            pstm = con.prepareStatement("insert into My_users(UserName,PassWord,Names,Sex,Address," +
                    "Phone,Post,Email,RegTime,RegIpAddress)values (?,?,?,?,?,?,?,?,?,?)");
            pstm.setString(1, u.getUserName());
            pstm.setString(2, u.getPassWord());
            pstm.setString(3, u.getNames());
            pstm.setString(4, u.getSex());
            pstm.setString(5, u.getAddress());
            pstm.setString(6, u.getPhone());
            pstm.setString(7, u.getPost());
            pstm.setString(8, u.getEmail());
            pstm.setTimestamp(9, s);
            pstm.setString(10, u.getRegIpAddress());
            int i = pstm.executeUpdate();
            if (i > 0) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (pstm != null)
                try {
                    pstm.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
        }
        return false;
    }


    public ArrayList<My_users> select(int id) {
        Statement stm = null;
        ResultSet rs = null;
        Connection con;
        DBUtil db = new DBUtil();
        con = (Connection) db.getConnection();
        ArrayList<My_users> users = new ArrayList<My_users>();
        try {
            stm = con.createStatement();
            String str = "SELECT * from My_users where Id='" + id + "'";
            rs = stm.executeQuery(str);
            if (rs != null)
                if (rs.next()) {
                    My_users user = new My_users();
                    user.setId(rs.getInt("Id"));
                    user.setUserName(rs.getString("UserName"));
                    user.setPassWord(rs.getString("PassWord"));
                    user.setNames(rs.getString("Names"));
                    user.setSex(rs.getString("Sex"));
                    user.setAddress(rs.getString("Address"));
                    user.setPhone(rs.getString("Phone"));
                    user.setPost(rs.getString("Post"));
                    user.setEmail(rs.getString("Email"));
                    user.setRegTime(rs.getDate("RegTime"));
                    user.setRegIpAddress(rs.getString("RegIpAddress"));
                    users.add(user);
                }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (rs != null)
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            if (stm != null)
                try {
                    stm.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
        }
        return users;

    }


    public void delete(int id) {
        Statement stm = null;
        ResultSet rs = null;
        Connection con;
        DBUtil db = new DBUtil();
        con = (Connection) db.getConnection();
        try {
            stm = con.createStatement();
            String str = "delete from my_users where Id='" + id + "'";
            int count = stm.executeUpdate(str);
            if (count != 0)
                System.out.println("删除用户成功");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (rs != null)
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            if (stm != null)
                try {
                    stm.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
        }
    }

}
