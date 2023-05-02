
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import view.Login;

/**
 * Khởi chạy giao diện của phần mềm
 * 
 * 
 * @author LeMinhBao
 */
public class TourManagementSystem {
    public static void main(String args[]) {

	try {
	    UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel"); // Nimbus
//	    UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel"); // Metal
	    new Login().setVisible(true);
	} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
		| UnsupportedLookAndFeelException ex) {
	    ex.printStackTrace();
	}
    }
}
