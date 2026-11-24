package yznu.cn.jgy.pojo;

import java.sql.Timestamp;
import java.util.Date;

public class My_order {
    private int IndentNo;
    private int UserId;
    private String UserName;
    Date date = new Date();
    private Timestamp SubmitTime;
    private Timestamp ConsignmentTime;
    private float TotaPeice;
    private String content;
    private String IPAddress;
    private String IsPayoff;
    private String IsSales;
    private String BookName;

    public int getIndentNo() {
        return IndentNo;
    }

    public void setIndentNo(int indentNo) {
        IndentNo = indentNo;
    }

    public int getUserId() {
        return UserId;
    }

    public void setUserId(int userId) {
        UserId = userId;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Timestamp getSubmitTime() {
        return SubmitTime;
    }

    public void setSubmitTime(Timestamp submitTime) {
        SubmitTime = submitTime;
    }

    public Timestamp getConsignmentTime() {
        return ConsignmentTime;
    }

    public void setConsignmentTime(Timestamp consignmentTime) {
        ConsignmentTime = consignmentTime;
    }

    public float getTotaPeice() {
        return TotaPeice;
    }

    public void setTotaPeice(float totaPeice) {
        TotaPeice = totaPeice;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getIPAddress() {
        return IPAddress;
    }

    public void setIPAddress(String IPAddress) {
        this.IPAddress = IPAddress;
    }

    public String getIsPayoff() {
        return IsPayoff;
    }

    public void setIsPayoff(String isPayoff) {
        IsPayoff = isPayoff;
    }

    public String getIsSales() {
        return IsSales;
    }

    public void setIsSales(String isSales) {
        IsSales = isSales;
    }

    public String getBookName() {
        return BookName;
    }

    public void setBookName(String bookName) {
        BookName = bookName;
    }
}
