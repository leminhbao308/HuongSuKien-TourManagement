package main.java.com.se_tourist;

import javax.swing.UIManager;

import main.java.com.se_tourist.view.Login;

/**
 * Khởi chạy giao diện của phần mềm
 * 
 * @author LeMinhBao
 */
public class TourManagementSystem {
    public static void main(String args[]) {
	try {
	    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
	    System.setProperty("apple.laf.useScreenMenuBar", "true");
	    new Login().setVisible(true);
	} catch (Exception e) {
	    e.printStackTrace();
	}
    }
}
