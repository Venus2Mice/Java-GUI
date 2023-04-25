package GUI;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import DTO.Publisher_DTO;
import GUI.MyCustom.MyTable;
import GUI.MyCustom.TransparentPanel;
import BUS.Publisher_BUS;

public class NXB_GUI extends javax.swing.JPanel {

    public NXB_GUI() {
        addControl();
        addEvent();
    }

    DefaultTableModel dtmNXB = new DefaultTableModel() {
        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };
    MyTable tbNXB;

    private Publisher_BUS publisher_BUS;

    final Color colorPanel = new Color(247, 247, 247);
    private JButton btnReset;
    private JButton btnAdd, btnUpdate, btnDel, btnSearch;
    private JTextField jtfSearch, jtxPubID, jtfPubName, jtfAdress, jtfEmail;

    private void addControl() {
        Font font = new Font("Tahoma", Font.PLAIN, 20);
        this.setLayout(new BorderLayout());
        this.setBackground(colorPanel);
        /*
         * =========================================================================
         * PANEL NHÀ XUẤT BẢN
         * =========================================================================
         */
        JPanel pnNXB = new TransparentPanel();
        pnNXB.setLayout(new BoxLayout(pnNXB, BoxLayout.Y_AXIS));

        JPanel pnTop = new TransparentPanel();
        pnTop.setLayout(new BoxLayout(pnTop, BoxLayout.Y_AXIS));

        JPanel pnTitile = new TransparentPanel();
        JLabel lblTitle = new JLabel("<html><h1>QUẢN LÝ NHÀ XUẤT BẢN</h1></html>");
        btnReset = new JButton("reset");
        btnReset.setPreferredSize(new Dimension(70, 40));
        pnTitile.add(lblTitle);
        pnTitile.add(btnReset);
        pnTop.add(pnTitile);

        // ======PANEL TEXT FIELD=======
        JPanel pnTextFiled = new TransparentPanel();
        pnTextFiled.setLayout(new BoxLayout(pnTextFiled, BoxLayout.Y_AXIS));

        JLabel lbID, lbName, lbAdress, lbEmail;
        lbID = new JLabel("Mã NXB");
        lbName = new JLabel("Tên NXB");
        lbAdress = new JLabel("Địa chỉ");
        lbEmail = new JLabel("Email");

        lbID.setFont(font);
        lbName.setFont(font);
        lbAdress.setFont(font);
        lbEmail.setFont(font);

        jtxPubID = new JTextField(20);
        jtxPubID.setEditable(false);
        jtfPubName = new JTextField(20);
        jtfAdress = new JTextField(20);
        jtfEmail = new JTextField(20);

        jtxPubID.setFont(font);
        jtfPubName.setFont(font);
        jtfAdress.setFont(font);
        jtfEmail.setFont(font);

        JPanel pnID = new TransparentPanel();
        pnID.add(lbID);
        pnID.add(jtxPubID);
        pnTextFiled.add(pnID);

        JPanel pnName = new TransparentPanel();
        pnName.add(lbName);
        pnName.add(jtfPubName);
        pnTextFiled.add(pnName);

        JPanel pnAdress = new TransparentPanel();
        pnAdress.add(lbAdress);
        pnAdress.add(jtfAdress);
        pnTextFiled.add(pnAdress);

        JPanel pnEmail = new TransparentPanel();
        pnEmail.add(lbEmail);
        pnEmail.add(jtfEmail);
        pnTextFiled.add(pnEmail);

        Dimension lbSize = new Dimension(125, 25);
        lbID.setPreferredSize(lbSize);
        lbName.setPreferredSize(lbSize);
        lbAdress.setPreferredSize(lbSize);
        lbEmail.setPreferredSize(lbSize);

        pnTop.add(pnTextFiled);
        pnNXB.add(pnTop);

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

        pnNXB.add(pnButton);

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
        pnNXB.add(pnSearch);

        // ==========TABLE===========
        dtmNXB.addColumn("Mã NXB");
        dtmNXB.addColumn("Tên NXB");
        dtmNXB.addColumn("Địa chỉ");
        dtmNXB.addColumn("Email");
        tbNXB = new MyTable(dtmNXB);

        JScrollPane scrtbNXB = new JScrollPane(tbNXB);

        this.add(pnNXB, BorderLayout.NORTH);
        this.add(scrtbNXB, BorderLayout.CENTER);

        loadData();
    }

    private void addEvent() {
        btnReset.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                loadData();
                jtxPubID.setText("");
                jtfPubName.setText("");
                jtfAdress.setText("");
                jtfEmail.setText("");
            }
        });

        tbNXB.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                clickTbEventNXB();
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

        jtfSearch.getDocument().addDocumentListener((DocumentListener) new DocumentListener() {
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
                eventAddNXB();
            }
        });

        btnDel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                eventDeleteNXB();
            }
        });

        btnUpdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                eventUpdateNXB();
            }
        });

    }

    private void loadData() {
        publisher_BUS = new Publisher_BUS();
        loadData(publisher_BUS.getAllPub());
    }

    private void loadData(List<Publisher_DTO> listitem) {
        dtmNXB.setRowCount(0);
        for (Publisher_DTO nxb : listitem) {
            Vector vec = new Vector();
            vec.add(nxb.getPubliser_id());
            vec.add(nxb.getPublisher_name());
            vec.add(nxb.getAdress());
            vec.add(nxb.getEmail());
            dtmNXB.addRow(vec);
        }
    }

    private void clickTbEventNXB() {
        int row = tbNXB.getSelectedRow();
        if (row > -1) {
            jtxPubID.setText(tbNXB.getValueAt(row, 0) + "");
            jtfPubName.setText(tbNXB.getValueAt(row, 1) + "");
            jtfAdress.setText(tbNXB.getValueAt(row, 2) + "");
            jtfEmail.setText(tbNXB.getValueAt(row, 3) + "");
        }
    }

    private void eventAddNXB() {
        Publisher_DTO p = publisher_BUS.initPub(jtxPubID.getText(), jtfPubName.getText(), jtfAdress.getText(),
                jtfEmail.getText());
        if (publisher_BUS.addPub(p))
            btnReset.doClick();
            Book_GUI.btnReset.doClick();
    }

    private void eventUpdateNXB() {
        Publisher_DTO p = publisher_BUS.initPub(jtxPubID.getText(), jtfPubName.getText(), jtfAdress.getText(),
                jtfEmail.getText());
        if (publisher_BUS.updatePub(p))
            btnReset.doClick();
            Book_GUI.btnReset.doClick();
    }

    private void eventDeleteNXB() {
        Publisher_DTO p = publisher_BUS.initPub(jtxPubID.getText(), jtfPubName.getText(), jtfAdress.getText(),
                jtfEmail.getText());
        if (publisher_BUS.deletePub(p))
            btnReset.doClick();
            Book_GUI.btnReset.doClick();
    }

    private void LiveSearch() {
        ArrayList<Publisher_DTO> list = publisher_BUS.findByKey(jtfSearch.getText());
        loadData(list);
    }

}
