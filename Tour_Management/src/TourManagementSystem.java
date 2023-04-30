
import javax.swing.UIManager;

import view.Login;

/**
 * khởi chạy 
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
