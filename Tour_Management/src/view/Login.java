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

import elements.RoundJButton;
import elements.RoundJPasswordField;
import elements.RoundJTextField;
import utils.LoadSave;

public class Login extends JFrame implements ActionListener {

    /**
     * 
     */
    private static final long serialVersionUID = 8390616510415779560L;
    private JLabel lbl_title;
    private JButton btn_login;
    private RoundJTextField txt_username;
    private RoundJPasswordField txt_password;
    private JPanel jp_login;
    private ImageIcon logo = new ImageIcon(LoadSave.GetSpriteAtlas(LoadSave.LOGO_ICON));

    public Login() {
	this.setTitle("SETourist - Login");
	super.setSize(600, 400);
	this.setLocationRelativeTo(null);
	this.setResizable(false);
	this.setIconImage(logo.getImage());
	this.setDefaultCloseOperation(EXIT_ON_CLOSE);

	init();
	style();
	preset();
    }

    /**
     * Khởi tạo các phần tử
     */
    private void init() {
	this.lbl_title = new JLabel("Login");
	this.txt_username = new RoundJTextField(40);
	this.txt_password = new RoundJPasswordField(40);
	this.btn_login = new RoundJButton("Login");
	this.jp_login = new JPanel();
    }

    /**
     * Tùy chỉnh các phần tử
     */
    private void style() {
	// Style color text
	Color color_Title = new Color(239, 245, 245);
	Color color_Forget = new Color(235, 100, 64);
	this.lbl_title.setForeground(color_Title);

	this.btn_login.setBackground(color_Forget);

	// Set font
	Font font_Title = new Font("Arial", Font.BOLD, 50);
	Font font_Text = new Font("Arial", Font.PLAIN, 18);
	Font font_btn = new Font("Arial", Font.PLAIN, 24);
	this.lbl_title.setFont(font_Title);
	this.txt_username.setFont(font_Text);
	this.txt_password.setFont(font_Text);
	this.btn_login.setFont(font_btn);
	// Set size
	this.txt_username.setPreferredSize(new Dimension(100, 30));
	this.txt_password.setPreferredSize(new Dimension(100, 30));

	// Set text in Field
	this.txt_username.setText("Username");
	this.txt_username.setColumns(20);
	this.txt_password.setText("Password");
	this.txt_password.setColumns(20);

	// Set layout
	jp_login.setLayout(new BoxLayout(jp_login, BoxLayout.Y_AXIS));
    }

    /**
     * Sắp xếp các phần tử
     */
    private void preset() {
	this.setLayoutFormLogin();
	this.add(jp_login);

	this.btn_login.addActionListener(this);
    }

    public void setLayoutFormLogin() {
	Box b = Box.createVerticalBox();
	Box b1 = Box.createHorizontalBox();
	Box b2 = Box.createHorizontalBox();
	Box b3 = Box.createHorizontalBox();
	Box b4 = Box.createHorizontalBox();

	b1.add(lbl_title);
	b2.add(Box.createHorizontalStrut(30));
	b2.add(txt_username);
	b2.add(Box.createHorizontalStrut(30));
	b3.add(Box.createHorizontalStrut(30));
	b3.add(txt_password);
	b3.add(Box.createHorizontalStrut(30));

	b4.add(Box.createHorizontalStrut(100));
	b4.add(btn_login);
	b4.add(Box.createHorizontalStrut(100));

	b.add(Box.createVerticalStrut(50));
	b.add(b1);
	b.add(Box.createVerticalStrut(30));
	b.add(b2);
	b.add(Box.createVerticalStrut(10));
	b.add(b3);
	b.add(Box.createVerticalStrut(50));
	b.add(b4);
	b.add(Box.createVerticalStrut(40));

	// Set color
	b.setBackground(new Color(73, 113, 116));
	b1.setBackground(new Color(73, 113, 116));
	b2.setBackground(new Color(73, 113, 116));
	b3.setBackground(new Color(73, 113, 116));
	b4.setBackground(new Color(73, 113, 116));

	jp_login.add(b);
	jp_login.setBackground(new Color(73, 113, 116));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
	Object o = e.getSource();

	/**
	 * Kiểm tra mật khẩu
	 */
	if (o.equals(btn_login)) {
	    if (txt_username.getText().equals("Username")) {
		char[] passwordChars = txt_password.getPassword();
		String password = new String(passwordChars);
		if (password.equals("Password")) {
		    JOptionPane.showMessageDialog(null, "Admin Login Successfull");
		    this.dispose();
		    Dashboard_Admin dashboard = new Dashboard_Admin();
		    dashboard.setLocationRelativeTo(null);
		    dashboard.setVisible(true);
		} else if (password.equals("Employee")) {
		    JOptionPane.showMessageDialog(null, "Employee Login Successfull");
		    this.dispose();
		    Dashboard_Employee dashboard = new Dashboard_Employee();
		    dashboard.setLocationRelativeTo(null);
		    dashboard.setVisible(true);
		} else {
		    JOptionPane.showMessageDialog(null, "Incorrect Password");
		    txt_password.requestFocus();
		}
	    } else {
		JOptionPane.showMessageDialog(null, "Incorrect Username");
		txt_username.requestFocus();
	    }
	}
    }
}
