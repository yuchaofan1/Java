package yznu.cn.jgy.dao.Interface;

import yznu.cn.jgy.pojo.My_Book;


import java.util.ArrayList;

public interface Idbp {
    public ArrayList<My_Book> select(int id);

    public ArrayList<My_Book> sousuo(String BookClass);

    public void addts(String BookName, String Author, String Publish, String BookClass,
                      String BookNo, String Prince, String Amount, String Content);

    public ArrayList<My_Book> select();

    public void updatebook(int Id, float Prince, int Amount, int Leav_number);

    public ArrayList<My_Book> select(String BookName);

    public void xgyh(int id, String PassWord, String Address, String Phone, String Post, String Email);
}
