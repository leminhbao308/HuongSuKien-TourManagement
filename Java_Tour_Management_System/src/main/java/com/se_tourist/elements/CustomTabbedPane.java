package main.java.com.se_tourist.elements;

import java.awt.*;
import javax.swing.*;
import javax.swing.plaf.basic.BasicTabbedPaneUI;

import main.java.com.se_tourist.utils.constants.ColorConstant;

public class CustomTabbedPane extends JTabbedPane {

    /**
     * 
     */
    private static final long serialVersionUID = 8697819780646477955L;

    public CustomTabbedPane() {
	setUI(new CustomTabbedPaneUI());
    }

    public class CustomTabbedPaneUI extends BasicTabbedPaneUI {

	private Color tabAreaBackground = new Color(255, 255, 255);
	private Font tabFont;

	@Override
	protected void installDefaults() {
	    super.installDefaults();
	    // Thay đổi màu nền của các tab button
	    tabAreaBackground = ColorConstant.BUTTON_NORMAL;
	    // Thay đổi font chữ của các tab button
	    tabFont = new Font("Arial", Font.BOLD, 13);
	    // Thay đổi độ rộng của viền bao quanh các tab button
	    tabInsets = new Insets(0, 15, 0, 15);
	}

	@Override
	protected void paintTab(Graphics g, int tabPlacement, Rectangle[] rects, int tabIndex, Rectangle iconRect,
		Rectangle textRect) {
	    Graphics2D g2 = (Graphics2D) g;
	    g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
	    // Lấy màu nền của các tab button
	    Color backgroundColor = tabAreaBackground;
	    // Lấy màu chữ của các tab button
	    Color textColor = Color.BLACK;
	    // Kiểm tra xem tab button được chọn hay không để thay đổi màu nền và màu chữ
	    if (tabIndex == getSelectedIndex()) {
		backgroundColor = new Color(235, 100, 64);
		textColor = Color.WHITE;
	    }
	    // Vẽ nền của tab button
	    g2.setColor(backgroundColor);
	    g2.fillRect(rects[tabIndex].x, rects[tabIndex].y, rects[tabIndex].width, rects[tabIndex].height);
	    // Vẽ chữ của tab button
	    g2.setColor(textColor);
	    g2.setFont(tabFont);
	    g2.drawString(getTitleAt(tabIndex), textRect.x, textRect.y + textRect.height - 4);
	}

	@Override
	protected void paintContentBorder(Graphics g, int tabPlacement, int selectedIndex) {
	    // Không vẽ content border
	}
    }
}
