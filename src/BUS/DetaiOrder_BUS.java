package BUS;

import java.util.List;

import DAO.DetailOrder_DAO;
import DTO.DetailOrder_DTO;

public class DetaiOrder_BUS {

    private DetailOrder_DAO detail_DAO = null;

    public DetaiOrder_BUS() {
        this.detail_DAO = new DetailOrder_DAO();
    }

    public List<DetailOrder_DTO> getAllStaff() {
        return detail_DAO.getAllDetail();
    }

    public boolean addStaff(DetailOrder_DTO d) {
        if (d == null)
            return false;
        int id = d.getId_order();
        DetailOrder_DTO tmp = detail_DAO.getDetailByIdOrder(id);
        if (tmp != null) {
            return false;
        } else {
            return detail_DAO.addDetail(d);
        }
    }

    public boolean updateStaff(DetailOrder_DTO d) {
        return d != null ? detail_DAO.updateDetail(d) : false;
    }

    public boolean deleteStaff(DetailOrder_DTO d) {
        return d != null ? detail_DAO.delDetail(d) : false;
    }
}
