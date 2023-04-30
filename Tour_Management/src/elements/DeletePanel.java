package elements;

import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import DAO.DAO_DiaDanh;
import DAO.DAO_NhanVien;
import DAO.DAO_TaiKhoan;
import models.DiaDanh;
import models.DichVu;
import models.HopDongTour;
import models.KhachHang;
import models.NhanVien;
import models.TaiKhoan;
import models.TourDuLich;
import models.VeTour;
import utils.constants.ColorConstant;

public class DeletePanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7715348372927466271L;
	private JPanel pnFindToDelete;
	private ArrayList<JLabel> listTitle;
	private ArrayList<JTextField> listInput;
	private RoundJButton btnFind, btnDelete;
	private DefaultTableModel tblModel;
	private JTable tblMain;
	private JScrollPane scrMain;

	private DiaDanh diaDanh;
	private DichVu dichVu;
	private HopDongTour hopDongTour;
	private KhachHang khachHang;
	private NhanVien nhanVien;
	private TaiKhoan taiKhoan;
	private TourDuLich tourDuLich;
	private VeTour veTour;

	public DeletePanel(ArrayList<JLabel> listTitle, ArrayList<JTextField> listInput, DiaDanh diaDanh) {
		this.listTitle = listTitle;
		this.listInput = listInput;
		this.diaDanh = diaDanh;

		init(this.diaDanh);
		style();
		preset();
		event();
	}

	public DeletePanel(ArrayList<JLabel> listTitle, ArrayList<JTextField> listInput, DichVu dichvu) {
		this.listTitle = listTitle;
		this.listInput = listInput;
		this.dichVu = dichvu;

		init(this.dichVu);
		style();
		preset();
		event();
	}

	public DeletePanel(ArrayList<JLabel> listTitle, ArrayList<JTextField> listInput, HopDongTour hopDongTour) {
		this.listTitle = listTitle;
		this.listInput = listInput;
		this.hopDongTour = hopDongTour;

		init(this.hopDongTour);
		style();
		preset();
		event();
	}

	public DeletePanel(ArrayList<JLabel> listTitle, ArrayList<JTextField> listInput, KhachHang khachHang) {
		this.listTitle = listTitle;
		this.listInput = listInput;
		this.khachHang = khachHang;

		init(this.khachHang);
		style();
		preset();
		event();
	}

	public DeletePanel(ArrayList<JLabel> listTitle, ArrayList<JTextField> listInput, NhanVien nhanVien) {
		this.listTitle = listTitle;
		this.listInput = listInput;
		this.nhanVien = nhanVien;

		init(this.nhanVien);
		style();
		preset();
		event();
	}

	public DeletePanel(ArrayList<JLabel> listTitle, ArrayList<JTextField> listInput, TaiKhoan taiKhoan) {
		this.listTitle = listTitle;
		this.listInput = listInput;
		this.taiKhoan = taiKhoan;

		init(this.taiKhoan);
		style();
		preset();
		event();
	}

	public DeletePanel(ArrayList<JLabel> listTitle, ArrayList<JTextField> listInput, TourDuLich tourDuLich) {
		this.listTitle = listTitle;
		this.listInput = listInput;
		this.tourDuLich = tourDuLich;

		init(this.tourDuLich);
		style();
		preset();
		event();
	}

	public DeletePanel(ArrayList<JLabel> listTitle, ArrayList<JTextField> listInput, VeTour veTour) {
		this.listTitle = listTitle;
		this.listInput = listInput;
		this.veTour = veTour;

		init(this.veTour);
		style();
		preset();
		event();
	}

	private void init(Object o) {
		// TODO Auto-generated method stub
		// Panel
		pnFindToDelete = new javax.swing.JPanel();

		// Button
		btnFind = new RoundJButton("TÌM");

		// Model
		if (o instanceof DiaDanh) {
			DiaDanh diaDanh = (DiaDanh) o;
			String[] cols = diaDanh.getTitle().split(";");
			tblModel = new DefaultTableModel(cols, 0);
			tblModel.addColumn("Hành Động");
			loadTable(o);
		}
		if (o instanceof DichVu) {
			DichVu dichVu = (DichVu) o;
			String[] cols = dichVu.getTitle().split(";");
			tblModel = new DefaultTableModel(cols, 0);
			tblModel.addColumn("Hành Động");
			loadTable(o);
		}
		if (o instanceof HopDongTour) {
			HopDongTour hopDongTour = (HopDongTour) o;
			String[] cols = hopDongTour.getTitle().split(";");
			tblModel = new DefaultTableModel(cols, 0);
			tblModel.addColumn("Hành Động");
			loadTable(o);
		}
		if (o instanceof KhachHang) {
			KhachHang khachHang = (KhachHang) o;
			String[] cols = khachHang.getTitle().split(";");
			tblModel = new DefaultTableModel(cols, 0);
			tblModel.addColumn("Hành Động");
			loadTable(o);
		}
		if (o instanceof NhanVien) {
			NhanVien nhanVien = (NhanVien) o;
			String[] cols = nhanVien.getTitle().split(";");
			tblModel = new DefaultTableModel(cols, 0);
			tblModel.addColumn("Hành Động");
			loadTable(o);
		}
		if (o instanceof TaiKhoan) {
			TaiKhoan taiKhoan = (TaiKhoan) o;
			String[] cols = taiKhoan.getTitle().split(";");
			tblModel = new DefaultTableModel(cols, 0);
			tblModel.addColumn("Hành Động");
			loadTable(o);
		}
		if (o instanceof TourDuLich) {
			TourDuLich tourDuLich = (TourDuLich) o;
			String[] cols = tourDuLich.getTitle().split(";");
			tblModel = new DefaultTableModel(cols, 0);
			tblModel.addColumn("Hành Động");
			loadTable(o);
		}
		if (o instanceof VeTour) {
			VeTour veTour = (VeTour) o;
			String[] cols = veTour.getTitle().split(";");
			tblModel = new DefaultTableModel(cols, 0);
			tblModel.addColumn("Hành Động");
			loadTable(o);
		}

		// Table
		tblMain = new JTable(tblModel);
		scrMain = new JScrollPane(tblMain);
	}

	private void style() {
		// TODO Auto-generated method stub
		pnFindToDelete.setBorder(javax.swing.BorderFactory.createTitledBorder("Không Tìm Thấy Trên Bảng?"));

		btnFind.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
		btnFind.setText("TÌM");

		for (JTextField txt : listInput) {
			txt.setBackground(ColorConstant.BACKGROUND_NORMAL);
			txt.setForeground(ColorConstant.TEXT_NORMAL);
		}

		for (JLabel lbl : listTitle) {
			lbl.setFont(new Font("Arial", Font.PLAIN, 15));
		}
	}

	private void preset() {
		// TODO Auto-generated method stub
		javax.swing.GroupLayout pnFindToDeleteLayout = new javax.swing.GroupLayout(pnFindToDelete);
		pnFindToDelete.setLayout(pnFindToDeleteLayout);
		pnFindToDeleteLayout.setHorizontalGroup(pnFindToDeleteLayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(pnFindToDeleteLayout.createSequentialGroup().addGap(15, 15, 15)
						.addComponent(listTitle.get(0), javax.swing.GroupLayout.PREFERRED_SIZE, 200,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(18, 18, 18)
						.addComponent(listInput.get(0), javax.swing.GroupLayout.DEFAULT_SIZE, 563, Short.MAX_VALUE)
						.addGap(18, 18, 18).addComponent(btnFind, javax.swing.GroupLayout.PREFERRED_SIZE, 187,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(17, 17, 17)));
		pnFindToDeleteLayout.setVerticalGroup(pnFindToDeleteLayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(pnFindToDeleteLayout.createSequentialGroup().addContainerGap().addGroup(pnFindToDeleteLayout
						.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
						.addGroup(pnFindToDeleteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(listInput.get(0), javax.swing.GroupLayout.PREFERRED_SIZE, 36,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(listTitle.get(0), javax.swing.GroupLayout.PREFERRED_SIZE, 33,
										javax.swing.GroupLayout.PREFERRED_SIZE))
						.addComponent(btnFind, javax.swing.GroupLayout.DEFAULT_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

		scrMain.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
		this.setLayout(layout);
		layout.setHorizontalGroup(layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(pnFindToDelete,
						javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
				.addComponent(scrMain));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
						.addComponent(pnFindToDelete, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
						.addComponent(scrMain, javax.swing.GroupLayout.DEFAULT_SIZE, 552, Short.MAX_VALUE)
						.addGap(7, 7, 7)));
	}

	private void event() {
		// TODO Auto-generated method stub

	}

	public void loadTable(Object o) {
		if (o instanceof NhanVien) {
    			ArrayList<NhanVien> list = DAO_NhanVien.getAllNhanVien();
			for (NhanVien nv : list) {
				String[] rowData = nv.toString().split(";");
				tblModel.addRow(rowData);
				tblModel.setValueAt(new JButton("XÓA"), tblModel.getRowCount() - 1, tblModel.getColumnCount() - 1);
			}
		} else if (o instanceof DiaDanh) {
			ArrayList<DiaDanh> list = DAO_DiaDanh.getAllDiaDanh();
			for (DiaDanh dd : list) {
				String[] rowData = dd.toString().split(";");
				tblModel.addRow(rowData);
				tblModel.setValueAt(btnDelete, tblModel.getRowCount() - 1, tblModel.getColumnCount() - 1);
			}
		} else if (o instanceof TaiKhoan) {
			ArrayList<TaiKhoan> list = DAO_TaiKhoan.getAllTaiKhoan();
			for (TaiKhoan tk : list) {
				String[] rowData = tk.toString().split(";");
				tblModel.addRow(rowData);
				tblModel.setValueAt(btnDelete, tblModel.getRowCount() - 1, tblModel.getColumnCount() - 1);
			}
		}
	}

}
