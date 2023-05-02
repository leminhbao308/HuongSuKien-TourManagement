package services;

import javax.swing.JPanel;

import entity.HopDongTour;
import utils.constants.ColorConstant;

public class Employee_HopDongTour extends JPanel {

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

	btnAdd.setText("Them Hop Dong");

	btnDelete.setText("Xoa Hop Dong");

	btnModify.setText("Sua Hop Dong");

	btnPrint.setText("In Hop Dong");
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
}
