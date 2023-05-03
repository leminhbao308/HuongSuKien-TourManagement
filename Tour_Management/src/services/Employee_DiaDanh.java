package services;

import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

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

import DAO.DAO_DiaDanh;
import DAO.DAO_NhanVien;
import DAO.DAO_TaiKhoan;
import entity.DiaDanh;
import utils.LoadSave;
import utils.constants.ColorConstant;

public class Employee_DiaDanh extends JPanel implements ActionListener {

    /**
     * 
     */
    private static final long serialVersionUID = 1791886657472259552L;
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
    private javax.swing.JTable tblDiaDanh;
    private javax.swing.table.DefaultTableModel tblModel;
    private javax.swing.JTabbedPane tpnSearch;
    private javax.swing.JTextField txtSearchMa;
    private javax.swing.JTextField txtSearchTen;

    public Employee_DiaDanh() {
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
	    String[] cols = new DiaDanh().getTitle().split(";");
	    tblModel = new javax.swing.table.DefaultTableModel(cols, 0);
	    tblDiaDanh = new javax.swing.JTable(tblModel);
	}
	pnAction = new javax.swing.JPanel();
	btnInfo = new javax.swing.JButton();
	btnAdd = new javax.swing.JButton();
	btnDelete = new javax.swing.JButton();
	btnModify = new javax.swing.JButton();
    }

    private void style() {
	// TODO Auto-generated method stub
	lblSearchMa.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
	lblSearchMa.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
	lblSearchMa.setText("Ma Dia Danh Can Tim:");

	txtSearchMa.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

	btnSearchMa.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
	btnSearchMa.setText("Tim");

	lblSearchTen.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
	lblSearchTen.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
	lblSearchTen.setText("Ten Dia Danh Can Tim:");

	txtSearchTen.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

	btnSearchTen.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
	btnSearchTen.setText("Tim");

	pnData.setBorder(javax.swing.BorderFactory.createTitledBorder(
		javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED),
		"Danh Sach Dia Danh", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,
		javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 14))); // NOI18N

	lblFilter.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
	lblFilter.setText("Loc Theo:");

	cbxFilter.setModel(
		new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

	scrData.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
	scrData.setViewportView(tblDiaDanh);

	pnAction.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Chon Tac Vu",
		javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION,
		new java.awt.Font("Segoe UI", 0, 14))); // NOI18N

	btnInfo.setText("Xem Thong Tin");
	btnInfo.setToolTipText("Xem thong tin Dia Danh (Ctrl + I)");
	btnInfo.setEnabled(false);

	btnAdd.setText("Them Dia Danh");
	btnAdd.setToolTipText("Them Dia Danh moi (Ctrl + T)");

	btnDelete.setText("Xoa Dia Danh");
	btnDelete.setToolTipText("Xoa Dia Danh duoc chon (Ctrl + D)");
	btnDelete.setEnabled(false);

	btnModify.setText("Sua Dia Danh");
	btnModify.setToolTipText("Sua thong tin Dia Danh duoc chon (Ctrl + M)");
	btnModify.setEnabled(false);

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
	this.tblDiaDanh.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

	    @Override
	    public void valueChanged(ListSelectionEvent e) {
		// TODO Auto-generated method stub
		// Kiểm tra xem có dòng nào được chọn hay không
		boolean hasSelection = !tblDiaDanh.getSelectionModel().isSelectionEmpty();

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
		    int selectedRow = tblDiaDanh.getSelectedRow();

		    // Lấy số cột của bảng
		    int columnsCount = tblDiaDanh.getColumnCount();

		    // Tạo một mảng String để chứa dữ liệu của hàng đang được chọn
		    String[] data = new String[columnsCount];

		    // Duyệt qua các cột của hàng đang được chọn và lưu giá trị vào mảng data
		    for (int i = 0; i < columnsCount; i++) {
			data[i] = tblDiaDanh.getValueAt(selectedRow, i).toString();
		    }

		    new FrameInfoDiaDanh(data).setVisible(true);
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
		    new FrameAddDiaDanh().setVisible(true);
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
			int selectedRow = tblDiaDanh.getSelectedRow();
			String data = tblDiaDanh.getValueAt(selectedRow, 0).toString();

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
		    int selectedRow = tblDiaDanh.getSelectedRow();

		    // Lấy số cột của bảng
		    int columnsCount = tblDiaDanh.getColumnCount();

		    // Tạo một mảng String để chứa dữ liệu của hàng đang được chọn
		    String[] data = new String[columnsCount];

		    // Duyệt qua các cột của hàng đang được chọn và lưu giá trị vào mảng data
		    for (int i = 0; i < columnsCount; i++) {
			data[i] = tblDiaDanh.getValueAt(selectedRow, i).toString();
		    }
		    new FrameModifyDiaDanh(data).setVisible(true);
		}
	    }
	});
    }

    private void loadData() {
	// TODO Auto-generated method stub
	ArrayList<DiaDanh> dsdd = DAO_DiaDanh.getAllDiaDanh();
	for (DiaDanh diaDanh : dsdd) {
	    String[] data = diaDanh.toString().split(";");

	    // Create a font with a larger size
	    Font largerFont = tblDiaDanh.getFont().deriveFont(14f);

	    // Set the cell renderer for all columns
	    for (int i = 0; i < tblDiaDanh.getColumnModel().getColumnCount(); i++) {
		tblDiaDanh.getColumnModel().getColumn(i).setCellRenderer(new DefaultTableCellRenderer() {
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
	    int selectedRow = tblDiaDanh.getSelectedRow();

	    // Lấy số cột của bảng
	    int columnsCount = tblDiaDanh.getColumnCount();

	    // Tạo một mảng String để chứa dữ liệu của hàng đang được chọn
	    String[] data = new String[columnsCount];

	    // Duyệt qua các cột của hàng đang được chọn và lưu giá trị vào mảng data
	    for (int i = 0; i < columnsCount; i++) {
		data[i] = tblDiaDanh.getValueAt(selectedRow, i).toString();
	    }
	    new FrameInfoDiaDanh(data).setVisible(true);
	}
	if (o.equals(btnAdd)) {
	    new FrameAddDiaDanh().setVisible(true);
	}
	if (o.equals(btnDelete)) {
	    int dialogResult = JOptionPane.showConfirmDialog(null, "Bạn có muốn xóa dữ liệu không?");
	    if (dialogResult == JOptionPane.YES_OPTION) {
		// Lấy chỉ số của hàng đang được chọn
		int selectedRow = tblDiaDanh.getSelectedRow();
		String data = tblDiaDanh.getValueAt(selectedRow, 0).toString();

		DAO_NhanVien.xoaNhanVien(data);
		DAO_TaiKhoan.xoaTaiKhoan(data);
		tblModel.setRowCount(0);
		loadData();
	    }
	}
	if (o.equals(btnModify)) {
	    // Lấy chỉ số của hàng đang được chọn
	    int selectedRow = tblDiaDanh.getSelectedRow();

	    // Lấy số cột của bảng
	    int columnsCount = tblDiaDanh.getColumnCount();

	    // Tạo một mảng String để chứa dữ liệu của hàng đang được chọn
	    String[] data = new String[columnsCount];

	    // Duyệt qua các cột của hàng đang được chọn và lưu giá trị vào mảng data
	    for (int i = 0; i < columnsCount; i++) {
		data[i] = tblDiaDanh.getValueAt(selectedRow, i).toString();
	    }
	    new FrameModifyDiaDanh(data).setVisible(true);
	}
    }

    private class FrameInfoDiaDanh extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1776722057797549712L;

	private FrameInfoDiaDanh(String[] data) {

	}
    }

    private class FrameAddDiaDanh extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7370212122136434241L;
	private javax.swing.JComboBox<String> cbxTinhThanh;
	private javax.swing.JButton btnAdd;
	private javax.swing.JButton btnCancel;
	private javax.swing.JPanel pnAction;
	private javax.swing.JLabel lblMaDiaDanh;
	private javax.swing.JLabel lblTenDiaDanh;
	private javax.swing.JLabel lblTinhThanh;
	private javax.swing.JPanel pnInfo;
	private javax.swing.JTextField txtMaDiaDanh;
	private javax.swing.JTextField txtTenDiaDanh;

	private FrameAddDiaDanh() {
	    this.setTitle("SE Tourist - Them Dia Danh");
	    this.setIconImage(LoadSave.GetSpriteAtlas(LoadSave.LOGO_ICON));
	    this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	    this.setResizable(false);
	    this.setLocationRelativeTo(null);
	    this.setMaximumSize(new java.awt.Dimension(450, 390));
	    this.setMinimumSize(new java.awt.Dimension(450, 390));

	    this.init();
	    this.style();
	    this.preset();
	    this.event();
	}

	private void init() {
	    // TODO Auto-generated method stub
	    pnInfo = new javax.swing.JPanel();
	    lblMaDiaDanh = new javax.swing.JLabel();
	    txtMaDiaDanh = new javax.swing.JTextField();
	    lblTenDiaDanh = new javax.swing.JLabel();
	    txtTenDiaDanh = new javax.swing.JTextField();
	    lblTinhThanh = new javax.swing.JLabel();
	    cbxTinhThanh = new javax.swing.JComboBox<>();
	    pnAction = new javax.swing.JPanel();
	    btnAdd = new javax.swing.JButton();
	    btnCancel = new javax.swing.JButton();
	}

	private void style() {
	    // TODO Auto-generated method stub
	    pnInfo.setBorder(javax.swing.BorderFactory.createTitledBorder(
		    javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED),
		    "Thong Tin Dia Danh", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,
		    javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 14))); // NOI18N

	    lblMaDiaDanh.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
	    lblMaDiaDanh.setText("Ma Dia Danh:");

	    txtMaDiaDanh.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

	    lblTenDiaDanh.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
	    lblTenDiaDanh.setText("Ten Dia Danh:");

	    txtTenDiaDanh.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

	    lblTinhThanh.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
	    lblTinhThanh.setText("Tinh Thanh:");

	    cbxTinhThanh.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
	    cbxTinhThanh.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "An Giang", "Bà Rịa – Vũng Tàu",
		    "Bắc Giang", "Bắc Kạn", "Bạc Liêu", "Bắc Ninh", "Bến Tre", "Bình Định", "Bình Dương", "Bình Phước",
		    "Bình Thuận", "Cà Mau", "Cần Thơ", "Cao Bằng", "Đà Nẵng", "Đắk Lắk", "Đắk Nông", "Điện Biên",
		    "Đồng Nai", "Đồng Tháp", "Gia Lai", "Hà Giang", "Hà Nam", "Hà Nội", "Hà Tĩnh", "Hải Dương",
		    "Hải Phòng", "Hậu Giang", "Hòa Bình", "Hưng Yên", "Khánh Hòa", "Kiên Giang", "Kon Tum", "Lai Châu",
		    "Lâm Đồng", "Lạng Sơn", "Lào Cai", "Long An", "Nam Định", "Nghệ An", "Ninh Bình", "Ninh Thuận",
		    "Phú Thọ", "Phú Yên", "Quảng Bình", "Quảng Nam", "Quảng Ngãi", "Quảng Ninh", "Quảng Trị",
		    "Sóc Trăng", "Sơn La", "Tây Ninh", "Thái Bình", "Thái Nguyên", "Thanh Hóa", "Thừa Thiên Huế",
		    "Tiền Giang", "Thành phố Hồ Chí Minh", "Trà Vinh", "Tuyên Quang", "Vĩnh Long", "Vĩnh Phúc",
		    "Yên Bái" }));
	    cbxTinhThanh.setSelectedIndex(-1);
	    cbxTinhThanh.setToolTipText("Chon Tinh Thanh");
	    cbxTinhThanh.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

	    pnAction.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Chon Tac Vu",
		    javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,
		    javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 14))); // NOI18N

	    btnAdd.setBackground(new java.awt.Color(0, 255, 0));
	    btnAdd.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
	    btnAdd.setForeground(new java.awt.Color(255, 255, 255));
	    btnAdd.setText("Them Dia Danh");
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
				    .addComponent(txtMaDiaDanh).addComponent(txtTenDiaDanh)
				    .addComponent(lblMaDiaDanh, javax.swing.GroupLayout.PREFERRED_SIZE, 121,
					    javax.swing.GroupLayout.PREFERRED_SIZE)
				    .addComponent(lblTenDiaDanh).addComponent(lblTinhThanh).addComponent(cbxTinhThanh,
					    0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
			    .addContainerGap()));

	    pnInfoLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL,
		    new java.awt.Component[] { lblMaDiaDanh, lblTenDiaDanh, lblTinhThanh });

	    pnInfoLayout.setVerticalGroup(pnInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
		    .addGroup(pnInfoLayout.createSequentialGroup().addContainerGap().addComponent(lblMaDiaDanh)
			    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
			    .addComponent(txtMaDiaDanh, javax.swing.GroupLayout.PREFERRED_SIZE,
				    javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
			    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
			    .addComponent(lblTenDiaDanh)
			    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
			    .addComponent(txtTenDiaDanh, javax.swing.GroupLayout.PREFERRED_SIZE,
				    javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
			    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
			    .addComponent(lblTinhThanh)
			    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
				    javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
			    .addComponent(cbxTinhThanh, javax.swing.GroupLayout.PREFERRED_SIZE,
				    javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
			    .addContainerGap()));

	    pnInfoLayout.linkSize(javax.swing.SwingConstants.VERTICAL,
		    new java.awt.Component[] { lblMaDiaDanh, lblTenDiaDanh, lblTinhThanh });

	    pnInfoLayout.linkSize(javax.swing.SwingConstants.VERTICAL,
		    new java.awt.Component[] { cbxTinhThanh, txtMaDiaDanh, txtTenDiaDanh });

	    javax.swing.GroupLayout pnActionLayout = new javax.swing.GroupLayout(pnAction);
	    pnAction.setLayout(pnActionLayout);
	    pnActionLayout
		    .setHorizontalGroup(pnActionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
			    .addGroup(pnActionLayout.createSequentialGroup().addContainerGap()
				    .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 154,
					    javax.swing.GroupLayout.PREFERRED_SIZE)
				    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
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
		    .addGroup(layout.createSequentialGroup().addContainerGap()
			    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				    .addComponent(pnInfo, javax.swing.GroupLayout.DEFAULT_SIZE,
					    javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
				    .addComponent(pnAction, javax.swing.GroupLayout.Alignment.TRAILING,
					    javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
					    Short.MAX_VALUE))
			    .addContainerGap()));
	    layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
		    .addGroup(layout.createSequentialGroup().addContainerGap()
			    .addComponent(pnInfo, javax.swing.GroupLayout.PREFERRED_SIZE,
				    javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
			    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
			    .addComponent(pnAction, javax.swing.GroupLayout.DEFAULT_SIZE,
				    javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
	}

	private void event() {
	    // TODO Auto-generated method stub
	    this.btnAdd.addActionListener(this);
	    this.btnCancel.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
	    // TODO Auto-generated method stub
	    Object o = e.getSource();

	    if (o.equals(btnCancel)) {
		this.dispose();
	    }

	    if (o.equals(btnAdd)) {
		if (cbxTinhThanh.getSelectedIndex() == -1) {
		    JOptionPane.showInternalMessageDialog(null, "Hay Chon Tinh Thanh", "Thieu Thong Tin",
			    JOptionPane.ERROR_MESSAGE);
		} else {
		    DiaDanh newDD = new DiaDanh(txtMaDiaDanh.getText(), txtTenDiaDanh.getText(),
			    cbxTinhThanh.getSelectedItem().toString());
		    if (DAO_DiaDanh.themDiaDanh(newDD)) {
			JOptionPane.showInternalMessageDialog(null, "Them Thanh Cong");
			tblModel.setRowCount(0);
			loadData();
			this.dispose();
		    } else
			JOptionPane.showInternalMessageDialog(null, "Them That Bai");
		}
	    }
	}
    }

    private class FrameModifyDiaDanh extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7924417023540325361L;

	private FrameModifyDiaDanh(String[] data) {

	}
    }

}
