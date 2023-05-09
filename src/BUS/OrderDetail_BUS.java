package BUS;

import java.util.List;

import DAO.OrderDetail_DAO;
import DTO.OrderDetail_DTO;
import GUI.MyCustom.MyDialog;

public class OrderDetail_BUS {
    private OrderDetail_DAO orderDetail_DAO = null;

    public OrderDetail_BUS() {
        this.orderDetail_DAO = new OrderDetail_DAO();
    }

    public List<OrderDetail_DTO> getAllDetailById(int id_order) {
        return orderDetail_DAO.getAllDetailByID(id_order);
    }

    public boolean addBookIntoOrder(String isbn_book, int id_order) {
        if (isbn_book == null || id_order < 0) {
            new MyDialog("Thêm thất bại!", MyDialog.ERROR_DIALOG);
            return false;
        }
        OrderDetail_DTO tmp = orderDetail_DAO.getDetailByIdAndIsbn(isbn_book, id_order);
        if (tmp != null) {
            new MyDialog("Thêm thất bại!", MyDialog.ERROR_DIALOG);
            return false;
        } else {
            new MyDialog("Thêm thành công!", MyDialog.SUCCESS_DIALOG);
            return orderDetail_DAO.addBookIntoDetail(id_order, isbn_book);
        }
    }

    public boolean dell (String isbn , int id){
        return orderDetail_DAO.delBookFromDetail(id, isbn);
    }

    public OrderDetail_DTO get (String isbn , int id){
        return orderDetail_DAO.getDetailByIdAndIsbn(isbn, id);
    }

}
