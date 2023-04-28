package elements;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.geom.RoundRectangle2D;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JTextField;

import utils.LoadSave;

public class SearchBar extends JTextField {

	/**
	 * 
	 */
	private static final long serialVersionUID = 360199448920568710L;
	private final Icon searchIcon = new ImageIcon(LoadSave.GetSpriteAtlas(LoadSave.ICON_SEARCH));;
	private final Color borderColor = new Color(235, 100, 64);
	private final int borderRadius = 15;
	private boolean isFocused = false;

	public SearchBar() {
		setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 30));
		addFocusListener(new FocusListener() {
			@Override
			public void focusGained(FocusEvent e) {
				isFocused = true;
				repaint();
			}

			@Override
			public void focusLost(FocusEvent e) {
				isFocused = false;
				repaint();
			}
		});
	}

	@Override
	protected void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g.create();
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		if (isOpaque()) {
			g2.setColor(getBackground());
			g2.fill(new RoundRectangle2D.Float(0, 0, getWidth() - 1, getHeight() - 1, borderRadius, borderRadius));
		}
		if (isFocused) {
			g2.setColor(borderColor);
			g2.draw(new RoundRectangle2D.Float(0, 0, getWidth() - 1, getHeight() - 1, borderRadius, borderRadius));
		}
		super.paintComponent(g2);
		int iconHeight = searchIcon.getIconHeight();
		int iconWidth = searchIcon.getIconWidth();
		int x = getWidth() - iconWidth - 10;
		int y = (getHeight() - iconHeight) / 2;
		searchIcon.paintIcon((Component) this, g2, x, y);
		g2.dispose();
	}

}
