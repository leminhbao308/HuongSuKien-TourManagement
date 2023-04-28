package elements;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;

import view.Login;

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

		accountInfo = new JMenuItem("ThÃ´ng Tin TÃ i Khoáº£n");
		setting = new JMenuItem("CÃ i Ä�áº·t");
		logout = new JMenuItem("Ä�Äƒng Xuáº¥t");

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
			int choice = JOptionPane.showConfirmDialog(null, "Báº¡n cÃ³ muá»‘n Ä‘Äƒng xuáº¥t?",
					"XÃ¡c nháº­n Ä‘Äƒng xuáº¥t", JOptionPane.YES_NO_OPTION);
			if (choice == JOptionPane.YES_OPTION) {
				window.dispose();
				Login login = new Login();
				login.setVisible(true);
			}

		}
	}

}
