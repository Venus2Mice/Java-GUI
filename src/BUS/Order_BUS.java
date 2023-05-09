package BUS;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;

import DAO.Order_DAO;
import DTO.Order_DTO;
import GUI.MyCustom.MyDialog;

public class Order_BUS {
    private Order_DAO order_DAO = null;

    public Order_BUS() {
        this.order_DAO = new Order_DAO();
    }

    public List<Order_DTO> getAllOrder() {
        return order_DAO.getAllOrder();
    }

    public int addOrder(Order_DTO o) {
        if (o == null)
            return -1;
        int id = o.getOrder_id();
        Order_DTO tmp = order_DAO.getOrderById(id);
        if (tmp != null) {
            return -1;
        } else {
            return order_DAO.addOrder(o);
        }
    }

    public boolean updateOrder(Order_DTO o) {
        if (o.getDay_return() == null) {
            new MyDialog("Không để trống ngày trả", MyDialog.ERROR_DIALOG);
            return false;
        }
        Date dayinit = o.getDay_init();
        Date dayreturn = o.getDay_return();
        int cp = dayinit.compareTo(dayreturn);
        if (cp == 0) {
            new MyDialog("Lỗi ngày trả cùng ngày tạo", MyDialog.ERROR_DIALOG);
            return false;
        }
        if (cp > 0) {
            new MyDialog("Lỗi ngày trả sau ngày tạo", MyDialog.ERROR_DIALOG);
            return false;
        }
        return o != null ? order_DAO.updateOrder(o) : false;
    }

    public boolean deleteOrder(int id) {
        int action = new MyDialog("Xóa ?", MyDialog.WARNING_DIALOG).getAction();
        if (action == 1) {
            new MyDialog("Xóa thành công ", MyDialog.SUCCESS_DIALOG);
            return order_DAO.delOrder(id);
        }
        return false;
    }

    public ArrayList<Order_DTO> findByKey(String key) {
        ArrayList<Order_DTO> list = new ArrayList<>();
        key = key.toLowerCase();
        for (Order_DTO b : order_DAO.getAllOrder()) {
            String id = b.getOrder_id() + "".toLowerCase();
            String id_libcard = b.getCard_id() + "".toLowerCase();
            String id_staff = b.getStaff_id() + "".toLowerCase();
            String dayinit = b.getDay_init() + "".toLowerCase();
            String desc = b.getDesc().toLowerCase();
            String dayretrun = b.getDay_return() + "".toLowerCase();
            if (id.contains(key) || id_libcard.contains(key) || id_staff.contains(key) || dayinit.contains(key)
                    || desc.contains(key) || dayretrun.contains(key)) {
                list.add(b);
            }
        }
        return list;
    }

}
