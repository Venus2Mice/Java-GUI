package GUI.MyCustom.form;

import GUI.MyCustom.model.Model_Card;
import GUI.MyCustom.model.StatusType;
import GUI.MyCustom.swing.ScrollBar;
import java.awt.Color;
import java.util.*;
import javax.swing.*;

import BUS.Book_BUS;
import BUS.LibCard_BUS;
import BUS.OrderDetail_BUS;
import BUS.Staff_BUS;
import DTO.Book_DTO;
import DTO.OrderDetail_DTO;
import DTO.Staff_DTO;

public class Dashboard extends javax.swing.JPanel {
    int rank_top = 0;
    String isbn_book_most ;
    public Dashboard() {
        initComponents();
        Staff_DTO s = Staff_BUS.staff_DTO_current_login;
        Staff_BUS staff_BUS = new Staff_BUS();
        Book_BUS book_BUS = new Book_BUS();
        int total_book = 0;
        for (Book_DTO book_DTO : book_BUS.getAllBook()) {
            total_book += book_DTO.getAmount();
        }
        int total_staff = 0;
        total_staff += staff_BUS.getAllStaff().size(); 

        List<Book_DTO> listRank = book_BUS.getAllBook();
        HashMap<String, Integer> rank = new HashMap<String, Integer>();

        // init rank
        for (Book_DTO book_DTO : listRank) {
            rank.put(book_DTO.getIsbn_code(), 0);
        }

        OrderDetail_BUS orderDetail_BUS = new OrderDetail_BUS();
        for (OrderDetail_DTO orderDetail_DTO : orderDetail_BUS.getAllDetail()) {
            rank.replace(orderDetail_DTO.getIsbn_book(), rank.get(orderDetail_DTO.getIsbn_book())+1);
        }
        
        rank.forEach((string, i) -> {
            if (i > rank_top) {
                rank_top = i;
                isbn_book_most = string;
            }
        });

        Book_DTO most = book_BUS.getById(isbn_book_most);

        card1.setData(new Model_Card(new ImageIcon(getClass().getResource("/GUI/MyCustom/icon/stock.png")),
                "Tổng số sách trong kho", total_book + ""));
        card2.setData(new Model_Card(new ImageIcon(getClass().getResource("/GUI/MyCustom/icon/profit.png")),
                "Tống số nhân viên", total_staff+""));
        card3.setData(new Model_Card(new ImageIcon(getClass().getResource("/GUI/MyCustom/icon/flag.png")),
                "Nhân viên đang trong ca", s.getStaff_name()));
        card4.setData(new Model_Card(new ImageIcon(getClass().getResource("/GUI/MyCustom/icon/flag.png")),
                "Sách được đọc nhiều nhất", most.getBook_name()));
        card5.setData(new Model_Card(new ImageIcon(getClass().getResource("/GUI/MyCustom/icon/flag.png")),
                "Tác giả được yêu thích", most.getAuthors()));
        card6.setData(new Model_Card(new ImageIcon(getClass().getResource("/GUI/MyCustom/icon/flag.png")),
                "Số đọc giả", new LibCard_BUS().getAllLibCard().size()+""));


    }
    
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnCardView = new javax.swing.JLayeredPane();
        card1 = new GUI.MyCustom.component.Card();
        card2 = new GUI.MyCustom.component.Card();
        card3 = new GUI.MyCustom.component.Card();
        card4 = new GUI.MyCustom.component.Card();
        card5 = new GUI.MyCustom.component.Card();
        card6 = new GUI.MyCustom.component.Card();

        setPreferredSize(new java.awt.Dimension(915, 600));

        pnCardView.setLayout(new java.awt.GridLayout(2, 3, 10, 0));

        card1.setColor1(new java.awt.Color(142, 142, 250));
        card1.setColor2(new java.awt.Color(123, 123, 245));
        pnCardView.add(card1);

        card2.setColor1(new java.awt.Color(186, 123, 247));
        card2.setColor2(new java.awt.Color(167, 94, 236));
        pnCardView.add(card2);

        card3.setColor1(new java.awt.Color(241, 208, 62));
        card3.setColor2(new java.awt.Color(211, 184, 61));
        pnCardView.add(card3);

        card4.setColor1(new java.awt.Color(142, 142, 250));
        card4.setColor2(new java.awt.Color(123, 123, 245));
        pnCardView.add(card4);

        card5.setColor1(new java.awt.Color(142, 142, 250));
        card5.setColor2(new java.awt.Color(123, 123, 245));
        pnCardView.add(card5);

        card6.setColor1(new java.awt.Color(142, 142, 250));
        card6.setColor2(new java.awt.Color(123, 123, 245));
        pnCardView.add(card6);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(pnCardView, javax.swing.GroupLayout.DEFAULT_SIZE, 875, Short.MAX_VALUE)
                .addGap(20, 20, 20))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(pnCardView, javax.swing.GroupLayout.PREFERRED_SIZE, 476, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(74, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private GUI.MyCustom.component.Card card1;
    private GUI.MyCustom.component.Card card2;
    private GUI.MyCustom.component.Card card3;
    private GUI.MyCustom.component.Card card4;
    private GUI.MyCustom.component.Card card5;
    private GUI.MyCustom.component.Card card6;
    private javax.swing.JLayeredPane pnCardView;
    // End of variables declaration//GEN-END:variables
}
