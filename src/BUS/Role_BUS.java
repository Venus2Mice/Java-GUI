package BUS;

import java.util.List;

import DAO.Role_DAO;
import DTO.Role_DTO;

public class Role_BUS {

    public static Role_DTO dsquyen = null ;


    private Role_DAO role_DAO = null;

    public Role_BUS() {
        this.role_DAO = new Role_DAO();
    }

    public List<Role_DTO> getAllRole() {
        return role_DAO.getAllRole();
    }

    public boolean checkQuyen(String grp){
        int idRole = role_DAO.checkGrpExist(grp);
        dsquyen = role_DAO.getRoleById(idRole);
        return dsquyen!=null;
    } 

    public boolean addRole(Role_DTO r) {
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

    public boolean updateRole(Role_DTO r) {
        return r != null ? role_DAO.updateRole(r) : false;
    }

    public boolean deleteRole(Role_DTO r) {
        return r != null ? role_DAO.delRole(r) : false;
    }

}

