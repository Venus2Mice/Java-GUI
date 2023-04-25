package DAO;

import java.util.List;

import DTO.Book_DTO;

public interface IBook_DAO {
    public List<Book_DTO> getAllBook();

    public Book_DTO getBookByIsbn(String isbn);

    public boolean addBook(Book_DTO b);

    public boolean updateBook(Book_DTO b);

    public boolean deleteBook(Book_DTO b);

}