package DTO;

import java.sql.Date;

public class Order_DTO {
    private int order_id;
    private int card_id;
    private int staff_id;
    private Date day_init;

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public int getCard_id() {
        return card_id;
    }

    public void setCard_id(int card_id) {
        this.card_id = card_id;
    }

    public int getStaff_id() {
        return staff_id;
    }

    public void setStaff_id(int staff_id) {
        this.staff_id = staff_id;
    }

    public Date getDay_init() {
        return day_init;
    }

    public void setDay_init(Date day_init) {
        this.day_init = day_init;
    }

}
