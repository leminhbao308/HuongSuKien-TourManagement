package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import DAO.DAO_NhanVien;
import DAO.DAO_TaiKhoan;
import controllers.CtrlLogin;
import elements.ImagePanel;
import entity.TaiKhoan;
import services.Admin_NhanVien;
import services.Admin_TaiKhoan;
import services.Employee_DiaDanh;
import services.Employee_DichVu;
import services.Employee_HopDongTour;
import services.Employee_KhachHang;
import services.Employee_TourDuLich;
import services.Employee_VeTour;
import utils.LoadSave;
import utils.constants.ColorConstant;

/**
 * Giao Diện của Admin (Quản lý)
 * 
 * @author LeMinhBao
 *
 */
public class Dashboard_Admin extends JFrame implements ActionListener {

    /**
     * 
     */
    private static final long serialVersionUID = -6100428245952328403L;
    private JButton btnDiaDanh;
    private JButton btnDichVu;
    private JButton btnHopDongTour;
    private JButton btnKhachHang;
    private javax.swing.JMenu btnMnAccount;
    private javax.swing.JMenu btnMnEdit;
    private javax.swing.JMenu btnMnFile;
    private javax.swing.JMenu btnMnHelp;
    private javax.swing.JMenu btnMnSetting;
    private JButton btnNhanVien;
    private JButton btnTaiKhoan;
    private JButton btnTourDuLich;
    private JButton btnVeTour;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JMenuBar mnMain;
    private javax.swing.JMenuItem mniChangePass;
    private javax.swing.JMenuItem mniLogout;
    private javax.swing.JPanel pnHeader;
    private javax.swing.JPanel pnMain;
    private String maNV;

    public Dashboard_Admin(String maNV) {
	Dimension DimMax = Toolkit.getDefaultToolkit().getScreenSize();
	this.setPreferredSize(new Dimension(1920, 1080));
	this.setResizable(false);
	this.setExtendedState(JFrame.MAXIMIZED_BOTH);
	this.setMaximumSize(DimMax);
	this.setMinimumSize(new Dimension(960, 540));
	this.setTitle("SETourist - Admin Dashboard");
	this.setLocationRelativeTo(null);
	this.setBackground(ColorConstant.BACKGROUND_NORMAL);
	this.setIconImage(LoadSave.GetSpriteAtlas(LoadSave.LOGO_ICON));
	this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	this.maNV = maNV;

	init();
	style();
	preset();
	event();
    }

    private void init() {
	pnHeader = new javax.swing.JPanel();
	lblTitle = new javax.swing.JLabel();
	btnNhanVien = new JButton();
	btnTaiKhoan = new JButton();
	btnDiaDanh = new JButton();
	btnKhachHang = new JButton();
	btnTourDuLich = new JButton();
	btnDichVu = new JButton();
	btnHopDongTour = new JButton();
	btnVeTour = new JButton();
	pnMain = new ImagePanel(LoadSave.GetSpriteAtlas(LoadSave.BACKGROUND_DASHBOARD), 0.5f);
	mnMain = new javax.swing.JMenuBar();
	btnMnFile = new javax.swing.JMenu();
	btnMnEdit = new javax.swing.JMenu();
	btnMnSetting = new javax.swing.JMenu();
	btnMnHelp = new javax.swing.JMenu();
	btnMnAccount = new javax.swing.JMenu();
	mniChangePass = new javax.swing.JMenuItem();
	mniLogout = new javax.swing.JMenuItem();
    }

    private void style() {
	lblTitle.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
	lblTitle.setForeground(new java.awt.Color(77, 69, 93));
	lblTitle.setText("SE TOURIST");
	lblTitle.setIcon(new ImageIcon(LoadSave.GetSpriteAtlas(LoadSave.LOGO_LABEL)));
	lblTitle.setToolTipText("Logo");

	btnNhanVien.setText("Nhân Viên");
	btnNhanVien.setIcon(new ImageIcon(LoadSave.GetSpriteAtlas(LoadSave.ICON_EMPLOYEE)));

	btnTaiKhoan.setText("Tài Khoản");
	btnTaiKhoan.setIcon(new ImageIcon(LoadSave.GetSpriteAtlas(LoadSave.ICON_PROFILE)));

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

	mniChangePass.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F11,
		java.awt.event.InputEvent.ALT_DOWN_MASK));
	mniChangePass.setText("Change Password");
	mniChangePass.setIcon(new ImageIcon(LoadSave.GetSpriteAtlas(LoadSave.ICON_PASS)));

	mniLogout.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F12,
		java.awt.event.InputEvent.ALT_DOWN_MASK));
	mniLogout.setText("Log Out");
	mniLogout.setIcon(new ImageIcon(LoadSave.GetSpriteAtlas(LoadSave.ICON_LOGOUT)));
    }

    private void preset() {
	javax.swing.GroupLayout pnHeaderLayout = new javax.swing.GroupLayout(pnHeader);
	pnHeader.setLayout(pnHeaderLayout);
	pnHeaderLayout
		.setHorizontalGroup(
			pnHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(pnHeaderLayout.createSequentialGroup()
					.addComponent(lblTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 200,
						javax.swing.GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
					.addComponent(btnNhanVien, javax.swing.GroupLayout.DEFAULT_SIZE,
						javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
					.addComponent(btnTaiKhoan, javax.swing.GroupLayout.DEFAULT_SIZE,
						javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
					.addComponent(btnKhachHang, javax.swing.GroupLayout.DEFAULT_SIZE,
						javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
					.addComponent(btnDiaDanh, javax.swing.GroupLayout.DEFAULT_SIZE,
						javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
					.addComponent(btnTourDuLich, javax.swing.GroupLayout.DEFAULT_SIZE,
						javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
					.addComponent(btnHopDongTour, javax.swing.GroupLayout.DEFAULT_SIZE,
						javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
					.addComponent(btnVeTour, javax.swing.GroupLayout.DEFAULT_SIZE,
						javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
					.addComponent(btnDichVu, javax.swing.GroupLayout.DEFAULT_SIZE,
						javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addContainerGap()));
	pnHeaderLayout.setVerticalGroup(pnHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
		.addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
			pnHeaderLayout.createSequentialGroup().addGap(0, 0, Short.MAX_VALUE)
				.addGroup(pnHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
					.addComponent(btnNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 38,
						javax.swing.GroupLayout.PREFERRED_SIZE)
					.addComponent(btnTaiKhoan, javax.swing.GroupLayout.PREFERRED_SIZE, 38,
						javax.swing.GroupLayout.PREFERRED_SIZE)
					.addComponent(btnKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, 38,
						javax.swing.GroupLayout.PREFERRED_SIZE)
					.addComponent(btnDiaDanh, javax.swing.GroupLayout.PREFERRED_SIZE, 38,
						javax.swing.GroupLayout.PREFERRED_SIZE)
					.addComponent(btnTourDuLich, javax.swing.GroupLayout.PREFERRED_SIZE, 38,
						javax.swing.GroupLayout.PREFERRED_SIZE)
					.addComponent(btnHopDongTour, javax.swing.GroupLayout.PREFERRED_SIZE, 38,
						javax.swing.GroupLayout.PREFERRED_SIZE)
					.addComponent(btnVeTour, javax.swing.GroupLayout.PREFERRED_SIZE, 38,
						javax.swing.GroupLayout.PREFERRED_SIZE)
					.addComponent(btnDichVu, javax.swing.GroupLayout.PREFERRED_SIZE, 38,
						javax.swing.GroupLayout.PREFERRED_SIZE)))
		.addComponent(lblTitle, javax.swing.GroupLayout.Alignment.TRAILING,
			javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));

	getContentPane().add(pnHeader, java.awt.BorderLayout.NORTH);

	javax.swing.GroupLayout pnMainLayout = new javax.swing.GroupLayout(pnMain);
	pnMain.setLayout(pnMainLayout);
	pnMainLayout.setHorizontalGroup(pnMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
		.addGap(0, 913, Short.MAX_VALUE));
	pnMainLayout.setVerticalGroup(pnMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
		.addGap(0, 239, Short.MAX_VALUE));

	getContentPane().add(pnMain, java.awt.BorderLayout.CENTER);

	btnMnAccount.add(mniChangePass);
	btnMnAccount.add(mniLogout);

	mnMain.add(btnMnFile);
	mnMain.add(btnMnEdit);
	mnMain.add(btnMnSetting);
	mnMain.add(btnMnHelp);
	mnMain.add(btnMnAccount);

	setJMenuBar(mnMain);
    }

    private void event() {
	this.btnNhanVien.addActionListener(this);
	this.btnTaiKhoan.addActionListener(this);
	this.btnDiaDanh.addActionListener(this);
	this.btnDichVu.addActionListener(this);
	this.btnHopDongTour.addActionListener(this);
	this.btnKhachHang.addActionListener(this);
	this.btnTourDuLich.addActionListener(this);
	this.btnVeTour.addActionListener(this);

	this.mniLogout.addActionListener(this);
	this.mniChangePass.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
	Object o = e.getSource();
	if (o.equals(btnNhanVien)) {
	    getContentPane().remove(pnMain);
	    pnMain = new Admin_NhanVien();
	    getContentPane().add(pnMain, BorderLayout.CENTER);
	    this.revalidate();
	    this.repaint();
	}
	if (o.equals(btnTaiKhoan)) {
	    getContentPane().remove(pnMain);
	    pnMain = new Admin_TaiKhoan();
	    getContentPane().add(pnMain, BorderLayout.CENTER);
	    this.revalidate();
	    this.repaint();
	}
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
	if (o.equals(mniChangePass)) {
	    new FrameChangePassword().setVisible(true);
	}
    }

    private class FrameChangePassword extends JFrame implements ActionListener, FocusListener, KeyListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6967948219796007619L;
	private javax.swing.JButton btnChange;
	private javax.swing.JLabel lblPassConfirm;
	private javax.swing.JLabel lblPassNew;
	private javax.swing.JLabel lblPassOld;
	private javax.swing.JPanel pnPass;
	private javax.swing.JPasswordField txtPassConfirm;
	private javax.swing.JPasswordField txtPassNew;
	private javax.swing.JPasswordField txtPassOld;

	public FrameChangePassword() {
	    this.setTitle("SE Tourist - Thay Đổi Mật Khẩu");
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
	}

	private void init() {
	    // TODO Auto-generated method stub
	    pnPass = new javax.swing.JPanel();
	    lblPassOld = new javax.swing.JLabel();
	    txtPassOld = new javax.swing.JPasswordField();
	    txtPassNew = new javax.swing.JPasswordField();
	    lblPassNew = new javax.swing.JLabel();
	    txtPassConfirm = new javax.swing.JPasswordField();
	    lblPassConfirm = new javax.swing.JLabel();
	    btnChange = new javax.swing.JButton();
	}

	private void style() {
	    // TODO Auto-generated method stub
	    pnPass.setBorder(javax.swing.BorderFactory.createTitledBorder(
		    javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED),
		    "Thay Đổi Mật Khẩu", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,
		    javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 14),
		    new java.awt.Color(255, 0, 0))); // NOI18N

	    lblPassOld.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
	    lblPassOld.setText("Mật khẩu hiện tại");

	    txtPassOld.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

	    txtPassNew.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

	    lblPassNew.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
	    lblPassNew.setText("Mật khẩu mới");

	    txtPassConfirm.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

	    lblPassConfirm.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
	    lblPassConfirm.setText("Nhập lại mật khẩu");

	    btnChange.setBackground(new java.awt.Color(255, 0, 0));
	    btnChange.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
	    btnChange.setForeground(new java.awt.Color(255, 255, 255));
	    btnChange.setText("Đổi Mật Khẩu");
	}

	private void preset() {
	    // TODO Auto-generated method stub
	    javax.swing.GroupLayout pnPassLayout = new javax.swing.GroupLayout(pnPass);
	    pnPass.setLayout(pnPassLayout);
	    pnPassLayout.setHorizontalGroup(pnPassLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
		    .addGroup(pnPassLayout.createSequentialGroup().addGroup(pnPassLayout
			    .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(txtPassOld)
			    .addGroup(pnPassLayout.createSequentialGroup().addContainerGap().addGroup(pnPassLayout
				    .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				    .addComponent(txtPassNew).addComponent(txtPassConfirm)
				    .addComponent(btnChange, javax.swing.GroupLayout.DEFAULT_SIZE,
					    javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
				    .addGroup(pnPassLayout.createSequentialGroup().addGroup(pnPassLayout
					    .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
					    .addComponent(lblPassOld, javax.swing.GroupLayout.PREFERRED_SIZE, 172,
						    javax.swing.GroupLayout.PREFERRED_SIZE)
					    .addComponent(lblPassNew, javax.swing.GroupLayout.PREFERRED_SIZE, 172,
						    javax.swing.GroupLayout.PREFERRED_SIZE)
					    .addComponent(lblPassConfirm, javax.swing.GroupLayout.PREFERRED_SIZE, 172,
						    javax.swing.GroupLayout.PREFERRED_SIZE))
					    .addGap(0, 129, Short.MAX_VALUE)))))
			    .addContainerGap()));
	    pnPassLayout.setVerticalGroup(pnPassLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
		    .addGroup(pnPassLayout.createSequentialGroup().addContainerGap().addComponent(lblPassOld)
			    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
			    .addComponent(txtPassOld, javax.swing.GroupLayout.PREFERRED_SIZE,
				    javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
			    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
			    .addComponent(lblPassNew)
			    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
			    .addComponent(txtPassNew, javax.swing.GroupLayout.PREFERRED_SIZE,
				    javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
			    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
			    .addComponent(lblPassConfirm)
			    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
			    .addComponent(txtPassConfirm, javax.swing.GroupLayout.PREFERRED_SIZE,
				    javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
			    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
			    .addComponent(btnChange, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
			    .addContainerGap()));

	    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
	    getContentPane().setLayout(layout);
	    layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
		    .addGroup(layout.createSequentialGroup().addContainerGap().addComponent(pnPass,
			    javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
			    .addContainerGap()));
	    layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
		    .addGroup(layout.createSequentialGroup().addContainerGap().addComponent(pnPass,
			    javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
			    .addContainerGap()));

	    pack();
	}

	private void event() {
	    // TODO Auto-generated method stub
	    // Text
	    this.txtPassOld.addFocusListener(this);
	    this.txtPassNew.addFocusListener(this);
	    this.txtPassConfirm.addFocusListener(this);
	    this.txtPassOld.addKeyListener(this);
	    this.txtPassNew.addKeyListener(this);
	    this.txtPassConfirm.addKeyListener(this);

	    // Action
	    this.btnChange.addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
	    // TODO Auto-generated method stub
	    char[] charPassOld = txtPassOld.getPassword();
	    char[] charPassNew = txtPassNew.getPassword();
	    char[] charPassConfirm = txtPassConfirm.getPassword();
	    String passOld = new String(charPassOld);
	    String passNew = new String(charPassNew);
	    String passConfirm = new String(charPassConfirm);

	    if (CtrlLogin.checkLoginStatus(maNV, passOld)) {
		if (passNew.matches("^(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-.]).{8,}$")
			&& passNew.equals(passConfirm)) {

		    TaiKhoan modifyTK = new TaiKhoan(DAO_NhanVien.timKiemNhanVien(maNV), passNew);
		    if (DAO_TaiKhoan.suaTaiKhoan(modifyTK)) {
			JOptionPane.showMessageDialog(null, "Cập Nhật Thành Công\nHãy Đăng Nhập Lại");
			this.dispose();
		    } else {
			JOptionPane.showMessageDialog(null, "Cập Nhật Thất Bại");
			this.dispose();
		    }
		} else {
		    JOptionPane.showMessageDialog(null, "Kiểm tra lại thông tin nhập vào");
		}
	    } else {
		JOptionPane.showMessageDialog(null, "Vui lòng nhập mật khẩu cũ");
	    }
	}

	@Override
	public void focusGained(FocusEvent e) {
	    // TODO Auto-generated method stub

	}

	@Override
	public void focusLost(FocusEvent e) {
	    // TODO Auto-generated method stub
	    Object o = e.getSource();

	    if (o.equals(txtPassNew)) {
		String regex = "^(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-.]).{8,}$"; // Regex kiểm tra Mật Khẩu
		char[] pass = txtPassNew.getPassword();
		String newPass = new String(pass);
		if (!newPass.matches(regex)) {
		    // Nếu dữ liệu nhập vào không đúng, đổi màu viền sang đỏ
		    txtPassNew.setBorder(BorderFactory.createLineBorder(Color.RED));
		} else {
		    // Nếu dữ liệu nhập vào đúng, đổi màu viền sang xanh
		    txtPassNew.setBorder(BorderFactory.createLineBorder(Color.GREEN));
		}
	    }

	    if (o.equals(txtPassConfirm)) {
		char[] pass = txtPassNew.getPassword();
		String newPass = new String(pass);
		char[] confirm = txtPassConfirm.getPassword();
		String confirmPass = new String(confirm);
		// chuỗi
		if ((!confirmPass.matches("^(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-.]).{8,}$")
			&& !confirmPass.equals(newPass))
			|| (!confirmPass.matches("^(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-.]).{8,}$")
				&& confirmPass.equals(newPass))) {
		    // Nếu dữ liệu nhập vào không đúng, đổi màu viền sang đỏ
		    txtPassConfirm.setBorder(BorderFactory.createLineBorder(Color.RED));
		} else {
		    // Nếu dữ liệu nhập vào đúng, đổi màu viền sang xanh
		    txtPassConfirm.setBorder(BorderFactory.createLineBorder(Color.GREEN));
		}
	    }
	}

	@Override
	public void keyTyped(KeyEvent e) {
	    // TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
	    // TODO Auto-generated method stub

	}

	@Override
	public void keyReleased(KeyEvent e) {
	    // TODO Auto-generated method stub
	    Object o = e.getSource();

	    if (o.equals(txtPassNew)) {
		String regex = "^(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-.]).{8,}$"; // Regex kiểm tra Mật Khẩu
		char[] pass = txtPassNew.getPassword();
		String newPass = new String(pass);
		if (!newPass.matches(regex)) {
		    // Nếu dữ liệu nhập vào không đúng, đổi màu viền sang đỏ
		    txtPassNew.setBorder(BorderFactory.createLineBorder(Color.RED));
		} else {
		    // Nếu dữ liệu nhập vào đúng, đổi màu viền sang xanh
		    txtPassNew.setBorder(BorderFactory.createLineBorder(Color.GREEN));
		}
	    }

	    if (o.equals(txtPassConfirm)) {
		char[] pass = txtPassNew.getPassword();
		String newPass = new String(pass);
		char[] confirm = txtPassConfirm.getPassword();
		String confirmPass = new String(confirm);
		// chuỗi
		if ((!confirmPass.matches("^(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-.]).{8,}$")
			&& !confirmPass.equals(newPass))
			|| (!confirmPass.matches("^(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-.]).{8,}$")
				&& confirmPass.equals(newPass))) {
		    // Nếu dữ liệu nhập vào không đúng, đổi màu viền sang đỏ
		    txtPassConfirm.setBorder(BorderFactory.createLineBorder(Color.RED));
		} else {
		    // Nếu dữ liệu nhập vào đúng, đổi màu viền sang xanh
		    txtPassConfirm.setBorder(BorderFactory.createLineBorder(Color.GREEN));
		}
	    }
	}
    }
}
