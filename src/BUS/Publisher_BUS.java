package BUS;

import java.util.ArrayList;
import java.util.List;

import DAO.Publisher_DAO;
import DTO.Publisher_DTO;
import GUI.MyCustom.MyDialog;

public class Publisher_BUS {
    private Publisher_DAO pub_DAO = null;

    public Publisher_BUS() {
        this.pub_DAO = new Publisher_DAO();
    }

    public List<Publisher_DTO> getAllPub() {
        return pub_DAO.getAllPub();
    }

    public boolean addPub(Publisher_DTO p) {
        if (p == null) {
            new MyDialog("Thêm thất bại!", MyDialog.ERROR_DIALOG);
            return false;
        }
        int id = p.getPubliser_id();
        Publisher_DTO tmp = pub_DAO.getPubById(id);
        if (tmp != null) {
            new MyDialog("Thêm thất bại!", MyDialog.ERROR_DIALOG);
            return false;
        } else {
            new MyDialog("Thêm thành công!", MyDialog.SUCCESS_DIALOG);
            return pub_DAO.addPub(p);
        }
    }

    public Publisher_DTO findByName(String name) {
        for (Publisher_DTO pub : pub_DAO.getAllPub()) {
            if (pub.getPublisher_name().equals(name)) {
                return pub;
            }
        }
        return null;
    }

    public Publisher_DTO initPub(String id, String name, String adress, String email) {
        if (name.trim().equals("") || email.trim().equals("")) {
            new MyDialog("Vui lòng điền đầy đủ thông tin!", MyDialog.ERROR_DIALOG);
            return null;
        }
        Publisher_DTO pub = new Publisher_DTO();
        try {
            pub.setPubliser_id(Integer.parseInt(id));
        } catch (NumberFormatException e) {
        }
        pub.setPublisher_name(name);
        pub.setAdress(adress);
        pub.setEmail(email);
        return pub;
    }

    public boolean updatePub(Publisher_DTO p) {
        if (p != null) {
            new MyDialog("Sửa thành công!", MyDialog.SUCCESS_DIALOG);
            return pub_DAO.updatePub(p);
        }
        new MyDialog("Sửa thất bại!", MyDialog.ERROR_DIALOG);
        return false;
    }

    public boolean deletePub(Publisher_DTO p) {
        if (p != null) {
            new MyDialog("Xóa thành công!", MyDialog.SUCCESS_DIALOG);
            return pub_DAO.delPub(p);
        }
        new MyDialog("Xóa thất bại!", MyDialog.ERROR_DIALOG);
        return false;
    }

    public ArrayList<Publisher_DTO> findByKey(String key) {
        ArrayList<Publisher_DTO> list = new ArrayList<>();
        key = key.toLowerCase();
        for (Publisher_DTO p : pub_DAO.getAllPub()) {
            String name = p.getPublisher_name().toLowerCase();
            String adress = p.getAdress().toLowerCase();
            String email = p.getEmail().toLowerCase();
            if (name.contains(key) || adress.contains(key) || email.contains(key)) {
                list.add(p);
            }
        }
        return list;
    }

}
