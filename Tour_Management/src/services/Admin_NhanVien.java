package services;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;

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

	btnAdd.setText("Them Nhan Vien");

	btnDelete.setText("Xoa Nhan Vien");

	btnModify.setText("Sua Nhan Vien");
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

	}
	if (o.equals(btnAdd)) {
	    new FrameAddNhanVien().setVisible(true);
	}
	if (o.equals(btnDelete)) {

	}
	if (o.equals(btnModify)) {

	}
    }

    private class FrameAddNhanVien extends JFrame implements ActionListener {

	private javax.swing.JButton btnHuy;
	private javax.swing.JButton btnThem;
	private javax.swing.JComboBox<String> cbxChucVu;
	private org.jdatepicker.JDatePicker dpkNgaySinh;
	private javax.swing.JLabel lblChucVu;
	private javax.swing.JLabel lblDiaChi;
	private javax.swing.JLabel lblEmail;
	private javax.swing.JLabel lblMaNV;
	private javax.swing.JLabel lblSDT;
	private javax.swing.JLabel lblTenNV;
	private javax.swing.JPanel pnAction;
	private javax.swing.JPanel pnGioiTinh;
	private javax.swing.JPanel pnInfo;
	private javax.swing.JPanel pnNgaySinh;
	private javax.swing.JRadioButton radNam;
	private javax.swing.JRadioButton radNu;
	private javax.swing.JTextField txtDiaChi;
	private javax.swing.JTextField txtEmail;
	private javax.swing.JTextField txtMaNV;
	private javax.swing.JTextField txtSDT;
	private javax.swing.JTextField txtTenNV;

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

	    txtMaNV.setEditable(false);
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
        pnGioiTinhLayout.setHorizontalGroup(
            pnGioiTinhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnGioiTinhLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(radNam)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(radNu)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnGioiTinhLayout.setVerticalGroup(
            pnGioiTinhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnGioiTinhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(radNam)
                .addComponent(radNu))
        );
        
	javax.swing.GroupLayout pnNgaySinhLayout = new javax.swing.GroupLayout(pnNgaySinh);
	pnNgaySinh.setLayout(pnNgaySinhLayout);
	pnNgaySinhLayout
		.setHorizontalGroup(
			pnNgaySinhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(pnNgaySinhLayout.createSequentialGroup().addContainerGap()
					.addComponent(dpkNgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, 438,
						javax.swing.GroupLayout.PREFERRED_SIZE)
					.addContainerGap(8, Short.MAX_VALUE)));
	pnNgaySinhLayout
		.setVerticalGroup(pnNgaySinhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
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
						.addComponent(lblDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, 103,
							javax.swing.GroupLayout.PREFERRED_SIZE)
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
					.addComponent(
						pnNgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE,
						javax.swing.GroupLayout.DEFAULT_SIZE,
						javax.swing.GroupLayout.PREFERRED_SIZE))
				.addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
					pnInfoLayout.createSequentialGroup().addGap(0, 0, Short.MAX_VALUE)
						.addGroup(pnInfoLayout
							.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
							.addComponent(lblMaNV, javax.swing.GroupLayout.PREFERRED_SIZE,
								103, javax.swing.GroupLayout.PREFERRED_SIZE)
							.addComponent(lblTenNV, javax.swing.GroupLayout.PREFERRED_SIZE,
								103, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(pnInfoLayout
							.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING,
								false)
							.addComponent(txtMaNV, javax.swing.GroupLayout.DEFAULT_SIZE,
								482, Short.MAX_VALUE)
							.addComponent(txtTenNV))))
			.addContainerGap()));
	pnInfoLayout.setVerticalGroup(pnInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
		.addGroup(pnInfoLayout.createSequentialGroup().addContainerGap()
			.addGroup(pnInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
				.addComponent(lblMaNV).addComponent(txtMaNV, javax.swing.GroupLayout.PREFERRED_SIZE, 26,
					javax.swing.GroupLayout.PREFERRED_SIZE))
			.addGap(5, 5, 5)
			.addGroup(pnInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
				.addComponent(lblTenNV).addComponent(txtTenNV, javax.swing.GroupLayout.PREFERRED_SIZE,
					javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
			.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
			.addGroup(pnInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
				.addComponent(pnGioiTinh, javax.swing.GroupLayout.DEFAULT_SIZE,
					javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
				.addComponent(pnNgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE,
					javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
			.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
			.addGroup(pnInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(pnInfoLayout.createSequentialGroup().addGap(5, 5, 5).addComponent(lblDiaChi)
					.addGap(12, 12, 12).addComponent(lblEmail).addGap(12, 12, 12)
					.addComponent(lblSDT).addGap(12, 12, 12).addComponent(lblChucVu))
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
					.addGap(6, 6, 6).addComponent(cbxChucVu, javax.swing.GroupLayout.PREFERRED_SIZE,
						javax.swing.GroupLayout.DEFAULT_SIZE,
						javax.swing.GroupLayout.PREFERRED_SIZE)))
			.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
	
	javax.swing.GroupLayout pnActionLayout = new javax.swing.GroupLayout(pnAction);
	pnAction.setLayout(pnActionLayout);
	pnActionLayout.setHorizontalGroup(pnActionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
		.addGroup(pnActionLayout.createSequentialGroup().addContainerGap()
			.addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 185,
				javax.swing.GroupLayout.PREFERRED_SIZE)
			.addGap(18, 18, 18)
			.addComponent(btnHuy, javax.swing.GroupLayout.PREFERRED_SIZE, 113,
				javax.swing.GroupLayout.PREFERRED_SIZE)
			.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

	pnActionLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] { btnHuy, btnThem });

	pnActionLayout.setVerticalGroup(pnActionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
		.addGroup(pnActionLayout.createSequentialGroup()
			.addGroup(pnActionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
				.addComponent(btnHuy).addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 34,
					javax.swing.GroupLayout.PREFERRED_SIZE))
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
	}

	@Override
	public void actionPerformed(ActionEvent e) {
	    // TODO Auto-generated method stub
	    Object o = e.getSource();
	    if (o.equals(this.btnThem)) {

	    }
	    if (o.equals(this.btnHuy)) {
		this.dispose();
	    }
	}
    }

    private class PanelDeleteNhanVien extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8157133607587667611L;

    }

    private class PanelModifyNhanVien extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8274213113371000350L;

    }

}
