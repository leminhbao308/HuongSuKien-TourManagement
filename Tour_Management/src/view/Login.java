package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import controllers.CtrlLogin;
import elements.ImagePanel;
import elements.RoundJButton;
import elements.RoundJPasswordField;
import elements.RoundJTextField;
import utils.LoadSave;

public class Login extends JFrame implements ActionListener {

    /**
     * 
     */
    private static final long serialVersionUID = 8390616510415779560L;
    private JPanel loginPanel;
    private JLabel lblTitle, lblPass, lblMaNV, lblCheckPass;
    private RoundJTextField txtMaNV;
    private RoundJPasswordField txtMatKhau;
    private RoundJButton btnLogin;

    public Login() {
	setIconImage(LoadSave.GetSpriteAtlas(LoadSave.LOGO_ICON));
	setTitle("SE Tourist - Login");
	setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
	setBackground(new java.awt.Color(73, 113, 116));
	setMaximumSize(new java.awt.Dimension(550, 355));
	setMinimumSize(new java.awt.Dimension(550, 355));
	setLocationRelativeTo(null);
	setResizable(false);

	init();
	style();
	preset();
	event();
    }

    private void init() {
	// TODO Auto-generated method stub
	loginPanel = new javax.swing.JPanel();
	lblTitle = new javax.swing.JLabel();
	lblPass = new javax.swing.JLabel();
	lblMaNV = new javax.swing.JLabel();
	txtMaNV = new RoundJTextField("");
	txtMatKhau = new RoundJPasswordField(1000);
	lblCheckPass = new javax.swing.JLabel();
	btnLogin = new RoundJButton("");
    }

    private void style() {
	// TODO Auto-generated method stub
	loginPanel.setBackground(new java.awt.Color(73, 113, 116));

	lblTitle.setFont(new java.awt.Font("Arial Black", 1, 36)); // NOI18N
	lblTitle.setForeground(new java.awt.Color(255, 255, 255));
	lblTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
	lblTitle.setText("LOGIN");
	lblTitle.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
	lblTitle.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);

	lblPass.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
	lblPass.setForeground(new java.awt.Color(77, 69, 93));
	lblPass.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
	lblPass.setText("Mật Khẩu");

	lblMaNV.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
	lblMaNV.setForeground(new java.awt.Color(77, 69, 93));
	lblMaNV.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
	lblMaNV.setText("Mã Nhân Viên");

	txtMaNV.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
	txtMaNV.setToolTipText("Nhập mã nhân viên");

	txtMatKhau.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
	txtMatKhau.setToolTipText("Nhập mật khẩu");

	lblCheckPass.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
	lblCheckPass.setForeground(new java.awt.Color(255, 0, 0));
	lblCheckPass.setText("(*)");

	btnLogin.setBackground(new java.awt.Color(235, 100, 64));
	btnLogin.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
	btnLogin.setForeground(new java.awt.Color(77, 69, 93));
	btnLogin.setText("LOGIN");
	btnLogin.setToolTipText("Đăng Nhập");
	btnLogin.setIcon(new ImageIcon(LoadSave.GetSpriteAtlas(LoadSave.ICON_LOGIN)));
	btnLogin.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    }

    private void preset() {
	// TODO Auto-generated method stub
	javax.swing.GroupLayout loginPanelLayout = new javax.swing.GroupLayout(loginPanel);
	loginPanel.setLayout(loginPanelLayout);
	loginPanelLayout
		.setHorizontalGroup(loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
			.addComponent(lblTitle, javax.swing.GroupLayout.DEFAULT_SIZE, 550, Short.MAX_VALUE)
			.addGroup(loginPanelLayout.createSequentialGroup().addContainerGap()
				.addGroup(loginPanelLayout
					.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
					.addComponent(btnLogin, javax.swing.GroupLayout.DEFAULT_SIZE,
						javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(txtMaNV).addComponent(txtMatKhau)
					.addGroup(loginPanelLayout.createSequentialGroup().addGroup(loginPanelLayout
						.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addComponent(lblPass, javax.swing.GroupLayout.PREFERRED_SIZE, 89,
							javax.swing.GroupLayout.PREFERRED_SIZE)
						.addComponent(lblMaNV)).addGap(0, 0, Short.MAX_VALUE))
					.addComponent(lblCheckPass, javax.swing.GroupLayout.DEFAULT_SIZE,
						javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				.addContainerGap()));
	loginPanelLayout
		.setVerticalGroup(
			loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(loginPanelLayout.createSequentialGroup()
					.addComponent(lblTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 52,
						javax.swing.GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
					.addComponent(lblMaNV, javax.swing.GroupLayout.PREFERRED_SIZE, 30,
						javax.swing.GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
					.addComponent(txtMaNV, javax.swing.GroupLayout.PREFERRED_SIZE, 36,
						javax.swing.GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
					.addComponent(lblPass, javax.swing.GroupLayout.PREFERRED_SIZE, 30,
						javax.swing.GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
					.addComponent(txtMatKhau, javax.swing.GroupLayout.PREFERRED_SIZE, 36,
						javax.swing.GroupLayout.PREFERRED_SIZE)
					.addGap(2, 2, 2).addComponent(lblCheckPass).addGap(18, 18, 18)
					.addComponent(btnLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 50,
						javax.swing.GroupLayout.PREFERRED_SIZE)
					.addGap(0, 15, Short.MAX_VALUE)));

	javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
	getContentPane().setLayout(layout);
	layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(
		loginPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE,
		javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
	layout.setVerticalGroup(
		layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(loginPanel,
			javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
    }

    private void event() {
	// TODO Auto-generated method stub
	this.btnLogin.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
	Object o = e.getSource();

	/**
	 * Kiểm tra mật khẩu
	 */
//	if (o.equals(btnLogin)) {
//	    String account = txtMaNV.getText();
//	    char[] passwordChars = txtMatKhau.getPassword();
//	    String password = new String(passwordChars);
//
//	    if (CtrlLogin.checkLoginStatus(account, password)) {
//		if (CtrlLogin.checkAccountType(account) == 1) {
//		    JOptionPane.showMessageDialog(null, "Đăng Nhập Thành Công!");
//		    new Dashboard_Admin().setVisible(true);
//		} else if (CtrlLogin.checkAccountType(account) == 2) {
//		    JOptionPane.showMessageDialog(null, "Đăng Nhập Thành Công!");
//		    new Dashboard_Employee().setVisible(true);
//		}
//	    } else {
//		JOptionPane.showMessageDialog(null,
//			"Mã Nhân Viên không tồn tại \n\t               Hoặc \nMật Khẩu không chính xác");
//	    }
//	}

	if (o.equals(btnLogin)) {
	    this.dispose();
	    Dashboard_Admin admin = new Dashboard_Admin();
	    admin.setVisible(true);
	    admin.requestFocus();
	    admin.setAlwaysOnTop(true);
	    admin.setAlwaysOnTop(false);
	}
    }
}
