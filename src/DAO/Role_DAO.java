package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DB_CONECT.DatabaseConnection;
import DTO.Role_DTO;

public class Role_DAO {

    public List<Role_DTO> getAllRole() {
        List<Role_DTO> Rolelist;
        Rolelist = new ArrayList<Role_DTO>();
        try {
            String sqlQuery = "SELECT * FROM `libarymanager`.`quyen`";
            ResultSet rs = DatabaseConnection.getInstance().executeQuery(sqlQuery);
            while (rs.next()) {
                Role_DTO r = new Role_DTO();
                r.setRole_id(rs.getInt("id_quyen"));
                r.setCrud_user(rs.getBoolean("crud_user"));
                r.setCrud_book(rs.getBoolean("crud_book"));
                r.setCrud_orders(rs.getBoolean("crud_muontra"));
                r.setCrud_cardlib(rs.getBoolean("crud_thethuvien"));
                Rolelist.add(r);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return Rolelist;
    }

    public boolean addRole(Role_DTO r) {
        try {
            String sql = "INSERT INTO `libarymanager`.`quyen` VALUES(?,?,?,?,?)";
            PreparedStatement pstmt = DatabaseConnection.getInstance().getConnection().prepareStatement(sql);
            pstmt.setInt(1, r.getRole_id());
            pstmt.setBoolean(2, r.isCrud_user());
            pstmt.setBoolean(3, r.isCrud_book());
            pstmt.setBoolean(4, r.isCrud_orders());
            pstmt.setBoolean(5, r.isCrud_cardlib());
            if (pstmt.executeUpdate() >= 1) {
                return true;
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return false;
    }

    public boolean delRole(Role_DTO r) {
        try {
            String sqlUpdate = "DELETE FROM `libarymanager`.`quyen`"
                    + "\nWHERE id_quyen = ?";
            PreparedStatement pstmt = DatabaseConnection.getInstance().getConnection().prepareStatement(sqlUpdate);
            pstmt.setInt(1, r.getRole_id());
            if (pstmt.executeUpdate() >= 1) {
                return true;
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return false;
    }

    public Role_DTO getRoleById(int id) {
        try {
            String sql = "SELECT * FROM `libarymanager`.`quyen` WHERE id_quyen = ?";
            PreparedStatement pstmt = DatabaseConnection.getInstance().getConnection().prepareStatement(sql);
            pstmt.setInt(1, id);
            Role_DTO r = new Role_DTO();
            ResultSet rs = pstmt.executeQuery();
            boolean check = false;

            while (rs.next()) {
                check = true;
                r.setRole_id(rs.getInt("id_quyen"));
                r.setCrud_user(rs.getBoolean("crud_user"));
                r.setCrud_book(rs.getBoolean("crud_book"));
                r.setCrud_orders(rs.getBoolean("crud_muontra"));
                r.setCrud_cardlib(rs.getBoolean("crud_thethuvien"));
            }

            if (check) {
                return r;
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }

    public boolean updateRole(Role_DTO r) {
        try {
            String sqlUpdate = "UPDATE `libarymanager`.`quyen`"
                    + "\nSET \n crud_user = ?, crud_book = ?, curd_muontra = ?, crud_thethuvien = ?"
                    + "\nWHERE id_quyen = ?";
            PreparedStatement pstmt = DatabaseConnection.getInstance().getConnection().prepareStatement(sqlUpdate);
            pstmt.setBoolean(1, r.isCrud_user());
            pstmt.setBoolean(2, r.isCrud_book());
            pstmt.setBoolean(3, r.isCrud_orders());
            pstmt.setBoolean(4, r.isCrud_cardlib());
            pstmt.setInt(5, r.getRole_id());
            if (pstmt.executeUpdate() >= 1) {
                return true;
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return false;
    }
}
