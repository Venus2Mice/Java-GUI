package DTO;

public class Role_DTO {
    private int role_id;
    private boolean crud_user;
    private boolean crud_book;
    private boolean crud_orders;
    private boolean crud_cardlib;

    public int getRole_id() {
        return role_id;
    }

    public void setRole_id(int role_id) {
        this.role_id = role_id;
    }

    public boolean isCrud_user() {
        return crud_user;
    }

    public void setCrud_user(boolean crud_user) {
        this.crud_user = crud_user;
    }

    public boolean isCrud_book() {
        return crud_book;
    }

    public void setCrud_book(boolean crud_book) {
        this.crud_book = crud_book;
    }

    public boolean isCrud_cardlib() {
        return crud_cardlib;
    }

    public void setCrud_cardlib(boolean crud_cardlib) {
        this.crud_cardlib = crud_cardlib;
    }

    public boolean isCrud_orders() {
        return crud_orders;
    }

    public void setCrud_orders(boolean crud_orders) {
        this.crud_orders = crud_orders;
    }

}
