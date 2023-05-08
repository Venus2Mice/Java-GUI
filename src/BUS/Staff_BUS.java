package BUS;

import java.util.List;

import DAO.Staff_DAO;
import DTO.Staff_DTO;
import GUI.MyCustom.MyDialog;

public class Staff_BUS {

    private final static int EMPTY_ERROR = -1;
    private final static int WRONG_ERROR = -2;

    public static Staff_DTO staff_DTO_current_login = null;

    private Staff_DAO staff_DAO = null;

    public Staff_BUS() {
        this.staff_DAO = new Staff_DAO();
    }

    public List<Staff_DTO> getAllStaff() {
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

    private int checkLogin(String username, String password) {
        username = username.replaceAll("\\s+", "");
        password = password.replaceAll("\\s+", "");

        if (username.length() <= 0 || password.length() <= 0)
            return EMPTY_ERROR;

        if (staff_DAO.getAccountId(username, password) == 0) {
            return WRONG_ERROR;
        }
        return staff_DAO.getAccountId(username, password);
    }

    public Staff_DTO Login(String username, String password) {
        if (checkLogin(username, password) == EMPTY_ERROR) {
            new MyDialog("Không được để trống thông tin!", MyDialog.ERROR_DIALOG);
            return null;
        }

        else if (checkLogin(username, password) == WRONG_ERROR) {
            new MyDialog("Sai thông tin đăng nhặp", MyDialog.ERROR_DIALOG);
            return null;
        }

        Staff_DTO s = staff_DAO.getStaffById(staff_DAO.getAccountId(username, password));
        Role_BUS role_BUS = new Role_BUS();
        if (role_BUS.checkQuyen(s.getGroup_name())) {
            new MyDialog("Đăng nhập thành công!", MyDialog.SUCCESS_DIALOG);
            staff_DTO_current_login = s;
        }
        return s;
    }

}
