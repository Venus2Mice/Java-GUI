package GUI;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import BUS.Book_BUS;
import BUS.LibCard_BUS;
import BUS.OrderDetail_BUS;
import BUS.Order_BUS;
import BUS.Staff_BUS;
import GUI.MyCustom.MyTable;
import GUI.MyCustom.TransparentPanel;
import GUI.MyCustom.datechooser.DateChooser;
import DTO.Book_DTO;
import DTO.LibCard_DTO;
import DTO.Order_DTO;

public class DialogCreateOrder_GUI extends JDialog {
    private Order_BUS order_BUS;
    private OrderDetail_BUS orderDetail_BUS;
    private Book_BUS book_BUS;
    private LibCard_BUS libCard_BUS;
    private List<Book_DTO> listAdd = new ArrayList<Book_DTO>();

    DefaultTableModel dtmBook = new DefaultTableModel() {
        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };

    DefaultTableModel dtmListBookAdd = new DefaultTableModel() {
        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };

    public DialogCreateOrder_GUI() {
        orderDetail_BUS = new OrderDetail_BUS();
        book_BUS = new Book_BUS();
        order_BUS = new Order_BUS();
        libCard_BUS = new LibCard_BUS();

        addControl();
        addEvent();

        this.setSize(900, 600);
        this.setModal(true);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);

    }

    private JTextField txtIdLibCard, txtDayinit, txtDesc;
    private DateChooser dayinit;
    private JTable tblBook, tbListBookAdd;
    private JLabel lbIdOrder, lbIdLibCard, lbDayinit, lbTitleTableBook, lbTileTableBookListAdd, lbDesc;
    private JButton btnAdd;
    private JComboBox cmbLibCard;

    private void addControl() {
        Container con = getContentPane();
        con.setLayout(new BoxLayout(con, BoxLayout.X_AXIS));

        Font font = new Font("Tahoma", Font.PLAIN, 16);

        JPanel pnHeader = new JPanel();
        pnHeader.setLayout(new BoxLayout(pnHeader, BoxLayout.Y_AXIS));

        txtDayinit = new JTextField(15);
        dayinit = new DateChooser();
        dayinit.setDateFormat("yyyy-MM-dd");
        dayinit.setTextRefernce(txtDayinit);
        txtIdLibCard = new JTextField(15);
        txtDesc = new JTextField(15);
        txtDesc.setPreferredSize(new Dimension(60, 80));

        lbDayinit = new JLabel("Ngày tạo");
        lbIdLibCard = new JLabel("Id thẻ thư viện");
        lbIdOrder = new JLabel("Tạo mới phiếu mượn sách");
        lbTitleTableBook = new JLabel("Danh sách các cuốn sách");
        lbTileTableBookListAdd = new JLabel("Sách đã thêm ");
        lbDesc = new JLabel("Ghi chú");

        cmbLibCard = new JComboBox<>();
        cmbLibCard.addItem("Chọn tên độc giả");
        for (LibCard_DTO c : libCard_BUS.getAllStaff()) {
            cmbLibCard.addItem(c.getName());
        }

        txtDayinit.setFont(font);
        txtIdLibCard.setFont(font);
        txtDesc.setFont(font);
        lbIdOrder.setFont(font);
        lbDayinit.setFont(font);
        lbIdLibCard.setFont(font);
        lbTitleTableBook.setFont(font);
        lbTileTableBookListAdd.setFont(font);
        lbDesc.setFont(font);
        cmbLibCard.setFont(font);

        JPanel pnForm = new JPanel();
        pnForm.setLayout(new BoxLayout(pnForm, BoxLayout.Y_AXIS));

        JPanel pnDayinit = new TransparentPanel();
        pnDayinit.add(lbDayinit);
        pnDayinit.add(txtDayinit);

        JPanel pnIdLibCard = new TransparentPanel();
        pnIdLibCard.add(lbIdLibCard);
        pnIdLibCard.add(cmbLibCard);

        JPanel pnDesc = new TransparentPanel();
        pnDesc.add(lbDesc);
        pnDesc.add(txtDesc);

        pnForm.add(pnIdLibCard);
        pnForm.add(pnDayinit);
        pnForm.add(pnDesc);

        JPanel pntitle = new JPanel();
        pntitle.add(lbIdOrder);

        JPanel pnBtn = new TransparentPanel();

        btnAdd = new JButton("Thêm");
        btnAdd.setPreferredSize(new Dimension(70, 40));

        Dimension cmbSize = new Dimension(200, 40);
        cmbLibCard.setPreferredSize(cmbSize);
        txtDayinit.setPreferredSize(cmbSize);

        pnBtn.add(btnAdd);

        pnHeader.add(pntitle);
        pnHeader.add(pnForm);
        pnHeader.add(pnBtn);

        con.add(pnHeader, BorderLayout.NORTH);

        JPanel pnTable = new JPanel();
        pnTable.setLayout(new BoxLayout(pnTable, BoxLayout.Y_AXIS));

        dtmBook = new DefaultTableModel();
        dtmBook.addColumn("Mã sách");
        dtmBook.addColumn("Tên sách");
        dtmBook.addColumn("Tên tác giả");
        tblBook = new MyTable(dtmBook);

        dtmListBookAdd = new DefaultTableModel();
        dtmListBookAdd.addColumn("Mã sách");
        dtmListBookAdd.addColumn("Tên sách");
        tbListBookAdd = new MyTable(dtmListBookAdd);

        tbListBookAdd.setDefaultEditor(Object.class, null);
        tblBook.setDefaultEditor(Object.class, null);

        JScrollPane scrDetail = new JScrollPane(tblBook);
        JScrollPane srcListbookAdd = new JScrollPane(tbListBookAdd);

        pnTable.add(lbTitleTableBook);
        pnTable.add(scrDetail, BorderLayout.NORTH);
        pnTable.add(lbTileTableBookListAdd);
        pnTable.add(srcListbookAdd, BorderLayout.SOUTH);
        con.add(pnTable, BorderLayout.CENTER);

        loadData();

    }

    private void addEvent() {
        tblBook.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    xuLyChonSach();
                    loadDataIntoListAdd(listAdd);
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

        tbListBookAdd.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    xuLyRemoveSach();
                    loadDataIntoListAdd(listAdd);
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

        btnAdd.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                addNewOrder();
                setVisible(false);
            }
        });

    }

    private void addNewOrder() {
        int id_card = -1;
        for (LibCard_DTO libCard_DTO : libCard_BUS.getAllStaff()) {
            if (libCard_DTO.getName().equals(cmbLibCard.getSelectedItem())) {
                id_card = libCard_DTO.getCard_id();
            }
        }
        int id_staff = Staff_BUS.staff_DTO_current_login.getId_staff();
        Date dayinit = Date.valueOf(txtDayinit.getText());
        String desc = txtDesc.getText();
        Order_DTO order_DTO = new Order_DTO();
        order_DTO.setCard_id(id_card);
        order_DTO.setStaff_id(id_staff);
        order_DTO.setDay_init(dayinit);
        order_DTO.setDesc(desc);
        int id_order = order_BUS.addOrder(order_DTO);
        if (id_order > 0) {
            for (Book_DTO book_DTO : listAdd) {
                orderDetail_BUS.addBookIntoOrder(book_DTO.getIsbn_code(), id_order);
            }
        }

    }

    private void xuLyChonSach() {
        int row = tblBook.getSelectedRow();
        if (row > -1) {
            String isbn = tblBook.getValueAt(row, 0) + "";
            Book_DTO b = book_BUS.getById(isbn);
            boolean chk = false;
            for (Book_DTO book_DTO : listAdd) {
                if (book_DTO.getIsbn_code().equals(b.getIsbn_code()))
                    chk = true;
            }
            if (chk == false) {
                listAdd.add(b);
            }
        }
    }

    private void xuLyRemoveSach() {
        int row = tbListBookAdd.getSelectedRow();
        if (row > -1) {
            String isbn = tbListBookAdd.getValueAt(row, 0) + "";
            Book_DTO b = book_BUS.getById(isbn);
            listAdd.removeIf(o -> (o.getIsbn_code().equals(b.getIsbn_code())));
        }
    }

    private void loadData() {
        book_BUS = new Book_BUS();
        loadData(book_BUS.getAllBook());
    }

    private void loadData(List<Book_DTO> listitem) {
        dtmBook.setRowCount(0);
        for (Book_DTO b : listitem) {
            Vector vec = new Vector();
            if (b.isStatus()) {
                vec.add(b.getIsbn_code());
                vec.add(b.getBook_name());
                vec.add(b.getAuthors());
            }
            dtmBook.addRow(vec);
        }
    }

    private void loadDataIntoListAdd(List<Book_DTO> listitem) {
        dtmListBookAdd.setRowCount(0);
        for (Book_DTO b : listitem) {
            Vector vec = new Vector();
            vec.add(b.getIsbn_code());
            vec.add(b.getBook_name());
            dtmListBookAdd.addRow(vec);
        }
    }
}
