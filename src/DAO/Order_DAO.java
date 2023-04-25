package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DB_CONECT.DatabaseConnection;
import DTO.Order_DTO;

public class Order_DAO {

    public List<Order_DTO> getAllOrder() {
        List<Order_DTO> Oderlist;
        Oderlist = new ArrayList<Order_DTO>();
        try {
            String sqlQuery = "SELECT * FROM `libarymanager`.`phieu_muontra`";
            ResultSet rs = DatabaseConnection.getInstance().executeQuery(sqlQuery);
            while (rs.next()) {
                Order_DTO o = new Order_DTO();
                o.setOrder_id(rs.getInt("id"));
                o.setCard_id(rs.getInt("id_the"));
                o.setStaff_id(rs.getInt("id_nv"));
                o.setDay_init(rs.getDate("ngay_tao"));
                Oderlist.add(o);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return Oderlist;
    }

    public boolean addOrder(Order_DTO o) {
        try {
            String sql = "INSERT INTO `libarymanager`.`phieu_muontra` VALUES(?,?,?,?,?,?,?,?,?)";
            PreparedStatement pstmt = DatabaseConnection.getInstance().getConnection().prepareStatement(sql);
            pstmt.setInt(1, o.getOrder_id());
            pstmt.setInt(2, o.getCard_id());
            pstmt.setInt(3, o.getStaff_id());
            pstmt.setDate(4, o.getDay_init());
            if (pstmt.executeUpdate() >= 1) {
                return true;
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return false;
    }

    public boolean delOrder(Order_DTO o) {
        try {
            String sqlUpdate = "DELETE FROM `libarymanager`.`phieu_muontra`"
                    + "\nWHERE id = ?";
            PreparedStatement pstmt = DatabaseConnection.getInstance().getConnection().prepareStatement(sqlUpdate);
            pstmt.setInt(1, o.getOrder_id());
            if (pstmt.executeUpdate() >= 1) {
                return true;
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return false;
    }

    public Order_DTO getOrderById(int id) {
        try {
            String sql = "SELECT * FROM `libarymanager`.`phieu_muontra` WHERE id = ?";
            PreparedStatement pstmt = DatabaseConnection.getInstance().getConnection().prepareStatement(sql);
            pstmt.setInt(1, id);
            Order_DTO o = new Order_DTO();
            ResultSet rs = pstmt.executeQuery();
            boolean check = false;

            while (rs.next()) {
                check = true;
                o.setOrder_id(rs.getInt("id"));
                o.setCard_id(rs.getInt("id_the"));
                o.setStaff_id(rs.getInt("id_nv"));
                o.setDay_init(rs.getDate("ngay_tao"));
            }

            if (check) {
                return o;
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }

    public boolean updateOrder(Order_DTO o) {
        try {
            String sqlUpdate = "UPDATE `libarymanager`.`phieu_muontra`"
                    + "\nSET \nid_the = ?, id_nv = ?, ngay_tao = ?"
                    + "\nWHERE id = ?";
            PreparedStatement pstmt = DatabaseConnection.getInstance().getConnection().prepareStatement(sqlUpdate);
            pstmt.setInt(1, o.getCard_id());
            pstmt.setInt(2, o.getStaff_id());
            pstmt.setDate(3, o.getDay_init());
            pstmt.setInt(4, o.getOrder_id());
            if (pstmt.executeUpdate() >= 1) {
                return true;
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return false;
    }
}
