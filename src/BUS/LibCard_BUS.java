package BUS;

import java.util.List;

import DAO.LibCard_DAO;
import DTO.LibCard_DTO;

public class LibCard_BUS {
    private LibCard_DAO libCard_DAO = null;

    public LibCard_BUS() {
        this.libCard_DAO = new LibCard_DAO();
    }

    public List<LibCard_DTO> getAllStaff() {
        return libCard_DAO.getAllLibCard();
    }

    public boolean addStaff(LibCard_DTO c) {
        if (c == null)
            return false;
        int id = c.getCard_id();
        LibCard_DTO tmp = libCard_DAO.getLibCardById(id);
        if (tmp != null) {
            return false;
        } else {
            return libCard_DAO.addLibCard(c);
        }
    }

    public boolean updateStaff(LibCard_DTO c) {
        return c != null ? libCard_DAO.updateLibCard(c) : false;
    }

    public boolean deleteStaff(LibCard_DTO c) {
        return c != null ? libCard_DAO.deleteLibCard(c) : false;
    }

}
