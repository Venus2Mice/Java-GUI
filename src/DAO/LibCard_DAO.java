package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DB_CONECT.DatabaseConnection;
import DTO.LibCard_DTO;

public class LibCard_DAO {
    
    public List<LibCard_DTO> getAllLibCard() {
        List<LibCard_DTO> LibCardlist;
        LibCardlist = new ArrayList<LibCard_DTO>();
        try {
            String sqlQuery = "SELECT * FROM `libarymanager`.`the_thuvien`";
            ResultSet rs = DatabaseConnection.getInstance().executeQuery(sqlQuery);
            while (rs.next()) {
                LibCard_DTO c = new LibCard_DTO();
                c.setCard_id(rs.getInt("id_the"));
                c.setDay_init(rs.getDate("ngay_tao"));
                c.setExp_date(rs.getDate("ngay_hethan"));
                c.setName(rs.getString("ten_docgia"));
                c.setPhone(rs.getInt("phone"));
                c.setDesc(rs.getString("desc"));
                LibCardlist.add(c);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return LibCardlist;
    }

    public boolean addLibCard(LibCard_DTO c) {
        try {
            String sql = "INSERT INTO `libarymanager`.`the_thuvien` VALUES(?,?,?,?,?)";
            PreparedStatement pstmt = DatabaseConnection.getInstance().getConnection().prepareStatement(sql);
            pstmt.setDate(1, c.getDay_init());
            pstmt.setDate(2, c.getExp_date());
            pstmt.setString(3, c.getDesc());
            pstmt.setString(4, c.getName());
            pstmt.setInt(5, c.getPhone());
            if (pstmt.executeUpdate() >= 1) {
                return true;
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return false;
    }

    public boolean deleteLibCard(LibCard_DTO c) {
        try {
            String sqlUpdate = "DELETE FROM `libarymanager`.`the_thuvien`"
                    + "\nWHERE id_the = ?";
            PreparedStatement pstmt = DatabaseConnection.getInstance().getConnection().prepareStatement(sqlUpdate);
            pstmt.setInt(1, c.getCard_id());
            if (pstmt.executeUpdate() >= 1) {
                return true;
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return false;
    }

    public boolean updateLibCard(LibCard_DTO c) {
        try {
            String sqlUpdate = "UPDATE `libarymanager`.`the_thuvien`"
                    + "\nSET \n ngay_tao = ?, ngay_hethan = ?, desc = ?, ten_docgia = ?, phone = ?"
                    + "\nWHERE id_the = ?";
            PreparedStatement pstmt = DatabaseConnection.getInstance().getConnection().prepareStatement(sqlUpdate);
            pstmt.setDate(1, c.getDay_init());
            pstmt.setDate(2, c.getExp_date());
            pstmt.setString(3, c.getDesc());
            pstmt.setString(4, c.getName());
            pstmt.setInt(5, c.getPhone());
            pstmt.setInt(6, c.getCard_id());
            if (pstmt.executeUpdate() >= 1) {
                return true;
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return false;
    }

    public LibCard_DTO getLibCardById(int id) {
        try {
            String sql = "SELECT * FROM `libarymanager`.`the_thuvien` WHERE id_the = ?";
            PreparedStatement pstmt = DatabaseConnection.getInstance().getConnection().prepareStatement(sql);
            pstmt.setInt(1, id);
            LibCard_DTO c = new LibCard_DTO();
            ResultSet rs = pstmt.executeQuery();
            boolean check = false;

            while (rs.next()) {
                check = true;
                c.setCard_id(rs.getInt("id_the"));
                c.setDay_init(rs.getDate("ngay_tao"));
                c.setExp_date(rs.getDate("ngay_hethan"));
                c.setName(rs.getString("ten_docgia"));
                c.setPhone(rs.getInt("phone"));
                c.setDesc(rs.getString("desc"));
            }

            if (check) {
                return c;
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }
}
