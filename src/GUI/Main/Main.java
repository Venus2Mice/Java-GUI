package GUI.Main;

import GUI.Account_GUI;
import GUI.Book_GUI;
import GUI.NXB_GUI;
import GUI.MyCustom.event.EventMenuSelected;
import GUI.MyCustom.form.Form_2;
import GUI.MyCustom.form.Form_3;
import GUI.MyCustom.form.Dashboard;
import GUI.Staff_GUI;
import GUI.Order_GUI;
import java.awt.Color;
import javax.swing.JComponent;

public class Main extends javax.swing.JFrame {

    private Dashboard home;
    private Form_2 form2;
    private Form_3 form3;
    private NXB_GUI formNXB;
    private Book_GUI formBook;
    private Staff_GUI formStaff;
    private Order_GUI formOrder;
    private Account_GUI formAccount;

    public Main() {
        initComponents();
        setBackground(new Color(0, 0, 0, 0));
        home = new Dashboard();
        form2 = new Form_2();
        form3 = new Form_3();
        formNXB = new NXB_GUI();
        formBook = new Book_GUI();
        formStaff = new Staff_GUI();
        formOrder = new Order_GUI();
        formAccount = new Account_GUI();
        pnMenu.initMoving(Main.this);
        pnMenu.addEventMenuSelected(new EventMenuSelected() {
            @Override
            public void selected(int index) {
                switch (index) {
                    case 1:
                        setForm(home);
                        break;
                    case 2:
                        setForm(formBook);
                        break;
                    case 3:
                        setForm(formNXB);
                        break;
                    case 4:
                        setForm(formStaff);
                        break;
                    case 5:
                        setForm(formOrder);
                        break;
                    case 6:
                        setForm(formAccount);
                        break;
                    default : setForm(form2);
                }
            }
        });
        setForm(new Dashboard());
    }

    private void setForm(JComponent com) {
        pnContainer.removeAll();
        pnContainer.add(com);
        pnContainer.repaint();
        pnContainer.revalidate();
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

        pnMain = new GUI.MyCustom.swing.PanelBorder();
        pnContainer = new javax.swing.JPanel();
        pnHeader = new GUI.MyCustom.component.Header();
        pnMenu = new GUI.MyCustom.component.Menu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        pnContainer.setOpaque(false);
        pnContainer.setLayout(new java.awt.BorderLayout());

        javax.swing.GroupLayout pnMainLayout = new javax.swing.GroupLayout(pnMain);
        pnMain.setLayout(pnMainLayout);
        pnMainLayout.setHorizontalGroup(
            pnMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnMainLayout.createSequentialGroup()
                .addComponent(pnMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnMainLayout.createSequentialGroup()
                        .addComponent(pnContainer, javax.swing.GroupLayout.DEFAULT_SIZE, 986, Short.MAX_VALUE)
                        .addContainerGap())
                    .addComponent(pnHeader, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        pnMainLayout.setVerticalGroup(
            pnMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnMainLayout.createSequentialGroup()
                .addGroup(pnMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(pnMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pnMainLayout.createSequentialGroup()
                        .addComponent(pnHeader, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pnContainer, javax.swing.GroupLayout.DEFAULT_SIZE, 636, Short.MAX_VALUE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1237, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(pnMain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 712, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(pnMain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        // <editor-fold defaultstate="collapsed" desc=" Look and feel setting code
        // (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the default
         * look and feel.
         * For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        // </editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel pnContainer;
    private GUI.MyCustom.component.Header pnHeader;
    private GUI.MyCustom.swing.PanelBorder pnMain;
    private GUI.MyCustom.component.Menu pnMenu;
    // End of variables declaration//GEN-END:variables

    public static void changLNF(String string) {
    }
}