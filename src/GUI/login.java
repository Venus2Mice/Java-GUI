/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import BUS.Staff_BUS;
import DTO.Staff_DTO;
import GUI.MainManager.MainManager;
import GUI.MyCustom.MyDialog;
import java.awt.event.KeyEvent;

/**
 *
 * @author ME1
 */
public class login extends javax.swing.JFrame {

    /**
     * Creates new form login
     */
    private  Staff_BUS staff_BUS;
    public login() {
        initComponents();
        txtusername.setBackground(new java.awt.Color(0, 0, 0, 1));
        txtpassword.setBackground(new java.awt.Color(0, 0, 0, 1));
        // do du lieu de test
        txtusername.setText("admin123");
        txtpassword.setText("12345");
        this.setVisible(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnBG = new javax.swing.JPanel();
        lbBg = new javax.swing.JLabel();
        pnFormLogin = new javax.swing.JPanel();
        lbExit = new javax.swing.JLabel();
        lbLogin = new javax.swing.JLabel();
        lbTitle = new javax.swing.JLabel();
        lbUserName = new javax.swing.JLabel();
        txtusername = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        lbIconUser = new javax.swing.JLabel();
        lbPassword = new javax.swing.JLabel();
        txtpassword = new javax.swing.JPasswordField();
        jLabel9 = new javax.swing.JLabel();
        disable = new javax.swing.JLabel();
        show = new javax.swing.JLabel();
        lbFoget = new javax.swing.JLabel();
        btnLogin = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(new javax.swing.BoxLayout(getContentPane(), javax.swing.BoxLayout.LINE_AXIS));

        pnBG.setBackground(new java.awt.Color(255, 255, 255));

        lbBg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/icon/bg1.png"))); // NOI18N

        javax.swing.GroupLayout pnBGLayout = new javax.swing.GroupLayout(pnBG);
        pnBG.setLayout(pnBGLayout);
        pnBGLayout.setHorizontalGroup(
            pnBGLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnBGLayout.createSequentialGroup()
                .addComponent(lbBg, javax.swing.GroupLayout.PREFERRED_SIZE, 490, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 6, Short.MAX_VALUE))
        );
        pnBGLayout.setVerticalGroup(
            pnBGLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnBGLayout.createSequentialGroup()
                .addComponent(lbBg, javax.swing.GroupLayout.PREFERRED_SIZE, 438, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        getContentPane().add(pnBG);

        pnFormLogin.setBackground(new java.awt.Color(25, 118, 211));

        lbExit.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lbExit.setForeground(new java.awt.Color(255, 255, 255));
        lbExit.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbExit.setText("X");
        lbExit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbExit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbExitMouseClicked(evt);
            }
        });

        lbLogin.setFont(new java.awt.Font("Segoe UI", 0, 32)); // NOI18N
        lbLogin.setForeground(new java.awt.Color(255, 255, 255));
        lbLogin.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbLogin.setText("Login");

        lbTitle.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        lbTitle.setForeground(new java.awt.Color(255, 255, 255));
        lbTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbTitle.setText("Hello! Let's get started");

        lbUserName.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        lbUserName.setForeground(new java.awt.Color(199, 226, 255));
        lbUserName.setText("Username");

        txtusername.setFont(txtusername.getFont().deriveFont(txtusername.getFont().getSize()+2f));
        txtusername.setForeground(new java.awt.Color(255, 255, 255));
        txtusername.setBorder(null);
        txtusername.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtusernameKeyPressed(evt);
            }
        });

        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("_________________________________________");

        lbIconUser.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbIconUser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/icon/icons8_user_20px_1.png"))); // NOI18N

        lbPassword.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        lbPassword.setForeground(new java.awt.Color(199, 226, 255));
        lbPassword.setText("Password");

        txtpassword.setFont(txtpassword.getFont().deriveFont(txtpassword.getFont().getSize()+2f));
        txtpassword.setForeground(new java.awt.Color(255, 255, 255));
        txtpassword.setBorder(null);
        txtpassword.setCaretColor(new java.awt.Color(255, 255, 255));
        txtpassword.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtpasswordKeyPressed(evt);
            }
        });

        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("_________________________________________");

        disable.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        disable.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/icon/icons8_invisible_20px_1.png"))); // NOI18N
        disable.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        disable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                disableMouseClicked(evt);
            }
        });

        show.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        show.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/icon/icons8_eye_20px_1.png"))); // NOI18N
        show.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        show.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                showMouseClicked(evt);
            }
        });

        lbFoget.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        lbFoget.setForeground(new java.awt.Color(199, 226, 255));
        lbFoget.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbFoget.setText("Forget Password?");
        lbFoget.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbFoget.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbFogetMouseClicked(evt);
            }
        });

        btnLogin.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnLogin.setForeground(new java.awt.Color(25, 118, 211));
        btnLogin.setText("LOGIN");
        btnLogin.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnLogin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnLoginMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout pnFormLoginLayout = new javax.swing.GroupLayout(pnFormLogin);
        pnFormLogin.setLayout(pnFormLoginLayout);
        pnFormLoginLayout.setHorizontalGroup(
            pnFormLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnFormLoginLayout.createSequentialGroup()
                .addGap(380, 380, 380)
                .addComponent(lbExit, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(lbLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 420, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(lbTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 420, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(pnFormLoginLayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(pnFormLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnFormLoginLayout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(txtusername, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnFormLoginLayout.createSequentialGroup()
                        .addGap(256, 256, 256)
                        .addComponent(lbIconUser, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbUserName, javax.swing.GroupLayout.PREFERRED_SIZE, 341, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGroup(pnFormLoginLayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(lbPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 341, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(pnFormLoginLayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(pnFormLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnFormLoginLayout.createSequentialGroup()
                        .addGap(256, 256, 256)
                        .addComponent(disable, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnFormLoginLayout.createSequentialGroup()
                        .addGap(256, 256, 256)
                        .addComponent(show, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnFormLoginLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(txtpassword, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGroup(pnFormLoginLayout.createSequentialGroup()
                .addGap(250, 250, 250)
                .addComponent(lbFoget, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(pnFormLoginLayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(btnLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 341, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        pnFormLoginLayout.setVerticalGroup(
            pnFormLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnFormLoginLayout.createSequentialGroup()
                .addComponent(lbExit, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lbLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(lbTitle)
                .addGap(11, 11, 11)
                .addGroup(pnFormLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnFormLoginLayout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(txtusername, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnFormLoginLayout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addComponent(lbIconUser, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnFormLoginLayout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lbUserName))
                .addGap(6, 6, 6)
                .addComponent(lbPassword)
                .addGroup(pnFormLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(disable, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(show, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtpassword, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnFormLoginLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(14, 14, 14)
                .addComponent(lbFoget, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9)
                .addComponent(btnLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(pnFormLogin);

        setSize(new java.awt.Dimension(916, 438));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnLoginMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLoginMouseClicked
        // TODO add your handling code here:
        xuLyDangNhap();
    }//GEN-LAST:event_btnLoginMouseClicked

    private void txtpasswordKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtpasswordKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            xuLyDangNhap();
        }
    }//GEN-LAST:event_txtpasswordKeyPressed

    private void txtusernameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtusernameKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            xuLyDangNhap();
        }
    }//GEN-LAST:event_txtusernameKeyPressed

    private void lbFogetMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbFogetMouseClicked
        // TODO add your handling code here:
        new MyDialog("Xin liên hệ Admin để giải quyết!", MyDialog.INFO_DIALOG);
    }//GEN-LAST:event_lbFogetMouseClicked

    private void lbExitMouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_lbExitMouseClicked
        System.exit(0);
    }// GEN-LAST:event_lbExitMouseClicked

    private void disableMouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_disableMouseClicked
        txtpassword.setEchoChar((char) 0);
        disable.setVisible(false);
        disable.setEnabled(false);
        show.setEnabled(true);
        show.setEnabled(true);
    }// GEN-LAST:event_disableMouseClicked

    private void showMouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_showMouseClicked
        txtpassword.setEchoChar((char) 8226);
        disable.setVisible(true);
        disable.setEnabled(true);
        show.setEnabled(false);
        show.setEnabled(false);
    }// GEN-LAST:event_showMouseClicked

    private void formWindowOpened(java.awt.event.WindowEvent evt) {// GEN-FIRST:event_formWindowOpened
        for (double i = 0.0; i <= 1.0; i = i + 0.1) {
            String val = i + "";
            float f = Float.valueOf(val);
            this.setOpacity(f);
            try {
                Thread.sleep(50);
            } catch (Exception e) {

            }
        }
    }// GEN-LAST:event_formWindowOpened

    private void xuLyDangNhap() {
        staff_BUS = new Staff_BUS();
        String username = txtusername.getText();
        String password = txtpassword.getText();
        Staff_DTO s = staff_BUS.Login(username, password);
        if (s != null) {
            MainManager gui = new MainManager();
            this.dispose();
        }

    }

    // /**
    // * @param args the command line arguments
    // */
    // public static void main(String args[]) {
    // /* Set the Nimbus look and feel */
    // //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code
    // (optional) ">
    // /* If Nimbus (introduced in Java SE 6) is not available, stay with the
    // default look and feel.
    // * For details see
    // http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
    // */
    // try {
    // for (javax.swing.UIManager.LookAndFeelInfo info :
    // javax.swing.UIManager.getInstalledLookAndFeels()) {
    // if ("Nimbus".equals(info.getName())) {
    // javax.swing.UIManager.setLookAndFeel(info.getClassName());
    // break;
    // }
    // }
    // } catch (ClassNotFoundException ex) {
    // java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE,
    // null, ex);
    // } catch (InstantiationException ex) {
    // java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE,
    // null, ex);
    // } catch (IllegalAccessException ex) {
    // java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE,
    // null, ex);
    // } catch (javax.swing.UnsupportedLookAndFeelException ex) {
    // java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE,
    // null, ex);
    // }
    // //</editor-fold>

    // /* Create and display the form */
    // java.awt.EventQueue.invokeLater(new Runnable() {
    // public void run() {
    // new login().setVisible(true);
    // }
    // });
    // }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLogin;
    private javax.swing.JLabel disable;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel lbBg;
    private javax.swing.JLabel lbExit;
    private javax.swing.JLabel lbFoget;
    private javax.swing.JLabel lbIconUser;
    private javax.swing.JLabel lbLogin;
    private javax.swing.JLabel lbPassword;
    private javax.swing.JLabel lbTitle;
    private javax.swing.JLabel lbUserName;
    private javax.swing.JPanel pnBG;
    private javax.swing.JPanel pnFormLogin;
    private javax.swing.JLabel show;
    private javax.swing.JPasswordField txtpassword;
    private javax.swing.JTextField txtusername;
    // End of variables declaration//GEN-END:variables
}
