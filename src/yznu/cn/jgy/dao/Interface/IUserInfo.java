package yznu.cn.jgy.dao.Interface;

import yznu.cn.jgy.pojo.My_users;

import java.util.ArrayList;

public interface IUserInfo {
    public My_users getUaer(String UserName);//跟据用户名和密码获取用户

    public My_users getUser(String UserName, String PassWord);//跟据用户名和密码获取用户

    public boolean addUser(My_users u);//注册新用户，加入到用户表

    public ArrayList<My_users> select(int id);//根据用户id获取用户

    public void delete(int id);//根据用户id获取用户
}
