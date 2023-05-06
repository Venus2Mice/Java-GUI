package GUI;

<<<<<<< Updated upstream
import BUS.Staff_BUS;
import DTO.Staff_DTO;
import java.awt.event.ActionEvent;

public class Staff_GUI extends javax.swing.JPanel {
    public Staff_GUI() {
        initComponents();
        input1.setLabelText(" HỌ VÀ TÊN");
        input3.setLabelText(" NGÀY SINH");
        input4.setLabelText("ĐIỆN THOẠI");
        input5.setLabelText(" TÊN NHÓM");
        input6.setLabelText("TÀI KHOẢN");
        input7.setLabelText(" MẬT KHẨU");
        input2.setLabelText("Nhập từ khoá");
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        dateChooser1 = new GUI.MyCustom.datechooser.DateChooser();
        pnStaffMenu = new javax.swing.JPanel();
        pnTop = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        Them = new javax.swing.JButton();
        Xoa = new javax.swing.JButton();
        Sua = new javax.swing.JButton();
        input1 = new GUI.MyCustom.swing.Input();
        input3 = new GUI.MyCustom.swing.Input();
        input4 = new GUI.MyCustom.swing.Input();
        input5 = new GUI.MyCustom.swing.Input();
        input6 = new GUI.MyCustom.swing.Input();
        input7 = new GUI.MyCustom.swing.Input();
        input2 = new GUI.MyCustom.swing.Input();
        Tim = new javax.swing.JButton();
        Reset = new javax.swing.JButton();

        jButton1.setText("Reset");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
=======
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
import GUI.MyCustom.MyTable;
import GUI.MyCustom.TransparentPanel;
import BUS.Book_BUS;
import BUS.Publisher_BUS;

public class Staff_GUI extends javax.swing.JPanel {

    public Staff_GUI() {
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
>>>>>>> Stashed changes

    final Color colorPanel = new Color(247, 247, 247);
    public static JButton btnReset;
    private JButton btnAdd, btnUpdate, btnDel, btnSearch;
    private JTextField txtSearch, txtISBN, txtName, txtCategory, txtAuthors, txtEdition, txtNamXuatBan, txtAmount;
    private JComboBox<String> cmbStatus, cmbNXB;
    private DateChooser Namxuatban;

<<<<<<< Updated upstream
        pnStaffMenu.setLayout(new javax.swing.BoxLayout(pnStaffMenu, javax.swing.BoxLayout.Y_AXIS));
        add(pnStaffMenu);

        pnTop.setBackground(new java.awt.Color(247, 247, 247));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setText("QUẢN LÝ NHÂN VIÊN");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã nhân viên", "Tên", "Ngày sinh", "Điện thoại", "Nhóm", "Tài khoản", "Mật khẩu"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        Them.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        Them.setText("Thêm");
        Them.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ThemActionPerformed(evt);
            }
        });

        Xoa.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        Xoa.setText("Xoá");
        Xoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                XoaActionPerformed(evt);
            }
        });

        Sua.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        Sua.setText("Sửa");
        Sua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SuaActionPerformed(evt);
            }
        });

        Tim.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        Tim.setText("Tìm");
        Tim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TimActionPerformed(evt);
            }
        });

        Reset.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        Reset.setText("Reset");
        Reset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ResetActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnTopLayout = new javax.swing.GroupLayout(pnTop);
        pnTop.setLayout(pnTopLayout);
        pnTopLayout.setHorizontalGroup(
            pnTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(pnTopLayout.createSequentialGroup()
                .addGroup(pnTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnTopLayout.createSequentialGroup()
                        .addGap(341, 341, 341)
                        .addComponent(jLabel1)
                        .addGap(107, 107, 107)
                        .addComponent(Reset)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(pnTopLayout.createSequentialGroup()
                        .addGroup(pnTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnTopLayout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(Them, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(12, 12, 12)
                                .addComponent(Xoa, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                            .addGroup(pnTopLayout.createSequentialGroup()
                                .addGap(44, 44, 44)
                                .addGroup(pnTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(input3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(input1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(input4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 187, Short.MAX_VALUE)))
                        .addGroup(pnTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(input5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(input6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(input7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Sua, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(68, 68, 68))
            .addGroup(pnTopLayout.createSequentialGroup()
                .addGap(271, 271, 271)
                .addComponent(input2, javax.swing.GroupLayout.PREFERRED_SIZE, 327, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Tim, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnTopLayout.setVerticalGroup(
            pnTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnTopLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnTopLayout.createSequentialGroup()
                        .addGroup(pnTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Reset))
                        .addGap(18, 18, 18)
                        .addComponent(input1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(input5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(input3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(input6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(input4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(input7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(pnTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Them, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Xoa, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Sua, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(pnTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnTopLayout.createSequentialGroup()
                        .addComponent(input2, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 289, Short.MAX_VALUE))
                    .addGroup(pnTopLayout.createSequentialGroup()
                        .addComponent(Tim, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );

        add(pnTop);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO delete this function because netbean
    }//GEN-LAST:event_jButton1ActionPerformed

    private void SuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SuaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SuaActionPerformed

    private void XoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_XoaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_XoaActionPerformed

    private void ResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ResetActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ResetActionPerformed

    private void ThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ThemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ThemActionPerformed

    private void TimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TimActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TimActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Reset;
    private javax.swing.JButton Sua;
    private javax.swing.JButton Them;
    private javax.swing.JButton Tim;
    private javax.swing.JButton Xoa;
    private GUI.MyCustom.datechooser.DateChooser dateChooser1;
    private GUI.MyCustom.swing.Input input1;
    private GUI.MyCustom.swing.Input input2;
    private GUI.MyCustom.swing.Input input3;
    private GUI.MyCustom.swing.Input input4;
    private GUI.MyCustom.swing.Input input5;
    private GUI.MyCustom.swing.Input input6;
    private GUI.MyCustom.swing.Input input7;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JPanel pnStaffMenu;
    private javax.swing.JPanel pnTop;
    // End of variables declaration//GEN-END:variables
=======
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
        lbISBN.setPreferredSize(lbSize);
        lbName.setPreferredSize(lbSize);
        lbCategory.setPreferredSize(lbSize);
        lbAuthors.setPreferredSize(lbSize);
        lbPubId.setPreferredSize(lbSize);
        lbNamXuatBan.setPreferredSize(lbSize);
        lbEdition.setPreferredSize(lbSize);
        lbAmount.setPreferredSize(lbSize);
        lbStatus.setPreferredSize(lbSize);
        cmbStatus.setPreferredSize(lbSize);

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
        String pub_id = pub.findByName(cmbNXB.getSelectedItem() + "").getPubliser_id() + "";
        Book_DTO b = Book_BUS.initBook(txtISBN.getText(), txtName.getText(), txtCategory.getText(),
                txtAuthors.getText(), pub_id, txtEdition.getText(), txtNamXuatBan.getText(),
                txtAmount.getText(), cmbStatus.getSelectedItem() + "");
        if (Book_BUS.addBook(b))
            btnReset.doClick();
    }

    private void eventUpdateBook() {
        String pub_id = pub.findByName(cmbNXB.getSelectedItem() + "").getPubliser_id() + "";
        Book_DTO b = Book_BUS.initBook(txtISBN.getText(), txtName.getText(), txtCategory.getText(),
                txtAuthors.getText(), pub_id, txtEdition.getText(), txtNamXuatBan.getText(),
                txtAmount.getText(), cmbStatus.getSelectedItem() + "");
        if (Book_BUS.updateBook(b))
            btnReset.doClick();
    }

    private void eventDeleteBook() {
        String pub_id = pub.findByName(cmbNXB.getSelectedItem() + "").getPubliser_id() + "";
        Book_DTO b = Book_BUS.initBook(txtISBN.getText(), txtName.getText(), txtCategory.getText(),
                txtAuthors.getText(), pub_id, txtEdition.getText(), txtNamXuatBan.getText(),
                txtAmount.getText(), cmbStatus.getSelectedItem() + "");
        if (Book_BUS.deleteBook(b))
            btnReset.doClick();
    }

    private void LiveSearch() {
        ArrayList<Book_DTO> list = Book_BUS.findByKey(txtSearch.getText());
        loadData(list);
    }

>>>>>>> Stashed changes
}
