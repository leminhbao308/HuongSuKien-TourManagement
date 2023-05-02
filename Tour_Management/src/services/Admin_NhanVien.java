package services;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.Date;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.BorderFactory;
import javax.swing.InputMap;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.KeyStroke;
import javax.swing.UIManager;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableCellRenderer;

import org.jdatepicker.JDatePicker;

import DAO.DAO_NhanVien;
import entity.NhanVien;
import utils.LoadSave;
import utils.constants.ColorConstant;

public class Admin_NhanVien extends JPanel implements ActionListener {
    /**
     * 
     */
    private static final long serialVersionUID = -945332098123420809L;
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnInfo;
    private javax.swing.JButton btnModify;
    private javax.swing.JButton btnSearchMa;
    private javax.swing.JButton btnSearchTen;
    private javax.swing.JComboBox<String> cbxFilter;
    private javax.swing.JLabel lblFilter;
    private javax.swing.JLabel lblSearchMa;
    private javax.swing.JLabel lblSearchTen;
    private javax.swing.JPanel pnAction;
    private javax.swing.JPanel pnData;
    private javax.swing.JPanel pnSearchMa;
    private javax.swing.JPanel pnSearchTen;
    private javax.swing.JScrollPane scrData;
    private javax.swing.JTable tblNhanVien;
    private javax.swing.table.DefaultTableModel tblModel;
    private javax.swing.JTabbedPane tpnSearch;
    private javax.swing.JTextField txtSearchMa;
    private javax.swing.JTextField txtSearchTen;

    public Admin_NhanVien() {

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
	pnSearchTen = new javax.swing.JPanel();
	lblSearchTen = new javax.swing.JLabel();
	txtSearchTen = new javax.swing.JTextField();
	btnSearchTen = new javax.swing.JButton();
	pnData = new javax.swing.JPanel();
	lblFilter = new javax.swing.JLabel();
	cbxFilter = new javax.swing.JComboBox<>();
	scrData = new javax.swing.JScrollPane();

	/**
	 * Table
	 */
	{
	    String[] cols = new NhanVien().getTitle().split(";");
	    tblModel = new javax.swing.table.DefaultTableModel(cols, 0);
	    tblNhanVien = new javax.swing.JTable(tblModel);
	}
	pnAction = new javax.swing.JPanel();
	btnInfo = new javax.swing.JButton();
	btnAdd = new javax.swing.JButton();
	btnDelete = new javax.swing.JButton();
	btnModify = new javax.swing.JButton();
    }

    private void style() {
	// TODO Auto-generated method stub
	tblNhanVien.getTableHeader().setReorderingAllowed(false);
	tblNhanVien.getTableHeader().setFont(new Font("Segoe UI", 0, 18));

	lblSearchMa.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
	lblSearchMa.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
	lblSearchMa.setText("Ma Nhan Vien Can Tim:");

	txtSearchMa.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

	btnSearchMa.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
	btnSearchMa.setText("Tim");

	lblSearchTen.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
	lblSearchTen.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
	lblSearchTen.setText("Ten Nhan Vien Can Tim:");

	txtSearchTen.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

	btnSearchTen.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
	btnSearchTen.setText("Tim");

	pnData.setBorder(javax.swing.BorderFactory.createTitledBorder(
		javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED),
		"Danh Sach Nhan Vien", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,
		javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 14))); // NOI18N

	lblFilter.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
	lblFilter.setText("Loc Theo:");

	cbxFilter.setModel(
		new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

	scrData.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
	scrData.setViewportView(tblNhanVien);

	pnAction.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Chon Tac Vu",
		javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION,
		new java.awt.Font("Segoe UI", 0, 14))); // NOI18N

	btnInfo.setText("Xem Thong Tin");
	btnInfo.setEnabled(false);
	btnInfo.setToolTipText("Xem thong tin nhan vien duoc chon (Ctrl + I)");

	btnAdd.setText("Them Nhan Vien");
	btnAdd.setToolTipText("Them nhan vien moi (Ctrl + T)");

	btnDelete.setText("Xoa Nhan Vien");
	btnDelete.setEnabled(false);
	btnDelete.setToolTipText("Xoa nhan vien duoc chon (Ctrl + D)");

	btnModify.setText("Sua Nhan Vien");
	btnModify.setEnabled(false);
	btnModify.setToolTipText("Sua thong tin nhan vien duoc chon (Ctrl + M)");
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
			.addComponent(txtSearchMa, javax.swing.GroupLayout.DEFAULT_SIZE, 429, Short.MAX_VALUE)
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

	tpnSearch.addTab("Tim Theo Ma", pnSearchMa);

	javax.swing.GroupLayout pnSearchTenLayout = new javax.swing.GroupLayout(pnSearchTen);
	pnSearchTen.setLayout(pnSearchTenLayout);
	pnSearchTenLayout
		.setHorizontalGroup(pnSearchTenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
			.addGroup(pnSearchTenLayout.createSequentialGroup().addContainerGap()
				.addComponent(lblSearchTen, javax.swing.GroupLayout.PREFERRED_SIZE, 250,
					javax.swing.GroupLayout.PREFERRED_SIZE)
				.addGap(18, 18, 18)
				.addComponent(txtSearchTen, javax.swing.GroupLayout.DEFAULT_SIZE, 429, Short.MAX_VALUE)
				.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
				.addComponent(btnSearchTen, javax.swing.GroupLayout.PREFERRED_SIZE, 165,
					javax.swing.GroupLayout.PREFERRED_SIZE)
				.addContainerGap()));
	pnSearchTenLayout.setVerticalGroup(pnSearchTenLayout
		.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
		.addGroup(pnSearchTenLayout.createSequentialGroup().addContainerGap().addGroup(pnSearchTenLayout
			.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
			.addGroup(pnSearchTenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
				.addComponent(txtSearchTen, javax.swing.GroupLayout.PREFERRED_SIZE,
					javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
				.addComponent(lblSearchTen))
			.addComponent(btnSearchTen, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
			.addContainerGap(9, Short.MAX_VALUE)));

	tpnSearch.addTab("Tim Theo Ten", pnSearchTen);

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
			.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

	pnActionLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL,
		new java.awt.Component[] { btnAdd, btnDelete, btnInfo, btnModify });

	pnActionLayout.setVerticalGroup(pnActionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
		.addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
			pnActionLayout.createSequentialGroup().addContainerGap()
				.addGroup(pnActionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
					.addComponent(btnInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 31,
						javax.swing.GroupLayout.PREFERRED_SIZE)
					.addComponent(btnAdd)
					.addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 28,
						javax.swing.GroupLayout.PREFERRED_SIZE)
					.addComponent(btnModify))
				.addContainerGap()));

	pnActionLayout.linkSize(javax.swing.SwingConstants.VERTICAL,
		new java.awt.Component[] { btnAdd, btnDelete, btnInfo, btnModify });

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
	this.btnSearchTen.addActionListener(this);
	// Action
	this.btnInfo.addActionListener(this);
	this.btnAdd.addActionListener(this);
	this.btnDelete.addActionListener(this);
	this.btnModify.addActionListener(this);

	// Table
	this.tblNhanVien.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

	    @Override
	    public void valueChanged(ListSelectionEvent e) {
		// TODO Auto-generated method stub
		// Kiểm tra xem có dòng nào được chọn hay không
		boolean hasSelection = !tblNhanVien.getSelectionModel().isSelectionEmpty();

		// Đặt giá trị cho thuộc tính enabled của btnInfo tương ứng với hasSelection
		btnInfo.setEnabled(hasSelection);
		btnDelete.setEnabled(hasSelection);
		btnModify.setEnabled(hasSelection);
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
		    int selectedRow = tblNhanVien.getSelectedRow();

		    // Lấy số cột của bảng
		    int columnsCount = tblNhanVien.getColumnCount();

		    // Tạo một mảng String để chứa dữ liệu của hàng đang được chọn
		    String[] data = new String[columnsCount];

		    // Duyệt qua các cột của hàng đang được chọn và lưu giá trị vào mảng data
		    for (int i = 0; i < columnsCount; i++) {
			data[i] = tblNhanVien.getValueAt(selectedRow, i).toString();
		    }

		    new FrameInfoNhanVien(data).setVisible(true);
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
		    new FrameAddNhanVien().setVisible(true);
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
			int selectedRow = tblNhanVien.getSelectedRow();
			String data = tblNhanVien.getValueAt(selectedRow, 0).toString();

			DAO_NhanVien.xoaNhanVien(data);
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
		    int selectedRow = tblNhanVien.getSelectedRow();

		    // Lấy số cột của bảng
		    int columnsCount = tblNhanVien.getColumnCount();

		    // Tạo một mảng String để chứa dữ liệu của hàng đang được chọn
		    String[] data = new String[columnsCount];

		    // Duyệt qua các cột của hàng đang được chọn và lưu giá trị vào mảng data
		    for (int i = 0; i < columnsCount; i++) {
			data[i] = tblNhanVien.getValueAt(selectedRow, i).toString();
		    }
		    new FrameModifyNhanVien(data).setVisible(true);
		}
	    }
	});
    }

    private void loadData() {
	ArrayList<NhanVien> dsnv = DAO_NhanVien.getAllNhanVien();
	for (NhanVien nhanVien : dsnv) {
	    String[] data = nhanVien.toString().split(";");
	    if (data[2].equalsIgnoreCase("true"))
		data[2] = "Nu";
	    else
		data[2] = "Nam";
	    // Create a font with a larger size
	    Font largerFont = tblNhanVien.getFont().deriveFont(14f);

	    // Set the cell renderer for all columns
	    for (int i = 0; i < tblNhanVien.getColumnModel().getColumnCount(); i++) {
		tblNhanVien.getColumnModel().getColumn(i).setCellRenderer(new DefaultTableCellRenderer() {
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
	    tblModel.addRow(data);
	}
    }

    @Override
    public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub
	Object o = e.getSource();
	// Search
	if (o.equals(btnSearchMa)) {

	}
	if (o.equals(btnSearchTen)) {

	}
	// Action
	if (o.equals(btnInfo)) {
	    // Lấy chỉ số của hàng đang được chọn
	    int selectedRow = tblNhanVien.getSelectedRow();

	    // Lấy số cột của bảng
	    int columnsCount = tblNhanVien.getColumnCount();

	    // Tạo một mảng String để chứa dữ liệu của hàng đang được chọn
	    String[] data = new String[columnsCount];

	    // Duyệt qua các cột của hàng đang được chọn và lưu giá trị vào mảng data
	    for (int i = 0; i < columnsCount; i++) {
		data[i] = tblNhanVien.getValueAt(selectedRow, i).toString();
	    }
	    new FrameInfoNhanVien(data).setVisible(true);
	}
	if (o.equals(btnAdd)) {
	    new FrameAddNhanVien().setVisible(true);
	}
	if (o.equals(btnDelete)) {
	    int dialogResult = JOptionPane.showConfirmDialog(null, "Bạn có muốn xóa dữ liệu không?");
	    if (dialogResult == JOptionPane.YES_OPTION) {
		// Lấy chỉ số của hàng đang được chọn
		int selectedRow = tblNhanVien.getSelectedRow();
		String data = tblNhanVien.getValueAt(selectedRow, 0).toString();

		DAO_NhanVien.xoaNhanVien(data);
		tblModel.setRowCount(0);
		loadData();
	    }
	}
	if (o.equals(btnModify)) {
	    // Lấy chỉ số của hàng đang được chọn
	    int selectedRow = tblNhanVien.getSelectedRow();

	    // Lấy số cột của bảng
	    int columnsCount = tblNhanVien.getColumnCount();

	    // Tạo một mảng String để chứa dữ liệu của hàng đang được chọn
	    String[] data = new String[columnsCount];

	    // Duyệt qua các cột của hàng đang được chọn và lưu giá trị vào mảng data
	    for (int i = 0; i < columnsCount; i++) {
		data[i] = tblNhanVien.getValueAt(selectedRow, i).toString();
	    }
	    new FrameModifyNhanVien(data).setVisible(true);
	}
    }

    private class FrameInfoNhanVien extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private javax.swing.JLabel lblChucVu;
	private javax.swing.JLabel lblDiaChi;
	private javax.swing.JLabel lblEmail;
	private javax.swing.JLabel lblMaNV;
	private javax.swing.JLabel lblSDT;
	private javax.swing.JLabel lblTenNV;
	private javax.swing.JPanel pnGioiTinh;
	private javax.swing.JPanel pnInfo;
	private javax.swing.JPanel pnNgaySinh;
	private javax.swing.JRadioButton radNam;
	private javax.swing.JRadioButton radNu;
	private javax.swing.JTextField txtChucVu;
	private javax.swing.JTextField txtDiaChi;
	private javax.swing.JTextField txtEmail;
	private javax.swing.JTextField txtMaNV;
	private javax.swing.JTextField txtNgaySinh;
	private javax.swing.JTextField txtSDT;
	private javax.swing.JTextField txtTenNV;

	private FrameInfoNhanVien(String[] data) {
	    this.setTitle("SE Tourist - Thong Tin Nhan Vien");
	    this.setIconImage(LoadSave.GetSpriteAtlas(LoadSave.LOGO_ICON));
	    this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	    this.setResizable(false);
	    this.setLocationRelativeTo(null);
	    this.setMaximumSize(new java.awt.Dimension(670, 400));
	    this.setMinimumSize(new java.awt.Dimension(670, 400));

	    this.init();
	    this.style();
	    this.preset();
	    this.event(data);
	}

	private void init() {
	    // TODO Auto-generated method stub
	    pnInfo = new javax.swing.JPanel();
	    lblMaNV = new javax.swing.JLabel();
	    txtMaNV = new javax.swing.JTextField();
	    lblTenNV = new javax.swing.JLabel();
	    txtTenNV = new javax.swing.JTextField();
	    pnGioiTinh = new javax.swing.JPanel();
	    radNam = new javax.swing.JRadioButton();
	    radNu = new javax.swing.JRadioButton();
	    pnNgaySinh = new javax.swing.JPanel();
	    txtNgaySinh = new javax.swing.JTextField();
	    lblDiaChi = new javax.swing.JLabel();
	    txtDiaChi = new javax.swing.JTextField();
	    lblEmail = new javax.swing.JLabel();
	    txtEmail = new javax.swing.JTextField();
	    lblSDT = new javax.swing.JLabel();
	    txtSDT = new javax.swing.JTextField();
	    lblChucVu = new javax.swing.JLabel();
	    txtChucVu = new javax.swing.JTextField();
	}

	private void style() {
	    // TODO Auto-generated method stub
	    pnInfo.setBorder(javax.swing.BorderFactory.createTitledBorder(
		    javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED),
		    "Thong Tin Nhan Vien", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,
		    javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 14))); // NOI18N

	    lblMaNV.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
	    lblMaNV.setText("Ma Nhan Vien:");

	    txtMaNV.setEditable(false);
	    txtMaNV.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

	    lblTenNV.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
	    lblTenNV.setText("Ten Nhan Vien:");

	    txtTenNV.setEditable(false);
	    txtTenNV.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

	    pnGioiTinh.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Gioi Tinh",
		    javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,
		    javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 14))); // NOI18N

	    radNam.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
	    radNam.setSelected(true);
	    radNam.setText("Nam");
	    radNam.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
	    radNam.setEnabled(false);

	    radNu.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
	    radNu.setText("Nu");
	    radNu.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
	    radNu.setEnabled(false);

	    pnNgaySinh.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Ngay Sinh",
		    javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,
		    javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 14))); // NOI18N

	    txtNgaySinh.setEditable(false);

	    lblDiaChi.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
	    lblDiaChi.setText("Dia Chi:");

	    txtDiaChi.setEditable(false);
	    txtDiaChi.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

	    lblEmail.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
	    lblEmail.setText("Email:");

	    txtEmail.setEditable(false);
	    txtEmail.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

	    lblSDT.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
	    lblSDT.setText("So Dien Thoai:");

	    txtSDT.setEditable(false);
	    txtSDT.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

	    lblChucVu.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
	    lblChucVu.setText("Chuc Vu:");

	    txtChucVu.setEditable(false);
	    txtChucVu.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

	}

	private void preset() {
	    // TODO Auto-generated method stub
	    javax.swing.GroupLayout pnGioiTinhLayout = new javax.swing.GroupLayout(pnGioiTinh);
	    pnGioiTinh.setLayout(pnGioiTinhLayout);
	    pnGioiTinhLayout.setHorizontalGroup(pnGioiTinhLayout
		    .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
		    .addGroup(pnGioiTinhLayout.createSequentialGroup().addContainerGap().addComponent(radNam)
			    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(radNu)
			    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
	    pnGioiTinhLayout
		    .setVerticalGroup(pnGioiTinhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
			    .addGroup(pnGioiTinhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
				    .addComponent(radNam).addComponent(radNu)));

	    javax.swing.GroupLayout pnNgaySinhLayout = new javax.swing.GroupLayout(pnNgaySinh);
	    pnNgaySinh.setLayout(pnNgaySinhLayout);
	    pnNgaySinhLayout.setHorizontalGroup(pnNgaySinhLayout
		    .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
		    .addGroup(pnNgaySinhLayout.createSequentialGroup().addContainerGap()
			    .addComponent(txtNgaySinh, javax.swing.GroupLayout.DEFAULT_SIZE, 442, Short.MAX_VALUE)
			    .addContainerGap()));
	    pnNgaySinhLayout.setVerticalGroup(pnNgaySinhLayout
		    .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
		    .addGroup(pnNgaySinhLayout.createSequentialGroup()
			    .addComponent(txtNgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE,
				    javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
			    .addGap(0, 6, Short.MAX_VALUE)));

	    javax.swing.GroupLayout pnInfoLayout = new javax.swing.GroupLayout(pnInfo);
	    pnInfo.setLayout(pnInfoLayout);
	    pnInfoLayout.setHorizontalGroup(pnInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
		    .addGroup(pnInfoLayout.createSequentialGroup().addContainerGap()
			    .addGroup(pnInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
					    pnInfoLayout.createSequentialGroup()
						    .addComponent(lblDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE,
							    103, javax.swing.GroupLayout.PREFERRED_SIZE)
						    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						    .addComponent(txtDiaChi))
				    .addGroup(pnInfoLayout.createSequentialGroup()
					    .addComponent(lblEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 103,
						    javax.swing.GroupLayout.PREFERRED_SIZE)
					    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
					    .addComponent(txtEmail))
				    .addGroup(pnInfoLayout.createSequentialGroup()
					    .addComponent(lblSDT, javax.swing.GroupLayout.PREFERRED_SIZE, 103,
						    javax.swing.GroupLayout.PREFERRED_SIZE)
					    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
					    .addComponent(txtSDT))
				    .addGroup(pnInfoLayout.createSequentialGroup()
					    .addComponent(lblChucVu, javax.swing.GroupLayout.PREFERRED_SIZE, 103,
						    javax.swing.GroupLayout.PREFERRED_SIZE)
					    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
					    .addComponent(txtChucVu))
				    .addGroup(pnInfoLayout.createSequentialGroup()
					    .addComponent(pnGioiTinh, javax.swing.GroupLayout.DEFAULT_SIZE,
						    javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
					    .addComponent(pnNgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE,
						    javax.swing.GroupLayout.DEFAULT_SIZE,
						    javax.swing.GroupLayout.PREFERRED_SIZE))
				    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnInfoLayout
					    .createSequentialGroup().addGap(0, 0, Short.MAX_VALUE)
					    .addGroup(pnInfoLayout
						    .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						    .addComponent(lblMaNV, javax.swing.GroupLayout.PREFERRED_SIZE, 103,
							    javax.swing.GroupLayout.PREFERRED_SIZE)
						    .addComponent(lblTenNV, javax.swing.GroupLayout.PREFERRED_SIZE, 103,
							    javax.swing.GroupLayout.PREFERRED_SIZE))
					    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
					    .addGroup(pnInfoLayout
						    .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING,
							    false)
						    .addComponent(txtMaNV, javax.swing.GroupLayout.DEFAULT_SIZE, 482,
							    Short.MAX_VALUE)
						    .addComponent(txtTenNV))))
			    .addContainerGap()));
	    pnInfoLayout.setVerticalGroup(pnInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
		    .addGroup(pnInfoLayout.createSequentialGroup().addContainerGap()
			    .addGroup(pnInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
				    .addComponent(lblMaNV).addComponent(txtMaNV, javax.swing.GroupLayout.PREFERRED_SIZE,
					    26, javax.swing.GroupLayout.PREFERRED_SIZE))
			    .addGap(5, 5, 5)
			    .addGroup(pnInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
				    .addComponent(lblTenNV).addComponent(txtTenNV,
					    javax.swing.GroupLayout.PREFERRED_SIZE,
					    javax.swing.GroupLayout.DEFAULT_SIZE,
					    javax.swing.GroupLayout.PREFERRED_SIZE))
			    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
			    .addGroup(pnInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
				    .addComponent(pnGioiTinh, javax.swing.GroupLayout.DEFAULT_SIZE,
					    javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
				    .addComponent(pnNgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE,
					    javax.swing.GroupLayout.DEFAULT_SIZE,
					    javax.swing.GroupLayout.PREFERRED_SIZE))
			    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
			    .addGroup(pnInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
				    .addGroup(pnInfoLayout.createSequentialGroup().addComponent(lblDiaChi)
					    .addGap(12, 12, 12).addComponent(lblEmail).addGap(12, 12, 12)
					    .addComponent(lblSDT))
				    .addGroup(pnInfoLayout.createSequentialGroup()
					    .addComponent(txtDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE,
						    javax.swing.GroupLayout.DEFAULT_SIZE,
						    javax.swing.GroupLayout.PREFERRED_SIZE)
					    .addGap(6, 6, 6)
					    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE,
						    javax.swing.GroupLayout.DEFAULT_SIZE,
						    javax.swing.GroupLayout.PREFERRED_SIZE)
					    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
					    .addComponent(txtSDT, javax.swing.GroupLayout.PREFERRED_SIZE, 25,
						    javax.swing.GroupLayout.PREFERRED_SIZE)))
			    .addGap(9, 9, 9)
			    .addGroup(pnInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
				    .addComponent(lblChucVu).addComponent(txtChucVu,
					    javax.swing.GroupLayout.PREFERRED_SIZE,
					    javax.swing.GroupLayout.DEFAULT_SIZE,
					    javax.swing.GroupLayout.PREFERRED_SIZE))
			    .addContainerGap(9, Short.MAX_VALUE)));

	    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
	    getContentPane().setLayout(layout);
	    layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
		    .addGap(0, 625, Short.MAX_VALUE)
		    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
			    .addGroup(layout.createSequentialGroup().addContainerGap()
				    .addComponent(pnInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 645,
					    javax.swing.GroupLayout.PREFERRED_SIZE)
				    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))));
	    layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
		    .addGap(0, 304, Short.MAX_VALUE)
		    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout
			    .createSequentialGroup().addGap(7, 7, 7)
			    .addComponent(pnInfo, javax.swing.GroupLayout.PREFERRED_SIZE,
				    javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
			    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))));
	}

	private void event(String[] data) {
	    txtMaNV.setText(data[0]);
	    txtTenNV.setText(data[1]);
	    if (data[2].equalsIgnoreCase("Nam")) {
		radNam.setSelected(true);
		radNu.setSelected(false);
	    } else {
		radNam.setSelected(false);
		radNu.setSelected(true);
	    }
	    txtNgaySinh.setText(data[3]);
	    txtDiaChi.setText(data[4]);
	    txtEmail.setText(data[5]);
	    txtSDT.setText(data[6]);
	    txtChucVu.setText(data[7]);
	}
    }

    private class FrameAddNhanVien extends JFrame implements ActionListener, FocusListener, KeyListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7828075587047401918L;
	private javax.swing.JComboBox<String> cbxChucVu;
	private javax.swing.JLabel lblChucVu;
	private javax.swing.JLabel lblDiaChi;
	private javax.swing.JLabel lblEmail;
	private javax.swing.JLabel lblMaNV;
	private javax.swing.JLabel lblSDT;
	private javax.swing.JLabel lblTenNV;
	private javax.swing.JPanel pnGioiTinh;
	private javax.swing.JPanel pnInfo;
	private javax.swing.JPanel pnNgaySinh;
	private javax.swing.JRadioButton radNam;
	private javax.swing.JRadioButton radNu;
	private javax.swing.JTextField txtDiaChi;
	private javax.swing.JTextField txtEmail;
	private javax.swing.JTextField txtMaNV;
	private JDatePicker dpkNgaySinh;
	private javax.swing.JTextField txtSDT;
	private javax.swing.JTextField txtTenNV;
	private JButton btnThem, btnHuy;

	private FrameAddNhanVien() {
	    this.setTitle("SE Tourist - Them Nhan Vien");
	    this.setIconImage(LoadSave.GetSpriteAtlas(LoadSave.LOGO_ICON));
	    this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	    this.setResizable(false);
	    this.setLocationRelativeTo(null);
	    this.setMaximumSize(new java.awt.Dimension(700, 470));
	    this.setMinimumSize(new java.awt.Dimension(700, 470));

	    this.init();
	    this.style();
	    this.preset();
	    this.event();
	}

	private void init() {
	    // TODO Auto-generated method stub
	    pnInfo = new javax.swing.JPanel();
	    lblMaNV = new javax.swing.JLabel();
	    txtMaNV = new javax.swing.JTextField();
	    lblTenNV = new javax.swing.JLabel();
	    txtTenNV = new javax.swing.JTextField();
	    pnGioiTinh = new javax.swing.JPanel();
	    radNam = new javax.swing.JRadioButton();
	    radNu = new javax.swing.JRadioButton();
	    pnNgaySinh = new javax.swing.JPanel();
	    dpkNgaySinh = new org.jdatepicker.JDatePicker();
	    lblDiaChi = new javax.swing.JLabel();
	    txtDiaChi = new javax.swing.JTextField();
	    lblEmail = new javax.swing.JLabel();
	    txtEmail = new javax.swing.JTextField();
	    lblSDT = new javax.swing.JLabel();
	    txtSDT = new javax.swing.JTextField();
	    lblChucVu = new javax.swing.JLabel();
	    cbxChucVu = new javax.swing.JComboBox<>();
	    pnAction = new javax.swing.JPanel();
	    btnThem = new javax.swing.JButton();
	    btnHuy = new javax.swing.JButton();
	}

	private void style() {
	    // TODO Auto-generated method stub
	    pnInfo.setBorder(javax.swing.BorderFactory.createTitledBorder(
		    javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED),
		    "Thong Tin Nhan Vien", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,
		    javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 14))); // NOI18N

	    lblMaNV.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
	    lblMaNV.setText("Ma Nhan Vien:");

//	    txtMaNV.setEditable(false);
	    txtMaNV.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

	    lblTenNV.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
	    lblTenNV.setText("Ten Nhan Vien:");

	    txtTenNV.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

	    pnGioiTinh.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Gioi Tinh",
		    javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,
		    javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 14))); // NOI18N

	    radNam.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
	    radNam.setSelected(true);
	    radNam.setText("Nam");
	    radNam.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

	    radNu.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
	    radNu.setText("Nu");
	    radNu.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

	    pnNgaySinh.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Ngay Sinh",
		    javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,
		    javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 14))); // NOI18N

	    dpkNgaySinh.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

	    lblDiaChi.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
	    lblDiaChi.setText("Dia Chi:");

	    txtDiaChi.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

	    lblEmail.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
	    lblEmail.setText("Email:");

	    txtEmail.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

	    lblSDT.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
	    lblSDT.setText("So Dien Thoai:");

	    txtSDT.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

	    lblChucVu.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
	    lblChucVu.setText("Chuc Vu:");

	    cbxChucVu.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
	    cbxChucVu.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Quan Ly", "Nhan Vien" }));
	    cbxChucVu.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

	    pnAction.setBorder(javax.swing.BorderFactory.createTitledBorder("Chon Tac Vu"));

	    btnThem.setBackground(new java.awt.Color(51, 204, 0));
	    btnThem.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
	    btnThem.setForeground(new java.awt.Color(255, 255, 255));
	    btnThem.setText("Them");
	    btnThem.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

	    btnHuy.setBackground(new java.awt.Color(255, 0, 0));
	    btnHuy.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
	    btnHuy.setForeground(new java.awt.Color(255, 255, 255));
	    btnHuy.setText("Huy");
	    btnHuy.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
	}

	private void preset() {
	    // TODO Auto-generated method stub
	    javax.swing.GroupLayout pnGioiTinhLayout = new javax.swing.GroupLayout(pnGioiTinh);
	    pnGioiTinh.setLayout(pnGioiTinhLayout);
	    pnGioiTinhLayout.setHorizontalGroup(pnGioiTinhLayout
		    .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
		    .addGroup(pnGioiTinhLayout.createSequentialGroup().addContainerGap().addComponent(radNam)
			    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(radNu)
			    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
	    pnGioiTinhLayout
		    .setVerticalGroup(pnGioiTinhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
			    .addGroup(pnGioiTinhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
				    .addComponent(radNam).addComponent(radNu)));

	    javax.swing.GroupLayout pnNgaySinhLayout = new javax.swing.GroupLayout(pnNgaySinh);
	    pnNgaySinh.setLayout(pnNgaySinhLayout);
	    pnNgaySinhLayout
		    .setHorizontalGroup(pnNgaySinhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
			    .addGroup(pnNgaySinhLayout.createSequentialGroup().addContainerGap()
				    .addComponent(dpkNgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, 438,
					    javax.swing.GroupLayout.PREFERRED_SIZE)
				    .addContainerGap(8, Short.MAX_VALUE)));
	    pnNgaySinhLayout.setVerticalGroup(pnNgaySinhLayout
		    .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
		    .addGroup(pnNgaySinhLayout.createSequentialGroup()
			    .addComponent(dpkNgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE,
				    javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
			    .addGap(0, 5, Short.MAX_VALUE)));

	    javax.swing.GroupLayout pnInfoLayout = new javax.swing.GroupLayout(pnInfo);
	    pnInfo.setLayout(pnInfoLayout);
	    pnInfoLayout.setHorizontalGroup(pnInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
		    .addGroup(pnInfoLayout.createSequentialGroup().addContainerGap()
			    .addGroup(pnInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
					    pnInfoLayout.createSequentialGroup()
						    .addComponent(lblDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE,
							    103, javax.swing.GroupLayout.PREFERRED_SIZE)
						    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						    .addComponent(txtDiaChi))
				    .addGroup(pnInfoLayout.createSequentialGroup()
					    .addComponent(lblEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 103,
						    javax.swing.GroupLayout.PREFERRED_SIZE)
					    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
					    .addComponent(txtEmail))
				    .addGroup(pnInfoLayout.createSequentialGroup()
					    .addComponent(lblSDT, javax.swing.GroupLayout.PREFERRED_SIZE, 103,
						    javax.swing.GroupLayout.PREFERRED_SIZE)
					    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
					    .addComponent(txtSDT))
				    .addGroup(pnInfoLayout.createSequentialGroup()
					    .addComponent(lblChucVu, javax.swing.GroupLayout.PREFERRED_SIZE, 103,
						    javax.swing.GroupLayout.PREFERRED_SIZE)
					    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
					    .addComponent(cbxChucVu, 0, javax.swing.GroupLayout.DEFAULT_SIZE,
						    Short.MAX_VALUE))
				    .addGroup(pnInfoLayout.createSequentialGroup()
					    .addComponent(pnGioiTinh, javax.swing.GroupLayout.DEFAULT_SIZE,
						    javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
					    .addComponent(pnNgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE,
						    javax.swing.GroupLayout.DEFAULT_SIZE,
						    javax.swing.GroupLayout.PREFERRED_SIZE))
				    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnInfoLayout
					    .createSequentialGroup().addGap(0, 0, Short.MAX_VALUE)
					    .addGroup(pnInfoLayout
						    .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						    .addComponent(lblMaNV, javax.swing.GroupLayout.PREFERRED_SIZE, 103,
							    javax.swing.GroupLayout.PREFERRED_SIZE)
						    .addComponent(lblTenNV, javax.swing.GroupLayout.PREFERRED_SIZE, 103,
							    javax.swing.GroupLayout.PREFERRED_SIZE))
					    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
					    .addGroup(pnInfoLayout
						    .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING,
							    false)
						    .addComponent(txtMaNV, javax.swing.GroupLayout.DEFAULT_SIZE, 482,
							    Short.MAX_VALUE)
						    .addComponent(txtTenNV))))
			    .addContainerGap()));
	    pnInfoLayout.setVerticalGroup(pnInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
		    .addGroup(pnInfoLayout.createSequentialGroup().addContainerGap()
			    .addGroup(pnInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
				    .addComponent(lblMaNV).addComponent(txtMaNV, javax.swing.GroupLayout.PREFERRED_SIZE,
					    26, javax.swing.GroupLayout.PREFERRED_SIZE))
			    .addGap(5, 5, 5)
			    .addGroup(pnInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
				    .addComponent(lblTenNV).addComponent(txtTenNV,
					    javax.swing.GroupLayout.PREFERRED_SIZE,
					    javax.swing.GroupLayout.DEFAULT_SIZE,
					    javax.swing.GroupLayout.PREFERRED_SIZE))
			    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
			    .addGroup(pnInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
				    .addComponent(pnGioiTinh, javax.swing.GroupLayout.DEFAULT_SIZE,
					    javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
				    .addComponent(pnNgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE,
					    javax.swing.GroupLayout.DEFAULT_SIZE,
					    javax.swing.GroupLayout.PREFERRED_SIZE))
			    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
			    .addGroup(
				    pnInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
					    .addGroup(pnInfoLayout.createSequentialGroup().addGap(5, 5, 5)
						    .addComponent(lblDiaChi).addGap(12, 12, 12).addComponent(lblEmail)
						    .addGap(12, 12, 12).addComponent(lblSDT).addGap(12, 12, 12)
						    .addComponent(lblChucVu))
					    .addGroup(pnInfoLayout.createSequentialGroup()
						    .addComponent(txtDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE,
							    javax.swing.GroupLayout.DEFAULT_SIZE,
							    javax.swing.GroupLayout.PREFERRED_SIZE)
						    .addGap(6, 6, 6)
						    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE,
							    javax.swing.GroupLayout.DEFAULT_SIZE,
							    javax.swing.GroupLayout.PREFERRED_SIZE)
						    .addGap(6, 6, 6)
						    .addComponent(txtSDT, javax.swing.GroupLayout.PREFERRED_SIZE,
							    javax.swing.GroupLayout.DEFAULT_SIZE,
							    javax.swing.GroupLayout.PREFERRED_SIZE)
						    .addGap(6, 6, 6).addComponent(cbxChucVu,
							    javax.swing.GroupLayout.PREFERRED_SIZE,
							    javax.swing.GroupLayout.DEFAULT_SIZE,
							    javax.swing.GroupLayout.PREFERRED_SIZE)))
			    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

	    javax.swing.GroupLayout pnActionLayout = new javax.swing.GroupLayout(pnAction);
	    pnAction.setLayout(pnActionLayout);
	    pnActionLayout
		    .setHorizontalGroup(pnActionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
			    .addGroup(pnActionLayout.createSequentialGroup().addContainerGap()
				    .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 185,
					    javax.swing.GroupLayout.PREFERRED_SIZE)
				    .addGap(18, 18, 18)
				    .addComponent(btnHuy, javax.swing.GroupLayout.PREFERRED_SIZE, 113,
					    javax.swing.GroupLayout.PREFERRED_SIZE)
				    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

	    pnActionLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL,
		    new java.awt.Component[] { btnHuy, btnThem });

	    pnActionLayout.setVerticalGroup(pnActionLayout
		    .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
		    .addGroup(pnActionLayout.createSequentialGroup()
			    .addGroup(pnActionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
				    .addComponent(btnHuy).addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE,
					    34, javax.swing.GroupLayout.PREFERRED_SIZE))
			    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

	    pnActionLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] { btnHuy, btnThem });

	    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
	    getContentPane().setLayout(layout);
	    layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
		    .addGroup(layout.createSequentialGroup().addContainerGap()
			    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				    .addComponent(pnInfo, javax.swing.GroupLayout.DEFAULT_SIZE,
					    javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
				    .addComponent(pnAction, javax.swing.GroupLayout.DEFAULT_SIZE,
					    javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
			    .addContainerGap()));
	    layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
		    .addGroup(layout.createSequentialGroup().addContainerGap()
			    .addComponent(pnInfo, javax.swing.GroupLayout.PREFERRED_SIZE,
				    javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
			    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
			    .addComponent(pnAction, javax.swing.GroupLayout.PREFERRED_SIZE,
				    javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
			    .addContainerGap()));
	}

	private void event() {
	    // TODO Auto-generated method stub
	    this.btnThem.addActionListener(this);
	    this.btnHuy.addActionListener(this);
	    this.txtEmail.addFocusListener(this);
	    this.txtSDT.addFocusListener(this);
	    this.txtEmail.addKeyListener(this);
	    this.txtSDT.addKeyListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
	    // TODO Auto-generated method stub
	    Object o = e.getSource();
	    if (o.equals(this.btnThem)) {
		if (txtEmail.getText().trim().matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$")
			&& txtSDT.getText().trim().matches("^(03|05|07|08|09)+([0-9]{8})$")) {
		    boolean gender = false;
		    if (radNam.isSelected())
			gender = false;
		    if (radNu.isSelected())
			gender = true;

		    // Lấy ngày tháng được chọn từ JDatePicker
		    Calendar selectedDate = (Calendar) dpkNgaySinh.getModel().getValue();

		    LocalDate localDate = LocalDate.of(selectedDate.get(Calendar.YEAR),
			    selectedDate.get(Calendar.MONTH) + 1, selectedDate.get(Calendar.DAY_OF_MONTH));

		    NhanVien newNV = new NhanVien(txtMaNV.getText(), txtTenNV.getText(), gender, localDate,
			    txtDiaChi.getText(), txtEmail.getText(), txtSDT.getText(),
			    cbxChucVu.getSelectedItem().toString());

		    if (DAO_NhanVien.themNhanVien(newNV)) {
			JOptionPane.showMessageDialog(null, "Them Thanh Cong");
			tblModel.setRowCount(0);
			loadData();
		    } else {
			JOptionPane.showMessageDialog(null, "Them That Bai");
			this.dispose();
		    }
		} else {
		    JOptionPane.showMessageDialog(null, "Kiem tra lai thong tin nhap vao");
		}

	    }
	    if (o.equals(this.btnHuy)) {
		this.dispose();
	    }
	}

	@Override
	public void focusGained(FocusEvent e) {
	    // TODO Auto-generated method stub

	}

	@Override
	public void focusLost(FocusEvent e) {
	    // TODO Auto-generated method stub
	    Object o = e.getSource();

	    if (o.equals(txtEmail)) {
		String regex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$"; // Regex kiểm tra Email
		String email = txtEmail.getText().trim();
		if (!email.matches(regex)) {
		    // Nếu dữ liệu nhập vào không đúng, đổi màu viền sang đỏ
		    txtEmail.setBorder(BorderFactory.createLineBorder(Color.RED));
		} else {
		    // Nếu dữ liệu nhập vào đúng, đổi màu viền sang xanh
		    txtEmail.setBorder(BorderFactory.createLineBorder(Color.GREEN));
		}
	    }

	    if (o.equals(txtSDT)) {
		String regex = "^(03|05|07|08|09)+([0-9]{8})$"; // Regex kiểm tra số điện thoại
		String sdt = txtSDT.getText().trim(); // Lấy giá trị của txtSDT và loại bỏ khoảng trắng ở đầu và cuối
						      // chuỗi
		if (!sdt.matches(regex)) {
		    // Nếu dữ liệu nhập vào không đúng, đổi màu viền sang đỏ
		    txtSDT.setBorder(BorderFactory.createLineBorder(Color.RED));
		} else {
		    // Nếu dữ liệu nhập vào đúng, đổi màu viền sang xanh
		    txtSDT.setBorder(BorderFactory.createLineBorder(Color.GREEN));
		}
	    }
	}

	@Override
	public void keyTyped(KeyEvent e) {
	    // TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
	    // TODO Auto-generated method stub

	}

	@Override
	public void keyReleased(KeyEvent e) {
	    // TODO Auto-generated method stub
	    Object o = e.getSource();

	    if (o.equals(txtEmail)) {
		String regex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$"; // Regex kiểm tra Email
		String email = txtEmail.getText().trim();
		if (!email.matches(regex)) {
		    // Nếu dữ liệu nhập vào không đúng, đổi màu viền sang đỏ
		    txtEmail.setBorder(BorderFactory.createLineBorder(Color.RED));
		} else {
		    // Nếu dữ liệu nhập vào đúng, đổi màu viền sang xanh
		    txtEmail.setBorder(BorderFactory.createLineBorder(Color.GREEN));
		}
	    }

	    if (o.equals(txtSDT)) {
		String regex = "^(03|05|07|08|09)+([0-9]{8})$"; // Regex kiểm tra số điện thoại
		String sdt = txtSDT.getText().trim(); // Lấy giá trị của txtSDT và loại bỏ khoảng trắng ở đầu và cuối
						      // chuỗi
		if (!sdt.matches(regex)) {
		    // Nếu dữ liệu nhập vào không đúng, đổi màu viền sang đỏ
		    txtSDT.setBorder(BorderFactory.createLineBorder(Color.RED));
		} else {
		    // Nếu dữ liệu nhập vào đúng, đổi màu viền sang xanh
		    txtSDT.setBorder(BorderFactory.createLineBorder(Color.GREEN));
		}
	    }
	}
    }

    private class FrameModifyNhanVien extends JFrame implements ActionListener, FocusListener, KeyListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8274213113371000350L;
	private javax.swing.JButton btnCancel;
	private javax.swing.JButton btnUpdate;
	private org.jdatepicker.JDatePicker dpkNgaySinhNew;
	private javax.swing.JComboBox<String> cbxChucVuNew;
	private javax.swing.JLabel lblChucVuNew;
	private javax.swing.JLabel lblChucVuOld;
	private javax.swing.JLabel lblDiaChiNew;
	private javax.swing.JLabel lblDiaChiOld;
	private javax.swing.JLabel lblEmailNew;
	private javax.swing.JLabel lblEmailOld;
	private javax.swing.JLabel lblMaNVNew;
	private javax.swing.JLabel lblMaNVOld;
	private javax.swing.JLabel lblSDTNew;
	private javax.swing.JLabel lblSDTOld;
	private javax.swing.JLabel lblTenNVNew;
	private javax.swing.JLabel lblTenNVOld;
	private javax.swing.JPanel pnAction;
	private javax.swing.JPanel pnGioiTinhOld;
	private javax.swing.JPanel pnGioiTinhNew;
	private javax.swing.JPanel pnNew;
	private javax.swing.JPanel pnNgaySinhNew;
	private javax.swing.JPanel pnNgaySinhOld;
	private javax.swing.JPanel pnOld;
	private javax.swing.JRadioButton radNamNew;
	private javax.swing.JRadioButton radNamOld;
	private javax.swing.JRadioButton radNuNew;
	private javax.swing.JRadioButton radNuOld;
	private javax.swing.JTextField txtChucVuOld;
	private javax.swing.JTextField txtDiaChiNew;
	private javax.swing.JTextField txtDiaChiOld;
	private javax.swing.JTextField txtEmailNew;
	private javax.swing.JTextField txtEmailOld;
	private javax.swing.JTextField txtMaNVNew;
	private javax.swing.JTextField txtMaNVOld;
	private javax.swing.JTextField txtNgaySinhOld;
	private javax.swing.JTextField txtSDTNew;
	private javax.swing.JTextField txtSDTOld;
	private javax.swing.JTextField txtTenNVNew;
	private javax.swing.JTextField txtTenNVOld;

	private FrameModifyNhanVien(String[] data) {
	    this.setTitle("SE Tourist - Chinh Sua Nhan Vien");
	    this.setIconImage(LoadSave.GetSpriteAtlas(LoadSave.LOGO_ICON));
	    this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	    this.setResizable(false);
	    this.setLocationRelativeTo(null);
	    this.setMaximumSize(new java.awt.Dimension(1400, 470));
	    this.setMinimumSize(new java.awt.Dimension(1400, 470));

	    this.init();
	    this.style();
	    this.preset();
	    this.event(data);
	}

	private void init() {
	    // TODO Auto-generated method stub
	    pnNew = new javax.swing.JPanel();
	    lblMaNVNew = new javax.swing.JLabel();
	    txtMaNVNew = new javax.swing.JTextField();
	    lblTenNVNew = new javax.swing.JLabel();
	    txtTenNVNew = new javax.swing.JTextField();
	    pnGioiTinhNew = new javax.swing.JPanel();
	    radNamNew = new javax.swing.JRadioButton();
	    radNuNew = new javax.swing.JRadioButton();
	    pnNgaySinhNew = new javax.swing.JPanel();
	    dpkNgaySinhNew = new org.jdatepicker.JDatePicker();
	    lblDiaChiNew = new javax.swing.JLabel();
	    txtDiaChiNew = new javax.swing.JTextField();
	    lblEmailNew = new javax.swing.JLabel();
	    txtEmailNew = new javax.swing.JTextField();
	    lblSDTNew = new javax.swing.JLabel();
	    txtSDTNew = new javax.swing.JTextField();
	    lblChucVuNew = new javax.swing.JLabel();
	    cbxChucVuNew = new javax.swing.JComboBox<>();
	    pnOld = new javax.swing.JPanel();
	    lblMaNVOld = new javax.swing.JLabel();
	    txtMaNVOld = new javax.swing.JTextField();
	    lblTenNVOld = new javax.swing.JLabel();
	    txtTenNVOld = new javax.swing.JTextField();
	    pnGioiTinhOld = new javax.swing.JPanel();
	    radNamOld = new javax.swing.JRadioButton();
	    radNuOld = new javax.swing.JRadioButton();
	    pnNgaySinhOld = new javax.swing.JPanel();
	    txtNgaySinhOld = new javax.swing.JTextField();
	    lblDiaChiOld = new javax.swing.JLabel();
	    txtDiaChiOld = new javax.swing.JTextField();
	    lblEmailOld = new javax.swing.JLabel();
	    txtEmailOld = new javax.swing.JTextField();
	    lblSDTOld = new javax.swing.JLabel();
	    txtSDTOld = new javax.swing.JTextField();
	    lblChucVuOld = new javax.swing.JLabel();
	    txtChucVuOld = new javax.swing.JTextField();
	    pnAction = new javax.swing.JPanel();
	    btnUpdate = new javax.swing.JButton();
	    btnCancel = new javax.swing.JButton();
	}

	private void style() {
	    // TODO Auto-generated method stub
	    pnNew.setBorder(javax.swing.BorderFactory.createTitledBorder(
		    javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED), "Thong Tin Moi",
		    javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,
		    javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 14),
		    new java.awt.Color(0, 204, 0))); // NOI18N

	    lblMaNVNew.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
	    lblMaNVNew.setText("Ma Nhan Vien:");

	    txtMaNVNew.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
	    txtMaNVNew.setEditable(false);

	    lblTenNVNew.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
	    lblTenNVNew.setText("Ten Nhan Vien:");

	    txtTenNVNew.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

	    pnGioiTinhNew.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Gioi Tinh",
		    javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,
		    javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 14))); // NOI18N

	    radNamNew.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
	    radNamNew.setSelected(true);
	    radNamNew.setText("Nam");
	    radNamNew.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

	    radNuNew.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
	    radNuNew.setText("Nu");
	    radNuNew.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

	    pnNgaySinhNew.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Ngay Sinh",
		    javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,
		    javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 14))); // NOI18N

	    lblDiaChiNew.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
	    lblDiaChiNew.setText("Dia Chi:");

	    txtDiaChiNew.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

	    lblEmailNew.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
	    lblEmailNew.setText("Email:");

	    txtEmailNew.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

	    lblSDTNew.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
	    lblSDTNew.setText("So Dien Thoai:");

	    txtSDTNew.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

	    lblChucVuNew.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
	    lblChucVuNew.setText("Chuc Vu:");

	    cbxChucVuNew.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
	    cbxChucVuNew.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Quan Ly", "Nhan Vien" }));
	    cbxChucVuNew.setToolTipText("");

	    pnOld.setBorder(javax.swing.BorderFactory.createTitledBorder(
		    javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED), "Thong Tin Cu",
		    javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,
		    javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 14),
		    new java.awt.Color(255, 0, 0))); // NOI18N

	    lblMaNVOld.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
	    lblMaNVOld.setText("Ma Nhan Vien:");

	    txtMaNVOld.setEditable(false);
	    txtMaNVOld.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

	    lblTenNVOld.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
	    lblTenNVOld.setText("Ten Nhan Vien:");

	    txtTenNVOld.setEditable(false);
	    txtTenNVOld.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

	    pnGioiTinhOld.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Gioi Tinh",
		    javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,
		    javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 14))); // NOI18N

	    radNamOld.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
	    radNamOld.setSelected(true);
	    radNamOld.setText("Nam");
	    radNamOld.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
	    radNamOld.setEnabled(false);

	    radNuOld.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
	    radNuOld.setText("Nu");
	    radNuOld.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
	    radNuOld.setEnabled(false);

	    pnNgaySinhOld.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Ngay Sinh",
		    javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,
		    javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 14))); // NOI18N

	    txtNgaySinhOld.setEditable(false);

	    lblDiaChiOld.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
	    lblDiaChiOld.setText("Dia Chi:");

	    txtDiaChiOld.setEditable(false);
	    txtDiaChiOld.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

	    lblEmailOld.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
	    lblEmailOld.setText("Email:");

	    txtEmailOld.setEditable(false);
	    txtEmailOld.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

	    lblSDTOld.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
	    lblSDTOld.setText("So Dien Thoai:");

	    txtSDTOld.setEditable(false);
	    txtSDTOld.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

	    lblChucVuOld.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
	    lblChucVuOld.setText("Chuc Vu:");

	    txtChucVuOld.setEditable(false);
	    txtChucVuOld.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

	    pnAction.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Chon Tac Vu",
		    javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,
		    javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 14))); // NOI18N

	    btnUpdate.setBackground(new java.awt.Color(255, 0, 0));
	    btnUpdate.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
	    btnUpdate.setForeground(new java.awt.Color(255, 255, 255));
	    btnUpdate.setText("Cap Nhat Thay Doi");
	    btnUpdate.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

	    btnCancel.setBackground(new java.awt.Color(0, 255, 0));
	    btnCancel.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
	    btnCancel.setForeground(new java.awt.Color(255, 255, 255));
	    btnCancel.setText("Huy Bo Thay Doi");
	    btnCancel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
	}

	private void preset() {
	    // TODO Auto-generated method stub
	    javax.swing.GroupLayout pnGioiTinhNewLayout = new javax.swing.GroupLayout(pnGioiTinhNew);
	    pnGioiTinhNew.setLayout(pnGioiTinhNewLayout);
	    pnGioiTinhNewLayout.setHorizontalGroup(pnGioiTinhNewLayout
		    .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
		    .addGroup(pnGioiTinhNewLayout.createSequentialGroup().addContainerGap().addComponent(radNamNew)
			    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(radNuNew)
			    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
	    pnGioiTinhNewLayout.setVerticalGroup(
		    pnGioiTinhNewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(
			    pnGioiTinhNewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
				    .addComponent(radNamNew).addComponent(radNuNew)));

	    javax.swing.GroupLayout pnNgaySinhNewLayout = new javax.swing.GroupLayout(pnNgaySinhNew);
	    pnNgaySinhNew.setLayout(pnNgaySinhNewLayout);
	    pnNgaySinhNewLayout.setHorizontalGroup(pnNgaySinhNewLayout
		    .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
		    .addGroup(pnNgaySinhNewLayout.createSequentialGroup().addContainerGap()
			    .addComponent(dpkNgaySinhNew, javax.swing.GroupLayout.DEFAULT_SIZE, 442, Short.MAX_VALUE)
			    .addContainerGap()));
	    pnNgaySinhNewLayout.setVerticalGroup(pnNgaySinhNewLayout
		    .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
		    .addGroup(pnNgaySinhNewLayout.createSequentialGroup()
			    .addComponent(dpkNgaySinhNew, javax.swing.GroupLayout.PREFERRED_SIZE,
				    javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
			    .addGap(0, 8, Short.MAX_VALUE)));

	    javax.swing.GroupLayout pnNewLayout = new javax.swing.GroupLayout(pnNew);
	    pnNew.setLayout(pnNewLayout);
	    pnNewLayout.setHorizontalGroup(pnNewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
		    .addGroup(pnNewLayout.createSequentialGroup().addContainerGap()
			    .addGroup(pnNewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
					    pnNewLayout.createSequentialGroup()
						    .addComponent(lblDiaChiNew, javax.swing.GroupLayout.PREFERRED_SIZE,
							    103, javax.swing.GroupLayout.PREFERRED_SIZE)
						    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						    .addComponent(txtDiaChiNew))
				    .addGroup(pnNewLayout.createSequentialGroup()
					    .addComponent(lblEmailNew, javax.swing.GroupLayout.PREFERRED_SIZE, 103,
						    javax.swing.GroupLayout.PREFERRED_SIZE)
					    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
					    .addComponent(txtEmailNew))
				    .addGroup(pnNewLayout.createSequentialGroup()
					    .addComponent(lblSDTNew, javax.swing.GroupLayout.PREFERRED_SIZE, 103,
						    javax.swing.GroupLayout.PREFERRED_SIZE)
					    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
					    .addComponent(txtSDTNew))
				    .addGroup(pnNewLayout.createSequentialGroup()
					    .addComponent(lblChucVuNew, javax.swing.GroupLayout.PREFERRED_SIZE, 103,
						    javax.swing.GroupLayout.PREFERRED_SIZE)
					    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
					    .addComponent(cbxChucVuNew, 0, javax.swing.GroupLayout.DEFAULT_SIZE,
						    Short.MAX_VALUE))
				    .addGroup(pnNewLayout.createSequentialGroup()
					    .addComponent(pnGioiTinhNew, javax.swing.GroupLayout.DEFAULT_SIZE,
						    javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
					    .addComponent(
						    pnNgaySinhNew, javax.swing.GroupLayout.PREFERRED_SIZE,
						    javax.swing.GroupLayout.DEFAULT_SIZE,
						    javax.swing.GroupLayout.PREFERRED_SIZE))
				    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnNewLayout
					    .createSequentialGroup().addGap(1, 1, 1)
					    .addGroup(pnNewLayout
						    .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						    .addComponent(lblMaNVNew, javax.swing.GroupLayout.PREFERRED_SIZE,
							    103, javax.swing.GroupLayout.PREFERRED_SIZE)
						    .addComponent(lblTenNVNew, javax.swing.GroupLayout.PREFERRED_SIZE,
							    103, javax.swing.GroupLayout.PREFERRED_SIZE))
					    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
					    .addGroup(pnNewLayout
						    .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						    .addComponent(txtMaNVNew).addComponent(txtTenNVNew))))
			    .addContainerGap()));
	    pnNewLayout.setVerticalGroup(pnNewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
		    .addGroup(pnNewLayout.createSequentialGroup().addContainerGap()
			    .addGroup(pnNewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
				    .addComponent(lblMaNVNew).addComponent(txtMaNVNew,
					    javax.swing.GroupLayout.PREFERRED_SIZE, 26,
					    javax.swing.GroupLayout.PREFERRED_SIZE))
			    .addGap(5, 5, 5)
			    .addGroup(pnNewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
				    .addComponent(lblTenNVNew).addComponent(txtTenNVNew,
					    javax.swing.GroupLayout.PREFERRED_SIZE,
					    javax.swing.GroupLayout.DEFAULT_SIZE,
					    javax.swing.GroupLayout.PREFERRED_SIZE))
			    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
			    .addGroup(pnNewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
				    .addComponent(pnGioiTinhNew, javax.swing.GroupLayout.DEFAULT_SIZE,
					    javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
				    .addComponent(pnNgaySinhNew, javax.swing.GroupLayout.PREFERRED_SIZE,
					    javax.swing.GroupLayout.DEFAULT_SIZE,
					    javax.swing.GroupLayout.PREFERRED_SIZE))
			    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
			    .addGroup(pnNewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
				    .addGroup(pnNewLayout.createSequentialGroup().addComponent(lblDiaChiNew)
					    .addGap(12, 12, 12).addComponent(lblEmailNew).addGap(12, 12, 12)
					    .addComponent(lblSDTNew))
				    .addGroup(pnNewLayout.createSequentialGroup()
					    .addComponent(txtDiaChiNew, javax.swing.GroupLayout.PREFERRED_SIZE,
						    javax.swing.GroupLayout.DEFAULT_SIZE,
						    javax.swing.GroupLayout.PREFERRED_SIZE)
					    .addGap(6, 6, 6)
					    .addComponent(txtEmailNew, javax.swing.GroupLayout.PREFERRED_SIZE,
						    javax.swing.GroupLayout.DEFAULT_SIZE,
						    javax.swing.GroupLayout.PREFERRED_SIZE)
					    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
					    .addComponent(txtSDTNew, javax.swing.GroupLayout.PREFERRED_SIZE, 25,
						    javax.swing.GroupLayout.PREFERRED_SIZE)))
			    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
			    .addGroup(pnNewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				    .addComponent(cbxChucVuNew).addComponent(lblChucVuNew,
					    javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
					    Short.MAX_VALUE))
			    .addContainerGap()));

	    javax.swing.GroupLayout pnGioiTinh1Layout = new javax.swing.GroupLayout(pnGioiTinhOld);
	    pnGioiTinhOld.setLayout(pnGioiTinh1Layout);
	    pnGioiTinh1Layout.setHorizontalGroup(pnGioiTinh1Layout
		    .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
		    .addGroup(pnGioiTinh1Layout.createSequentialGroup().addContainerGap().addComponent(radNamOld)
			    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(radNuOld)
			    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
	    pnGioiTinh1Layout
		    .setVerticalGroup(pnGioiTinh1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
			    .addGroup(pnGioiTinh1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
				    .addComponent(radNamOld).addComponent(radNuOld)));

	    javax.swing.GroupLayout pnNgaySinhOldLayout = new javax.swing.GroupLayout(pnNgaySinhOld);
	    pnNgaySinhOld.setLayout(pnNgaySinhOldLayout);
	    pnNgaySinhOldLayout.setHorizontalGroup(pnNgaySinhOldLayout
		    .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
		    .addGroup(pnNgaySinhOldLayout.createSequentialGroup().addContainerGap()
			    .addComponent(txtNgaySinhOld, javax.swing.GroupLayout.DEFAULT_SIZE, 442, Short.MAX_VALUE)
			    .addContainerGap()));
	    pnNgaySinhOldLayout.setVerticalGroup(pnNgaySinhOldLayout
		    .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
		    .addGroup(pnNgaySinhOldLayout.createSequentialGroup()
			    .addComponent(txtNgaySinhOld, javax.swing.GroupLayout.PREFERRED_SIZE,
				    javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
			    .addGap(0, 6, Short.MAX_VALUE)));

	    javax.swing.GroupLayout pnOldLayout = new javax.swing.GroupLayout(pnOld);
	    pnOld.setLayout(pnOldLayout);
	    pnOldLayout.setHorizontalGroup(pnOldLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
		    .addGroup(pnOldLayout.createSequentialGroup().addContainerGap()
			    .addGroup(pnOldLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
					    pnOldLayout.createSequentialGroup()
						    .addComponent(lblDiaChiOld, javax.swing.GroupLayout.PREFERRED_SIZE,
							    103, javax.swing.GroupLayout.PREFERRED_SIZE)
						    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						    .addComponent(txtDiaChiOld))
				    .addGroup(pnOldLayout.createSequentialGroup()
					    .addComponent(lblEmailOld, javax.swing.GroupLayout.PREFERRED_SIZE, 103,
						    javax.swing.GroupLayout.PREFERRED_SIZE)
					    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
					    .addComponent(txtEmailOld))
				    .addGroup(pnOldLayout.createSequentialGroup()
					    .addComponent(lblSDTOld, javax.swing.GroupLayout.PREFERRED_SIZE, 103,
						    javax.swing.GroupLayout.PREFERRED_SIZE)
					    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
					    .addComponent(txtSDTOld))
				    .addGroup(pnOldLayout.createSequentialGroup()
					    .addComponent(lblChucVuOld, javax.swing.GroupLayout.PREFERRED_SIZE, 103,
						    javax.swing.GroupLayout.PREFERRED_SIZE)
					    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
					    .addComponent(txtChucVuOld))
				    .addGroup(pnOldLayout.createSequentialGroup()
					    .addComponent(pnGioiTinhOld, javax.swing.GroupLayout.DEFAULT_SIZE,
						    javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
					    .addComponent(
						    pnNgaySinhOld, javax.swing.GroupLayout.PREFERRED_SIZE,
						    javax.swing.GroupLayout.DEFAULT_SIZE,
						    javax.swing.GroupLayout.PREFERRED_SIZE))
				    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnOldLayout
					    .createSequentialGroup().addGap(0, 0, Short.MAX_VALUE)
					    .addGroup(pnOldLayout
						    .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						    .addComponent(lblMaNVOld, javax.swing.GroupLayout.PREFERRED_SIZE,
							    103, javax.swing.GroupLayout.PREFERRED_SIZE)
						    .addComponent(lblTenNVOld, javax.swing.GroupLayout.PREFERRED_SIZE,
							    103, javax.swing.GroupLayout.PREFERRED_SIZE))
					    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
					    .addGroup(pnOldLayout
						    .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING,
							    false)
						    .addComponent(txtMaNVOld, javax.swing.GroupLayout.DEFAULT_SIZE, 482,
							    Short.MAX_VALUE)
						    .addComponent(txtTenNVOld))))
			    .addContainerGap()));
	    pnOldLayout.setVerticalGroup(pnOldLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
		    .addGroup(pnOldLayout.createSequentialGroup().addContainerGap()
			    .addGroup(pnOldLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
				    .addComponent(lblMaNVOld).addComponent(txtMaNVOld,
					    javax.swing.GroupLayout.PREFERRED_SIZE, 26,
					    javax.swing.GroupLayout.PREFERRED_SIZE))
			    .addGap(5, 5, 5)
			    .addGroup(pnOldLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
				    .addComponent(lblTenNVOld).addComponent(txtTenNVOld,
					    javax.swing.GroupLayout.PREFERRED_SIZE,
					    javax.swing.GroupLayout.DEFAULT_SIZE,
					    javax.swing.GroupLayout.PREFERRED_SIZE))
			    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
			    .addGroup(pnOldLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
				    .addComponent(pnGioiTinhOld, javax.swing.GroupLayout.DEFAULT_SIZE,
					    javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
				    .addComponent(pnNgaySinhOld, javax.swing.GroupLayout.PREFERRED_SIZE,
					    javax.swing.GroupLayout.DEFAULT_SIZE,
					    javax.swing.GroupLayout.PREFERRED_SIZE))
			    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
			    .addGroup(pnOldLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
				    .addGroup(pnOldLayout.createSequentialGroup().addComponent(lblDiaChiOld)
					    .addGap(12, 12, 12).addComponent(lblEmailOld).addGap(12, 12, 12)
					    .addComponent(lblSDTOld))
				    .addGroup(pnOldLayout.createSequentialGroup()
					    .addComponent(txtDiaChiOld, javax.swing.GroupLayout.PREFERRED_SIZE,
						    javax.swing.GroupLayout.DEFAULT_SIZE,
						    javax.swing.GroupLayout.PREFERRED_SIZE)
					    .addGap(6, 6, 6)
					    .addComponent(txtEmailOld, javax.swing.GroupLayout.PREFERRED_SIZE,
						    javax.swing.GroupLayout.DEFAULT_SIZE,
						    javax.swing.GroupLayout.PREFERRED_SIZE)
					    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
					    .addComponent(txtSDTOld, javax.swing.GroupLayout.PREFERRED_SIZE, 25,
						    javax.swing.GroupLayout.PREFERRED_SIZE)))
			    .addGap(9, 9, 9)
			    .addGroup(pnOldLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
				    .addComponent(lblChucVuOld).addComponent(txtChucVuOld,
					    javax.swing.GroupLayout.PREFERRED_SIZE,
					    javax.swing.GroupLayout.DEFAULT_SIZE,
					    javax.swing.GroupLayout.PREFERRED_SIZE))
			    .addContainerGap(9, Short.MAX_VALUE)));

	    javax.swing.GroupLayout pnActionLayout = new javax.swing.GroupLayout(pnAction);
	    pnAction.setLayout(pnActionLayout);
	    pnActionLayout
		    .setHorizontalGroup(pnActionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
			    .addGroup(pnActionLayout.createSequentialGroup().addContainerGap()
				    .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 315,
					    javax.swing.GroupLayout.PREFERRED_SIZE)
				    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
				    .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 104,
					    javax.swing.GroupLayout.PREFERRED_SIZE)
				    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

	    pnActionLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL,
		    new java.awt.Component[] { btnCancel, btnUpdate });

	    pnActionLayout.setVerticalGroup(pnActionLayout
		    .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
		    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnActionLayout.createSequentialGroup()
			    .addContainerGap()
			    .addGroup(pnActionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
				    .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 31,
					    javax.swing.GroupLayout.PREFERRED_SIZE)
				    .addComponent(btnCancel))
			    .addContainerGap()));

	    pnActionLayout.linkSize(javax.swing.SwingConstants.VERTICAL,
		    new java.awt.Component[] { btnCancel, btnUpdate });

	    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
	    getContentPane().setLayout(layout);
	    layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(
		    javax.swing.GroupLayout.Alignment.TRAILING,
		    layout.createSequentialGroup().addContainerGap()
			    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
				    .addComponent(pnAction, javax.swing.GroupLayout.DEFAULT_SIZE,
					    javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
				    .addGroup(layout.createSequentialGroup()
					    .addComponent(pnOld, javax.swing.GroupLayout.PREFERRED_SIZE, 613,
						    javax.swing.GroupLayout.PREFERRED_SIZE)
					    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
						    javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					    .addComponent(pnNew, javax.swing.GroupLayout.PREFERRED_SIZE, 613,
						    javax.swing.GroupLayout.PREFERRED_SIZE)))
			    .addContainerGap()));
	    layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
		    .addGroup(layout.createSequentialGroup().addContainerGap()
			    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
				    .addComponent(pnOld, javax.swing.GroupLayout.DEFAULT_SIZE,
					    javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
				    .addComponent(pnNew, javax.swing.GroupLayout.DEFAULT_SIZE,
					    javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
			    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
			    .addComponent(pnAction, javax.swing.GroupLayout.PREFERRED_SIZE,
				    javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
			    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
	}

	private void event(String data[]) {
	    // TODO Auto-generated method stub
	    txtMaNVOld.setText(data[0]);
	    txtMaNVNew.setText(data[0]);
	    txtTenNVOld.setText(data[1]);
	    if (data[2].equalsIgnoreCase("Nam")) {
		radNamOld.setSelected(true);
		radNuOld.setSelected(false);
	    } else {
		radNamOld.setSelected(false);
		radNuOld.setSelected(true);
	    }
	    txtNgaySinhOld.setText(data[3]);
	    txtDiaChiOld.setText(data[4]);
	    txtEmailOld.setText(data[5]);
	    txtSDTOld.setText(data[6]);
	    txtChucVuOld.setText(data[7]);

	    this.btnUpdate.addActionListener(this);
	    this.btnCancel.addActionListener(this);
	    this.txtEmailNew.addFocusListener(this);
	    this.txtEmailNew.addKeyListener(this);
	    this.txtSDTNew.addFocusListener(this);
	    this.txtSDTNew.addKeyListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
	    // TODO Auto-generated method stub
	    Object o = e.getSource();
	    if (o.equals(btnCancel))
		this.dispose();
	    if (o.equals(btnUpdate)) {
		if (txtEmailNew.getText().trim().matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$")
			&& txtSDTNew.getText().trim().matches("^(03|05|07|08|09)+([0-9]{8})$")) {
		    boolean gender = true;
		    if (radNamNew.isSelected())
			gender = false;
		    if (radNuNew.isSelected())
			gender = true;

		    // Lấy ngày tháng được chọn từ JDatePicker
		    Calendar selectedDate = (Calendar) dpkNgaySinhNew.getModel().getValue();

		    LocalDate localDate = LocalDate.of(selectedDate.get(Calendar.YEAR),
			    selectedDate.get(Calendar.MONTH) + 1, selectedDate.get(Calendar.DAY_OF_MONTH));

		    NhanVien updateNV = new NhanVien(txtMaNVNew.getText(), txtTenNVNew.getText(), gender, localDate,
			    txtDiaChiNew.getText(), txtEmailNew.getText(), txtSDTNew.getText(),
			    cbxChucVuNew.getSelectedItem().toString());

		    if (DAO_NhanVien.suaNhanVien(updateNV)) {
			JOptionPane.showMessageDialog(null, "Cap Nhat Thanh Cong");
			tblModel.setRowCount(0);
			loadData();
		    } else {
			JOptionPane.showMessageDialog(null, "Cap Nhat That Bai");
			this.dispose();
		    }
		} else {
		    JOptionPane.showMessageDialog(null, "Kiem tra lai thong tin nhap vao");
		}
	    }
	}

	@Override
	public void keyTyped(KeyEvent e) {
	    // TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
	    // TODO Auto-generated method stub

	}

	@Override
	public void keyReleased(KeyEvent e) {
	    // TODO Auto-generated method stub
	    Object o = e.getSource();

	    if (o.equals(txtEmailNew)) {
		String regex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$"; // Regex kiểm tra Email
		String email = txtEmailNew.getText().trim();
		if (!email.matches(regex)) {
		    // Nếu dữ liệu nhập vào không đúng, đổi màu viền sang đỏ
		    txtEmailNew.setBorder(BorderFactory.createLineBorder(Color.RED));
		} else {
		    // Nếu dữ liệu nhập vào đúng, đổi màu viền sang xanh
		    txtEmailNew.setBorder(BorderFactory.createLineBorder(Color.GREEN));
		}
	    }

	    if (o.equals(txtSDTNew)) {
		String regex = "^(03|05|07|08|09)+([0-9]{8})$"; // Regex kiểm tra số điện thoại
		String sdt = txtSDTNew.getText().trim(); // Lấy giá trị của txtSDT và loại bỏ khoảng trắng ở đầu và cuối
							 // chuỗi
		if (!sdt.matches(regex)) {
		    // Nếu dữ liệu nhập vào không đúng, đổi màu viền sang đỏ
		    txtSDTNew.setBorder(BorderFactory.createLineBorder(Color.RED));
		} else {
		    // Nếu dữ liệu nhập vào đúng, đổi màu viền sang xanh
		    txtSDTNew.setBorder(BorderFactory.createLineBorder(Color.GREEN));
		}
	    }
	}

	@Override
	public void focusGained(FocusEvent e) {
	    // TODO Auto-generated method stub

	}

	@Override
	public void focusLost(FocusEvent e) {
	    // TODO Auto-generated method stub
	    Object o = e.getSource();

	    if (o.equals(txtEmailNew)) {
		String regex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$"; // Regex kiểm tra Email
		String email = txtEmailNew.getText().trim();
		if (!email.matches(regex)) {
		    // Nếu dữ liệu nhập vào không đúng, đổi màu viền sang đỏ
		    txtEmailNew.setBorder(BorderFactory.createLineBorder(Color.RED));
		} else {
		    // Nếu dữ liệu nhập vào đúng, đổi màu viền sang xanh
		    txtEmailNew.setBorder(BorderFactory.createLineBorder(Color.GREEN));
		}
	    }

	    if (o.equals(txtSDTNew)) {
		String regex = "^(03|05|07|08|09)+([0-9]{8})$"; // Regex kiểm tra số điện thoại
		String sdt = txtSDTNew.getText().trim(); // Lấy giá trị của txtSDT và loại bỏ khoảng trắng ở đầu và cuối
							 // chuỗi
		if (!sdt.matches(regex)) {
		    // Nếu dữ liệu nhập vào không đúng, đổi màu viền sang đỏ
		    txtSDTNew.setBorder(BorderFactory.createLineBorder(Color.RED));
		} else {
		    // Nếu dữ liệu nhập vào đúng, đổi màu viền sang xanh
		    txtSDTNew.setBorder(BorderFactory.createLineBorder(Color.GREEN));
		}
	    }
	}

    }
}
