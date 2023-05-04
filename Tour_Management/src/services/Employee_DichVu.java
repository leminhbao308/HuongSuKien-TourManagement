package services;

import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.text.NumberFormat;
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
import DAO.DAO_KhachHang;
import controllers.CtrlDichVu;
import entity.DichVu;
import utils.LoadSave;
import utils.constants.ColorConstant;

public class Employee_DichVu extends JPanel implements ActionListener {

    /**
     * 
     */
    private static final long serialVersionUID = 1620882785298551272L;
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
    private javax.swing.JTable tblDichVu;
    private javax.swing.table.DefaultTableModel tblModel;
    private javax.swing.JTabbedPane tpnSearch;
    private javax.swing.JTextField txtSearchMa;
    private String[] cols = new DichVu().getTitle().split(";");
    private String[] cbxItem = {"Sắp xếp theo giá tăng", "Sắp xếp theo giá giảm"};
    private ArrayList<DichVu> dsDichVu = new ArrayList<DichVu>();
    
    public Employee_DichVu() {
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
	    tblModel = new javax.swing.table.DefaultTableModel(cols, 0);
	    tblDichVu = new javax.swing.JTable(tblModel);
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
	lblSearchMa.setText("Ma Dich Vu Can Tim:");

	txtSearchMa.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

	btnSearchMa.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
	btnSearchMa.setText("Tim");

	pnData.setBorder(javax.swing.BorderFactory.createTitledBorder(
		javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED), "Danh Sach Dich Vu",
		javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION,
		new java.awt.Font("Segoe UI", 0, 14))); // NOI18N

	lblFilter.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
	lblFilter.setText("Loc Theo:");

	scrData.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
	scrData.setViewportView(tblDichVu);

	pnAction.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Chon Tac Vu",
		javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION,
		new java.awt.Font("Segoe UI", 0, 14))); // NOI18N

	btnInfo.setText("Xem Thong Tin");
	btnInfo.setToolTipText("Xem Thong Tin Dich Vu (Ctr + I)");
	btnInfo.setEnabled(false);

	btnAdd.setText("Them Dich Vu");
	btnAdd.setToolTipText("Them Dich Vu Moi (Ctrl + T)");

	btnDelete.setText("Xoa Dich Vu");
	btnDelete.setToolTipText("Xoa Dich Vu Duoc Chon (Ctrl + D)");
	btnDelete.setEnabled(false);

	btnModify.setText("Sua Dich Vu");
	btnModify.setToolTipText("Sua Thong Tin Dich Vu Duoc Chon (Ctrl +M)");
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
		for(int i=0; i<cbxItem.length;i++) {
			cbxFilter.addItem(cbxItem[i]);
		}
    }

    private void event() {
	// TODO Auto-generated method stub
	// Search
	this.btnSearchMa.addActionListener(this);
	this.cbxFilter.addActionListener(this);

	// Action
	this.btnInfo.addActionListener(this);
	this.btnAdd.addActionListener(this);
	this.btnDelete.addActionListener(this);
	this.btnModify.addActionListener(this);

	// Table
	this.tblDichVu.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

	    @Override
	    public void valueChanged(ListSelectionEvent e) {
		// TODO Auto-generated method stub
		// Kiểm tra xem có dòng nào được chọn hay không
		boolean hasSelection = !tblDichVu.getSelectionModel().isSelectionEmpty();

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
		    int selectedRow = tblDichVu.getSelectedRow();

		    // Lấy số cột của bảng
		    int columnsCount = tblDichVu.getColumnCount();

		    // Tạo một mảng String để chứa dữ liệu của hàng đang được chọn
		    String[] data = new String[columnsCount];

		    // Duyệt qua các cột của hàng đang được chọn và lưu giá trị vào mảng data
		    for (int i = 0; i < columnsCount; i++) {
			data[i] = tblDichVu.getValueAt(selectedRow, i).toString();
		    }

		    new FrameInfoDichVu(data).setVisible(true);
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
		    new FrameAddDichVu().setVisible(true);
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
			int selectedRow = tblDichVu.getSelectedRow();
			String data = tblDichVu.getValueAt(selectedRow, 0).toString();

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
		    int selectedRow = tblDichVu.getSelectedRow();

		    // Lấy số cột của bảng
		    int columnsCount = tblDichVu.getColumnCount();

		    // Tạo một mảng String để chứa dữ liệu của hàng đang được chọn
		    String[] data = new String[columnsCount];

		    // Duyệt qua các cột của hàng đang được chọn và lưu giá trị vào mảng data
		    for (int i = 0; i < columnsCount; i++) {
			data[i] = tblDichVu.getValueAt(selectedRow, i).toString();
		    }
		    new FrameModifyDichVu(data).setVisible(true);
		}
	    }
	});
    }

    private void loadData() {
	ArrayList<DichVu> dsdv = DAO_DichVu.getAllDichVu();

	for (DichVu dichVu : dsdv) {
	    String[] data = dichVu.toString().split(";");

	    // Format đơn vị tiền tệ
	    NumberFormat format = NumberFormat.getCurrencyInstance(new Locale("vi", "VN"));
	    String donGia = format.format(Double.parseDouble(data[3]));

	    // Create a font with a larger size
	    Font largerFont = tblDichVu.getFont().deriveFont(14f);

	    // Set the cell renderer for all columns
	    for (int i = 0; i < tblDichVu.getColumnModel().getColumnCount(); i++) {
		tblDichVu.getColumnModel().getColumn(i).setCellRenderer(new DefaultTableCellRenderer() {
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
	    String[] input = { data[0], data[1], data[2], donGia };
	    tblModel.addRow(input);

	    // Right Align Column
	    DefaultTableCellRenderer rightRender = new DefaultTableCellRenderer();
	    rightRender.setHorizontalAlignment(DefaultTableCellRenderer.RIGHT);

	    TableColumnModel columnModel = tblDichVu.getColumnModel();
	    int lastColumn = columnModel.getColumnCount() - 1; // Lấy cột cuối cùng
	    columnModel.getColumn(lastColumn).setCellRenderer(rightRender);
	}
    }

    private void loadDataToTable(ArrayList<DichVu> dsIn, DefaultTableModel model) {
    	model.setRowCount(0);
    	for(DichVu dv:dsIn) {
    		addOneRowToTable(dv, model);
    	}
    }

    private void addOneRowToTable(DichVu dv, DefaultTableModel model) {
		model.addRow(
			new Object[] {dv.getMaDichVu(), dv.getPhuongTienDiChuyen(), dv.getChiTietDichVu(), dv.getGiaDichVu()});
    }
    @Override
    public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub
	Object o = e.getSource();

	// Search
	if (o.equals(btnSearchMa)) {
		dsDichVu = DAO_DichVu.getAllDichVu();
		if(txtSearchMa.getText().trim().equals("")||txtSearchMa.getText().trim().equals(null)) {
			loadDataToTable(dsDichVu, tblModel);
		} else {
			loadDataToTable(CtrlDichVu.locTourTheoMaDV(dsDichVu, txtSearchMa.getText().trim()), tblModel);
		}
		txtSearchMa.setText("");
	}
	if(o.equals(cbxFilter)) {
		//"Sắp xếp theo giá tăng", "Sắp xếp theo giá giảm"
		dsDichVu = DAO_DichVu.getAllDichVu();
		if(cbxFilter.getSelectedIndex()==0) {
			loadDataToTable(CtrlDichVu.sapXepGiaDichVuTang(dsDichVu), tblModel);
		} else if(cbxFilter.getSelectedIndex()==1) {
			loadDataToTable(CtrlDichVu.sapXepGiaDichVuGiam(dsDichVu), tblModel);
		}
	}
	// Action
	if (o.equals(btnInfo)) {
	    // Lấy chỉ số của hàng đang được chọn
	    int selectedRow = tblDichVu.getSelectedRow();

	    // Lấy số cột của bảng
	    int columnsCount = tblDichVu.getColumnCount();

	    // Tạo một mảng String để chứa dữ liệu của hàng đang được chọn
	    String[] data = new String[columnsCount];

	    // Duyệt qua các cột của hàng đang được chọn và lưu giá trị vào mảng data
	    for (int i = 0; i < columnsCount; i++) {
		data[i] = tblDichVu.getValueAt(selectedRow, i).toString();
	    }
	    new FrameInfoDichVu(data).setVisible(true);
	}
	if (o.equals(btnAdd)) {
	    new FrameAddDichVu().setVisible(true);
	}
	if (o.equals(btnDelete)) {
	    int dialogResult = JOptionPane.showConfirmDialog(null, "Bạn có muốn xóa dữ liệu không?");
	    if (dialogResult == JOptionPane.YES_OPTION) {
		// Lấy chỉ số của hàng đang được chọn
		int selectedRow = tblDichVu.getSelectedRow();
		String data = tblDichVu.getValueAt(selectedRow, 0).toString();

		DAO_DichVu.xoaDichVu(data);
		tblModel.setRowCount(0);
		loadData();
	    }
	}
	if (o.equals(btnModify)) {
	    // Lấy chỉ số của hàng đang được chọn
	    int selectedRow = tblDichVu.getSelectedRow();

	    // Lấy số cột của bảng
	    int columnsCount = tblDichVu.getColumnCount();

	    // Tạo một mảng String để chứa dữ liệu của hàng đang được chọn
	    String[] data = new String[columnsCount];

	    // Duyệt qua các cột của hàng đang được chọn và lưu giá trị vào mảng data
	    for (int i = 0; i < columnsCount; i++) {
		data[i] = tblDichVu.getValueAt(selectedRow, i).toString();
	    }
	    new FrameModifyDichVu(data).setVisible(true);
	}
    }

    private class FrameInfoDichVu extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2915268828481034799L;
	private javax.swing.JLabel lblChiTiet;
	private javax.swing.JLabel lblDonVi;
	private javax.swing.JLabel lblGiaTien;
	private javax.swing.JLabel lblMaDV;
	private javax.swing.JLabel lblPhuongTien;
	private javax.swing.JPanel pnInfo;
	private javax.swing.JScrollPane scrChiTiet;
	private javax.swing.JTextArea taChiTiet;
	private javax.swing.JTextField txtGiaTien;
	private javax.swing.JTextField txtMaDV;
	private javax.swing.JTextField txtPhuongTien;

	public FrameInfoDichVu(String[] data) {
	    this.setTitle("SE Tourist - Thong Tin Dich Vu");
	    this.setIconImage(LoadSave.GetSpriteAtlas(LoadSave.LOGO_ICON));
	    this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	    this.setResizable(false);
	    this.setLocationRelativeTo(null);
	    this.setMaximumSize(new java.awt.Dimension(455, 390));
	    this.setMinimumSize(new java.awt.Dimension(455, 390));

	    this.init();
	    this.style();
	    this.preset();
	    this.event(data);
	}

	private void init() {
	    // TODO Auto-generated method stub
	    pnInfo = new javax.swing.JPanel();
	    lblMaDV = new javax.swing.JLabel();
	    txtMaDV = new javax.swing.JTextField();
	    lblPhuongTien = new javax.swing.JLabel();
	    txtPhuongTien = new javax.swing.JTextField();
	    lblChiTiet = new javax.swing.JLabel();
	    scrChiTiet = new javax.swing.JScrollPane();
	    taChiTiet = new javax.swing.JTextArea();
	    lblGiaTien = new javax.swing.JLabel();
	    lblDonVi = new javax.swing.JLabel();
	    txtGiaTien = new javax.swing.JTextField();
	}

	private void style() {
	    // TODO Auto-generated method stub
	    pnInfo.setBorder(javax.swing.BorderFactory.createTitledBorder(
		    javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED),
		    "Thong Tin Dich Vu", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,
		    javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 14))); // NOI18N

	    lblMaDV.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
	    lblMaDV.setText("Ma Dich Vu");

	    txtMaDV.setEditable(false);
	    txtMaDV.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

	    lblPhuongTien.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
	    lblPhuongTien.setText("Phuong Tien Di Chuyen");

	    txtPhuongTien.setEditable(false);
	    txtPhuongTien.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

	    lblChiTiet.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
	    lblChiTiet.setText("Mo Ta Chi Tiet");

	    taChiTiet.setEditable(false);
	    taChiTiet.setColumns(20);
	    taChiTiet.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
	    taChiTiet.setRows(5);
	    scrChiTiet.setViewportView(taChiTiet);

	    lblGiaTien.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
	    lblGiaTien.setText("Gia Tien");

	    lblDonVi.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
	    lblDonVi.setText("VND");

	    txtGiaTien.setEditable(false);
	    txtGiaTien.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
	    txtGiaTien.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
	}

	private void preset() {
	    // TODO Auto-generated method stub
	    javax.swing.GroupLayout pnInfoLayout = new javax.swing.GroupLayout(pnInfo);
	    pnInfo.setLayout(pnInfoLayout);
	    pnInfoLayout.setHorizontalGroup(pnInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
		    .addGroup(pnInfoLayout.createSequentialGroup().addContainerGap().addGroup(pnInfoLayout
			    .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(txtMaDV)
			    .addComponent(scrChiTiet, javax.swing.GroupLayout.DEFAULT_SIZE, 364, Short.MAX_VALUE)
			    .addGroup(pnInfoLayout.createSequentialGroup().addComponent(txtGiaTien)
				    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
				    .addComponent(lblDonVi))
			    .addGroup(pnInfoLayout.createSequentialGroup()
				    .addGroup(pnInfoLayout
					    .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
					    .addComponent(lblMaDV, javax.swing.GroupLayout.PREFERRED_SIZE, 130,
						    javax.swing.GroupLayout.PREFERRED_SIZE)
					    .addComponent(lblChiTiet, javax.swing.GroupLayout.PREFERRED_SIZE, 130,
						    javax.swing.GroupLayout.PREFERRED_SIZE)
					    .addComponent(lblGiaTien, javax.swing.GroupLayout.PREFERRED_SIZE, 130,
						    javax.swing.GroupLayout.PREFERRED_SIZE)
					    .addComponent(lblPhuongTien))
				    .addGap(0, 0, Short.MAX_VALUE))
			    .addComponent(txtPhuongTien)).addContainerGap()));
	    pnInfoLayout.setVerticalGroup(pnInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
		    .addGroup(pnInfoLayout.createSequentialGroup()
			    .addComponent(lblMaDV, javax.swing.GroupLayout.PREFERRED_SIZE, 26,
				    javax.swing.GroupLayout.PREFERRED_SIZE)
			    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
			    .addComponent(txtMaDV, javax.swing.GroupLayout.PREFERRED_SIZE, 30,
				    javax.swing.GroupLayout.PREFERRED_SIZE)
			    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
			    .addComponent(lblPhuongTien, javax.swing.GroupLayout.PREFERRED_SIZE, 26,
				    javax.swing.GroupLayout.PREFERRED_SIZE)
			    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
			    .addComponent(txtPhuongTien, javax.swing.GroupLayout.PREFERRED_SIZE, 30,
				    javax.swing.GroupLayout.PREFERRED_SIZE)
			    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
			    .addComponent(lblChiTiet, javax.swing.GroupLayout.PREFERRED_SIZE, 26,
				    javax.swing.GroupLayout.PREFERRED_SIZE)
			    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
			    .addComponent(scrChiTiet, javax.swing.GroupLayout.PREFERRED_SIZE, 63,
				    javax.swing.GroupLayout.PREFERRED_SIZE)
			    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
			    .addComponent(lblGiaTien, javax.swing.GroupLayout.PREFERRED_SIZE, 26,
				    javax.swing.GroupLayout.PREFERRED_SIZE)
			    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
			    .addGroup(pnInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
				    .addComponent(lblDonVi).addComponent(txtGiaTien,
					    javax.swing.GroupLayout.PREFERRED_SIZE,
					    javax.swing.GroupLayout.DEFAULT_SIZE,
					    javax.swing.GroupLayout.PREFERRED_SIZE))
			    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

	    pnInfoLayout.linkSize(javax.swing.SwingConstants.VERTICAL,
		    new java.awt.Component[] { txtGiaTien, txtMaDV });

	    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
	    getContentPane().setLayout(layout);
	    layout.setHorizontalGroup(
		    layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
			    .addGap(0, 400, Short.MAX_VALUE)
			    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				    .addGroup(layout.createSequentialGroup().addContainerGap()
					    .addComponent(pnInfo, javax.swing.GroupLayout.DEFAULT_SIZE,
						    javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					    .addContainerGap())));
	    layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
		    .addGap(0, 345, Short.MAX_VALUE)
		    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout
			    .createSequentialGroup().addContainerGap()
			    .addComponent(pnInfo, javax.swing.GroupLayout.PREFERRED_SIZE,
				    javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
			    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))));
	}

	private void event(String[] data) {
	    // TODO Auto-generated method stub
	    this.txtMaDV.setText(data[0]);
	    this.txtPhuongTien.setText(data[1]);
	    this.taChiTiet.setText(data[2]);
	    this.txtGiaTien.setText(data[3]);
	}

    }

    private class FrameAddDichVu extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1323041554572509610L;
	private javax.swing.JButton btnAdd;
	private javax.swing.JButton btnCancel;
	private javax.swing.JComboBox<String> cbxPhuongTien;
	private javax.swing.JLabel lblChiTiet;
	private javax.swing.JLabel lblDonVi;
	private javax.swing.JLabel lblGiaTien;
	private javax.swing.JLabel lblMaDV;
	private javax.swing.JLabel lblPhuongTien;
	private javax.swing.JPanel pnAction;
	private javax.swing.JPanel pnInfo;
	private javax.swing.JScrollPane scrChiTiet;
	private javax.swing.JTextArea taChiTiet;
	private javax.swing.JTextField txtGiaTien;
	private javax.swing.JTextField txtMaDV;

	private FrameAddDichVu() {
	    this.setTitle("SE Tourist - Them Dich Vu");
	    this.setIconImage(LoadSave.GetSpriteAtlas(LoadSave.LOGO_ICON));
	    this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	    this.setResizable(false);
	    this.setLocationRelativeTo(null);
	    this.setMaximumSize(new java.awt.Dimension(465, 485));
	    this.setMinimumSize(new java.awt.Dimension(465, 485));

	    this.init();
	    this.style();
	    this.preset();
	    this.event();
	}

	private void init() {
	    // TODO Auto-generated method stub
	    pnInfo = new javax.swing.JPanel();
	    lblMaDV = new javax.swing.JLabel();
	    txtMaDV = new javax.swing.JTextField();
	    lblPhuongTien = new javax.swing.JLabel();
	    cbxPhuongTien = new javax.swing.JComboBox<>();
	    lblChiTiet = new javax.swing.JLabel();
	    scrChiTiet = new javax.swing.JScrollPane();
	    taChiTiet = new javax.swing.JTextArea();
	    lblGiaTien = new javax.swing.JLabel();
	    lblDonVi = new javax.swing.JLabel();
	    txtGiaTien = new javax.swing.JTextField();
	    pnAction = new javax.swing.JPanel();
	    btnAdd = new javax.swing.JButton();
	    btnCancel = new javax.swing.JButton();
	}

	private void style() {
	    // TODO Auto-generated method stub
	    pnInfo.setBorder(javax.swing.BorderFactory.createTitledBorder(
		    javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED),
		    "Thong Tin Dich Vu", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,
		    javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 14))); // NOI18N

	    lblMaDV.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
	    lblMaDV.setText("Ma Dich Vu");

	    txtMaDV.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

	    lblPhuongTien.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
	    lblPhuongTien.setText("Phuong Tien Di Chuyen");

	    cbxPhuongTien.setModel(new javax.swing.DefaultComboBoxModel<>(
		    new String[] { "Xe đạp", "Xe ô tô (4 chỗ)", "Xe ô tô (7 chỗ)", "Xe máy (Xe số)", "Xe máy (tay ga)",
			    "Xe khách (45 chỗ)", "Tàu hỏa", "Máy bay", "Tàu cao tốc", "Du thuyền", "Canô" }));
	    cbxPhuongTien.setSelectedIndex(-1);
	    cbxPhuongTien.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

	    lblChiTiet.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
	    lblChiTiet.setText("Mo Ta Chi Tiet");

	    taChiTiet.setColumns(20);
	    taChiTiet.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
	    taChiTiet.setRows(5);
	    scrChiTiet.setViewportView(taChiTiet);

	    lblGiaTien.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
	    lblGiaTien.setText("Gia Tien");

	    lblDonVi.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
	    lblDonVi.setText("VND");

	    txtGiaTien.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
	    txtGiaTien.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

	    pnAction.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Chon Tac Vu",
		    javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,
		    javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 14))); // NOI18N

	    btnAdd.setBackground(new java.awt.Color(0, 255, 0));
	    btnAdd.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
	    btnAdd.setForeground(new java.awt.Color(255, 255, 255));
	    btnAdd.setText("Them Dich Vu");
	    btnAdd.setToolTipText("Them dich vu moi");

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
		    .addGroup(pnInfoLayout.createSequentialGroup().addContainerGap().addGroup(pnInfoLayout
			    .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(txtMaDV)
			    .addComponent(scrChiTiet, javax.swing.GroupLayout.DEFAULT_SIZE, 392, Short.MAX_VALUE)
			    .addGroup(pnInfoLayout.createSequentialGroup().addComponent(txtGiaTien)
				    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
				    .addComponent(lblDonVi))
			    .addComponent(cbxPhuongTien, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
			    .addGroup(pnInfoLayout.createSequentialGroup()
				    .addGroup(pnInfoLayout
					    .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
					    .addComponent(lblMaDV, javax.swing.GroupLayout.PREFERRED_SIZE, 130,
						    javax.swing.GroupLayout.PREFERRED_SIZE)
					    .addComponent(lblChiTiet, javax.swing.GroupLayout.PREFERRED_SIZE, 130,
						    javax.swing.GroupLayout.PREFERRED_SIZE)
					    .addComponent(lblGiaTien, javax.swing.GroupLayout.PREFERRED_SIZE, 130,
						    javax.swing.GroupLayout.PREFERRED_SIZE)
					    .addComponent(lblPhuongTien))
				    .addGap(0, 0, Short.MAX_VALUE)))
			    .addContainerGap()));
	    pnInfoLayout.setVerticalGroup(pnInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
		    .addGroup(pnInfoLayout.createSequentialGroup()
			    .addComponent(lblMaDV, javax.swing.GroupLayout.PREFERRED_SIZE, 26,
				    javax.swing.GroupLayout.PREFERRED_SIZE)
			    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
			    .addComponent(txtMaDV, javax.swing.GroupLayout.PREFERRED_SIZE, 30,
				    javax.swing.GroupLayout.PREFERRED_SIZE)
			    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
			    .addComponent(lblPhuongTien, javax.swing.GroupLayout.PREFERRED_SIZE, 26,
				    javax.swing.GroupLayout.PREFERRED_SIZE)
			    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
			    .addComponent(cbxPhuongTien, javax.swing.GroupLayout.PREFERRED_SIZE,
				    javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
			    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
			    .addComponent(lblChiTiet, javax.swing.GroupLayout.PREFERRED_SIZE, 26,
				    javax.swing.GroupLayout.PREFERRED_SIZE)
			    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
			    .addComponent(scrChiTiet, javax.swing.GroupLayout.PREFERRED_SIZE, 63,
				    javax.swing.GroupLayout.PREFERRED_SIZE)
			    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
			    .addComponent(lblGiaTien, javax.swing.GroupLayout.PREFERRED_SIZE, 26,
				    javax.swing.GroupLayout.PREFERRED_SIZE)
			    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
			    .addGroup(pnInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
				    .addComponent(lblDonVi).addComponent(txtGiaTien,
					    javax.swing.GroupLayout.PREFERRED_SIZE,
					    javax.swing.GroupLayout.DEFAULT_SIZE,
					    javax.swing.GroupLayout.PREFERRED_SIZE))
			    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

	    pnInfoLayout.linkSize(javax.swing.SwingConstants.VERTICAL,
		    new java.awt.Component[] { cbxPhuongTien, txtGiaTien, txtMaDV });

	    javax.swing.GroupLayout pnAction2Layout = new javax.swing.GroupLayout(pnAction);
	    pnAction.setLayout(pnAction2Layout);
	    pnAction2Layout
		    .setHorizontalGroup(pnAction2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
			    .addGroup(pnAction2Layout.createSequentialGroup().addContainerGap()
				    .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 194,
					    javax.swing.GroupLayout.PREFERRED_SIZE)
				    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
				    .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 184,
					    javax.swing.GroupLayout.PREFERRED_SIZE)
				    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

	    pnAction2Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL,
		    new java.awt.Component[] { btnAdd, btnCancel });

	    pnAction2Layout
		    .setVerticalGroup(pnAction2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
			    .addGroup(pnAction2Layout.createSequentialGroup().addGroup(pnAction2Layout
				    .createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER).addComponent(btnAdd)
				    .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 40,
					    javax.swing.GroupLayout.PREFERRED_SIZE))
				    .addContainerGap()));

	    pnAction2Layout.linkSize(javax.swing.SwingConstants.VERTICAL,
		    new java.awt.Component[] { btnAdd, btnCancel });

	    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
	    getContentPane().setLayout(layout);
	    layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
		    .addGroup(layout.createSequentialGroup().addContainerGap()
			    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				    .addComponent(pnInfo, javax.swing.GroupLayout.DEFAULT_SIZE,
					    javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
				    .addComponent(pnAction, javax.swing.GroupLayout.DEFAULT_SIZE,
					    javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))));
	    layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
		    .addGroup(layout.createSequentialGroup().addContainerGap()
			    .addComponent(pnInfo, javax.swing.GroupLayout.PREFERRED_SIZE,
				    javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
			    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(pnAction,
				    javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
				    Short.MAX_VALUE)));
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
		DichVu newDV = new DichVu(txtMaDV.getText(), cbxPhuongTien.getSelectedItem().toString(),
			taChiTiet.getText(), Float.parseFloat(txtGiaTien.getText()));

		if (DAO_DichVu.themDichVu(newDV)) {
		    JOptionPane.showInternalMessageDialog(null, "Them Thanh Cong");
		    tblModel.setRowCount(0);
		    loadData();
		    this.dispose();
		} else {
		    JOptionPane.showInternalMessageDialog(null, "Them That Bai", "That Bai", JOptionPane.ERROR_MESSAGE);
		    this.dispose();
		}
	    }
	}
    }

    private class FrameModifyDichVu extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2189692006758680847L;
	private javax.swing.JButton btnModify;
	private javax.swing.JButton btnCancel;
	private javax.swing.JComboBox<String> cbxPhuongTienNew;
	private javax.swing.JLabel lblChiTietNew;
	private javax.swing.JLabel lblChiTietOld;
	private javax.swing.JLabel lblDonViNew;
	private javax.swing.JLabel lblDonViOld;
	private javax.swing.JLabel lblGiaTienNew;
	private javax.swing.JLabel lblGiaTienOld;
	private javax.swing.JLabel lblMaDVNew;
	private javax.swing.JLabel lblMaDVOld;
	private javax.swing.JLabel lblPhuongTienNew;
	private javax.swing.JLabel lblPhuongTienOld;
	private javax.swing.JPanel pnAction;
	private javax.swing.JPanel pnNew;
	private javax.swing.JPanel pnOld;
	private javax.swing.JScrollPane scrChiTietNew;
	private javax.swing.JScrollPane scrChiTietOld;
	private javax.swing.JTextArea taChiTiet;
	private javax.swing.JTextArea taChiTietOld;
	private javax.swing.JTextField txtGiaTienNew;
	private javax.swing.JTextField txtGiaTienOld;
	private javax.swing.JTextField txtMaDVNew;
	private javax.swing.JTextField txtMaDVOld;
	private javax.swing.JTextField txtPhuongTienOld;

	public FrameModifyDichVu(String[] data) {
	    this.setTitle("SE Tourist - Thay Doi Dich Vu");
	    this.setIconImage(LoadSave.GetSpriteAtlas(LoadSave.LOGO_ICON));
	    this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	    this.setResizable(false);
	    this.setLocationRelativeTo(null);
	    this.setMaximumSize(new java.awt.Dimension(900, 485));
	    this.setMinimumSize(new java.awt.Dimension(900, 485));

	    this.init();
	    this.style();
	    this.preset();
	    this.event(data);
	}

	private void init() {
	    // TODO Auto-generated method stub
	    pnOld = new javax.swing.JPanel();
	    lblMaDVOld = new javax.swing.JLabel();
	    txtMaDVOld = new javax.swing.JTextField();
	    lblPhuongTienOld = new javax.swing.JLabel();
	    txtPhuongTienOld = new javax.swing.JTextField();
	    lblChiTietOld = new javax.swing.JLabel();
	    scrChiTietOld = new javax.swing.JScrollPane();
	    taChiTietOld = new javax.swing.JTextArea();
	    lblGiaTienOld = new javax.swing.JLabel();
	    lblDonViOld = new javax.swing.JLabel();
	    txtGiaTienOld = new javax.swing.JTextField();
	    pnNew = new javax.swing.JPanel();
	    lblMaDVNew = new javax.swing.JLabel();
	    txtMaDVNew = new javax.swing.JTextField();
	    lblPhuongTienNew = new javax.swing.JLabel();
	    cbxPhuongTienNew = new javax.swing.JComboBox<>();
	    lblChiTietNew = new javax.swing.JLabel();
	    scrChiTietNew = new javax.swing.JScrollPane();
	    taChiTiet = new javax.swing.JTextArea();
	    lblGiaTienNew = new javax.swing.JLabel();
	    lblDonViNew = new javax.swing.JLabel();
	    txtGiaTienNew = new javax.swing.JTextField();
	    pnAction = new javax.swing.JPanel();
	    btnModify = new javax.swing.JButton();
	    btnCancel = new javax.swing.JButton();
	}

	private void style() {
	    // TODO Auto-generated method stub
	    pnOld.setBorder(javax.swing.BorderFactory.createTitledBorder(
		    javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED), "Thong Tin Cu",
		    javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,
		    javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 14))); // NOI18N

	    lblMaDVOld.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
	    lblMaDVOld.setText("Ma Dich Vu");

	    txtMaDVOld.setEditable(false);
	    txtMaDVOld.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

	    lblPhuongTienOld.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
	    lblPhuongTienOld.setText("Phuong Tien Di Chuyen");

	    txtPhuongTienOld.setEditable(false);
	    txtPhuongTienOld.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

	    lblChiTietOld.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
	    lblChiTietOld.setText("Mo Ta Chi Tiet");

	    taChiTietOld.setEditable(false);
	    taChiTietOld.setColumns(20);
	    taChiTietOld.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
	    taChiTietOld.setRows(5);
	    scrChiTietOld.setViewportView(taChiTietOld);

	    lblGiaTienOld.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
	    lblGiaTienOld.setText("Gia Tien");

	    lblDonViOld.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
	    lblDonViOld.setText("VND");

	    txtGiaTienOld.setEditable(false);
	    txtGiaTienOld.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
	    txtGiaTienOld.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

	    pnNew.setBorder(javax.swing.BorderFactory.createTitledBorder(
		    javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED), "Thong Tin Moi",
		    javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,
		    javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 14))); // NOI18N

	    lblMaDVNew.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
	    lblMaDVNew.setText("Ma Dich Vu");

	    txtMaDVNew.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
	    txtMaDVNew.setEditable(false);

	    lblPhuongTienNew.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
	    lblPhuongTienNew.setText("Phuong Tien Di Chuyen");

	    cbxPhuongTienNew.setModel(new javax.swing.DefaultComboBoxModel<>(
		    new String[] { "Xe đạp", "Xe ô tô (4 chỗ)", "Xe ô tô (7 chỗ)", "Xe máy (Xe số)", "Xe máy (tay ga)",
			    "Xe khách (45 chỗ)", "Tàu hỏa", "Máy bay", "Tàu cao tốc", "Du thuyền", "Canô" }));
	    cbxPhuongTienNew.setSelectedIndex(-1);
	    cbxPhuongTienNew.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

	    lblChiTietNew.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
	    lblChiTietNew.setText("Mo Ta Chi Tiet");

	    taChiTiet.setColumns(20);
	    taChiTiet.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
	    taChiTiet.setRows(5);
	    scrChiTietNew.setViewportView(taChiTiet);

	    lblGiaTienNew.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
	    lblGiaTienNew.setText("Gia Tien");

	    lblDonViNew.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
	    lblDonViNew.setText("VND");

	    txtGiaTienNew.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
	    txtGiaTienNew.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

	    pnAction.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Chon Tac Vu",
		    javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,
		    javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 14))); // NOI18N

	    btnModify.setBackground(new java.awt.Color(0, 255, 0));
	    btnModify.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
	    btnModify.setForeground(new java.awt.Color(255, 255, 255));
	    btnModify.setText("Thay Doi Dich Vu");
	    btnModify.setToolTipText("Thay doi thong tin dich vu");

	    btnCancel.setBackground(new java.awt.Color(255, 0, 0));
	    btnCancel.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
	    btnCancel.setForeground(new java.awt.Color(255, 255, 255));
	    btnCancel.setText("Huy");
	    btnCancel.setToolTipText("Huy thao tac thay doi");
	}

	private void preset() {
	    // TODO Auto-generated method stub
	    javax.swing.GroupLayout pnOldLayout = new javax.swing.GroupLayout(pnOld);
	    pnOld.setLayout(pnOldLayout);
	    pnOldLayout.setHorizontalGroup(pnOldLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
		    .addGroup(pnOldLayout.createSequentialGroup().addContainerGap().addGroup(pnOldLayout
			    .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(txtMaDVOld)
			    .addComponent(scrChiTietOld, javax.swing.GroupLayout.DEFAULT_SIZE, 414, Short.MAX_VALUE)
			    .addGroup(pnOldLayout.createSequentialGroup().addComponent(txtGiaTienOld)
				    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
				    .addComponent(lblDonViOld))
			    .addGroup(pnOldLayout.createSequentialGroup()
				    .addGroup(pnOldLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
					    .addComponent(lblMaDVOld, javax.swing.GroupLayout.PREFERRED_SIZE, 130,
						    javax.swing.GroupLayout.PREFERRED_SIZE)
					    .addComponent(lblChiTietOld, javax.swing.GroupLayout.PREFERRED_SIZE, 130,
						    javax.swing.GroupLayout.PREFERRED_SIZE)
					    .addComponent(lblGiaTienOld, javax.swing.GroupLayout.PREFERRED_SIZE, 130,
						    javax.swing.GroupLayout.PREFERRED_SIZE)
					    .addComponent(lblPhuongTienOld))
				    .addGap(0, 0, Short.MAX_VALUE))
			    .addComponent(txtPhuongTienOld)).addContainerGap()));
	    pnOldLayout.setVerticalGroup(pnOldLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
		    .addGroup(pnOldLayout.createSequentialGroup()
			    .addComponent(lblMaDVOld, javax.swing.GroupLayout.PREFERRED_SIZE, 26,
				    javax.swing.GroupLayout.PREFERRED_SIZE)
			    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
			    .addComponent(txtMaDVOld, javax.swing.GroupLayout.PREFERRED_SIZE, 30,
				    javax.swing.GroupLayout.PREFERRED_SIZE)
			    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
			    .addComponent(lblPhuongTienOld, javax.swing.GroupLayout.PREFERRED_SIZE, 26,
				    javax.swing.GroupLayout.PREFERRED_SIZE)
			    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
			    .addComponent(txtPhuongTienOld, javax.swing.GroupLayout.PREFERRED_SIZE, 30,
				    javax.swing.GroupLayout.PREFERRED_SIZE)
			    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
			    .addComponent(lblChiTietOld, javax.swing.GroupLayout.PREFERRED_SIZE, 26,
				    javax.swing.GroupLayout.PREFERRED_SIZE)
			    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
			    .addComponent(scrChiTietOld, javax.swing.GroupLayout.PREFERRED_SIZE, 63,
				    javax.swing.GroupLayout.PREFERRED_SIZE)
			    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
			    .addComponent(lblGiaTienOld, javax.swing.GroupLayout.PREFERRED_SIZE, 26,
				    javax.swing.GroupLayout.PREFERRED_SIZE)
			    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
			    .addGroup(pnOldLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
				    .addComponent(lblDonViOld).addComponent(txtGiaTienOld,
					    javax.swing.GroupLayout.PREFERRED_SIZE,
					    javax.swing.GroupLayout.DEFAULT_SIZE,
					    javax.swing.GroupLayout.PREFERRED_SIZE))
			    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

	    javax.swing.GroupLayout pnNewLayout = new javax.swing.GroupLayout(pnNew);
	    pnNew.setLayout(pnNewLayout);
	    pnNewLayout.setHorizontalGroup(pnNewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
		    .addGroup(pnNewLayout.createSequentialGroup().addContainerGap().addGroup(pnNewLayout
			    .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(txtMaDVNew)
			    .addComponent(scrChiTietNew, javax.swing.GroupLayout.DEFAULT_SIZE, 467, Short.MAX_VALUE)
			    .addGroup(pnNewLayout.createSequentialGroup().addComponent(txtGiaTienNew)
				    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
				    .addComponent(lblDonViNew))
			    .addComponent(cbxPhuongTienNew, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
			    .addGroup(pnNewLayout.createSequentialGroup()
				    .addGroup(pnNewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
					    .addComponent(lblMaDVNew, javax.swing.GroupLayout.PREFERRED_SIZE, 130,
						    javax.swing.GroupLayout.PREFERRED_SIZE)
					    .addComponent(lblChiTietNew, javax.swing.GroupLayout.PREFERRED_SIZE, 130,
						    javax.swing.GroupLayout.PREFERRED_SIZE)
					    .addComponent(lblGiaTienNew, javax.swing.GroupLayout.PREFERRED_SIZE, 130,
						    javax.swing.GroupLayout.PREFERRED_SIZE)
					    .addComponent(lblPhuongTienNew))
				    .addGap(0, 0, Short.MAX_VALUE)))
			    .addContainerGap()));
	    pnNewLayout.setVerticalGroup(pnNewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
		    .addGroup(pnNewLayout.createSequentialGroup()
			    .addComponent(lblMaDVNew, javax.swing.GroupLayout.PREFERRED_SIZE, 26,
				    javax.swing.GroupLayout.PREFERRED_SIZE)
			    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
			    .addComponent(txtMaDVNew, javax.swing.GroupLayout.PREFERRED_SIZE, 30,
				    javax.swing.GroupLayout.PREFERRED_SIZE)
			    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
			    .addComponent(lblPhuongTienNew, javax.swing.GroupLayout.PREFERRED_SIZE, 26,
				    javax.swing.GroupLayout.PREFERRED_SIZE)
			    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
			    .addComponent(cbxPhuongTienNew, javax.swing.GroupLayout.PREFERRED_SIZE,
				    javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
			    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
			    .addComponent(lblChiTietNew, javax.swing.GroupLayout.PREFERRED_SIZE, 26,
				    javax.swing.GroupLayout.PREFERRED_SIZE)
			    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
			    .addComponent(scrChiTietNew, javax.swing.GroupLayout.PREFERRED_SIZE, 63,
				    javax.swing.GroupLayout.PREFERRED_SIZE)
			    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
			    .addComponent(lblGiaTienNew, javax.swing.GroupLayout.PREFERRED_SIZE, 26,
				    javax.swing.GroupLayout.PREFERRED_SIZE)
			    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
			    .addGroup(pnNewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
				    .addComponent(lblDonViNew).addComponent(txtGiaTienNew,
					    javax.swing.GroupLayout.PREFERRED_SIZE,
					    javax.swing.GroupLayout.DEFAULT_SIZE,
					    javax.swing.GroupLayout.PREFERRED_SIZE))
			    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

	    pnNewLayout.linkSize(javax.swing.SwingConstants.VERTICAL,
		    new java.awt.Component[] { cbxPhuongTienNew, txtMaDVNew });

	    javax.swing.GroupLayout pnActionLayout = new javax.swing.GroupLayout(pnAction);
	    pnAction.setLayout(pnActionLayout);
	    pnActionLayout
		    .setHorizontalGroup(pnActionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
			    .addGroup(pnActionLayout.createSequentialGroup().addContainerGap()
				    .addComponent(btnModify, javax.swing.GroupLayout.PREFERRED_SIZE, 194,
					    javax.swing.GroupLayout.PREFERRED_SIZE)
				    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
				    .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 184,
					    javax.swing.GroupLayout.PREFERRED_SIZE)
				    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

	    pnActionLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL,
		    new java.awt.Component[] { btnModify, btnCancel });

	    pnActionLayout.setVerticalGroup(pnActionLayout
		    .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
		    .addGroup(pnActionLayout.createSequentialGroup()
			    .addGroup(pnActionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
				    .addComponent(btnModify).addComponent(btnCancel,
					    javax.swing.GroupLayout.PREFERRED_SIZE, 40,
					    javax.swing.GroupLayout.PREFERRED_SIZE))
			    .addContainerGap()));

	    pnActionLayout.linkSize(javax.swing.SwingConstants.VERTICAL,
		    new java.awt.Component[] { btnModify, btnCancel });

	    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
	    getContentPane().setLayout(layout);
	    layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
		    .addGroup(layout.createSequentialGroup()
			    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				    .addGroup(layout.createSequentialGroup().addGap(454, 454, 454).addComponent(pnNew,
					    javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
					    Short.MAX_VALUE))
				    .addGroup(layout.createSequentialGroup().addContainerGap().addComponent(pnAction,
					    javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
					    Short.MAX_VALUE)))
			    .addContainerGap())
		    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout
			    .createSequentialGroup().addContainerGap()
			    .addComponent(pnOld, javax.swing.GroupLayout.PREFERRED_SIZE,
				    javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
			    .addContainerGap(507, Short.MAX_VALUE))));
	    layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
		    .addGroup(layout.createSequentialGroup().addContainerGap()
			    .addComponent(pnNew, javax.swing.GroupLayout.PREFERRED_SIZE,
				    javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
			    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
			    .addComponent(pnAction, javax.swing.GroupLayout.DEFAULT_SIZE,
				    javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
			    .addContainerGap())
		    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout
			    .createSequentialGroup().addContainerGap()
			    .addComponent(pnOld, javax.swing.GroupLayout.PREFERRED_SIZE,
				    javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
			    .addContainerGap(85, Short.MAX_VALUE))));

	}

	private void event(String[] data) {
	    // TODO Auto-generated method stub
	    // Text
	    this.txtMaDVOld.setText(data[0]);
	    this.txtMaDVNew.setText(data[0]);
	    this.txtPhuongTienOld.setText(data[1]);
	    this.taChiTietOld.setText(data[2]);
	    this.txtGiaTienOld.setText(data[3]);

	    // Action
	    this.btnModify.addActionListener(this);
	    this.btnCancel.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
	    // TODO Auto-generated method stub
	    Object o = e.getSource();
	    if (o.equals(btnCancel)) {
		this.dispose();
	    }
	    if (o.equals(btnModify)) {
		DichVu modifyDV = new DichVu(txtMaDVNew.getText(), cbxPhuongTienNew.getSelectedItem().toString(),
			taChiTiet.getText(), Float.parseFloat(txtGiaTienNew.getText()));
		if (DAO_DichVu.suaDichVu(modifyDV)) {
		    JOptionPane.showInternalMessageDialog(null, "Cap Nhat Thanh Cong");
		    tblModel.setRowCount(0);
		    loadData();
		    this.dispose();
		} else {
		    JOptionPane.showInternalMessageDialog(null, "Cap Nhat That Bai", "That Bai",
			    JOptionPane.ERROR_MESSAGE);
		    this.dispose();
		}
	    }
	}

    }

}
