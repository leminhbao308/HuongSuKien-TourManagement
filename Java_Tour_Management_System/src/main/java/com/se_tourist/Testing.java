package main.java.com.se_tourist;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.UIManager;

import main.java.com.se_tourist.services.Admin_NhanVien;
import main.java.com.se_tourist.services.Admin_TaiKhoan;

public class Testing extends JFrame {
    /**
     * 
     */
    private static final long serialVersionUID = -2760484292351117967L;
    private JTabbedPane tbpn_content = new JTabbedPane(JTabbedPane.LEFT);

    public Testing() {
	this.setTitle("TESTING");
	this.setSize(1000, 800);
//	this.setResizable(false);
	this.setLocationRelativeTo(null);

	tbpn_content.add("TaiKhoan", new Admin_TaiKhoan());
	tbpn_content.add("NhanVien", new Admin_NhanVien());
	this.add(tbpn_content);
    }

    public static void main(String args[]) {
	try {
	    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
	    System.setProperty("apple.laf.useScreenMenuBar", "true");
	    new Testing().setVisible(true);
	} catch (Exception e) {
	    e.printStackTrace();
	}
    }
}
