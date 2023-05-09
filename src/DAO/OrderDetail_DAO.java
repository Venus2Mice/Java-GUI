package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DB_CONECT.DatabaseConnection;
import DTO.OrderDetail_DTO;

public class OrderDetail_DAO {

    public List<OrderDetail_DTO> getAllDetailByID(int id_order) {
        List<OrderDetail_DTO> detailList;
        detailList = new ArrayList<OrderDetail_DTO>();
        try {
            String sqlQuery = "SELECT * FROM `libarymanager`.`chi_tiet_muontra` WHERE `id_muontra` = ? ";
            PreparedStatement pstmt = DatabaseConnection.getInstance().getConnection().prepareStatement(sqlQuery);
            pstmt.setInt(1, id_order);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                OrderDetail_DTO p = new OrderDetail_DTO();
                p.setId_order(rs.getInt("id_muontra"));
                p.setIsbn_book(rs.getString("isbn_book"));
                detailList.add(p);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return detailList;
    }

    public List<OrderDetail_DTO> getAllDetail() {
        List<OrderDetail_DTO> detailList;
        detailList = new ArrayList<OrderDetail_DTO>();
        try {
            String sqlQuery = "SELECT * FROM `libarymanager`.`chi_tiet_muontra`";
            PreparedStatement pstmt = DatabaseConnection.getInstance().getConnection().prepareStatement(sqlQuery);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                OrderDetail_DTO p = new OrderDetail_DTO();
                p.setId_order(rs.getInt("id_muontra"));
                p.setIsbn_book(rs.getString("isbn_book"));
                detailList.add(p);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return detailList;
    }

    public OrderDetail_DTO getDetailByIdAndIsbn(String isbn, int id) {
        try {
            String sqlQuery = "SELECT * FROM `libarymanager`.`chi_tiet_muontra` WHERE `id_muontra` = ? AND `isbn_book` = ? ";
            PreparedStatement pstmt = DatabaseConnection.getInstance().getConnection().prepareStatement(sqlQuery);
            pstmt.setInt(1, id);
            pstmt.setString(2, isbn);
            OrderDetail_DTO o = new OrderDetail_DTO();
            ResultSet rs = pstmt.executeQuery();
            boolean check = false;

            while (rs.next()) {
                check = true;
                OrderDetail_DTO p = new OrderDetail_DTO();
                p.setId_order(rs.getInt("id_muontra"));
                p.setIsbn_book(rs.getString("isbn_book"));

            }
            if (check) {
                return o;
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        return null;
    }

    public boolean addBookIntoDetail(int id_order, String isbn_book) {
        try {
            String sql = "INSERT INTO `libarymanager`.`chi_tiet_muontra` VALUES(?,?)";
            PreparedStatement pstmt = DatabaseConnection.getInstance().getConnection().prepareStatement(sql);
            pstmt.setString(2, isbn_book);
            pstmt.setInt(1, id_order);
            if (pstmt.executeUpdate() >= 1) {
                return true;
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return false;
    }

    public boolean delBookFromDetail(int id_order, String isbn_book) {
        try {
            String sqlUpdate = "DELETE FROM `libarymanager`.`chi_tiet_muontra`"
                    + "\nWHERE id_muontra = ? AND isbn_book = ? ";
            PreparedStatement pstmt = DatabaseConnection.getInstance().getConnection().prepareStatement(sqlUpdate);
            pstmt.setInt(1, id_order);
            pstmt.setString(2, isbn_book);
            if (pstmt.executeUpdate() >= 1) {
                return true;
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return false;
    }

}
