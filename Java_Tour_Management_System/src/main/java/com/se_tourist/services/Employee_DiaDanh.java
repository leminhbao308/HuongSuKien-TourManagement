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
import main.java.com.se_tourist.models.DiaDanh;
import main.java.com.se_tourist.utils.AddList;
import main.java.com.se_tourist.utils.constants.ColorConstant;

public class Employee_DiaDanh extends JPanel {

    /**
     * 
     */
    private static final long serialVersionUID = 1791886657472259552L;
    private CustomTabbedPane tbpnDiaDanh = new CustomTabbedPane();
    private AddPanel pnThem;
    private DeletePanel pnXoa;
    private ModifyPanel pnSua;
    private Box b_content;
    private ArrayList<JLabel> listAddLbl = AddList.getListLblAddDiaDanh();
    private ArrayList<JTextField> listAddTxt = AddList.getListTxtAddDiaDanh();
    private ArrayList<JLabel> listDeleteLbl = AddList.getListLblDeleteDiaDanh();
    private ArrayList<JTextField> listDeleteTxt = AddList.getListTxtDeleteDiaDanh();
    private ArrayList<JLabel> listModifyLbl = AddList.getListLblModifyDiaDanh();
    private ArrayList<JTextField> listModifyTxt = AddList.getListTxtModifyDiaDanh();

    public Employee_DiaDanh() {
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
	this.pnThem = new AddPanel(listAddLbl, listAddTxt, new DiaDanh());
	this.pnXoa = new DeletePanel(listDeleteLbl, listDeleteTxt, new DiaDanh());
	this.pnSua = new ModifyPanel(listModifyLbl, listModifyTxt, new DiaDanh());

	this.b_content = Box.createHorizontalBox();
    }

    private void style() {
	// TODO Auto-generated method stub
	tbpnDiaDanh.setTabLayoutPolicy(JTabbedPane.WRAP_TAB_LAYOUT);

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
	tbpnDiaDanh.add("Thêm Địa Danh", pnThem);
	tbpnDiaDanh.add("Xóa Địa Danh", pnXoa);
	tbpnDiaDanh.add("Sửa Địa Danh", pnSua);

	for (int i = 0; i < tbpnDiaDanh.getTabCount(); i++) {
	    JLabel tab = new JLabel(tbpnDiaDanh.getTitleAt(i));
	    tab.setFont(new Font("Arial", Font.PLAIN, 13)); // thiết lập font chữ
	    tab.setForeground(ColorConstant.TEXT_BUTTON); // thiết lập màu chữ
	    tab.setBackground(ColorConstant.BUTTON_NORMAL); // thiết lập màu nền
	    tab.setOpaque(true);
	    tab.setPreferredSize(new Dimension(150, 25)); // thiết lập kích thước
	    tbpnDiaDanh.setTabComponentAt(i, tab); // đặt tab component cho mỗi tab
	}

	b_content.add(tbpnDiaDanh);

	this.add(b_content);
    }
}
