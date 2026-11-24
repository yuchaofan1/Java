package yznu.cn.jgy.dao.Interface;

import yznu.cn.jgy.pojo.My_order;

import java.sql.Timestamp;
import java.util.ArrayList;

public interface Idbpindent {
    public void insert(float s, Timestamp time, int id, String UserName, String IpAddress) ;//添加订单
    public ArrayList<My_order> select(int id);//根据 id 查询订单
    public ArrayList<My_order> st(int IndentNo);//根据 IndentNo 查询订单
    public ArrayList<My_order> select();//查询所有订单
    public void delete(int BookId,int id);//根据 BookId 和id 删除订单
    public void deleteindent(int IndentNo);//根据 IndentNo 删除订单
    public void update();//发货
    public void updateddxx(int IndentNo,String fk,String jh);//修改订单信息
}
