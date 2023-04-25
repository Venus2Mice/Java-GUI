package BUS;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import DAO.Book_DAO;
import DAO.IBook_DAO;
import DTO.Book_DTO;
import GUI.MyCustom.MyDialog;

public class Book_BUS {
    private IBook_DAO book_DAO = null;

    public Book_BUS() {
        this.book_DAO = new Book_DAO();
    }

    public List<Book_DTO> getAllBook() {
        return book_DAO.getAllBook();
    }

    public boolean addBook(Book_DTO b) {
        if (b == null) {
            new MyDialog("Thêm thất bại!", MyDialog.ERROR_DIALOG);
            return false;
        }
        String isbn = b.getIsbn_code();
        Book_DTO tmp = book_DAO.getBookByIsbn(isbn);
        if (tmp != null) {
            new MyDialog("Thêm thành công!", MyDialog.SUCCESS_DIALOG);
            b.setAmount(b.getAmount() + tmp.getAmount());
            return book_DAO.updateBook(b);
        } else {
            new MyDialog("Thêm thành công!", MyDialog.SUCCESS_DIALOG);
            return book_DAO.addBook(b);
        }
    }

    public Book_DTO initBook(String isbn, String name, String category, String authors, String pub_id, String edition,
            String namxuatban, String amount, String status) {
        if (isbn.trim().equals("") || name.trim().equals("") || category.trim().equals("")
                || authors.trim().equals("") || pub_id.trim().equals("") || edition.trim().equals("")
                || namxuatban.trim().equals("") || amount.trim().equals("") || status.trim().equals("")) {
            new MyDialog("Vui lòng điền đầy đủ thông tin!", MyDialog.ERROR_DIALOG);
            return null;
        }
        Book_DTO b = new Book_DTO();
        b.setIsbn_code(isbn);
        b.setBook_name(name);
        b.setCategory(category);
        b.setAuthors(authors);
        try {
            if (Integer.parseInt(pub_id) < 0 || Integer.parseInt(amount) < 0 || Integer.parseInt(edition) < 0) {
                new MyDialog("Lỗi thông tin!", MyDialog.ERROR_DIALOG);
                return null;
            }
            b.setPublisher_id(Integer.parseInt(pub_id));
            b.setAmount(Integer.parseInt(amount));
            b.setEdition(Integer.parseInt(edition));
            b.setPublishing_year(Date.valueOf(namxuatban));
            b.setStatus(Boolean.parseBoolean(status));
        } catch (Exception e) {

        }
        return b;
    }

    public boolean updateBook(Book_DTO b) {
        if (b != null) {
            new MyDialog("Sửa thành công!", MyDialog.SUCCESS_DIALOG);
            return book_DAO.updateBook(b);
        }
        new MyDialog("Sửa thất bại!", MyDialog.ERROR_DIALOG);
        return false;
    }

    public boolean deleteBook(Book_DTO b) {
        if (b != null) {
            new MyDialog("Xóa thành công!", MyDialog.SUCCESS_DIALOG);
            return book_DAO.deleteBook(b);
        }
        new MyDialog("Xóa thất bại!", MyDialog.ERROR_DIALOG);
        return false;
    }

    public ArrayList<Book_DTO> findByKey(String key) {
        ArrayList<Book_DTO> list = new ArrayList<>();
        key = key.toLowerCase();
        for (Book_DTO b : book_DAO.getAllBook()) {
            String isbn = b.getIsbn_code().toLowerCase();
            String name = b.getBook_name().toLowerCase();
            String authors = b.getAuthors().toLowerCase();
            String category = b.getCategory().toLowerCase();
            if (name.contains(key) || isbn.contains(key) || authors.contains(key) || category.contains(key)) {
                list.add(b);
            }
        }
        return list;
    }
}
