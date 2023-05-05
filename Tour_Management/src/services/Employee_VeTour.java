package services;

import java.awt.Component;
import java.awt.Desktop;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.ImageIcon;
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

import com.itextpdf.text.DocumentException;

import DAO.DAO_VeTour;
import controllers.CtrlVeTour;
import controllers.PrintTicket;
import entity.VeTour;
import utils.LoadSave;
import utils.constants.ColorConstant;

/**
 * 
 * @author LE MINH BAO
 */
public class Employee_VeTour extends JPanel implements ActionListener {
	private static final long serialVersionUID = -2105223887261403595L;
	private javax.swing.JButton btnInfo;
	private javax.swing.JButton btnPrint;
	private javax.swing.JButton btnSearchMaVe;
	private javax.swing.JComboBox<String> cbxFilter;
	private javax.swing.JLabel lblFilter;
	private javax.swing.JLabel lblSearchMaVe;
	private javax.swing.JPanel pnAction;
	private javax.swing.JPanel pnData;
	private javax.swing.JPanel pnSearchMaVe;
	private javax.swing.JScrollPane scrData;
	private javax.swing.JTable tblVeTour;
	private javax.swing.table.DefaultTableModel tblModel;
	private javax.swing.JTabbedPane tpnSearch;
	private javax.swing.JTextField txtSearchMaVe;
	private String[] cols = new VeTour().getTitle().split(";");
	private ArrayList<VeTour> dsVeTour = new ArrayList<VeTour>();
	private String[] cbxItem = { "Sắp xếp theo mã vé", "Sắp xếp theo ngày đi", "Sắp xếp thep khách hàng" };

	public Employee_VeTour() {
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
		pnSearchMaVe = new javax.swing.JPanel();
		lblSearchMaVe = new javax.swing.JLabel();
		txtSearchMaVe = new javax.swing.JTextField();
		btnSearchMaVe = new javax.swing.JButton();
		pnData = new javax.swing.JPanel();
		lblFilter = new javax.swing.JLabel();
		cbxFilter = new javax.swing.JComboBox<>();
		scrData = new javax.swing.JScrollPane();
		/**
		 * Table
		 */
		{
			tblModel = new javax.swing.table.DefaultTableModel(cols, 0);
			tblVeTour = new javax.swing.JTable(tblModel);
		}
		pnAction = new javax.swing.JPanel();
		btnInfo = new javax.swing.JButton();
		btnPrint = new javax.swing.JButton();
	}

	private void style() {
		// TODO Auto-generated method stub
		lblSearchMaVe.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
		lblSearchMaVe.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		lblSearchMaVe.setText("Ma Ve Tour Can Tim:");

		txtSearchMaVe.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

		btnSearchMaVe.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
		btnSearchMaVe.setText("Tim");

		pnData.setBorder(javax.swing.BorderFactory.createTitledBorder(
				javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED), "Danh Sach Ve Tour",
				javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION,
				new java.awt.Font("Segoe UI", 0, 14))); // NOI18N

		lblFilter.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		lblFilter.setText("Lọc Theo:");

		scrData.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
		scrData.setViewportView(tblVeTour);

		pnAction.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Chon Tac Vu",
				javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION,
				new java.awt.Font("Segoe UI", 0, 14))); // NOI18N

		btnInfo.setText("Xem Thong Tin");
		btnInfo.setToolTipText("Xem thong tin ve tour (Ctrl + I)");
		btnInfo.setEnabled(false);

		btnPrint.setText("In Ve Tour");
		btnPrint.setToolTipText("In ve tour (Ctrl + I)");
		btnPrint.setEnabled(false);
	}

	private void preset() {
		// TODO Auto-generated method stub
		javax.swing.GroupLayout pnSearchMaVeLayout = new javax.swing.GroupLayout(pnSearchMaVe);
		pnSearchMaVe.setLayout(pnSearchMaVeLayout);
		pnSearchMaVeLayout
				.setHorizontalGroup(pnSearchMaVeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(pnSearchMaVeLayout.createSequentialGroup().addContainerGap()
								.addComponent(lblSearchMaVe, javax.swing.GroupLayout.PREFERRED_SIZE, 250,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGap(18, 18, 18)
								.addComponent(txtSearchMaVe, javax.swing.GroupLayout.DEFAULT_SIZE, 429, Short.MAX_VALUE)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
								.addComponent(btnSearchMaVe, javax.swing.GroupLayout.PREFERRED_SIZE, 165,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addContainerGap()));
		pnSearchMaVeLayout.setVerticalGroup(pnSearchMaVeLayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(pnSearchMaVeLayout.createSequentialGroup().addContainerGap().addGroup(pnSearchMaVeLayout
						.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
						.addGroup(pnSearchMaVeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(txtSearchMaVe, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(lblSearchMaVe, javax.swing.GroupLayout.PREFERRED_SIZE, 31,
										javax.swing.GroupLayout.PREFERRED_SIZE))
						.addComponent(btnSearchMaVe, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
						.addContainerGap(9, Short.MAX_VALUE)));

		tpnSearch.addTab("Tim Theo Ma Ve", pnSearchMaVe);

		javax.swing.GroupLayout pnActionLayout = new javax.swing.GroupLayout(pnAction);
		pnAction.setLayout(pnActionLayout);
		pnActionLayout.setHorizontalGroup(pnActionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(pnActionLayout.createSequentialGroup().addContainerGap()
						.addComponent(btnInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 173,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(btnPrint, javax.swing.GroupLayout.PREFERRED_SIZE, 104,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

		pnActionLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] { btnInfo, btnPrint });

		pnActionLayout.setVerticalGroup(pnActionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
						pnActionLayout.createSequentialGroup().addContainerGap()
								.addGroup(pnActionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
										.addComponent(btnInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 31,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addComponent(btnPrint))
								.addContainerGap()));

		pnActionLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] { btnInfo, btnPrint });

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
		btnSearchMaVe.addActionListener(this);

		// Action
		btnInfo.addActionListener(this);
		btnPrint.addActionListener(this);

		// Table
		this.tblVeTour.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent e) {
				// TODO Auto-generated method stub
				// Kiểm tra xem có dòng nào được chọn hay không
				boolean hasSelection = !tblVeTour.getSelectionModel().isSelectionEmpty();

				// Đặt giá trị cho thuộc tính enabled của btnInfo tương ứng với hasSelection
				btnInfo.setEnabled(hasSelection);
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
					int selectedRow = tblVeTour.getSelectedRow();

					// Lấy số cột của bảng
					int columnsCount = tblVeTour.getColumnCount();

					// Tạo một mảng String để chứa dữ liệu của hàng đang được chọn
					String[] data = new String[columnsCount];

					// Duyệt qua các cột của hàng đang được chọn và lưu giá trị vào mảng data
					for (int i = 0; i < columnsCount; i++) {
						data[i] = tblVeTour.getValueAt(selectedRow, i).toString();
					}

					new FrameInfoVeTour(data).setVisible(true);
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
					int selectedRow = tblVeTour.getSelectedRow();

					// Lấy số cột của bảng
					int columnsCount = tblVeTour.getColumnCount();

					// Tạo một mảng String để chứa dữ liệu của hàng đang được chọn
					String[] data = new String[columnsCount];

					// Duyệt qua các cột của hàng đang được chọn và lưu giá trị vào mảng data
					for (int i = 0; i < columnsCount; i++) {
						data[i] = tblVeTour.getValueAt(selectedRow, i).toString();
					}
					JFileChooser fileChooser = new JFileChooser();
					fileChooser.setDialogTitle("Chon Vi Tri Luu Ve Tour");
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
									PrintTicket.printTicket(data[0], filePath);
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
								PrintTicket.printTicket(data[0], filePath);
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

	private void loadData() {
		// TODO Auto-generated method stub
		ArrayList<VeTour> dsvt = DAO_VeTour.getAllVeTour();

		for (VeTour veTour : dsvt) {
			String[] data = veTour.toString().split(";");
			// Create a font with a larger size
			Font largerFont = tblVeTour.getFont().deriveFont(14f);

			// Set the cell renderer for all columns
			for (int i = 0; i < tblVeTour.getColumnModel().getColumnCount(); i++) {
				tblVeTour.getColumnModel().getColumn(i).setCellRenderer(new DefaultTableCellRenderer() {
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

	private void loadDataToTable(ArrayList<VeTour> dsIn, DefaultTableModel model) {
		model.setRowCount(0);
		for (VeTour vt : dsIn) {
			addOneRowToTable(vt, model);
		}
	}

	private void addOneRowToTable(VeTour vt, DefaultTableModel model) {
		model.addRow(new Object[] { vt.getMaVe(), vt.getHopDong().getKhachHang().getTenKhachHang(),
				vt.getHopDong().getTourDuLich().getTenTour(), vt.getHopDong().getTourDuLich().getNgayDi() });
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object o = e.getSource();
		// Search
		if (o.equals(btnSearchMaVe)) {
			dsVeTour = DAO_VeTour.getAllVeTour();
			if (txtSearchMaVe.getText().trim().equals("") || txtSearchMaVe.getText().trim().equals(null)) {
				loadDataToTable(dsVeTour, tblModel);
			} else {
				loadDataToTable(CtrlVeTour.locVeTourTheoMaVe(dsVeTour, txtSearchMaVe.getText().trim()), tblModel);
			}
			txtSearchMaVe.setText("");
		}

		if (o.equals(cbxFilter)) {
			// {"Sắp xếp theo mã vé", "Sắp xếp theo ngày đi", "Sắp xếp theo khách hàng"}
			dsVeTour = DAO_VeTour.getAllVeTour();
			if (cbxFilter.getSelectedIndex() == 0) {
				loadDataToTable(CtrlVeTour.sapXepVeTourTheoMa(dsVeTour), tblModel);
			} else if (cbxFilter.getSelectedIndex() == 1) {
				loadDataToTable(CtrlVeTour.sapXepVeTourTheoNgay(dsVeTour), tblModel);
			} else if (cbxFilter.getSelectedIndex() == 2) {
				loadDataToTable(CtrlVeTour.sapVeTourTheoTenKH(dsVeTour), tblModel);
			}
		}
		// Action
		if (o.equals(btnInfo)) {
			// Lấy chỉ số của hàng đang được chọn
			int selectedRow = tblVeTour.getSelectedRow();

			// Lấy số cột của bảng
			int columnsCount = tblVeTour.getColumnCount();

			// Tạo một mảng String để chứa dữ liệu của hàng đang được chọn
			String[] data = new String[columnsCount];

			// Duyệt qua các cột của hàng đang được chọn và lưu giá trị vào mảng data
			for (int i = 0; i < columnsCount; i++) {
				data[i] = tblVeTour.getValueAt(selectedRow, i).toString();
			}
			new FrameInfoVeTour(data).setVisible(true);
		}

		if (o.equals(btnPrint)) {
			// Lấy chỉ số của hàng đang được chọn
			int selectedRow = tblVeTour.getSelectedRow();

			// Lấy số cột của bảng
			int columnsCount = tblVeTour.getColumnCount();

			// Tạo một mảng String để chứa dữ liệu của hàng đang được chọn
			String[] data = new String[columnsCount];

			// Duyệt qua các cột của hàng đang được chọn và lưu giá trị vào mảng data
			for (int i = 0; i < columnsCount; i++) {
				data[i] = tblVeTour.getValueAt(selectedRow, i).toString();
			}
			JFileChooser fileChooser = new JFileChooser();
			fileChooser.setDialogTitle("Chon Vi Tri Luu Hop Dong");
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
							PrintTicket.printTicket(data[0], filePath);
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
						PrintTicket.printTicket(data[0], filePath);
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

	private class FrameInfoVeTour extends JFrame {
		/**
		 * 
		 */
		private static final long serialVersionUID = -5991069744176954328L;
		private javax.swing.JLabel lblDiaDanh;
		private javax.swing.JLabel lblLogo;
		private javax.swing.JLabel lblMaVe;
		private javax.swing.JLabel lblNgayDi;
		private javax.swing.JLabel lblNgayIn;
		private javax.swing.JLabel lblTenKH;
		private javax.swing.JLabel lblTitle;
		private javax.swing.JPanel pnInfo;
		private javax.swing.JTextField txtDiaDanh;
		private javax.swing.JTextField txtNgayDi;
		private javax.swing.JTextField txtTenKH;

		public FrameInfoVeTour(String[] data) {
			this.setTitle("SE Tourist - Thong Tin Ve Tour");
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
			lblLogo = new javax.swing.JLabel(new ImageIcon(LoadSave.GetSpriteAtlas(LoadSave.LOGO_LABEL)));
			lblTitle = new javax.swing.JLabel();
			lblMaVe = new javax.swing.JLabel();
			lblTenKH = new javax.swing.JLabel();
			txtTenKH = new javax.swing.JTextField();
			lblDiaDanh = new javax.swing.JLabel();
			txtDiaDanh = new javax.swing.JTextField();
			lblNgayDi = new javax.swing.JLabel();
			txtNgayDi = new javax.swing.JTextField();
			lblNgayIn = new javax.swing.JLabel();
		}

		private void style() {
			// TODO Auto-generated method stub
			pnInfo.setBorder(javax.swing.BorderFactory
					.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0))));

			lblLogo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

			lblTitle.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
			lblTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
			lblTitle.setText("SE Tourist -Vé tour du lịch");

			lblMaVe.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
			lblMaVe.setForeground(new java.awt.Color(255, 0, 0));
			lblMaVe.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
			lblMaVe.setText("Mã vé: ");

			lblTenKH.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
			lblTenKH.setText("Tên khách hàng:");

			txtTenKH.setEditable(false);

			lblDiaDanh.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
			lblDiaDanh.setText("Địa danh:");

			txtDiaDanh.setEditable(false);

			lblNgayDi.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
			lblNgayDi.setText("Ngày đi:");

			txtNgayDi.setEditable(false);

			lblNgayIn.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
			lblNgayIn.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
			lblNgayIn.setText("Ngày in vé: ");

		}

		private void preset() {
			// TODO Auto-generated method stub
			javax.swing.GroupLayout pnInfoLayout = new javax.swing.GroupLayout(pnInfo);
			pnInfo.setLayout(pnInfoLayout);
			pnInfoLayout.setHorizontalGroup(pnInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
					.addGroup(pnInfoLayout.createSequentialGroup().addGroup(pnInfoLayout
							.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
							.addGroup(pnInfoLayout.createSequentialGroup().addContainerGap().addGroup(pnInfoLayout
									.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
									.addGroup(pnInfoLayout.createSequentialGroup().addComponent(lblTenKH)
											.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
											.addComponent(txtTenKH))
									.addGroup(pnInfoLayout.createSequentialGroup()
											.addComponent(lblLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 47,
													javax.swing.GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
											.addComponent(lblTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 374,
													javax.swing.GroupLayout.PREFERRED_SIZE))))
							.addGroup(pnInfoLayout.createSequentialGroup().addContainerGap().addComponent(lblDiaDanh)
									.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
									.addComponent(txtDiaDanh))
							.addGroup(pnInfoLayout.createSequentialGroup().addContainerGap().addComponent(lblNgayDi)
									.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
									.addComponent(txtNgayDi))
							.addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
									pnInfoLayout.createSequentialGroup()
											.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
											.addComponent(lblNgayIn, javax.swing.GroupLayout.PREFERRED_SIZE, 219,
													javax.swing.GroupLayout.PREFERRED_SIZE))
							.addGroup(pnInfoLayout.createSequentialGroup().addGap(149, 149, 149)
									.addComponent(lblMaVe, javax.swing.GroupLayout.PREFERRED_SIZE, 163,
											javax.swing.GroupLayout.PREFERRED_SIZE)
									.addGap(0, 0, Short.MAX_VALUE)))
							.addContainerGap()));

			pnInfoLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL,
					new java.awt.Component[] { lblDiaDanh, lblNgayDi, lblTenKH });

			pnInfoLayout.setVerticalGroup(pnInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
					.addGroup(pnInfoLayout.createSequentialGroup().addContainerGap()
							.addGroup(pnInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
									.addComponent(lblLogo, javax.swing.GroupLayout.DEFAULT_SIZE,
											javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(lblTitle, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE))
							.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(lblMaVe)
							.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
							.addGroup(pnInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
									.addComponent(lblTenKH).addComponent(txtTenKH,
											javax.swing.GroupLayout.PREFERRED_SIZE,
											javax.swing.GroupLayout.DEFAULT_SIZE,
											javax.swing.GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
							.addGroup(pnInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
									.addComponent(lblDiaDanh).addComponent(txtDiaDanh,
											javax.swing.GroupLayout.PREFERRED_SIZE,
											javax.swing.GroupLayout.DEFAULT_SIZE,
											javax.swing.GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
							.addGroup(pnInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
									.addComponent(lblNgayDi).addComponent(txtNgayDi,
											javax.swing.GroupLayout.PREFERRED_SIZE,
											javax.swing.GroupLayout.DEFAULT_SIZE,
											javax.swing.GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
							.addComponent(lblNgayIn)
							.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

			javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
			getContentPane().setLayout(layout);
			layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
					.addGroup(layout.createSequentialGroup().addContainerGap().addComponent(pnInfo,
							javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addContainerGap()));
			layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
					.addGroup(layout.createSequentialGroup().addContainerGap().addComponent(pnInfo,
							javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addContainerGap()));

			pack();
		}

		private void event(String[] data) {
			// TODO Auto-generated method stub
			this.lblMaVe.setText(lblMaVe.getText() + data[0]);
			this.txtTenKH.setText(data[1]);
			this.txtDiaDanh.setText(data[2]);
			this.txtNgayDi.setText(data[3]);
			this.lblNgayIn.setText(lblNgayIn.getText() + LocalDate.now());
		}
	}

}
