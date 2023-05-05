package services;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import javax.swing.ScrollPaneConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.*;
import javax.swing.text.AbstractDocument;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;

import DAO.DAO_DiaDanh;
import DAO.DAO_TourDuLich;
import controllers.CtrlTourDuLich;
import entity.DiaDanh;
import entity.TourDuLich;
import utils.LoadSave;
import utils.constants.ColorConstant;

/**
 * 
 * @author LE MINH BAO
 */
public class Employee_TourDuLich extends JPanel implements ActionListener {
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
				.addGroup(pnSearchTinhThanhLayout.createSequentialGroup().addContainerGap()
						.addGroup(pnSearchTinhThanhLayout
								.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
								.addGroup(pnSearchTinhThanhLayout
										.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
										.addComponent(txtSearchTinhThanh, javax.swing.GroupLayout.PREFERRED_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addComponent(lblSearchTinhThanh))
								.addComponent(btnSearchTinhThanh, javax.swing.GroupLayout.PREFERRED_SIZE, 0,
										Short.MAX_VALUE))
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
		String[] locTheo = { "Tất cả tour", "Tour sau hôm nay", "Gía Tour giảm dần", "Giá Tour tăng dần",
				"Tour đã đóng", "Tour đang mở" };
		for (int i = 0; i < locTheo.length; i++) {
			cbxLocTheo.addItem(locTheo[i]);
		}
		dsTourDuLich = DAO_TourDuLich.getAllTourDuLich();
		loadDataToTable(dsTourDuLich, tblModel);

		event();
	}

	private void event() {
		// Search
		this.btnSearchMaTour.addActionListener(this);
		this.btnSearchNgayDi.addActionListener(this);
		this.btnSearchThongTin.addActionListener(this);
		this.btnSearchTinhThanh.addActionListener(this);
		this.cbxLocTheo.addActionListener(this);

		// Action
		this.btnInfo.addActionListener(this);
		this.btnAdd.addActionListener(this);
		this.btnDelete.addActionListener(this);
		this.btnModify.addActionListener(this);

		/*
		 * Table
		 * 
		 * 
		 * 
		 */
		this.tblTourDuLich.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent e) {
				// TODO Auto-generated method stub
				// Kiểm tra xem có dòng nào được chọn hay không
				boolean hasSelection = !tblTourDuLich.getSelectionModel().isSelectionEmpty();

				// Đặt giá trị cho thuộc tính enabled của btnInfo tương ứng với hasSelection
				btnInfo.setEnabled(hasSelection);
				btnDelete.setEnabled(hasSelection);
				btnModify.setEnabled(hasSelection);
			}
		});

		/*
		 * shotcut
		 * 
		 * 
		 * 
		 */
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
					int selectedRow = tblTourDuLich.getSelectedRow();

					// Lấy số cột của bảng
					int columnsCount = tblTourDuLich.getColumnCount();

					// Tạo một mảng String để chứa dữ liệu của hàng đang được chọn
					String[] data = new String[columnsCount];

					// Duyệt qua các cột của hàng đang được chọn và lưu giá trị vào mảng data
					for (int i = 0; i < columnsCount; i++) {
						data[i] = tblTourDuLich.getValueAt(selectedRow, i).toString();
					}

					new FrameInfoTourDuLich(data).setVisible(true);
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
					new FrameAddTourDuLich().setVisible(true);
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
						int selectedRow = tblTourDuLich.getSelectedRow();
						String data = tblTourDuLich.getValueAt(selectedRow, 0).toString();

						DAO_TourDuLich.xoaTourDuLich(data);
						tblModel.setRowCount(0);
						loadDataToTable(dsTourDuLich, tblModel);
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
					int selectedRow = tblTourDuLich.getSelectedRow();

					// Lấy số cột của bảng
					int columnsCount = tblTourDuLich.getColumnCount();

					// Tạo một mảng String để chứa dữ liệu của hàng đang được chọn
					String[] data = new String[columnsCount];

					// Duyệt qua các cột của hàng đang được chọn và lưu giá trị vào mảng data
					for (int i = 0; i < columnsCount; i++) {
						data[i] = tblTourDuLich.getValueAt(selectedRow, i).toString();
					}
					new FrameModifyTourDuLich(data).setVisible(true);
				}
			}
		});
	}

	private void loadDataToTable(ArrayList<TourDuLich> dsIn, DefaultTableModel model) {
		model.setRowCount(0);
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
		if (o.equals(btnSearchMaTour)) {
			if (txtSearchMaTour.getText().trim().equals("") || txtSearchMaTour.getText().trim().equals(null)) {
				JOptionPane.showMessageDialog(this, "Vui lòng nhập mã cần tìm !");
			} else {
				dsTourDuLich = CtrlTourDuLich.locTourTheoMaTour(DAO_TourDuLich.getAllTourDuLich(),
						txtSearchMaTour.getText().trim());
				if (dsTourDuLich.size() == 0) {
					JOptionPane.showMessageDialog(this, "Không có dữ liệu phù hợp !");
				} else {
					loadDataToTable(dsTourDuLich, tblModel);
				}
			}
			txtSearchMaTour.setText("");
		} else if (o.equals(btnSearchThongTin)) {
			if (txtSearchThongTin.getText().trim().equals("") || txtSearchThongTin.getText().trim().equals(null)) {
				JOptionPane.showMessageDialog(this, "Vui lòng nhập thông tin cần tìm !");
			} else {
				dsTourDuLich = CtrlTourDuLich.locTourTheoThongTinTour(DAO_TourDuLich.getAllTourDuLich(),
						txtSearchThongTin.getText().trim());
				if (dsTourDuLich.size() == 0) {
					JOptionPane.showMessageDialog(this, "Không có dữ liệu phù hợp !");
				} else {
					loadDataToTable(dsTourDuLich, tblModel);
				}
			}
			txtSearchThongTin.setText("");
		} else if (o.equals(btnSearchTinhThanh)) {
			if (txtSearchTinhThanh.getText().trim().equals("") || txtSearchTinhThanh.getText().trim().equals(null)) {
				JOptionPane.showMessageDialog(this, "Vui lòng nhập tỉnh thành cần tìm !");
			} else {
				dsTourDuLich = CtrlTourDuLich.locTourTheoTinhThanh(DAO_TourDuLich.getAllTourDuLich(),
						txtSearchTinhThanh.getText().trim());
				if (dsTourDuLich.size() == 0) {
					JOptionPane.showMessageDialog(this, "Không có dữ liệu phù hợp !");
				} else {
					loadDataToTable(dsTourDuLich, tblModel);
				}
			}
		} else if (o.equals(btnSearchNgayDi)) {
			if (dpkNgayDi.equals(null)) {
				JOptionPane.showMessageDialog(this, "Vui lòng Chọn ngày đi cần tìm !");
			} else {
				GregorianCalendar calendar = (GregorianCalendar) dpkNgayDi.getModel().getValue();
				Date date = calendar.getTime();
				LocalDate ngayDi = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
				dsTourDuLich = CtrlTourDuLich.locTourTheoNgayDi(DAO_TourDuLich.getAllTourDuLich(), ngayDi);
				if (dsTourDuLich.size() == 0) {
					JOptionPane.showMessageDialog(this, "Không có dữ liệu phù hợp !");
				} else {
					loadDataToTable(dsTourDuLich, tblModel);
				}
			}
		} else if (o.equals(cbxLocTheo)) {
			// "Tất cả tour","Tour sau hôm nay", "Gía Tour giảm dần", "Giá Tour tăng dần",
			// "Tour đã đóng", "Tour đang mở"
			if (cbxLocTheo.getSelectedIndex() == 0) {
				dsTourDuLich = DAO_TourDuLich.getAllTourDuLich();
				loadDataToTable(dsTourDuLich, tblModel);
			} else if (cbxLocTheo.getSelectedIndex() == 1) {
				loadDataToTable(CtrlTourDuLich.locTourNgayDiTuNgay(dsTourDuLich, LocalDate.now()), tblModel);
			} else if (cbxLocTheo.getSelectedIndex() == 2) {
				loadDataToTable(CtrlTourDuLich.sapXepGiaTourGiam(dsTourDuLich), tblModel);
			} else if (cbxLocTheo.getSelectedIndex() == 3) {
				loadDataToTable(CtrlTourDuLich.sapXepGiaTourTang(dsTourDuLich), tblModel);
			} else if (cbxLocTheo.getSelectedIndex() == 4) {
				loadDataToTable(CtrlTourDuLich.locTourDaDong(dsTourDuLich), tblModel);
			} else if (cbxLocTheo.getSelectedIndex() == 5) {
				loadDataToTable(CtrlTourDuLich.locTourDangMo(dsTourDuLich), tblModel);
			}
		} else if (o.equals(btnInfo)) {
			// Lấy chỉ số của hàng đang được chọn
			int selectedRow = tblTourDuLich.getSelectedRow();

			// Lấy số cột của bảng
			int columnsCount = tblTourDuLich.getColumnCount();

			// Tạo một mảng String để chứa dữ liệu của hàng đang được chọn
			String[] data = new String[columnsCount];

			// Duyệt qua các cột của hàng đang được chọn và lưu giá trị vào mảng data
			for (int i = 0; i < columnsCount; i++) {
				data[i] = tblTourDuLich.getValueAt(selectedRow, i).toString();
			}
			new FrameInfoTourDuLich(data).setVisible(true);
		} else if (o.equals(btnAdd)) {
			new FrameAddTourDuLich().setVisible(true);
		} else if (o.equals(btnDelete)) {
			int dialogResult = JOptionPane.showConfirmDialog(null, "Bạn có muốn xóa dữ liệu không?");
			if (dialogResult == JOptionPane.YES_OPTION) {
				// Lấy chỉ số của hàng đang được chọn
				int selectedRow = tblTourDuLich.getSelectedRow();
				String data = tblTourDuLich.getValueAt(selectedRow, 0).toString();

				DAO_TourDuLich.xoaTourDuLich(data);
				tblModel.setRowCount(0);
				dsTourDuLich = DAO_TourDuLich.getAllTourDuLich();
				loadDataToTable(dsTourDuLich, tblModel);
			}
		} else if (o.equals(btnModify)) {
			// Lấy chỉ số của hàng đang được chọn
			int selectedRow = tblTourDuLich.getSelectedRow();

			// Lấy số cột của bảng
			int columnsCount = tblTourDuLich.getColumnCount();

			// Tạo một mảng String để chứa dữ liệu của hàng đang được chọn
			String[] data = new String[columnsCount];

			// Duyệt qua các cột của hàng đang được chọn và lưu giá trị vào mảng data
			for (int i = 0; i < columnsCount; i++) {
				data[i] = tblTourDuLich.getValueAt(selectedRow, i).toString();
			}
			new FrameModifyTourDuLich(data).setVisible(true);
		}
	}

	private class FrameInfoTourDuLich extends JFrame {

		/**
		 * 
		 */
		private static final long serialVersionUID = 318156337806728496L;
		private javax.swing.JLabel lblDiaDanh;
		private javax.swing.JLabel lblGiaTour;
		private javax.swing.JLabel lblMaTour;
		private javax.swing.JLabel lblMoTa;
		private javax.swing.JLabel lblNgayDi;
		private javax.swing.JLabel lblNoiDi;
		private javax.swing.JLabel lblSoNgay;
		private javax.swing.JLabel lblTenTour;
		private javax.swing.JLabel lblTrangThaiTour;
		private javax.swing.JPanel pnInfo;
		private javax.swing.JScrollPane scrMoTa;
		private javax.swing.JTextArea taMoTa;
		private javax.swing.JTextField txtDiaDanh;
		private javax.swing.JTextField txtGiaTour;
		private javax.swing.JTextField txtMaTour;
		private javax.swing.JTextField txtNgayDi;
		private javax.swing.JTextField txtNoiDi;
		private javax.swing.JTextField txtSoNgay;
		private javax.swing.JTextField txtTenTour;
		private javax.swing.JTextField txtTrangThai;

		public FrameInfoTourDuLich(String[] data) {
			this.setTitle("SE Tourist - Thông Tin Tour Du Lịch");
			this.setIconImage(LoadSave.GetSpriteAtlas(LoadSave.LOGO_ICON));
			this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			this.setResizable(false);
			this.setLocationRelativeTo(null);
//		this.setMaximumSize(new java.awt.Dimension(670, 400));
//		this.setMinimumSize(new java.awt.Dimension(670, 400));

			this.init();
			this.style();
			this.preset();
			this.event(data);
		}

		private void init() {
			// TODO Auto-generated method stub
			pnInfo = new javax.swing.JPanel();
			lblMaTour = new javax.swing.JLabel();
			txtMaTour = new javax.swing.JTextField();
			lblTenTour = new javax.swing.JLabel();
			txtTenTour = new javax.swing.JTextField();
			lblNgayDi = new javax.swing.JLabel();
			txtNgayDi = new javax.swing.JTextField();
			lblSoNgay = new javax.swing.JLabel();
			txtSoNgay = new javax.swing.JTextField();
			lblNoiDi = new javax.swing.JLabel();
			txtNoiDi = new javax.swing.JTextField();
			lblDiaDanh = new javax.swing.JLabel();
			txtDiaDanh = new javax.swing.JTextField();
			lblTrangThaiTour = new javax.swing.JLabel();
			txtTrangThai = new javax.swing.JTextField();
			lblGiaTour = new javax.swing.JLabel();
			txtGiaTour = new javax.swing.JTextField();
			lblMoTa = new javax.swing.JLabel();
			scrMoTa = new javax.swing.JScrollPane();
			taMoTa = new javax.swing.JTextArea();
		}

		private void style() {
			// TODO Auto-generated method stub
			pnInfo.setBorder(javax.swing.BorderFactory.createTitledBorder(
					javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED),
					"Thông Tin Tour Du Lịch", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,
					javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 14))); // NOI18N

			lblMaTour.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
			lblMaTour.setText("Mã Tour");

			txtMaTour.setEditable(false);
			txtMaTour.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

			lblTenTour.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
			lblTenTour.setText("Tên Tour");

			txtTenTour.setEditable(false);
			txtTenTour.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

			lblNgayDi.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
			lblNgayDi.setText("Ngày Đi");

			txtNgayDi.setEditable(false);
			txtNgayDi.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

			lblSoNgay.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
			lblSoNgay.setText("Số Ngày");

			txtSoNgay.setEditable(false);
			txtSoNgay.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

			lblNoiDi.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
			lblNoiDi.setText("Nơi Đi");

			txtNoiDi.setEditable(false);
			txtNoiDi.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

			lblDiaDanh.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
			lblDiaDanh.setText("Địa Danh");

			txtDiaDanh.setEditable(false);
			txtDiaDanh.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

			lblTrangThaiTour.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
			lblTrangThaiTour.setText("Trạng Thái Tour");

			txtTrangThai.setEditable(false);
			txtTrangThai.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

			lblGiaTour.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
			lblGiaTour.setText("Giá Tour");

			txtGiaTour.setEditable(false);
			txtGiaTour.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

			lblMoTa.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
			lblMoTa.setText("Mô Tả");

			scrMoTa.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

			taMoTa.setEditable(false);
			taMoTa.setColumns(20);
			taMoTa.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
			taMoTa.setLineWrap(true);
			taMoTa.setRows(5);
			scrMoTa.setViewportView(taMoTa);
		}

		private void preset() {
			// TODO Auto-generated method stub
			javax.swing.GroupLayout pnInfoLayout = new javax.swing.GroupLayout(pnInfo);
			pnInfo.setLayout(pnInfoLayout);
			pnInfoLayout.setHorizontalGroup(pnInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
					.addGroup(pnInfoLayout.createSequentialGroup().addContainerGap().addGroup(pnInfoLayout
							.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
							.addComponent(txtMaTour, javax.swing.GroupLayout.PREFERRED_SIZE, 217,
									javax.swing.GroupLayout.PREFERRED_SIZE)
							.addComponent(lblMaTour).addComponent(lblTenTour).addComponent(lblNgayDi)
							.addComponent(txtTenTour, javax.swing.GroupLayout.PREFERRED_SIZE, 217,
									javax.swing.GroupLayout.PREFERRED_SIZE)
							.addGroup(pnInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
									.addComponent(lblSoNgay, javax.swing.GroupLayout.Alignment.LEADING)
									.addComponent(txtSoNgay, javax.swing.GroupLayout.PREFERRED_SIZE, 217,
											javax.swing.GroupLayout.PREFERRED_SIZE))
							.addGroup(pnInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
									.addComponent(lblGiaTour, javax.swing.GroupLayout.Alignment.LEADING)
									.addComponent(txtGiaTour, javax.swing.GroupLayout.PREFERRED_SIZE, 217,
											javax.swing.GroupLayout.PREFERRED_SIZE))
							.addComponent(txtNgayDi, javax.swing.GroupLayout.PREFERRED_SIZE, 217,
									javax.swing.GroupLayout.PREFERRED_SIZE))
							.addGap(33, 33, 33)
							.addGroup(
									pnInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
											.addComponent(txtDiaDanh).addComponent(scrMoTa).addComponent(txtNoiDi)
											.addGroup(pnInfoLayout.createSequentialGroup().addGroup(pnInfoLayout
													.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
													.addComponent(lblMoTa).addComponent(lblTrangThaiTour)
													.addComponent(lblNoiDi).addComponent(lblDiaDanh))
													.addGap(0, 0, Short.MAX_VALUE))
											.addComponent(txtTrangThai))
							.addContainerGap()));
			pnInfoLayout.setVerticalGroup(pnInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
					.addGroup(pnInfoLayout.createSequentialGroup().addContainerGap()
							.addGroup(pnInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
									.addGroup(pnInfoLayout.createSequentialGroup()
											.addGroup(pnInfoLayout
													.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
													.addComponent(lblMaTour).addComponent(lblNoiDi))
											.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
											.addGroup(pnInfoLayout
													.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
													.addComponent(txtMaTour, javax.swing.GroupLayout.PREFERRED_SIZE,
															javax.swing.GroupLayout.DEFAULT_SIZE,
															javax.swing.GroupLayout.PREFERRED_SIZE)
													.addComponent(txtNoiDi, javax.swing.GroupLayout.PREFERRED_SIZE,
															javax.swing.GroupLayout.DEFAULT_SIZE,
															javax.swing.GroupLayout.PREFERRED_SIZE))
											.addGap(6, 6, 6).addComponent(lblTenTour)
											.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
											.addComponent(txtTenTour, javax.swing.GroupLayout.PREFERRED_SIZE,
													javax.swing.GroupLayout.DEFAULT_SIZE,
													javax.swing.GroupLayout.PREFERRED_SIZE))
									.addGroup(pnInfoLayout.createSequentialGroup().addComponent(lblDiaDanh)
											.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
											.addComponent(txtDiaDanh, javax.swing.GroupLayout.PREFERRED_SIZE,
													javax.swing.GroupLayout.DEFAULT_SIZE,
													javax.swing.GroupLayout.PREFERRED_SIZE)))
							.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
							.addGroup(pnInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
									.addComponent(lblNgayDi).addComponent(lblTrangThaiTour))
							.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
							.addGroup(pnInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
									.addComponent(txtNgayDi, javax.swing.GroupLayout.PREFERRED_SIZE,
											javax.swing.GroupLayout.DEFAULT_SIZE,
											javax.swing.GroupLayout.PREFERRED_SIZE)
									.addComponent(txtTrangThai, javax.swing.GroupLayout.PREFERRED_SIZE,
											javax.swing.GroupLayout.DEFAULT_SIZE,
											javax.swing.GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
							.addGroup(pnInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
									.addComponent(lblSoNgay).addComponent(lblMoTa))
							.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
							.addGroup(pnInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
									.addGroup(pnInfoLayout.createSequentialGroup()
											.addComponent(txtSoNgay, javax.swing.GroupLayout.PREFERRED_SIZE,
													javax.swing.GroupLayout.DEFAULT_SIZE,
													javax.swing.GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
											.addComponent(lblGiaTour)
											.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
											.addComponent(txtGiaTour, javax.swing.GroupLayout.PREFERRED_SIZE,
													javax.swing.GroupLayout.DEFAULT_SIZE,
													javax.swing.GroupLayout.PREFERRED_SIZE))
									.addComponent(scrMoTa, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
							.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

			javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
			getContentPane().setLayout(layout);
			layout.setHorizontalGroup(
					layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
							.addGap(0, 540, Short.MAX_VALUE)
							.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
									.addGroup(layout.createSequentialGroup().addContainerGap()
											.addComponent(pnInfo, javax.swing.GroupLayout.DEFAULT_SIZE,
													javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
											.addContainerGap())));
			layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
					.addGap(0, 336, Short.MAX_VALUE)
					.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout
							.createSequentialGroup().addContainerGap()
							.addComponent(pnInfo, javax.swing.GroupLayout.PREFERRED_SIZE,
									javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
							.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))));

			pack();
		}

		private void event(String[] data) {
			// TODO Auto-generated method stub
			txtMaTour.setText(data[0]);
			txtTenTour.setText(data[1]);
			taMoTa.setText(data[2]);
			txtNgayDi.setText(data[3]);
			txtNoiDi.setText(data[4]);
			txtSoNgay.setText(data[5]);
			txtGiaTour.setText(data[6]);
			txtTrangThai.setText(data[7]);
			txtDiaDanh.setText(data[8]);
		}

	}

	private class FrameAddTourDuLich extends JFrame implements ActionListener {

		/**
		 * 
		 */
		private static final long serialVersionUID = 1056081906700611874L;
		private javax.swing.JButton btnAdd;
		private javax.swing.JButton btnCancel;
		private javax.swing.JComboBox<String> cbxNoiDi;
		private javax.swing.JComboBox<String> cbxTrangThaiTour;
		private org.jdatepicker.JDatePicker dpkNgayDi;
		private javax.swing.JLabel lblDiaDanh;
		private javax.swing.JLabel lblGiaTour;
		private javax.swing.JLabel lblMaTour;
		private javax.swing.JLabel lblMoTa;
		private javax.swing.JLabel lblNgayDi;
		private javax.swing.JLabel lblNoiDi;
		private javax.swing.JLabel lblSoNgay;
		private javax.swing.JLabel lblTenTour;
		private javax.swing.JLabel lblTrangThaiTour;
		private javax.swing.JPanel pnAction;
		private javax.swing.JPanel pnDiaDanh;
		private javax.swing.JPanel pnInfo;
		private javax.swing.JScrollPane scrDiaDanh;
		private javax.swing.JScrollPane scrMoTa;
		private javax.swing.JTextArea taMoTa;
		private javax.swing.table.DefaultTableModel tblModelDiaDanh;
		private javax.swing.JTable tblDiaDanh;
		private javax.swing.JTextField txtDiaDanh;
		private javax.swing.JTextField txtGiaTour;
		private javax.swing.JTextField txtMaTour;
		private javax.swing.JTextField txtSoNgay;
		private javax.swing.JTextField txtTenTour;

		public FrameAddTourDuLich() {
			this.setTitle("SE Tourist - Thêm Tour Du Lịch");
			this.setIconImage(LoadSave.GetSpriteAtlas(LoadSave.LOGO_ICON));
			this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			this.setResizable(false);
			this.setLocationRelativeTo(null);
//		this.setMaximumSize(new java.awt.Dimension(670, 400));
//		this.setMinimumSize(new java.awt.Dimension(670, 400));

			this.init();
			this.style();
			this.preset();
			this.event();
			this.loadData();
		}

		private void init() {
			// TODO Auto-generated method stub
			pnInfo = new javax.swing.JPanel();
			lblMaTour = new javax.swing.JLabel();
			txtMaTour = new javax.swing.JTextField();
			lblTenTour = new javax.swing.JLabel();
			txtTenTour = new javax.swing.JTextField();
			lblNgayDi = new javax.swing.JLabel();
			dpkNgayDi = new org.jdatepicker.JDatePicker();
			lblSoNgay = new javax.swing.JLabel();
			txtSoNgay = new javax.swing.JTextField();
			lblNoiDi = new javax.swing.JLabel();
			cbxNoiDi = new javax.swing.JComboBox<>();
			lblDiaDanh = new javax.swing.JLabel();
			txtDiaDanh = new javax.swing.JTextField();
			lblTrangThaiTour = new javax.swing.JLabel();
			cbxTrangThaiTour = new javax.swing.JComboBox<>();
			lblGiaTour = new javax.swing.JLabel();
			txtGiaTour = new javax.swing.JTextField();
			lblMoTa = new javax.swing.JLabel();
			scrMoTa = new javax.swing.JScrollPane();
			taMoTa = new javax.swing.JTextArea();
			pnDiaDanh = new javax.swing.JPanel();
			scrDiaDanh = new javax.swing.JScrollPane();
			{
				String[] cols = new DiaDanh().getTitle().split(";");
				tblModelDiaDanh = new javax.swing.table.DefaultTableModel(cols, 0);
				tblDiaDanh = new javax.swing.JTable(tblModelDiaDanh);
			}
			pnAction = new javax.swing.JPanel();
			btnAdd = new javax.swing.JButton();
			btnCancel = new javax.swing.JButton();
		}

		private void style() {
			// TODO Auto-generated method stub
			pnInfo.setBorder(javax.swing.BorderFactory.createTitledBorder(
					javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED),
					"Thông Tin Tour Du Lịch", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,
					javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 14))); // NOI18N

			lblMaTour.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
			lblMaTour.setText("Mã Tour");

			txtMaTour.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

			lblTenTour.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
			lblTenTour.setText("Tên Tour");

			txtTenTour.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

			lblNgayDi.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
			lblNgayDi.setText("Ngày Đi");

			lblSoNgay.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
			lblSoNgay.setText("Số Ngày");

			// Tạo một DocumentFilter để kiểm tra dữ liệu đầu vào
			DocumentFilter filter = new DocumentFilter() {
				public void insertString(FilterBypass fb, int offset, String string, AttributeSet attr)
						throws BadLocationException {
					// Chỉ cho phép chèn chữ số dương
					if (string.matches("\\d+")) {
						super.insertString(fb, offset, string, attr);
					}
				}

				@Override
				public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs)
						throws BadLocationException {
					// Chỉ cho phép thay thế bằng chữ số dương
					if (text.matches("\\d+")) {
						super.replace(fb, offset, length, text, attrs);
					}
				}
			};

			// Áp dụng DocumentFilter cho JTextField
			((AbstractDocument) txtSoNgay.getDocument()).setDocumentFilter(filter);
			txtSoNgay.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

			lblNoiDi.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
			lblNoiDi.setText("Noi Di");

			cbxNoiDi.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
			cbxNoiDi.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "An Giang", "Bà Rịa – Vũng Tàu",
					"Bắc Giang", "Bắc Kạn", "Bạc Liêu", "Bắc Ninh", "Bến Tre", "Bình Định", "Bình Dương", "Bình Phước",
					"Bình Thuận", "Cà Mau", "Cần Thơ", "Cao Bằng", "Đà Nẵng", "Đắk Lắk", "Đắk Nông", "Điện Biên",
					"Đồng Nai", "Đồng Tháp", "Gia Lai", "Hà Giang", "Hà Nam", "Hà Nội", "Hà Tĩnh", "Hải Dương",
					"Hải Phòng", "Hậu Giang", "Hòa Bình", "Hưng Yên", "Khánh Hòa", "Kiên Giang", "Kon Tum", "Lai Châu",
					"Lâm Đồng", "Lạng Sơn", "Lào Cai", "Long An", "Nam Định", "Nghệ An", "Ninh Bình", "Ninh Thuận",
					"Phú Thọ", "Phú Yên", "Quảng Bình", "Quảng Nam", "Quảng Ngãi", "Quảng Ninh", "Quảng Trị",
					"Sóc Trăng", "Sơn La", "Tây Ninh", "Thái Bình", "Thái Nguyên", "Thanh Hóa", "Thừa Thiên Huế",
					"Tiền Giang", "Thành phố Hồ Chí Minh", "Trà Vinh", "Tuyên Quang", "Vĩnh Long", "Vĩnh Phúc",
					"Yên Bái" }));

			lblDiaDanh.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
			lblDiaDanh.setText("Địa Danh");

			txtDiaDanh.setEditable(false);
			txtDiaDanh.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

			lblTrangThaiTour.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
			lblTrangThaiTour.setText("Trạng Thái Tour");

			cbxTrangThaiTour.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
			cbxTrangThaiTour.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Đã đóng", "Đang mở" }));

			lblGiaTour.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
			lblGiaTour.setText("Giá Tour");

			((AbstractDocument) txtGiaTour.getDocument()).setDocumentFilter(filter);
			txtGiaTour.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

			lblMoTa.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
			lblMoTa.setText("Mô Tả");

			taMoTa.setColumns(20);
			taMoTa.setRows(5);
			taMoTa.setLineWrap(true);
			scrMoTa.setViewportView(taMoTa);

			pnDiaDanh.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Chọn Địa Danh",
					javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,
					javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 14))); // NOI18N

			scrDiaDanh.setViewportView(tblDiaDanh);
			scrDiaDanh.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

			pnAction.setBorder(javax.swing.BorderFactory.createTitledBorder(
					new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED), "Chọn Tác Vụ",
					javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,
					javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 14))); // NOI18N

			btnAdd.setBackground(new java.awt.Color(0, 255, 0));
			btnAdd.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
			btnAdd.setForeground(new java.awt.Color(255, 255, 255));
			btnAdd.setText("Thêm Tour Du Lịch");

			btnCancel.setBackground(new java.awt.Color(255, 0, 0));
			btnCancel.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
			btnCancel.setForeground(new java.awt.Color(255, 255, 255));
			btnCancel.setText("Hủy");
		}

		private void preset() {
			// TODO Auto-generated method stub
			javax.swing.GroupLayout pnInfoLayout = new javax.swing.GroupLayout(pnInfo);
			pnInfo.setLayout(pnInfoLayout);
			pnInfoLayout.setHorizontalGroup(pnInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
					.addGroup(pnInfoLayout.createSequentialGroup().addContainerGap().addGroup(pnInfoLayout
							.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
							.addComponent(dpkNgayDi, javax.swing.GroupLayout.PREFERRED_SIZE, 217,
									javax.swing.GroupLayout.PREFERRED_SIZE)
							.addComponent(txtMaTour, javax.swing.GroupLayout.PREFERRED_SIZE, 217,
									javax.swing.GroupLayout.PREFERRED_SIZE)
							.addComponent(lblMaTour).addComponent(lblTenTour).addComponent(lblNgayDi)
							.addComponent(txtTenTour, javax.swing.GroupLayout.PREFERRED_SIZE, 217,
									javax.swing.GroupLayout.PREFERRED_SIZE)
							.addGroup(pnInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
									.addComponent(lblSoNgay, javax.swing.GroupLayout.Alignment.LEADING)
									.addComponent(txtSoNgay, javax.swing.GroupLayout.PREFERRED_SIZE, 217,
											javax.swing.GroupLayout.PREFERRED_SIZE))
							.addGroup(pnInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
									.addComponent(lblGiaTour, javax.swing.GroupLayout.Alignment.LEADING)
									.addComponent(txtGiaTour, javax.swing.GroupLayout.PREFERRED_SIZE, 217,
											javax.swing.GroupLayout.PREFERRED_SIZE)))
							.addGap(33, 33, 33)
							.addGroup(pnInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
									.addComponent(cbxNoiDi, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(txtDiaDanh)
									.addComponent(cbxTrangThaiTour, 0, javax.swing.GroupLayout.DEFAULT_SIZE,
											Short.MAX_VALUE)
									.addComponent(lblMoTa).addComponent(lblTrangThaiTour).addComponent(lblNoiDi)
									.addComponent(lblDiaDanh).addComponent(scrMoTa,
											javax.swing.GroupLayout.PREFERRED_SIZE,
											javax.swing.GroupLayout.DEFAULT_SIZE,
											javax.swing.GroupLayout.PREFERRED_SIZE))
							.addContainerGap()));
			pnInfoLayout.setVerticalGroup(pnInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
					.addGroup(pnInfoLayout.createSequentialGroup().addContainerGap()
							.addGroup(pnInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
									.addGroup(pnInfoLayout.createSequentialGroup()
											.addGroup(pnInfoLayout
													.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
													.addComponent(lblMaTour).addComponent(lblNoiDi))
											.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
											.addGroup(pnInfoLayout
													.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING,
															false)
													.addComponent(txtMaTour, javax.swing.GroupLayout.PREFERRED_SIZE,
															javax.swing.GroupLayout.DEFAULT_SIZE,
															javax.swing.GroupLayout.PREFERRED_SIZE)
													.addComponent(cbxNoiDi))
											.addGap(6, 6, 6).addComponent(lblTenTour)
											.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
											.addComponent(txtTenTour, javax.swing.GroupLayout.PREFERRED_SIZE,
													javax.swing.GroupLayout.DEFAULT_SIZE,
													javax.swing.GroupLayout.PREFERRED_SIZE))
									.addGroup(pnInfoLayout.createSequentialGroup().addComponent(lblDiaDanh)
											.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
											.addComponent(txtDiaDanh, javax.swing.GroupLayout.PREFERRED_SIZE,
													javax.swing.GroupLayout.DEFAULT_SIZE,
													javax.swing.GroupLayout.PREFERRED_SIZE)))
							.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
							.addGroup(pnInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
									.addComponent(lblNgayDi).addComponent(lblTrangThaiTour))
							.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
							.addGroup(pnInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
									.addComponent(dpkNgayDi, javax.swing.GroupLayout.PREFERRED_SIZE,
											javax.swing.GroupLayout.DEFAULT_SIZE,
											javax.swing.GroupLayout.PREFERRED_SIZE)
									.addComponent(cbxTrangThaiTour, javax.swing.GroupLayout.PREFERRED_SIZE,
											javax.swing.GroupLayout.DEFAULT_SIZE,
											javax.swing.GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
							.addGroup(pnInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
									.addComponent(lblSoNgay).addComponent(lblMoTa))
							.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
							.addGroup(pnInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
									.addGroup(pnInfoLayout.createSequentialGroup()
											.addComponent(txtSoNgay, javax.swing.GroupLayout.PREFERRED_SIZE,
													javax.swing.GroupLayout.DEFAULT_SIZE,
													javax.swing.GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
											.addComponent(lblGiaTour)
											.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
											.addComponent(txtGiaTour, javax.swing.GroupLayout.PREFERRED_SIZE,
													javax.swing.GroupLayout.DEFAULT_SIZE,
													javax.swing.GroupLayout.PREFERRED_SIZE))
									.addComponent(scrMoTa, javax.swing.GroupLayout.PREFERRED_SIZE,
											javax.swing.GroupLayout.DEFAULT_SIZE,
											javax.swing.GroupLayout.PREFERRED_SIZE))
							.addContainerGap(12, Short.MAX_VALUE)));

			pnInfoLayout.linkSize(javax.swing.SwingConstants.VERTICAL,
					new java.awt.Component[] { cbxNoiDi, txtMaTour });

			javax.swing.GroupLayout pnDiaDanhLayout = new javax.swing.GroupLayout(pnDiaDanh);
			pnDiaDanh.setLayout(pnDiaDanhLayout);
			pnDiaDanhLayout.setHorizontalGroup(pnDiaDanhLayout
					.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
					.addGroup(pnDiaDanhLayout.createSequentialGroup().addContainerGap()
							.addComponent(scrDiaDanh, javax.swing.GroupLayout.DEFAULT_SIZE, 409, Short.MAX_VALUE)
							.addContainerGap()));
			pnDiaDanhLayout.setVerticalGroup(pnDiaDanhLayout
					.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
					.addGroup(pnDiaDanhLayout.createSequentialGroup()
							.addComponent(scrDiaDanh, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
							.addContainerGap()));
			javax.swing.GroupLayout pnActionLayout = new javax.swing.GroupLayout(pnAction);
			pnAction.setLayout(pnActionLayout);
			pnActionLayout
					.setHorizontalGroup(pnActionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
							.addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
									pnActionLayout.createSequentialGroup().addContainerGap()
											.addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 234,
													javax.swing.GroupLayout.PREFERRED_SIZE)
											.addGap(18, 18, 18)
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
							.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
									.addComponent(pnInfo, javax.swing.GroupLayout.DEFAULT_SIZE,
											javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(pnAction, javax.swing.GroupLayout.DEFAULT_SIZE,
											javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
							.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
							.addComponent(pnDiaDanh, javax.swing.GroupLayout.DEFAULT_SIZE,
									javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addContainerGap()));
			layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
					.addGroup(layout.createSequentialGroup().addContainerGap()
							.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
									.addGroup(layout.createSequentialGroup()
											.addComponent(pnInfo, javax.swing.GroupLayout.PREFERRED_SIZE,
													javax.swing.GroupLayout.DEFAULT_SIZE,
													javax.swing.GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8,
													Short.MAX_VALUE)
											.addComponent(pnAction, javax.swing.GroupLayout.PREFERRED_SIZE,
													javax.swing.GroupLayout.DEFAULT_SIZE,
													javax.swing.GroupLayout.PREFERRED_SIZE))
									.addComponent(pnDiaDanh, javax.swing.GroupLayout.DEFAULT_SIZE,
											javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
							.addContainerGap()));

			pack();
		}

		private void event() {
			// TODO Auto-generated method stub
			this.btnAdd.addActionListener(this);
			this.btnCancel.addActionListener(this);

			this.tblDiaDanh.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
				@Override
				public void valueChanged(ListSelectionEvent e) {
					// Kiểm tra xem có dòng nào được chọn hay không
					boolean hasSelection = !tblDiaDanh.getSelectionModel().isSelectionEmpty();

					// Nếu có dòng được chọn thì lấy giá trị ô số 0 của dòng đó
					if (hasSelection) {
						int rowIndex = tblDiaDanh.getSelectedRow();
						String value = tblDiaDanh.getValueAt(rowIndex, 0).toString();
						// Thêm giá trị của ô số 0 vào textfield tương ứng
						txtDiaDanh.setText(value);
					}
				}
			});
		}

		private void loadData() {
			// TODO Auto-generated method stub
			ArrayList<DiaDanh> dsdd = DAO_DiaDanh.getAllDiaDanh();

			for (DiaDanh diaDanh : dsdd) {
				String[] data = diaDanh.toString().split(";");

				tblModelDiaDanh.addRow(data);
			}
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			Object o = e.getSource();
			if (o.equals(btnCancel)) {
				this.dispose();
			}

			if (o.equals(btnAdd)) {
				// Lấy ngày tháng được chọn từ JDatePicker
				Calendar selectedDate = (Calendar) dpkNgayDi.getModel().getValue();

				LocalDate localDate = LocalDate.of(selectedDate.get(Calendar.YEAR),
						selectedDate.get(Calendar.MONTH) + 1, selectedDate.get(Calendar.DAY_OF_MONTH));

				boolean status = false;
				if (cbxTrangThaiTour.getSelectedIndex() == 0)
					status = true;

				TourDuLich newTour = new TourDuLich(txtMaTour.getText(), txtTenTour.getText(), taMoTa.getText(),
						localDate, cbxNoiDi.getSelectedItem().toString(), Integer.parseInt(txtSoNgay.getText()),
						Float.parseFloat(txtGiaTour.getText()), status, DAO_DiaDanh.timDiaDanh(txtDiaDanh.getText()));

				if (DAO_TourDuLich.themTourDuLich(newTour)) {
					JOptionPane.showInternalMessageDialog(null, "Thêm Thành Công");
					tblModel.setRowCount(0);
					dsTourDuLich = DAO_TourDuLich.getAllTourDuLich();
					loadDataToTable(dsTourDuLich, tblModel);
					this.dispose();
				} else {
					JOptionPane.showInternalMessageDialog(null, "Thêm Tour Thất Bại", "Lỗi", JOptionPane.ERROR_MESSAGE);
					this.dispose();
				}
			}
		}
	}

	private class FrameModifyTourDuLich extends JFrame implements ActionListener {

		/**
		 * 
		 */
		private static final long serialVersionUID = -2349217886841155087L;
		private javax.swing.JButton btnCancel;
		private javax.swing.JButton btnModify;
		private javax.swing.JComboBox<String> cbxNoiDi;
		private javax.swing.JComboBox<String> cbxTrangThaiTour;
		private org.jdatepicker.JDatePicker dpkNgayDi;
		private javax.swing.JLabel lblDiaDanh;
		private javax.swing.JLabel lblGiaTour;
		private javax.swing.JLabel lblMaTour;
		private javax.swing.JLabel lblMoTa;
		private javax.swing.JLabel lblNgayDi;
		private javax.swing.JLabel lblNoiDi;
		private javax.swing.JLabel lblSoNgay;
		private javax.swing.JLabel lblTenTour;
		private javax.swing.JLabel lblTrangThaiTour;
		private javax.swing.JPanel pnAction;
		private javax.swing.JPanel pnDiaDanh;
		private javax.swing.JPanel pnInfo;
		private javax.swing.JScrollPane scrDiaDanh;
		private javax.swing.JScrollPane scrMoTa;
		private javax.swing.JTextArea taMoTa;
		private javax.swing.table.DefaultTableModel tblModelDiaDanh;
		private javax.swing.JTable tblDiaDanh;
		private javax.swing.JTextField txtDiaDanh;
		private javax.swing.JTextField txtGiaTour;
		private javax.swing.JTextField txtMaTour;
		private javax.swing.JTextField txtSoNgay;
		private javax.swing.JTextField txtTenTour;

		public FrameModifyTourDuLich(String[] data) {
			this.setTitle("SE Tourist - Chỉnh Sửa Tour Du Lịch");
			this.setIconImage(LoadSave.GetSpriteAtlas(LoadSave.LOGO_ICON));
			this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			this.setResizable(false);
			this.setLocationRelativeTo(null);
//		this.setMaximumSize(new java.awt.Dimension(670, 400));
//		this.setMinimumSize(new java.awt.Dimension(670, 400));

			this.init();
			this.style();
			this.preset();
			this.event(data);
			this.loadData();
		}

		private void init() {
			// TODO Auto-generated method stub
			pnInfo = new javax.swing.JPanel();
			lblMaTour = new javax.swing.JLabel();
			txtMaTour = new javax.swing.JTextField();
			lblTenTour = new javax.swing.JLabel();
			txtTenTour = new javax.swing.JTextField();
			lblNgayDi = new javax.swing.JLabel();
			dpkNgayDi = new org.jdatepicker.JDatePicker();
			lblSoNgay = new javax.swing.JLabel();
			txtSoNgay = new javax.swing.JTextField();
			lblNoiDi = new javax.swing.JLabel();
			cbxNoiDi = new javax.swing.JComboBox<>();
			lblDiaDanh = new javax.swing.JLabel();
			txtDiaDanh = new javax.swing.JTextField();
			lblTrangThaiTour = new javax.swing.JLabel();
			cbxTrangThaiTour = new javax.swing.JComboBox<>();
			lblGiaTour = new javax.swing.JLabel();
			txtGiaTour = new javax.swing.JTextField();
			lblMoTa = new javax.swing.JLabel();
			scrMoTa = new javax.swing.JScrollPane();
			taMoTa = new javax.swing.JTextArea();
			pnDiaDanh = new javax.swing.JPanel();
			scrDiaDanh = new javax.swing.JScrollPane();
			{
				String[] cols = new DiaDanh().getTitle().split(";");
				tblModelDiaDanh = new javax.swing.table.DefaultTableModel(cols, 0);
				tblDiaDanh = new javax.swing.JTable(tblModelDiaDanh);
			}
			pnAction = new javax.swing.JPanel();
			btnModify = new javax.swing.JButton();
			btnCancel = new javax.swing.JButton();
		}

		private void style() {
			// TODO Auto-generated method stub
			pnInfo.setBorder(javax.swing.BorderFactory.createTitledBorder(
					javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED),
					"Thông Tin Tour Du Lịch", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,
					javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 14))); // NOI18N

			lblMaTour.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
			lblMaTour.setText("Mã Tour");

			txtMaTour.setEditable(false);
			txtMaTour.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

			lblTenTour.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
			lblTenTour.setText("Tên Tour");

			txtTenTour.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

			lblNgayDi.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
			lblNgayDi.setText("Ngày Đi");

			lblSoNgay.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
			lblSoNgay.setText("Số Ngày");

			// Tạo một DocumentFilter để kiểm tra dữ liệu đầu vào
			DocumentFilter filter = new DocumentFilter() {
				public void insertString(FilterBypass fb, int offset, String string, AttributeSet attr)
						throws BadLocationException {
					// Chỉ cho phép chèn chữ số dương
					if (string.matches("\\d+")) {
						super.insertString(fb, offset, string, attr);
					}
				}

				@Override
				public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs)
						throws BadLocationException {
					// Chỉ cho phép thay thế bằng chữ số dương
					if (text.matches("\\d+")) {
						super.replace(fb, offset, length, text, attrs);
					}
				}
			};

			// Áp dụng DocumentFilter cho JTextField
			((AbstractDocument) txtSoNgay.getDocument()).setDocumentFilter(filter);
			txtSoNgay.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

			lblNoiDi.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
			lblNoiDi.setText("Nơi Đi");

			cbxNoiDi.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
			cbxNoiDi.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "An Giang", "Bà Rịa – Vũng Tàu",
					"Bắc Giang", "Bắc Kạn", "Bạc Liêu", "Bắc Ninh", "Bến Tre", "Bình Định", "Bình Dương", "Bình Phước",
					"Bình Thuận", "Cà Mau", "Cần Thơ", "Cao Bằng", "Đà Nẵng", "Đắk Lắk", "Đắk Nông", "Điện Biên",
					"Đồng Nai", "Đồng Tháp", "Gia Lai", "Hà Giang", "Hà Nam", "Hà Nội", "Hà Tĩnh", "Hải Dương",
					"Hải Phòng", "Hậu Giang", "Hòa Bình", "Hưng Yên", "Khánh Hòa", "Kiên Giang", "Kon Tum", "Lai Châu",
					"Lâm Đồng", "Lạng Sơn", "Lào Cai", "Long An", "Nam Định", "Nghệ An", "Ninh Bình", "Ninh Thuận",
					"Phú Thọ", "Phú Yên", "Quảng Bình", "Quảng Nam", "Quảng Ngãi", "Quảng Ninh", "Quảng Trị",
					"Sóc Trăng", "Sơn La", "Tây Ninh", "Thái Bình", "Thái Nguyên", "Thanh Hóa", "Thừa Thiên Huế",
					"Tiền Giang", "Thành phố Hồ Chí Minh", "Trà Vinh", "Tuyên Quang", "Vĩnh Long", "Vĩnh Phúc",
					"Yên Bái" }));

			lblDiaDanh.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
			lblDiaDanh.setText("Địa Danh");

			txtDiaDanh.setEditable(false);
			txtDiaDanh.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

			lblTrangThaiTour.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
			lblTrangThaiTour.setText("Trang Thai Tour");

			cbxTrangThaiTour.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
			cbxTrangThaiTour.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Đã đóng", "Đang mở" }));

			lblGiaTour.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
			lblGiaTour.setText("Giá Tour");

			((AbstractDocument) txtGiaTour.getDocument()).setDocumentFilter(filter);
			txtGiaTour.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

			lblMoTa.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
			lblMoTa.setText("Mô Tả");

			taMoTa.setColumns(20);
			taMoTa.setLineWrap(true);
			taMoTa.setRows(5);
			taMoTa.setWrapStyleWord(true);
			scrMoTa.setViewportView(taMoTa);

			pnDiaDanh.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Chọn Địa Danh",
					javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,
					javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 14))); // NOI18N

			scrDiaDanh.setViewportView(tblDiaDanh);

			pnAction.setBorder(javax.swing.BorderFactory.createTitledBorder(
					new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED), "Chọn Tác Vụ",
					javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,
					javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 14))); // NOI18N

			btnModify.setBackground(new java.awt.Color(0, 255, 0));
			btnModify.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
			btnModify.setForeground(new java.awt.Color(255, 255, 255));
			btnModify.setText("Thay Đổi Tour Du Lịch");

			btnCancel.setBackground(new java.awt.Color(255, 0, 0));
			btnCancel.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
			btnCancel.setForeground(new java.awt.Color(255, 255, 255));
			btnCancel.setText("Hủy");
		}

		private void preset() {
			// TODO Auto-generated method stub
			javax.swing.GroupLayout pnInfoLayout = new javax.swing.GroupLayout(pnInfo);
			pnInfo.setLayout(pnInfoLayout);
			pnInfoLayout.setHorizontalGroup(pnInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
					.addGroup(pnInfoLayout.createSequentialGroup().addContainerGap().addGroup(pnInfoLayout
							.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
							.addComponent(dpkNgayDi, javax.swing.GroupLayout.PREFERRED_SIZE, 217,
									javax.swing.GroupLayout.PREFERRED_SIZE)
							.addComponent(txtMaTour, javax.swing.GroupLayout.PREFERRED_SIZE, 217,
									javax.swing.GroupLayout.PREFERRED_SIZE)
							.addComponent(lblMaTour).addComponent(lblTenTour).addComponent(lblNgayDi)
							.addComponent(txtTenTour, javax.swing.GroupLayout.PREFERRED_SIZE, 217,
									javax.swing.GroupLayout.PREFERRED_SIZE)
							.addGroup(pnInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
									.addComponent(lblSoNgay, javax.swing.GroupLayout.Alignment.LEADING)
									.addComponent(txtSoNgay, javax.swing.GroupLayout.PREFERRED_SIZE, 217,
											javax.swing.GroupLayout.PREFERRED_SIZE))
							.addGroup(pnInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
									.addComponent(lblGiaTour, javax.swing.GroupLayout.Alignment.LEADING)
									.addComponent(txtGiaTour, javax.swing.GroupLayout.PREFERRED_SIZE, 217,
											javax.swing.GroupLayout.PREFERRED_SIZE)))
							.addGap(33, 33, 33)
							.addGroup(pnInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
									.addComponent(cbxNoiDi, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(txtDiaDanh)
									.addComponent(cbxTrangThaiTour, 0, javax.swing.GroupLayout.DEFAULT_SIZE,
											Short.MAX_VALUE)
									.addComponent(lblMoTa).addComponent(lblTrangThaiTour).addComponent(lblNoiDi)
									.addComponent(lblDiaDanh).addComponent(scrMoTa,
											javax.swing.GroupLayout.PREFERRED_SIZE,
											javax.swing.GroupLayout.DEFAULT_SIZE,
											javax.swing.GroupLayout.PREFERRED_SIZE))
							.addContainerGap()));
			pnInfoLayout.setVerticalGroup(pnInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
					.addGroup(pnInfoLayout.createSequentialGroup().addContainerGap()
							.addGroup(pnInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
									.addGroup(pnInfoLayout.createSequentialGroup()
											.addGroup(pnInfoLayout
													.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
													.addComponent(lblMaTour).addComponent(lblNoiDi))
											.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
											.addGroup(pnInfoLayout
													.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING,
															false)
													.addComponent(txtMaTour, javax.swing.GroupLayout.PREFERRED_SIZE,
															javax.swing.GroupLayout.DEFAULT_SIZE,
															javax.swing.GroupLayout.PREFERRED_SIZE)
													.addComponent(cbxNoiDi))
											.addGap(6, 6, 6).addComponent(lblTenTour)
											.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
											.addComponent(txtTenTour, javax.swing.GroupLayout.PREFERRED_SIZE,
													javax.swing.GroupLayout.DEFAULT_SIZE,
													javax.swing.GroupLayout.PREFERRED_SIZE))
									.addGroup(pnInfoLayout.createSequentialGroup().addComponent(lblDiaDanh)
											.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
											.addComponent(txtDiaDanh, javax.swing.GroupLayout.PREFERRED_SIZE,
													javax.swing.GroupLayout.DEFAULT_SIZE,
													javax.swing.GroupLayout.PREFERRED_SIZE)))
							.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
							.addGroup(pnInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
									.addComponent(lblNgayDi).addComponent(lblTrangThaiTour))
							.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
							.addGroup(pnInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
									.addComponent(dpkNgayDi, javax.swing.GroupLayout.PREFERRED_SIZE,
											javax.swing.GroupLayout.DEFAULT_SIZE,
											javax.swing.GroupLayout.PREFERRED_SIZE)
									.addComponent(cbxTrangThaiTour, javax.swing.GroupLayout.PREFERRED_SIZE,
											javax.swing.GroupLayout.DEFAULT_SIZE,
											javax.swing.GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
							.addGroup(pnInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
									.addComponent(lblSoNgay).addComponent(lblMoTa))
							.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
							.addGroup(pnInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
									.addGroup(pnInfoLayout.createSequentialGroup()
											.addComponent(txtSoNgay, javax.swing.GroupLayout.PREFERRED_SIZE,
													javax.swing.GroupLayout.DEFAULT_SIZE,
													javax.swing.GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
											.addComponent(lblGiaTour)
											.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
											.addComponent(txtGiaTour, javax.swing.GroupLayout.PREFERRED_SIZE,
													javax.swing.GroupLayout.DEFAULT_SIZE,
													javax.swing.GroupLayout.PREFERRED_SIZE))
									.addComponent(scrMoTa, javax.swing.GroupLayout.PREFERRED_SIZE,
											javax.swing.GroupLayout.DEFAULT_SIZE,
											javax.swing.GroupLayout.PREFERRED_SIZE))
							.addContainerGap(12, Short.MAX_VALUE)));
			pnInfoLayout.linkSize(javax.swing.SwingConstants.VERTICAL,
					new java.awt.Component[] { cbxNoiDi, txtMaTour });

			javax.swing.GroupLayout pnDiaDanhLayout = new javax.swing.GroupLayout(pnDiaDanh);
			pnDiaDanh.setLayout(pnDiaDanhLayout);
			pnDiaDanhLayout.setHorizontalGroup(pnDiaDanhLayout
					.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
					.addGroup(pnDiaDanhLayout.createSequentialGroup().addContainerGap()
							.addComponent(scrDiaDanh, javax.swing.GroupLayout.DEFAULT_SIZE, 409, Short.MAX_VALUE)
							.addContainerGap()));
			pnDiaDanhLayout.setVerticalGroup(pnDiaDanhLayout
					.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
					.addGroup(pnDiaDanhLayout.createSequentialGroup()
							.addComponent(scrDiaDanh, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
							.addContainerGap()));

			javax.swing.GroupLayout pnActionLayout = new javax.swing.GroupLayout(pnAction);
			pnAction.setLayout(pnActionLayout);
			pnActionLayout
					.setHorizontalGroup(
							pnActionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
									.addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
											pnActionLayout.createSequentialGroup().addContainerGap()
													.addComponent(btnModify, javax.swing.GroupLayout.PREFERRED_SIZE,
															234, javax.swing.GroupLayout.PREFERRED_SIZE)
													.addGap(18, 18, 18)
													.addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE,
															200, javax.swing.GroupLayout.PREFERRED_SIZE)
													.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE,
															Short.MAX_VALUE)));

			pnActionLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL,
					new java.awt.Component[] { btnCancel, btnModify });

			pnActionLayout.setVerticalGroup(pnActionLayout
					.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
					.addGroup(pnActionLayout.createSequentialGroup()
							.addGroup(pnActionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
									.addComponent(btnModify, javax.swing.GroupLayout.PREFERRED_SIZE, 46,
											javax.swing.GroupLayout.PREFERRED_SIZE)
									.addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 46,
											javax.swing.GroupLayout.PREFERRED_SIZE))
							.addContainerGap()));

			pnActionLayout.linkSize(javax.swing.SwingConstants.VERTICAL,
					new java.awt.Component[] { btnCancel, btnModify });

			javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
			getContentPane().setLayout(layout);
			layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
					.addGroup(layout.createSequentialGroup().addContainerGap()
							.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
									.addComponent(pnInfo, javax.swing.GroupLayout.DEFAULT_SIZE,
											javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(pnAction, javax.swing.GroupLayout.DEFAULT_SIZE,
											javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
							.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
							.addComponent(pnDiaDanh, javax.swing.GroupLayout.DEFAULT_SIZE,
									javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addContainerGap()));
			layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
					.addGroup(layout.createSequentialGroup().addContainerGap()
							.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
									.addGroup(layout.createSequentialGroup()
											.addComponent(pnInfo, javax.swing.GroupLayout.PREFERRED_SIZE,
													javax.swing.GroupLayout.DEFAULT_SIZE,
													javax.swing.GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8,
													Short.MAX_VALUE)
											.addComponent(pnAction, javax.swing.GroupLayout.PREFERRED_SIZE,
													javax.swing.GroupLayout.DEFAULT_SIZE,
													javax.swing.GroupLayout.PREFERRED_SIZE))
									.addComponent(pnDiaDanh, javax.swing.GroupLayout.DEFAULT_SIZE,
											javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
							.addContainerGap()));

			pack();

		}

		private void event(String[] data) {
			// TODO Auto-generated method stub
			// Text
			this.txtMaTour.setText(data[0]);

			// Action
			this.btnModify.addActionListener(this);
			this.btnCancel.addActionListener(this);

			this.tblDiaDanh.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
				@Override
				public void valueChanged(ListSelectionEvent e) {
					// Kiểm tra xem có dòng nào được chọn hay không
					boolean hasSelection = !tblDiaDanh.getSelectionModel().isSelectionEmpty();

					// Nếu có dòng được chọn thì lấy giá trị ô số 0 của dòng đó
					if (hasSelection) {
						int rowIndex = tblDiaDanh.getSelectedRow();
						String value = tblDiaDanh.getValueAt(rowIndex, 0).toString();
						// Thêm giá trị của ô số 0 vào textfield tương ứng
						txtDiaDanh.setText(value);
					}
				}
			});
		}

		private void loadData() {
			// TODO Auto-generated method stub
			ArrayList<DiaDanh> dsdd = DAO_DiaDanh.getAllDiaDanh();

			for (DiaDanh diaDanh : dsdd) {
				String[] data = diaDanh.toString().split(";");

				tblModelDiaDanh.addRow(data);
			}
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			Object o = e.getSource();
			if (o.equals(btnCancel)) {
				this.dispose();
			}

			if (o.equals(btnModify)) {
				// Lấy ngày tháng được chọn từ JDatePicker
				Calendar selectedDate = (Calendar) dpkNgayDi.getModel().getValue();

				LocalDate localDate = LocalDate.of(selectedDate.get(Calendar.YEAR),
						selectedDate.get(Calendar.MONTH) + 1, selectedDate.get(Calendar.DAY_OF_MONTH));

				boolean status = false;
				if (cbxTrangThaiTour.getSelectedIndex() == 0)
					status = true;

				TourDuLich modifyTour = new TourDuLich(txtMaTour.getText(), txtTenTour.getText(), taMoTa.getText(),
						localDate, cbxNoiDi.getSelectedItem().toString(), Integer.parseInt(txtSoNgay.getText()),
						Float.parseFloat(txtGiaTour.getText()), status, DAO_DiaDanh.timDiaDanh(txtDiaDanh.getText()));

				if (DAO_TourDuLich.suaTuorDuLich(modifyTour)) {
					JOptionPane.showInternalMessageDialog(null, "Chỉnh Sửa Thành Công");
					tblModel.setRowCount(0);
					dsTourDuLich = DAO_TourDuLich.getAllTourDuLich();
					loadDataToTable(dsTourDuLich, tblModel);
					this.dispose();
				} else {
					JOptionPane.showInternalMessageDialog(null, "Thay Đổi Thất Bại", "Lỗi", JOptionPane.ERROR_MESSAGE);
					this.dispose();
				}
			}
		}

	}
}
