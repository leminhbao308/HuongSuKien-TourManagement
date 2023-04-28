package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.Box;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import elements.DropdownMenu;
import elements.HeaderButton;
import elements.ImagePanel;
import elements.SearchBar;
import services.Employee_DiaDanh;
import services.Employee_DichVu;
import services.Employee_HopDongTour;
import services.Employee_KhachHang;
import services.Employee_TourDuLich;
import services.Employee_VeTour;
import utils.LoadSave;
import utils.constants.ColorConstant;

public class Dashboard_Employee extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7425542322399368764L;
	private JPanel pnNorth, pnWest, pnCenter, pnSouth;
	private JLabel lblLogo;
	private HeaderButton btnKhachHang, btnDiaDanh, btnTourDuLich;
	private HeaderButton btnDichVu, btnHopDongTour, btnVeTour;
	private DropdownMenu btnAccount;
	private SearchBar txtSearch;
	private Box bNorth;
	private GroupLayout pnNorthLayout;

	/**
	 * Khá»Ÿi táº¡o giao diá»‡n
	 */
	public Dashboard_Employee() {
		Dimension DimMax = Toolkit.getDefaultToolkit().getScreenSize();
		this.setPreferredSize(new Dimension(1920, 1080));
		this.setResizable(false);
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		this.setMaximumSize(DimMax);
		this.setMinimumSize(new Dimension(960, 540));
		this.setTitle("SETourist - Employee Dashboard");
		this.setLocationRelativeTo(null);
		this.setBackground(ColorConstant.BACKGROUND_NORMAL);
		this.setIconImage(LoadSave.GetSpriteAtlas(LoadSave.LOGO_ICON));
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);

		init();
		style();
		preset();
		event();
	}

	/**
	 * Khá»Ÿi táº¡o cÃ¡c pháº§n tá»­
	 */
	private void init() {
		// Panel
		pnNorth = new JPanel();
		pnSouth = new JPanel();
		pnWest = new JPanel(new GridLayout(20, 1, 0, 10));
		pnCenter = new ImagePanel(LoadSave.GetSpriteAtlas(LoadSave.BACKGROUND_DASHBOARD));

		// Label
		lblLogo = new JLabel("SE TOURIST", new ImageIcon(LoadSave.GetSpriteAtlas(LoadSave.LOGO_LABEL)),
				SwingConstants.LEFT);

		// Button
		btnKhachHang = new HeaderButton("KhÃ¡ch HÃ ng", ColorConstant.BACKGROUND_NORMAL, ColorConstant.TEXT_NORMAL);
		btnDiaDanh = new HeaderButton("Ä�á»‹a Danh", ColorConstant.BACKGROUND_NORMAL, ColorConstant.TEXT_NORMAL);
		btnTourDuLich = new HeaderButton("Tour Du Lá»‹ch", ColorConstant.BACKGROUND_NORMAL, ColorConstant.TEXT_NORMAL);
		btnDichVu = new HeaderButton("Dá»‹ch Vá»¥", ColorConstant.BACKGROUND_NORMAL, ColorConstant.TEXT_NORMAL);
		btnHopDongTour = new HeaderButton("Há»£p Ä�á»“ng Tour", ColorConstant.BACKGROUND_NORMAL,
				ColorConstant.TEXT_NORMAL);
		btnVeTour = new HeaderButton("VÃ© Tour", ColorConstant.BACKGROUND_NORMAL, ColorConstant.TEXT_NORMAL);
		btnAccount = new DropdownMenu("Employee", ColorConstant.BACKGROUND_HEADER_FOOTER, ColorConstant.TEXT_NORMAL,
				this);

		// Search Bar
		txtSearch = new SearchBar();

		// Box
		bNorth = Box.createHorizontalBox();

		// Group Layout
		pnNorthLayout = new GroupLayout(pnNorth);
	}

	/**
	 * TÃ¹y chá»‰nh cÃ¡c pháº§n tá»­
	 */
	private void style() {
		// Panel
		pnNorth.setBackground(ColorConstant.BACKGROUND_HEADER_FOOTER);
		pnNorth.setLayout(pnNorthLayout);
		pnNorthLayout.setHorizontalGroup(pnNorthLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(pnNorthLayout.createSequentialGroup().addContainerGap().addComponent(lblLogo)
						.addGap(118, 118, 118).addComponent(txtSearch, GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
						.addGap(125, 125, 125).addComponent(btnAccount).addContainerGap()));
		pnNorthLayout.setVerticalGroup(pnNorthLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(pnNorthLayout.createSequentialGroup().addContainerGap(9, Short.MAX_VALUE)
						.addGroup(pnNorthLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
								.addComponent(txtSearch, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(lblLogo).addComponent(btnAccount))
						.addContainerGap()));

		pnSouth.setBackground(ColorConstant.BACKGROUND_HEADER_FOOTER);
		pnWest.setBackground(ColorConstant.BACKGROUND_NORMAL);

		// Label
		lblLogo.setForeground(ColorConstant.TEXT_NORMAL);
		lblLogo.setFont(new Font("Arial", Font.BOLD, 35));

		// Button
		btnAccount.setFont(new Font("Arial", Font.BOLD, 25));

		// Search
		txtSearch.setHorizontalAlignment(JTextField.LEFT);
		txtSearch.setToolTipText("");
		txtSearch.setColumns((int) (this.getWidth() / 20));
		txtSearch.setFont(new Font("Arial", Font.PLAIN, 20));

		// Box
		bNorth.setBackground(ColorConstant.BACKGROUND_HEADER_FOOTER);
	}

	/**
	 * Sáº¯p xáº¿p cÃ¡c pháº§n tá»­
	 */
	private void preset() {

		// Panel
		pnNorth.add(lblLogo, FlowLayout.LEFT);
		pnNorth.add(txtSearch, FlowLayout.CENTER);
		pnWest.add(btnKhachHang);
		pnWest.add(btnDiaDanh);
		pnWest.add(btnDichVu);
		pnWest.add(btnHopDongTour);
		pnWest.add(btnTourDuLich);
		pnWest.add(btnVeTour);

		// Frame
		this.add(pnNorth, BorderLayout.NORTH);
		this.add(pnSouth, BorderLayout.SOUTH);
		this.add(pnWest, BorderLayout.WEST);
		this.add(pnCenter, BorderLayout.CENTER);

	}

	/**
	 * Sá»± kiá»‡n cÃ¡c pháº§n tá»­
	 */
	private void event() {
		this.btnKhachHang.addActionListener(this);
		this.btnTourDuLich.addActionListener(this);
		this.btnDiaDanh.addActionListener(this);
		this.btnDichVu.addActionListener(this);
		this.btnHopDongTour.addActionListener(this);
		this.btnVeTour.addActionListener(this);

		addComponentListener(new ComponentAdapter() {
			public void componentResized(ComponentEvent e) {
				int numCols = (int) (getWidth() / 10);
				txtSearch.setColumns(numCols);
			}
		});
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if (o.equals(btnKhachHang)) {
			this.remove(pnCenter);
			pnCenter = new Employee_KhachHang();
			this.add(pnCenter, BorderLayout.CENTER);
			this.revalidate();
			this.repaint();
		}
		if (o.equals(btnTourDuLich)) {
			this.remove(pnCenter);
			pnCenter = new Employee_TourDuLich();
			this.add(pnCenter, BorderLayout.CENTER);
			this.revalidate();
			this.repaint();
		}
		if (o.equals(btnDiaDanh)) {
			this.remove(pnCenter);
			pnCenter = new Employee_DiaDanh();
			this.add(pnCenter, BorderLayout.CENTER);
			this.revalidate();
			this.repaint();
		}
		if (o.equals(btnDichVu)) {
			this.remove(pnCenter);
			pnCenter = new Employee_DichVu();
			this.add(pnCenter, BorderLayout.CENTER);
			this.revalidate();
			this.repaint();
		}
		if (o.equals(btnHopDongTour)) {
			this.remove(pnCenter);
			pnCenter = new Employee_HopDongTour();
			this.add(pnCenter, BorderLayout.CENTER);
			this.revalidate();
			this.repaint();
		}
		if (o.equals(btnVeTour)) {
			this.remove(pnCenter);
			pnCenter = new Employee_VeTour();
			this.add(pnCenter, BorderLayout.CENTER);
			this.revalidate();
			this.repaint();
		}
	}

}