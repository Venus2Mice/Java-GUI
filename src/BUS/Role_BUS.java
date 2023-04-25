package BUS;

import java.util.List;

import DAO.Role_DAO;
import DTO.Role_DTO;

public class Role_BUS {
    private Role_DAO role_DAO = null;

    public Role_BUS() {
        this.role_DAO = new Role_DAO();
    }

    public List<Role_DTO> getAllStaff() {
        return role_DAO.getAllRole();
    }

    public boolean addStaff(Role_DTO r) {
        if (r == null)
            return false;
        int id = r.getRole_id();
        Role_DTO tmp = role_DAO.getRoleById(id);
        if (tmp != null) {
            return false;
        } else {
            return role_DAO.addRole(r);
        }
    }

    public boolean updateStaff(Role_DTO r) {
        return r != null ? role_DAO.updateRole(r) : false;
    }

    public boolean deleteStaff(Role_DTO r) {
        return r != null ? role_DAO.delRole(r) : false;
    }

}

