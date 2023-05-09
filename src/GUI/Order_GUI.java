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
import java.sql.Date;

import DTO.Order_DTO;
import GUI.MyCustom.MyTable;
import GUI.MyCustom.TransparentPanel;
import BUS.Order_BUS;
import BUS.Role_BUS;

public class Order_GUI extends javax.swing.JPanel {

    public Order_GUI() {
        addControl();
        addEvent();
    }

    DefaultTableModel dtmOrder = new DefaultTableModel() {
        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };
    MyTable tbOrder;

    private Order_BUS order_BUS;
    private Role_BUS role_BUS;

    final Color colorPanel = new Color(247, 247, 247);
    public static JButton btnReset;
    private JButton btnAdd, btnDel, btnSearch , btnDetail , btnUpdate;
    private JTextField txtSearch, txtID , txtIDStaff, txtIDLibCard, txtDayinit , txtDesc, txtDayreturn;
    private DateChooser datyInit, dayReturn;
    private JCheckBox ckStatus;

    private void addControl() {
        Font font = new Font("Tahoma", Font.PLAIN, 15);
        this.setLayout(new BorderLayout());
        this.setBackground(colorPanel);

        JPanel pnOrder = new TransparentPanel();
        pnOrder.setLayout(new BoxLayout(pnOrder, BoxLayout.Y_AXIS));

        JPanel pnTop = new TransparentPanel();
        pnTop.setLayout(new BoxLayout(pnTop, BoxLayout.X_AXIS));

        JPanel pnTitile = new TransparentPanel();
        JLabel lblTitle = new JLabel("<html><h1>QUẢN LÝ PHIẾU MƯỢN</h1></html>");
        btnReset = new JButton("Reset");
        btnReset.setPreferredSize(new Dimension(70, 40));
        pnTitile.add(lblTitle);
        pnTitile.add(btnReset);
        pnOrder.add(pnTitile);

        JPanel pnTextFiledLeft = new TransparentPanel();
        pnTextFiledLeft.setLayout(new BoxLayout(pnTextFiledLeft, BoxLayout.Y_AXIS));
        JPanel pnTextFiledRight = new TransparentPanel();
        pnTextFiledRight.setLayout(new BoxLayout(pnTextFiledRight, BoxLayout.Y_AXIS));

        JLabel lbID, lbIDStaff, lbIDLibCard , lbDayinit , lbStatus, lbDesc , lbDayReturn;
        lbID = new JLabel("ID");
        lbIDStaff = new JLabel("ID NV");
        lbIDLibCard = new JLabel("ID THẺ THƯ VIỆN");
        lbDayinit = new JLabel("NGÀY TẠO");
        lbStatus = new JLabel("TRẠNG THÁI");
        lbDesc = new JLabel("Ghi chú");
        lbDayReturn = new JLabel("NGÀY TRẢ");

        lbID.setFont(font);
        lbIDStaff.setFont(font);
        lbIDLibCard.setFont(font);
        lbDayinit.setFont(font);
        lbStatus.setFont(font);
        lbDesc.setFont(font);
        lbDayReturn.setFont(font);

        txtID = new JTextField(15);
        txtID.setEditable(false);
        txtIDStaff = new JTextField(15);
        txtIDStaff.setEditable(false);
        txtIDLibCard = new JTextField(15);
        txtDayinit = new JTextField(15);
        txtDesc = new JTextField(15);
        txtDesc.setPreferredSize(new Dimension(60, 80));
        txtDayreturn = new JTextField(15);

        ckStatus = new JCheckBox();

        txtID.setFont(font);
        txtIDStaff.setFont(font);
        txtIDLibCard.setFont(font);
        txtDayinit.setFont(font);
        txtDesc.setFont(font);
        txtDayreturn.setFont(font);

        datyInit = new DateChooser();
        datyInit.setDateFormat("yyyy-MM-dd");
        datyInit.setTextRefernce(txtDayinit);

        dayReturn = new DateChooser();
        dayReturn.setDateFormat("yyyy-MM-dd");
        dayReturn.setTextRefernce(txtDayreturn);

        JPanel pnID = new TransparentPanel();
        pnID.add(lbID);
        pnID.add(txtID);
        pnTextFiledLeft.add(pnID);

        JPanel pnIDStaff = new TransparentPanel();
        pnIDStaff.add(lbIDStaff);
        pnIDStaff.add(txtIDStaff);
        pnTextFiledLeft.add(pnIDStaff);

        JPanel pnIdLibCard = new TransparentPanel();
        pnIdLibCard.add(lbIDLibCard);
        pnIdLibCard.add(txtIDLibCard);
        pnTextFiledLeft.add(pnIdLibCard);

        JPanel pnDesc = new TransparentPanel();
        pnDesc.add(lbDesc);
        pnDesc.add(txtDesc);
        pnTextFiledLeft.add(pnDesc);

        JPanel pnDayReturn = new TransparentPanel();
        pnDayReturn.add(lbDayReturn);
        pnDayReturn.add(txtDayreturn);
        pnTextFiledRight.add(pnDayReturn);

        JPanel pnDayInit = new TransparentPanel();
        pnDayInit.add(lbDayinit);
        pnDayInit.add(txtDayinit);
        pnTextFiledRight.add(pnDayInit);

        JPanel pnCkStatus = new TransparentPanel();
        pnCkStatus.add(lbStatus);
        pnCkStatus.add(ckStatus);
        pnTextFiledRight.add(pnCkStatus);

        Dimension lbSize = new Dimension(125, 40);
        lbID.setPreferredSize(lbSize);
        lbIDStaff.setPreferredSize(lbSize);
        lbIDLibCard.setPreferredSize(lbSize);
        lbDayinit.setPreferredSize(lbSize);
        lbStatus.setPreferredSize(lbSize);
        lbDesc.setPreferredSize(lbSize);
        lbDayReturn.setPreferredSize(lbSize);
        
        pnTop.add(pnTextFiledLeft, BorderLayout.WEST);
        pnTop.add(pnTextFiledRight, BorderLayout.EAST);
        pnOrder.add(pnTop);

        JPanel pnButton = new TransparentPanel();
        btnAdd = new JButton("Thêm");
        btnDel = new JButton("Xóa");
        btnUpdate = new JButton("Sửa");
        btnDetail = new JButton("Xem chi tiết");

        Font fntBtn = new Font("Tahoma", Font.PLAIN, 16);

        btnAdd.setFont(fntBtn);
        btnDel.setFont(fntBtn);
        btnDetail.setFont(font);
        btnUpdate.setFont(font);

        pnButton.add(btnAdd);
        pnButton.add(btnDel);
        pnButton.add(btnUpdate);
        pnButton.add(btnDetail);

        pnOrder.add(pnButton);

        Dimension btnSize = btnAdd.getPreferredSize();
        btnAdd.setPreferredSize(btnSize);
        btnDel.setPreferredSize(btnSize);

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
        pnOrder.add(pnSearch);

        dtmOrder.addColumn("Mã ID");
        dtmOrder.addColumn("MÃ THẺ");
        dtmOrder.addColumn("MÃ NHÂN VIÊN");
        dtmOrder.addColumn("NGÀY TẠO");
        dtmOrder.addColumn("NGÀY TRẢ");
        dtmOrder.addColumn("GHI CHÚ");
        dtmOrder.addColumn("TRẠNG THÁI");

        tbOrder = new MyTable(dtmOrder);

        JScrollPane srctbOrder = new JScrollPane(tbOrder);

        this.add(pnOrder, BorderLayout.NORTH);
        this.add(srctbOrder, BorderLayout.CENTER);

        loadData();
    }

    private void addEvent() {
        
        btnReset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loadData();
                txtID.setText("");
                txtIDStaff.setText("");
                txtIDLibCard.setText("");
                txtDayinit.setText("");
                txtDayreturn.setText("");
                txtDesc.setText("");
                ckStatus.setSelected(false);
            }
        });

        tbOrder.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                clickTbEventOrder();
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

        btnDetail.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String txt = txtID.getText();
                if(!txt.equals(""))
                    new DialogDetailOrder_GUI(Integer.parseInt(txt));
            }
        });

        btnUpdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                eUpdate();
            }
        });
        
    }

    private void loadData() {
        order_BUS = new Order_BUS();
        loadData(order_BUS.getAllOrder());
    }

    private void loadData(List<Order_DTO> listitem) {
        dtmOrder.setRowCount(0);
        for (Order_DTO o : listitem) {
            Vector vec = new Vector();
            vec.add(o.getOrder_id());
            vec.add(o.getCard_id());
            vec.add(o.getStaff_id());
            vec.add(o.getDay_init());
            vec.add(o.getDay_return());
            vec.add(o.getDesc());
            vec.add(o.isStatus());
        
            dtmOrder.addRow(vec);
        }
    }

    private void clickTbEventOrder() {
        int row = tbOrder.getSelectedRow();
        if (row > -1) {
            txtID.setText(tbOrder.getValueAt(row, 0) + "");
            txtIDLibCard.setText(tbOrder.getValueAt(row, 1) + "");
            txtIDStaff.setText(tbOrder.getValueAt(row, 2) + "");
            txtDayinit.setText(tbOrder.getValueAt(row, 3) + "");
            txtDayreturn.setText(tbOrder.getValueAt(row, 4) + "");
            txtDesc.setText(tbOrder.getValueAt(row, 5) + "");
            Boolean b = Boolean.parseBoolean((tbOrder.getValueAt(row, 6))+"") ;
            ckStatus.setSelected(b);
        }
    }

    private void eventAddBook() {
            new DialogCreateOrder_GUI();
            btnReset.doClick();
    }

    private void eUpdate(){
        int id_order = Integer.parseInt(txtID.getText());
        int id_card = Integer.parseInt(txtIDLibCard.getText());
        int id_staff = Integer.parseInt(txtIDStaff.getText());
        Date dayInit = Date.valueOf(txtDayinit.getText());
        String desc = txtDesc.getText();
        boolean status = ckStatus.isSelected();
        Date dayReturn = Date.valueOf(txtDayreturn.getText());

        Order_DTO o = new Order_DTO(id_order, id_card, id_staff, dayInit, desc, dayReturn, status);
        order_BUS.updateOrder(o);
        
        btnReset.doClick();
    }


    private void eventDeleteBook() {
            int id = Integer.parseInt(txtID.getText());
            order_BUS.deleteOrder(id);
            btnReset.doClick();
    }

    private void LiveSearch() {
        ArrayList<Order_DTO> list = order_BUS.findByKey(txtSearch.getText());
        loadData(list);
    }
}
