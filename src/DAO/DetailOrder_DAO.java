package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DB_CONECT.DatabaseConnection;
import DTO.DetailOrder_DTO;

public class DetailOrder_DAO {

    public List<DetailOrder_DTO> getAllDetail() {
        List<DetailOrder_DTO> detail_List;
        detail_List = new ArrayList<DetailOrder_DTO>();
        try {
            String sqlQuery = "SELECT * FROM `libarymanager`.`chi_tiet_muontra`";
            ResultSet rs = DatabaseConnection.getInstance().executeQuery(sqlQuery);
            while (rs.next()) {
                DetailOrder_DTO detail = new DetailOrder_DTO();
                detail.setId_order(rs.getInt("id_muontra"));
                detail.setIsbn_book(rs.getString("isbn_book"));
                detail.setDesc(rs.getString("desc"));
                detail.setDay_return((rs.getDate("ngay_tra")));
                detail.setStatus(rs.getBoolean("status"));
                detail_List.add(detail);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return detail_List;
    }

    public boolean addDetail(DetailOrder_DTO detail) {
        try {
            String sql = "INSERT INTO `libarymanager`.`chi_tiet_muontra` VALUES(?,?,?,?,?)";
            PreparedStatement pstmt = DatabaseConnection.getInstance().getConnection().prepareStatement(sql);
            pstmt.setInt(1, detail.getId_order());
            pstmt.setString(2, detail.getIsbn_book());
            pstmt.setString(3, detail.getDesc());
            pstmt.setBoolean(4, detail.isStatus());
            pstmt.setDate(5, detail.getDay_return());
            if (pstmt.executeUpdate() >= 1) {
                return true;
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return false;
    }

    public boolean delDetail(DetailOrder_DTO detail) {
        try {
            String sqlUpdate = "DELETE FROM `libarymanager`.`chi_tiet_muontra`"
                    + "\nWHERE id_muontra = ?";
            PreparedStatement pstmt = DatabaseConnection.getInstance().getConnection().prepareStatement(sqlUpdate);
            pstmt.setInt(1, detail.getId_order());
            if (pstmt.executeUpdate() >= 1) {
                return true;
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return false;
    }

    public DetailOrder_DTO getDetailByIdOrder(int id) {
        try {
            String sql = "SELECT * FROM `libarymanager`.`chi_tiet_muontra` WHERE id_muontra = ?";
            PreparedStatement pstmt = DatabaseConnection.getInstance().getConnection().prepareStatement(sql);
            pstmt.setInt(1, id);
            DetailOrder_DTO detail = new DetailOrder_DTO();
            ResultSet rs = pstmt.executeQuery();
            boolean check = false;

            while (rs.next()) {
                check = true;
                pstmt.setInt(1, detail.getId_order());
                pstmt.setString(2, detail.getIsbn_book());
                pstmt.setString(3, detail.getDesc());
                pstmt.setBoolean(4, detail.isStatus());
                pstmt.setDate(5, detail.getDay_return());
            }

            if (check) {
                return detail;
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }

    public boolean updateDetail(DetailOrder_DTO detail) {
        try {
            String sqlUpdate = "UPDATE `libarymanager`.`chi_tiet_muontra`"
                    + "\n SET \n isbn_book = ?, desc = ?, status = ? , ngay_tra=?"
                    + "\n WHERE id_muontra = ?";
            PreparedStatement pstmt = DatabaseConnection.getInstance().getConnection().prepareStatement(sqlUpdate);
            pstmt.setString(1, detail.getIsbn_book());
            pstmt.setString(2, detail.getDesc());
            pstmt.setBoolean(3, detail.isStatus());
            pstmt.setDate(4, detail.getDay_return());
            if (pstmt.executeUpdate() >= 1) {
                return true;
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return false;
    }
}
