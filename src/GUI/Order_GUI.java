package GUI;

public class Order_GUI extends javax.swing.JPanel {
    public Order_GUI() {
        initComponents();
        iKey.setLabelText("Nhập từ khoá");
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dateChooser1 = new GUI.MyCustom.datechooser.DateChooser();
        pnTop = new javax.swing.JPanel();
        lbTitle = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        Them = new javax.swing.JButton();
        Xoa = new javax.swing.JButton();
        Sua = new javax.swing.JButton();
        iKey = new GUI.MyCustom.swing.Input();
        Tim = new javax.swing.JButton();
        Reset = new javax.swing.JButton();
        pnID = new javax.swing.JPanel();
        lbID = new javax.swing.JLabel();
        txtID = new javax.swing.JTextField();
        pnIDNV = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtIDNV = new javax.swing.JTextField();
        pnIDTHE = new javax.swing.JPanel();
        txtID1 = new javax.swing.JTextField();
        lbID1 = new javax.swing.JLabel();
        pnDATEINIT = new javax.swing.JPanel();
        txtID2 = new javax.swing.JTextField();
        lbID2 = new javax.swing.JLabel();

        dateChooser1.setDateFormat("yyyy-MM-dd");
        dateChooser1.setTextRefernce(txtID2);

        setPreferredSize(new java.awt.Dimension(915, 600));
        setLayout(new javax.swing.BoxLayout(this, javax.swing.BoxLayout.Y_AXIS));

        pnTop.setBackground(new java.awt.Color(247, 247, 247));

        lbTitle.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lbTitle.setText("QUẢN LÝ MƯỢN TRẢ");

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

        pnID.setBackground(new java.awt.Color(247, 247, 247));

        lbID.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lbID.setText("ID");

        txtID.setEditable(false);

        javax.swing.GroupLayout pnIDLayout = new javax.swing.GroupLayout(pnID);
        pnID.setLayout(pnIDLayout);
        pnIDLayout.setHorizontalGroup(
            pnIDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnIDLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbID, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtID)
                .addContainerGap())
        );
        pnIDLayout.setVerticalGroup(
            pnIDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnIDLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnIDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbID)
                    .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(7, Short.MAX_VALUE))
        );

        pnIDNV.setBackground(new java.awt.Color(247, 247, 247));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("ID NV");

        txtIDNV.setEditable(false);
        txtIDNV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIDNVActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnIDNVLayout = new javax.swing.GroupLayout(pnIDNV);
        pnIDNV.setLayout(pnIDNVLayout);
        pnIDNVLayout.setHorizontalGroup(
            pnIDNVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnIDNVLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtIDNV, javax.swing.GroupLayout.DEFAULT_SIZE, 183, Short.MAX_VALUE))
        );
        pnIDNVLayout.setVerticalGroup(
            pnIDNVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnIDNVLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnIDNVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtIDNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(8, Short.MAX_VALUE))
        );

        pnIDTHE.setBackground(new java.awt.Color(247, 247, 247));

        lbID1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lbID1.setText("ID THẺ");

        javax.swing.GroupLayout pnIDTHELayout = new javax.swing.GroupLayout(pnIDTHE);
        pnIDTHE.setLayout(pnIDTHELayout);
        pnIDTHELayout.setHorizontalGroup(
            pnIDTHELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnIDTHELayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbID1)
                .addGap(34, 34, 34)
                .addComponent(txtID1, javax.swing.GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnIDTHELayout.setVerticalGroup(
            pnIDTHELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnIDTHELayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnIDTHELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtID1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbID1))
                .addContainerGap(7, Short.MAX_VALUE))
        );

        pnDATEINIT.setBackground(new java.awt.Color(247, 247, 247));

        txtID2.setEditable(false);

        lbID2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lbID2.setText("NGÀY TẠO");

        javax.swing.GroupLayout pnDATEINITLayout = new javax.swing.GroupLayout(pnDATEINIT);
        pnDATEINIT.setLayout(pnDATEINITLayout);
        pnDATEINITLayout.setHorizontalGroup(
            pnDATEINITLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnDATEINITLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbID2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtID2, javax.swing.GroupLayout.DEFAULT_SIZE, 204, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnDATEINITLayout.setVerticalGroup(
            pnDATEINITLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnDATEINITLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnDATEINITLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtID2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbID2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnTopLayout = new javax.swing.GroupLayout(pnTop);
        pnTop.setLayout(pnTopLayout);
        pnTopLayout.setHorizontalGroup(
            pnTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(pnTopLayout.createSequentialGroup()
                .addGap(88, 88, 88)
                .addGroup(pnTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pnID, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnIDNV, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnTopLayout.createSequentialGroup()
                        .addComponent(lbTitle)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Reset))
                    .addGroup(pnTopLayout.createSequentialGroup()
                        .addGap(161, 161, 161)
                        .addComponent(pnIDTHE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(pnTopLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(pnDATEINIT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(160, 160, 160))
            .addGroup(pnTopLayout.createSequentialGroup()
                .addGap(239, 239, 239)
                .addComponent(iKey, javax.swing.GroupLayout.PREFERRED_SIZE, 327, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Tim, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnTopLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Them, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(Xoa, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Sua, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(313, 313, 313))
        );
        pnTopLayout.setVerticalGroup(
            pnTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnTopLayout.createSequentialGroup()
                .addGroup(pnTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnTopLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(pnTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(Reset, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lbTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(pnIDTHE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(pnTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(pnIDNV, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(pnDATEINIT, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(35, 35, 35))
                    .addGroup(pnTopLayout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addComponent(pnID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(pnTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Them, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Xoa, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Sua, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(iKey, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Tim, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 345, Short.MAX_VALUE))
        );

        add(pnTop);
    }// </editor-fold>//GEN-END:initComponents

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

    private void txtIDNVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIDNVActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIDNVActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Reset;
    private javax.swing.JButton Sua;
    private javax.swing.JButton Them;
    private javax.swing.JButton Tim;
    private javax.swing.JButton Xoa;
    private GUI.MyCustom.datechooser.DateChooser dateChooser1;
    private GUI.MyCustom.swing.Input iKey;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lbID;
    private javax.swing.JLabel lbID1;
    private javax.swing.JLabel lbID2;
    private javax.swing.JLabel lbTitle;
    private javax.swing.JPanel pnDATEINIT;
    private javax.swing.JPanel pnID;
    private javax.swing.JPanel pnIDNV;
    private javax.swing.JPanel pnIDTHE;
    private javax.swing.JPanel pnTop;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtID1;
    private javax.swing.JTextField txtID2;
    private javax.swing.JTextField txtIDNV;
    // End of variables declaration//GEN-END:variables
}
