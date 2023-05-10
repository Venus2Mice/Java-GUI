package GUI;

import BUS.Staff_BUS;
import DTO.Staff_DTO;
import GUI.MyCustom.MyTable;
import GUI.MyCustom.datechooser.DateChooser;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class Staff_GUI extends javax.swing.JPanel {
    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
    public Staff_GUI() {
        initComponents();
        initTb();
        loadData();
        
    }

    DefaultTableModel dtmStaff = new DefaultTableModel() {
        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };

    private void initTb(){
        dtmStaff.addColumn("ID");
        dtmStaff.addColumn("Tên nv");
        dtmStaff.addColumn("Ngày sinh");
        dtmStaff.addColumn("SĐT");
        dtmStaff.addColumn("Thuộc nhóm");
        dtmStaff.addColumn("Tên đăng nhập");
        dtmStaff.addColumn("Mật khẩu");
        dtmStaff.addColumn("Trạng thái");
    }

    private Staff_BUS staff_BUS;
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        datechooseBirth = new GUI.MyCustom.datechooser.DateChooser();
        pnStaffMenu = new javax.swing.JPanel();
        pnTop = new javax.swing.JPanel();
        lbTitle = new javax.swing.JLabel();
        scrTbStaff = new javax.swing.JScrollPane();
        tbStaff = new MyTable();
        Them = new javax.swing.JButton();
        Xoa = new javax.swing.JButton();
        Sua = new javax.swing.JButton();
        txtName = new GUI.MyCustom.swing.Input();
        txtPhone = new GUI.MyCustom.swing.Input();
        txtUsername = new GUI.MyCustom.swing.Input();
        txtPassword = new GUI.MyCustom.swing.Input();
        txtKey = new GUI.MyCustom.swing.Input();
        Tim = new javax.swing.JButton();
        btnReset = new javax.swing.JButton();
        cmbGroup = new javax.swing.JComboBox<>();
        lbCbGroup = new javax.swing.JLabel();
        lbBirth = new javax.swing.JLabel();
        txtBirth = new javax.swing.JTextField();
        btnLockStaff = new javax.swing.JButton();
        txtID = new GUI.MyCustom.swing.Input();

        datechooseBirth.setDateFormat("yyyy-MM-dd");
        datechooseBirth.setTextRefernce(txtBirth);

        setPreferredSize(new java.awt.Dimension(915, 600));
        setLayout(new javax.swing.BoxLayout(this, javax.swing.BoxLayout.Y_AXIS));

        pnStaffMenu.setLayout(new javax.swing.BoxLayout(pnStaffMenu, javax.swing.BoxLayout.Y_AXIS));
        add(pnStaffMenu);

        pnTop.setBackground(new java.awt.Color(247, 247, 247));

        lbTitle.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lbTitle.setText("QUẢN LÝ NHÂN VIÊN");

        tbStaff.setModel(dtmStaff);
        tbStaff.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbStaffMouseClicked(evt);
            }
        });
        scrTbStaff.setViewportView(tbStaff);

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

        txtName.setLabelText("Họ tên");

        txtPhone.setLabelText("SĐT");

        txtUsername.setLabelText("TK login");

        txtPassword.setLabelText("Password");

        txtKey.setLabelText("Từ khóa cần tìm");

        Tim.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        Tim.setText("Tìm");
        Tim.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TimMouseClicked(evt);
            }
        });
        Tim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TimActionPerformed(evt);
            }
        });

        btnReset.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnReset.setText("Reset");
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });

        cmbGroup.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ADMIN", "STAFF", "NV_KHO" }));

        lbCbGroup.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lbCbGroup.setText("Nhóm");

        lbBirth.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lbBirth.setText("Ngày sinh");

        btnLockStaff.setText("KHÓA NV");
        btnLockStaff.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnLockStaffMouseClicked(evt);
            }
        });

        txtID.setLabelText("ID NV");

        javax.swing.GroupLayout pnTopLayout = new javax.swing.GroupLayout(pnTop);
        pnTop.setLayout(pnTopLayout);
        pnTopLayout.setHorizontalGroup(
            pnTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(scrTbStaff)
            .addGroup(pnTopLayout.createSequentialGroup()
                .addGroup(pnTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnTopLayout.createSequentialGroup()
                        .addGap(341, 341, 341)
                        .addComponent(lbTitle)
                        .addGap(18, 18, 18)
                        .addComponent(btnReset, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 166, Short.MAX_VALUE))
                    .addGroup(pnTopLayout.createSequentialGroup()
                        .addGroup(pnTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(pnTopLayout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(Them, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(12, 12, 12)
                                .addComponent(Xoa, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnTopLayout.createSequentialGroup()
                                .addGap(101, 101, 101)
                                .addGroup(pnTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnTopLayout.createSequentialGroup()
                                        .addComponent(lbBirth, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtBirth, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(txtPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(txtName, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                        .addComponent(txtID, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pnTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtPassword, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(pnTopLayout.createSequentialGroup()
                                .addComponent(Sua, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnLockStaff))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnTopLayout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addComponent(lbCbGroup, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(cmbGroup, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10))
                            .addComponent(txtUsername, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(68, 68, 68))
            .addGroup(pnTopLayout.createSequentialGroup()
                .addGap(271, 271, 271)
                .addComponent(txtKey, javax.swing.GroupLayout.PREFERRED_SIZE, 339, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Tim, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnTopLayout.setVerticalGroup(
            pnTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnTopLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(pnTopLayout.createSequentialGroup()
                        .addComponent(btnReset, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(1, 1, 1))
                    .addComponent(lbTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(pnTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnTopLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(pnTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbBirth)
                            .addComponent(txtBirth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(pnTopLayout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(pnTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cmbGroup, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbCbGroup, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(25, 25, 25)
                        .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(pnTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnTopLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(txtPhone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnTopLayout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(29, 29, 29)
                .addGroup(pnTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Them, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Xoa, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Sua, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLockStaff, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(pnTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnTopLayout.createSequentialGroup()
                        .addComponent(txtKey, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(scrTbStaff, javax.swing.GroupLayout.DEFAULT_SIZE, 247, Short.MAX_VALUE))
                    .addGroup(pnTopLayout.createSequentialGroup()
                        .addComponent(Tim, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );

        txtID.setEditable();

        add(pnTop);
    }// </editor-fold>//GEN-END:initComponents

    private void SuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SuaActionPerformed
        try {
            int id = Integer.parseInt(txtID.getFieldText());
            String ten = txtName.getFieldText();
            Date birth = Date.valueOf(txtBirth.getText());
            String phone  = txtPhone.getFieldText();
            String group = cmbGroup.getSelectedItem().toString();
            String username = txtUsername.getFieldText();
            String password = txtPassword.getFieldText();
            boolean status = true;
        
            Staff_DTO s = new Staff_DTO(id, ten, birth, phone, username, password, group, status);
            if (staff_BUS.updateStaff(s)) {
                btnReset.doClick();
            }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_SuaActionPerformed

    private void XoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_XoaActionPerformed
        try {
            int id = Integer.parseInt(txtID.getFieldText());
            if (staff_BUS.deleteStaff(id)) {
                btnReset.doClick();
            }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_XoaActionPerformed

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        txtName.setFieldText("");
        txtBirth.setText("");
        txtPhone.setFieldText("");
        txtUsername.setFieldText("");
        txtPassword.setFieldText("");
        txtID.setFieldText("");
        loadData();
    }//GEN-LAST:event_btnResetActionPerformed

    private void ThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ThemActionPerformed
        try {
            String ten = txtName.getFieldText();
            String birth = txtBirth.getText(); 
            String phone  = txtPhone.getFieldText();
            String group = cmbGroup.getSelectedItem().toString();
            String username = txtUsername.getFieldText();
            String password = txtPassword.getFieldText();
            boolean status = true;
            
            java.sql.Date sqlBirthDate2 = java.sql.Date.valueOf(birth);
        
            Staff_DTO s = staff_BUS.initStaff(ten, sqlBirthDate2, phone, group, username, password, status);
            if (staff_BUS.addStaff(s)) {
                System.out.println("added to database GUI"); // TODO: delete this line later
                btnReset.doClick();
            }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_ThemActionPerformed

    private void TimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TimActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TimActionPerformed

    private void btnLockStaffMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLockStaffMouseClicked
        int id = Integer.parseInt(txtID.getFieldText());
        staff_BUS.setActive(id, false);
        btnReset.doClick();
    }//GEN-LAST:event_btnLockStaffMouseClicked

    private void tbStaffMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbStaffMouseClicked
        // TODO add your handling code here:
        clickTbEventStaff();
    }//GEN-LAST:event_tbStaffMouseClicked

    private void TimMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TimMouseClicked
        // TODO add your handling code here:
        Search();
    }//GEN-LAST:event_TimMouseClicked

    private void loadData(){
        staff_BUS = new Staff_BUS();
        loadData(staff_BUS.getAllStaff());
    }

    private void loadData(List<Staff_DTO> listitem){
        dtmStaff.setRowCount(0);
        for(Staff_DTO s : listitem){
            Vector vec = new Vector();
            vec.add(s.getId_staff());
            vec.add(s.getStaff_name());
            vec.add(s.getBrith());
            vec.add(s.getPhone());
            vec.add(s.getGroup_name());
            vec.add(s.getUsername());
            vec.add(s.getPassword());
            vec.add(s.isActive());
            dtmStaff.addRow(vec);
        }
    }

    private void clickTbEventStaff() {
        int row = tbStaff.getSelectedRow();
        if (row > -1) {
            txtID.setFieldText(tbStaff.getValueAt(row, 0) + "");
            txtName.setFieldText(tbStaff.getValueAt(row, 1) + "");
            txtBirth.setText(tbStaff.getValueAt(row, 2) + "");
            txtPhone.setFieldText(tbStaff.getValueAt(row, 3) + "");
            cmbGroup.setSelectedItem(tbStaff.getValueAt(row, 4)+"");      
            txtUsername.setFieldText(tbStaff.getValueAt(row, 5) + "");
            txtPassword.setFieldText(tbStaff.getValueAt(row, 6) + "");
        }
    }

    private void Search() {
        ArrayList<Staff_DTO> list = staff_BUS.findByKey(txtKey.getFieldText());
        loadData(list);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Sua;
    private javax.swing.JButton Them;
    private javax.swing.JButton Tim;
    private javax.swing.JButton Xoa;
    private javax.swing.JButton btnLockStaff;
    private javax.swing.JButton btnReset;
    private javax.swing.JComboBox<String> cmbGroup;
    private GUI.MyCustom.datechooser.DateChooser datechooseBirth;
    private javax.swing.JLabel lbBirth;
    private javax.swing.JLabel lbCbGroup;
    private javax.swing.JLabel lbTitle;
    private javax.swing.JPanel pnStaffMenu;
    private javax.swing.JPanel pnTop;
    private javax.swing.JScrollPane scrTbStaff;
    private javax.swing.JTable tbStaff;
    private javax.swing.JTextField txtBirth;
    private GUI.MyCustom.swing.Input txtID;
    private GUI.MyCustom.swing.Input txtKey;
    private GUI.MyCustom.swing.Input txtName;
    private GUI.MyCustom.swing.Input txtPassword;
    private GUI.MyCustom.swing.Input txtPhone;
    private GUI.MyCustom.swing.Input txtUsername;
    // End of variables declaration//GEN-END:variables
}
