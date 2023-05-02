package services;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.BorderFactory;
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

import DAO.DAO_KhachHang;
import entity.KhachHang;
import utils.LoadSave;
import utils.constants.ColorConstant;

public class Employee_KhachHang extends JPanel implements ActionListener {

    /**
     * 
     */
    private static final long serialVersionUID = -2776630998434590655L;
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
    private javax.swing.JTable tblKhachHang;
    private javax.swing.table.DefaultTableModel tblModel;
    private javax.swing.JTabbedPane tpnSearch;
    private javax.swing.JTextField txtSearchMa;
    private javax.swing.JTextField txtSearchTen;

    public Employee_KhachHang() {
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
	    String[] cols = new KhachHang().getTitle().split(";");
	    tblModel = new javax.swing.table.DefaultTableModel(cols, 0);
	    tblKhachHang = new javax.swing.JTable(tblModel);
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
	lblSearchMa.setText("Ma Khach Hang Can Tim:");

	txtSearchMa.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

	btnSearchMa.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
	btnSearchMa.setText("Tim");

	lblSearchTen.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
	lblSearchTen.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
	lblSearchTen.setText("Ten Khach Hang Can Tim:");

	txtSearchTen.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

	btnSearchTen.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
	btnSearchTen.setText("Tim");

	pnData.setBorder(javax.swing.BorderFactory.createTitledBorder(
		javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED),
		"Danh Sach Khach Hang", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,
		javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 14))); // NOI18N

	lblFilter.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
	lblFilter.setText("Loc Theo:");

	cbxFilter.setModel(
		new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

	scrData.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
	scrData.setViewportView(tblKhachHang);

	pnAction.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Chon Tac Vu",
		javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION,
		new java.awt.Font("Segoe UI", 0, 14))); // NOI18N

	btnInfo.setText("Xem Thong Tin");
	btnInfo.setEnabled(false);
	btnInfo.setToolTipText("Xem Thong Tin Khach Hang (Ctrl + I)");

	btnAdd.setText("Them Khach Hang");
	btnAdd.setToolTipText("Them Khach Hang Moi (Ctrl + T)");

	btnDelete.setText("Xoa Khach Hang");
	btnDelete.setEnabled(false);
	btnDelete.setToolTipText("Xoa Khach Hang Duoc Chon (Ctrl + D)");

	btnModify.setText("Sua Thong Tin");
	btnModify.setEnabled(false);
	btnModify.setToolTipText("Sua Thong Tin Khach Hang Duoc Chon (Ctrl + M)");
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
	this.tblKhachHang.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

	    @Override
	    public void valueChanged(ListSelectionEvent e) {
		// TODO Auto-generated method stub
		// Kiểm tra xem có dòng nào được chọn hay không
		boolean hasSelection = !tblKhachHang.getSelectionModel().isSelectionEmpty();

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
		    int selectedRow = tblKhachHang.getSelectedRow();

		    // Lấy số cột của bảng
		    int columnsCount = tblKhachHang.getColumnCount();

		    // Tạo một mảng String để chứa dữ liệu của hàng đang được chọn
		    String[] data = new String[columnsCount];

		    // Duyệt qua các cột của hàng đang được chọn và lưu giá trị vào mảng data
		    for (int i = 0; i < columnsCount; i++) {
			data[i] = tblKhachHang.getValueAt(selectedRow, i).toString();
		    }

		    new FrameInfoKhachHang(data).setVisible(true);
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
		    new FrameAddKhachHang().setVisible(true);
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
			int selectedRow = tblKhachHang.getSelectedRow();
			String data = tblKhachHang.getValueAt(selectedRow, 0).toString();

			DAO_KhachHang.xoaKhachHang(data);
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
		    int selectedRow = tblKhachHang.getSelectedRow();

		    // Lấy số cột của bảng
		    int columnsCount = tblKhachHang.getColumnCount();

		    // Tạo một mảng String để chứa dữ liệu của hàng đang được chọn
		    String[] data = new String[columnsCount];

		    // Duyệt qua các cột của hàng đang được chọn và lưu giá trị vào mảng data
		    for (int i = 0; i < columnsCount; i++) {
			data[i] = tblKhachHang.getValueAt(selectedRow, i).toString();
		    }
		    new FrameModifyKhachHang(data).setVisible(true);
		}
	    }
	});
    }

    private void loadData() {
	ArrayList<KhachHang> dskh = DAO_KhachHang.getAllKhachHang();
	for (KhachHang khachHang : dskh) {
	    String[] data = khachHang.toString().split(";");

	    if (data[3].equalsIgnoreCase("true"))
		data[3] = "Nu";
	    else
		data[3] = "Nam";
	    // Create a font with a larger size
	    Font largerFont = tblKhachHang.getFont().deriveFont(14f);

	    // Set the cell renderer for all columns
	    for (int i = 0; i < tblKhachHang.getColumnModel().getColumnCount(); i++) {
		tblKhachHang.getColumnModel().getColumn(i).setCellRenderer(new DefaultTableCellRenderer() {
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
	    int selectedRow = tblKhachHang.getSelectedRow();

	    // Lấy số cột của bảng
	    int columnsCount = tblKhachHang.getColumnCount();

	    // Tạo một mảng String để chứa dữ liệu của hàng đang được chọn
	    String[] data = new String[columnsCount];

	    // Duyệt qua các cột của hàng đang được chọn và lưu giá trị vào mảng data
	    for (int i = 0; i < columnsCount; i++) {
		data[i] = tblKhachHang.getValueAt(selectedRow, i).toString();
	    }
	    new FrameInfoKhachHang(data).setVisible(true);
	}
	if (o.equals(btnAdd)) {
	    new FrameAddKhachHang().setVisible(true);
	}
	if (o.equals(btnDelete)) {
	    int dialogResult = JOptionPane.showConfirmDialog(null, "Bạn có muốn xóa dữ liệu không?");
	    if (dialogResult == JOptionPane.YES_OPTION) {
		// Lấy chỉ số của hàng đang được chọn
		int selectedRow = tblKhachHang.getSelectedRow();
		String data = tblKhachHang.getValueAt(selectedRow, 0).toString();

		DAO_KhachHang.xoaKhachHang(data);
		tblModel.setRowCount(0);
		loadData();
	    }
	}
	if (o.equals(btnModify)) {
	    // Lấy chỉ số của hàng đang được chọn
	    int selectedRow = tblKhachHang.getSelectedRow();

	    // Lấy số cột của bảng
	    int columnsCount = tblKhachHang.getColumnCount();

	    // Tạo một mảng String để chứa dữ liệu của hàng đang được chọn
	    String[] data = new String[columnsCount];

	    // Duyệt qua các cột của hàng đang được chọn và lưu giá trị vào mảng data
	    for (int i = 0; i < columnsCount; i++) {
		data[i] = tblKhachHang.getValueAt(selectedRow, i).toString();
	    }
	    new FrameModifyKhachHang(data).setVisible(true);
	}
    }

    private class FrameInfoKhachHang extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3622233922413844632L;
	private javax.swing.JLabel lblCCCD;
	private javax.swing.JLabel lblEmail;
	private javax.swing.JLabel lblMaKH;
	private javax.swing.JLabel lblSDT;
	private javax.swing.JLabel lblTenKH;
	private javax.swing.JPanel pnGioiTinh;
	private javax.swing.JPanel pnInfo;
	private javax.swing.JPanel pnNgaySinh;
	private javax.swing.JRadioButton radNam;
	private javax.swing.JRadioButton radNu;
	private javax.swing.JTextField txtCCCD;
	private javax.swing.JTextField txtEmail;
	private javax.swing.JTextField txtMaKH;
	private javax.swing.JTextField txtNgaySinh;
	private javax.swing.JTextField txtSDT;
	private javax.swing.JTextField txtTenKH;

	private FrameInfoKhachHang(String[] data) {
	    this.setTitle("SE Tourist - Thong Tin Khach Hang");
	    this.setIconImage(LoadSave.GetSpriteAtlas(LoadSave.LOGO_ICON));
	    this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	    this.setResizable(false);
	    this.setLocationRelativeTo(null);
	    this.setMaximumSize(new java.awt.Dimension(700, 400));
	    this.setMinimumSize(new java.awt.Dimension(700, 400));

	    this.init();
	    this.style();
	    this.preset();
	    this.event(data);
	}

	private void init() {
	    // TODO Auto-generated method stub
	    pnInfo = new javax.swing.JPanel();
	    lblMaKH = new javax.swing.JLabel();
	    txtMaKH = new javax.swing.JTextField();
	    txtCCCD = new javax.swing.JTextField();
	    lblCCCD = new javax.swing.JLabel();
	    lblTenKH = new javax.swing.JLabel();
	    txtTenKH = new javax.swing.JTextField();
	    pnGioiTinh = new javax.swing.JPanel();
	    radNam = new javax.swing.JRadioButton();
	    radNu = new javax.swing.JRadioButton();
	    pnNgaySinh = new javax.swing.JPanel();
	    txtNgaySinh = new javax.swing.JTextField();
	    lblEmail = new javax.swing.JLabel();
	    txtEmail = new javax.swing.JTextField();
	    lblSDT = new javax.swing.JLabel();
	    txtSDT = new javax.swing.JTextField();
	}

	private void style() {
	    // TODO Auto-generated method stub
	    pnInfo.setBorder(javax.swing.BorderFactory.createTitledBorder(
		    javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED),
		    "Thong Tin Khach Hang", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,
		    javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 14))); // NOI18N

	    lblMaKH.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
	    lblMaKH.setText("Ma Khach Hang:");

	    txtMaKH.setEditable(false);
	    txtMaKH.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

	    txtCCCD.setEditable(false);
	    txtCCCD.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

	    lblCCCD.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
	    lblCCCD.setText("So CCCD / HC:");

	    lblTenKH.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
	    lblTenKH.setText("Ten Khach Hang:");

	    txtTenKH.setEditable(false);
	    txtTenKH.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

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
	    txtNgaySinh.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

	    lblEmail.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
	    lblEmail.setText("Email:");

	    txtEmail.setEditable(false);
	    txtEmail.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

	    lblSDT.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
	    lblSDT.setText("So Dien Thoai:");

	    txtSDT.setEditable(false);
	    txtSDT.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

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
		    .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(pnNgaySinhLayout
			    .createSequentialGroup().addContainerGap().addComponent(txtNgaySinh).addContainerGap()));
	    pnNgaySinhLayout.setVerticalGroup(
		    pnNgaySinhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(
			    javax.swing.GroupLayout.Alignment.TRAILING,
			    pnNgaySinhLayout.createSequentialGroup().addComponent(txtNgaySinh,
				    javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
				    .addContainerGap()));

	    javax.swing.GroupLayout pnInfoLayout = new javax.swing.GroupLayout(pnInfo);
	    pnInfo.setLayout(pnInfoLayout);
	    pnInfoLayout.setHorizontalGroup(pnInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
		    .addGroup(pnInfoLayout.createSequentialGroup().addContainerGap().addGroup(pnInfoLayout
			    .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
			    .addGroup(pnInfoLayout.createSequentialGroup()
				    .addComponent(lblMaKH, javax.swing.GroupLayout.PREFERRED_SIZE, 150,
					    javax.swing.GroupLayout.PREFERRED_SIZE)
				    .addGap(18, 18, 18)
				    .addComponent(txtMaKH, javax.swing.GroupLayout.DEFAULT_SIZE, 368, Short.MAX_VALUE))
			    .addGroup(pnInfoLayout.createSequentialGroup()
				    .addComponent(lblCCCD, javax.swing.GroupLayout.PREFERRED_SIZE, 150,
					    javax.swing.GroupLayout.PREFERRED_SIZE)
				    .addGap(18, 18, 18).addComponent(txtCCCD))
			    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
				    pnInfoLayout.createSequentialGroup()
					    .addComponent(lblTenKH, javax.swing.GroupLayout.PREFERRED_SIZE, 150,
						    javax.swing.GroupLayout.PREFERRED_SIZE)
					    .addGap(18, 18, 18).addComponent(txtTenKH))
			    .addGroup(pnInfoLayout.createSequentialGroup()
				    .addComponent(pnGioiTinh, javax.swing.GroupLayout.PREFERRED_SIZE,
					    javax.swing.GroupLayout.DEFAULT_SIZE,
					    javax.swing.GroupLayout.PREFERRED_SIZE)
				    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
				    .addComponent(pnNgaySinh, javax.swing.GroupLayout.DEFAULT_SIZE,
					    javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
			    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
				    pnInfoLayout.createSequentialGroup().addGroup(pnInfoLayout
					    .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
					    .addComponent(lblEmail, javax.swing.GroupLayout.DEFAULT_SIZE, 150,
						    Short.MAX_VALUE)
					    .addComponent(lblSDT, javax.swing.GroupLayout.DEFAULT_SIZE,
						    javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					    .addGap(18, 18, 18)
					    .addGroup(pnInfoLayout
						    .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						    .addComponent(txtSDT).addComponent(txtEmail))))
			    .addContainerGap()));
	    pnInfoLayout.setVerticalGroup(pnInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
		    .addGroup(pnInfoLayout.createSequentialGroup().addContainerGap()
			    .addGroup(pnInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
				    .addComponent(lblMaKH).addComponent(txtMaKH, javax.swing.GroupLayout.PREFERRED_SIZE,
					    javax.swing.GroupLayout.DEFAULT_SIZE,
					    javax.swing.GroupLayout.PREFERRED_SIZE))
			    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
			    .addGroup(pnInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
				    .addComponent(lblCCCD).addComponent(txtCCCD, javax.swing.GroupLayout.PREFERRED_SIZE,
					    javax.swing.GroupLayout.DEFAULT_SIZE,
					    javax.swing.GroupLayout.PREFERRED_SIZE))
			    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
			    .addGroup(pnInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
				    .addComponent(lblTenKH).addComponent(txtTenKH,
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
			    .addGroup(pnInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				    .addGroup(pnInfoLayout.createSequentialGroup().addGap(5, 5, 5)
					    .addComponent(lblEmail).addGap(12, 12, 12).addComponent(lblSDT))
				    .addGroup(pnInfoLayout.createSequentialGroup()
					    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE,
						    javax.swing.GroupLayout.DEFAULT_SIZE,
						    javax.swing.GroupLayout.PREFERRED_SIZE)
					    .addGap(6, 6, 6).addComponent(txtSDT,
						    javax.swing.GroupLayout.PREFERRED_SIZE,
						    javax.swing.GroupLayout.DEFAULT_SIZE,
						    javax.swing.GroupLayout.PREFERRED_SIZE)))
			    .addContainerGap(10, Short.MAX_VALUE)));

	    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
	    getContentPane().setLayout(layout);
	    layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
		    .addGroup(layout.createSequentialGroup().addContainerGap().addComponent(pnInfo,
			    javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
			    .addContainerGap()));
	    layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
		    .addGroup(layout.createSequentialGroup().addContainerGap()
			    .addComponent(pnInfo, javax.swing.GroupLayout.PREFERRED_SIZE,
				    javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
			    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
	}

	private void event(String[] data) {
	    // TODO Auto-generated method stub
	    txtMaKH.setText(data[0]);
	    txtCCCD.setText(data[1]);
	    txtTenKH.setText(data[2]);
	    if (data[3].equalsIgnoreCase("Nam")) {
		radNam.setSelected(true);
		radNu.setSelected(false);
	    } else {
		radNam.setSelected(false);
		radNu.setSelected(true);
	    }
	    txtNgaySinh.setText(data[4]);
	    txtEmail.setText(data[5]);
	    txtSDT.setText(data[6]);
	}
    }

    private class FrameAddKhachHang extends JFrame implements ActionListener, FocusListener, KeyListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8303275748715949981L;
	private javax.swing.ButtonGroup btgGioiTinh;
	private javax.swing.JButton btnAdd;
	private javax.swing.JButton btnCancel;
	private org.jdatepicker.JDatePicker dpkNgaySinh;
	private javax.swing.JLabel lblCCCD;
	private javax.swing.JLabel lblEmail;
	private javax.swing.JLabel lblMaKH;
	private javax.swing.JLabel lblSDT;
	private javax.swing.JLabel lblTenKH;
	private javax.swing.JPanel pnAction;
	private javax.swing.JPanel pnGioiTinh;
	private javax.swing.JPanel pnInfo;
	private javax.swing.JPanel pnNgaySinh;
	private javax.swing.JRadioButton radNam;
	private javax.swing.JRadioButton radNu;
	private javax.swing.JTextField txtCCCD;
	private javax.swing.JTextField txtEmail;
	private javax.swing.JTextField txtMaKH;
	private javax.swing.JTextField txtSDT;
	private javax.swing.JTextField txtTenKH;

	private FrameAddKhachHang() {
	    this.setTitle("SE Tourist - Them Khach Hang");
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
	    btgGioiTinh = new javax.swing.ButtonGroup();
	    pnInfo = new javax.swing.JPanel();
	    lblMaKH = new javax.swing.JLabel();
	    txtMaKH = new javax.swing.JTextField();
	    txtCCCD = new javax.swing.JTextField();
	    lblCCCD = new javax.swing.JLabel();
	    lblTenKH = new javax.swing.JLabel();
	    txtTenKH = new javax.swing.JTextField();
	    pnGioiTinh = new javax.swing.JPanel();
	    radNam = new javax.swing.JRadioButton();
	    radNu = new javax.swing.JRadioButton();
	    pnNgaySinh = new javax.swing.JPanel();
	    dpkNgaySinh = new org.jdatepicker.JDatePicker();
	    lblEmail = new javax.swing.JLabel();
	    txtEmail = new javax.swing.JTextField();
	    lblSDT = new javax.swing.JLabel();
	    txtSDT = new javax.swing.JTextField();
	    pnAction = new javax.swing.JPanel();
	    btnAdd = new javax.swing.JButton();
	    btnCancel = new javax.swing.JButton();
	}

	private void style() {
	    // TODO Auto-generated method stub
	    pnInfo.setBorder(javax.swing.BorderFactory.createTitledBorder(
		    javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED),
		    "Thong Tin Khach Hang", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,
		    javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 14))); // NOI18N

	    lblMaKH.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
	    lblMaKH.setText("Ma Khach Hang:");

	    txtMaKH.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

	    txtCCCD.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

	    lblCCCD.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
	    lblCCCD.setText("So CCCD / HC:");

	    lblTenKH.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
	    lblTenKH.setText("Ten Khach Hang:");

	    txtTenKH.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

	    pnGioiTinh.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Gioi Tinh",
		    javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,
		    javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 14))); // NOI18N

	    btgGioiTinh.add(radNam);
	    radNam.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
	    radNam.setSelected(true);
	    radNam.setText("Nam");
	    radNam.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

	    btgGioiTinh.add(radNu);
	    radNu.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
	    radNu.setText("Nu");
	    radNu.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

	    pnNgaySinh.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Ngay Sinh",
		    javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,
		    javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 14))); // NOI18N

	    dpkNgaySinh.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

	    lblEmail.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
	    lblEmail.setText("Email:");

	    txtEmail.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

	    lblSDT.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
	    lblSDT.setText("So Dien Thoai:");

	    txtSDT.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

	    pnAction.setBorder(javax.swing.BorderFactory.createTitledBorder(
		    new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED), "Chon Tac Vu",
		    javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,
		    javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 14))); // NOI18N

	    btnAdd.setBackground(new java.awt.Color(0, 255, 0));
	    btnAdd.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
	    btnAdd.setForeground(new java.awt.Color(255, 255, 255));
	    btnAdd.setText("Them Khach Hang");

	    btnCancel.setBackground(new java.awt.Color(255, 0, 0));
	    btnCancel.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
	    btnCancel.setForeground(new java.awt.Color(255, 255, 255));
	    btnCancel.setText("Huy");

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
			    .addComponent(dpkNgaySinh, javax.swing.GroupLayout.DEFAULT_SIZE, 438, Short.MAX_VALUE)
			    .addGap(8, 8, 8)));
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
				    .addGroup(pnInfoLayout.createSequentialGroup()
					    .addComponent(lblMaKH, javax.swing.GroupLayout.PREFERRED_SIZE, 150,
						    javax.swing.GroupLayout.PREFERRED_SIZE)
					    .addGap(18, 18, 18).addComponent(txtMaKH))
				    .addGroup(pnInfoLayout.createSequentialGroup()
					    .addComponent(lblCCCD, javax.swing.GroupLayout.PREFERRED_SIZE, 150,
						    javax.swing.GroupLayout.PREFERRED_SIZE)
					    .addGap(18, 18, 18).addComponent(txtCCCD))
				    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
					    pnInfoLayout.createSequentialGroup()
						    .addComponent(lblTenKH, javax.swing.GroupLayout.PREFERRED_SIZE, 150,
							    javax.swing.GroupLayout.PREFERRED_SIZE)
						    .addGap(18, 18, 18).addComponent(txtTenKH))
				    .addGroup(pnInfoLayout.createSequentialGroup()
					    .addComponent(pnGioiTinh, javax.swing.GroupLayout.PREFERRED_SIZE,
						    javax.swing.GroupLayout.DEFAULT_SIZE,
						    javax.swing.GroupLayout.PREFERRED_SIZE)
					    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
					    .addComponent(
						    pnNgaySinh, javax.swing.GroupLayout.DEFAULT_SIZE,
						    javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
					    pnInfoLayout.createSequentialGroup().addGroup(pnInfoLayout
						    .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING,
							    false)
						    .addComponent(lblEmail, javax.swing.GroupLayout.DEFAULT_SIZE, 150,
							    Short.MAX_VALUE)
						    .addComponent(lblSDT, javax.swing.GroupLayout.DEFAULT_SIZE,
							    javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						    .addGap(18, 18, 18)
						    .addGroup(pnInfoLayout
							    .createParallelGroup(
								    javax.swing.GroupLayout.Alignment.LEADING)
							    .addComponent(txtSDT).addComponent(txtEmail))))
			    .addContainerGap()));

	    pnInfoLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL,
		    new java.awt.Component[] { lblEmail, lblTenKH });

	    pnInfoLayout.setVerticalGroup(pnInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
		    .addGroup(pnInfoLayout.createSequentialGroup().addContainerGap()
			    .addGroup(pnInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
				    .addComponent(lblMaKH).addComponent(txtMaKH, javax.swing.GroupLayout.PREFERRED_SIZE,
					    javax.swing.GroupLayout.DEFAULT_SIZE,
					    javax.swing.GroupLayout.PREFERRED_SIZE))
			    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
			    .addGroup(pnInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
				    .addComponent(lblCCCD).addComponent(txtCCCD, javax.swing.GroupLayout.PREFERRED_SIZE,
					    javax.swing.GroupLayout.DEFAULT_SIZE,
					    javax.swing.GroupLayout.PREFERRED_SIZE))
			    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
			    .addGroup(pnInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
				    .addComponent(lblTenKH).addComponent(txtTenKH,
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
			    .addGroup(pnInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				    .addGroup(pnInfoLayout.createSequentialGroup().addGap(5, 5, 5)
					    .addComponent(lblEmail).addGap(12, 12, 12).addComponent(lblSDT))
				    .addGroup(pnInfoLayout.createSequentialGroup()
					    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE,
						    javax.swing.GroupLayout.DEFAULT_SIZE,
						    javax.swing.GroupLayout.PREFERRED_SIZE)
					    .addGap(6, 6, 6).addComponent(txtSDT,
						    javax.swing.GroupLayout.PREFERRED_SIZE,
						    javax.swing.GroupLayout.DEFAULT_SIZE,
						    javax.swing.GroupLayout.PREFERRED_SIZE)))
			    .addContainerGap(10, Short.MAX_VALUE)));

	    javax.swing.GroupLayout pnActionLayout = new javax.swing.GroupLayout(pnAction);
	    pnAction.setLayout(pnActionLayout);
	    pnActionLayout
		    .setHorizontalGroup(pnActionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
			    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
				    pnActionLayout.createSequentialGroup().addContainerGap()
					    .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 200,
						    javax.swing.GroupLayout.PREFERRED_SIZE)
					    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
					    .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 200,
						    javax.swing.GroupLayout.PREFERRED_SIZE)
					    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

	    pnActionLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL,
		    new java.awt.Component[] { btnAdd, btnCancel });

	    pnActionLayout.setVerticalGroup(pnActionLayout
		    .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
		    .addGroup(pnActionLayout.createSequentialGroup()
			    .addGroup(pnActionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
				    .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 46,
					    javax.swing.GroupLayout.PREFERRED_SIZE)
				    .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 46,
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
				    .addComponent(pnAction, javax.swing.GroupLayout.DEFAULT_SIZE,
					    javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
			    .addContainerGap()));
	    layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
		    .addGroup(layout.createSequentialGroup().addContainerGap()
			    .addComponent(pnInfo, javax.swing.GroupLayout.PREFERRED_SIZE,
				    javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
			    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
			    .addComponent(pnAction, javax.swing.GroupLayout.PREFERRED_SIZE,
				    javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
			    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
	}

	private void event() {
	    // TODO Auto-generated method stub
	    // Button
	    this.btnAdd.addActionListener(this);
	    this.btnCancel.addActionListener(this);

	    // Text
	    this.txtCCCD.addFocusListener(this);
	    this.txtEmail.addFocusListener(this);
	    this.txtSDT.addFocusListener(this);

	    this.txtCCCD.addKeyListener(this);
	    this.txtEmail.addKeyListener(this);
	    this.txtSDT.addKeyListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
	    // TODO Auto-generated method stub
	    Object o = e.getSource();

	    if (o.equals(btnCancel)) {
		this.dispose();
	    }

	    if (o.equals(btnAdd)) {
		if (txtEmail.getText().trim().matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$")
			&& txtSDT.getText().trim().matches("^(03|05|07|08|09)+([0-9]{8})$")
			&& txtCCCD.getText().trim().matches("^0{1}(0[1-9]|[1-9][0-9]){1}[0-9]{1}[0-9]{2}[0-9]{6}$")) {
		    boolean gender = false;
		    if (radNam.isSelected())
			gender = true;
		    if (radNu.isSelected())
			gender = false;

		    // Lấy ngày tháng được chọn từ JDatePicker
		    Calendar selectedDate = (Calendar) dpkNgaySinh.getModel().getValue();

		    LocalDate localDate = LocalDate.of(selectedDate.get(Calendar.YEAR),
			    selectedDate.get(Calendar.MONTH) + 1, selectedDate.get(Calendar.DAY_OF_MONTH));

		    KhachHang newKH = new KhachHang(txtMaKH.getText(), txtCCCD.getText(), txtTenKH.getText(), gender,
			    localDate, txtEmail.getText(), txtSDT.getText());
		    if (DAO_KhachHang.themKhachHang(newKH)) {
			JOptionPane.showMessageDialog(null, "Them Thanh Cong");
			tblModel.setRowCount(0);
			loadData();
			this.dispose();
		    } else {
			JOptionPane.showMessageDialog(null, "Them That Bai");
			this.dispose();
		    }
		} else {
		    JOptionPane.showMessageDialog(null, "Kiem tra lai thong tin nhap vao");
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

	    if (o.equals(txtCCCD)) {
		String regex = "^0{1}(0[1-9]|[1-9][0-9]){1}[0-9]{1}[0-9]{2}[0-9]{6}$"; // Regex kiểm tra CCCD
		String sdt = txtCCCD.getText().trim(); // Lấy giá trị của txtCCCD và loại bỏ khoảng trắng ở đầu và cuối
						       // chuỗi
		if (!sdt.matches(regex)) {
		    // Nếu dữ liệu nhập vào không đúng, đổi màu viền sang đỏ
		    txtCCCD.setBorder(BorderFactory.createLineBorder(Color.RED));
		} else {
		    // Nếu dữ liệu nhập vào đúng, đổi màu viền sang xanh
		    txtCCCD.setBorder(BorderFactory.createLineBorder(Color.GREEN));
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

	    if (o.equals(txtCCCD)) {
		String regex = "^0{1}(0[1-9]|[1-9][0-9]){1}[0-9]{1}[0-9]{2}[0-9]{6}$"; // Regex kiểm tra CCCD
		String sdt = txtCCCD.getText().trim(); // Lấy giá trị của txtCCCD và loại bỏ khoảng trắng ở đầu và cuối
						       // chuỗi
		if (!sdt.matches(regex)) {
		    // Nếu dữ liệu nhập vào không đúng, đổi màu viền sang đỏ
		    txtCCCD.setBorder(BorderFactory.createLineBorder(Color.RED));
		} else {
		    // Nếu dữ liệu nhập vào đúng, đổi màu viền sang xanh
		    txtCCCD.setBorder(BorderFactory.createLineBorder(Color.GREEN));
		}
	    }
	}

    }

    private class FrameModifyKhachHang extends JFrame implements ActionListener, FocusListener, KeyListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2843751355678013964L;
	private javax.swing.ButtonGroup btgGioiTinhNew;
	private javax.swing.JButton btnCancel;
	private javax.swing.JButton btnUpdate;
	private org.jdatepicker.JDatePicker dpkNgaySinh;
	private javax.swing.JLabel lblCCCDNew;
	private javax.swing.JLabel lblCCCDOld;
	private javax.swing.JLabel lblEmailNew;
	private javax.swing.JLabel lblEmailOld;
	private javax.swing.JLabel lblMaKHNew;
	private javax.swing.JLabel lblMaKHOld;
	private javax.swing.JLabel lblSDTNew;
	private javax.swing.JLabel lblSDTOld;
	private javax.swing.JLabel lblTenKHNew;
	private javax.swing.JLabel lblTenKHOld;
	private javax.swing.JPanel pnAction;
	private javax.swing.JPanel pnGioiTinhNew;
	private javax.swing.JPanel pnGioiTinhOld;
	private javax.swing.JPanel pnNew;
	private javax.swing.JPanel pnNgaySinhNew;
	private javax.swing.JPanel pnNgaySinhOld;
	private javax.swing.JPanel pnOld;
	private javax.swing.JRadioButton radNamOld;
	private javax.swing.JRadioButton radNamNew;
	private javax.swing.JRadioButton radNuOld;
	private javax.swing.JRadioButton radNuNew;
	private javax.swing.JTextField txtCCCDNew;
	private javax.swing.JTextField txtCCCDOld;
	private javax.swing.JTextField txtEmailNew;
	private javax.swing.JTextField txtEmailOld;
	private javax.swing.JTextField txtMaKHNew;
	private javax.swing.JTextField txtMaKHOld;
	private javax.swing.JTextField txtNgaySinh;
	private javax.swing.JTextField txtSDTNew;
	private javax.swing.JTextField txtSDTOld;
	private javax.swing.JTextField txtTenKHNew;
	private javax.swing.JTextField txtTenKHOld;

	private FrameModifyKhachHang(String[] data) {
	    this.setTitle("SE Tourist - Sua Thong Tin Khach Hang");
	    this.setIconImage(LoadSave.GetSpriteAtlas(LoadSave.LOGO_ICON));
	    this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	    this.setResizable(false);
	    this.setLocationRelativeTo(null);
	    this.setMaximumSize(new java.awt.Dimension(1200, 470));
	    this.setMinimumSize(new java.awt.Dimension(1200, 470));

	    this.init();
	    this.style();
	    this.preset();
	    this.event(data);
	}

	private void init() {
	    // TODO Auto-generated method stub
	    btgGioiTinhNew = new javax.swing.ButtonGroup();
	    pnOld = new javax.swing.JPanel();
	    lblMaKHOld = new javax.swing.JLabel();
	    txtMaKHOld = new javax.swing.JTextField();
	    txtCCCDOld = new javax.swing.JTextField();
	    lblCCCDOld = new javax.swing.JLabel();
	    lblTenKHOld = new javax.swing.JLabel();
	    txtTenKHOld = new javax.swing.JTextField();
	    pnGioiTinhOld = new javax.swing.JPanel();
	    radNamOld = new javax.swing.JRadioButton();
	    radNuOld = new javax.swing.JRadioButton();
	    pnNgaySinhOld = new javax.swing.JPanel();
	    txtNgaySinh = new javax.swing.JTextField();
	    lblEmailOld = new javax.swing.JLabel();
	    txtEmailOld = new javax.swing.JTextField();
	    lblSDTOld = new javax.swing.JLabel();
	    txtSDTOld = new javax.swing.JTextField();
	    pnNew = new javax.swing.JPanel();
	    lblMaKHNew = new javax.swing.JLabel();
	    txtMaKHNew = new javax.swing.JTextField();
	    txtCCCDNew = new javax.swing.JTextField();
	    lblCCCDNew = new javax.swing.JLabel();
	    lblTenKHNew = new javax.swing.JLabel();
	    txtTenKHNew = new javax.swing.JTextField();
	    pnGioiTinhNew = new javax.swing.JPanel();
	    radNamNew = new javax.swing.JRadioButton();
	    radNuNew = new javax.swing.JRadioButton();
	    pnNgaySinhNew = new javax.swing.JPanel();
	    dpkNgaySinh = new org.jdatepicker.JDatePicker();
	    lblEmailNew = new javax.swing.JLabel();
	    txtEmailNew = new javax.swing.JTextField();
	    lblSDTNew = new javax.swing.JLabel();
	    txtSDTNew = new javax.swing.JTextField();
	    pnAction = new javax.swing.JPanel();
	    btnUpdate = new javax.swing.JButton();
	    btnCancel = new javax.swing.JButton();
	}

	private void style() {
	    // TODO Auto-generated method stub
	    pnOld.setBorder(javax.swing.BorderFactory.createTitledBorder(
		    javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED), "Thong Tin Cu",
		    javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,
		    javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 14),
		    new java.awt.Color(255, 0, 0))); // NOI18N

	    lblMaKHOld.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
	    lblMaKHOld.setText("Ma Khach Hang:");

	    txtMaKHOld.setEditable(false);
	    txtMaKHOld.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

	    txtCCCDOld.setEditable(false);
	    txtCCCDOld.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

	    lblCCCDOld.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
	    lblCCCDOld.setText("So CCCD / HC:");

	    lblTenKHOld.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
	    lblTenKHOld.setText("Ten Khach Hang:");

	    txtTenKHOld.setEditable(false);
	    txtTenKHOld.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

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

	    txtNgaySinh.setEditable(false);
	    txtNgaySinh.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

	    lblEmailOld.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
	    lblEmailOld.setText("Email:");

	    txtEmailOld.setEditable(false);
	    txtEmailOld.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

	    lblSDTOld.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
	    lblSDTOld.setText("So Dien Thoai:");

	    txtSDTOld.setEditable(false);
	    txtSDTOld.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

	    pnNew.setBorder(javax.swing.BorderFactory.createTitledBorder(
		    javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED), "Thong Tin Moi",
		    javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,
		    javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 14),
		    new java.awt.Color(0, 255, 0))); // NOI18N

	    lblMaKHNew.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
	    lblMaKHNew.setText("Ma Khach Hang:");

	    txtMaKHNew.setEditable(false);
	    txtMaKHNew.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

	    txtCCCDNew.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

	    lblCCCDNew.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
	    lblCCCDNew.setText("So CCCD / HC:");

	    lblTenKHNew.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
	    lblTenKHNew.setText("Ten Khach Hang:");

	    txtTenKHNew.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

	    pnGioiTinhNew.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Gioi Tinh",
		    javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,
		    javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 14))); // NOI18N

	    btgGioiTinhNew.add(radNamNew);
	    radNamNew.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
	    radNamNew.setSelected(true);
	    radNamNew.setText("Nam");
	    radNamNew.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

	    btgGioiTinhNew.add(radNuNew);
	    radNuNew.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
	    radNuNew.setText("Nu");
	    radNuNew.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

	    pnNgaySinhNew.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Ngay Sinh",
		    javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,
		    javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 14))); // NOI18N

	    dpkNgaySinh.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

	    lblEmailNew.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
	    lblEmailNew.setText("Email:");

	    txtEmailNew.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

	    lblSDTNew.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
	    lblSDTNew.setText("So Dien Thoai:");

	    txtSDTNew.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

	    pnAction.setBorder(javax.swing.BorderFactory.createTitledBorder(
		    new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED), "Chon Tac Vu",
		    javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,
		    javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 14))); // NOI18N

	    btnUpdate.setBackground(new java.awt.Color(0, 255, 0));
	    btnUpdate.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
	    btnUpdate.setForeground(new java.awt.Color(255, 255, 255));
	    btnUpdate.setText("Cap Nhat Thong Tin");

	    btnCancel.setBackground(new java.awt.Color(255, 0, 0));
	    btnCancel.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
	    btnCancel.setForeground(new java.awt.Color(255, 255, 255));
	    btnCancel.setText("Huy");
	}

	private void preset() {
	    // TODO Auto-generated method stub
	    javax.swing.GroupLayout pnGioiTinhOldLayout = new javax.swing.GroupLayout(pnGioiTinhOld);
	    pnGioiTinhOld.setLayout(pnGioiTinhOldLayout);
	    pnGioiTinhOldLayout.setHorizontalGroup(pnGioiTinhOldLayout
		    .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
		    .addGroup(pnGioiTinhOldLayout.createSequentialGroup().addContainerGap().addComponent(radNamOld)
			    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(radNuOld)
			    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
	    pnGioiTinhOldLayout.setVerticalGroup(
		    pnGioiTinhOldLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(
			    pnGioiTinhOldLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
				    .addComponent(radNamOld).addComponent(radNuOld)));

	    javax.swing.GroupLayout pnNgaySinhOldLayout = new javax.swing.GroupLayout(pnNgaySinhOld);
	    pnNgaySinhOld.setLayout(pnNgaySinhOldLayout);
	    pnNgaySinhOldLayout.setHorizontalGroup(pnNgaySinhOldLayout
		    .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(pnNgaySinhOldLayout
			    .createSequentialGroup().addContainerGap().addComponent(txtNgaySinh).addContainerGap()));
	    pnNgaySinhOldLayout.setVerticalGroup(
		    pnNgaySinhOldLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(
			    javax.swing.GroupLayout.Alignment.TRAILING,
			    pnNgaySinhOldLayout.createSequentialGroup().addComponent(txtNgaySinh,
				    javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
				    .addContainerGap()));

	    javax.swing.GroupLayout pnOldLayout = new javax.swing.GroupLayout(pnOld);
	    pnOld.setLayout(pnOldLayout);
	    pnOldLayout.setHorizontalGroup(pnOldLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
		    .addGroup(pnOldLayout.createSequentialGroup().addContainerGap()
			    .addGroup(pnOldLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				    .addGroup(pnOldLayout.createSequentialGroup()
					    .addComponent(lblMaKHOld, javax.swing.GroupLayout.PREFERRED_SIZE, 150,
						    javax.swing.GroupLayout.PREFERRED_SIZE)
					    .addGap(18, 18, 18).addComponent(txtMaKHOld,
						    javax.swing.GroupLayout.DEFAULT_SIZE, 263, Short.MAX_VALUE))
				    .addGroup(pnOldLayout.createSequentialGroup()
					    .addComponent(lblCCCDOld, javax.swing.GroupLayout.PREFERRED_SIZE, 150,
						    javax.swing.GroupLayout.PREFERRED_SIZE)
					    .addGap(18, 18, 18).addComponent(txtCCCDOld))
				    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
					    pnOldLayout.createSequentialGroup()
						    .addComponent(lblTenKHOld, javax.swing.GroupLayout.PREFERRED_SIZE,
							    150, javax.swing.GroupLayout.PREFERRED_SIZE)
						    .addGap(18, 18, 18).addComponent(txtTenKHOld))
				    .addGroup(pnOldLayout.createSequentialGroup()
					    .addComponent(pnGioiTinhOld, javax.swing.GroupLayout.PREFERRED_SIZE,
						    javax.swing.GroupLayout.DEFAULT_SIZE,
						    javax.swing.GroupLayout.PREFERRED_SIZE)
					    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
					    .addComponent(
						    pnNgaySinhOld, javax.swing.GroupLayout.DEFAULT_SIZE,
						    javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
					    pnOldLayout.createSequentialGroup().addGroup(pnOldLayout
						    .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING,
							    false)
						    .addComponent(lblEmailOld, javax.swing.GroupLayout.DEFAULT_SIZE,
							    javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						    .addComponent(lblSDTOld, javax.swing.GroupLayout.DEFAULT_SIZE, 150,
							    Short.MAX_VALUE))
						    .addGap(18, 18, 18)
						    .addGroup(pnOldLayout
							    .createParallelGroup(
								    javax.swing.GroupLayout.Alignment.LEADING)
							    .addComponent(txtSDTOld).addComponent(txtEmailOld))))
			    .addContainerGap()));
	    pnOldLayout.setVerticalGroup(pnOldLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
		    .addGroup(pnOldLayout.createSequentialGroup().addContainerGap()
			    .addGroup(pnOldLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
				    .addComponent(lblMaKHOld)
				    .addComponent(txtMaKHOld, javax.swing.GroupLayout.PREFERRED_SIZE,
					    javax.swing.GroupLayout.DEFAULT_SIZE,
					    javax.swing.GroupLayout.PREFERRED_SIZE))
			    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
			    .addGroup(pnOldLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
				    .addComponent(lblCCCDOld)
				    .addComponent(txtCCCDOld, javax.swing.GroupLayout.PREFERRED_SIZE,
					    javax.swing.GroupLayout.DEFAULT_SIZE,
					    javax.swing.GroupLayout.PREFERRED_SIZE))
			    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
			    .addGroup(pnOldLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
				    .addComponent(lblTenKHOld).addComponent(txtTenKHOld,
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
			    .addGroup(pnOldLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				    .addGroup(pnOldLayout.createSequentialGroup().addGap(5, 5, 5)
					    .addComponent(lblEmailOld).addGap(12, 12, 12).addComponent(lblSDTOld))
				    .addGroup(pnOldLayout.createSequentialGroup()
					    .addComponent(txtEmailOld, javax.swing.GroupLayout.PREFERRED_SIZE,
						    javax.swing.GroupLayout.DEFAULT_SIZE,
						    javax.swing.GroupLayout.PREFERRED_SIZE)
					    .addGap(6, 6, 6).addComponent(txtSDTOld,
						    javax.swing.GroupLayout.PREFERRED_SIZE,
						    javax.swing.GroupLayout.DEFAULT_SIZE,
						    javax.swing.GroupLayout.PREFERRED_SIZE)))
			    .addContainerGap(10, Short.MAX_VALUE)));

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
			    .addComponent(dpkNgaySinh, javax.swing.GroupLayout.DEFAULT_SIZE, 387, Short.MAX_VALUE)
			    .addGap(8, 8, 8)));
	    pnNgaySinhNewLayout.setVerticalGroup(pnNgaySinhNewLayout
		    .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
		    .addGroup(pnNgaySinhNewLayout.createSequentialGroup()
			    .addComponent(dpkNgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE,
				    javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
			    .addGap(0, 5, Short.MAX_VALUE)));

	    javax.swing.GroupLayout pnNewLayout = new javax.swing.GroupLayout(pnNew);
	    pnNew.setLayout(pnNewLayout);
	    pnNewLayout.setHorizontalGroup(pnNewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
		    .addGroup(pnNewLayout.createSequentialGroup().addContainerGap()
			    .addGroup(pnNewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				    .addGroup(pnNewLayout.createSequentialGroup()
					    .addComponent(lblMaKHNew, javax.swing.GroupLayout.PREFERRED_SIZE, 150,
						    javax.swing.GroupLayout.PREFERRED_SIZE)
					    .addGap(18, 18, 18).addComponent(txtMaKHNew))
				    .addGroup(pnNewLayout.createSequentialGroup()
					    .addComponent(lblCCCDNew, javax.swing.GroupLayout.PREFERRED_SIZE, 150,
						    javax.swing.GroupLayout.PREFERRED_SIZE)
					    .addGap(18, 18, 18).addComponent(txtCCCDNew))
				    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
					    pnNewLayout.createSequentialGroup()
						    .addComponent(lblTenKHNew, javax.swing.GroupLayout.PREFERRED_SIZE,
							    150, javax.swing.GroupLayout.PREFERRED_SIZE)
						    .addGap(18, 18, 18).addComponent(txtTenKHNew))
				    .addGroup(pnNewLayout.createSequentialGroup()
					    .addComponent(pnGioiTinhNew, javax.swing.GroupLayout.PREFERRED_SIZE,
						    javax.swing.GroupLayout.DEFAULT_SIZE,
						    javax.swing.GroupLayout.PREFERRED_SIZE)
					    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
					    .addComponent(
						    pnNgaySinhNew, javax.swing.GroupLayout.DEFAULT_SIZE,
						    javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
					    pnNewLayout.createSequentialGroup().addGroup(pnNewLayout
						    .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING,
							    false)
						    .addComponent(lblEmailNew, javax.swing.GroupLayout.DEFAULT_SIZE,
							    javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						    .addComponent(lblSDTNew, javax.swing.GroupLayout.DEFAULT_SIZE, 150,
							    Short.MAX_VALUE))
						    .addGap(18, 18, 18)
						    .addGroup(pnNewLayout
							    .createParallelGroup(
								    javax.swing.GroupLayout.Alignment.LEADING)
							    .addComponent(txtSDTNew).addComponent(txtEmailNew))))
			    .addContainerGap()));
	    pnNewLayout.setVerticalGroup(pnNewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
		    .addGroup(pnNewLayout.createSequentialGroup().addContainerGap()
			    .addGroup(pnNewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
				    .addComponent(lblMaKHNew)
				    .addComponent(txtMaKHNew, javax.swing.GroupLayout.PREFERRED_SIZE,
					    javax.swing.GroupLayout.DEFAULT_SIZE,
					    javax.swing.GroupLayout.PREFERRED_SIZE))
			    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
			    .addGroup(pnNewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
				    .addComponent(lblCCCDNew)
				    .addComponent(txtCCCDNew, javax.swing.GroupLayout.PREFERRED_SIZE,
					    javax.swing.GroupLayout.DEFAULT_SIZE,
					    javax.swing.GroupLayout.PREFERRED_SIZE))
			    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
			    .addGroup(pnNewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
				    .addComponent(lblTenKHNew).addComponent(txtTenKHNew,
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
			    .addGroup(pnNewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				    .addGroup(pnNewLayout.createSequentialGroup().addGap(5, 5, 5)
					    .addComponent(lblEmailNew).addGap(12, 12, 12).addComponent(lblSDTNew))
				    .addGroup(pnNewLayout.createSequentialGroup()
					    .addComponent(txtEmailNew, javax.swing.GroupLayout.PREFERRED_SIZE,
						    javax.swing.GroupLayout.DEFAULT_SIZE,
						    javax.swing.GroupLayout.PREFERRED_SIZE)
					    .addGap(6, 6, 6).addComponent(txtSDTNew,
						    javax.swing.GroupLayout.PREFERRED_SIZE,
						    javax.swing.GroupLayout.DEFAULT_SIZE,
						    javax.swing.GroupLayout.PREFERRED_SIZE)))
			    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

	    javax.swing.GroupLayout pnActionLayout = new javax.swing.GroupLayout(pnAction);
	    pnAction.setLayout(pnActionLayout);
	    pnActionLayout
		    .setHorizontalGroup(
			    pnActionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
					    pnActionLayout.createSequentialGroup().addContainerGap()
						    .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE,
							    221, javax.swing.GroupLayout.PREFERRED_SIZE)
						    .addGap(27, 27, 27)
						    .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE,
							    200, javax.swing.GroupLayout.PREFERRED_SIZE)
						    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE,
							    Short.MAX_VALUE)));

	    pnActionLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL,
		    new java.awt.Component[] { btnCancel, btnUpdate });

	    pnActionLayout.setVerticalGroup(pnActionLayout
		    .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
		    .addGroup(pnActionLayout.createSequentialGroup()
			    .addGroup(pnActionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
				    .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 46,
					    javax.swing.GroupLayout.PREFERRED_SIZE)
				    .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 46,
					    javax.swing.GroupLayout.PREFERRED_SIZE))
			    .addContainerGap()));

	    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
	    getContentPane().setLayout(layout);
	    layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
		    .addGroup(layout.createSequentialGroup().addContainerGap()
			    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				    .addGroup(layout.createSequentialGroup()
					    .addComponent(pnOld, javax.swing.GroupLayout.PREFERRED_SIZE,
						    javax.swing.GroupLayout.DEFAULT_SIZE,
						    javax.swing.GroupLayout.PREFERRED_SIZE)
					    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
					    .addComponent(pnNew, javax.swing.GroupLayout.DEFAULT_SIZE,
						    javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				    .addComponent(pnAction, javax.swing.GroupLayout.DEFAULT_SIZE,
					    javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

	private void event(String[] data) {
	    // TODO Auto-generated method stub
	    txtMaKHOld.setText(data[0]);
	    txtMaKHNew.setText(data[0]);
	    txtCCCDOld.setText(data[1]);
	    txtTenKHOld.setText(data[2]);
	    if (data[3].equalsIgnoreCase("Nam")) {
		radNamOld.setSelected(true);
		radNuOld.setSelected(false);
	    } else {
		radNamOld.setSelected(false);
		radNuOld.setSelected(true);
	    }
	    txtNgaySinh.setText(data[4]);
	    txtEmailOld.setText(data[5]);
	    txtSDTOld.setText(data[6]);

	    this.btnUpdate.addActionListener(this);
	    this.btnCancel.addActionListener(this);
	    this.txtEmailNew.addFocusListener(this);
	    this.txtEmailNew.addKeyListener(this);
	    this.txtSDTNew.addFocusListener(this);
	    this.txtSDTNew.addKeyListener(this);
	    this.txtCCCDNew.addFocusListener(this);
	    this.txtCCCDNew.addKeyListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
	    // TODO Auto-generated method stub
	    Object o = e.getSource();
	    if (o.equals(btnCancel))
		this.dispose();
	    if (o.equals(btnUpdate)) {
		if (txtEmailNew.getText().trim().matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$")
			&& txtSDTNew.getText().trim().matches("^(03|05|07|08|09)+([0-9]{8})$") && txtCCCDNew.getText()
				.trim().matches("^0{1}(0[1-9]|[1-9][0-9]){1}[0-9]{1}[0-9]{2}[0-9]{6}$")) {
		    boolean gender = false;
		    if (radNamNew.isSelected())
			gender = true;
		    if (radNuNew.isSelected())
			gender = false;

		    // Lấy ngày tháng được chọn từ JDatePicker
		    Calendar selectedDate = (Calendar) dpkNgaySinh.getModel().getValue();

		    LocalDate localDate = LocalDate.of(selectedDate.get(Calendar.YEAR),
			    selectedDate.get(Calendar.MONTH) + 1, selectedDate.get(Calendar.DAY_OF_MONTH));

		    KhachHang newKH = new KhachHang(txtMaKHNew.getText(), txtCCCDNew.getText(), txtTenKHNew.getText(),
			    gender, localDate, txtEmailNew.getText(), txtSDTNew.getText());
		    if (DAO_KhachHang.suaKhachHang(newKH)) {
			JOptionPane.showMessageDialog(null, "Cap Nhat Thanh Cong");
			tblModel.setRowCount(0);
			loadData();
			this.dispose();
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

	    if (o.equals(txtCCCDNew)) {
		String regex = "^0{1}(0[1-9]|[1-9][0-9]){1}[0-9]{1}[0-9]{2}[0-9]{6}$"; // Regex kiểm tra CCCD
		String sdt = txtCCCDNew.getText().trim(); // Lấy giá trị của txtCCCD và loại bỏ khoảng trắng ở đầu và
							  // cuối
							  // chuỗi
		if (!sdt.matches(regex)) {
		    // Nếu dữ liệu nhập vào không đúng, đổi màu viền sang đỏ
		    txtCCCDNew.setBorder(BorderFactory.createLineBorder(Color.RED));
		} else {
		    // Nếu dữ liệu nhập vào đúng, đổi màu viền sang xanh
		    txtCCCDNew.setBorder(BorderFactory.createLineBorder(Color.GREEN));
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

	    if (o.equals(txtCCCDNew)) {
		String regex = "^0{1}(0[1-9]|[1-9][0-9]){1}[0-9]{1}[0-9]{2}[0-9]{6}$"; // Regex kiểm tra CCCD
		String sdt = txtCCCDNew.getText().trim(); // Lấy giá trị của txtCCCD và loại bỏ khoảng trắng ở đầu và
							  // cuối
							  // chuỗi
		if (!sdt.matches(regex)) {
		    // Nếu dữ liệu nhập vào không đúng, đổi màu viền sang đỏ
		    txtCCCDNew.setBorder(BorderFactory.createLineBorder(Color.RED));
		} else {
		    // Nếu dữ liệu nhập vào đúng, đổi màu viền sang xanh
		    txtCCCDNew.setBorder(BorderFactory.createLineBorder(Color.GREEN));
		}
	    }
	}
    }

}
