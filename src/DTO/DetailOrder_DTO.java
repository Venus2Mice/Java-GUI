package DTO;

import java.sql.Date;

public class DetailOrder_DTO {
    private int id_order;
    private String isbn_book;
    private String desc;
    private Date day_return;
    private boolean status;

    public int getId_order() {
        return id_order;
    }

    public void setId_order(int id_order) {
        this.id_order = id_order;
    }

    public String getIsbn_book() {
        return isbn_book;
    }

    public void setIsbn_book(String isbn_book) {
        this.isbn_book = isbn_book;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Date getDay_return() {
        return day_return;
    }

    public void setDay_return(Date day_return) {
        this.day_return = day_return;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

}
