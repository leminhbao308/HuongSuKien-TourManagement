package services;

import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Locale;

import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.KeyStroke;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import DAO.DAO_DichVu;
import DAO.DAO_HopDongTour;
import DAO.DAO_KhachHang;
import DAO.DAO_NhanVien;
import DAO.DAO_TourDuLich;
import entity.DichVu;
import entity.HopDongTour;
import entity.KhachHang;
import entity.NhanVien;
import entity.TourDuLich;
import utils.LoadSave;
import utils.constants.ColorConstant;

public class Employee_HopDongTour extends JPanel implements ActionListener {

    /**
     * 
     */
    private static final long serialVersionUID = 7769822990638312131L;
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnInfo;
    private javax.swing.JButton btnModify;
    private javax.swing.JButton btnPrint;
    private javax.swing.JButton btnSearchMa;
    private javax.swing.JButton btnSearchTenNV;
    private javax.swing.JButton btnSearchTenKH;
    private javax.swing.JComboBox<String> cbxFilter;
    private javax.swing.JLabel lblFilter;
    private javax.swing.JLabel lblSearchMa;
    private javax.swing.JLabel lblSearchTenNV;
    private javax.swing.JLabel lblSearchTenKH;
    private javax.swing.JPanel pnAction;
    private javax.swing.JPanel pnData;
    private javax.swing.JPanel pnSearchMa;
    private javax.swing.JPanel pnSearchTenKH;
    private javax.swing.JPanel pnSearchTenNV;
    private javax.swing.JScrollPane scrData;
    private javax.swing.JTable tblHopDongTour;
    private javax.swing.table.DefaultTableModel tblModel;
    private javax.swing.JTabbedPane tpnSearch;
    private javax.swing.JTextField txtSearchMa;
    private javax.swing.JTextField txtSearchTenNV;
    private javax.swing.JTextField txtSearchTenKH;

    public Employee_HopDongTour() {
	setBackground(ColorConstant.BACKGROUND_NORMAL);
	setForeground(ColorConstant.TEXT_NORMAL);

	init();
	style();
	preset();
	event();
	loadData();
    }

    private void init() {
	// TODO Auto-generated method stub
	tpnSearch = new javax.swing.JTabbedPane();
	pnSearchMa = new javax.swing.JPanel();
	lblSearchMa = new javax.swing.JLabel();
	txtSearchMa = new javax.swing.JTextField();
	btnSearchMa = new javax.swing.JButton();
	pnSearchTenKH = new javax.swing.JPanel();
	lblSearchTenKH = new javax.swing.JLabel();
	txtSearchTenKH = new javax.swing.JTextField();
	btnSearchTenKH = new javax.swing.JButton();
	pnSearchTenNV = new javax.swing.JPanel();
	lblSearchTenNV = new javax.swing.JLabel();
	txtSearchTenNV = new javax.swing.JTextField();
	btnSearchTenNV = new javax.swing.JButton();
	pnData = new javax.swing.JPanel();
	lblFilter = new javax.swing.JLabel();
	cbxFilter = new javax.swing.JComboBox<>();
	scrData = new javax.swing.JScrollPane();
	/**
	 * Table
	 */
	{
	    String[] cols = new HopDongTour().getTitle().split(";");
	    tblModel = new javax.swing.table.DefaultTableModel(cols, 0);
	    tblHopDongTour = new javax.swing.JTable(tblModel);
	}
	pnAction = new javax.swing.JPanel();
	btnInfo = new javax.swing.JButton();
	btnAdd = new javax.swing.JButton();
	btnDelete = new javax.swing.JButton();
	btnModify = new javax.swing.JButton();
	btnPrint = new javax.swing.JButton();
    }

    private void style() {
	// TODO Auto-generated method stub
	lblSearchMa.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
	lblSearchMa.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
	lblSearchMa.setText("Ma Hop Dong Can Tim:");

	txtSearchMa.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

	btnSearchMa.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
	btnSearchMa.setText("Tim");

	lblSearchTenKH.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
	lblSearchTenKH.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
	lblSearchTenKH.setText("Ten Khach Hang Can Tim:");

	txtSearchTenKH.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

	btnSearchTenKH.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
	btnSearchTenKH.setText("Tim");

	lblSearchTenNV.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
	lblSearchTenNV.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
	lblSearchTenNV.setText("Ten Nhan Vien Can Tim:");

	txtSearchTenNV.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

	btnSearchTenNV.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
	btnSearchTenNV.setText("Tim");

	pnData.setBorder(javax.swing.BorderFactory.createTitledBorder(
		javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED),
		"Danh Sach Hop Dong", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,
		javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 14))); // NOI18N

	lblFilter.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
	lblFilter.setText("Loc Theo:");

	cbxFilter.setModel(
		new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

	scrData.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
	scrData.setViewportView(tblHopDongTour);

	pnAction.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Chon Tac Vu",
		javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION,
		new java.awt.Font("Segoe UI", 0, 14))); // NOI18N

	btnInfo.setText("Xem Thong Tin");
	btnInfo.setToolTipText("Xem thong tin hop dong (Ctrl + I)");
	btnInfo.setEnabled(false);

	btnAdd.setText("Them Hop Dong");
	btnAdd.setToolTipText("Them hop dong moi (Ctrl + T)");

	btnDelete.setText("Xoa Hop Dong");
	btnDelete.setToolTipText("Xoa hop dong duoc chon (Ctrl + D)");
	btnDelete.setEnabled(false);

	btnModify.setText("Sua Hop Dong");
	btnModify.setToolTipText("Chinh sua hop dong duoc chon (Ctrl + M)");
	btnModify.setEnabled(false);

	btnPrint.setText("In Hop Dong");
	btnPrint.setToolTipText("In hop dong duoc chon (Ctrl + P)");
	btnPrint.setEnabled(false);
    }

    private void preset() {
	// TODO Auto-generated method stub
	javax.swing.GroupLayout pnSearchMaLayout = new javax.swing.GroupLayout(pnSearchMa);
	pnSearchMa.setLayout(pnSearchMaLayout);
	pnSearchMaLayout.setHorizontalGroup(pnSearchMaLayout
		.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
		.addGroup(pnSearchMaLayout.createSequentialGroup().addContainerGap()
			.addComponent(lblSearchMa, javax.swing.GroupLayout.PREFERRED_SIZE, 250,
				javax.swing.GroupLayout.PREFERRED_SIZE)
			.addGap(18, 18, 18)
			.addComponent(txtSearchMa, javax.swing.GroupLayout.DEFAULT_SIZE, 490, Short.MAX_VALUE)
			.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED).addComponent(btnSearchMa,
				javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
			.addContainerGap()));
	pnSearchMaLayout.setVerticalGroup(pnSearchMaLayout
		.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
		.addGroup(pnSearchMaLayout.createSequentialGroup().addContainerGap().addGroup(pnSearchMaLayout
			.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
			.addGroup(pnSearchMaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
				.addComponent(txtSearchMa, javax.swing.GroupLayout.PREFERRED_SIZE,
					javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
				.addComponent(lblSearchMa, javax.swing.GroupLayout.PREFERRED_SIZE, 31,
					javax.swing.GroupLayout.PREFERRED_SIZE))
			.addComponent(btnSearchMa, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
			.addContainerGap(9, Short.MAX_VALUE)));

	tpnSearch.addTab("Tim Theo Ma Hop Dong", pnSearchMa);

	javax.swing.GroupLayout pnSearchTenKHLayout = new javax.swing.GroupLayout(pnSearchTenKH);
	pnSearchTenKH.setLayout(pnSearchTenKHLayout);
	pnSearchTenKHLayout.setHorizontalGroup(pnSearchTenKHLayout
		.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
		.addGroup(pnSearchTenKHLayout.createSequentialGroup().addContainerGap()
			.addComponent(lblSearchTenKH, javax.swing.GroupLayout.PREFERRED_SIZE, 250,
				javax.swing.GroupLayout.PREFERRED_SIZE)
			.addGap(18, 18, 18)
			.addComponent(txtSearchTenKH, javax.swing.GroupLayout.DEFAULT_SIZE, 490, Short.MAX_VALUE)
			.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
			.addComponent(btnSearchTenKH, javax.swing.GroupLayout.PREFERRED_SIZE, 165,
				javax.swing.GroupLayout.PREFERRED_SIZE)
			.addContainerGap()));
	pnSearchTenKHLayout.setVerticalGroup(pnSearchTenKHLayout
		.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
		.addGroup(pnSearchTenKHLayout.createSequentialGroup().addContainerGap().addGroup(pnSearchTenKHLayout
			.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
			.addGroup(pnSearchTenKHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
				.addComponent(txtSearchTenKH, javax.swing.GroupLayout.PREFERRED_SIZE,
					javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
				.addComponent(lblSearchTenKH))
			.addComponent(btnSearchTenKH, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
			.addContainerGap(9, Short.MAX_VALUE)));

	tpnSearch.addTab("Tim Theo Ten Khach Hang", pnSearchTenKH);

	javax.swing.GroupLayout pnSearchTenNVLayout = new javax.swing.GroupLayout(pnSearchTenNV);
	pnSearchTenNV.setLayout(pnSearchTenNVLayout);
	pnSearchTenNVLayout.setHorizontalGroup(pnSearchTenNVLayout
		.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
		.addGroup(pnSearchTenNVLayout.createSequentialGroup().addContainerGap()
			.addComponent(lblSearchTenNV, javax.swing.GroupLayout.PREFERRED_SIZE, 250,
				javax.swing.GroupLayout.PREFERRED_SIZE)
			.addGap(18, 18, 18)
			.addComponent(txtSearchTenNV, javax.swing.GroupLayout.DEFAULT_SIZE, 490, Short.MAX_VALUE)
			.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
			.addComponent(btnSearchTenNV, javax.swing.GroupLayout.PREFERRED_SIZE, 165,
				javax.swing.GroupLayout.PREFERRED_SIZE)
			.addContainerGap()));
	pnSearchTenNVLayout.setVerticalGroup(pnSearchTenNVLayout
		.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
		.addGroup(pnSearchTenNVLayout.createSequentialGroup().addContainerGap().addGroup(pnSearchTenNVLayout
			.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
			.addGroup(pnSearchTenNVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
				.addComponent(txtSearchTenNV, javax.swing.GroupLayout.PREFERRED_SIZE,
					javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
				.addComponent(lblSearchTenNV, javax.swing.GroupLayout.PREFERRED_SIZE, 31,
					javax.swing.GroupLayout.PREFERRED_SIZE))
			.addComponent(btnSearchTenNV, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
			.addContainerGap(9, Short.MAX_VALUE)));

	tpnSearch.addTab("Tim Theo Ten Nhan Vien", pnSearchTenNV);

	javax.swing.GroupLayout pnActionLayout = new javax.swing.GroupLayout(pnAction);
	pnAction.setLayout(pnActionLayout);
	pnActionLayout.setHorizontalGroup(pnActionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
		.addGroup(pnActionLayout.createSequentialGroup().addContainerGap()
			.addComponent(btnInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 173,
				javax.swing.GroupLayout.PREFERRED_SIZE)
			.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
			.addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 104,
				javax.swing.GroupLayout.PREFERRED_SIZE)
			.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(btnDelete)
			.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
			.addComponent(btnModify, javax.swing.GroupLayout.PREFERRED_SIZE, 104,
				javax.swing.GroupLayout.PREFERRED_SIZE)
			.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
			.addComponent(btnPrint, javax.swing.GroupLayout.PREFERRED_SIZE, 104,
				javax.swing.GroupLayout.PREFERRED_SIZE)
			.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

	pnActionLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL,
		new java.awt.Component[] { btnAdd, btnDelete, btnInfo, btnModify, btnPrint });

	pnActionLayout.setVerticalGroup(pnActionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
		.addGroup(pnActionLayout.createSequentialGroup().addContainerGap()
			.addGroup(pnActionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
					pnActionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
						.addComponent(btnInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 31,
							javax.swing.GroupLayout.PREFERRED_SIZE)
						.addComponent(btnAdd)
						.addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 28,
							javax.swing.GroupLayout.PREFERRED_SIZE)
						.addComponent(btnModify))
				.addComponent(btnPrint))
			.addContainerGap()));

	pnActionLayout.linkSize(javax.swing.SwingConstants.VERTICAL,
		new java.awt.Component[] { btnAdd, btnDelete, btnInfo, btnModify, btnPrint });

	javax.swing.GroupLayout pnDataLayout = new javax.swing.GroupLayout(pnData);
	pnData.setLayout(pnDataLayout);
	pnDataLayout.setHorizontalGroup(pnDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
		.addGroup(pnDataLayout.createSequentialGroup().addContainerGap()
			.addGroup(pnDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(pnDataLayout.createSequentialGroup().addGap(0, 0, Short.MAX_VALUE)
					.addComponent(lblFilter)
					.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
					.addComponent(cbxFilter, javax.swing.GroupLayout.PREFERRED_SIZE, 154,
						javax.swing.GroupLayout.PREFERRED_SIZE))
				.addComponent(scrData).addComponent(pnAction, javax.swing.GroupLayout.DEFAULT_SIZE,
					javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
			.addContainerGap()));
	pnDataLayout.setVerticalGroup(pnDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
		.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnDataLayout.createSequentialGroup()
			.addGroup(pnDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
				.addComponent(lblFilter).addComponent(cbxFilter, javax.swing.GroupLayout.PREFERRED_SIZE,
					javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
			.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
			.addComponent(scrData, javax.swing.GroupLayout.DEFAULT_SIZE, 294, Short.MAX_VALUE)
			.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(pnAction,
				javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
				javax.swing.GroupLayout.PREFERRED_SIZE)));

	javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
	this.setLayout(layout);
	layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
		.addComponent(tpnSearch)
		.addGroup(layout.createSequentialGroup().addContainerGap().addComponent(pnData,
			javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
			.addContainerGap()));
	layout.setVerticalGroup(
		layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
			.addGroup(
				layout.createSequentialGroup()
					.addComponent(tpnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 77,
						javax.swing.GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
					.addComponent(pnData, javax.swing.GroupLayout.DEFAULT_SIZE,
						javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addContainerGap()));
    }

    private void event() {
	// TODO Auto-generated method stub
	// Search
	this.btnSearchMa.addActionListener(this);
	this.btnSearchTenKH.addActionListener(this);
	this.btnSearchTenNV.addActionListener(this);

	// Action
	this.btnInfo.addActionListener(this);
	this.btnAdd.addActionListener(this);
	this.btnDelete.addActionListener(this);
	this.btnModify.addActionListener(this);
	this.btnPrint.addActionListener(this);

	// Table
	this.tblHopDongTour.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

	    @Override
	    public void valueChanged(ListSelectionEvent e) {
		// TODO Auto-generated method stub
		// Kiểm tra xem có dòng nào được chọn hay không
		boolean hasSelection = !tblHopDongTour.getSelectionModel().isSelectionEmpty();

		// Đặt giá trị cho thuộc tính enabled của btnInfo tương ứng với hasSelection
		btnInfo.setEnabled(hasSelection);
		btnDelete.setEnabled(hasSelection);
		btnModify.setEnabled(hasSelection);
		btnPrint.setEnabled(hasSelection);
	    }
	});

	// Shortcut for Info Button
	InputMap imI = btnInfo.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
	// Add the key binding for Ctrl + I
	imI.put(KeyStroke.getKeyStroke(KeyEvent.VK_I, KeyEvent.CTRL_DOWN_MASK), "info");
	ActionMap amI = btnInfo.getActionMap();
	amI.put("info", new AbstractAction() {
	    /**
	     * 
	     */
	    private static final long serialVersionUID = 1L;

	    public void actionPerformed(ActionEvent e) {
		if (btnInfo.isEnabled()) {
		    // Lấy chỉ số của hàng đang được chọn
		    int selectedRow = tblHopDongTour.getSelectedRow();

		    // Lấy số cột của bảng
		    int columnsCount = tblHopDongTour.getColumnCount();

		    // Tạo một mảng String để chứa dữ liệu của hàng đang được chọn
		    String[] data = new String[columnsCount];

		    // Duyệt qua các cột của hàng đang được chọn và lưu giá trị vào mảng data
		    for (int i = 0; i < columnsCount; i++) {
			data[i] = tblHopDongTour.getValueAt(selectedRow, i).toString();
		    }

		    new FrameInfoHopDongTour(data).setVisible(true);
		}
	    }
	});

	// Shortcut for Add Button
	InputMap imA = btnAdd.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
	// Add the key binding for Ctrl + T
	imA.put(KeyStroke.getKeyStroke(KeyEvent.VK_T, KeyEvent.CTRL_DOWN_MASK), "add");
	ActionMap amA = btnAdd.getActionMap();
	amA.put("add", new AbstractAction() {
	    /**
	     * 
	     */
	    private static final long serialVersionUID = 5483789243899890043L;

	    public void actionPerformed(ActionEvent e) {
		if (btnAdd.isEnabled()) {
		    new FrameAddHopDongTour().setVisible(true);
		}
	    }
	});

	// Shortcut for Delete Button
	InputMap imD = btnDelete.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
	// Add the key binding for Ctrl + D
	imD.put(KeyStroke.getKeyStroke(KeyEvent.VK_D, KeyEvent.CTRL_DOWN_MASK), "delete");
	ActionMap amD = btnDelete.getActionMap();
	amD.put("delete", new AbstractAction() {
	    /**
	     * 
	     */
	    private static final long serialVersionUID = 6022012418853074879L;

	    public void actionPerformed(ActionEvent e) {
		if (btnDelete.isEnabled()) {
		    int dialogResult = JOptionPane.showConfirmDialog(null, "Bạn có muốn xóa dữ liệu không?");
		    if (dialogResult == JOptionPane.YES_OPTION) {
			// Lấy chỉ số của hàng đang được chọn
			int selectedRow = tblHopDongTour.getSelectedRow();
			String data = tblHopDongTour.getValueAt(selectedRow, 0).toString();

			DAO_HopDongTour.xoaHopDongTour(data);
			tblModel.setRowCount(0);
			loadData();
		    }
		}
	    }
	});

	// Shortcut for Modify Button
	InputMap imM = btnModify.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
	// Add the key binding for Ctrl + M
	imM.put(KeyStroke.getKeyStroke(KeyEvent.VK_M, KeyEvent.CTRL_DOWN_MASK), "modify");
	ActionMap amM = btnModify.getActionMap();
	amM.put("modify", new AbstractAction() {
	    /**
	     * 
	     */
	    private static final long serialVersionUID = -4313320705274645351L;

	    public void actionPerformed(ActionEvent e) {
		if (btnModify.isEnabled()) {
		    // Lấy chỉ số của hàng đang được chọn
		    int selectedRow = tblHopDongTour.getSelectedRow();

		    // Lấy số cột của bảng
		    int columnsCount = tblHopDongTour.getColumnCount();

		    // Tạo một mảng String để chứa dữ liệu của hàng đang được chọn
		    String[] data = new String[columnsCount];

		    // Duyệt qua các cột của hàng đang được chọn và lưu giá trị vào mảng data
		    for (int i = 0; i < columnsCount; i++) {
			data[i] = tblHopDongTour.getValueAt(selectedRow, i).toString();
		    }
		    new FrameModifyHopDongTour(data).setVisible(true);
		}
	    }
	});

	// Shortcut for Print Button
	InputMap imP = btnPrint.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
	// Add the key binding for Ctrl + M
	imP.put(KeyStroke.getKeyStroke(KeyEvent.VK_P, KeyEvent.CTRL_DOWN_MASK), "print");
	ActionMap amP = btnModify.getActionMap();
	amP.put("print", new AbstractAction() {
	    /**
	     * 
	     */
	    private static final long serialVersionUID = -4313320705274645351L;

	    public void actionPerformed(ActionEvent e) {
		if (btnModify.isEnabled()) {
		    // Lấy chỉ số của hàng đang được chọn
		    int selectedRow = tblHopDongTour.getSelectedRow();

		    // Lấy số cột của bảng
		    int columnsCount = tblHopDongTour.getColumnCount();

		    // Tạo một mảng String để chứa dữ liệu của hàng đang được chọn
		    String[] data = new String[columnsCount];

		    // Duyệt qua các cột của hàng đang được chọn và lưu giá trị vào mảng data
		    for (int i = 0; i < columnsCount; i++) {
			data[i] = tblHopDongTour.getValueAt(selectedRow, i).toString();
		    }
		    new FramePrintHopDongTour(data).setVisible(true);
		}
	    }
	});
    }

    @Override
    public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub
	Object o = e.getSource();
	// Search
	if (o.equals(btnSearchMa)) {

	}
	if (o.equals(btnSearchTenKH)) {

	}
	if (o.equals(btnSearchTenNV)) {

	}

	// Action
	if (o.equals(btnInfo)) {
	    // Lấy chỉ số của hàng đang được chọn
	    int selectedRow = tblHopDongTour.getSelectedRow();

	    // Lấy số cột của bảng
	    int columnsCount = tblHopDongTour.getColumnCount();

	    // Tạo một mảng String để chứa dữ liệu của hàng đang được chọn
	    String[] data = new String[columnsCount];

	    // Duyệt qua các cột của hàng đang được chọn và lưu giá trị vào mảng data
	    for (int i = 0; i < columnsCount; i++) {
		data[i] = tblHopDongTour.getValueAt(selectedRow, i).toString();
	    }
	    new FrameInfoHopDongTour(data).setVisible(true);
	}
	if (o.equals(btnAdd)) {
	    new FrameAddHopDongTour().setVisible(true);
	}
	if (o.equals(btnDelete)) {
	    int dialogResult = JOptionPane.showConfirmDialog(null, "Bạn có muốn xóa dữ liệu không?");
	    if (dialogResult == JOptionPane.YES_OPTION) {
		// Lấy chỉ số của hàng đang được chọn
		int selectedRow = tblHopDongTour.getSelectedRow();
		String data = tblHopDongTour.getValueAt(selectedRow, 0).toString();

		DAO_HopDongTour.xoaHopDongTour(data);
		tblModel.setRowCount(0);
		loadData();
	    }
	}
	if (o.equals(btnModify)) {
	    // Lấy chỉ số của hàng đang được chọn
	    int selectedRow = tblHopDongTour.getSelectedRow();

	    // Lấy số cột của bảng
	    int columnsCount = tblHopDongTour.getColumnCount();

	    // Tạo một mảng String để chứa dữ liệu của hàng đang được chọn
	    String[] data = new String[columnsCount];

	    // Duyệt qua các cột của hàng đang được chọn và lưu giá trị vào mảng data
	    for (int i = 0; i < columnsCount; i++) {
		data[i] = tblHopDongTour.getValueAt(selectedRow, i).toString();
	    }
	    new FrameModifyHopDongTour(data).setVisible(true);
	}
	if (o.equals(btnPrint)) {
	    // Lấy chỉ số của hàng đang được chọn
	    int selectedRow = tblHopDongTour.getSelectedRow();

	    // Lấy số cột của bảng
	    int columnsCount = tblHopDongTour.getColumnCount();

	    // Tạo một mảng String để chứa dữ liệu của hàng đang được chọn
	    String[] data = new String[columnsCount];

	    // Duyệt qua các cột của hàng đang được chọn và lưu giá trị vào mảng data
	    for (int i = 0; i < columnsCount; i++) {
		data[i] = tblHopDongTour.getValueAt(selectedRow, i).toString();
	    }
	    new FramePrintHopDongTour(data).setVisible(true);
	}
    }

    private void loadData() {
	// TODO Auto-generated method stub
	ArrayList<HopDongTour> dshdt = DAO_HopDongTour.getAllHopDongTour();
	for (HopDongTour hopDongTour : dshdt) {
	    String[] data = hopDongTour.toString().split(";");

	    // Format đơn vị tiền tệ
	    NumberFormat format = NumberFormat.getCurrencyInstance(new Locale("vi", "VN"));
	    String tongTien = format.format(Double.parseDouble(data[3]));
	    String tienDichVu = format.format(Double.parseDouble(data[7]));

	    // Create a font with a larger size
	    Font largerFont = tblHopDongTour.getFont().deriveFont(14f);

	    // Set the cell renderer for all columns
	    for (int i = 0; i < tblHopDongTour.getColumnModel().getColumnCount(); i++) {
		tblHopDongTour.getColumnModel().getColumn(i).setCellRenderer(new DefaultTableCellRenderer() {
		    /**
		     * 
		     */
		    private static final long serialVersionUID = 1L;

		    @Override
		    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
			    boolean hasFocus, int row, int column) {
			// Get the default renderer component
			Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row,
				column);

			// Set the font to the larger font
			c.setFont(largerFont);

			return c;
		    }
		});
	    }

	    String[] input = { data[0], data[1], data[2], tongTien, data[4], data[5], data[6], tienDichVu };
	    tblModel.addRow(input);

	    // Right Align Column
	    DefaultTableCellRenderer rightRender = new DefaultTableCellRenderer();
	    rightRender.setHorizontalAlignment(DefaultTableCellRenderer.RIGHT);

	    TableColumnModel columnModel = tblHopDongTour.getColumnModel();
	    int tongTienColumn = columnModel.getColumnIndex("Tổng Tiền"); // Lấy cột tổng tiền
	    int lastColumn = columnModel.getColumnCount() - 1; // Lấy cột dịch vụ
	    columnModel.getColumn(tongTienColumn).setCellRenderer(rightRender);
	    columnModel.getColumn(lastColumn).setCellRenderer(rightRender);
	}
    }

    private class FrameInfoHopDongTour extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8766759911141232526L;

	public FrameInfoHopDongTour(String[] data) {
	    // TODO Auto-generated constructor stub
	}

    }

    private class FrameAddHopDongTour extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5798721375417107998L;
	private javax.swing.JButton btnAdd;
	private javax.swing.JButton btnCancel;
	private javax.swing.JLabel lblDichVu;
	private javax.swing.JLabel lblGhiChu;
	private javax.swing.JLabel lblKhachHang;
	private javax.swing.JLabel lblMaHopDong;
	private javax.swing.JLabel lblNhanVien;
	private javax.swing.JLabel lblTour;
	private javax.swing.JPanel pnAction;
	private javax.swing.JPanel pnInfo;
	private javax.swing.JScrollPane scrDichVu;
	private javax.swing.JScrollPane scrKhachhang;
	private javax.swing.JScrollPane scrNhanVien;
	private javax.swing.JScrollPane scrTour;
	private javax.swing.JTextArea taGhiChu;
	private javax.swing.table.DefaultTableModel tblModelDichVu;
	private javax.swing.table.DefaultTableModel tblModelKhachHang;
	private javax.swing.table.DefaultTableModel tblModelNhanVien;
	private javax.swing.table.DefaultTableModel tblModelTour;
	private javax.swing.JTable tblDichVu;
	private javax.swing.JTable tblKhachHang;
	private javax.swing.JTable tblNhanVien;
	private javax.swing.JTable tblTour;
	private javax.swing.JTabbedPane tbpnData;
	private javax.swing.JTextField txtDichVu;
	private javax.swing.JScrollPane txtGhiChu;
	private javax.swing.JTextField txtKhachHang;
	private javax.swing.JTextField txtMaHopDong;
	private javax.swing.JTextField txtNhanVien;
	private javax.swing.JTextField txtTour;
	private NhanVien nv = new NhanVien();
	private KhachHang kh = new KhachHang();
	private DichVu dv = new DichVu();
	private TourDuLich tour = new TourDuLich();
	private ArrayList<NhanVien> dsnv = DAO_NhanVien.getAllNhanVien();
	private ArrayList<KhachHang> dskh = DAO_KhachHang.getAllKhachHang();
	private ArrayList<TourDuLich> dstour = DAO_TourDuLich.getAllTourDuLich();
	private ArrayList<DichVu> dsdv = DAO_DichVu.getAllDichVu();

	public FrameAddHopDongTour() {
	    this.setTitle("SE Tourist - Thêm Hop Dong Tour");
	    this.setIconImage(LoadSave.GetSpriteAtlas(LoadSave.LOGO_ICON));
	    this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	    this.setResizable(false);
	    this.setLocationRelativeTo(null);
//	    this.setMaximumSize(new java.awt.Dimension(420, 500));
//	    this.setMinimumSize(new java.awt.Dimension(420, 500));

	    this.init();
	    this.style();
	    this.preset();
	    this.event();
	    this.loadData();
	}

	private void init() {
	    // TODO Auto-generated method stub
	    pnInfo = new javax.swing.JPanel();
	    lblMaHopDong = new javax.swing.JLabel();
	    txtMaHopDong = new javax.swing.JTextField();
	    lblGhiChu = new javax.swing.JLabel();
	    txtGhiChu = new javax.swing.JScrollPane();
	    taGhiChu = new javax.swing.JTextArea();
	    lblNhanVien = new javax.swing.JLabel();
	    txtNhanVien = new javax.swing.JTextField();
	    lblKhachHang = new javax.swing.JLabel();
	    txtKhachHang = new javax.swing.JTextField();
	    lblTour = new javax.swing.JLabel();
	    txtTour = new javax.swing.JTextField();
	    lblDichVu = new javax.swing.JLabel();
	    txtDichVu = new javax.swing.JTextField();
	    tbpnData = new javax.swing.JTabbedPane();
	    scrNhanVien = new javax.swing.JScrollPane();
	    tblNhanVien = new javax.swing.JTable();
	    scrKhachhang = new javax.swing.JScrollPane();
	    tblKhachHang = new javax.swing.JTable();
	    scrTour = new javax.swing.JScrollPane();
	    tblTour = new javax.swing.JTable();
	    scrDichVu = new javax.swing.JScrollPane();
	    tblDichVu = new javax.swing.JTable();
	    pnAction = new javax.swing.JPanel();
	    btnAdd = new javax.swing.JButton();
	    btnCancel = new javax.swing.JButton();
	    String[] colsNV = nv.getTitle().split(";");
	    String[] colsKH = kh.getTitle().split(";");
	    String[] colsTour = tour.getTitle().split(";");
	    String[] colsDV = dv.getTitle().split(";");
	    tblModelNhanVien = new javax.swing.table.DefaultTableModel(colsNV, 0);
	    tblModelKhachHang = new javax.swing.table.DefaultTableModel(colsKH, 0);
	    tblModelTour = new javax.swing.table.DefaultTableModel(colsTour, 0);
	    tblModelDichVu = new javax.swing.table.DefaultTableModel(colsDV, 0);
	}

	private void style() {
	    // TODO Auto-generated method stub
	    pnInfo.setBorder(javax.swing.BorderFactory.createTitledBorder(
		    javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED),
		    "Thong Tin Hop Dong", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,
		    javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 14))); // NOI18N

	    lblMaHopDong.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
	    lblMaHopDong.setText("Ma Hop Dong");

	    txtMaHopDong.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

	    lblGhiChu.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
	    lblGhiChu.setText("Ghi Chu");

	    taGhiChu.setColumns(20);
	    taGhiChu.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
	    taGhiChu.setRows(5);
	    txtGhiChu.setViewportView(taGhiChu);

	    lblNhanVien.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
	    lblNhanVien.setText("Nhan Vien Thuc Hien");

	    txtNhanVien.setEditable(false);
	    txtNhanVien.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

	    lblKhachHang.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
	    lblKhachHang.setText("Khach Hang Dat Tour");

	    txtKhachHang.setEditable(false);
	    txtKhachHang.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

	    lblTour.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
	    lblTour.setText("Tour Khach Hang Dat");

	    txtTour.setEditable(false);
	    txtTour.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

	    lblDichVu.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
	    lblDichVu.setText("Dich Vu Di Kem");

	    txtDichVu.setEditable(false);
	    txtDichVu.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

	    tbpnData.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

	    tblNhanVien.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
	    tblNhanVien.setModel(tblModelNhanVien);
	    scrNhanVien.setViewportView(tblNhanVien);

	    tbpnData.addTab("Nhan Vien", scrNhanVien);

	    tblKhachHang.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
	    tblKhachHang.setModel(tblModelKhachHang);
	    scrKhachhang.setViewportView(tblKhachHang);

	    tbpnData.addTab("Khach Hang", scrKhachhang);

	    tblTour.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
	    tblTour.setModel(tblModelTour);
	    scrTour.setViewportView(tblTour);

	    tbpnData.addTab("Tour Du Lich", scrTour);

	    tblDichVu.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
	    tblDichVu.setModel(tblModelDichVu);
	    scrDichVu.setViewportView(tblDichVu);

	    tbpnData.addTab("Dich Vu", scrDichVu);

	    pnAction.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Chon Tac Vu",
		    javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,
		    javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 14))); // NOI18N

	    btnAdd.setBackground(new java.awt.Color(0, 255, 0));
	    btnAdd.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
	    btnAdd.setForeground(new java.awt.Color(255, 255, 255));
	    btnAdd.setText("Them Hop Dong");
	    btnAdd.setToolTipText("Them dia danh moi");

	    btnCancel.setBackground(new java.awt.Color(255, 0, 0));
	    btnCancel.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
	    btnCancel.setForeground(new java.awt.Color(255, 255, 255));
	    btnCancel.setText("Huy");
	    btnCancel.setToolTipText("Huy thao tac them");
	}

	private void preset() {
	    // TODO Auto-generated method stub
	    javax.swing.GroupLayout pnInfoLayout = new javax.swing.GroupLayout(pnInfo);
	    pnInfo.setLayout(pnInfoLayout);
	    pnInfoLayout.setHorizontalGroup(pnInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
		    .addGroup(pnInfoLayout.createSequentialGroup().addContainerGap()
			    .addGroup(pnInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				    .addComponent(txtMaHopDong)
				    .addComponent(txtGhiChu, javax.swing.GroupLayout.DEFAULT_SIZE, 459, Short.MAX_VALUE)
				    .addGroup(pnInfoLayout.createSequentialGroup().addGroup(pnInfoLayout
					    .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
					    .addComponent(lblMaHopDong, javax.swing.GroupLayout.PREFERRED_SIZE, 125,
						    javax.swing.GroupLayout.PREFERRED_SIZE)
					    .addComponent(lblGhiChu, javax.swing.GroupLayout.PREFERRED_SIZE, 125,
						    javax.swing.GroupLayout.PREFERRED_SIZE)
					    .addComponent(lblNhanVien).addComponent(lblKhachHang).addComponent(lblTour)
					    .addComponent(lblDichVu)).addGap(0, 0, Short.MAX_VALUE))
				    .addComponent(txtNhanVien)
				    .addComponent(txtKhachHang, javax.swing.GroupLayout.Alignment.TRAILING)
				    .addComponent(txtTour, javax.swing.GroupLayout.Alignment.TRAILING)
				    .addComponent(txtDichVu, javax.swing.GroupLayout.Alignment.TRAILING))
			    .addContainerGap()));
	    pnInfoLayout.setVerticalGroup(pnInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
		    .addGroup(pnInfoLayout.createSequentialGroup().addComponent(lblMaHopDong)
			    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
			    .addComponent(txtMaHopDong, javax.swing.GroupLayout.PREFERRED_SIZE,
				    javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
			    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(lblGhiChu)
			    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
			    .addComponent(txtGhiChu, javax.swing.GroupLayout.PREFERRED_SIZE, 43,
				    javax.swing.GroupLayout.PREFERRED_SIZE)
			    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
			    .addComponent(lblNhanVien)
			    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
			    .addComponent(txtNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE,
				    javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
			    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
			    .addComponent(lblKhachHang)
			    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
			    .addComponent(txtKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE,
				    javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
			    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(lblTour)
			    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
			    .addComponent(txtTour, javax.swing.GroupLayout.PREFERRED_SIZE,
				    javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
			    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(lblDichVu)
			    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
				    javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
			    .addComponent(txtDichVu, javax.swing.GroupLayout.PREFERRED_SIZE,
				    javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)));

	    javax.swing.GroupLayout pnActionLayout = new javax.swing.GroupLayout(pnAction);
	    pnAction.setLayout(pnActionLayout);
	    pnActionLayout
		    .setHorizontalGroup(pnActionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
			    .addGroup(pnActionLayout.createSequentialGroup().addContainerGap()
				    .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 194,
					    javax.swing.GroupLayout.PREFERRED_SIZE)
				    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
				    .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 184,
					    javax.swing.GroupLayout.PREFERRED_SIZE)
				    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

	    pnActionLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL,
		    new java.awt.Component[] { btnAdd, btnCancel });

	    pnActionLayout
		    .setVerticalGroup(pnActionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
			    .addGroup(pnActionLayout.createSequentialGroup().addGroup(pnActionLayout
				    .createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER).addComponent(btnAdd)
				    .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 40,
					    javax.swing.GroupLayout.PREFERRED_SIZE))
				    .addContainerGap()));

	    pnActionLayout.linkSize(javax.swing.SwingConstants.VERTICAL,
		    new java.awt.Component[] { btnAdd, btnCancel });

	    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
	    getContentPane().setLayout(layout);
	    layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
		    .addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout
			    .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
			    .addComponent(pnAction, javax.swing.GroupLayout.DEFAULT_SIZE,
				    javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
			    .addGroup(layout.createSequentialGroup()
				    .addComponent(pnInfo, javax.swing.GroupLayout.PREFERRED_SIZE,
					    javax.swing.GroupLayout.DEFAULT_SIZE,
					    javax.swing.GroupLayout.PREFERRED_SIZE)
				    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(
					    tbpnData, javax.swing.GroupLayout.DEFAULT_SIZE, 632, Short.MAX_VALUE)))
			    .addContainerGap()));
	    layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
		    .addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout
			    .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
			    .addComponent(pnInfo, javax.swing.GroupLayout.PREFERRED_SIZE,
				    javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
			    .addComponent(tbpnData, javax.swing.GroupLayout.PREFERRED_SIZE, 387,
				    javax.swing.GroupLayout.PREFERRED_SIZE))
			    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
			    .addComponent(pnAction, javax.swing.GroupLayout.PREFERRED_SIZE,
				    javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
			    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

	    pack();
	}

	private void event() {
	    // TODO Auto-generated method stub
	    this.btnAdd.addActionListener(this);
	    this.btnCancel.addActionListener(this);

	    tblNhanVien.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {
		    if (e.getClickCount() == 2) {
			int row = tblNhanVien.getSelectedRow();
			String value = tblNhanVien.getValueAt(row, 0).toString();
			txtNhanVien.setText(value);
		    }
		}
	    });

	    tblKhachHang.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {
		    if (e.getClickCount() == 2) {
			int row = tblKhachHang.getSelectedRow();
			String value = tblKhachHang.getValueAt(row, 0).toString();
			txtKhachHang.setText(value);
		    }
		}
	    });

	    tblTour.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {
		    if (e.getClickCount() == 2) {
			int row = tblTour.getSelectedRow();
			String value = tblTour.getValueAt(row, 0).toString();
			txtTour.setText(value);
		    }
		}
	    });

	    tblDichVu.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {
		    if (e.getClickCount() == 2) {
			int row = tblDichVu.getSelectedRow();
			String value = tblDichVu.getValueAt(row, 0).toString();
			txtDichVu.setText(value);
		    }
		}
	    });
	}

	@Override
	public void actionPerformed(ActionEvent e) {
	    // TODO Auto-generated method stub
	    Object o = e.getSource();

	    if (o.equals(btnCancel)) {
		this.dispose();
	    }

	    if (o.equals(btnAdd)) {
		HopDongTour newHD = new HopDongTour(txtMaHopDong.getText(), LocalDate.now(), taGhiChu.getText(),
			DAO_HopDongTour.getTongTienTour(dv.getMaDichVu(), tour.getMaTour()), nv, kh, tour, dv);

		if (DAO_HopDongTour.themHopDongTour(newHD)) {
		    JOptionPane.showInternalMessageDialog(null, "Them Thanh Cong");
		    tblModel.setRowCount(0);
		    loadData();
		    this.dispose();
		} else {
		    JOptionPane.showInternalMessageDialog(null, "Them That Bai", "Loi", JOptionPane.ERROR_MESSAGE);
		    this.dispose();
		}
	    }
	}

	private void loadData() {
	    // TODO Auto-generated method stub
	    // Nhan Vien
	    {
		for (NhanVien nhanVien : dsnv) {
		    String[] data = nhanVien.toString().split(";");
		    if (data[2].equalsIgnoreCase("true"))
			data[2] = "Nữ";
		    else
			data[2] = "Nam";

		    tblModelNhanVien.addRow(data);
		}
	    }

	    // Khach Hang
	    {
		for (KhachHang khachHang : dskh) {
		    String[] data = khachHang.toString().split(";");

		    if (data[3].equalsIgnoreCase("true"))
			data[3] = "Nữ";
		    else
			data[3] = "Nam";

		    tblModelKhachHang.addRow(data);
		}
	    }

	    // Tour Du Lich
	    {
		for (TourDuLich tour : dstour) {
		    String[] data = tour.toString().split(";");

		    // Format đơn vị tiền tệ
		    NumberFormat format = NumberFormat.getCurrencyInstance(new Locale("vi", "VN"));
		    String donGia = format.format(Double.parseDouble(data[6]));

		    String[] input = { data[0], data[1], data[2], data[3], data[4], data[5], donGia, data[7], data[8] };
		    tblModelTour.addRow(input);

		    // Right Align Column
		    DefaultTableCellRenderer rightRender = new DefaultTableCellRenderer();
		    rightRender.setHorizontalAlignment(DefaultTableCellRenderer.RIGHT);

		    TableColumnModel columnModel = tblDichVu.getColumnModel();
		    int lastColumn = columnModel.getColumnCount() - 1; // Lấy cột cuối cùng
		    columnModel.getColumn(lastColumn).setCellRenderer(rightRender);
		}
	    }

	    // Dich Vu
	    {
		for (DichVu dichVu : dsdv) {
		    String[] data = dichVu.toString().split(";");

		    // Format đơn vị tiền tệ
		    NumberFormat format = NumberFormat.getCurrencyInstance(new Locale("vi", "VN"));
		    String donGia = format.format(Double.parseDouble(data[3]));

		    String[] input = { data[0], data[1], data[2], donGia };
		    tblModelDichVu.addRow(input);

		    // Right Align Column
		    DefaultTableCellRenderer rightRender = new DefaultTableCellRenderer();
		    rightRender.setHorizontalAlignment(DefaultTableCellRenderer.RIGHT);

		    TableColumnModel columnModel = tblDichVu.getColumnModel();
		    int lastColumn = columnModel.getColumnCount() - 1; // Lấy cột cuối cùng
		    columnModel.getColumn(lastColumn).setCellRenderer(rightRender);
		}
	    }

	}
    }

    private class FrameModifyHopDongTour extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3063599220485930972L;

	public FrameModifyHopDongTour(String[] data) {
	    // TODO Auto-generated constructor stub
	}

    }

    private class FramePrintHopDongTour extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8091667814103489629L;

	public FramePrintHopDongTour(String[] data) {
	    // TODO Auto-generated constructor stub
	}

    }
}
