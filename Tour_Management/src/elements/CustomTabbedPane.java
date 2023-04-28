package elements;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.Rectangle;
import java.awt.RenderingHints;

import javax.swing.JTabbedPane;
import javax.swing.plaf.basic.BasicTabbedPaneUI;

import utils.constants.ColorConstant;

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
			// Thay Ä‘á»•i mÃ u ná»�n cá»§a cÃ¡c tab button
			tabAreaBackground = ColorConstant.BUTTON_NORMAL;
			// Thay Ä‘á»•i font chá»¯ cá»§a cÃ¡c tab button
			tabFont = new Font("Arial", Font.BOLD, 13);
			// Thay Ä‘á»•i Ä‘á»™ rá»™ng cá»§a viá»�n bao quanh cÃ¡c tab button
			tabInsets = new Insets(0, 15, 0, 15);
		}

		@Override
		protected void paintTab(Graphics g, int tabPlacement, Rectangle[] rects, int tabIndex, Rectangle iconRect,
				Rectangle textRect) {
			Graphics2D g2 = (Graphics2D) g;
			g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
			// Láº¥y mÃ u ná»�n cá»§a cÃ¡c tab button
			Color backgroundColor = tabAreaBackground;
			// Láº¥y mÃ u chá»¯ cá»§a cÃ¡c tab button
			Color textColor = Color.BLACK;
			// Kiá»ƒm tra xem tab button Ä‘Æ°á»£c chá»�n hay khÃ´ng Ä‘á»ƒ thay Ä‘á»•i mÃ u
			// ná»�n vÃ  mÃ u chá»¯
			if (tabIndex == getSelectedIndex()) {
				backgroundColor = new Color(235, 100, 64);
				textColor = Color.WHITE;
			}
			// Váº½ ná»�n cá»§a tab button
			g2.setColor(backgroundColor);
			g2.fillRect(rects[tabIndex].x, rects[tabIndex].y, rects[tabIndex].width, rects[tabIndex].height);
			// Váº½ chá»¯ cá»§a tab button
			g2.setColor(textColor);
			g2.setFont(tabFont);
			g2.drawString(getTitleAt(tabIndex), textRect.x, textRect.y + textRect.height - 4);
		}

		@Override
		protected void paintContentBorder(Graphics g, int tabPlacement, int selectedIndex) {
			// KhÃ´ng váº½ content border
		}
	}
}
