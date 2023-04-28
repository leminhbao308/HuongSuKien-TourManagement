package main.java.com.se_tourist.services;

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

import main.java.com.se_tourist.elements.AddPanel;
import main.java.com.se_tourist.elements.CustomTabbedPane;
import main.java.com.se_tourist.elements.DeletePanel;
import main.java.com.se_tourist.elements.ModifyPanel;
import main.java.com.se_tourist.models.TourDuLich;
import main.java.com.se_tourist.utils.AddList;
import main.java.com.se_tourist.utils.constants.ColorConstant;

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
	UIManager.put("TabbedPane.selected", Color.WHITE); // màu sắc của tab được chọn
	UIManager.put("TabbedPane.tabAreaBackground", Color.GRAY); // màu sắc của vùng chứa các tab
	UIManager.put("TabbedPane.tabForeground", Color.BLACK); // màu sắc của tiêu đề tab
	UIManager.put("TabbedPane.font", new Font("Arial", Font.BOLD, 13)); // font chữ của tab

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

	tbpnTourDuLich.add("Thêm Tour Du Lịch", pnThem);
	tbpnTourDuLich.add("Xóa Tour Du Lịch", pnXoa);
	tbpnTourDuLich.add("Sửa Tour Du Lịch", pnSua);

	for (int i = 0; i < tbpnTourDuLich.getTabCount(); i++) {
	    JLabel tab = new JLabel(tbpnTourDuLich.getTitleAt(i));
	    tab.setFont(new Font("Arial", Font.PLAIN, 13)); // thiết lập font chữ
	    tab.setForeground(ColorConstant.TEXT_BUTTON); // thiết lập màu chữ
	    tab.setBackground(ColorConstant.BUTTON_NORMAL); // thiết lập màu nền
	    tab.setOpaque(true);
	    tab.setPreferredSize(new Dimension(150, 25)); // thiết lập kích thước
	    tbpnTourDuLich.setTabComponentAt(i, tab); // đặt tab component cho mỗi tab
	}

	b_content.add(tbpnTourDuLich);

	this.add(b_content);
    }
}
