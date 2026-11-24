package yznu.cn.jgy.dao;//package yznu.cn.jgy.dao;

import yznu.cn.jgy.dao.Interface.Idbp;
import yznu.cn.jgy.pojo.My_Book;
import yznu.cn.jgy.pojo.My_Book;
import yznu.cn.jgy.util.DBUtil;

import java.sql.Date;
import java.sql.*;
import java.util.ArrayList;

public class dbp implements Idbp {
    Connection con = null;
    PreparedStatement pre = null;
    Statement sta = null;
    ResultSet rs = null;
    boolean f = false;
    private Object Id;
    // private String Id;

    @Override
    public ArrayList<My_Book> select(int id) {
        ArrayList<My_Book> books = new ArrayList<My_Book>();
        try {
            DBUtil cons = new DBUtil();
            con = cons.getConnection();
            sta = con.createStatement();
            rs = sta.executeQuery("select * from my_book where Id='" + Id + "'");
            if (rs == null)
                rs.beforeFirst();
            while (rs.next()) {
                My_Book book = new My_Book();
                book.setId(rs.getInt("Id"));
                book.setBookName(rs.getString("BookName"));
                book.setBookClass(rs.getString("BookClass"));
                book.setAuthor(rs.getString("Author"));
                book.setPublish(rs.getString("Publish"));
                book.setBookNo(rs.getString("BookNo"));
                book.setConternt(rs.getString("Content"));
                book.setPrince(rs.getFloat("Prince"));
                book.setAmount(rs.getInt("Amount"));
                book.setLeav_number(rs.getInt("Leav_number"));
                books.add(book);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return books;
    }

    @Override
    public ArrayList<My_Book> sousuo(String BookClass) {
        ArrayList<My_Book> books = new ArrayList<My_Book>();
        try {
            DBUtil cons = new DBUtil();
            con = cons.getConnection();
            sta = con.createStatement();
            rs = sta.executeQuery("select * from my_book where BookClass='" + BookClass + "'");
            if (rs == null)
                rs.beforeFirst();
            while (rs.next()) {
                My_Book book = new My_Book();
                book.setId(rs.getInt("Id"));
                book.setBookName(rs.getString("BookName"));
                book.setBookClass(rs.getString("BookClass"));
                book.setAuthor(rs.getString("Author"));
                book.setPublish(rs.getString("Publish"));
                book.setBookNo(rs.getString("BookNo"));
                book.setConternt(rs.getString("Content"));
                book.setPrince(rs.getFloat("Prince"));
                book.setAmount(rs.getInt("Amount"));
                book.setLeav_number(rs.getInt("Leav_number"));
                books.add(book);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return books;
    }

    @Override
    public void addts(String BookName, String Author, String Publish, String BookClass, String BookNo,
                      String Prince, String Amount, String Content) {

        Date date = new Date(23);
        Timestamp s = new Timestamp(date.getTime());
        try {
            DBUtil cons = new DBUtil();
            con = cons.getConnection();
            sta = con.createStatement();
            int count = sta.executeUpdate("insert into my_book(BookName,Author,Publish,BookClass,BookNo,Prince," +
                    "Amount,Content,RegTime)values ('" + BookName + "','" + Author + "','" + Publish + "','" + BookClass + "','" + BookNo + "'," +
                    "'" + Prince + "','" + Amount + "','" + Content + "','" + s + "')");
            if (count != 0)
                System.out.println("插入成功");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public ArrayList<My_Book> select() {
        ArrayList<My_Book> books = new ArrayList<My_Book>();
        try {
            DBUtil cons = new DBUtil();
            con = cons.getConnection();
           /* sta = con.createStatement();*/
            String sql="select * from my_book";
            pre=con.prepareStatement(sql,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
            /*rs=sta.executeQuery("select * from my_book");*/
            rs= pre.executeQuery();
            rs.beforeFirst();
            while (rs.next()) {
                My_Book book = new My_Book();
                book.setId(rs.getInt("Id"));
                book.setBookName(rs.getString("BookName"));
                book.setBookClass(rs.getString("BookClass"));
                book.setAuthor(rs.getString("Author"));
                book.setPublish(rs.getString("Publish"));
                book.setBookNo(rs.getString("BookNo"));
                book.setConternt(rs.getString("Content"));
                book.setPrince(rs.getFloat("Prince"));
                book.setAmount(rs.getInt("Amount"));
                book.setLeav_number(rs.getInt("Leav_number"));
                books.add(book);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return books;
    }


    @Override
    public void updatebook(int Id, float Prince, int Amount, int Leav_number) {
        try {
            DBUtil cons = new DBUtil();
            con = cons.getConnection();
            sta = con.createStatement();
            int count = sta.executeUpdate("update my_book set Prince='" + Prince + "',Amount='" + Amount + "'," +
                    "Leav_number='" + Leav_number + "'where Id='" + Id + "'");
            if (count != 0)
                System.out.println("修改成功");
        } catch (SQLException e) {
            e.printStackTrace();

        }
    }

    public void deletebook(int Id) {
        try {
            DBUtil cons = new DBUtil();
            con = cons.getConnection();
            sta = con.createStatement();
            int count = sta.executeUpdate("delete from my_book where Id='" + Id + "'");
            if (count != 0)
                System.out.println("删除成功");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public ArrayList<My_Book> select(String BookName) {
        ArrayList<My_Book> books = new ArrayList<My_Book>();
        try {
            DBUtil cons = new DBUtil();
            con = cons.getConnection();
            PreparedStatement sta = con.prepareStatement("select *from my_book where BookName='" + BookName + "'");
            rs = sta.executeQuery();
            while (rs.next()) {
                My_Book book = new My_Book();
                book.setId(rs.getInt("Id"));
                book.setBookName(rs.getString("BookName"));
                book.setBookClass(rs.getString("BookClass"));
                book.setAuthor(rs.getString("Author"));
                book.setPublish(rs.getString("Publish"));
                book.setBookNo(rs.getString("BookNo"));
                book.setConternt(rs.getString("Content"));
                book.setPrince(rs.getFloat("Prince"));
                book.setAmount(rs.getInt("Amount"));
                book.setLeav_number(rs.getInt("Leav_number"));
                books.add(book);
                if (books != null)
                    System.out.println("&&&&&&&");
                return books;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;

    }

    @Override
    public void xgyh(int id, String PassWord, String Address, String Phone, String Post, String Email) {
        //修改用户信息
        ArrayList<My_Book> books = new ArrayList<My_Book>();
        try {
            DBUtil cons = new DBUtil();
            con = cons.getConnection();
            sta = con.createStatement();
            System.out.println(id);
            System.out.println(PassWord);
            System.out.println(Address);
            System.out.println(Phone);
            System.out.println(Post);
            System.out.println(Email);
            sta.executeUpdate("update my_users set PassWord='" + PassWord + "',Address='" + Address + "',Phone='" +
                    Phone + "',Post='" + Post + "',Email='" + Email + "'where Id='" + id + "'");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
