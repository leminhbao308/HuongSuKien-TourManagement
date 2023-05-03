package services;

import javax.swing.JPanel;

import entity.TourDuLich;
import utils.constants.ColorConstant;

public class Employee_TourDuLich extends JPanel {

    /**
     * 
     */
    private static final long serialVersionUID = 4857724560123557844L;
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnInfo;
    private javax.swing.JButton btnModify;
    private javax.swing.JButton btnSearchDiaDanh;
    private javax.swing.JButton btnSearchMaVe;
    private javax.swing.JButton btnSearchNgayDi;
    private javax.swing.JButton btnSearchTinhThanh;
    private javax.swing.JComboBox<String> cbxFilter;
    private org.jdatepicker.JDatePicker dpkNgayDi;
    private javax.swing.JLabel lblFilter;
    private javax.swing.JLabel lblSearchDiaDanh;
    private javax.swing.JLabel lblSearchMaVe;
    private javax.swing.JLabel lblSearchNgayDi;
    private javax.swing.JLabel lblSearchTinhThanh;
    private javax.swing.JPanel pnAction;
    private javax.swing.JPanel pnData;
    private javax.swing.JPanel pnSearchDiaDanh;
    private javax.swing.JPanel pnSearchMaTour;
    private javax.swing.JPanel pnSearchNgayDi;
    private javax.swing.JPanel pnSearchTinhThanh;
    private javax.swing.JScrollPane scrData;
    private javax.swing.JTable tblTourDuLich;
    private javax.swing.table.DefaultTableModel tblModel;
    private javax.swing.JTabbedPane tpnSearch;
    private javax.swing.JTextField txtSearchDiaDanh;
    private javax.swing.JTextField txtSearchMaVe;
    private javax.swing.JTextField txtSearchTinhThanh;

    public Employee_TourDuLich() {
	setBackground(ColorConstant.BACKGROUND_NORMAL);
	setForeground(ColorConstant.TEXT_NORMAL);

	init();
	style();
	preset();
    }

    private void init() {
	// TODO Auto-generated method stub
	tpnSearch = new javax.swing.JTabbedPane();
	pnSearchMaTour = new javax.swing.JPanel();
	lblSearchMaVe = new javax.swing.JLabel();
	txtSearchMaVe = new javax.swing.JTextField();
	btnSearchMaVe = new javax.swing.JButton();
	pnSearchDiaDanh = new javax.swing.JPanel();
	lblSearchDiaDanh = new javax.swing.JLabel();
	txtSearchDiaDanh = new javax.swing.JTextField();
	btnSearchDiaDanh = new javax.swing.JButton();
	pnSearchTinhThanh = new javax.swing.JPanel();
	lblSearchTinhThanh = new javax.swing.JLabel();
	txtSearchTinhThanh = new javax.swing.JTextField();
	btnSearchTinhThanh = new javax.swing.JButton();
	pnSearchNgayDi = new javax.swing.JPanel();
	lblSearchNgayDi = new javax.swing.JLabel();
	btnSearchNgayDi = new javax.swing.JButton();
	dpkNgayDi = new org.jdatepicker.JDatePicker();
	pnData = new javax.swing.JPanel();
	lblFilter = new javax.swing.JLabel();
	cbxFilter = new javax.swing.JComboBox<>();
	scrData = new javax.swing.JScrollPane();
	/**
	 * Table
	 */
	{
	    String[] cols = new TourDuLich().getTitle().split(";");
	    tblModel = new javax.swing.table.DefaultTableModel(cols, 0);
	    tblTourDuLich = new javax.swing.JTable(tblModel);
	}
	pnAction = new javax.swing.JPanel();
	btnInfo = new javax.swing.JButton();
	btnAdd = new javax.swing.JButton();
	btnDelete = new javax.swing.JButton();
	btnModify = new javax.swing.JButton();
    }

    private void style() {
	// TODO Auto-generated method stub
	lblSearchMaVe.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
	lblSearchMaVe.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
	lblSearchMaVe.setText("Ma Tour Can Tim:");

	txtSearchMaVe.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

	btnSearchMaVe.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
	btnSearchMaVe.setText("Tim");

	lblSearchDiaDanh.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
	lblSearchDiaDanh.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
	lblSearchDiaDanh.setText("Ten Dia Danh Can Tim:");

	txtSearchDiaDanh.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

	btnSearchDiaDanh.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
	btnSearchDiaDanh.setText("Tim");

	lblSearchTinhThanh.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
	lblSearchTinhThanh.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
	lblSearchTinhThanh.setText("Ten Tinh Thanh Can Tim:");

	txtSearchTinhThanh.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

	btnSearchTinhThanh.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
	btnSearchTinhThanh.setText("Tim");

	tpnSearch.addTab("Tim Theo Tinh Thanh", pnSearchTinhThanh);

	lblSearchNgayDi.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
	lblSearchNgayDi.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
	lblSearchNgayDi.setText("Nhap Ngay Di:");

	btnSearchNgayDi.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
	btnSearchNgayDi.setText("Tim");

	pnData.setBorder(javax.swing.BorderFactory.createTitledBorder(
		javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED),
		"Danh Sach Tour Du Lich", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,
		javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 14))); // NOI18N

	lblFilter.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
	lblFilter.setText("Loc Theo:");

	cbxFilter.setModel(
		new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

	scrData.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
	scrData.setViewportView(tblTourDuLich);

	pnAction.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Chon Tac Vu",
		javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION,
		new java.awt.Font("Segoe UI", 0, 14))); // NOI18N

	btnInfo.setText("Xem Thong Tin");

	btnAdd.setText("Them Tour Du Lich");

	btnDelete.setText("Xoa Tour Du Lich");

	btnModify.setText("Sua Tour Du Lich");
    }

    private void preset() {
	// TODO Auto-generated method stub
	javax.swing.GroupLayout pnSearchMaTourLayout = new javax.swing.GroupLayout(pnSearchMaTour);
	pnSearchMaTour.setLayout(pnSearchMaTourLayout);
	pnSearchMaTourLayout
		.setHorizontalGroup(pnSearchMaTourLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
			.addGroup(pnSearchMaTourLayout.createSequentialGroup().addContainerGap()
				.addComponent(lblSearchMaVe, javax.swing.GroupLayout.PREFERRED_SIZE, 250,
					javax.swing.GroupLayout.PREFERRED_SIZE)
				.addGap(18, 18, 18)
				.addComponent(txtSearchMaVe, javax.swing.GroupLayout.DEFAULT_SIZE, 429, Short.MAX_VALUE)
				.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
				.addComponent(btnSearchMaVe, javax.swing.GroupLayout.PREFERRED_SIZE, 165,
					javax.swing.GroupLayout.PREFERRED_SIZE)
				.addContainerGap()));
	pnSearchMaTourLayout.setVerticalGroup(pnSearchMaTourLayout
		.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
		.addGroup(pnSearchMaTourLayout.createSequentialGroup().addContainerGap().addGroup(pnSearchMaTourLayout
			.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
			.addGroup(pnSearchMaTourLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
				.addComponent(txtSearchMaVe, javax.swing.GroupLayout.PREFERRED_SIZE,
					javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
				.addComponent(lblSearchMaVe, javax.swing.GroupLayout.PREFERRED_SIZE, 31,
					javax.swing.GroupLayout.PREFERRED_SIZE))
			.addComponent(btnSearchMaVe, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
			.addContainerGap(9, Short.MAX_VALUE)));

	tpnSearch.addTab("Tim Theo Ma Tour", pnSearchMaTour);

	javax.swing.GroupLayout pnSearchDiaDanhLayout = new javax.swing.GroupLayout(pnSearchDiaDanh);
	pnSearchDiaDanh.setLayout(pnSearchDiaDanhLayout);
	pnSearchDiaDanhLayout.setHorizontalGroup(pnSearchDiaDanhLayout
		.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
		.addGroup(pnSearchDiaDanhLayout.createSequentialGroup().addContainerGap()
			.addComponent(lblSearchDiaDanh, javax.swing.GroupLayout.PREFERRED_SIZE, 250,
				javax.swing.GroupLayout.PREFERRED_SIZE)
			.addGap(18, 18, 18)
			.addComponent(txtSearchDiaDanh, javax.swing.GroupLayout.DEFAULT_SIZE, 429, Short.MAX_VALUE)
			.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
			.addComponent(btnSearchDiaDanh, javax.swing.GroupLayout.PREFERRED_SIZE, 165,
				javax.swing.GroupLayout.PREFERRED_SIZE)
			.addContainerGap()));
	pnSearchDiaDanhLayout.setVerticalGroup(pnSearchDiaDanhLayout
		.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
		.addGroup(pnSearchDiaDanhLayout.createSequentialGroup().addContainerGap().addGroup(pnSearchDiaDanhLayout
			.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
			.addGroup(pnSearchDiaDanhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
				.addComponent(txtSearchDiaDanh, javax.swing.GroupLayout.PREFERRED_SIZE,
					javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
				.addComponent(lblSearchDiaDanh))
			.addComponent(btnSearchDiaDanh, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
			.addContainerGap(9, Short.MAX_VALUE)));

	tpnSearch.addTab("Tim Theo Dia Danh", pnSearchDiaDanh);

	javax.swing.GroupLayout pnSearchTinhThanhLayout = new javax.swing.GroupLayout(pnSearchTinhThanh);
	pnSearchTinhThanh.setLayout(pnSearchTinhThanhLayout);
	pnSearchTinhThanhLayout.setHorizontalGroup(pnSearchTinhThanhLayout
		.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
		.addGroup(pnSearchTinhThanhLayout.createSequentialGroup().addContainerGap()
			.addComponent(lblSearchTinhThanh, javax.swing.GroupLayout.PREFERRED_SIZE, 250,
				javax.swing.GroupLayout.PREFERRED_SIZE)
			.addGap(18, 18, 18)
			.addComponent(txtSearchTinhThanh, javax.swing.GroupLayout.DEFAULT_SIZE, 429, Short.MAX_VALUE)
			.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
			.addComponent(btnSearchTinhThanh, javax.swing.GroupLayout.PREFERRED_SIZE, 165,
				javax.swing.GroupLayout.PREFERRED_SIZE)
			.addContainerGap()));
	pnSearchTinhThanhLayout.setVerticalGroup(pnSearchTinhThanhLayout
		.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
		.addGroup(pnSearchTinhThanhLayout.createSequentialGroup().addContainerGap()
			.addGroup(pnSearchTinhThanhLayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
				.addGroup(pnSearchTinhThanhLayout
					.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
					.addComponent(txtSearchTinhThanh, javax.swing.GroupLayout.PREFERRED_SIZE,
						javax.swing.GroupLayout.DEFAULT_SIZE,
						javax.swing.GroupLayout.PREFERRED_SIZE)
					.addComponent(lblSearchTinhThanh, javax.swing.GroupLayout.PREFERRED_SIZE, 31,
						javax.swing.GroupLayout.PREFERRED_SIZE))
				.addComponent(btnSearchTinhThanh, javax.swing.GroupLayout.PREFERRED_SIZE, 0,
					Short.MAX_VALUE))
			.addContainerGap(9, Short.MAX_VALUE)));

	tpnSearch.addTab("Tim Theo Tinh Thanh", pnSearchTinhThanh);

	javax.swing.GroupLayout pnSearchNgayDiLayout = new javax.swing.GroupLayout(pnSearchNgayDi);
	pnSearchNgayDi.setLayout(pnSearchNgayDiLayout);
	pnSearchNgayDiLayout.setHorizontalGroup(pnSearchNgayDiLayout
		.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
		.addGroup(pnSearchNgayDiLayout.createSequentialGroup().addContainerGap()
			.addComponent(lblSearchNgayDi, javax.swing.GroupLayout.PREFERRED_SIZE, 250,
				javax.swing.GroupLayout.PREFERRED_SIZE)
			.addGap(18, 18, 18)
			.addComponent(dpkNgayDi, javax.swing.GroupLayout.DEFAULT_SIZE, 423, Short.MAX_VALUE)
			.addGap(18, 18, 18).addComponent(btnSearchNgayDi, javax.swing.GroupLayout.PREFERRED_SIZE, 165,
				javax.swing.GroupLayout.PREFERRED_SIZE)
			.addContainerGap()));
	pnSearchNgayDiLayout.setVerticalGroup(pnSearchNgayDiLayout
		.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
		.addGroup(pnSearchNgayDiLayout.createSequentialGroup().addContainerGap()
			.addGroup(pnSearchNgayDiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
				.addGroup(pnSearchNgayDiLayout
					.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
					.addComponent(lblSearchNgayDi, javax.swing.GroupLayout.PREFERRED_SIZE, 31,
						javax.swing.GroupLayout.PREFERRED_SIZE)
					.addComponent(btnSearchNgayDi, javax.swing.GroupLayout.PREFERRED_SIZE, 0,
						Short.MAX_VALUE))
				.addComponent(dpkNgayDi, javax.swing.GroupLayout.PREFERRED_SIZE,
					javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
			.addContainerGap(9, Short.MAX_VALUE)));

	tpnSearch.addTab("Tim Theo Ngay Di", pnSearchNgayDi);

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
}
