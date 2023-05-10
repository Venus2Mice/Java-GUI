package GUI;

import BUS.LibCard_BUS;
import BUS.Staff_BUS;
import DTO.LibCard_DTO;
import DTO.Staff_DTO;
import GUI.MyCustom.MyTable;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

public class Libary_Card_GUI extends javax.swing.JPanel {
    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
    private LibCard_BUS libcard_BUS;
    public Libary_Card_GUI() {
        initComponents();
        // extra space de canh dong cho nhanh
        tendocgia.setLabelText("      HỌ VÀ TÊN");
        ngay_tao.setLabelText("       NGÀY TẠO");
        ngay_hethan.setLabelText("NGÀY HẾT HẠN");
        desc.setLabelText(" CHÚ THÍCH");
        phone.setLabelText("ĐIỆN THOẠI");
        input2.setLabelText("Nhập từ khoá");
        initTb();
        loadData();
    }
    
        DefaultTableModel dtmLibCard = new DefaultTableModel() {
        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };

    private void initTb(){
        dtmLibCard.addColumn("ID");
        dtmLibCard.addColumn("Ngày tạo");
        dtmLibCard.addColumn("Ngày hết hạn");
        dtmLibCard.addColumn("Mô tả");
        dtmLibCard.addColumn("Tên độc giả");
        dtmLibCard.addColumn("SĐT");
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        day_exp = new GUI.MyCustom.datechooser.DateChooser();
        dayinit = new GUI.MyCustom.datechooser.DateChooser();
        pnStaffMenu = new javax.swing.JPanel();
        pnTop = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        srcTBStaff = new javax.swing.JScrollPane();
        tbLibCard = new MyTable();
        Them = new javax.swing.JButton();
        Xoa = new javax.swing.JButton();
        Sua = new javax.swing.JButton();
        tendocgia = new GUI.MyCustom.swing.Input();
        ngay_tao = new GUI.MyCustom.swing.Input();
        ngay_hethan = new GUI.MyCustom.swing.Input();
        desc = new GUI.MyCustom.swing.Input();
        phone = new GUI.MyCustom.swing.Input();
        input2 = new GUI.MyCustom.swing.Input();
        Tim = new javax.swing.JButton();
        Reset = new javax.swing.JButton();
        txtIDLIbCard = new GUI.MyCustom.swing.Input();

        jButton1.setText("Reset");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        day_exp.setDateFormat("yyyy-MM-dd");
        day_exp.setTextRefernce(ngay_hethan.getTf());

        dayinit.setDateFormat("yyyy-MM-dd");
        dayinit.setTextRefernce(ngay_tao.getTf());

        setPreferredSize(new java.awt.Dimension(915, 600));
        setLayout(new javax.swing.BoxLayout(this, javax.swing.BoxLayout.Y_AXIS));

        pnStaffMenu.setLayout(new javax.swing.BoxLayout(pnStaffMenu, javax.swing.BoxLayout.Y_AXIS));
        add(pnStaffMenu);

        pnTop.setBackground(new java.awt.Color(247, 247, 247));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setText("QUẢN LÝ THẺ THƯ VIỆN");

        tbLibCard.setModel(dtmLibCard);
        tbLibCard.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbLibCardMouseClicked(evt);
            }
        });
        srcTBStaff.setViewportView(tbLibCard);

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

        Reset.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        Reset.setText("Reset");
        Reset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ResetActionPerformed(evt);
            }
        });

        txtIDLIbCard.setLabelText("ID Thẻ");

        javax.swing.GroupLayout pnTopLayout = new javax.swing.GroupLayout(pnTop);
        pnTop.setLayout(pnTopLayout);
        pnTopLayout.setHorizontalGroup(
            pnTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(srcTBStaff)
            .addGroup(pnTopLayout.createSequentialGroup()
                .addGroup(pnTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnTopLayout.createSequentialGroup()
                        .addGap(341, 341, 341)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Reset, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                                    .addComponent(ngay_tao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tendocgia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(ngay_hethan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 185, Short.MAX_VALUE)))
                        .addGroup(pnTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(desc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(phone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Sua, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnTopLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(txtIDLIbCard, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
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
                .addGroup(pnTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                    .addComponent(Reset, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(pnTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnTopLayout.createSequentialGroup()
                        .addComponent(tendocgia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33)
                        .addComponent(ngay_tao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnTopLayout.createSequentialGroup()
                        .addComponent(txtIDLIbCard, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(desc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(pnTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnTopLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(phone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnTopLayout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(ngay_hethan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(39, 39, 39)
                .addGroup(pnTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Them, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Xoa, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Sua, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(pnTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnTopLayout.createSequentialGroup()
                        .addComponent(input2, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(srcTBStaff, javax.swing.GroupLayout.DEFAULT_SIZE, 255, Short.MAX_VALUE))
                    .addGroup(pnTopLayout.createSequentialGroup()
                        .addComponent(Tim, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );

        txtIDLIbCard.setEditable();

        add(pnTop);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO delete this function because netbean
    }//GEN-LAST:event_jButton1ActionPerformed

    private void SuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SuaActionPerformed
        try {
            int id = Integer.parseInt(txtIDLIbCard.getFieldText());
            String start = ngay_tao.getFieldText();
            String expire = ngay_hethan.getFieldText();
        
            java.util.Date utilstartDate = format.parse(start);
            java.sql.Date sqlstartDate = new java.sql.Date(utilstartDate.getTime());
        
            java.util.Date utilendDate = format.parse(expire);
            java.sql.Date sqlendDate = new java.sql.Date(utilendDate.getTime());
        
            String name = tendocgia.getFieldText();
            String desc1 = desc.getFieldText();
            String phone1 = phone.getFieldText();
        
        
            LibCard_DTO lib = new LibCard_DTO(id, sqlstartDate, sqlendDate, name, phone1, desc1);
            if (libcard_BUS.updateLibCard(lib)){
                Reset.doClick();
            }
        } catch (ParseException e) {
        }
    }//GEN-LAST:event_SuaActionPerformed

    private void XoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_XoaActionPerformed
        try {
            int id = Integer.parseInt(txtIDLIbCard.getFieldText());
            if (libcard_BUS.deleteLibCard(id)){
                Reset.doClick();
            }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_XoaActionPerformed

    private void ResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ResetActionPerformed
        tendocgia.setFieldText("");
        ngay_tao.setFieldText("");
        ngay_hethan.setFieldText("");
        desc.setFieldText("");
        phone.setFieldText("");
        input2.setFieldText("");
        loadData();
    }//GEN-LAST:event_ResetActionPerformed

    private void ThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ThemActionPerformed
        try {
            String start = ngay_tao.getFieldText();
            String expire = ngay_hethan.getFieldText();
        
            java.util.Date utilstartDate = format.parse(start);
            java.sql.Date sqlstartDate = new java.sql.Date(utilstartDate.getTime());
        
            java.util.Date utilendDate = format.parse(expire);
            java.sql.Date sqlendDate = new java.sql.Date(utilendDate.getTime());
        
            String name = tendocgia.getFieldText();
            String desc1 = desc.getFieldText();
            String phone1 = phone.getFieldText();
        
        
            LibCard_DTO lib = libcard_BUS.initLibCard(sqlstartDate, sqlendDate, desc1, name, phone1);
            if (libcard_BUS.addLibCard(lib)) {
                Reset.doClick();
            }
        } catch (ParseException e) {
        }
    }//GEN-LAST:event_ThemActionPerformed

    private void TimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TimActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TimActionPerformed

    private void tbLibCardMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbLibCardMouseClicked
        // TODO add your handling code here:
        clickTbEventStaff();
    }//GEN-LAST:event_tbLibCardMouseClicked

    private void TimMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TimMouseClicked
        // TODO add your handling code here:
        Search();
    }//GEN-LAST:event_TimMouseClicked

        private void loadData(){
        libcard_BUS = new LibCard_BUS();
        loadData(libcard_BUS.getAllStaff());
    }

    private void loadData(List<LibCard_DTO> listitem){
        dtmLibCard.setRowCount(0);
        for(LibCard_DTO s : listitem){
            Vector vec = new Vector();
            vec.add(s.getCard_id());
            vec.add(s.getDay_init());
            vec.add(s.getExp_date());
            vec.add(s.getDesc());
            vec.add(s.getName());
            vec.add(s.getPhone());
            dtmLibCard.addRow(vec);
        }
    }

    private void clickTbEventStaff() {
        int row = tbLibCard.getSelectedRow();
        if (row > -1) {
            txtIDLIbCard.setFieldText(tbLibCard.getValueAt(row, 0) + "");
            ngay_tao.setFieldText(tbLibCard.getValueAt(row, 1) + "");
            ngay_hethan.setFieldText(tbLibCard.getValueAt(row, 2) + "");
            desc.setFieldText(tbLibCard.getValueAt(row, 3) + "");
            tendocgia.setFieldText(tbLibCard.getValueAt(row, 4)+"");      
            phone.setFieldText(tbLibCard.getValueAt(row, 5) + "");
        }
    }

    private void Search() {
        ArrayList<LibCard_DTO> list = libcard_BUS.findByKey(input2.getFieldText());
        loadData(list);
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Reset;
    private javax.swing.JButton Sua;
    private javax.swing.JButton Them;
    private javax.swing.JButton Tim;
    private javax.swing.JButton Xoa;
    private GUI.MyCustom.datechooser.DateChooser day_exp;
    private GUI.MyCustom.datechooser.DateChooser dayinit;
    private GUI.MyCustom.swing.Input desc;
    private GUI.MyCustom.swing.Input input2;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private GUI.MyCustom.swing.Input ngay_hethan;
    private GUI.MyCustom.swing.Input ngay_tao;
    private GUI.MyCustom.swing.Input phone;
    private javax.swing.JPanel pnStaffMenu;
    private javax.swing.JPanel pnTop;
    private javax.swing.JScrollPane srcTBStaff;
    private javax.swing.JTable tbLibCard;
    private GUI.MyCustom.swing.Input tendocgia;
    private GUI.MyCustom.swing.Input txtIDLIbCard;
    // End of variables declaration//GEN-END:variables
}
