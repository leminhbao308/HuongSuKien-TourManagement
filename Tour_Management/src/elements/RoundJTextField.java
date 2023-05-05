package elements;

import java.awt.Graphics;
import java.awt.Shape;
import java.awt.geom.RoundRectangle2D;

import javax.swing.JTextField;

/**
 * TextField được bo góc
 * 
 * @author LeMinhBao
 * @author LE HOANG NAM
 * @author TRAN HIEN VINH
 * @see RoundPanel
 * @see RoundJButton
 * @see RoundJPasswordField
 * @see #RoundJTextField(int)
 * @see #RoundJTextField(String)
 */
public class RoundJTextField extends JTextField {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7815033924674387839L;
	private Shape shape;

	/**
	 * Khởi tạo một TextField được bo góc
	 * 
	 * @param size Kích thước của TextField
	 */
	public RoundJTextField(int size) {
		super(size);
		setOpaque(false); // As suggested by @AVD in comment.
	}

	/**
	 * Khởi tạo TextField được bo góc
	 * 
	 * @param string Nội dung của TextField
	 */
	public RoundJTextField(String string) {
		super(string);
		setOpaque(false);
	}

	protected void paintComponent(Graphics g) {
		g.setColor(getBackground());
		g.fillRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 20, 20);
		super.paintComponent(g);
	}

	protected void paintBorder(Graphics g) {
		g.setColor(getForeground());
		g.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 20, 20);
	}

	public boolean contains(int x, int y) {
		if (shape == null || !shape.getBounds().equals(getBounds())) {
			shape = new RoundRectangle2D.Float(0, 0, getWidth() - 1, getHeight() - 1, 20, 20);
		}
		return shape.contains(x, y);
	}
}