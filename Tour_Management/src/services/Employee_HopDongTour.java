package services;

import java.awt.Component;
import java.awt.Desktop;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Locale;

import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.KeyStroke;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import com.itextpdf.text.DocumentException;

import DAO.DAO_DichVu;
import DAO.DAO_HopDongTour;
import DAO.DAO_KhachHang;
import DAO.DAO_NhanVien;
import DAO.DAO_TourDuLich;
import DAO.DAO_VeTour;
import controllers.CtrlHopDongTour;
import controllers.PrintTicket;
import entity.DichVu;
import entity.HopDongTour;
import entity.KhachHang;
import entity.NhanVien;
import entity.TourDuLich;
import entity.VeTour;
import utils.LoadSave;
import utils.constants.ColorConstant;

/**
 * 
 * @author LE MINH BAO
 */
public class Employee_HopDongTour extends JPanel implements ActionListener {
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
	private ArrayList<NhanVien> dsnv = DAO_NhanVien.getAllNhanVien();
	private ArrayList<KhachHang> dskh = DAO_KhachHang.getAllKhachHang();
	private ArrayList<TourDuLich> dstour = DAO_TourDuLich.getAllTourDuLich();
	private ArrayList<DichVu> dsdv = DAO_DichVu.getAllDichVu();
	private String[] cols = new HopDongTour().getTitle().split(";");
	private ArrayList<HopDongTour> dsHopDong = new ArrayList<HopDongTour>();
	private String[] cbxItem = { "Sắp xếp tổng tiền tăng", "Sắp xếp tổng tiền giảm", "Sắp xếp theo mã hợp đồng",
			"Sắp xếp theo thời gian lập" };

	public Employee_HopDongTour() {
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
		lblSearchMa.setText("Mã hợp đồng cần tìm:");

		txtSearchMa.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

		btnSearchMa.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
		btnSearchMa.setText("Tìm Kiếm");

		lblSearchTenKH.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
		lblSearchTenKH.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		lblSearchTenKH.setText("Tên Khách hàng Cần Tìm Kiếm:");

		txtSearchTenKH.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

		btnSearchTenKH.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
		btnSearchTenKH.setText("Tìm Kiếm");

		lblSearchTenNV.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
		lblSearchTenNV.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		lblSearchTenNV.setText("Tên Nhân viên Cần Tìm Kiếm:");

		txtSearchTenNV.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

		btnSearchTenNV.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
		btnSearchTenNV.setText("Tìm Kiếm");

		pnData.setBorder(javax.swing.BorderFactory.createTitledBorder(
				javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED),
				"Danh Sách Hợp Đồng", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,
				javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 14))); // NOI18N

		lblFilter.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		lblFilter.setText("Lọc theo: ");

		scrData.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
		scrData.setViewportView(tblHopDongTour);

		pnAction.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Chọn Tác Vụ",
				javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION,
				new java.awt.Font("Segoe UI", 0, 14))); // NOI18N

		btnInfo.setText("Xem Thông Tin");
		btnInfo.setToolTipText("Xem Thông tin hợp đồng (Ctrl + I)");
		btnInfo.setEnabled(false);

		btnAdd.setText("Thêm Hợp Đồng");
		btnAdd.setToolTipText("Thêm Hợp Đồng Mới (Ctrl + T)");

		btnDelete.setText("Xóa Hợp Đồng");
		btnDelete.setToolTipText("Xóa hợp đồng được chọn (Ctrl + D)");
		btnDelete.setEnabled(false);

		btnModify.setText("Sửa Hợp Đồng");
		btnModify.setToolTipText("Chỉnh sửa hợp đồng được chọn (Ctrl + M)");
		btnModify.setEnabled(false);

		btnPrint.setText("In Hợp Đồng");
		btnPrint.setToolTipText("In hợp đồng được chọn (Ctrl + P)");
		btnPrint.setEnabled(false);
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

		tpnSearch.addTab("Tìm Kiếm Theo Mã hợp đồng", pnSearchMa);

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

		tpnSearch.addTab("Tìm Kiếm Theo Tên Khách hàng", pnSearchTenKH);

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

		tpnSearch.addTab("Tìm Kiếm Theo tên nhân viên", pnSearchTenNV);

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
		for (int i = 0; i < cbxItem.length; i++) {
			cbxFilter.addItem(cbxItem[i]);
		}
	}

	private void event() {
		// TODO Auto-generated method stub
		// Search
		this.btnSearchMa.addActionListener(this);
		this.btnSearchTenKH.addActionListener(this);
		this.btnSearchTenNV.addActionListener(this);
		this.cbxFilter.addActionListener(this);

		// Action
		this.btnInfo.addActionListener(this);
		this.btnAdd.addActionListener(this);
		this.btnDelete.addActionListener(this);
		this.btnModify.addActionListener(this);
		this.btnPrint.addActionListener(this);

		// Table
		this.tblHopDongTour.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent e) {
				// TODO Auto-generated method stub
				// Kiểm tra xem có dòng nào được chọn hay không
				boolean hasSelection = !tblHopDongTour.getSelectionModel().isSelectionEmpty();

				// Đặt giá trị cho thuộc tính enabled của btnInfo tương ứng với hasSelection
				btnInfo.setEnabled(hasSelection);
				btnDelete.setEnabled(hasSelection);
				btnModify.setEnabled(hasSelection);
				btnPrint.setEnabled(hasSelection);
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
					int selectedRow = tblHopDongTour.getSelectedRow();

					// Lấy số cột của bảng
					int columnsCount = tblHopDongTour.getColumnCount();

					// Tạo một mảng String để chứa dữ liệu của hàng đang được chọn
					String[] data = new String[columnsCount];

					// Duyệt qua các cột của hàng đang được chọn và lưu giá trị vào mảng data
					for (int i = 0; i < columnsCount; i++) {
						data[i] = tblHopDongTour.getValueAt(selectedRow, i).toString();
					}

					new FrameInfoHopDongTour(data).setVisible(true);
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
					new FrameAddHopDongTour().setVisible(true);
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
						int selectedRow = tblHopDongTour.getSelectedRow();
						String data = tblHopDongTour.getValueAt(selectedRow, 0).toString();

						DAO_HopDongTour.xoaHopDongTour(data);
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
					int selectedRow = tblHopDongTour.getSelectedRow();

					// Lấy số cột của bảng
					int columnsCount = tblHopDongTour.getColumnCount();

					// Tạo một mảng String để chứa dữ liệu của hàng đang được chọn
					String[] data = new String[columnsCount];

					// Duyệt qua các cột của hàng đang được chọn và lưu giá trị vào mảng data
					for (int i = 0; i < columnsCount; i++) {
						data[i] = tblHopDongTour.getValueAt(selectedRow, i).toString();
					}
					new FrameModifyHopDongTour(data).setVisible(true);
				}
			}
		});

		// Shortcut for Print Button
		InputMap imP = btnPrint.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
		// Add the key binding for Ctrl + P
		imP.put(KeyStroke.getKeyStroke(KeyEvent.VK_P, KeyEvent.CTRL_DOWN_MASK), "print");
		ActionMap amP = btnPrint.getActionMap();
		amP.put("print", new AbstractAction() {
			/**
			 * 
			 */
			private static final long serialVersionUID = -4313320705274645351L;

			public void actionPerformed(ActionEvent e) {
				if (btnPrint.isEnabled()) {
					// Lấy chỉ số của hàng đang được chọn
					int selectedRow = tblHopDongTour.getSelectedRow();

					// Lấy số cột của bảng
					int columnsCount = tblHopDongTour.getColumnCount();

					// Tạo một mảng String để chứa dữ liệu của hàng đang được chọn
					String[] data = new String[columnsCount];

					// Duyệt qua các cột của hàng đang được chọn và lưu giá trị vào mảng data
					for (int i = 0; i < columnsCount; i++) {
						data[i] = tblHopDongTour.getValueAt(selectedRow, i).toString();
					}
					JFileChooser fileChooser = new JFileChooser();
					fileChooser.setDialogTitle("Chọn vị trí lưu hợp đồng");
					// Chỉ cho phép lưu file với định dạng .pdf
					fileChooser.setFileFilter(new FileNameExtensionFilter("PDF files", "pdf"));
					// Hiển thị hộp thoại để chọn vị trí lưu file
					int result = fileChooser.showSaveDialog(null);
					if (result == JFileChooser.APPROVE_OPTION) {
						// Lấy đường dẫn đã chọn
						String filePath = fileChooser.getSelectedFile().getPath();
						// Kiểm tra xem có đuôi mở rộng của file không
						if (!filePath.endsWith(".pdf")) {
							filePath += ".pdf";
						}
						// Kiểm tra nếu file đã tồn tại
						File file = fileChooser.getSelectedFile();
						if (file.exists()) {
							int response = JOptionPane.showConfirmDialog(null,
									"File đã tồn tại, bạn có muốn ghi đè lên file này?", "Cảnh báo",
									JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
							if (response == JOptionPane.YES_OPTION) {
								// Lưu file
								try {
									PrintTicket.printContract(data[0], filePath);
								} catch (DocumentException | IOException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
								// Mở file vừa lưu
								if (Desktop.isDesktopSupported()) {
									try {
										Desktop.getDesktop().open(file);
									} catch (IOException e1) {
										e1.printStackTrace();
									}
								}
							}
						} else {
							// Lưu file
							try {
								PrintTicket.printContract(data[0], filePath);
							} catch (DocumentException | IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							// Mở file vừa lưu
							if (Desktop.isDesktopSupported()) {
								try {
									Desktop.getDesktop().open(file);
								} catch (IOException e1) {
									e1.printStackTrace();
								}
							}
						}
					}
				}
			}
		});
	}

	private void loadDataToTable(ArrayList<HopDongTour> dsIn, DefaultTableModel model) {
		model.setRowCount(0);
		for (HopDongTour hd : dsIn) {
			addOneRowToTable(hd, model);
		}
	}

	private void addOneRowToTable(HopDongTour hd, DefaultTableModel model) {
		model.addRow(new Object[] { hd.getMaHopDong(), hd.getThoiGianLap(), hd.getGhiChu(),
				DAO_HopDongTour.getTongTienTour(hd.getDichVu().getMaDichVu(), hd.getTourDuLich().getMaTour()),
				hd.getNhanVien().getTenNhanVien(), hd.getKhachHang().getTenKhachHang(), hd.getTourDuLich().getTenTour(),
				hd.getDichVu().getGiaDichVu() });
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object o = e.getSource();
		// Search
		if (o.equals(btnSearchMa)) {
			dsHopDong = DAO_HopDongTour.getAllHopDongTour();
			if (txtSearchMa.getText().trim().equals("") || txtSearchMa.getText().trim().equals(null)) {
				loadDataToTable(dsHopDong, tblModel);
			} else {
				dsHopDong = CtrlHopDongTour.locHopDongTheoMa(dsHopDong, txtSearchMa.getText().trim());
				loadDataToTable(dsHopDong, tblModel);
			}
			txtSearchMa.setText("");
		}
		if (o.equals(btnSearchTenKH)) {
			dsHopDong = DAO_HopDongTour.getAllHopDongTour();
			if (txtSearchTenKH.getText().trim().equals("") || txtSearchTenKH.getText().trim().equals(null)) {
				loadDataToTable(dsHopDong, tblModel);
			} else {
				dsHopDong = CtrlHopDongTour.locHopDongTheoKH(dsHopDong, txtSearchTenKH.getText().trim());
				loadDataToTable(dsHopDong, tblModel);
			}
			txtSearchTenKH.setText("");
		}
		if (o.equals(btnSearchTenNV)) {
			dsHopDong = DAO_HopDongTour.getAllHopDongTour();
			if (txtSearchTenNV.getText().trim().equals("") || txtSearchTenNV.getText().trim().equals(null)) {
				loadDataToTable(dsHopDong, tblModel);
			} else {
				dsHopDong = CtrlHopDongTour.locHopDongTheoNV(dsHopDong, txtSearchTenNV.getText().trim());
				loadDataToTable(dsHopDong, tblModel);
			}
			txtSearchTenNV.setText("");
		}

		if (o.equals(cbxFilter)) {
			dsHopDong = DAO_HopDongTour.getAllHopDongTour();
			// {"Sắp xếp tổng tiền tăng", "Sắp xếp tổng tiền giảm", "Sắp xếp theo mã hợp
			// đồng", "Sắp xếp theo thời gian lập"}
			if (cbxFilter.getSelectedIndex() == 0) {
				dsHopDong = CtrlHopDongTour.sapXepHopDongTongTienTang(dsHopDong);
				loadDataToTable(dsHopDong, tblModel);
			} else if (cbxFilter.getSelectedIndex() == 1) {
				loadDataToTable(CtrlHopDongTour.sapXepHopDongTongTienGiam(dsHopDong), tblModel);
			} else if (cbxFilter.getSelectedIndex() == 2) {
				loadDataToTable(CtrlHopDongTour.sapXepHopDongTheoMa(dsHopDong), tblModel);
			} else if (cbxFilter.getSelectedIndex() == 3) {
				loadDataToTable(CtrlHopDongTour.sapXepHopDongTheoNgay(dsHopDong), tblModel);
			}
		}

		// Action
		if (o.equals(btnInfo)) {
			// Lấy chỉ số của hàng đang được chọn
			int selectedRow = tblHopDongTour.getSelectedRow();

			// Lấy số cột của bảng
			int columnsCount = tblHopDongTour.getColumnCount();

			// Tạo một mảng String để chứa dữ liệu của hàng đang được chọn
			String[] data = new String[columnsCount];

			// Duyệt qua các cột của hàng đang được chọn và lưu giá trị vào mảng data
			for (int i = 0; i < columnsCount; i++) {
				data[i] = tblHopDongTour.getValueAt(selectedRow, i).toString();
			}
			new FrameInfoHopDongTour(data).setVisible(true);
		}
		if (o.equals(btnAdd)) {
			new FrameAddHopDongTour().setVisible(true);
		}
		if (o.equals(btnDelete)) {
			int dialogResult = JOptionPane.showConfirmDialog(null, "Bạn có muốn xóa dữ liệu không?");
			if (dialogResult == JOptionPane.YES_OPTION) {
				// Lấy chỉ số của hàng đang được chọn
				int selectedRow = tblHopDongTour.getSelectedRow();
				String data = tblHopDongTour.getValueAt(selectedRow, 0).toString();

				DAO_HopDongTour.xoaHopDongTour(data);
				tblModel.setRowCount(0);
				loadData();
			}
		}
		if (o.equals(btnModify)) {
			// Lấy chỉ số của hàng đang được chọn
			int selectedRow = tblHopDongTour.getSelectedRow();

			// Lấy số cột của bảng
			int columnsCount = tblHopDongTour.getColumnCount();

			// Tạo một mảng String để chứa dữ liệu của hàng đang được chọn
			String[] data = new String[columnsCount];

			// Duyệt qua các cột của hàng đang được chọn và lưu giá trị vào mảng data
			for (int i = 0; i < columnsCount; i++) {
				data[i] = tblHopDongTour.getValueAt(selectedRow, i).toString();
			}
			new FrameModifyHopDongTour(data).setVisible(true);
		}
		if (o.equals(btnPrint)) {
			// Lấy chỉ số của hàng đang được chọn
			int selectedRow = tblHopDongTour.getSelectedRow();

			// Lấy số cột của bảng
			int columnsCount = tblHopDongTour.getColumnCount();

			// Tạo một mảng String để chứa dữ liệu của hàng đang được chọn
			String[] data = new String[columnsCount];

			// Duyệt qua các cột của hàng đang được chọn và lưu giá trị vào mảng data
			for (int i = 0; i < columnsCount; i++) {
				data[i] = tblHopDongTour.getValueAt(selectedRow, i).toString();
			}
			JFileChooser fileChooser = new JFileChooser();
			fileChooser.setDialogTitle("Chọn vị trí lưu hợp đồng");
			// Chỉ cho phép lưu file với định dạng .pdf
			fileChooser.setFileFilter(new FileNameExtensionFilter("PDF files", "pdf"));
			// Hiển thị hộp thoại để chọn vị trí lưu file
			int result = fileChooser.showSaveDialog(null);
			if (result == JFileChooser.APPROVE_OPTION) {
				// Lấy đường dẫn đã chọn
				String filePath = fileChooser.getSelectedFile().getPath();
				// Kiểm tra xem có đuôi mở rộng của file không
				if (!filePath.endsWith(".pdf")) {
					filePath += ".pdf";
				}
				// Kiểm tra nếu file đã tồn tại
				File file = fileChooser.getSelectedFile();
				if (file.exists()) {
					int response = JOptionPane.showConfirmDialog(null,
							"File đã tồn tại, bạn có muốn ghi đè lên file này?", "Cảnh báo", JOptionPane.YES_NO_OPTION,
							JOptionPane.WARNING_MESSAGE);
					if (response == JOptionPane.YES_OPTION) {
						// Lưu file
						try {
							PrintTicket.printContract(data[0], filePath);
						} catch (DocumentException | IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						// Mở file vừa lưu
						if (Desktop.isDesktopSupported()) {
							try {
								Desktop.getDesktop().open(file);
							} catch (IOException e1) {
								e1.printStackTrace();
							}
						}
					}
				} else {
					// Lưu file
					try {
						PrintTicket.printContract(data[0], filePath);
					} catch (DocumentException | IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					// Mở file vừa lưu
					if (Desktop.isDesktopSupported()) {
						try {
							Desktop.getDesktop().open(file);
						} catch (IOException e1) {
							e1.printStackTrace();
						}
					}
				}
			}
		}
	}

	private void loadData() {
		// TODO Auto-generated method stub
		ArrayList<HopDongTour> dshdt = DAO_HopDongTour.getAllHopDongTour();
		for (HopDongTour hopDongTour : dshdt) {
			String[] data = hopDongTour.toString().split(";");

			// Format đơn vị tiền tệ
			NumberFormat format = NumberFormat.getCurrencyInstance(new Locale("vi", "VN"));
			String tongTien = format.format(Double.parseDouble(data[3]));
			String tienDichVu = format.format(Double.parseDouble(data[7]));

			// Create a font with a larger size
			Font largerFont = tblHopDongTour.getFont().deriveFont(14f);

			// Set the cell renderer for all columns
			for (int i = 0; i < tblHopDongTour.getColumnModel().getColumnCount(); i++) {
				tblHopDongTour.getColumnModel().getColumn(i).setCellRenderer(new DefaultTableCellRenderer() {
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

			String[] input = { data[0], data[1], data[2], tongTien, data[4], data[5], data[6], tienDichVu };
			tblModel.addRow(input);

			// Right Align Column
			DefaultTableCellRenderer rightRender = new DefaultTableCellRenderer();
			rightRender.setHorizontalAlignment(DefaultTableCellRenderer.RIGHT);

			TableColumnModel columnModel = tblHopDongTour.getColumnModel();
			int tongTienColumn = columnModel.getColumnIndex("Tổng Tiền"); // Lấy cột tổng tiền
			int lastColumn = columnModel.getColumnCount() - 1; // Lấy cột dịch vụ
			columnModel.getColumn(tongTienColumn).setCellRenderer(rightRender);
			columnModel.getColumn(lastColumn).setCellRenderer(rightRender);
		}
	}

	private class FrameInfoHopDongTour extends JFrame {

		/**
		 * 
		 */
		private static final long serialVersionUID = 8766759911141232526L;
		private javax.swing.JLabel lblDichVu;
		private javax.swing.JLabel lblGhiChu;
		private javax.swing.JLabel lblKhachHang;
		private javax.swing.JLabel lblMaHopDong;
		private javax.swing.JLabel lblNhanVien;
		private javax.swing.JLabel lblThoiGianLap;
		private javax.swing.JLabel lblTongTien;
		private javax.swing.JLabel lblTour;
		private javax.swing.JPanel pnInfo;
		private javax.swing.JTextArea taGhiChu;
		private javax.swing.JTextField txtDichVu;
		private javax.swing.JScrollPane txtGhiChu;
		private javax.swing.JTextField txtKhachHang;
		private javax.swing.JTextField txtMaHopDong;
		private javax.swing.JTextField txtNhanVien;
		private javax.swing.JTextField txtThoiGianLap;
		private javax.swing.JTextField txtTongTien;
		private javax.swing.JTextField txtTour;

		public FrameInfoHopDongTour(String[] data) {
			this.setTitle("SE Tourist - Thông tin hợp đồng");
			this.setIconImage(LoadSave.GetSpriteAtlas(LoadSave.LOGO_ICON));
			this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			this.setResizable(false);
			this.setLocationRelativeTo(null);
//	    this.setMaximumSize(new java.awt.Dimension(420, 500));
//	    this.setMinimumSize(new java.awt.Dimension(420, 500));

			this.init();
			this.style();
			this.preset();
			this.event(data);
		}

		private void init() {
			// TODO Auto-generated method stub
			pnInfo = new javax.swing.JPanel();
			lblMaHopDong = new javax.swing.JLabel();
			txtMaHopDong = new javax.swing.JTextField();
			lblThoiGianLap = new javax.swing.JLabel();
			txtThoiGianLap = new javax.swing.JTextField();
			lblGhiChu = new javax.swing.JLabel();
			txtGhiChu = new javax.swing.JScrollPane();
			taGhiChu = new javax.swing.JTextArea();
			lblNhanVien = new javax.swing.JLabel();
			txtNhanVien = new javax.swing.JTextField();
			lblKhachHang = new javax.swing.JLabel();
			txtKhachHang = new javax.swing.JTextField();
			lblTour = new javax.swing.JLabel();
			txtTour = new javax.swing.JTextField();
			lblDichVu = new javax.swing.JLabel();
			txtDichVu = new javax.swing.JTextField();
			lblTongTien = new javax.swing.JLabel();
			txtTongTien = new javax.swing.JTextField();
		}

		private void style() {
			// TODO Auto-generated method stub
			pnInfo.setBorder(javax.swing.BorderFactory.createTitledBorder(
					javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED),
					"Thông tin hợp đồng", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,
					javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 14))); // NOI18N

			lblMaHopDong.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
			lblMaHopDong.setText("Mã hợp đồng");

			txtMaHopDong.setEditable(false);
			txtMaHopDong.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
			txtMaHopDong.setHorizontalAlignment(javax.swing.JTextField.CENTER);

			lblThoiGianLap.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
			lblThoiGianLap.setText("Thời Gian Lập");

			txtThoiGianLap.setEditable(false);
			txtThoiGianLap.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
			txtThoiGianLap.setHorizontalAlignment(javax.swing.JTextField.CENTER);

			lblGhiChu.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
			lblGhiChu.setText("Ghi chú");

			taGhiChu.setEditable(false);
			taGhiChu.setColumns(20);
			taGhiChu.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
			taGhiChu.setRows(5);
			txtGhiChu.setViewportView(taGhiChu);

			lblNhanVien.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
			lblNhanVien.setText("Nhân viên thực hiện");

			txtNhanVien.setEditable(false);
			txtNhanVien.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

			lblKhachHang.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
			lblKhachHang.setText("Khách hàng đặt tour");

			txtKhachHang.setEditable(false);
			txtKhachHang.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

			lblTour.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
			lblTour.setText("Tour khách hàng đặt");

			txtTour.setEditable(false);
			txtTour.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

			lblDichVu.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
			lblDichVu.setText("Tiền Dịch Vụ");

			txtDichVu.setEditable(false);
			txtDichVu.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
			txtDichVu.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

			lblTongTien.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
			lblTongTien.setText("Tổng Tiền");

			txtTongTien.setEditable(false);
			txtTongTien.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
			txtTongTien.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
		}

		private void preset() {
			javax.swing.GroupLayout pnInfoLayout = new javax.swing.GroupLayout(pnInfo);
			pnInfo.setLayout(pnInfoLayout);
			pnInfoLayout.setHorizontalGroup(pnInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
					.addGroup(pnInfoLayout.createSequentialGroup().addContainerGap().addGroup(pnInfoLayout
							.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
							.addGroup(pnInfoLayout.createSequentialGroup()
									.addGroup(pnInfoLayout
											.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
											.addComponent(lblMaHopDong, javax.swing.GroupLayout.PREFERRED_SIZE, 125,
													javax.swing.GroupLayout.PREFERRED_SIZE)
											.addComponent(lblGhiChu, javax.swing.GroupLayout.PREFERRED_SIZE, 125,
													javax.swing.GroupLayout.PREFERRED_SIZE)
											.addComponent(lblNhanVien).addComponent(lblKhachHang).addComponent(lblTour)
											.addComponent(lblDichVu).addComponent(txtMaHopDong,
													javax.swing.GroupLayout.PREFERRED_SIZE, 237,
													javax.swing.GroupLayout.PREFERRED_SIZE))
									.addGap(35, 35, 35)
									.addGroup(pnInfoLayout
											.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
											.addGroup(pnInfoLayout.createSequentialGroup()
													.addComponent(lblThoiGianLap,
															javax.swing.GroupLayout.PREFERRED_SIZE, 125,
															javax.swing.GroupLayout.PREFERRED_SIZE)
													.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
															96, Short.MAX_VALUE))
											.addComponent(txtThoiGianLap)))
							.addComponent(txtGhiChu).addComponent(txtNhanVien)
							.addComponent(txtKhachHang, javax.swing.GroupLayout.Alignment.TRAILING)
							.addComponent(txtTour, javax.swing.GroupLayout.Alignment.TRAILING)
							.addComponent(txtDichVu, javax.swing.GroupLayout.Alignment.TRAILING).addGroup(pnInfoLayout
									.createSequentialGroup().addComponent(lblTongTien).addGap(0, 0, Short.MAX_VALUE))
							.addComponent(txtTongTien)).addContainerGap()));
			pnInfoLayout.setVerticalGroup(pnInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
					.addGroup(pnInfoLayout.createSequentialGroup()
							.addGroup(pnInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
									.addComponent(lblMaHopDong).addComponent(lblThoiGianLap))
							.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
							.addGroup(pnInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
									.addComponent(txtMaHopDong, javax.swing.GroupLayout.PREFERRED_SIZE,
											javax.swing.GroupLayout.DEFAULT_SIZE,
											javax.swing.GroupLayout.PREFERRED_SIZE)
									.addComponent(txtThoiGianLap, javax.swing.GroupLayout.PREFERRED_SIZE,
											javax.swing.GroupLayout.DEFAULT_SIZE,
											javax.swing.GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(lblGhiChu)
							.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
							.addComponent(txtGhiChu, javax.swing.GroupLayout.PREFERRED_SIZE, 43,
									javax.swing.GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
							.addComponent(lblNhanVien)
							.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
							.addComponent(txtNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE,
									javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
							.addComponent(lblKhachHang)
							.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
							.addComponent(txtKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE,
									javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(lblTour)
							.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
							.addComponent(txtTour, javax.swing.GroupLayout.PREFERRED_SIZE,
									javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(lblDichVu)
							.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
							.addComponent(txtDichVu, javax.swing.GroupLayout.PREFERRED_SIZE,
									javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
									javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(lblTongTien)
							.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
							.addComponent(txtTongTien, javax.swing.GroupLayout.PREFERRED_SIZE,
									javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
							.addContainerGap()));

			pnInfoLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] { txtDichVu,
					txtKhachHang, txtMaHopDong, txtNhanVien, txtThoiGianLap, txtTongTien, txtTour });

			javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
			getContentPane().setLayout(layout);
			layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
					.addGroup(layout.createSequentialGroup().addContainerGap().addComponent(pnInfo,
							javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addContainerGap()));
			layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
					.addGroup(layout.createSequentialGroup().addContainerGap().addComponent(pnInfo,
							javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
							Short.MAX_VALUE)));

			pack();
		}

		private void event(String[] data) {
			// TODO Auto-generated method stub
			this.txtMaHopDong.setText(data[0]);
			this.txtThoiGianLap.setText(data[1]);
			this.taGhiChu.setText(data[2]);
			this.txtTongTien.setText(data[3]);
			this.txtNhanVien.setText(data[4]);
			this.txtKhachHang.setText(data[5]);
			this.txtTour.setText(data[6]);
			this.txtDichVu.setText(data[7]);
		}

	}

	private class FrameAddHopDongTour extends JFrame implements ActionListener {

		/**
		 * 
		 */
		private static final long serialVersionUID = 5798721375417107998L;
		private javax.swing.JButton btnAdd;
		private javax.swing.JButton btnCancel;
		private javax.swing.JLabel lblDichVu;
		private javax.swing.JLabel lblGhiChu;
		private javax.swing.JLabel lblKhachHang;
		private javax.swing.JLabel lblMaHopDong;
		private javax.swing.JLabel lblNhanVien;
		private javax.swing.JLabel lblTour;
		private javax.swing.JPanel pnAction;
		private javax.swing.JPanel pnInfo;
		private javax.swing.JScrollPane scrDichVu;
		private javax.swing.JScrollPane scrKhachhang;
		private javax.swing.JScrollPane scrNhanVien;
		private javax.swing.JScrollPane scrTour;
		private javax.swing.JTextArea taGhiChu;
		private javax.swing.table.DefaultTableModel tblModelDichVu;
		private javax.swing.table.DefaultTableModel tblModelKhachHang;
		private javax.swing.table.DefaultTableModel tblModelNhanVien;
		private javax.swing.table.DefaultTableModel tblModelTour;
		private javax.swing.JTable tblDichVu;
		private javax.swing.JTable tblKhachHang;
		private javax.swing.JTable tblNhanVien;
		private javax.swing.JTable tblTour;
		private javax.swing.JTabbedPane tbpnData;
		private javax.swing.JTextField txtDichVu;
		private javax.swing.JScrollPane txtGhiChu;
		private javax.swing.JTextField txtKhachHang;
		private javax.swing.JTextField txtMaHopDong;
		private javax.swing.JTextField txtNhanVien;
		private javax.swing.JTextField txtTour;
		private NhanVien nv = new NhanVien();
		private KhachHang kh = new KhachHang();
		private DichVu dv = new DichVu();
		private TourDuLich tour = new TourDuLich();

		public FrameAddHopDongTour() {
			this.setTitle("SE Tourist - Thêm Hợp Đồng Tour");
			this.setIconImage(LoadSave.GetSpriteAtlas(LoadSave.LOGO_ICON));
			this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			this.setResizable(false);
			this.setLocationRelativeTo(null);
//	    this.setMaximumSize(new java.awt.Dimension(420, 500));
//	    this.setMinimumSize(new java.awt.Dimension(420, 500));

			this.init();
			this.style();
			this.preset();
			this.event();
			this.loadDataTable();
		}

		private void init() {
			// TODO Auto-generated method stub
			pnInfo = new javax.swing.JPanel();
			lblMaHopDong = new javax.swing.JLabel();
			txtMaHopDong = new javax.swing.JTextField();
			lblGhiChu = new javax.swing.JLabel();
			txtGhiChu = new javax.swing.JScrollPane();
			taGhiChu = new javax.swing.JTextArea();
			lblNhanVien = new javax.swing.JLabel();
			txtNhanVien = new javax.swing.JTextField();
			lblKhachHang = new javax.swing.JLabel();
			txtKhachHang = new javax.swing.JTextField();
			lblTour = new javax.swing.JLabel();
			txtTour = new javax.swing.JTextField();
			lblDichVu = new javax.swing.JLabel();
			txtDichVu = new javax.swing.JTextField();
			tbpnData = new javax.swing.JTabbedPane();
			scrNhanVien = new javax.swing.JScrollPane();
			tblNhanVien = new javax.swing.JTable();
			scrKhachhang = new javax.swing.JScrollPane();
			tblKhachHang = new javax.swing.JTable();
			scrTour = new javax.swing.JScrollPane();
			tblTour = new javax.swing.JTable();
			scrDichVu = new javax.swing.JScrollPane();
			tblDichVu = new javax.swing.JTable();
			pnAction = new javax.swing.JPanel();
			btnAdd = new javax.swing.JButton();
			btnCancel = new javax.swing.JButton();
			String[] colsNV = nv.getTitle().split(";");
			String[] colsKH = kh.getTitle().split(";");
			String[] colsTour = tour.getTitle().split(";");
			String[] colsDV = dv.getTitle().split(";");
			tblModelNhanVien = new javax.swing.table.DefaultTableModel(colsNV, 0);
			tblModelKhachHang = new javax.swing.table.DefaultTableModel(colsKH, 0);
			tblModelTour = new javax.swing.table.DefaultTableModel(colsTour, 0);
			tblModelDichVu = new javax.swing.table.DefaultTableModel(colsDV, 0);
		}

		private void style() {
			// TODO Auto-generated method stub
			pnInfo.setBorder(javax.swing.BorderFactory.createTitledBorder(
					javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED),
					"Thông tin hợp đồng", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,
					javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 14))); // NOI18N

			lblMaHopDong.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
			lblMaHopDong.setText("Mã hợp đồng");

			txtMaHopDong.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

			lblGhiChu.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
			lblGhiChu.setText("Ghi chú");

			taGhiChu.setColumns(20);
			taGhiChu.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
			taGhiChu.setRows(5);
			txtGhiChu.setViewportView(taGhiChu);

			lblNhanVien.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
			lblNhanVien.setText("Nhân viên thực hiện");

			txtNhanVien.setEditable(false);
			txtNhanVien.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

			lblKhachHang.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
			lblKhachHang.setText("Khách hàng đặt tour");

			txtKhachHang.setEditable(false);
			txtKhachHang.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

			lblTour.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
			lblTour.setText("Tour khách hàng đặt");

			txtTour.setEditable(false);
			txtTour.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

			lblDichVu.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
			lblDichVu.setText("Dịch vụ đi kèm");

			txtDichVu.setEditable(false);
			txtDichVu.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

			tbpnData.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

			tblNhanVien.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
			tblNhanVien.setModel(tblModelNhanVien);
			scrNhanVien.setViewportView(tblNhanVien);

			tbpnData.addTab("Nhân viên", scrNhanVien);

			tblKhachHang.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
			tblKhachHang.setModel(tblModelKhachHang);
			scrKhachhang.setViewportView(tblKhachHang);

			tbpnData.addTab("Khách hàng", scrKhachhang);

			tblTour.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
			tblTour.setModel(tblModelTour);
			scrTour.setViewportView(tblTour);

			tbpnData.addTab("Tour Du Lich", scrTour);

			tblDichVu.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
			tblDichVu.setModel(tblModelDichVu);
			scrDichVu.setViewportView(tblDichVu);

			tbpnData.addTab("Dịch Vụ", scrDichVu);

			pnAction.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Chọn Tác Vụ",
					javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,
					javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 14))); // NOI18N

			btnAdd.setBackground(new java.awt.Color(0, 255, 0));
			btnAdd.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
			btnAdd.setForeground(new java.awt.Color(255, 255, 255));
			btnAdd.setText("Thêm Hợp Đồng");
			btnAdd.setToolTipText("Thêm hợp đồng mới");

			btnCancel.setBackground(new java.awt.Color(255, 0, 0));
			btnCancel.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
			btnCancel.setForeground(new java.awt.Color(255, 255, 255));
			btnCancel.setText("Hủy");
			btnCancel.setToolTipText("Hủy thao tác thêm");
		}

		private void preset() {
			// TODO Auto-generated method stub
			javax.swing.GroupLayout pnInfoLayout = new javax.swing.GroupLayout(pnInfo);
			pnInfo.setLayout(pnInfoLayout);
			pnInfoLayout.setHorizontalGroup(pnInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
					.addGroup(pnInfoLayout.createSequentialGroup().addContainerGap()
							.addGroup(pnInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
									.addComponent(txtMaHopDong)
									.addComponent(txtGhiChu, javax.swing.GroupLayout.DEFAULT_SIZE, 459, Short.MAX_VALUE)
									.addGroup(pnInfoLayout.createSequentialGroup().addGroup(pnInfoLayout
											.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
											.addComponent(lblMaHopDong, javax.swing.GroupLayout.PREFERRED_SIZE, 125,
													javax.swing.GroupLayout.PREFERRED_SIZE)
											.addComponent(lblGhiChu, javax.swing.GroupLayout.PREFERRED_SIZE, 125,
													javax.swing.GroupLayout.PREFERRED_SIZE)
											.addComponent(lblNhanVien).addComponent(lblKhachHang).addComponent(lblTour)
											.addComponent(lblDichVu)).addGap(0, 0, Short.MAX_VALUE))
									.addComponent(txtNhanVien)
									.addComponent(txtKhachHang, javax.swing.GroupLayout.Alignment.TRAILING)
									.addComponent(txtTour, javax.swing.GroupLayout.Alignment.TRAILING)
									.addComponent(txtDichVu, javax.swing.GroupLayout.Alignment.TRAILING))
							.addContainerGap()));
			pnInfoLayout.setVerticalGroup(pnInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
					.addGroup(pnInfoLayout.createSequentialGroup().addComponent(lblMaHopDong)
							.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
							.addComponent(txtMaHopDong, javax.swing.GroupLayout.PREFERRED_SIZE,
									javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(lblGhiChu)
							.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
							.addComponent(txtGhiChu, javax.swing.GroupLayout.PREFERRED_SIZE, 43,
									javax.swing.GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
							.addComponent(lblNhanVien)
							.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
							.addComponent(txtNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE,
									javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
							.addComponent(lblKhachHang)
							.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
							.addComponent(txtKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE,
									javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(lblTour)
							.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
							.addComponent(txtTour, javax.swing.GroupLayout.PREFERRED_SIZE,
									javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(lblDichVu)
							.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
									javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(txtDichVu, javax.swing.GroupLayout.PREFERRED_SIZE,
									javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)));

			javax.swing.GroupLayout pnActionLayout = new javax.swing.GroupLayout(pnAction);
			pnAction.setLayout(pnActionLayout);
			pnActionLayout
					.setHorizontalGroup(pnActionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
							.addGroup(pnActionLayout.createSequentialGroup().addContainerGap()
									.addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 194,
											javax.swing.GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
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
					.addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout
							.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
							.addComponent(pnAction, javax.swing.GroupLayout.DEFAULT_SIZE,
									javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addGroup(layout.createSequentialGroup()
									.addComponent(pnInfo, javax.swing.GroupLayout.PREFERRED_SIZE,
											javax.swing.GroupLayout.DEFAULT_SIZE,
											javax.swing.GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(
											tbpnData, javax.swing.GroupLayout.DEFAULT_SIZE, 632, Short.MAX_VALUE)))
							.addContainerGap()));
			layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
					.addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout
							.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
							.addComponent(pnInfo, javax.swing.GroupLayout.PREFERRED_SIZE,
									javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
							.addComponent(tbpnData, javax.swing.GroupLayout.PREFERRED_SIZE, 387,
									javax.swing.GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
							.addComponent(pnAction, javax.swing.GroupLayout.PREFERRED_SIZE,
									javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
							.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

			pack();
		}

		private void event() {
			// TODO Auto-generated method stub
			this.btnAdd.addActionListener(this);
			this.btnCancel.addActionListener(this);

			this.tblDichVu.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
				@Override
				public void valueChanged(ListSelectionEvent e) {
					// Kiểm tra xem có dòng nào được chọn hay không
					boolean hasSelection = !tblDichVu.getSelectionModel().isSelectionEmpty();

					// Nếu có dòng được chọn thì lấy giá trị ô số 0 của dòng đó
					if (hasSelection) {
						int rowIndex = tblDichVu.getSelectedRow();
						String value = tblDichVu.getValueAt(rowIndex, 0).toString();
						// Thêm giá trị của ô số 0 vào textfield tương ứng
						txtDichVu.setText(value);
					}
				}
			});

			this.tblKhachHang.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
				@Override
				public void valueChanged(ListSelectionEvent e) {
					// Kiểm tra xem có dòng nào được chọn hay không
					boolean hasSelection = !tblKhachHang.getSelectionModel().isSelectionEmpty();

					// Nếu có dòng được chọn thì lấy giá trị ô số 0 của dòng đó
					if (hasSelection) {
						int rowIndex = tblKhachHang.getSelectedRow();
						String value = tblKhachHang.getValueAt(rowIndex, 0).toString();
						// Thêm giá trị của ô số 0 vào textfield tương ứng
						txtKhachHang.setText(value);
					}
				}
			});

			this.tblNhanVien.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
				@Override
				public void valueChanged(ListSelectionEvent e) {
					// Kiểm tra xem có dòng nào được chọn hay không
					boolean hasSelection = !tblNhanVien.getSelectionModel().isSelectionEmpty();

					// Nếu có dòng được chọn thì lấy giá trị ô số 0 của dòng đó
					if (hasSelection) {
						int rowIndex = tblNhanVien.getSelectedRow();
						String value = tblNhanVien.getValueAt(rowIndex, 0).toString();
						// Thêm giá trị của ô số 0 vào textfield tương ứng
						txtNhanVien.setText(value);
					}
				}
			});

			this.tblTour.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
				@Override
				public void valueChanged(ListSelectionEvent e) {
					// Kiểm tra xem có dòng nào được chọn hay không
					boolean hasSelection = !tblTour.getSelectionModel().isSelectionEmpty();

					// Nếu có dòng được chọn thì lấy giá trị ô số 0 của dòng đó
					if (hasSelection) {
						int rowIndex = tblTour.getSelectedRow();
						String value = tblTour.getValueAt(rowIndex, 0).toString();
						// Thêm giá trị của ô số 0 vào textfield tương ứng
						txtTour.setText(value);
					}
				}
			});
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			Object o = e.getSource();

			if (o.equals(btnCancel)) {
				this.dispose();
			}

			if (o.equals(btnAdd)) {
				for (DichVu dichVu : dsdv) {
					if (dichVu.getMaDichVu().equals(txtDichVu.getText())) {
						dv = dichVu;
						break;
					}
				}

				for (NhanVien nhanVien : dsnv) {
					if (nhanVien.getMaNhanVien().equals(txtNhanVien.getText())) {
						nv = nhanVien;
						break;
					}
				}

				for (KhachHang khachHang : dskh) {
					if (khachHang.getMaKhachHang().equals(txtKhachHang.getText())) {
						kh = khachHang;
						break;
					}
				}

				for (TourDuLich tourDuLich : dstour) {
					if (tourDuLich.getMaTour().equals(txtTour.getText())) {
						tour = tourDuLich;
						break;
					}
				}

				HopDongTour newHD = new HopDongTour(txtMaHopDong.getText(), LocalDate.now(), taGhiChu.getText(),
						DAO_HopDongTour.getTongTienTour(dv.getMaDichVu(), tour.getMaTour()), nv, kh, tour, dv);

				if (DAO_HopDongTour.themHopDongTour(newHD)) {
					JOptionPane.showInternalMessageDialog(null, "Thêm Thành Công");
					tblModel.setRowCount(0);
					loadData();
					DAO_VeTour.themVeTour(new VeTour(txtMaHopDong.getText().replaceAll("HD", "VT"), newHD));
					this.dispose();
				} else {
					JOptionPane.showInternalMessageDialog(null, "Thêm Thất Bại", "Lỗi", JOptionPane.ERROR_MESSAGE);
					this.dispose();
				}
			}
		}

		private void loadDataTable() {
			// TODO Auto-generated method stub
			// Nhân viên
			{
				for (NhanVien nhanVien : dsnv) {
					String[] data = nhanVien.toString().split(";");
					if (data[2].equalsIgnoreCase("true"))
						data[2] = "Nữ";
					else
						data[2] = "Nam";

					tblModelNhanVien.addRow(data);
				}
			}

			// Khách hàng
			{
				for (KhachHang khachHang : dskh) {
					String[] data = khachHang.toString().split(";");

					if (data[3].equalsIgnoreCase("true"))
						data[3] = "Nữ";
					else
						data[3] = "Nam";

					tblModelKhachHang.addRow(data);
				}
			}

			// Tour Du Lich
			{
				for (TourDuLich tour : dstour) {
					String[] data = tour.toString().split(";");

					if (Boolean.parseBoolean(data[7]) == true) {
						// Format đơn vị tiền tệ
						NumberFormat format = NumberFormat.getCurrencyInstance(new Locale("vi", "VN"));
						String donGia = format.format(Double.parseDouble(data[6]));

						String[] input = { data[0], data[1], data[2], data[3], data[4], data[5], donGia, data[7],
								data[8] };
						tblModelTour.addRow(input);
					}

					// Right Align Column
					DefaultTableCellRenderer rightRender = new DefaultTableCellRenderer();
					rightRender.setHorizontalAlignment(DefaultTableCellRenderer.RIGHT);

					TableColumnModel columnModel = tblDichVu.getColumnModel();
					int lastColumn = columnModel.getColumnCount() - 1; // Lấy cột cuối cùng
					columnModel.getColumn(lastColumn).setCellRenderer(rightRender);
				}
			}

			// Dich Vu
			{
				for (DichVu dichVu : dsdv) {
					String[] data = dichVu.toString().split(";");

					// Format đơn vị tiền tệ
					NumberFormat format = NumberFormat.getCurrencyInstance(new Locale("vi", "VN"));
					String donGia = format.format(Double.parseDouble(data[3]));

					String[] input = { data[0], data[1], data[2], donGia };
					tblModelDichVu.addRow(input);

					// Right Align Column
					DefaultTableCellRenderer rightRender = new DefaultTableCellRenderer();
					rightRender.setHorizontalAlignment(DefaultTableCellRenderer.RIGHT);

					TableColumnModel columnModel = tblDichVu.getColumnModel();
					int lastColumn = columnModel.getColumnCount() - 1; // Lấy cột cuối cùng
					columnModel.getColumn(lastColumn).setCellRenderer(rightRender);
				}
			}

		}
	}

	private class FrameModifyHopDongTour extends JFrame implements ActionListener {

		/**
		 * 
		 */
		private static final long serialVersionUID = 3063599220485930972L;
		private javax.swing.JButton btnModify;
		private javax.swing.JButton btnCancel;
		private javax.swing.JLabel lblDichVu;
		private javax.swing.JLabel lblGhiChu;
		private javax.swing.JLabel lblKhachHang;
		private javax.swing.JLabel lblMaHopDong;
		private javax.swing.JLabel lblNhanVien;
		private javax.swing.JLabel lblTour;
		private javax.swing.JPanel pnAction;
		private javax.swing.JPanel pnInfo;
		private javax.swing.JScrollPane scrDichVu;
		private javax.swing.JScrollPane scrKhachhang;
		private javax.swing.JScrollPane scrNhanVien;
		private javax.swing.JScrollPane scrTour;
		private javax.swing.JTextArea taGhiChu;
		private javax.swing.table.DefaultTableModel tblModelDichVu;
		private javax.swing.table.DefaultTableModel tblModelKhachHang;
		private javax.swing.table.DefaultTableModel tblModelNhanVien;
		private javax.swing.table.DefaultTableModel tblModelTour;
		private javax.swing.JTable tblDichVu;
		private javax.swing.JTable tblKhachHang;
		private javax.swing.JTable tblNhanVien;
		private javax.swing.JTable tblTour;
		private javax.swing.JTabbedPane tbpnData;
		private javax.swing.JTextField txtDichVu;
		private javax.swing.JScrollPane txtGhiChu;
		private javax.swing.JTextField txtKhachHang;
		private javax.swing.JTextField txtMaHopDong;
		private javax.swing.JTextField txtNhanVien;
		private javax.swing.JTextField txtTour;
		private NhanVien nv = new NhanVien();
		private KhachHang kh = new KhachHang();
		private DichVu dv = new DichVu();
		private TourDuLich tour = new TourDuLich();

		public FrameModifyHopDongTour(String[] data) {
			// TODO Auto-generated constructor stub
			this.setTitle("SE Tourist - Chỉnh Sửa Hợp Đồng Tour");
			this.setIconImage(LoadSave.GetSpriteAtlas(LoadSave.LOGO_ICON));
			this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			this.setResizable(false);
			this.setLocationRelativeTo(null);
//	    this.setMaximumSize(new java.awt.Dimension(420, 500));
//	    this.setMinimumSize(new java.awt.Dimension(420, 500));

			this.init();
			this.style();
			this.preset();
			this.event(data);
			this.loadDataTable();
		}

		private void init() {
			// TODO Auto-generated method stub
			pnInfo = new javax.swing.JPanel();
			lblMaHopDong = new javax.swing.JLabel();
			txtMaHopDong = new javax.swing.JTextField();
			lblGhiChu = new javax.swing.JLabel();
			txtGhiChu = new javax.swing.JScrollPane();
			taGhiChu = new javax.swing.JTextArea();
			lblNhanVien = new javax.swing.JLabel();
			txtNhanVien = new javax.swing.JTextField();
			lblKhachHang = new javax.swing.JLabel();
			txtKhachHang = new javax.swing.JTextField();
			lblTour = new javax.swing.JLabel();
			txtTour = new javax.swing.JTextField();
			lblDichVu = new javax.swing.JLabel();
			txtDichVu = new javax.swing.JTextField();
			tbpnData = new javax.swing.JTabbedPane();
			scrNhanVien = new javax.swing.JScrollPane();
			tblNhanVien = new javax.swing.JTable();
			scrKhachhang = new javax.swing.JScrollPane();
			tblKhachHang = new javax.swing.JTable();
			scrTour = new javax.swing.JScrollPane();
			tblTour = new javax.swing.JTable();
			scrDichVu = new javax.swing.JScrollPane();
			tblDichVu = new javax.swing.JTable();
			pnAction = new javax.swing.JPanel();
			btnModify = new javax.swing.JButton();
			btnCancel = new javax.swing.JButton();
			String[] colsNV = nv.getTitle().split(";");
			String[] colsKH = kh.getTitle().split(";");
			String[] colsTour = tour.getTitle().split(";");
			String[] colsDV = dv.getTitle().split(";");
			tblModelNhanVien = new javax.swing.table.DefaultTableModel(colsNV, 0);
			tblModelKhachHang = new javax.swing.table.DefaultTableModel(colsKH, 0);
			tblModelTour = new javax.swing.table.DefaultTableModel(colsTour, 0);
			tblModelDichVu = new javax.swing.table.DefaultTableModel(colsDV, 0);
		}

		private void style() {
			// TODO Auto-generated method stub
			pnInfo.setBorder(javax.swing.BorderFactory.createTitledBorder(
					javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED),
					"Thông tin hợp đồng", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,
					javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 14))); // NOI18N

			lblMaHopDong.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
			lblMaHopDong.setText("Mã hợp đồng");

			txtMaHopDong.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
			txtMaHopDong.setEditable(false);

			lblGhiChu.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
			lblGhiChu.setText("Ghi chú");

			taGhiChu.setColumns(20);
			taGhiChu.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
			taGhiChu.setRows(5);
			txtGhiChu.setViewportView(taGhiChu);

			lblNhanVien.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
			lblNhanVien.setText("Nhân viên thực hiện");

			txtNhanVien.setEditable(false);
			txtNhanVien.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

			lblKhachHang.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
			lblKhachHang.setText("Khách hàng đặt tour");

			txtKhachHang.setEditable(false);
			txtKhachHang.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

			lblTour.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
			lblTour.setText("Tour khách hàng đặt");

			txtTour.setEditable(false);
			txtTour.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

			lblDichVu.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
			lblDichVu.setText("Dịch vụ đi kèm");

			txtDichVu.setEditable(false);
			txtDichVu.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

			tbpnData.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

			tblNhanVien.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
			tblNhanVien.setModel(tblModelNhanVien);
			scrNhanVien.setViewportView(tblNhanVien);

			tbpnData.addTab("Nhân viên", scrNhanVien);

			tblKhachHang.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
			tblKhachHang.setModel(tblModelKhachHang);
			scrKhachhang.setViewportView(tblKhachHang);

			tbpnData.addTab("Khách hàng", scrKhachhang);

			tblTour.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
			tblTour.setModel(tblModelTour);
			scrTour.setViewportView(tblTour);

			tbpnData.addTab("Tour du lịch", scrTour);

			tblDichVu.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
			tblDichVu.setModel(tblModelDichVu);
			scrDichVu.setViewportView(tblDichVu);

			tbpnData.addTab("Dịch vụ", scrDichVu);

			pnAction.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Chon Tac Vu",
					javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,
					javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 14))); // NOI18N

			btnModify.setBackground(new java.awt.Color(0, 255, 0));
			btnModify.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
			btnModify.setForeground(new java.awt.Color(255, 255, 255));
			btnModify.setText("Cập nhật hợp đồng");
			btnModify.setToolTipText("Cập nhật hợp đồng mới");

			btnCancel.setBackground(new java.awt.Color(255, 0, 0));
			btnCancel.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
			btnCancel.setForeground(new java.awt.Color(255, 255, 255));
			btnCancel.setText("Hủy");
			btnCancel.setToolTipText("Hủy thao tác cập nhật");
		}

		private void preset() {
			// TODO Auto-generated method stub
			javax.swing.GroupLayout pnInfoLayout = new javax.swing.GroupLayout(pnInfo);
			pnInfo.setLayout(pnInfoLayout);
			pnInfoLayout.setHorizontalGroup(pnInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
					.addGroup(pnInfoLayout.createSequentialGroup().addContainerGap()
							.addGroup(pnInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
									.addComponent(txtMaHopDong)
									.addComponent(txtGhiChu, javax.swing.GroupLayout.DEFAULT_SIZE, 305, Short.MAX_VALUE)
									.addGroup(pnInfoLayout.createSequentialGroup().addGroup(pnInfoLayout
											.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
											.addComponent(lblMaHopDong, javax.swing.GroupLayout.PREFERRED_SIZE, 125,
													javax.swing.GroupLayout.PREFERRED_SIZE)
											.addComponent(lblGhiChu, javax.swing.GroupLayout.PREFERRED_SIZE, 125,
													javax.swing.GroupLayout.PREFERRED_SIZE)
											.addComponent(lblNhanVien).addComponent(lblKhachHang).addComponent(lblTour)
											.addComponent(lblDichVu)).addGap(0, 0, Short.MAX_VALUE))
									.addComponent(txtNhanVien)
									.addComponent(txtKhachHang, javax.swing.GroupLayout.Alignment.TRAILING)
									.addComponent(txtTour, javax.swing.GroupLayout.Alignment.TRAILING)
									.addComponent(txtDichVu, javax.swing.GroupLayout.Alignment.TRAILING))
							.addContainerGap()));
			pnInfoLayout.setVerticalGroup(pnInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
					.addGroup(pnInfoLayout.createSequentialGroup().addComponent(lblMaHopDong)
							.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
							.addComponent(txtMaHopDong, javax.swing.GroupLayout.PREFERRED_SIZE,
									javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(lblGhiChu)
							.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
							.addComponent(txtGhiChu, javax.swing.GroupLayout.PREFERRED_SIZE, 43,
									javax.swing.GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
							.addComponent(lblNhanVien)
							.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
							.addComponent(txtNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE,
									javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
							.addComponent(lblKhachHang)
							.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
							.addComponent(txtKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE,
									javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(lblTour)
							.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
							.addComponent(txtTour, javax.swing.GroupLayout.PREFERRED_SIZE,
									javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(lblDichVu)
							.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
									javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(txtDichVu, javax.swing.GroupLayout.PREFERRED_SIZE,
									javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)));

			javax.swing.GroupLayout pnActionLayout = new javax.swing.GroupLayout(pnAction);
			pnAction.setLayout(pnActionLayout);
			pnActionLayout
					.setHorizontalGroup(pnActionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
							.addGroup(pnActionLayout.createSequentialGroup().addContainerGap()
									.addComponent(btnModify, javax.swing.GroupLayout.PREFERRED_SIZE, 220,
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
					.addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout
							.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
							.addComponent(pnAction, javax.swing.GroupLayout.DEFAULT_SIZE,
									javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addGroup(layout.createSequentialGroup()
									.addComponent(pnInfo, javax.swing.GroupLayout.PREFERRED_SIZE,
											javax.swing.GroupLayout.DEFAULT_SIZE,
											javax.swing.GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(
											tbpnData, javax.swing.GroupLayout.DEFAULT_SIZE, 786, Short.MAX_VALUE)))
							.addContainerGap()));
			layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
					.addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout
							.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
							.addComponent(pnInfo, javax.swing.GroupLayout.PREFERRED_SIZE,
									javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
							.addComponent(tbpnData, javax.swing.GroupLayout.PREFERRED_SIZE, 387,
									javax.swing.GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
							.addComponent(pnAction, javax.swing.GroupLayout.PREFERRED_SIZE,
									javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
							.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

			pack();
		}

		private void event(String[] data) {
			// TODO Auto-generated method stub

			// Text
			txtMaHopDong.setText(data[0]);
			taGhiChu.setText(data[2]);

			// Action
			this.btnModify.addActionListener(this);
			this.btnCancel.addActionListener(this);

			this.tblDichVu.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
				@Override
				public void valueChanged(ListSelectionEvent e) {
					// Kiểm tra xem có dòng nào được chọn hay không
					boolean hasSelection = !tblDichVu.getSelectionModel().isSelectionEmpty();

					// Nếu có dòng được chọn thì lấy giá trị ô số 0 của dòng đó
					if (hasSelection) {
						int rowIndex = tblDichVu.getSelectedRow();
						String value = tblDichVu.getValueAt(rowIndex, 0).toString();
						// Thêm giá trị của ô số 0 vào textfield tương ứng
						txtDichVu.setText(value);
					}
				}
			});

			this.tblKhachHang.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
				@Override
				public void valueChanged(ListSelectionEvent e) {
					// Kiểm tra xem có dòng nào được chọn hay không
					boolean hasSelection = !tblKhachHang.getSelectionModel().isSelectionEmpty();

					// Nếu có dòng được chọn thì lấy giá trị ô số 0 của dòng đó
					if (hasSelection) {
						int rowIndex = tblKhachHang.getSelectedRow();
						String value = tblKhachHang.getValueAt(rowIndex, 0).toString();
						// Thêm giá trị của ô số 0 vào textfield tương ứng
						txtKhachHang.setText(value);
					}
				}
			});

			this.tblNhanVien.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
				@Override
				public void valueChanged(ListSelectionEvent e) {
					// Kiểm tra xem có dòng nào được chọn hay không
					boolean hasSelection = !tblNhanVien.getSelectionModel().isSelectionEmpty();

					// Nếu có dòng được chọn thì lấy giá trị ô số 0 của dòng đó
					if (hasSelection) {
						int rowIndex = tblNhanVien.getSelectedRow();
						String value = tblNhanVien.getValueAt(rowIndex, 0).toString();
						// Thêm giá trị của ô số 0 vào textfield tương ứng
						txtNhanVien.setText(value);
					}
				}
			});

			this.tblTour.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
				@Override
				public void valueChanged(ListSelectionEvent e) {
					// Kiểm tra xem có dòng nào được chọn hay không
					boolean hasSelection = !tblTour.getSelectionModel().isSelectionEmpty();

					// Nếu có dòng được chọn thì lấy giá trị ô số 0 của dòng đó
					if (hasSelection) {
						int rowIndex = tblTour.getSelectedRow();
						String value = tblTour.getValueAt(rowIndex, 0).toString();
						// Thêm giá trị của ô số 0 vào textfield tương ứng
						txtTour.setText(value);
					}
				}
			});
		}

		private void loadDataTable() {
			// Nhân viên
			{
				for (NhanVien nhanVien : dsnv) {
					String[] data = nhanVien.toString().split(";");
					if (data[2].equalsIgnoreCase("true"))
						data[2] = "Nữ";
					else
						data[2] = "Nam";

					tblModelNhanVien.addRow(data);
				}
			}

			// Khách hàng
			{
				for (KhachHang khachHang : dskh) {
					String[] data = khachHang.toString().split(";");

					if (data[3].equalsIgnoreCase("true"))
						data[3] = "Nữ";
					else
						data[3] = "Nam";

					tblModelKhachHang.addRow(data);
				}
			}

			// Tour Du Lich
			{
				for (TourDuLich tour : dstour) {
					String[] data = tour.toString().split(";");

					// Format đơn vị tiền tệ
					NumberFormat format = NumberFormat.getCurrencyInstance(new Locale("vi", "VN"));
					String donGia = format.format(Double.parseDouble(data[6]));

					String[] input = { data[0], data[1], data[2], data[3], data[4], data[5], donGia, data[7], data[8] };
					tblModelTour.addRow(input);

					// Right Align Column
					DefaultTableCellRenderer rightRender = new DefaultTableCellRenderer();
					rightRender.setHorizontalAlignment(DefaultTableCellRenderer.RIGHT);

					TableColumnModel columnModel = tblDichVu.getColumnModel();
					int lastColumn = columnModel.getColumnCount() - 1; // Lấy cột cuối cùng
					columnModel.getColumn(lastColumn).setCellRenderer(rightRender);
				}
			}

			// Dich Vu
			{
				for (DichVu dichVu : dsdv) {
					String[] data = dichVu.toString().split(";");

					// Format đơn vị tiền tệ
					NumberFormat format = NumberFormat.getCurrencyInstance(new Locale("vi", "VN"));
					String donGia = format.format(Double.parseDouble(data[3]));

					String[] input = { data[0], data[1], data[2], donGia };
					tblModelDichVu.addRow(input);

					// Right Align Column
					DefaultTableCellRenderer rightRender = new DefaultTableCellRenderer();
					rightRender.setHorizontalAlignment(DefaultTableCellRenderer.RIGHT);

					TableColumnModel columnModel = tblDichVu.getColumnModel();
					int lastColumn = columnModel.getColumnCount() - 1; // Lấy cột cuối cùng
					columnModel.getColumn(lastColumn).setCellRenderer(rightRender);
				}
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
				for (DichVu dichVu : dsdv) {
					if (dichVu.getMaDichVu().equals(txtDichVu.getText())) {
						dv = dichVu;
						break;
					}
				}

				for (NhanVien nhanVien : dsnv) {
					if (nhanVien.getMaNhanVien().equals(txtNhanVien.getText())) {
						nv = nhanVien;
						break;
					}
				}

				for (KhachHang khachHang : dskh) {
					if (khachHang.getMaKhachHang().equals(txtKhachHang.getText())) {
						kh = khachHang;
						break;
					}
				}

				for (TourDuLich tourDuLich : dstour) {
					if (tourDuLich.getMaTour().equals(txtTour.getText())) {
						tour = tourDuLich;
						break;
					}
				}

				HopDongTour modifyHD = new HopDongTour(txtMaHopDong.getText(), LocalDate.now(), taGhiChu.getText(),
						DAO_HopDongTour.getTongTienTour(dv.getMaDichVu(), tour.getMaTour()), nv, kh, tour, dv);

				if (DAO_HopDongTour.suaHopDongTour(modifyHD)) {
					JOptionPane.showInternalMessageDialog(null, "Cập nhật thành công");
					tblModel.setRowCount(0);
					loadData();
					DAO_VeTour.suaVeTour(new VeTour(txtMaHopDong.getText().replaceAll("HD", "VT"), modifyHD));
					this.dispose();
				} else {
					JOptionPane.showInternalMessageDialog(null, "Cập nhật thất bại", "Thất bại",
							JOptionPane.ERROR_MESSAGE);
					this.dispose();
				}
			}
		}
	}
}
