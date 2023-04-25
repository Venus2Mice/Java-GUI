package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DB_CONECT.DatabaseConnection;
import DTO.Book_DTO;

public class Book_DAO implements IBook_DAO {

    @Override
    public boolean addBook(Book_DTO b) {
        try {
            String sql = "INSERT INTO `libarymanager`.`book` VALUES(?,?,?,?,?,?,?,?,?)";
            PreparedStatement pstmt = DatabaseConnection.getInstance().getConnection().prepareStatement(sql);
            pstmt.setString(1, b.getIsbn_code());
            pstmt.setString(2, b.getBook_name());
            pstmt.setString(3, b.getCategory());
            pstmt.setString(4, b.getAuthors());
            pstmt.setInt(5, b.getPublisher_id());
            pstmt.setInt(6, b.getEdition());
            pstmt.setDate(7, b.getPublishing_year());
            pstmt.setInt(8, b.getAmount());
            pstmt.setBoolean(9, b.isStatus());
            if (pstmt.executeUpdate() >= 1) {
                return true;
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return false;
    }

    @Override
    public boolean deleteBook(Book_DTO b) {
        try {
            String sqlUpdate = "DELETE FROM `libarymanager`.`book`"
                    + "\nWHERE isbn = ?";
            PreparedStatement pstmt = DatabaseConnection.getInstance().getConnection().prepareStatement(sqlUpdate);
            pstmt.setString(1, b.getIsbn_code());
            if (pstmt.executeUpdate() >= 1) {
                return true;
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return false;
    }

    @Override
    public List<Book_DTO> getAllBook() {
        List<Book_DTO> booklist;
        booklist = new ArrayList<Book_DTO>();
        try {
            String sqlQuery = "SELECT * FROM `libarymanager`.`book`";
            ResultSet rs = DatabaseConnection.getInstance().executeQuery(sqlQuery);
            while (rs.next()) {
                Book_DTO b = new Book_DTO();
                b.setIsbn_code((rs.getString("isbn")));
                b.setBook_name(rs.getString("ten_sach"));
                b.setCategory(rs.getString("danh_muc"));
                b.setAuthors(rs.getString("tac_gia"));
                b.setPublisher_id(rs.getInt("id_nxb"));
                b.setEdition(rs.getInt("tai_ban"));
                b.setPublishing_year(rs.getDate("nam_xuatban"));
                b.setAmount(rs.getInt("so_luong"));
                b.setStatus(rs.getBoolean("status"));
                booklist.add(b);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return booklist;
    }

    @Override
    public Book_DTO getBookByIsbn(String isbn) {
        try {
            String sql = "SELECT * FROM `libarymanager`.`book` WHERE isbn = ?";
            PreparedStatement pstmt = DatabaseConnection.getInstance().getConnection().prepareStatement(sql);
            pstmt.setString(1, isbn);
            Book_DTO b = new Book_DTO();
            ResultSet rs = pstmt.executeQuery();
            boolean check = false;

            while (rs.next()) {
                check = true;
                b.setIsbn_code(rs.getString("isbn"));
                b.setBook_name(rs.getString("ten_sach"));
                b.setCategory(rs.getString("danh_muc"));
                b.setAuthors(rs.getString("tac_gia"));
                b.setPublisher_id(rs.getInt("id_nxb"));
                b.setEdition(rs.getInt("tai_ban"));
                b.setPublishing_year(rs.getDate("nam_xuatban"));
                b.setAmount(rs.getInt("so_luong"));
                b.setStatus(rs.getBoolean("status"));
            }

            if (check) {
                return b;
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }

    @Override
    public boolean updateBook(Book_DTO b) {
        try {
            String sqlUpdate = "UPDATE `libarymanager`.`book`"
                    + "\nSET \nten_sach = ?, danh_muc = ?, tac_gia = ?, id_nxb = ?,"
                    + "tai_ban = ?, nam_xuatban = ?, so_luong = ?, status = ? "
                    + "\nWHERE isbn = ?";
            PreparedStatement pstmt = DatabaseConnection.getInstance().getConnection().prepareStatement(sqlUpdate);
            pstmt.setString(1, b.getBook_name());
            pstmt.setString(2, b.getCategory());
            pstmt.setString(3, b.getAuthors());
            pstmt.setInt(4, b.getPublisher_id());
            pstmt.setInt(5, b.getEdition());
            pstmt.setDate(6, b.getPublishing_year());
            pstmt.setInt(7, b.getAmount());
            pstmt.setBoolean(8, b.isStatus());
            pstmt.setString(9, b.getIsbn_code());
            if (pstmt.executeUpdate() >= 1) {
                return true;
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return false;
    }

}
