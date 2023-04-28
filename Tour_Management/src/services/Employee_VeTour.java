package services;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.UIManager;

import elements.AddPanel;
import elements.CustomTabbedPane;
import elements.DeletePanel;
import elements.ModifyPanel;
import models.VeTour;
import utils.AddList;
import utils.constants.ColorConstant;

public class Employee_VeTour extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2105223887261403595L;
	private CustomTabbedPane tbpnVeTour = new CustomTabbedPane();
	private AddPanel pnXem;
	private DeletePanel pnXoa;
	private ModifyPanel pnSua;
	private Box b_content;
	private ArrayList<JLabel> listTitleAdd = AddList.getListLblAddVe();
	private ArrayList<JTextField> listInputAdd = AddList.getListTxtAddVe();
	private ArrayList<JLabel> listTitleDelete = AddList.getListLblDeleteVe();
	private ArrayList<JTextField> listInputDelete = AddList.getListTxtDeleteVe();
	private ArrayList<JLabel> listTitleModify = AddList.getListLblModifyVe();
	private ArrayList<JTextField> listInputModify = AddList.getListTxtModifyVe();

	public Employee_VeTour() {
		UIManager.put("TabbedPane.selected", Color.WHITE); // mÃ u sáº¯c cá»§a tab Ä‘Æ°á»£c chá»�n
		UIManager.put("TabbedPane.tabAreaBackground", Color.GRAY); // mÃ u sáº¯c cá»§a vÃ¹ng chá»©a cÃ¡c tab
		UIManager.put("TabbedPane.tabForeground", Color.BLACK); // mÃ u sáº¯c cá»§a tiÃªu Ä‘á»� tab
		UIManager.put("TabbedPane.font", new Font("Arial", Font.BOLD, 13)); // font chá»¯ cá»§a tab

		setBackground(ColorConstant.BACKGROUND_NORMAL);
		setForeground(ColorConstant.TEXT_NORMAL);
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		init();
		style();
		preset();
	}

	private void init() {
		// TODO Auto-generated method stub

		this.pnXem = new AddPanel(listTitleAdd, listInputAdd, new VeTour());
		this.pnXoa = new DeletePanel(listTitleDelete, listInputDelete, new VeTour());
		this.pnSua = new ModifyPanel(listTitleModify, listInputModify, new VeTour());

		this.b_content = Box.createHorizontalBox();
	}

	private void style() {
		// TODO Auto-generated method stub
		tbpnVeTour.setTabLayoutPolicy(JTabbedPane.WRAP_TAB_LAYOUT);

		pnXem.setBackground(ColorConstant.BACKGROUND_NORMAL);
		pnXem.setForeground(ColorConstant.TEXT_NORMAL);

		pnXoa.setBackground(ColorConstant.BACKGROUND_NORMAL);
		pnXoa.setForeground(ColorConstant.TEXT_NORMAL);

		pnSua.setBackground(ColorConstant.BACKGROUND_NORMAL);
		pnSua.setForeground(ColorConstant.TEXT_NORMAL);

		b_content.setBackground(ColorConstant.BACKGROUND_NORMAL);
	}

	private void preset() {
		// TODO Auto-generated method stub

		tbpnVeTour.add("Xem VÃ© Tour", pnXem);
		tbpnVeTour.add("XÃ³a VÃ© Tour", pnXoa);
		tbpnVeTour.add("Sá»­a VÃ© Tour", pnSua);

		for (int i = 0; i < tbpnVeTour.getTabCount(); i++) {
			JLabel tab = new JLabel(tbpnVeTour.getTitleAt(i));
			tab.setFont(new Font("Arial", Font.PLAIN, 13)); // thiáº¿t láº­p font chá»¯
			tab.setForeground(ColorConstant.TEXT_BUTTON); // thiáº¿t láº­p mÃ u chá»¯
			tab.setBackground(ColorConstant.BUTTON_NORMAL); // thiáº¿t láº­p mÃ u ná»�n
			tab.setOpaque(true);
			tab.setPreferredSize(new Dimension(150, 25)); // thiáº¿t láº­p kÃ­ch thÆ°á»›c
			tbpnVeTour.setTabComponentAt(i, tab); // Ä‘áº·t tab component cho má»—i tab
		}

		b_content.add(tbpnVeTour);

		this.add(b_content);
	}
}
