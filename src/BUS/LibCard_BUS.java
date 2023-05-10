package BUS;

import java.util.ArrayList;
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

    public boolean addLibCard(LibCard_DTO l) {
        if (l.getDay_init() == null || l.getExp_date() == null) {
            new MyDialog("Không để trống ngày trả", MyDialog.ERROR_DIALOG);
            return false;
        }
        Date dayinit = l.getDay_init();
        Date day_exp = l.getExp_date();
        int cp = dayinit.compareTo(day_exp);
        if (cp == 0) {
            new MyDialog("Lỗi ngày hết hạn cùng ngày tạo", MyDialog.ERROR_DIALOG);
            return false;
        }
        if (cp > 0) {
            new MyDialog("Lỗi ngày hết hạn sau ngày tạo", MyDialog.ERROR_DIALOG);
            return false;
        }

        int id = l.getCard_id();
        LibCard_DTO tmp = libCard_DAO.getLibCardById(id);
        if (tmp != null) {
            return false;
        } else {
            return l != null ? libCard_DAO.addLibCard(l) : false;
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

    public boolean deleteLibCard(int id) {
        int action = new MyDialog("Xóa ?", MyDialog.WARNING_DIALOG).getAction();
        if (action == 1) {
            new MyDialog("Xóa thành công ", MyDialog.SUCCESS_DIALOG);
            return libCard_DAO.deleteLibCard(id);
        }
        return false;
    }

    public boolean updateLibCard(LibCard_DTO l) {
        if (l.getDay_init() == null || l.getExp_date() == null) {
            new MyDialog("Không để trống ngày trả", MyDialog.ERROR_DIALOG);
            return false;
        }
        Date dayinit = l.getDay_init();
        Date day_exp = l.getExp_date();
        int cp = dayinit.compareTo(day_exp);
        if (cp == 0) {
            new MyDialog("Lỗi ngày hết hạn cùng ngày tạo", MyDialog.ERROR_DIALOG);
            return false;
        }
        if (cp > 0) {
            new MyDialog("Lỗi ngày hết hạn sau ngày tạo", MyDialog.ERROR_DIALOG);
            return false;
        }
        return l != null ? libCard_DAO.updateLibCard(l) : false;
    }

    public ArrayList<LibCard_DTO> findByKey(String key) {
        ArrayList<LibCard_DTO> list = new ArrayList<>();
        key = key.toLowerCase();
        for (LibCard_DTO b : libCard_DAO.getAllLibCard()) {
            String id = b.getCard_id() + "".toLowerCase();
            String name = b.getName().toLowerCase();
            String dayinit = b.getDay_init() + "".toLowerCase();
            String day_exp = b.getExp_date() + "".toLowerCase();
            String desc = b.getDesc().toLowerCase();
            if (id.contains(key) || name.contains(key) || dayinit.contains(key) || day_exp.contains(key)
                    || desc.contains(key)) {
                list.add(b);
            }
        }
        return list;
    }

}
