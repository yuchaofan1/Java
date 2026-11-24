package yznu.cn.jgy.pojo;

public class My_cart {
    private int userId;
    private String BookName;
    private String BookClass;
    private String Author;
    private float Prince;
    private int Amount;
    private int BookId;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getBookName() {
        return BookName;
    }

    public void setBookName(String bookName) {
        BookName = bookName;
    }

    public String getBookClass() {
        return BookClass;
    }

    public void setBookClass(String bookClass) {
        BookClass = bookClass;
    }

    public String getAuthor() {
        return Author;
    }

    public void setAuthor(String author) {
        Author = author;
    }

    public float getPrince() {
        return Prince;
    }

    public void setPrince(float prince) {
        Prince = prince;
    }

    public int getAmount() {
        return Amount;
    }

    public void setAmount(int amount) {
        Amount = amount;
    }

    public int getBookId() {
        return BookId;
    }

    public void setBookId(int bookId) {
        BookId = bookId;
    }
}
