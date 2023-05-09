package DTO;

public class OrderDetail_DTO {
    private String isbn_book;
    private int id_order;

    public String getIsbn_book() {
        return isbn_book;
    }

    public void setIsbn_book(String isbn_book) {
        this.isbn_book = isbn_book;
    }

    public int getId_order() {
        return id_order;
    }

    public void setId_order(int id_order) {
        this.id_order = id_order;
    }
}
