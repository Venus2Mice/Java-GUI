package GUI;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;

import GUI.MyCustom.datechooser.DateChooser;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import DTO.Book_DTO;
import DTO.Publisher_DTO;
import GUI.MyCustom.MyDialog;
import GUI.MyCustom.MyTable;
import GUI.MyCustom.TransparentPanel;
import BUS.Book_BUS;
import BUS.Publisher_BUS;

public class Book_GUI extends javax.swing.JPanel {

    public Book_GUI() {
        addControl();
        addEvent();
    }

    DefaultTableModel dtmBOOK = new DefaultTableModel() {
        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };
    MyTable tbBOOK;

    private Book_BUS Book_BUS;
    private Publisher_BUS pub;

    final Color colorPanel = new Color(247, 247, 247);
    public static JButton btnReset;
    private JButton btnAdd, btnUpdate, btnDel, btnSearch;
    private JTextField txtSearch, txtISBN, txtName, txtCategory, txtAuthors, txtEdition, txtNamXuatBan, txtAmount;
    private JComboBox<String> cmbStatus, cmbNXB;
    private DateChooser Namxuatban;

    private void addControl() {
        Font font = new Font("Tahoma", Font.PLAIN, 15);
        this.setLayout(new BorderLayout());
        this.setBackground(colorPanel);
        /*
         * =========================================================================
         * PANEL NHÀ XUẤT BẢN
         * =========================================================================
         */
        JPanel pnBook = new TransparentPanel();
        pnBook.setLayout(new BoxLayout(pnBook, BoxLayout.Y_AXIS));

        JPanel pnTop = new TransparentPanel();
        pnTop.setLayout(new BoxLayout(pnTop, BoxLayout.X_AXIS));

        JPanel pnTitile = new TransparentPanel();
        JLabel lblTitle = new JLabel("<html><h1>QUẢN LÝ SÁCH</h1></html>");
        btnReset = new JButton("Reset");
        btnReset.setPreferredSize(new Dimension(70, 40));
        pnTitile.add(lblTitle);
        pnTitile.add(btnReset);
        pnBook.add(pnTitile);

        // ======PANEL TEXT FIELD=======
        JPanel pnTextFiledLeft = new TransparentPanel();
        pnTextFiledLeft.setLayout(new BoxLayout(pnTextFiledLeft, BoxLayout.Y_AXIS));
        JPanel pnTextFiledRight = new TransparentPanel();
        pnTextFiledRight.setLayout(new BoxLayout(pnTextFiledRight, BoxLayout.Y_AXIS));

        JLabel lbISBN, lbName, lbCategory, lbAuthors, lbPubId, lbEdition, lbNamXuatBan, lbAmount, lbStatus;
        lbISBN = new JLabel("MÃ ISBN");
        lbName = new JLabel("TẾN SÁCH");
        lbCategory = new JLabel("THỂ LOẠI");
        lbAuthors = new JLabel("TÁC GIẢ");
        lbPubId = new JLabel("MÃ NXB");
        lbEdition = new JLabel("LẦN TÁI BẢN");
        lbNamXuatBan = new JLabel("NĂM XUẤT BẢN");
        lbAmount = new JLabel("SỐ LƯỢNG");
        lbStatus = new JLabel("TRẠNG THÁI");

        lbISBN.setFont(font);
        lbName.setFont(font);
        lbCategory.setFont(font);
        lbAuthors.setFont(font);
        lbPubId.setFont(font);
        lbEdition.setFont(font);
        lbNamXuatBan.setFont(font);
        lbAmount.setFont(font);
        lbStatus.setFont(font);

        txtISBN = new JTextField(15);
        txtName = new JTextField(15);
        txtCategory = new JTextField(15);
        txtAuthors = new JTextField(15);
        txtEdition = new JTextField(15);
        txtNamXuatBan = new JTextField(15);
        txtAmount = new JTextField(15);
        cmbStatus = new JComboBox<>();
        cmbNXB = new JComboBox<>();
        cmbStatus.addItem("Chọn status");
        cmbStatus.addItem("True");
        cmbStatus.addItem("False");
        cmbNXB.addItem("Chọn NXB");
        pub = new Publisher_BUS();
        for (Publisher_DTO p : pub.getAllPub()) {
            cmbNXB.addItem(p.getPublisher_name());
        }

        txtISBN.setFont(font);
        txtName.setFont(font);
        txtCategory.setFont(font);
        txtAuthors.setFont(font);
        txtEdition.setFont(font);
        txtNamXuatBan.setFont(font);
        txtAmount.setFont(font);
        cmbStatus.setFont(font);
        cmbNXB.setFont(font);

        Namxuatban = new DateChooser();
        Namxuatban.setDateFormat("yyyy-MM-dd");
        Namxuatban.setTextRefernce(txtNamXuatBan);

        JPanel pnISBN = new TransparentPanel();
        pnISBN.add(lbISBN);
        pnISBN.add(txtISBN);
        pnTextFiledLeft.add(pnISBN);

        JPanel pnName = new TransparentPanel();
        pnName.add(lbName);
        pnName.add(txtName);
        pnTextFiledLeft.add(pnName);

        JPanel pnCategory = new TransparentPanel();
        pnCategory.add(lbCategory);
        pnCategory.add(txtCategory);
        pnTextFiledLeft.add(pnCategory);

        JPanel pnAuthors = new TransparentPanel();
        pnAuthors.add(lbAuthors);
        pnAuthors.add(txtAuthors);
        pnTextFiledLeft.add(pnAuthors);

        JPanel pnPubID = new TransparentPanel();
        pnPubID.add(lbPubId);
        pnPubID.add(cmbNXB);
        pnTextFiledLeft.add(pnPubID);

        JPanel pnEdition = new TransparentPanel();
        pnEdition.add(lbEdition);
        pnEdition.add(txtEdition);
        pnTextFiledRight.add(pnEdition);

        JPanel pnNamXuatBan = new TransparentPanel();
        pnNamXuatBan.add(lbNamXuatBan);
        pnNamXuatBan.add(txtNamXuatBan);
        pnTextFiledRight.add(pnNamXuatBan);

        JPanel pnAmount = new TransparentPanel();
        pnAmount.add(lbAmount);
        pnAmount.add(txtAmount);
        pnTextFiledRight.add(pnAmount);

        JPanel pnStatus = new TransparentPanel();
        pnStatus.add(lbStatus);
        pnStatus.add(cmbStatus);
        pnTextFiledRight.add(pnStatus);

        Dimension lbSize = new Dimension(125, 40);
        Dimension cmbSize = new Dimension(200, 40);
        lbISBN.setPreferredSize(lbSize);
        lbName.setPreferredSize(lbSize);
        lbCategory.setPreferredSize(lbSize);
        lbAuthors.setPreferredSize(lbSize);
        lbPubId.setPreferredSize(lbSize);
        lbNamXuatBan.setPreferredSize(lbSize);
        lbEdition.setPreferredSize(lbSize);
        lbAmount.setPreferredSize(lbSize);
        lbStatus.setPreferredSize(lbSize);
        cmbStatus.setPreferredSize(cmbSize);
        cmbNXB.setPreferredSize(cmbSize);

        pnTop.add(pnTextFiledLeft, BorderLayout.WEST);
        pnTop.add(pnTextFiledRight, BorderLayout.EAST);
        pnBook.add(pnTop);

        // ===============PANEL BUTTON=============
        JPanel pnButton = new TransparentPanel();
        btnAdd = new JButton("Thêm");
        btnUpdate = new JButton("Lưu");
        btnDel = new JButton("Xóa");

        Font fntBtn = new Font("Tahoma", Font.PLAIN, 16);

        btnAdd.setFont(fntBtn);
        btnUpdate.setFont(fntBtn);
        btnDel.setFont(fntBtn);

        pnButton.add(btnAdd);
        pnButton.add(btnUpdate);
        pnButton.add(btnDel);

        pnBook.add(pnButton);

        Dimension btnSize = btnAdd.getPreferredSize();
        btnAdd.setPreferredSize(btnSize);
        btnDel.setPreferredSize(btnSize);
        btnUpdate.setPreferredSize(btnSize);

        // ====PANEL SEARCH=====
        JPanel pnSearch = new TransparentPanel();
        JLabel lblSearch = new JLabel("Nhập từ khóa");

        lblSearch.setFont(font);
        txtSearch = new JTextField(20);
        txtSearch.setFont(font);
        btnSearch = new JButton("Find");
        btnSearch.setPreferredSize(new Dimension(70, 40));

        pnSearch.add(lblSearch);
        pnSearch.add(txtSearch);
        pnSearch.add(btnSearch);
        pnBook.add(pnSearch);

        // ==========TABLE===========
        dtmBOOK.addColumn("Mã ISBN");
        dtmBOOK.addColumn("Tên SÁCH");
        dtmBOOK.addColumn("THỂ LOẠI");
        dtmBOOK.addColumn("TÁC GIẢ");
        dtmBOOK.addColumn("MÃ NXB");
        dtmBOOK.addColumn("LẦN TÁI BẢN");
        dtmBOOK.addColumn("NĂM XUẤT BẢN");
        dtmBOOK.addColumn("SỐ LƯỢNG");
        dtmBOOK.addColumn(" TRẠNG THÁI");

        tbBOOK = new MyTable(dtmBOOK);

        JScrollPane scrtbBOOK = new JScrollPane(tbBOOK);

        this.add(pnBook, BorderLayout.NORTH);
        this.add(scrtbBOOK, BorderLayout.CENTER);

        loadData();
    }

    private void addEvent() {
        btnReset.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                pub = new Publisher_BUS();
                cmbNXB.removeAllItems();
                cmbNXB.addItem("Chọn NXB");
                for (Publisher_DTO p : pub.getAllPub()) {
                    cmbNXB.addItem(p.getPublisher_name());
                }
                loadData();
                txtISBN.setText("");
                txtISBN.setEditable(true);
                txtName.setText("");
                txtCategory.setText("");
                txtAuthors.setText("");
                txtEdition.setText("");
                txtNamXuatBan.setText("");
                txtAmount.setText("");
                cmbNXB.setSelectedIndex(0);
                cmbStatus.setSelectedIndex(0);
            }
        });

        tbBOOK.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                txtISBN.setEditable(false);
                clickTbEventBook();
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
        });

        txtSearch.getDocument().addDocumentListener((DocumentListener) new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                LiveSearch();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                LiveSearch();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                LiveSearch();
            }
        });

        btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                eventAddBook();
            }
        });

        btnDel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                eventDeleteBook();
            }
        });

        btnUpdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                eventUpdateBook();
            }
        });
    }

    private void loadData() {
        Book_BUS = new Book_BUS();
        loadData(Book_BUS.getAllBook());
    }

    private void loadData(List<Book_DTO> listitem) {
        dtmBOOK.setRowCount(0);
        for (Book_DTO b : listitem) {
            Vector vec = new Vector();
            vec.add(b.getIsbn_code());
            vec.add(b.getBook_name());
            vec.add(b.getCategory());
            vec.add(b.getAuthors());
            vec.add(b.getPublisher_id());
            vec.add(b.getEdition());
            vec.add(b.getPublishing_year());
            vec.add(b.getAmount());
            vec.add(b.isStatus());
            dtmBOOK.addRow(vec);
        }
    }

    private void clickTbEventBook() {
        int row = tbBOOK.getSelectedRow();
        if (row > -1) {
            txtISBN.setText(tbBOOK.getValueAt(row, 0) + "");
            txtName.setText(tbBOOK.getValueAt(row, 1) + "");
            txtCategory.setText(tbBOOK.getValueAt(row, 2) + "");
            txtAuthors.setText(tbBOOK.getValueAt(row, 3) + "");
            for (Publisher_DTO p : pub.getAllPub()) {
                if (tbBOOK.getValueAt(row, 4).toString().equals(p.getPubliser_id() + "")) {
                    cmbNXB.setSelectedItem(p.getPublisher_name());
                }
            }
            txtEdition.setText(tbBOOK.getValueAt(row, 5) + "");
            txtNamXuatBan.setText(tbBOOK.getValueAt(row, 6) + "");
            txtAmount.setText(tbBOOK.getValueAt(row, 7) + "");
            int index = tbBOOK.getValueAt(row, 8).toString().equals("true") ? 1 : 2;
            cmbStatus.setSelectedIndex(index);

        }
    }

    private void eventAddBook() {
        Publisher_DTO p = pub.findByName(cmbNXB.getSelectedItem() + "");
        String status = cmbStatus.getSelectedItem() + "";
        if(p==null || status.equals("Chọn status")){
            new MyDialog("Không thêm được!", MyDialog.ERROR_DIALOG);
            return ;
        }
        String pub_id = p.getPubliser_id() + "";
        Book_DTO b = Book_BUS.initBook(txtISBN.getText(), txtName.getText(), txtCategory.getText(),
                txtAuthors.getText(), pub_id, txtEdition.getText(), txtNamXuatBan.getText(),
                txtAmount.getText(), status);
        if (Book_BUS.addBook(b))
            btnReset.doClick();
    }

    private void eventUpdateBook() {
        Publisher_DTO p = pub.findByName(cmbNXB.getSelectedItem() + "");
        String status = cmbStatus.getSelectedItem() + "";
        if(p==null || status.equals("Chọn status")){
            new MyDialog("Không sửa được!", MyDialog.ERROR_DIALOG);
            return ;
        }
        String pub_id = p.getPubliser_id() + "";
        Book_DTO b = Book_BUS.initBook(txtISBN.getText(), txtName.getText(), txtCategory.getText(),
                txtAuthors.getText(), pub_id, txtEdition.getText(), txtNamXuatBan.getText(),
                txtAmount.getText(), status);
        if (Book_BUS.updateBook(b))
            btnReset.doClick();
    }

    private void eventDeleteBook() {
        Publisher_DTO p = pub.findByName(cmbNXB.getSelectedItem() + "");
        String status = cmbStatus.getSelectedItem() + "";
        if(p==null || status.equals("Chọn status")){
            new MyDialog("Không xóa được!", MyDialog.ERROR_DIALOG);
            return ;
        }
        String pub_id = p.getPubliser_id() + "";
        Book_DTO b = Book_BUS.initBook(txtISBN.getText(), txtName.getText(), txtCategory.getText(),
                txtAuthors.getText(), pub_id, txtEdition.getText(), txtNamXuatBan.getText(),
                txtAmount.getText(), status);
        if (Book_BUS.deleteBook(b))
            btnReset.doClick();
    }

    private void LiveSearch() {
        ArrayList<Book_DTO> list = Book_BUS.findByKey(txtSearch.getText());
        loadData(list);
    }

}
