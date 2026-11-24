package yznu.cn.jgy.pojo;

import java.sql.Date;

public class My_users {
    private int Id;
    private String UserName;
    private String PassWord;
    private String Names;
    private String Sex;
    private String Address;
    private String Phone;
    private String Post;
    private String Email;
    private Date RegTime;
    private String RegIpAddress;

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getPassWord() {
        return PassWord;
    }

    public void setPassWord(String passWord) {
        PassWord = passWord;
    }

    public String getNames() {
        return Names;
    }

    public void setNames(String names) {
        Names = names;
    }

    public String getSex() {
        return Sex;
    }

    public void setSex(String sex) {
        Sex = sex;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public String getPost() {
        return Post;
    }

    public void setPost(String post) {
        Post = post;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public Date getRegTime() {
        return RegTime;
    }

    public void setRegTime(Date regTime) {
        RegTime = regTime;
    }

    public String getRegIpAddress() {
        return RegIpAddress;
    }

    public void setRegIpAddress(String regIpAddress) {
        RegIpAddress = regIpAddress;
    }
}
