package services;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

import DAO.DAO_TourDuLich;
import entity.TourDuLich;
import utils.constants.ColorConstant;

public class Employee_TourDuLich extends JPanel  implements ActionListener,MouseListener{

    /**
     * 
     */
    private static final long serialVersionUID = 4857724560123557844L;
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnInfo;
    private javax.swing.JButton btnModify;
    private javax.swing.JButton btnSearchDiaDanh;
    private javax.swing.JButton btnSearchMaTour;
    private javax.swing.JButton btnSearchNgayDi;
    private javax.swing.JButton btnSearchThongTin;
    private javax.swing.JComboBox<String> cbxLocTheo;
    private org.jdatepicker.JDatePicker dpkNgayDi;
    private javax.swing.JLabel lblLocTheo;
    private javax.swing.JLabel lblSearchDiaDanh;
    private javax.swing.JLabel lblSearchMaTour;
    private javax.swing.JLabel lblSearchNgayDi;
    private javax.swing.JLabel lblSearchThongTin;
    private javax.swing.JPanel pnAction;
    private javax.swing.JPanel pnData;
    private javax.swing.JPanel pnSearchDiaDanh;
    private javax.swing.JPanel pnSearchMaTour;
    private javax.swing.JPanel pnSearchNgayDi;
    private javax.swing.JPanel pnSearchThongTin;
    private javax.swing.JScrollPane scrData;
    private javax.swing.JTable tblTourDuLich;
    private javax.swing.table.DefaultTableModel tblModel;
    private javax.swing.JTabbedPane tpnSearch;
    private javax.swing.JTextField txtSearchDiaDanh;
    private javax.swing.JTextField txtSearchMaTour;
    private javax.swing.JTextField txtSearchThongTin;
    
    private ArrayList<TourDuLich> dsTourDuLich = new ArrayList<TourDuLich>();

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
	pnSearchDiaDanh = new javax.swing.JPanel();
	lblSearchDiaDanh = new javax.swing.JLabel();
	txtSearchDiaDanh = new javax.swing.JTextField();
	btnSearchDiaDanh = new javax.swing.JButton();
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
	lblSearchMaTour.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
	lblSearchMaTour.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
	lblSearchMaTour.setText("Tìm theo mã Tour :");

	txtSearchMaTour.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

	btnSearchMaTour.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
	btnSearchMaTour.setText("Tìm kiếm");

	lblSearchDiaDanh.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
	lblSearchDiaDanh.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
	lblSearchDiaDanh.setText("Địa danh cần tìm :");

	txtSearchDiaDanh.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

	btnSearchDiaDanh.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
	btnSearchDiaDanh.setText("Tìm Kiếm");

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
	lblLocTheo.setText("Chọn tỉnh thành:");

	scrData.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
	scrData.setViewportView(tblTourDuLich);

	pnAction.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Chọn Tác Vụ",
		javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION,
		new java.awt.Font("Segoe UI", 0, 14))); // NOI18N

	btnInfo.setText("Xem Thông Tin");

	btnAdd.setText("Thêm Tour");

	btnDelete.setText("Xóa Tour");

	btnModify.setText("Sửa Tour");
    }

    private void preset() {
	// TODO Auto-generated method stub
	javax.swing.GroupLayout pnSearchMaTourLayout = new javax.swing.GroupLayout(pnSearchMaTour);
	pnSearchMaTour.setLayout(pnSearchMaTourLayout);
	pnSearchMaTourLayout
		.setHorizontalGroup(pnSearchMaTourLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
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

	tpnSearch.addTab("Tìm theo địa danh", pnSearchDiaDanh);

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
				.addComponent(lblLocTheo).addComponent(cbxLocTheo, javax.swing.GroupLayout.PREFERRED_SIZE,
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
	String[] tinhThanh = {"Hà Nội", "Hồ Chí Minh", "Hải Phòng", "Cần Thơ", "Đà Nẵng", "Hà Giang", "Cao Bằng", "Bắc Kạn", "Lạng Sơn", "Tuyên Quang", "Thái Nguyên", "Yên Bái", "Lào Cai", "Điện Biên", "Lai Châu", "Sơn La", "Hòa Bình", "Thái Bình", "Nam Định", "Ninh Bình", "Thanh Hóa", "Nghệ An", "Hà Tĩnh", "Quảng Bình", "Quảng Trị", "Thừa Thiên Huế", "Quảng Nam", "Quảng Ngãi", "Bình Định", "Phú Yên", "Khánh Hòa", "Ninh Thuận", "Bình Thuận", "Kon Tum", "Gia Lai", "Đắk Lắk", "Đắk Nông", "Lâm Đồng", "Bình Phước", "Tây Ninh", "Bình Dương", "Đồng Nai", "Bà Rịa - Vũng Tàu", "Long An", "Tiền Giang", "Bến Tre", "Trà Vinh", "Vĩnh Long", "Đồng Tháp", "An Giang", "Kiên Giang", "Cần Thơ", "Hậu Giang", "Sóc Trăng", "Bạc Liêu", "Cà Mau", "Điện Biên", "Đăk Nông", "Hà Nam", "Hưng Yên", "Nam Định", "Phú Thọ", "Vĩnh Phúc", "Bắc Giang", "Bắc Ninh", "Hải Dương", "Hải Dương", "Hưng Yên", "Ninh Bình"};
    for(int i=0; i<tinhThanh.length;i++) {
    	cbxLocTheo.addItem(tinhThanh[i]);
    }
	dsTourDuLich = DAO_TourDuLich.getAllTourDuLich();
	loadDataToTable(dsTourDuLich, tblModel);
    }
    
    private void event() {
    	this.btnSearchMaTour.addActionListener(this);
    	this.btnSearchNgayDi.addActionListener(this);
    	this.btnSearchThongTin.addActionListener(this);
    	this.btnSearchDiaDanh.addActionListener(this);
    	this.cbxLocTheo.addActionListener(this);
    	
    	this.btnInfo.addActionListener(this);
    	this.btnAdd.addActionListener(this);
    	this.btnDelete.addActionListener(this);
    	this.btnModify.addActionListener(this);
    	
    	this.tblTourDuLich.addMouseListener(this);
    }
    
    private void loadDataToTable(ArrayList<TourDuLich> dsIn, DefaultTableModel model) {
    	for(TourDuLich tour:dsIn) {
    		addOneRowToTable(tour, model);
    	}
    }
    
    private void addOneRowToTable(TourDuLich tour, DefaultTableModel model) {
    	String trangThai;
    	trangThai = tour.getTrangThaiTour()?"Hoạt động":"Đã đóng";
    	model.addRow(new Object [] {tour.getMaTour(), tour.getTenTour(), tour.getMoTa(), tour.getNgayDi(), tour.getNoiDi(), tour.getSoNgayDuKien(), tour.getGiaTour(), trangThai, tour.getDiaDanh().getTenDiaDanh()});
    }

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
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
