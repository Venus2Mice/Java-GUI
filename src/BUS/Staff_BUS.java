package BUS;

import java.util.List;

import DAO.Staff_DAO;
import DTO.Staff_DTO;

public class Staff_BUS {
    private Staff_DAO staff_DAO = null;

    public Staff_BUS() {
        this.staff_DAO = new Staff_DAO();
    }

    public List<Staff_DTO> getAllStaff(){
        return staff_DAO.getAllStaff();
    }
    
    public boolean addStaff(Staff_DTO s) {
        if (s == null)
            return false;
        int id = s.getId_staff();
        Staff_DTO tmp = staff_DAO.getStaffById(id);
        if (tmp != null) {
            return false;
        } else {
            return staff_DAO.addStaff(s);
        }
    }
    public boolean updateStaff(Staff_DTO s) {
        return s != null ? staff_DAO.updateStaff(s) : false;
    }

    public boolean deleteStaff(Staff_DTO s) {
        return s != null ? staff_DAO.deleteStaff(s) : false;
    }

    public boolean setActive(int id, boolean active) {
        return staff_DAO.setActive(id, active);
    }
    
}
