package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import elements.ImagePanel;
import services.Employee_DiaDanh;
import services.Employee_DichVu;
import services.Employee_HopDongTour;
import services.Employee_KhachHang;
import services.Employee_TourDuLich;
import services.Employee_VeTour;
import utils.LoadSave;
import utils.constants.ColorConstant;

public class Dashboard_Employee extends JFrame implements ActionListener {

    /**
     * 
     */
    private static final long serialVersionUID = 7425542322399368764L;
    private javax.swing.JButton btnDiaDanh;
    private javax.swing.JButton btnDichVu;
    private javax.swing.JButton btnHopDongTour;
    private javax.swing.JButton btnKhachHang;
    private javax.swing.JMenu btnMnAccount;
    private javax.swing.JMenu btnMnEdit;
    private javax.swing.JMenu btnMnFile;
    private javax.swing.JMenu btnMnHelp;
    private javax.swing.JMenu btnMnSetting;
    private javax.swing.JButton btnTourDuLich;
    private javax.swing.JButton btnVeTour;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JMenuBar mnMain;
    private javax.swing.JMenuItem mniLogout;
    private javax.swing.JPanel pnHeader;
    private javax.swing.JPanel pnMain;

    public Dashboard_Employee() {
	Dimension DimMax = Toolkit.getDefaultToolkit().getScreenSize();
	this.setPreferredSize(new Dimension(1920, 1080));
	this.setResizable(false);
	this.setExtendedState(JFrame.MAXIMIZED_BOTH);
	this.setMaximumSize(DimMax);
	this.setMinimumSize(new Dimension(960, 540));
	this.setTitle("SETourist - Employee Dashboard");
	this.setLocationRelativeTo(null);
	this.setBackground(ColorConstant.BACKGROUND_NORMAL);
	this.setIconImage(LoadSave.GetSpriteAtlas(LoadSave.LOGO_ICON));
	this.setDefaultCloseOperation(EXIT_ON_CLOSE);

	init();
	style();
	preset();
	event();
    }

    private void init() {
	pnHeader = new javax.swing.JPanel();
	lblTitle = new javax.swing.JLabel();
	btnDiaDanh = new javax.swing.JButton();
	btnKhachHang = new javax.swing.JButton();
	btnTourDuLich = new javax.swing.JButton();
	btnDichVu = new javax.swing.JButton();
	btnHopDongTour = new javax.swing.JButton();
	btnVeTour = new javax.swing.JButton();
	pnMain = new ImagePanel(LoadSave.GetSpriteAtlas(LoadSave.BACKGROUND_DASHBOARD), 0.5f);
	mnMain = new javax.swing.JMenuBar();
	btnMnFile = new javax.swing.JMenu();
	btnMnEdit = new javax.swing.JMenu();
	btnMnSetting = new javax.swing.JMenu();
	btnMnHelp = new javax.swing.JMenu();
	btnMnAccount = new javax.swing.JMenu();
	mniLogout = new javax.swing.JMenuItem();
    }

    private void style() {
	lblTitle.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
	lblTitle.setForeground(new java.awt.Color(77, 69, 93));
	lblTitle.setText("SE TOURIST");
	lblTitle.setIcon(new ImageIcon(LoadSave.GetSpriteAtlas(LoadSave.LOGO_LABEL)));
	lblTitle.setToolTipText("Logo");

	btnDiaDanh.setText("Địa Danh");
	btnDiaDanh.setIcon(new ImageIcon(LoadSave.GetSpriteAtlas(LoadSave.ICON_LOCATION)));

	btnKhachHang.setText("Khách Hàng");
	btnKhachHang.setIcon(new ImageIcon(LoadSave.GetSpriteAtlas(LoadSave.ICON_COSTUMER)));

	btnTourDuLich.setText("Tour Du Lịch");
	btnTourDuLich.setIcon(new ImageIcon(LoadSave.GetSpriteAtlas(LoadSave.ICON_TOUR)));

	btnDichVu.setText("Dịch Vụ");
	btnDichVu.setIcon(new ImageIcon(LoadSave.GetSpriteAtlas(LoadSave.ICON_SERVICE)));

	btnHopDongTour.setText("Hợp Đồng Tour");
	btnHopDongTour.setIcon(new ImageIcon(LoadSave.GetSpriteAtlas(LoadSave.ICON_CONTRACT)));

	btnVeTour.setText("Vé Tour");
	btnVeTour.setIcon(new ImageIcon(LoadSave.GetSpriteAtlas(LoadSave.ICON_TICKET)));

	btnMnFile.setText("File");

	btnMnEdit.setText("Edit");

	btnMnSetting.setText("Setting");

	btnMnHelp.setText("Help");

	btnMnAccount.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
	btnMnAccount.setText("Account");

	mniLogout.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F12,
		java.awt.event.InputEvent.ALT_DOWN_MASK));
	mniLogout.setText("Log Out");
	mniLogout.setIcon(new ImageIcon(LoadSave.GetSpriteAtlas(LoadSave.ICON_LOGOUT)));
    }

    private void preset() {
	javax.swing.GroupLayout pnHeaderLayout = new javax.swing.GroupLayout(pnHeader);
	pnHeader.setLayout(pnHeaderLayout);
	pnHeaderLayout.setHorizontalGroup(pnHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
		.addGroup(pnHeaderLayout.createSequentialGroup()
			.addComponent(lblTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 200,
				javax.swing.GroupLayout.PREFERRED_SIZE)
			.addGap(18, 18, 18)
			.addComponent(btnKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, 202,
				javax.swing.GroupLayout.PREFERRED_SIZE)
			.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
			.addComponent(btnDiaDanh, javax.swing.GroupLayout.PREFERRED_SIZE, 136,
				javax.swing.GroupLayout.PREFERRED_SIZE)
			.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
			.addComponent(btnTourDuLich, javax.swing.GroupLayout.PREFERRED_SIZE, 136,
				javax.swing.GroupLayout.PREFERRED_SIZE)
			.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
			.addComponent(btnHopDongTour, javax.swing.GroupLayout.PREFERRED_SIZE, 136,
				javax.swing.GroupLayout.PREFERRED_SIZE)
			.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
			.addComponent(btnVeTour, javax.swing.GroupLayout.PREFERRED_SIZE, 76,
				javax.swing.GroupLayout.PREFERRED_SIZE)
			.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
			.addComponent(btnDichVu, javax.swing.GroupLayout.PREFERRED_SIZE, 76,
				javax.swing.GroupLayout.PREFERRED_SIZE)
			.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

	pnHeaderLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] { btnDiaDanh, btnDichVu,
		btnHopDongTour, btnKhachHang, btnTourDuLich, btnVeTour });

	pnHeaderLayout.setVerticalGroup(pnHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
		.addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
			pnHeaderLayout.createSequentialGroup().addGap(0, 0, Short.MAX_VALUE)
				.addGroup(pnHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
					.addComponent(btnKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, 38,
						javax.swing.GroupLayout.PREFERRED_SIZE)
					.addComponent(btnDichVu, javax.swing.GroupLayout.PREFERRED_SIZE, 38,
						javax.swing.GroupLayout.PREFERRED_SIZE)
					.addComponent(btnVeTour, javax.swing.GroupLayout.PREFERRED_SIZE, 38,
						javax.swing.GroupLayout.PREFERRED_SIZE)
					.addComponent(btnHopDongTour, javax.swing.GroupLayout.PREFERRED_SIZE, 38,
						javax.swing.GroupLayout.PREFERRED_SIZE)
					.addComponent(btnTourDuLich, javax.swing.GroupLayout.PREFERRED_SIZE, 38,
						javax.swing.GroupLayout.PREFERRED_SIZE)
					.addComponent(btnDiaDanh, javax.swing.GroupLayout.PREFERRED_SIZE, 38,
						javax.swing.GroupLayout.PREFERRED_SIZE)))
		.addComponent(lblTitle, javax.swing.GroupLayout.Alignment.TRAILING,
			javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));

	pnHeaderLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] { btnDiaDanh, btnDichVu,
		btnHopDongTour, btnKhachHang, btnTourDuLich, btnVeTour });

	getContentPane().add(pnHeader, java.awt.BorderLayout.NORTH);

	javax.swing.GroupLayout pnMainLayout = new javax.swing.GroupLayout(pnMain);
	pnMain.setLayout(pnMainLayout);
	pnMainLayout.setHorizontalGroup(pnMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
		.addGap(0, 1422, Short.MAX_VALUE));
	pnMainLayout.setVerticalGroup(pnMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
		.addGap(0, 239, Short.MAX_VALUE));

	getContentPane().add(pnMain, java.awt.BorderLayout.CENTER);

	btnMnAccount.add(mniLogout);

	mnMain.add(btnMnFile);
	mnMain.add(btnMnEdit);
	mnMain.add(btnMnSetting);
	mnMain.add(btnMnHelp);
	mnMain.add(btnMnAccount);

	setJMenuBar(mnMain);
    }

    private void event() {
	this.btnKhachHang.addActionListener(this);
	this.btnTourDuLich.addActionListener(this);
	this.btnDiaDanh.addActionListener(this);
	this.btnDichVu.addActionListener(this);
	this.btnHopDongTour.addActionListener(this);
	this.btnVeTour.addActionListener(this);
	this.mniLogout.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
	Object o = e.getSource();
	if (o.equals(btnDiaDanh)) {
	    getContentPane().remove(pnMain);
	    pnMain = new Employee_DiaDanh();
	    getContentPane().add(pnMain, BorderLayout.CENTER);
	    this.revalidate();
	    this.repaint();
	}
	if (o.equals(btnDichVu)) {
	    getContentPane().remove(pnMain);
	    pnMain = new Employee_DichVu();
	    getContentPane().add(pnMain, BorderLayout.CENTER);
	    this.revalidate();
	    this.repaint();
	}
	if (o.equals(btnHopDongTour)) {
	    getContentPane().remove(pnMain);
	    pnMain = new Employee_HopDongTour();
	    getContentPane().add(pnMain, BorderLayout.CENTER);
	    this.revalidate();
	    this.repaint();
	}
	if (o.equals(btnKhachHang)) {
	    getContentPane().remove(pnMain);
	    pnMain = new Employee_KhachHang();
	    getContentPane().add(pnMain, BorderLayout.CENTER);
	    this.revalidate();
	    this.repaint();
	}
	if (o.equals(btnTourDuLich)) {
	    getContentPane().remove(pnMain);
	    pnMain = new Employee_TourDuLich();
	    getContentPane().add(pnMain, BorderLayout.CENTER);
	    this.revalidate();
	    this.repaint();
	}
	if (o.equals(btnVeTour)) {
	    getContentPane().remove(pnMain);
	    pnMain = new Employee_VeTour();
	    getContentPane().add(pnMain, BorderLayout.CENTER);
	    this.revalidate();
	    this.repaint();
	}
	if (o.equals(mniLogout)) {
	    int choice = JOptionPane.showConfirmDialog(null, "Bạn có chắc muốn đăng xuất?", "Xác nhận đăng xuất",
		    JOptionPane.YES_NO_OPTION);
	    if (choice == JOptionPane.YES_OPTION) {
		this.dispose();
		Login login = new Login();
		login.setVisible(true);
	    }
	}
    }
}
