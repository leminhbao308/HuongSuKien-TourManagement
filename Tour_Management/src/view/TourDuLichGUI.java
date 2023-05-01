package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

public class TourDuLichGUI extends JFrame {

	private JPanel contentPane;
	private JTextField txtTimKiem;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TourDuLichGUI frame = new TourDuLichGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TourDuLichGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 999, 660);
		contentPane = new JPanel();
		contentPane.setForeground(Color.BLUE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane_Sidebar = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane_Sidebar.setBounds(0, 52, 69, 565);
		contentPane.add(tabbedPane_Sidebar);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 984, 50);
		contentPane.add(panel);
		
		JTabbedPane tabbedPane_tools = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane_tools.setBounds(69, 52, 915, 31);
		contentPane.add(tabbedPane_tools);
		
		JLabel lblTieuDeTrang = new JLabel("DANH S\u00C1CH TOUR");
		lblTieuDeTrang.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblTieuDeTrang.setBounds(427, 94, 135, 19);
		contentPane.add(lblTieuDeTrang);
		
		JPanel panel_tools = new JPanel();
		panel_tools.setBorder(new LineBorder(Color.CYAN));
		panel_tools.setForeground(Color.BLUE);
		panel_tools.setBounds(115, 124, 801, 40);
		contentPane.add(panel_tools);
		panel_tools.setLayout(null);
		
		JComboBox cbbx_TinhThanh = new JComboBox();
		cbbx_TinhThanh.setBounds(587, 11, 204, 22);
		panel_tools.add(cbbx_TinhThanh);
		
		txtTimKiem = new JTextField();
		txtTimKiem.setBounds(65, 12, 204, 20);
		panel_tools.add(txtTimKiem);
		txtTimKiem.setColumns(10);
		
		JLabel lblTimKiem = new JLabel("Tìm Kiếm :");
		lblTimKiem.setBounds(10, 13, 60, 18);
		panel_tools.add(lblTimKiem);
		
		JLabel lblNgyi = new JLabel("Ngày đi :");
		lblNgyi.setBounds(279, 13, 53, 18);
		panel_tools.add(lblNgyi);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(330, 12, 157, 20);
		panel_tools.add(textField);
		
		JLabel lblTinhThanhCbbx = new JLabel("Tỉnh thành :");
		lblTinhThanhCbbx.setBounds(516, 15, 60, 18);
		panel_tools.add(lblTinhThanhCbbx);
		
		JPanel panel_DsTour = new JPanel();
		panel_DsTour.setBorder(new LineBorder(Color.CYAN));
		panel_DsTour.setBounds(115, 185, 801, 432);
		contentPane.add(panel_DsTour);
		panel_DsTour.setLayout(null);
		
		JPanel panel_Tour1 = new JPanel();
		panel_Tour1.setBorder(new LineBorder(Color.BLUE, 1, true));
		panel_Tour1.setForeground(Color.BLUE);
		panel_Tour1.setBounds(25, 11, 766, 70);
		panel_DsTour.add(panel_Tour1);
		panel_Tour1.setLayout(null);
		
		JPanel panelImageTour = new JPanel();
		panelImageTour.setBounds(10, 8, 78, 59);
		panel_Tour1.add(panelImageTour);
		
		JLabel lblTenTour = new JLabel("Tour đi Phú Quốc 2 ngày một đêm");
		lblTenTour.setHorizontalAlignment(SwingConstants.LEFT);
		lblTenTour.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTenTour.setLabelFor(panel_Tour1);
		lblTenTour.setBounds(98, 0, 592, 22);
		panel_Tour1.add(lblTenTour);
		
		JLabel lblNoiDi = new JLabel("Nơi đi :");
		lblNoiDi.setFont(new Font("Tahoma", Font.ITALIC, 11));
		lblNoiDi.setBounds(559, 28, 131, 14);
		panel_Tour1.add(lblNoiDi);
		
		JLabel lblNgayDi = new JLabel("Ngày đi :");
		lblNgayDi.setHorizontalAlignment(SwingConstants.LEFT);
		lblNgayDi.setFont(new Font("Tahoma", Font.ITALIC, 11));
		lblNgayDi.setBounds(559, 53, 131, 14);
		panel_Tour1.add(lblNgayDi);
		
		JLabel lblGiaTour = new JLabel("Giá Tour :");
		lblGiaTour.setHorizontalAlignment(SwingConstants.LEFT);
		lblGiaTour.setFont(new Font("Tahoma", Font.ITALIC, 11));
		lblGiaTour.setBounds(559, 6, 131, 14);
		panel_Tour1.add(lblGiaTour);
		
		JLabel lblMaTour = new JLabel("Mã Tour :");
		lblMaTour.setBounds(108, 53, 46, 14);
		panel_Tour1.add(lblMaTour);
		
		JButton btnTourLeft = new JButton("<");
		btnTourLeft.setBackground(Color.LIGHT_GRAY);
		btnTourLeft.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnTourLeft.setBounds(72, 323, 41, 40);
		contentPane.add(btnTourLeft);
		
		JButton btnTourRight = new JButton(">");
		btnTourRight.setBackground(Color.LIGHT_GRAY);
		btnTourRight.setBounds(934, 323, 41, 40);
		contentPane.add(btnTourRight);
	}
}
