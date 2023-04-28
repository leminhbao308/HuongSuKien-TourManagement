package elements;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JPanel;

/**
 * Panel được bo góc
 * 
 * @author LeMinhBao
 * @see RoundJButton
 * @see RoundJTextField
 * @see RoundJPasswordField
 * @see #RoundPanel()
 */
public class RoundPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7792771550562292634L;
	private int radius;

	/**
	 * Khởi tạo một Panel được bo góc
	 */
	public RoundPanel() {
		super();
		this.radius = 20;
		setOpaque(true);
	}

	@Override
	protected void paintComponent(Graphics g) {
		int x = 0;
		int y = 0;
		int w = getWidth();
		int h = getHeight();
		Graphics2D g2 = (Graphics2D) g.create();
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2.setColor(getBackground());
		g2.fillRoundRect(x, y, w - 1, h - 1, radius, radius);
		g2.setColor(getForeground());
		g2.drawRoundRect(x, y, w - 1, h - 1, radius, radius);
		g2.dispose();
	}
}
