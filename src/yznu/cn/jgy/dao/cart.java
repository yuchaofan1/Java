package yznu.cn.jgy.dao;

import yznu.cn.jgy.dao.Interface.ICart;
import yznu.cn.jgy.pojo.My_Book;
import yznu.cn.jgy.pojo.My_cart;
import yznu.cn.jgy.util.DBUtil;

import java.sql.*;
import java.util.ArrayList;

public class cart implements ICart {
    Connection con = null;
    PreparedStatement pre = null;
    Statement sta = null;
    ResultSet rs = null;
    boolean f = false;

    public ArrayList<My_cart> select(int userId) {
        ArrayList<My_cart> books = new ArrayList<My_cart>();
        try {
            DBUtil cons = new DBUtil();
            con = cons.getConnection();
            sta = con.createStatement();
            rs = sta.executeQuery("select * from my_cart where userId='" + userId + "'");
           /* rs.beforeFirst();*/
            while (rs.next()) {
                My_cart book = new My_cart();
                book.setUserId(rs.getInt("userId"));
                book.setBookName(rs.getString("BookName"));
                book.setBookClass(rs.getString("BookClass"));
                book.setAuthor(rs.getString("Author"));
                book.setPrince(rs.getFloat("Prince"));
                book.setAmount(rs.getInt("Amount"));
                book.setBookId(rs.getInt("BookId"));
                books.add(book);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return books;
    }


    @Override
    public void add(ArrayList<My_Book> Books, int count, int userId, String BookName) {
        try {
            DBUtil cons = new DBUtil();
            con = cons.getConnection();
            sta = con.createStatement();
            pre = con.prepareStatement("update my_book set Leav_number=Leav_number-? where BookName=?");
            pre.setInt(1, count);
            pre.setString(2, BookName);
            pre.executeUpdate();
            rs = sta.executeQuery("select userId from my_cart where userId='" + userId + "'and BookId='" + Books.get(0).getId() + "'");
           // rs.beforeFirst();
            if (rs.next()) {
                pre = con.prepareStatement("update my_cart set Amount=Amount+? where userId=? and BookId=?");
                pre.setInt(1, count);
                pre.setInt(2, userId);
                pre.setInt(3, Books.get(0).getId());
                int c = pre.executeUpdate();
                if (c != 0)
                    System.out.println("更新成功");
            } else {
                pre = con.prepareStatement("insert into my_cart values(?,?,?,?,?,?,?)");
                pre.setInt(1, userId);
                pre.setString(2, Books.get(0).getBookName());
                pre.setString(3, Books.get(0).getAuthor());
                pre.setString(4, Books.get(0).getBookClass());
                pre.setFloat(5, Books.get(0).getPrince());
                pre.setInt(6, count);
                pre.setInt(7, Books.get(0).getId());
                int c = pre.executeUpdate();
                if (c != 0)
                    System.out.println("添加成功");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void update(int BookId, int Amount, String bookName, int leaveNumber) {
        try {
            DBUtil cons = new DBUtil();

            con = cons.getConnection();
            sta = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            pre = con.prepareStatement("Update my_book set Leav_number=Leav_number-? where BookName=?");
            pre.setInt(1, leaveNumber);
            pre.setString(2, bookName);
            pre.executeUpdate();
            sta.executeUpdate("update my_cart set Amount='" + Amount + "'where BookId='" + BookId + "'");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



    @Override
    public void delete(int BookId, int id) {
        try {
            DBUtil cons = new DBUtil();
            con = cons.getConnection();
            sta = con.createStatement();
            sta.executeUpdate("delete from my_cart where userId='" + id + "'and BookId='" + BookId + "'");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        try {
            DBUtil cons = new DBUtil();
            con = cons.getConnection();
            sta = con.createStatement();
            sta.executeUpdate("delete from my_cart where userId='" + id + "'");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void qingkong(int id) {
        try {
            DBUtil cons = new DBUtil();
            con = cons.getConnection();
            sta = con.createStatement();
            sta.executeUpdate("delete from my_cart where userId='" + id + "'");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void tijiao(int id, String UserName, String IpAddress, Timestamp time) {
        float m;
        try {
            DBUtil cons = new DBUtil();
            con = cons.getConnection();
            String sql="select *from my_cart where userId='"+id+ "'";
            pre= con.prepareStatement(sql,ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
          rs= pre.executeQuery();
           /* sta = con.createStatement();
            rs = sta.executeQuery("select *from my_cart where userId='" + id + "'");*/
            /*rs.beforeFirst();*/
            while (rs.next()) {
                m = rs.getFloat("Prince") * rs.getInt("Amount");
                sta = con.createStatement();
                sta.executeUpdate("insert into my_order(UserId,UserName,SubmitTime,TotalPrice,IsPayoff," +
                        "IsSales,IPAddress,BookName)values ('" +id+"','"+ UserName + "','"+time+"','" + m + "','未付','未发货','"+IpAddress
                        + "','" + rs.getString("BookName") + "')");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
