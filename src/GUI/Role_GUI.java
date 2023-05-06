package GUI;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;

import BUS.Role_BUS;
import DTO.Role_DTO;
import GUI.MyCustom.MyTable;
import GUI.MyCustom.TransparentPanel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Role_GUI extends javax.swing.JPanel {

    public Role_GUI() {
        addControl();
        addEvent();
    }

    DefaultTableModel dtmRole = new DefaultTableModel() {
        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };
    MyTable tbRole;

    private Role_BUS role_BUS;

    final Color colorPanel = new Color(247, 247, 247);
    private JButton btnReset;
    private JButton btnAdd, btnUpdate, btnDel, btnSearch;
    private JComboBox<String> cmbCrudStaff, cmbCrudBook, cmbCrudPub,
            cmbCrudRole, cmbCrudCardLibary, cmbCrudOrder;
    private JTextField txtId, jtfSearch;

    private void addControl() {
        Font font = new Font("Tahoma", Font.PLAIN, 20);
        this.setLayout(new BorderLayout());
        this.setBackground(colorPanel);
        /*
         * =========================================================================
         * PANEL Quyền
         * =========================================================================
         */
        JPanel pnRole = new TransparentPanel();
        pnRole.setLayout(new BoxLayout(pnRole, BoxLayout.Y_AXIS));

        JPanel pnTop = new TransparentPanel();
        pnTop.setLayout(new BoxLayout(pnTop, BoxLayout.Y_AXIS));

        JPanel pnTitile = new TransparentPanel();
        JLabel lblTitle = new JLabel("<html><h1>QUẢN LÝ PHÂN QUYỀN </h1></html>");
        btnReset = new JButton("reset");
        btnReset.setPreferredSize(new Dimension(70, 40));
        pnTitile.add(lblTitle);
        pnTitile.add(btnReset);
        pnTop.add(pnTitile);
        // ======PANEL COMBOBOX=======
        JPanel pnComboBox = new TransparentPanel();
        pnComboBox.setLayout(new BoxLayout(pnComboBox, BoxLayout.Y_AXIS));

        JLabel lbID, lbStaff, lbBook, lbPub, lbRole, lbCB, lbOrder;
        lbID = new JLabel("MÃ QUYỀN");
        lbStaff = new JLabel("QL NHÂN VIÊN");
        lbBook = new JLabel("QL SÁCH");
        lbPub = new JLabel("QL NXB");
        lbRole = new JLabel("QL QUYỀN");
        lbCB = new JLabel("QL THẺ THƯ VIỆN");
        lbOrder = new JLabel("QL PHIẾU MƯỢN TRẢ");

        lbID.setFont(font);
        lbStaff.setFont(font);
        lbBook.setFont(font);
        lbPub.setFont(font);
        lbRole.setFont(font);
        lbCB.setFont(font);
        lbOrder.setFont(font);

        txtId = new JTextField(20);
        txtId.setEditable(false);
        cmbCrudStaff.addItem("Chọn status");
        cmbCrudStaff.addItem("True");
        cmbCrudStaff.addItem("False");
        cmbCrudBook.addItem("Chọn status");
        cmbCrudBook.addItem("True");
        cmbCrudBook.addItem("False");
        cmbCrudPub.addItem("Chọn status");
        cmbCrudPub.addItem("True");
        cmbCrudPub.addItem("False");
        cmbCrudRole.addItem("Chọn status");
        cmbCrudRole.addItem("True");
        cmbCrudRole.addItem("False");
        cmbCrudCardLibary.addItem("Chọn status");
        cmbCrudCardLibary.addItem("True");
        cmbCrudCardLibary.addItem("False");
        cmbCrudOrder.addItem("Chọn status");
        cmbCrudOrder.addItem("True");
        cmbCrudOrder.addItem("False");

        txtId.setFont(font);
        cmbCrudBook.setFont(font);
        cmbCrudCardLibary.setFont(font);
        cmbCrudOrder.setFont(font);
        cmbCrudPub.setFont(font);
        cmbCrudRole.setFont(font);
        cmbCrudStaff.setFont(font);

        JPanel pnID = new TransparentPanel();
        pnID.add(lbID);
        pnID.add(txtId);
        pnComboBox.add(pnID);

        JPanel pnStaff = new TransparentPanel();
        pnStaff.add(lbStaff);
        pnStaff.add(cmbCrudStaff);
        pnComboBox.add(pnStaff);

        JPanel pnBook = new TransparentPanel();
        pnBook.add(lbBook);
        pnBook.add(cmbCrudBook);
        pnComboBox.add(pnBook);

        JPanel pnPub = new TransparentPanel();
        pnPub.add(lbPub);
        pnPub.add(cmbCrudPub);
        pnComboBox.add(pnPub);

        JPanel pnCmbRole = new TransparentPanel();
        pnCmbRole.add(lbRole);
        pnCmbRole.add(cmbCrudRole);
        pnComboBox.add(pnCmbRole);

        JPanel pnCard = new TransparentPanel();
        pnCard.add(lbCB);
        pnCard.add(cmbCrudCardLibary);
        pnComboBox.add(pnCard);

        JPanel pnOrder = new TransparentPanel();
        pnOrder.add(lbOrder);
        pnOrder.add(cmbCrudOrder);
        pnComboBox.add(pnOrder);

        Dimension cmbSize = new Dimension(150, 40);
        cmbCrudBook.setPreferredSize(cmbSize);
        cmbCrudCardLibary.setPreferredSize(cmbSize);
        cmbCrudOrder.setPreferredSize(cmbSize);
        cmbCrudPub.setPreferredSize(cmbSize);
        cmbCrudRole.setPreferredSize(cmbSize);
        cmbCrudStaff.setPreferredSize(cmbSize);

        pnTop.add(pnComboBox);
        pnRole.add(pnTop);

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

        pnRole.add(pnButton);

        Dimension btnSize = btnAdd.getPreferredSize();
        btnAdd.setPreferredSize(btnSize);
        btnDel.setPreferredSize(btnSize);
        btnUpdate.setPreferredSize(btnSize);

        // ====PANEL SEARCH=====
        JPanel pnSearch = new TransparentPanel();
        JLabel lblSearch = new JLabel("Nhập từ khóa");

        lblSearch.setFont(font);
        jtfSearch = new JTextField(20);
        jtfSearch.setFont(font);
        btnSearch = new JButton("Find");
        btnSearch.setPreferredSize(new Dimension(70, 40));

        pnSearch.add(lblSearch);
        pnSearch.add(jtfSearch);
        pnSearch.add(btnSearch);
        pnRole.add(pnSearch);

        // ==========TABLE===========
        dtmRole.addColumn("Mã QUYỀN");
        dtmRole.addColumn("QL NHÂN VIÊN");
        dtmRole.addColumn("QL SÁCH");
        dtmRole.addColumn("QL NXB");
        dtmRole.addColumn("QL QUYỀN");
        dtmRole.addColumn("QL THẺ THƯ VIỆN");
        dtmRole.addColumn("QL PHIẾU MƯỢN TRẢ");
        tbRole = new MyTable(dtmRole);

        JScrollPane scrtbRole = new JScrollPane(tbRole);

        this.add(pnRole, BorderLayout.NORTH);
        this.add(scrtbRole, BorderLayout.CENTER);

        loadData();

    }

    private void addEvent() {
    }

    private void loadData() {
        role_BUS = new Role_BUS();
        loadData(role_BUS.getAllStaff());
    }

    private void loadData(List<Role_DTO> listitem) {
        dtmRole.setRowCount(0);
        for (Role_DTO nxb : listitem) {
            Vector vec = new Vector();
            dtmRole.addRow(vec);
        }
    }
}
