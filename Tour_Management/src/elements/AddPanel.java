package elements;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import com.itextpdf.text.DocumentException;

import DAO.DAO_VeTour;
import controllers.PrintTicket;
import models.DiaDanh;
import models.DichVu;
import models.HopDongTour;
import models.KhachHang;
import models.NhanVien;
import models.TaiKhoan;
import models.TourDuLich;
import models.VeTour;
import utils.LoadSave;
import utils.constants.ColorConstant;

public class AddPanel extends JPanel {

    /**
     * 
     */
    private static final long serialVersionUID = -4473651476180684312L;
    private JPanel pnInput, pnControl;
    private ArrayList<JLabel> listTitle;
    private ArrayList<JTextField> listInput;
    private RoundJButton btnAdd, btnCancel, btnPrint;
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

    public AddPanel(ArrayList<JLabel> listTitle, ArrayList<JTextField> listInput, DiaDanh diaDanh) {
	this.listTitle = listTitle;
	this.listInput = listInput;
	this.diaDanh = diaDanh;

	init(this.diaDanh);
	style();
	preset();
	event(this.diaDanh);
    }

    public AddPanel(ArrayList<JLabel> listTitle, ArrayList<JTextField> listInput, DichVu dichVu) {
	this.listTitle = listTitle;
	this.listInput = listInput;
	this.dichVu = dichVu;

	init(this.dichVu);
	style();
	preset();
	event(this.dichVu);
    }

    public AddPanel(ArrayList<JLabel> listTitle, ArrayList<JTextField> listInput, HopDongTour hopDongTour) {
	this.listTitle = listTitle;
	this.listInput = listInput;
	this.hopDongTour = hopDongTour;

	init(this.hopDongTour);
	style();
	preset();
	event(this.hopDongTour);
    }

    public AddPanel(ArrayList<JLabel> listTitle, ArrayList<JTextField> listInput, KhachHang khachHang) {
	this.listTitle = listTitle;
	this.listInput = listInput;
	this.khachHang = khachHang;

	init(this.khachHang);
	style();
	preset();
	event(this.khachHang);
    }

    public AddPanel(ArrayList<JLabel> listTitle, ArrayList<JTextField> listInput, NhanVien nhanVien) {
	this.listTitle = listTitle;
	this.listInput = listInput;
	this.nhanVien = nhanVien;

	init(this.nhanVien);
	style();
	preset();
	event(this.nhanVien);
    }

    public AddPanel(ArrayList<JLabel> listTitle, ArrayList<JTextField> listInput, TaiKhoan taiKhoan) {
	this.listTitle = listTitle;
	this.listInput = listInput;
	this.taiKhoan = taiKhoan;

	init(this.taiKhoan);
	style();
	preset();
	event(this.taiKhoan);
    }

    public AddPanel(ArrayList<JLabel> listTitle, ArrayList<JTextField> listInput, TourDuLich tourDuLich) {
	this.listTitle = listTitle;
	this.listInput = listInput;
	this.tourDuLich = tourDuLich;

	init(this.tourDuLich);
	style();
	preset();
	event(this.tourDuLich);
    }

    public AddPanel(ArrayList<JLabel> listTitle, ArrayList<JTextField> listInput, VeTour veTour) {
	this.listTitle = listTitle;
	this.listInput = listInput;
	this.veTour = veTour;

	init(this.veTour);
	style();
	preset();
	event(this.veTour);
    }

    private void init(Object o) {
	// TODO Auto-generated method stub
	// Panel
	pnControl = new JPanel();
	pnInput = new JPanel();

	// Button
	btnAdd = new RoundJButton("them");
	btnCancel = new RoundJButton("them");
	btnPrint = new RoundJButton("them");

	// Model
	if (o instanceof DiaDanh) {
	    DiaDanh diaDanh = (DiaDanh) o;
	    String[] cols = diaDanh.getTitle().split(";");
	    tblModel = new DefaultTableModel(cols, 0);
	}
	if (o instanceof DichVu) {
	    DichVu dichVu = (DichVu) o;
	    String[] cols = dichVu.getTitle().split(";");
	    tblModel = new DefaultTableModel(cols, 0);
	}
	if (o instanceof HopDongTour) {
	    HopDongTour hopDongTour = (HopDongTour) o;
	    String[] cols = hopDongTour.getTitle().split(";");
	    tblModel = new DefaultTableModel(cols, 0);
	}
	if (o instanceof KhachHang) {
	    KhachHang khachHang = (KhachHang) o;
	    String[] cols = khachHang.getTitle().split(";");
	    tblModel = new DefaultTableModel(cols, 0);
	}
	if (o instanceof NhanVien) {
	    NhanVien nhanVien = (NhanVien) o;
	    String[] cols = nhanVien.getTitle().split(";");
	    tblModel = new DefaultTableModel(cols, 0);
	}
	if (o instanceof TaiKhoan) {
	    TaiKhoan taiKhoan = (TaiKhoan) o;
	    String[] cols = taiKhoan.getTitle().split(";");
	    tblModel = new DefaultTableModel(cols, 0);
	}
	if (o instanceof TourDuLich) {
	    TourDuLich tourDuLich = (TourDuLich) o;
	    String[] cols = tourDuLich.getTitle().split(";");
	    tblModel = new DefaultTableModel(cols, 0);
	}
	if (o instanceof VeTour) {
	    VeTour veTour = (VeTour) o;
	    String[] cols = veTour.getTitle().split(";");
	    tblModel = new DefaultTableModel(cols, 0);
	    this.btnAdd.setEnabled(false);
	    this.btnCancel.setEnabled(false);
	}

	// Table
	tblMain = new JTable(tblModel);
	scrMain = new JScrollPane(tblMain, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
		ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
    }

    private void style() {
	// TODO Auto-generated method stub
	BoxLayout boxLayout = new BoxLayout(pnInput, BoxLayout.Y_AXIS);
	pnInput.setLayout(boxLayout);
//	pnInput.setBackground(ColorConstant.BACKGROUND_HEADER_FOOTER);

//	pnControl.setBackground(ColorConstant.BACKGROUND_HEADER_FOOTER);
	pnControl.setBorder(BorderFactory.createTitledBorder("Lựa Chọn Thao Tác"));

	javax.swing.GroupLayout pnControlLayout = new javax.swing.GroupLayout(pnControl);
	pnControl.setLayout(pnControlLayout);
	pnControlLayout
		.setHorizontalGroup(
			pnControlLayout
				.createParallelGroup(
					javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(pnControlLayout.createSequentialGroup().addGap(121, 121, 121)
					.addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 170,
						javax.swing.GroupLayout.PREFERRED_SIZE)
					.addGap(18, 18, 18)
					.addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 170,
						javax.swing.GroupLayout.PREFERRED_SIZE)
					.addGap(18, 18, 18)
					.addComponent(btnPrint, javax.swing.GroupLayout.PREFERRED_SIZE, 170,
						javax.swing.GroupLayout.PREFERRED_SIZE)
					.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
	pnControlLayout.setVerticalGroup(pnControlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
		.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnControlLayout.createSequentialGroup()
			.addContainerGap()
			.addGroup(pnControlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
				.addComponent(btnAdd, javax.swing.GroupLayout.DEFAULT_SIZE,
					javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
				.addComponent(btnCancel).addComponent(btnPrint))
			.addContainerGap()));

	tblMain.setBackground(ColorConstant.BACKGROUND_NORMAL);
	JTableHeader header = tblMain.getTableHeader();
	header.setFont(header.getFont().deriveFont(16f));

	for (JTextField txt : listInput) {
	    txt.setBackground(ColorConstant.BACKGROUND_NORMAL);
	    txt.setForeground(ColorConstant.TEXT_NORMAL);
	}

	for (JLabel lbl : listTitle) {
	    lbl.setFont(new Font("Arial", Font.PLAIN, 15));
	}

	btnPrint.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
	btnPrint.setText("IN");

	btnCancel.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
	btnCancel.setText("HỦY");

	btnAdd.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
	btnAdd.setText("THÊM");

	tblMain.getTableHeader().setReorderingAllowed(false);

	scrMain.setBackground(ColorConstant.BACKGROUND_NORMAL);
	scrMain.setSize(Integer.MAX_VALUE, Integer.MAX_VALUE);

	GroupLayout layout = new GroupLayout(this);
	this.setLayout(layout);
	layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
		.addComponent(pnInput, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
		.addComponent(pnControl, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
		.addComponent(scrMain, GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE));
	layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout
		.createSequentialGroup()
		.addComponent(pnInput, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
		.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
		.addComponent(pnControl, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
			GroupLayout.PREFERRED_SIZE)
		.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
		.addComponent(scrMain, GroupLayout.DEFAULT_SIZE, 251, Short.MAX_VALUE)));

    }

    private void preset() {
	// TODO Auto-generated method stub

	for (int i = 0; i < listInput.size(); i++) {
	    JPanel pnInsert = new JPanel();
	    listTitle.get(i).setFont(new java.awt.Font("Segoe UI", 0, 14));
	    listInput.get(i).setFont(new java.awt.Font("Segoe UI", 0, 14));
	    javax.swing.GroupLayout pnInsertLayout = new javax.swing.GroupLayout(pnInsert);
	    pnInsert.setLayout(pnInsertLayout);
	    pnInsertLayout.setHorizontalGroup(pnInsertLayout
		    .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
		    .addGroup(pnInsertLayout.createSequentialGroup().addContainerGap()
			    .addComponent(listTitle.get(i), javax.swing.GroupLayout.PREFERRED_SIZE, 200,
				    javax.swing.GroupLayout.PREFERRED_SIZE)
			    .addGap(18, 18, 18)
			    .addComponent(listInput.get(i), javax.swing.GroupLayout.DEFAULT_SIZE, 725, Short.MAX_VALUE)
			    .addContainerGap()));
	    pnInsertLayout.setVerticalGroup(pnInsertLayout
		    .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
		    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnInsertLayout.createSequentialGroup()
			    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
			    .addGroup(pnInsertLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
				    .addComponent(listTitle.get(i), javax.swing.GroupLayout.PREFERRED_SIZE, 22,
					    javax.swing.GroupLayout.PREFERRED_SIZE)
				    .addComponent(listInput.get(i), javax.swing.GroupLayout.PREFERRED_SIZE,
					    javax.swing.GroupLayout.DEFAULT_SIZE,
					    javax.swing.GroupLayout.PREFERRED_SIZE))
			    .addContainerGap()));

	    pnInput.add(pnInsert);

	}
	pnControl.add(btnAdd);
	pnControl.add(btnCancel);
	pnControl.add(btnPrint);

	Box b1 = Box.createHorizontalBox();
	Box b2 = Box.createVerticalBox();
	b1.add(pnControl);
	b2.add(scrMain);
	pnInput.add(b1);
	pnInput.add(b2);

	Dimension maxSize = pnInput.getSize();
	scrMain.setSize(maxSize);
	this.add(pnInput);
//	this.add(scrMain);

	pnControl.add(btnAdd);
	pnControl.add(btnCancel);
	pnControl.add(btnPrint);

    }

    private void event(Object o) {
	// TODO Auto-generated method stub
	if (o instanceof DiaDanh) {

	}
	if (o instanceof DichVu) {

	}
	if (o instanceof HopDongTour) {

	}
	if (o instanceof KhachHang) {

	}
	if (o instanceof NhanVien) {

	}
	if (o instanceof TaiKhoan) {

	}
	if (o instanceof TourDuLich) {

	}
	if (o instanceof VeTour) {
	    this.btnPrint.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
		    // TODO Auto-generated method stub
		    ArrayList<VeTour> dsVeTour = DAO_VeTour.getAllVeTour();

		    for (VeTour veTour : dsVeTour) {
			try {
			    PrintTicket.printTicket(veTour.getMaVe());
			} catch (DocumentException e1) {
			    // TODO Auto-generated catch block
			    e1.printStackTrace();
			} catch (IOException e1) {
			    // TODO Auto-generated catch block
			    e1.printStackTrace();
			}
		    }
		}
	    });
	}
    }
}
