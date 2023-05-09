package BUS;

import java.util.List;

import DAO.LibCard_DAO;
import DTO.LibCard_DTO;
import GUI.MyCustom.MyDialog;
import java.sql.Date;

public class LibCard_BUS {
    private LibCard_DAO libCard_DAO = null;

    public LibCard_BUS() {
        this.libCard_DAO = new LibCard_DAO();
    }

    public List<LibCard_DTO> getAllStaff() {
        return libCard_DAO.getAllLibCard();
    }

    public boolean addStaff(LibCard_DTO c) {
        if (c == null)
            return false;
        int id = c.getCard_id();
        LibCard_DTO tmp = libCard_DAO.getLibCardById(id);
        if (tmp != null) {
            return false;
        } else {
            return libCard_DAO.addLibCard(c);
        }
    }
    
    public LibCard_DTO initLibCard(Date start, Date expire, String desc, String name, String phone) {
        if (name.trim().equals("")) {
            new MyDialog("Vui lòng điền đầy đủ thông tin!", MyDialog.ERROR_DIALOG);
            return null;
        }
        LibCard_DTO libcard = new LibCard_DTO();
        libcard.setDay_init(start);
        libcard.setExp_date(expire);
        libcard.setDesc(desc);
        libcard.setName(name);
        libcard.setPhone(phone);
        return libcard;
    }
    
    public boolean addLibCard(LibCard_DTO l) {
        if (l == null) {
            new MyDialog("Thêm thất bại!", MyDialog.ERROR_DIALOG);
            return false;
        }
        return libCard_DAO.addLibCard(l);   
    }
    
    public boolean deleteLibCard(LibCard_DTO l) {
        if (l == null) {
            new MyDialog("Thêm thất bại!", MyDialog.ERROR_DIALOG);
            return false;
        }
        return libCard_DAO.deleteLibCard(l);
    }
    
    public boolean updateLibCard(LibCard_DTO l) {
        if (l == null) {
            new MyDialog("Thêm thất bại!", MyDialog.ERROR_DIALOG);
            return false;
        }
        return libCard_DAO.updateLibCard(l);
    }
    public boolean updateStaff(LibCard_DTO c) {
        return c != null ? libCard_DAO.updateLibCard(c) : false;
    }

    public boolean deleteStaff(LibCard_DTO c) {
        return c != null ? libCard_DAO.deleteLibCard(c) : false;
    }

}
