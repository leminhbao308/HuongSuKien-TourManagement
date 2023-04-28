package main.java.com.se_tourist.elements;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;

import main.java.com.se_tourist.view.Login;

public class DropdownMenu extends HeaderButton implements ActionListener {

    /**
     * 
     */
    private static final long serialVersionUID = -5604889259228544981L;
    private JPopupMenu popupMenu = new JPopupMenu();
    private JMenuItem accountInfo, setting, logout;
    private JFrame window;

    public DropdownMenu(String title, Color backgroundColor, Color textColor, JFrame window) {
	super(title, backgroundColor, textColor);
	this.window = window;

	accountInfo = new JMenuItem("Thông Tin Tài Khoản");
	setting = new JMenuItem("Cài Đặt");
	logout = new JMenuItem("Đăng Xuất");

	this.popupMenu.add(accountInfo);
	this.popupMenu.add(setting);
	this.popupMenu.add(logout);

	this.addActionListener(this);
	accountInfo.addActionListener(this);
	setting.addActionListener(this);
	logout.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
	Object o = e.getSource();

	if (o.equals(this))
	    popupMenu.show(this, 0, this.getHeight());
	if (o.equals(accountInfo)) {

	}
	if (o.equals(setting)) {

	}
	if (o.equals(logout)) {
	    int choice = JOptionPane.showConfirmDialog(null, "Bạn có muốn đăng xuất?", "Xác nhận đăng xuất",
		    JOptionPane.YES_NO_OPTION);
	    if (choice == JOptionPane.YES_OPTION) {
		window.dispose();
		Login login = new Login();
		login.setVisible(true);
	    }

	}
    }

}
