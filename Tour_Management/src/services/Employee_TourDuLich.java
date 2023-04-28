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
import models.TourDuLich;
import utils.AddList;
import utils.constants.ColorConstant;

public class Employee_TourDuLich extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4857724560123557844L;
	private CustomTabbedPane tbpnTourDuLich = new CustomTabbedPane();
	private AddPanel pnThem;
	private DeletePanel pnXoa;
	private ModifyPanel pnSua;
	private Box b_content;
	private ArrayList<JLabel> listTitleAdd = AddList.getListLblAddTourDuLich();
	private ArrayList<JTextField> listInputAdd = AddList.getListTxtAddTourDuLich();
	private ArrayList<JLabel> listTitleDelete = AddList.getListLblDeleteTourDuLich();
	private ArrayList<JTextField> listInputDelete = AddList.getListTxtDeleteTourDuLich();
	private ArrayList<JLabel> listTitleModify = AddList.getListLblModifyTourDuLich();
	private ArrayList<JTextField> listInputModify = AddList.getListTxtModifyTourDuLich();

	public Employee_TourDuLich() {
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
		this.pnThem = new AddPanel(listTitleAdd, listInputAdd, new TourDuLich());
		this.pnXoa = new DeletePanel(listTitleDelete, listInputDelete, new TourDuLich());
		this.pnSua = new ModifyPanel(listTitleModify, listInputModify, new TourDuLich());

		this.b_content = Box.createHorizontalBox();
	}

	private void style() {
		// TODO Auto-generated method stub
		tbpnTourDuLich.setTabLayoutPolicy(JTabbedPane.WRAP_TAB_LAYOUT);

		pnThem.setBackground(ColorConstant.BACKGROUND_NORMAL);
		pnThem.setForeground(ColorConstant.TEXT_NORMAL);

		pnXoa.setBackground(ColorConstant.BACKGROUND_NORMAL);
		pnXoa.setForeground(ColorConstant.TEXT_NORMAL);

		pnSua.setBackground(ColorConstant.BACKGROUND_NORMAL);
		pnSua.setForeground(ColorConstant.TEXT_NORMAL);

		b_content.setBackground(ColorConstant.BACKGROUND_NORMAL);
	}

	private void preset() {
		// TODO Auto-generated method stub

		tbpnTourDuLich.add("ThÃªm Tour Du Lá»‹ch", pnThem);
		tbpnTourDuLich.add("XÃ³a Tour Du Lá»‹ch", pnXoa);
		tbpnTourDuLich.add("Sá»­a Tour Du Lá»‹ch", pnSua);

		for (int i = 0; i < tbpnTourDuLich.getTabCount(); i++) {
			JLabel tab = new JLabel(tbpnTourDuLich.getTitleAt(i));
			tab.setFont(new Font("Arial", Font.PLAIN, 13)); // thiáº¿t láº­p font chá»¯
			tab.setForeground(ColorConstant.TEXT_BUTTON); // thiáº¿t láº­p mÃ u chá»¯
			tab.setBackground(ColorConstant.BUTTON_NORMAL); // thiáº¿t láº­p mÃ u ná»�n
			tab.setOpaque(true);
			tab.setPreferredSize(new Dimension(150, 25)); // thiáº¿t láº­p kÃ­ch thÆ°á»›c
			tbpnTourDuLich.setTabComponentAt(i, tab); // Ä‘áº·t tab component cho má»—i tab
		}

		b_content.add(tbpnTourDuLich);

		this.add(b_content);
	}
}
