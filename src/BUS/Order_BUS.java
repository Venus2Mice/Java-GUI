package BUS;

import java.util.ArrayList;
import java.util.List;

import DAO.Order_DAO;
import DTO.Order_DTO;

public class Order_BUS {
    private Order_DAO order_DAO = null;

    public Order_BUS() {
        this.order_DAO = new Order_DAO();
    }

    public List<Order_DTO> getAllOrder() {
        return order_DAO.getAllOrder();
    }

    public boolean addOrder(Order_DTO o) {
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

    public boolean updateOrder(Order_DTO o) {
        return o != null ? order_DAO.updateOrder(o) : false;
    }

    public boolean deleteOrder(Order_DTO o) {
        return o != null ? order_DAO.delOrder(o) : false;
    }

    public ArrayList<Order_DTO> findByKey(String key) {
        ArrayList<Order_DTO> list = new ArrayList<>();
        key = key.toLowerCase();
        for (Order_DTO b : order_DAO.getAllOrder()) {
            String id = b.getOrder_id()+"".toLowerCase();
            String id_libcard = b.getCard_id()+"".toLowerCase();
            String id_staff = b.getStaff_id()+"".toLowerCase();
            String dayinit = b.getDay_init()+"".toLowerCase();
            String desc = b.getDesc().toLowerCase();
            String dayretrun = b.getDay_return()+"".toLowerCase();
            if (id.contains(key) || id_libcard.contains(key) || id_staff.contains(key) || dayinit.contains(key) || desc.contains(key) || dayretrun.contains(key) ) {
                list.add(b);
            }
        }
        return list;
    }

}
