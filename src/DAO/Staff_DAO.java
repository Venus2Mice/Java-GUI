package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DB_CONECT.DatabaseConnection;
import DTO.Staff_DTO;

public class Staff_DAO {


    public boolean addStaff(Staff_DTO s) {
        try {
            String sql = "INSERT INTO `libarymanager`.`nhan_vien` VALUES(?,?,?,?,?,?,?,?)";
            PreparedStatement pstmt = DatabaseConnection.getInstance().getConnection().prepareStatement(sql);
            pstmt.setInt(1, s.getId_staff());
            pstmt.setString(2, s.getStaff_name());
            pstmt.setDate(3, s.getBrith());
            pstmt.setInt(4, s.getPhone());
            pstmt.setString(5, s.getGroup_name());
            pstmt.setString(6, s.getUsername());
            pstmt.setString(7, s.getPassword());
            pstmt.setBoolean(8, s.isActive());
            if (pstmt.executeUpdate() >= 1) {
                return true;
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return false;
    }


    public boolean deleteStaff(Staff_DTO s) {
        try {
            String sqlUpdate = "DELETE FROM `libarymanager`.`nhan_vien`"
                    + "\nWHERE id_nv = ?";
            PreparedStatement pstmt = DatabaseConnection.getInstance().getConnection().prepareStatement(sqlUpdate);
            pstmt.setInt(1, s.getId_staff());
            if (pstmt.executeUpdate() >= 1) {
                return true;
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return false;
    }


    public List<Staff_DTO> getAllStaff() {
        List<Staff_DTO> staff_list;
        staff_list = new ArrayList<Staff_DTO>();
        try {
            String sqlQuery = "SELECT * FROM `libarymanager`.`nhan_vien`";
            ResultSet rs = DatabaseConnection.getInstance().executeQuery(sqlQuery);
            while (rs.next()) {
                Staff_DTO s = new Staff_DTO();
                s.setId_staff(rs.getInt("id_nv"));
                s.setStaff_name(rs.getString("ten_nv"));
                s.setBrith(rs.getDate("ngay_sinh"));
                s.setPhone(rs.getInt("phone"));
                s.setGroup_name(rs.getString("ten_nhom"));
                s.setUsername(rs.getString("username"));
                s.setPassword(rs.getString("password"));
                s.setActive(rs.getBoolean("status"));
                staff_list.add(s);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return staff_list;
    }


    public Staff_DTO getStaffByName(String name) {
        try {
            String sql = "SELECT * FROM `libarymanager`.`nhan_vien` WHERE ten_nv = ?";
            PreparedStatement pstmt = DatabaseConnection.getInstance().getConnection().prepareStatement(sql);
            pstmt.setString(1, name);
            Staff_DTO s = new Staff_DTO();
            ResultSet rs = pstmt.executeQuery();
            boolean check = false;

            while (rs.next()) {
                check = true;
                s.setId_staff(rs.getInt("id_nv"));
                s.setStaff_name(rs.getString("ten_nv"));
                s.setBrith(rs.getDate("BIRTH"));
                s.setPhone(rs.getInt("phone"));
                s.setGroup_name(rs.getString("ten_nhom"));
                s.setUsername(rs.getString("username"));
                s.setPassword(rs.getString("password"));
                s.setActive(rs.getBoolean("status"));
            }

            if (check) {
                return s;
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }

    public Staff_DTO getStaffById(int id) {
        try {
            String sql = "SELECT * FROM `libarymanager`.`nhan_vien` WHERE id_nv = ?";
            PreparedStatement pstmt = DatabaseConnection.getInstance().getConnection().prepareStatement(sql);
            pstmt.setInt(1, id);
            Staff_DTO s = new Staff_DTO();
            ResultSet rs = pstmt.executeQuery();
            boolean check = false;

            while (rs.next()) {
                check = true;
                s.setId_staff(rs.getInt("id_nv"));
                s.setStaff_name(rs.getString("ten_nv"));
                s.setBrith(rs.getDate("BIRTH"));
                s.setPhone(rs.getInt("phone"));
                s.setGroup_name(rs.getString("ten_nhom"));
                s.setUsername(rs.getString("username"));
                s.setPassword(rs.getString("password"));
                s.setActive(rs.getBoolean("status"));
            }

            if (check) {
                return s;
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }


    public boolean updateStaff(Staff_DTO s) {
        try {
            String sqlUpdate = "UPDATE `libarymanager`.`nhan_vien`"
                    + "\nSET \nten_nv = ?, BIRTH = ?, phone = ?,"
                    + "ten_nhom = ?, username = ?, password = ?, status = ?"
                    + "\nWHERE id_nv = ?";
            PreparedStatement pstmt = DatabaseConnection.getInstance().getConnection().prepareStatement(sqlUpdate);
            pstmt.setInt(8, s.getId_staff());
            pstmt.setString(1, s.getStaff_name());
            pstmt.setDate(2, s.getBrith());
            pstmt.setInt(3, s.getPhone());
            pstmt.setString(4, s.getGroup_name());
            pstmt.setString(5, s.getUsername());
            pstmt.setString(6, s.getPassword());
            pstmt.setBoolean(7, s.isActive());
            if (pstmt.executeUpdate() >= 1) {
                return true;
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return false;
    }


    public boolean setActive(int id, boolean active) {
        try {
            String sqlUpdate = "UPDATE `libarymanager`.`nhan_vien`"
                    + "\nSET status = ?"
                    + "\nWHERE id_nv = ?";
            PreparedStatement pstmt = DatabaseConnection.getInstance().getConnection().prepareStatement(sqlUpdate);
            pstmt.setBoolean(1, active);
            pstmt.setInt(2, id);
            if (pstmt.executeUpdate() >= 1) {
                return true;
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return false;
    }
}
