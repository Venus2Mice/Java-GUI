package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DB_CONECT.DatabaseConnection;
import DTO.Publisher_DTO;

public class Publisher_DAO {

    public List<Publisher_DTO> getAllPub() {
        List<Publisher_DTO> Publist;
        Publist = new ArrayList<Publisher_DTO>();
        try {
            String sqlQuery = "SELECT * FROM `libarymanager`.`nxb`";
            ResultSet rs = DatabaseConnection.getInstance().executeQuery(sqlQuery);
            while (rs.next()) {
                Publisher_DTO p = new Publisher_DTO();
                p.setAdress(rs.getString("dia_chi"));
                p.setEmail(rs.getString("email"));
                p.setPubliser_id(rs.getInt("id_nxb"));
                p.setPublisher_name(rs.getString("ten_nxb"));
                Publist.add(p);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return Publist;
    }

    public boolean addPub(Publisher_DTO p) {
        try {
            String sql = "INSERT INTO `libarymanager`.`nxb` (`ten_nxb`, `dia_chi`, `email`) VALUES(?,?,?)";
            PreparedStatement pstmt = DatabaseConnection.getInstance().getConnection().prepareStatement(sql);
            pstmt.setString(1, p.getPublisher_name());
            pstmt.setString(2, p.getAdress());
            pstmt.setString(3, p.getEmail());
            if (pstmt.executeUpdate() >= 1) {
                return true;
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return false;
    }

    public boolean delPub(Publisher_DTO p) {
        try {
            String sqlUpdate = "DELETE FROM `libarymanager`.`nxb`"
                    + "\nWHERE id_nxb = ?";
            PreparedStatement pstmt = DatabaseConnection.getInstance().getConnection().prepareStatement(sqlUpdate);
            pstmt.setInt(1, p.getPubliser_id());
            if (pstmt.executeUpdate() >= 1) {
                return true;
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return false;
    }

    public Publisher_DTO getPubById(int id) {
        try {
            String sql = "SELECT * FROM `libarymanager`.`nxb` WHERE id_nxb = ?";
            PreparedStatement pstmt = DatabaseConnection.getInstance().getConnection().prepareStatement(sql);
            pstmt.setInt(1, id);
            Publisher_DTO p = new Publisher_DTO();
            ResultSet rs = pstmt.executeQuery();
            boolean check = false;

            while (rs.next()) {
                check = true;
                p.setAdress(rs.getString("dia_chi"));
                p.setEmail(rs.getString("email"));
                p.setPubliser_id(rs.getInt("id_nxb"));
                p.setPublisher_name(rs.getString("ten_nxb"));
            }

            if (check) {
                return p;
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }

    public boolean updatePub(Publisher_DTO p) {
        try {
            String sqlUpdate = "UPDATE `libarymanager`.`nxb`"
                    + "\nSET \nten_nxb = ?, dia_chi = ?, email = ?"
                    + "\nWHERE id_nxb = ?";
            PreparedStatement pstmt = DatabaseConnection.getInstance().getConnection().prepareStatement(sqlUpdate);
            pstmt.setString(1, p.getPublisher_name());
            pstmt.setString(2, p.getAdress());
            pstmt.setString(3, p.getEmail());
            pstmt.setInt(4, p.getPubliser_id());
            if (pstmt.executeUpdate() >= 1) {
                return true;
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return false;
    }
}
