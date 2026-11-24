package yznu.cn.jgy.dao.Interface;


import yznu.cn.jgy.pojo.My_Book;
import yznu.cn.jgy.pojo.My_cart;

import java.sql.Timestamp;
import java.util.ArrayList;

public interface ICart {
    public ArrayList<My_cart> select(int userId);

    public void add(ArrayList<My_Book> Book, int count, int userId, String BookName);

    public void update(int BookId,int Amount,String bookName,int leaveNumber );

    public void delete(int BookId, int id);

    public void delete(int id);

    public void qingkong(int id);

    public void tijiao(int id, String UserName, String IpAddress, Timestamp time);
}
