package yznu.cn.jgy.dao;
import yznu.cn.jgy.dao.Interface.Idbpindent;
import yznu.cn.jgy.pojo.My_order;
import yznu.cn.jgy.util.DBUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;

public class dbpindent implements Idbpindent {
    Connection con=null;
    PreparedStatement pre=null;
    Statement sta=null;
    ResultSet rs=null;
    boolean f=false;
    public void insert(float s, Timestamp time,int id,String UserName,String IpAddress){
        try {
            DBUtil cons=new DBUtil();
            con=cons.getConnection();
            sta=con.createStatement();
            sta.executeUpdate("insert into my_order(UserId,UserName,SubmitTime,TotalPrice,IsPayoff,IsSales,IpAddress)" +
                    "values ('"+id+"','"+UserName+"','"+time+"','"+s+"','未付','未发货','"+IpAddress+"')");
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
     public ArrayList<My_order> select(int id){
        ArrayList<My_order>indents=new ArrayList<My_order>();
        try {
            DBUtil cons=new DBUtil();
            con=cons.getConnection();
            sta=con.createStatement();
            rs=sta.executeQuery("select * from my_order where UserId='"+id+"'");
            //rs.beforeFirst();
            while (rs.next()){
                My_order indent=new My_order();
                indent.setIndentNo(rs.getInt("IndentNo"));
                indent.setUserId(rs.getInt("UserId"));
                indent.setUserName(rs.getString("UserName"));
                indent.setSubmitTime(rs.getTimestamp("SubmitTime"));
                indent.setConsignmentTime(rs.getTimestamp("ConsignmentTime"));
                indent.setTotaPeice(rs.getFloat("TotalPrice"));
                indent.setContent(rs.getString("Content"));
                indent.setIPAddress(rs.getString("IPAddress"));
                indent.setIsPayoff(rs.getString("IsPayoff"));
                indent.setIsSales(rs.getString("IsSales"));
                indent.setBookName(rs.getString("BookName"));
                indents.add(indent);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return indents;
     }

     public ArrayList<My_order> st(int IndentNo){
         ArrayList<My_order>indents=new ArrayList<My_order>();
         try {
             DBUtil cons=new DBUtil();
             con=cons.getConnection();
             sta=con.createStatement();
             rs=sta.executeQuery("select * from my_order where IndentNo='"+IndentNo+"'");
             //rs.beforeFirst();
             while (rs.next()){
                 My_order indent=new My_order();
                 indent.setIndentNo(rs.getInt("IndentNo"));
                 indent.setUserId(rs.getInt("UserId"));
                 indent.setUserName(rs.getString("UserName"));
                 indent.setSubmitTime(rs.getTimestamp("SubmitTime"));
                 indent.setConsignmentTime(rs.getTimestamp("ConsignmentTime"));
                 indent.setTotaPeice(rs.getFloat("TotalPrice"));
                 indent.setContent(rs.getString("Content"));
                 indent.setIPAddress(rs.getString("IPAddress"));
                 indent.setIsPayoff(rs.getString("IsPayoff"));
                 indent.setIsSales(rs.getString("IsSales"));
                 indent.setBookName(rs.getString("BookName"));
                 indents.add(indent);
             }
         }catch (SQLException e){
             e.printStackTrace();
         }
         return indents;
     }

     public ArrayList<My_order>select(){
         ArrayList<My_order>indents=new ArrayList<My_order>();
         try {
             DBUtil cons=new DBUtil();
             con=cons.getConnection();
            /* sta=con.createStatement();*/
           /*  rs=sta.executeQuery("select * from my_order");*/
             String sql="select * from my_order";
             pre=con.prepareStatement(sql,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
             rs= pre.executeQuery();
           /*  rs.beforeFirst();*/
             while (rs.next()){
                 My_order indent=new My_order();
                 indent.setIndentNo(rs.getInt("IndentNo"));
                 indent.setUserId(rs.getInt("UserId"));
                 indent.setUserName(rs.getString("UserName"));

                 System.out.println(rs.getString("UserName"));
                 System.out.println("=========================");
                 indent.setSubmitTime(rs.getTimestamp("SubmitTime"));

                 indent.setConsignmentTime(rs.getTimestamp("ConsignmentTime"));
                 indent.setTotaPeice(rs.getFloat("TotalPrice"));
                 indent.setContent(rs.getString("Content"));
                 indent.setIPAddress(rs.getString("IPAddress"));
                 indent.setIsPayoff(rs.getString("IsPayoff"));
                 indent.setIsSales(rs.getString("IsSales"));
                 indent.setBookName(rs.getString("BookName"));
                 indents.add(indent);
             }
         }catch (SQLException e){
             e.printStackTrace();
         }
         return indents;
     }

     public void delete(int BookId,int id){
        try {
            DBUtil cons=new DBUtil();
            con=cons.getConnection();
            sta=con.createStatement();
            sta.executeUpdate("delete from my_bus where userId='"+id+"'and BookId='"+BookId+"'");
        }catch (SQLException e){
            e.printStackTrace();
        }
     }
     public void deleteindent(int IndentNo){
        try {
            DBUtil cons=new DBUtil();
            con=cons.getConnection();
            sta=con.createStatement();
            sta.executeUpdate("delete from my_order where IndentNo='"+IndentNo+"'");
        }catch (SQLException e){
            e.printStackTrace();
        }
     }
     public void update(){
        Date date=new Date();
        Timestamp s=new Timestamp(date.getTime());
        try {
            DBUtil cons=new DBUtil();
            con=cons.getConnection();
            sta=con.createStatement();
            int count=sta.executeUpdate("update my_order set ConsignmentTime='"+s+"'");
            if (count!=0)
                System.out.println("发货成功");
        }catch (SQLException e){
            e.printStackTrace();
        }
     }
     public void updateddxx(int IndentNo,String fk,String jh){
        try {
            DBUtil cons=new DBUtil();
            con=cons.getConnection();
            sta=con.createStatement();
            pre=con.prepareStatement("update my_order set IsPayoff=?,IsSales=? where IndentNo=?");
            pre.setString(1,fk);
            pre.setString(2,jh);
            pre.setInt(3,IndentNo);
            int count=pre.executeUpdate();
            if (count!=0)
                System.out.println("更新成功");
        }catch (SQLException e){
            e.printStackTrace();
        }
     }
}
