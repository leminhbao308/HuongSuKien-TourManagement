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

import DAO.DAO_NhanVien;
import DAO.DAO_TaiKhoan;
import entity.NhanVien;
import entity.TaiKhoan;
import utils.LoadSave;
import utils.PasswordEncoder;
import utils.constants.ColorConstant;

public class Admin_TaiKhoan extends JPanel implements ActionListener {
    /**
     * 
     */
    private static final long serialVersionUID = 4492752808394891285L;
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnInfo;
    private javax.swing.JButton btnModify;
    private javax.swing.JButton btnSearchMa;
    private javax.swing.JComboBox<String> cbxFilter;
    private javax.swing.JLabel lblFilter;
    private javax.swing.JLabel lblSearchMa;
    private javax.swing.JPanel pnAction;
    private javax.swing.JPanel pnData;
    private javax.swing.JPanel pnSearchMa;
    private javax.swing.JScrollPane scrData;
    private javax.swing.JTable tblTaiKhoan;
    private javax.swing.table.DefaultTableModel tblModel;
    private javax.swing.JTabbedPane tpnSearch;
    private javax.swing.JTextField txtSearchMa;

    public Admin_TaiKhoan() {

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
	pnData = new javax.swing.JPanel();
	lblFilter = new javax.swing.JLabel();
	cbxFilter = new javax.swing.JComboBox<>();
	scrData = new javax.swing.JScrollPane();
	{
	    String[] cols = new TaiKhoan().getTitle().split(";");
	    tblModel = new javax.swing.table.DefaultTableModel(cols, 0);
	    tblTaiKhoan = new javax.swing.JTable(tblModel);
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
	lblSearchMa.setText("Mã Nhân Viên Cần Tìm:");

	txtSearchMa.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

	btnSearchMa.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
	btnSearchMa.setText("Tìm");

	pnData.setBorder(javax.swing.BorderFactory.createTitledBorder(
		javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED),
		"Danh Sách Tài Khoản", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,
		javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 14))); // NOI18N

	lblFilter.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
	lblFilter.setText("Lọc Theo:");

	cbxFilter.setModel(
		new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

	scrData.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
	scrData.setViewportView(tblTaiKhoan);

	pnAction.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Chọn Tác Vụ",
		javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION,
		new java.awt.Font("Segoe UI", 0, 14))); // NOI18N

	btnInfo.setText("Xem Thông Tin");
	btnInfo.setToolTipText("Xem thông tin tài khỏan (Ctrl + I)");
	btnInfo.setEnabled(false);

	btnAdd.setText("Thêm Tài Khoản");
	btnAdd.setToolTipText("Tài khoản được thêm tự động khi thêm nhân viên");
	btnAdd.setEnabled(false);

	btnDelete.setText("Xóa Tài Khoản");
	btnDelete.setToolTipText("Tài khoản được xóa tự động khi thêm nhân viên");
	btnDelete.setEnabled(false);

	btnModify.setText("Sửa Tài Khoản");
	btnModify.setToolTipText("Cập nhật mật khẩu (Ctrl + M)");
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
	// Action
	this.btnInfo.addActionListener(this);
	this.btnModify.addActionListener(this);

	// Table
	this.tblTaiKhoan.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

	    @Override
	    public void valueChanged(ListSelectionEvent e) {
		// TODO Auto-generated method stub
		// Kiểm tra xem có dòng nào được chọn hay không
		boolean hasSelection = !tblTaiKhoan.getSelectionModel().isSelectionEmpty();

		// Đặt giá trị cho thuộc tính enabled của btnInfo tương ứng với hasSelection
		btnInfo.setEnabled(hasSelection);
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
		    int selectedRow = tblTaiKhoan.getSelectedRow();

		    // Lấy số cột của bảng
		    int columnsCount = tblTaiKhoan.getColumnCount();

		    // Tạo một mảng String để chứa dữ liệu của hàng đang được chọn
		    String[] data = new String[columnsCount];

		    // Duyệt qua các cột của hàng đang được chọn và lưu giá trị vào mảng data
		    for (int i = 0; i < columnsCount; i++) {
			data[i] = tblTaiKhoan.getValueAt(selectedRow, i).toString();
		    }

		    new FrameInfoTaiKhoan(data).setVisible(true);
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
		    int selectedRow = tblTaiKhoan.getSelectedRow();

		    // Lấy số cột của bảng
		    int columnsCount = tblTaiKhoan.getColumnCount();

		    // Tạo một mảng String để chứa dữ liệu của hàng đang được chọn
		    String[] data = new String[columnsCount];

		    // Duyệt qua các cột của hàng đang được chọn và lưu giá trị vào mảng data
		    for (int i = 0; i < columnsCount; i++) {
			data[i] = tblTaiKhoan.getValueAt(selectedRow, i).toString();
		    }
		    new FrameModifyTaiKhoan(data).setVisible(true);
		}
	    }
	});
    }

    private void loadData() {
	// TODO Auto-generated method stub
	ArrayList<TaiKhoan> dstk = DAO_TaiKhoan.getAllTaiKhoan();

	for (TaiKhoan taiKhoan : dstk) {
	    String[] data = taiKhoan.toString().split(";");
	    // Create a font with a larger size
	    Font largerFont = tblTaiKhoan.getFont().deriveFont(14f);

	    // Set the cell renderer for all columns
	    for (int i = 0; i < tblTaiKhoan.getColumnModel().getColumnCount(); i++) {
		tblTaiKhoan.getColumnModel().getColumn(i).setCellRenderer(new DefaultTableCellRenderer() {
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

	// Action
	if (o.equals(btnInfo)) {
	    // Lấy chỉ số của hàng đang được chọn
	    int selectedRow = tblTaiKhoan.getSelectedRow();

	    // Lấy số cột của bảng
	    int columnsCount = tblTaiKhoan.getColumnCount();

	    // Tạo một mảng String để chứa dữ liệu của hàng đang được chọn
	    String[] data = new String[columnsCount];

	    // Duyệt qua các cột của hàng đang được chọn và lưu giá trị vào mảng data
	    for (int i = 0; i < columnsCount; i++) {
		data[i] = tblTaiKhoan.getValueAt(selectedRow, i).toString();
	    }
	    new FrameInfoTaiKhoan(data).setVisible(true);
	}

	if (o.equals(btnModify)) {
	    // Lấy chỉ số của hàng đang được chọn
	    int selectedRow = tblTaiKhoan.getSelectedRow();

	    // Lấy số cột của bảng
	    int columnsCount = tblTaiKhoan.getColumnCount();

	    // Tạo một mảng String để chứa dữ liệu của hàng đang được chọn
	    String[] data = new String[columnsCount];

	    // Duyệt qua các cột của hàng đang được chọn và lưu giá trị vào mảng data
	    for (int i = 0; i < columnsCount; i++) {
		data[i] = tblTaiKhoan.getValueAt(selectedRow, i).toString();
	    }
	    new FrameModifyTaiKhoan(data).setVisible(true);
	}
    }

    private class FrameInfoTaiKhoan extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 910594592810937910L;
	private javax.swing.JLabel lblAlert;
	private javax.swing.JLabel lblMaNV;
	private javax.swing.JPanel pnInfo;
	private javax.swing.JTextField txtMaNV;

	private FrameInfoTaiKhoan(String[] data) {
	    this.setTitle("SE Tourist - Thông Tin Tài Khoản");
	    this.setIconImage(LoadSave.GetSpriteAtlas(LoadSave.LOGO_ICON));
	    this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	    this.setResizable(false);
	    this.setLocationRelativeTo(null);
	    this.setMaximumSize(new java.awt.Dimension(400, 300));
	    this.setMinimumSize(new java.awt.Dimension(400, 300));

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
	    lblAlert = new javax.swing.JLabel();
	}

	private void style() {
	    // TODO Auto-generated method stub
	    pnInfo.setBorder(javax.swing.BorderFactory
		    .createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Thông Tin Tài Khoản"));

	    lblMaNV.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
	    lblMaNV.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
	    lblMaNV.setText("Mã Nhân Viên:");

	    txtMaNV.setEditable(false);
	    txtMaNV.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
	    txtMaNV.setText("jTextField1");

	    lblAlert.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
	    lblAlert.setForeground(new java.awt.Color(255, 0, 0));
	    lblAlert.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
	    lblAlert.setText("Mật khẩu được mã hóa vì lý do bảo mật!");
	}

	private void preset() {
	    // TODO Auto-generated method stub
	    javax.swing.GroupLayout pnInfoLayout = new javax.swing.GroupLayout(pnInfo);
	    pnInfo.setLayout(pnInfoLayout);
	    pnInfoLayout.setHorizontalGroup(pnInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
		    .addGroup(pnInfoLayout.createSequentialGroup().addContainerGap()
			    .addGroup(pnInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				    .addComponent(lblAlert, javax.swing.GroupLayout.DEFAULT_SIZE, 364, Short.MAX_VALUE)
				    .addGroup(pnInfoLayout.createSequentialGroup()
					    .addComponent(lblMaNV, javax.swing.GroupLayout.PREFERRED_SIZE, 106,
						    javax.swing.GroupLayout.PREFERRED_SIZE)
					    .addGap(18, 18, 18).addComponent(txtMaNV)))
			    .addContainerGap()));
	    pnInfoLayout.setVerticalGroup(pnInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
		    .addGroup(pnInfoLayout.createSequentialGroup().addContainerGap()
			    .addGroup(pnInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
				    .addComponent(lblMaNV, javax.swing.GroupLayout.PREFERRED_SIZE, 40,
					    javax.swing.GroupLayout.PREFERRED_SIZE)
				    .addComponent(txtMaNV, javax.swing.GroupLayout.PREFERRED_SIZE,
					    javax.swing.GroupLayout.DEFAULT_SIZE,
					    javax.swing.GroupLayout.PREFERRED_SIZE))
			    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
			    .addComponent(lblAlert)
			    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

	    pnInfoLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] { lblMaNV, txtMaNV });

	    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
	    getContentPane().setLayout(layout);
	    layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
		    .addGroup(layout.createSequentialGroup().addContainerGap().addComponent(pnInfo,
			    javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
			    .addContainerGap()));
	    layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
		    .addGroup(layout.createSequentialGroup().addContainerGap().addComponent(pnInfo,
			    javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
			    .addGap(5, 5, 5)));
	}

	private void event(String[] data) {
	    // TODO Auto-generated method stub
	    this.txtMaNV.setText(data[0]);
	}
    }

    private class FrameModifyTaiKhoan extends JFrame implements ActionListener, KeyListener, FocusListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 9067231519410272709L;
	private javax.swing.JButton btnCancel;
	private javax.swing.JButton btnUpdate;
	private javax.swing.JLabel lblAlert;
	private javax.swing.JLabel lblConfirmPassword;
	private javax.swing.JLabel lblPasswordNew;
	private javax.swing.JLabel lblPasswordOld;
	private javax.swing.JPanel pnAction;
	private javax.swing.JPanel pnInfo;
	private javax.swing.JPasswordField txtConfirmPassword;
	private javax.swing.JPasswordField txtPasswordNew;
	private javax.swing.JTextField txtPasswordOld;
	private String[] data;

	private FrameModifyTaiKhoan(String[] data) {
	    this.setTitle("SE Tourist - Đổi Mật Khẩu");
	    this.setIconImage(LoadSave.GetSpriteAtlas(LoadSave.LOGO_ICON));
	    this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	    this.setResizable(false);
	    this.setLocationRelativeTo(null);
	    this.setMaximumSize(new java.awt.Dimension(405, 305));
	    this.setMinimumSize(new java.awt.Dimension(405, 305));
	    this.data = data;

	    this.init();
	    this.style();
	    this.preset();
	    this.event(this.data);
	}

	private void init() {
	    // TODO Auto-generated method stub
	    pnInfo = new javax.swing.JPanel();
	    lblPasswordOld = new javax.swing.JLabel();
	    lblPasswordNew = new javax.swing.JLabel();
	    lblConfirmPassword = new javax.swing.JLabel();
	    txtPasswordOld = new javax.swing.JTextField();
	    txtPasswordNew = new javax.swing.JPasswordField();
	    txtConfirmPassword = new javax.swing.JPasswordField();
	    lblAlert = new javax.swing.JLabel();
	    pnAction = new javax.swing.JPanel();
	    btnUpdate = new javax.swing.JButton();
	    btnCancel = new javax.swing.JButton();
	}

	private void style() {
	    // TODO Auto-generated method stub
	    pnInfo.setBorder(javax.swing.BorderFactory
		    .createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Thay Đổi Mật Khẩu"));

	    lblPasswordOld.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
	    lblPasswordOld.setText("Mật Khẩu Cũ:");

	    lblPasswordNew.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
	    lblPasswordNew.setText("Mật Khẩu Mới:");

	    lblConfirmPassword.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
	    lblConfirmPassword.setText("Nhập Lại Mật Khẩu:");

	    txtPasswordOld.setEditable(false);
	    txtPasswordOld.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

	    txtPasswordNew.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

	    txtConfirmPassword.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

	    lblAlert.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
	    lblAlert.setForeground(new java.awt.Color(255, 0, 0));
	    lblAlert.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
	    lblAlert.setText("Mật khẩu có tối thiểu 8 ký tự, có ít nhất 1 chữ số và một ký tự đặc biệt");

	    pnAction.setBorder(javax.swing.BorderFactory
		    .createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Chọn Tác Vụ"));

	    btnUpdate.setBackground(new java.awt.Color(255, 0, 0));
	    btnUpdate.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
	    btnUpdate.setForeground(new java.awt.Color(255, 255, 255));
	    btnUpdate.setText("Cập Nhật");
	    btnUpdate.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

	    btnCancel.setBackground(new java.awt.Color(0, 255, 0));
	    btnCancel.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
	    btnCancel.setForeground(new java.awt.Color(255, 255, 255));
	    btnCancel.setText("Hủy");
	    btnCancel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

	}

	private void preset() {
	    // TODO Auto-generated method stub
	    javax.swing.GroupLayout pnInfoLayout = new javax.swing.GroupLayout(pnInfo);
	    pnInfo.setLayout(pnInfoLayout);
	    pnInfoLayout.setHorizontalGroup(pnInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
		    .addGroup(pnInfoLayout.createSequentialGroup().addGroup(pnInfoLayout
			    .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
			    .addGroup(pnInfoLayout.createSequentialGroup().addContainerGap().addGroup(pnInfoLayout
				    .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				    .addGroup(pnInfoLayout.createSequentialGroup()
					    .addComponent(lblPasswordOld, javax.swing.GroupLayout.PREFERRED_SIZE, 140,
						    javax.swing.GroupLayout.PREFERRED_SIZE)
					    .addGap(29, 29, 29).addComponent(txtPasswordOld))
				    .addGroup(pnInfoLayout.createSequentialGroup().addGroup(pnInfoLayout
					    .createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
					    .addComponent(lblConfirmPassword, javax.swing.GroupLayout.DEFAULT_SIZE,
						    javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					    .addComponent(lblPasswordNew, javax.swing.GroupLayout.DEFAULT_SIZE,
						    javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					    .addGap(18, 18, 18)
					    .addGroup(pnInfoLayout
						    .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						    .addComponent(txtPasswordNew).addComponent(txtConfirmPassword)))))
			    .addComponent(lblAlert, javax.swing.GroupLayout.DEFAULT_SIZE,
				    javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
			    .addContainerGap()));
	    pnInfoLayout.setVerticalGroup(pnInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
		    .addGroup(pnInfoLayout.createSequentialGroup()
			    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
			    .addGroup(pnInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
				    .addComponent(lblPasswordOld, javax.swing.GroupLayout.PREFERRED_SIZE, 30,
					    javax.swing.GroupLayout.PREFERRED_SIZE)
				    .addComponent(txtPasswordOld, javax.swing.GroupLayout.PREFERRED_SIZE,
					    javax.swing.GroupLayout.DEFAULT_SIZE,
					    javax.swing.GroupLayout.PREFERRED_SIZE))
			    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
			    .addGroup(pnInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
				    .addComponent(lblPasswordNew, javax.swing.GroupLayout.PREFERRED_SIZE, 30,
					    javax.swing.GroupLayout.PREFERRED_SIZE)
				    .addComponent(txtPasswordNew, javax.swing.GroupLayout.PREFERRED_SIZE,
					    javax.swing.GroupLayout.DEFAULT_SIZE,
					    javax.swing.GroupLayout.PREFERRED_SIZE))
			    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
			    .addGroup(pnInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
				    .addComponent(lblConfirmPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 30,
					    javax.swing.GroupLayout.PREFERRED_SIZE)
				    .addComponent(txtConfirmPassword, javax.swing.GroupLayout.PREFERRED_SIZE,
					    javax.swing.GroupLayout.DEFAULT_SIZE,
					    javax.swing.GroupLayout.PREFERRED_SIZE))
			    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
			    .addComponent(lblAlert)));

	    pnInfoLayout.linkSize(javax.swing.SwingConstants.VERTICAL,
		    new java.awt.Component[] { lblPasswordOld, txtPasswordOld });

	    pnInfoLayout.linkSize(javax.swing.SwingConstants.VERTICAL,
		    new java.awt.Component[] { lblPasswordNew, txtPasswordNew });

	    pnInfoLayout.linkSize(javax.swing.SwingConstants.VERTICAL,
		    new java.awt.Component[] { lblConfirmPassword, txtConfirmPassword });

	    javax.swing.GroupLayout pnActionLayout = new javax.swing.GroupLayout(pnAction);
	    pnAction.setLayout(pnActionLayout);
	    pnActionLayout
		    .setHorizontalGroup(pnActionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
			    .addGroup(pnActionLayout.createSequentialGroup().addContainerGap()
				    .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 172,
					    javax.swing.GroupLayout.PREFERRED_SIZE)
				    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
				    .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 172,
					    javax.swing.GroupLayout.PREFERRED_SIZE)
				    .addContainerGap(14, Short.MAX_VALUE)));
	    pnActionLayout.setVerticalGroup(pnActionLayout
		    .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
		    .addGroup(pnActionLayout.createSequentialGroup()
			    .addGroup(pnActionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				    .addComponent(btnUpdate, javax.swing.GroupLayout.DEFAULT_SIZE,
					    javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
				    .addComponent(btnCancel, javax.swing.GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE))
			    .addContainerGap()));

	    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
	    getContentPane().setLayout(layout);
	    layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
		    .addGroup(layout.createSequentialGroup().addContainerGap()
			    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				    .addComponent(pnAction, javax.swing.GroupLayout.DEFAULT_SIZE,
					    javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
				    .addComponent(pnInfo, javax.swing.GroupLayout.DEFAULT_SIZE,
					    javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
			    .addContainerGap()));
	    layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
		    .addGroup(layout.createSequentialGroup().addContainerGap()
			    .addComponent(pnInfo, javax.swing.GroupLayout.PREFERRED_SIZE,
				    javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
			    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
			    .addComponent(pnAction, javax.swing.GroupLayout.DEFAULT_SIZE,
				    javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
			    .addContainerGap()));
	}

	private void event(String[] data) {
	    // TODO Auto-generated method stub
	    this.txtPasswordOld.setText(data[1]);

	    // Action
	    this.btnUpdate.addActionListener(this);
	    this.btnCancel.addActionListener(this);

	    // Text
	    this.txtPasswordNew.addFocusListener(this);
	    this.txtConfirmPassword.addFocusListener(this);
	    this.txtPasswordNew.addKeyListener(this);
	    this.txtConfirmPassword.addKeyListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
	    // TODO Auto-generated method stub
	    Object o = e.getSource();

	    if (o.equals(btnCancel)) {
		this.dispose();
	    }

	    if (o.equals(btnUpdate)) {
		char[] pass = txtPasswordNew.getPassword();
		String newpass = new String(pass);
		char[] confirm = txtConfirmPassword.getPassword();
		String confirmpass = new String(confirm);

		if (newpass.matches("^(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-.]).{8,}$")
			&& newpass.equals(confirmpass)) {

		    TaiKhoan modifyTK = new TaiKhoan(DAO_NhanVien.timKiemNhanVien(this.data[0]),
			    PasswordEncoder.hashPassword(newpass));
		    if (DAO_TaiKhoan.suaTaiKhoan(modifyTK)) {
			JOptionPane.showMessageDialog(null, "Cập Nhật Thành Công");
			tblModel.setRowCount(0);
			loadData();
			this.dispose();
		    } else {
			JOptionPane.showMessageDialog(null, "Cập Nhật Thất Bại");
			this.dispose();
		    }
		} else {
		    JOptionPane.showMessageDialog(null, "Kiểm tra lại thông tin nhập vào");
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

	    if (o.equals(txtPasswordNew)) {
		String regex = "^(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-.]).{8,}$"; // Regex kiểm tra Mật Khẩu
		char[] pass = txtPasswordNew.getPassword();
		String newPass = new String(pass);
		if (!newPass.matches(regex)) {
		    // Nếu dữ liệu nhập vào không đúng, đổi màu viền sang đỏ
		    txtPasswordNew.setBorder(BorderFactory.createLineBorder(Color.RED));
		} else {
		    // Nếu dữ liệu nhập vào đúng, đổi màu viền sang xanh
		    txtPasswordNew.setBorder(BorderFactory.createLineBorder(Color.GREEN));
		}
	    }

	    if (o.equals(txtConfirmPassword)) {
		char[] pass = txtPasswordNew.getPassword();
		String newPass = new String(pass);
		char[] confirm = txtConfirmPassword.getPassword();
		String confirmPass = new String(confirm);
		// chuỗi
		if ((!confirmPass.matches("^(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-.]).{8,}$")
			&& !confirmPass.equals(newPass))
			|| (!confirmPass.matches("^(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-.]).{8,}$")
				&& confirmPass.equals(newPass))) {
		    // Nếu dữ liệu nhập vào không đúng, đổi màu viền sang đỏ
		    txtConfirmPassword.setBorder(BorderFactory.createLineBorder(Color.RED));
		} else {
		    // Nếu dữ liệu nhập vào đúng, đổi màu viền sang xanh
		    txtConfirmPassword.setBorder(BorderFactory.createLineBorder(Color.GREEN));
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

	    if (o.equals(txtPasswordNew)) {
		String regex = "^(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-.]).{8,}$"; // Regex kiểm tra Mật Khẩu
		char[] pass = txtPasswordNew.getPassword();
		String newPass = new String(pass);
		char[] confirm = txtConfirmPassword.getPassword();
		String confirmPass = new String(confirm);
		if (!newPass.matches(regex)) {
		    // Nếu dữ liệu nhập vào không đúng, đổi màu viền sang đỏ
		    txtPasswordNew.setBorder(BorderFactory.createLineBorder(Color.RED));
		} else {
		    // Nếu dữ liệu nhập vào đúng, đổi màu viền sang xanh
		    txtPasswordNew.setBorder(BorderFactory.createLineBorder(Color.GREEN));
		}
	    }

	    if (o.equals(txtConfirmPassword)) {
		char[] pass = txtPasswordNew.getPassword();
		String newPass = new String(pass);
		char[] confirm = txtConfirmPassword.getPassword();
		String confirmPass = new String(confirm);
		// chuỗi
		if ((!confirmPass.matches("^(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-.]).{8,}$")
			&& !confirmPass.equals(newPass))
			|| (!confirmPass.matches("^(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-.]).{8,}$")
				&& confirmPass.equals(newPass))) {
		    // Nếu dữ liệu nhập vào không đúng, đổi màu viền sang đỏ
		    txtConfirmPassword.setBorder(BorderFactory.createLineBorder(Color.RED));
		} else {
		    // Nếu dữ liệu nhập vào đúng, đổi màu viền sang xanh
		    txtConfirmPassword.setBorder(BorderFactory.createLineBorder(Color.GREEN));
		}
	    }
	}
    }
}
