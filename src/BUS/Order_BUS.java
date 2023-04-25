package BUS;

import java.util.List;

import DAO.Order_DAO;
import DTO.Order_DTO;

public class Order_BUS {
    private Order_DAO order_DAO = null;

    public Order_BUS() {
        this.order_DAO = new Order_DAO();
    }

    public List<Order_DTO> getAllStaff() {
        return order_DAO.getAllOrder();
    }

    public boolean addStaff(Order_DTO o) {
        if (o == null)
            return false;
        int id = o.getOrder_id();
        Order_DTO tmp = order_DAO.getOrderById(id);
        if (tmp != null) {
            return false;
        } else {
            return order_DAO.addOrder(o);
        }
    }

    public boolean updateStaff(Order_DTO o) {
        return o != null ? order_DAO.updateOrder(o) : false;
    }

    public boolean deleteStaff(Order_DTO o) {
        return o != null ? order_DAO.delOrder(o) : false;
    }

}
