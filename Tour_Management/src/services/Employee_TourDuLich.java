package services;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

import DAO.DAO_TourDuLich;
import controllers.CtrlTourDuLich;
import entity.TourDuLich;
import utils.constants.ColorConstant;

public class Employee_TourDuLich extends JPanel implements ActionListener, MouseListener {

    /**
     * 
     */
    private static final long serialVersionUID = 4857724560123557844L;
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnInfo;
    private javax.swing.JButton btnModify;
    private javax.swing.JButton btnSearchTinhThanh;
    private javax.swing.JButton btnSearchMaTour;
    private javax.swing.JButton btnSearchNgayDi;
    private javax.swing.JButton btnSearchThongTin;
    private javax.swing.JButton btnRefresh;
    private javax.swing.JComboBox<String> cbxLocTheo;
    private org.jdatepicker.JDatePicker dpkNgayDi;
    private javax.swing.JLabel lblLocTheo;
    private javax.swing.JLabel lblSearchTinhThanh;
    private javax.swing.JLabel lblSearchMaTour;
    private javax.swing.JLabel lblSearchNgayDi;
    private javax.swing.JLabel lblSearchThongTin;
    private javax.swing.JPanel pnAction;
    private javax.swing.JPanel pnData;
    private javax.swing.JPanel pnSearchTinhThanh;
    private javax.swing.JPanel pnSearchMaTour;
    private javax.swing.JPanel pnSearchNgayDi;
    private javax.swing.JPanel pnSearchThongTin;
    private javax.swing.JScrollPane scrData;
    private javax.swing.JTable tblTourDuLich;
    private javax.swing.table.DefaultTableModel tblModel;
    private javax.swing.JTabbedPane tpnSearch;
    private javax.swing.JTextField txtSearchTinhThanh;
    private javax.swing.JTextField txtSearchMaTour;
    private javax.swing.JTextField txtSearchThongTin;
    private String[] cols = new TourDuLich().getTitle().split(";");
	ArrayList<TourDuLich> dsTourDuLich = new ArrayList<TourDuLich>();

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
	lblSearchMaTour = new javax.swing.JLabel();
	txtSearchMaTour = new javax.swing.JTextField();
	btnSearchMaTour = new javax.swing.JButton();
	pnSearchTinhThanh = new javax.swing.JPanel();
	lblSearchTinhThanh = new javax.swing.JLabel();
	txtSearchTinhThanh = new javax.swing.JTextField();
	btnSearchTinhThanh = new javax.swing.JButton();
	pnSearchThongTin = new javax.swing.JPanel();
	lblSearchThongTin = new javax.swing.JLabel();
	txtSearchThongTin = new javax.swing.JTextField();
	btnSearchThongTin = new javax.swing.JButton();
	pnSearchNgayDi = new javax.swing.JPanel();
	lblSearchNgayDi = new javax.swing.JLabel();
	btnSearchNgayDi = new javax.swing.JButton();
	dpkNgayDi = new org.jdatepicker.JDatePicker();
	pnData = new javax.swing.JPanel();
	lblLocTheo = new javax.swing.JLabel();
	cbxLocTheo = new javax.swing.JComboBox<>();
	btnRefresh = new JButton();
	scrData = new javax.swing.JScrollPane();
	/**
	 * Table
	 */
	{
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
	lblSearchMaTour.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
	lblSearchMaTour.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
	lblSearchMaTour.setText("Tìm theo mã Tour :");

	txtSearchMaTour.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

	btnSearchMaTour.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
	btnSearchMaTour.setText("Tìm kiếm");

	lblSearchTinhThanh.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
	lblSearchTinhThanh.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
	lblSearchTinhThanh.setText("Địa danh cần tìm :");

	txtSearchTinhThanh.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

	btnSearchTinhThanh.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
	btnSearchTinhThanh.setText("Tìm Kiếm");

	lblSearchThongTin.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
	lblSearchThongTin.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
	lblSearchThongTin.setText("Thông tin cần tìm:");

	txtSearchThongTin.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

	btnSearchThongTin.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
	btnSearchThongTin.setText("Tìm kiếm");

	lblSearchNgayDi.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
	lblSearchNgayDi.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
	lblSearchNgayDi.setText("Tìm theo ngày đi:");

	btnSearchNgayDi.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
	btnSearchNgayDi.setText("Tìm Kiếm");

	pnData.setBorder(javax.swing.BorderFactory.createTitledBorder(
		javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED),
		"Danh Sách Tour Du Lịch", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,
		javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 14))); // NOI18N

	lblLocTheo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
	lblLocTheo.setText("Lọc theo:");

	scrData.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
	scrData.setViewportView(tblTourDuLich);

	pnAction.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Chọn Tác Vụ",
		javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION,
		new java.awt.Font("Segoe UI", 0, 14))); // NOI18N

	btnInfo.setText("Xem Thông Tin");
	btnInfo.setEnabled(false);
	btnInfo.setToolTipText("Xem Thông Tin Tour (Ctrl + I)");

	btnAdd.setText("Thêm Tour");
	btnAdd.setToolTipText("Thêm Tour Mới (Ctrl + T)");

	btnDelete.setText("Xóa Tour");
	btnDelete.setEnabled(false);
	btnDelete.setToolTipText("Xóa Tour Được Chọn (Ctrl + D)");

	btnModify.setText("Sửa Tour");
	btnModify.setEnabled(false);
	btnModify.setToolTipText("Sửa Thông Tin Tour Được Chọn (Ctrl + M)");
	
	btnRefresh.setText("Làm mới");
	btnRefresh.setToolTipText("Làm mới thông tin (F5)");
    }

    private void preset() {
	// TODO Auto-generated method stub
	javax.swing.GroupLayout pnSearchMaTourLayout = new javax.swing.GroupLayout(pnSearchMaTour);
	pnSearchMaTour.setLayout(pnSearchMaTourLayout);
	pnSearchMaTourLayout.setHorizontalGroup(pnSearchMaTourLayout
		.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
		.addGroup(pnSearchMaTourLayout.createSequentialGroup().addContainerGap()
			.addComponent(lblSearchMaTour, javax.swing.GroupLayout.PREFERRED_SIZE, 250,
				javax.swing.GroupLayout.PREFERRED_SIZE)
			.addGap(18, 18, 18)
			.addComponent(txtSearchMaTour, javax.swing.GroupLayout.DEFAULT_SIZE, 429, Short.MAX_VALUE)
			.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
			.addComponent(btnSearchMaTour, javax.swing.GroupLayout.PREFERRED_SIZE, 165,
				javax.swing.GroupLayout.PREFERRED_SIZE)
			.addContainerGap()));
	pnSearchMaTourLayout.setVerticalGroup(pnSearchMaTourLayout
		.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
		.addGroup(pnSearchMaTourLayout.createSequentialGroup().addContainerGap().addGroup(pnSearchMaTourLayout
			.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
			.addGroup(pnSearchMaTourLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
				.addComponent(txtSearchMaTour, javax.swing.GroupLayout.PREFERRED_SIZE,
					javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
				.addComponent(lblSearchMaTour, javax.swing.GroupLayout.PREFERRED_SIZE, 31,
					javax.swing.GroupLayout.PREFERRED_SIZE))
			.addComponent(btnSearchMaTour, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
			.addContainerGap(9, Short.MAX_VALUE)));

	tpnSearch.addTab("Tìm với mã Tour", pnSearchMaTour);

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
		.addGroup(pnSearchTinhThanhLayout.createSequentialGroup().addContainerGap().addGroup(pnSearchTinhThanhLayout
			.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
			.addGroup(pnSearchTinhThanhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
				.addComponent(txtSearchTinhThanh, javax.swing.GroupLayout.PREFERRED_SIZE,
					javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
				.addComponent(lblSearchTinhThanh))
			.addComponent(btnSearchTinhThanh, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
			.addContainerGap(9, Short.MAX_VALUE)));

	tpnSearch.addTab("Tìm theo Tỉnh Thành", pnSearchTinhThanh);

	javax.swing.GroupLayout pnSearchThongTinLayout = new javax.swing.GroupLayout(pnSearchThongTin);
	pnSearchThongTin.setLayout(pnSearchThongTinLayout);
	pnSearchThongTinLayout.setHorizontalGroup(pnSearchThongTinLayout
		.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
		.addGroup(pnSearchThongTinLayout.createSequentialGroup().addContainerGap()
			.addComponent(lblSearchThongTin, javax.swing.GroupLayout.PREFERRED_SIZE, 250,
				javax.swing.GroupLayout.PREFERRED_SIZE)
			.addGap(18, 18, 18)
			.addComponent(txtSearchThongTin, javax.swing.GroupLayout.DEFAULT_SIZE, 429, Short.MAX_VALUE)
			.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
			.addComponent(btnSearchThongTin, javax.swing.GroupLayout.PREFERRED_SIZE, 165,
				javax.swing.GroupLayout.PREFERRED_SIZE)
			.addContainerGap()));

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

	tpnSearch.addTab("Tìm theo ngày đi", pnSearchNgayDi);

	pnSearchThongTinLayout.setVerticalGroup(pnSearchThongTinLayout
		.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
		.addGroup(pnSearchThongTinLayout.createSequentialGroup().addContainerGap()
			.addGroup(pnSearchThongTinLayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
				.addGroup(pnSearchThongTinLayout
					.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
					.addComponent(txtSearchThongTin, javax.swing.GroupLayout.PREFERRED_SIZE,
						javax.swing.GroupLayout.DEFAULT_SIZE,
						javax.swing.GroupLayout.PREFERRED_SIZE)
					.addComponent(lblSearchThongTin, javax.swing.GroupLayout.PREFERRED_SIZE, 31,
						javax.swing.GroupLayout.PREFERRED_SIZE))
				.addComponent(btnSearchThongTin, javax.swing.GroupLayout.PREFERRED_SIZE, 0,
					Short.MAX_VALUE))
			.addContainerGap(9, Short.MAX_VALUE)));

	tpnSearch.addTab("Tìm theo thông tin Tour", pnSearchThongTin);

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
					.addComponent(lblLocTheo)
					.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
					.addComponent(cbxLocTheo, javax.swing.GroupLayout.PREFERRED_SIZE, 154,
						javax.swing.GroupLayout.PREFERRED_SIZE))
				.addComponent(scrData).addComponent(pnAction, javax.swing.GroupLayout.DEFAULT_SIZE,
					javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
			.addContainerGap()));
	pnDataLayout.setVerticalGroup(pnDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
		.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnDataLayout.createSequentialGroup()
			.addGroup(pnDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
				.addComponent(lblLocTheo)
				.addComponent(cbxLocTheo, javax.swing.GroupLayout.PREFERRED_SIZE,
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
	String[] locTheo = {"Tất cả tour","Tour sau hôm nay", "Gía Tour giảm dần", "Giá Tour tăng dần", "Tour đã đóng", "Tour đang mở"};
    for(int i=0; i<locTheo.length;i++) {
    	cbxLocTheo.addItem(locTheo[i]);
    }
	dsTourDuLich = DAO_TourDuLich.getAllTourDuLich();
	loadDataToTable(dsTourDuLich, tblModel);
	
	event();
    }

    private void event() {
    	this.btnSearchMaTour.addActionListener(this);
    	this.btnSearchNgayDi.addActionListener(this);
    	this.btnSearchThongTin.addActionListener(this);
    	this.btnSearchTinhThanh.addActionListener(this);
    	this.cbxLocTheo.addActionListener(this);
    	
    	this.btnInfo.addActionListener(this);
    	this.btnAdd.addActionListener(this);
    	this.btnDelete.addActionListener(this);
    	this.btnModify.addActionListener(this);
    	
    	this.tblTourDuLich.addMouseListener(this);
    	
    	/* Table 
    	 * 
    	 * 
    	 * 
    	*/
    	
    	/* shotcut 
    	 * 
    	 * 
    	 * 
    	*/
    }

    private void loadDataToTable(ArrayList<TourDuLich> dsIn, DefaultTableModel model) {
    	model.setRowCount(0);
    	for(TourDuLich tour:dsIn) {
    		addOneRowToTable(tour, model);
    	}
	for (TourDuLich tour : dsIn) {
	    addOneRowToTable(tour, model);
	}
    }

    private void addOneRowToTable(TourDuLich tour, DefaultTableModel model) {
	String trangThai;
	trangThai = tour.getTrangThaiTour() ? "Hoạt động" : "Đã đóng";
	model.addRow(
		new Object[] { tour.getMaTour(), tour.getTenTour(), tour.getMoTa(), tour.getNgayDi(), tour.getNoiDi(),
			tour.getSoNgayDuKien(), tour.getGiaTour(), trangThai, tour.getDiaDanh().getTenDiaDanh() });
    }

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if(o.equals(btnSearchMaTour)) {
			if(txtSearchMaTour.getText().trim().equals("")||txtSearchMaTour.getText().trim().equals(null)) {
				JOptionPane.showMessageDialog(this, "Vui lòng nhập mã cần tìm !");
			} else {
				dsTourDuLich = CtrlTourDuLich.locTourTheoMaTour(DAO_TourDuLich.getAllTourDuLich(), txtSearchMaTour.getText().trim());
				if(dsTourDuLich.size()==0) {
					JOptionPane.showMessageDialog(this, "Không có dữ liệu phù hợp !");
				} else {
					loadDataToTable(dsTourDuLich, tblModel);
				}
			}
		} else if(o.equals(btnSearchThongTin)) {
			if(txtSearchThongTin.getText().trim().equals("")||txtSearchThongTin.getText().trim().equals(null)) {
				JOptionPane.showMessageDialog(this, "Vui lòng nhập thông tin cần tìm !");
			} else {
				dsTourDuLich = CtrlTourDuLich.locTourTheoThongTinTour(DAO_TourDuLich.getAllTourDuLich(), txtSearchThongTin.getText().trim());
				if(dsTourDuLich.size()==0) {
					JOptionPane.showMessageDialog(this, "Không có dữ liệu phù hợp !");
				} else {
					loadDataToTable(dsTourDuLich, tblModel);
				}
			}
		}else if(o.equals(btnSearchTinhThanh)) {
			if(txtSearchTinhThanh.getText().trim().equals("")||txtSearchTinhThanh.getText().trim().equals(null)) {
				JOptionPane.showMessageDialog(this, "Vui lòng nhập tỉnh thành cần tìm !");
			} else {
				dsTourDuLich = CtrlTourDuLich.locTourTheoTinhThanh(DAO_TourDuLich.getAllTourDuLich(), txtSearchTinhThanh.getText().trim());
				if(dsTourDuLich.size()==0) {
					JOptionPane.showMessageDialog(this, "Không có dữ liệu phù hợp !");
				} else {
					loadDataToTable(dsTourDuLich, tblModel);
				}
			}
		} else if(o.equals(btnSearchNgayDi)) {
			if(dpkNgayDi.equals(null)) {
				JOptionPane.showMessageDialog(this, "Vui lòng Chọn ngày đi cần tìm !");
			} else {
				// Lấy giá trị ngày tháng được chọn từ JDatePicker
				Date date = (Date) dpkNgayDi.getModel().getValue();
				// Chuyển đổi java.util.Date sang java.time.LocalDate
				LocalDate ngayDi = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
				dsTourDuLich = CtrlTourDuLich.locTourTheoNgayDi(DAO_TourDuLich.getAllTourDuLich(), ngayDi);
				if(dsTourDuLich.size()==0) {
					JOptionPane.showMessageDialog(this, "Không có dữ liệu phù hợp !");
				} else {
					loadDataToTable(dsTourDuLich, tblModel);
				}
			}
		} else if(o.equals(cbxLocTheo)) {
			//"Tất cả tour","Tour sau hôm nay", "Gía Tour giảm dần", "Giá Tour tăng dần", "Tour đã đóng", "Tour đang mở"
			if(cbxLocTheo.getSelectedIndex()==0) {
				loadDataToTable(dsTourDuLich, tblModel);
			} else if(cbxLocTheo.getSelectedIndex()==1) {
				loadDataToTable(CtrlTourDuLich.locTourNgayDiTuNgay(dsTourDuLich, LocalDate.now()), tblModel);
			} else if(cbxLocTheo.getSelectedIndex()==2) {
				loadDataToTable(CtrlTourDuLich.sapXepGiaTourGiam(dsTourDuLich), tblModel);
			}else if(cbxLocTheo.getSelectedIndex()==3) {
				loadDataToTable(CtrlTourDuLich.sapXepGiaTourTang(dsTourDuLich), tblModel);
			}else if(cbxLocTheo.getSelectedIndex()==4) {
				loadDataToTable(CtrlTourDuLich.locTourDaDong(dsTourDuLich), tblModel);
			}else if(cbxLocTheo.getSelectedIndex()==5) {
				loadDataToTable(CtrlTourDuLich.locTourDangMo(dsTourDuLich), tblModel);
			}
		}else {
			JOptionPane.showMessageDialog(this, "Hi");
		}
		
	}

    @Override
    public void mouseClicked(MouseEvent e) {
	// TODO Auto-generated method stub

    }

    @Override
    public void mousePressed(MouseEvent e) {
	// TODO Auto-generated method stub

    }

    @Override
    public void mouseReleased(MouseEvent e) {
	// TODO Auto-generated method stub

    }

    @Override
    public void mouseEntered(MouseEvent e) {
	// TODO Auto-generated method stub

    }

    @Override
    public void mouseExited(MouseEvent e) {
	// TODO Auto-generated method stub

    }
}
