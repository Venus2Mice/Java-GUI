package GUI;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;
import java.util.Vector;

import javax.swing.BoxLayout;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import BUS.Book_BUS;
import BUS.OrderDetail_BUS;
import GUI.MyCustom.MyTable;
import DTO.Book_DTO;
import DTO.OrderDetail_DTO;

public class DialogDetailOrder_GUI extends JDialog {
    private OrderDetail_BUS orderDetail_BUS;
    private Book_BUS book_BUS;

    public DialogDetailOrder_GUI(int id) {
        orderDetail_BUS = new OrderDetail_BUS();
        book_BUS = new Book_BUS();
        addControl(id);
        addEvent(id);

        this.setSize(500, 400);
        this.setModal(true);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);

    }

    private JTextField txtTuKhoa;
    private JTable tblDetail;
    private DefaultTableModel dtmDetail;
    private JLabel lbIdOrder;

    private void addControl(int id) {
        Container con = getContentPane();
        con.setLayout(new BorderLayout());

        Font font = new Font("Tahoma", Font.PLAIN, 16);
        JPanel pnTop = new JPanel();

        lbIdOrder = new JLabel("Chi tiết Phiếu id:" + id);
        JLabel lblTuKhoa = new JLabel("Từ khoá tìm");

        txtTuKhoa = new JTextField(20);
        lblTuKhoa.setFont(font);
        lbIdOrder.setFont(font);
        txtTuKhoa.setFont(font);
        
        JPanel pntitle = new JPanel();
        pntitle.add(lbIdOrder);

        pnTop.add(pntitle);
        pnTop.add(lblTuKhoa);
        pnTop.add(txtTuKhoa);

        JPanel pnHeader = new JPanel();
        pnHeader.setLayout(new BoxLayout(pnHeader, BoxLayout.Y_AXIS));
        pnHeader.add(pntitle);
        pnHeader.add(pnTop);

        con.add(pnHeader, BorderLayout.NORTH);

        JPanel pnTable = new JPanel();
        pnTable.setLayout(new BorderLayout());
        dtmDetail = new DefaultTableModel();
        dtmDetail.addColumn("Mã sách");
        dtmDetail.addColumn("Tên sách");
        dtmDetail.addColumn("Tên tác giả");
        tblDetail = new MyTable(dtmDetail);

        JScrollPane scrDetail = new JScrollPane(tblDetail);
        pnTable.add(scrDetail, BorderLayout.CENTER);
        con.add(pnTable, BorderLayout.CENTER);

        loadDataLenTable(id);
    }

    private void addEvent(int id) {

        txtTuKhoa.getDocument().addDocumentListener((DocumentListener) new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                String txt = txtTuKhoa.getText();
                if (!txt.toLowerCase().equals("")) {
                    loadDataLenTable(txtTuKhoa.getText(), id);
                }
            }
            @Override
            public void removeUpdate(DocumentEvent e) {
                String txt = txtTuKhoa.getText();
                if (!txt.toLowerCase().equals("")) {
                    loadDataLenTable(txtTuKhoa.getText(), id);
                }
            }
            @Override
            public void changedUpdate(DocumentEvent e) {
                String txt = txtTuKhoa.getText();
                if (!txt.toLowerCase().equals("")) {
                    loadDataLenTable(txtTuKhoa.getText(), id);
                }
            }
        });

        tblDetail.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // TODO Auto-generated method stub
                if (e.getClickCount() == 2) {
                    xuLyChonSach();
                }
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
    }

    private void xuLyChonSach() {
        int row = tblDetail.getSelectedRow();
        tblDetail.removeRowSelectionInterval(row, row);
    }

    private void loadDataLenTable(int id) {
        dtmDetail.setRowCount(0);
        List<OrderDetail_DTO> list = orderDetail_BUS.getAllDetailById(id);
        if (list != null) {
            for (OrderDetail_DTO dt : list) {
                Book_DTO b = book_BUS.getById(dt.getIsbn_book());
                Vector vec = new Vector();
                vec.add(dt.getIsbn_book());
                vec.add(b.getBook_name());
                vec.add(b.getAuthors());
                dtmDetail.addRow(vec);
            }
        }
    }

    private void loadDataLenTable(String tuKhoa, int id) {
        dtmDetail.setRowCount(0);
        List<OrderDetail_DTO> list = orderDetail_BUS.getAllDetailById(id);
        if (list != null) {
            for (OrderDetail_DTO dt : list) {
                Book_DTO b = book_BUS.getById(dt.getIsbn_book());
                Vector vec = new Vector();
                if (b.getIsbn_code().toLowerCase().contains(tuKhoa) ||
                        b.getBook_name().toLowerCase().contains(tuKhoa) ||
                        b.getAuthors().toLowerCase().contains(tuKhoa)) {
                    vec.add(b.getIsbn_code());
                    vec.add(b.getBook_name());
                    vec.add(b.getAuthors());
                }
                dtmDetail.addRow(vec);
            }
        }
    }

}
