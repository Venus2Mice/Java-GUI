package GUI;

import BUS.Staff_BUS;
import DTO.Staff_DTO;
import GUI.MyCustom.MyTable;
import GUI.MyCustom.datechooser.DateChooser;

import java.awt.Color;
import java.awt.event.ActionEvent;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class Staff_GUI extends javax.swing.JPanel {
    public Staff_GUI() {
        initComponents();
    }

    DefaultTableModel dtmStaff = new DefaultTableModel() {
        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };
    MyTable tbStaff;

    private Staff_BUS staff_BUS;
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        datechooseBirth = new GUI.MyCustom.datechooser.DateChooser();
        pnStaffMenu = new javax.swing.JPanel();
        pnTop = new javax.swing.JPanel();
        lbTitle = new javax.swing.JLabel();
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

        datechooseBirth.setDateFormat("yyyy-MM-dd");
        datechooseBirth.setTextRefernce(txtBirth);

        dtmStaff.addColumn("Mã NV");
        dtmStaff.addColumn("Tên NV");
        dtmStaff.addColumn("Ngày Sinh");
        dtmStaff.addColumn("SĐT");
        dtmStaff.addColumn("Tên Nhóm");
        dtmStaff.addColumn("Tên đăng nhặp");
        dtmStaff.addColumn("password");
        dtmStaff.addColumn("status");

        tbStaff = new MyTable(dtmStaff);

        scrTbStaff = new javax.swing.JScrollPane(tbStaff);

        setPreferredSize(new java.awt.Dimension(915, 600));
        setLayout(new javax.swing.BoxLayout(this, javax.swing.BoxLayout.Y_AXIS));

        pnStaffMenu.setLayout(new javax.swing.BoxLayout(pnStaffMenu, javax.swing.BoxLayout.Y_AXIS));
        add(pnStaffMenu);

        pnTop.setBackground(new java.awt.Color(247, 247, 247));

        lbTitle.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lbTitle.setText("QUẢN LÝ NHÂN VIÊN");
        

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

        cmbGroup.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        lbCbGroup.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lbCbGroup.setText("Nhóm");

        lbBirth.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lbBirth.setText("Ngày sinh");

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
                                    .addComponent(txtPhone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnTopLayout.createSequentialGroup()
                                        .addComponent(lbBirth)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtBirth, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pnTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtPassword, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Sua, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnTopLayout.createSequentialGroup()
                                .addGap(17, 17, 17)
                                .addComponent(lbCbGroup, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(cmbGroup, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(11, 11, 11))
                            .addComponent(txtUsername, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(68, 68, 68))
            .addGroup(pnTopLayout.createSequentialGroup()
                .addGap(271, 271, 271)
                .addComponent(txtKey, javax.swing.GroupLayout.PREFERRED_SIZE, 327, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
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
                        .addGap(24, 24, 24)
                        .addComponent(cmbGroup, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnTopLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(pnTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbCbGroup, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtName, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(pnTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lbBirth)
                        .addComponent(txtBirth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(pnTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtPhone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(pnTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Them, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Xoa, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Sua, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(pnTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnTopLayout.createSequentialGroup()
                        .addComponent(txtKey, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(scrTbStaff, javax.swing.GroupLayout.DEFAULT_SIZE, 289, Short.MAX_VALUE))
                    .addGroup(pnTopLayout.createSequentialGroup()
                        .addComponent(Tim, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        add(pnTop);
        loadData();
    }// </editor-fold>//GEN-END:initComponents

    private void SuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SuaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SuaActionPerformed

    private void XoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_XoaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_XoaActionPerformed

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnResetActionPerformed

    private void ThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ThemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ThemActionPerformed

    private void TimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TimActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TimActionPerformed

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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Sua;
    private javax.swing.JButton Them;
    private javax.swing.JButton Tim;
    private javax.swing.JButton Xoa;
    private javax.swing.JButton btnReset;
    private javax.swing.JComboBox<String> cmbGroup;
    private GUI.MyCustom.datechooser.DateChooser datechooseBirth;
    private javax.swing.JLabel lbBirth;
    private javax.swing.JLabel lbCbGroup;
    private javax.swing.JLabel lbTitle;
    private javax.swing.JPanel pnStaffMenu;
    private javax.swing.JPanel pnTop;
    private javax.swing.JScrollPane scrTbStaff;
    private javax.swing.JTextField txtBirth;
    private GUI.MyCustom.swing.Input txtKey;
    private GUI.MyCustom.swing.Input txtName;
    private GUI.MyCustom.swing.Input txtPassword;
    private GUI.MyCustom.swing.Input txtPhone;
    private GUI.MyCustom.swing.Input txtUsername;
    // End of variables declaration//GEN-END:variables
}
