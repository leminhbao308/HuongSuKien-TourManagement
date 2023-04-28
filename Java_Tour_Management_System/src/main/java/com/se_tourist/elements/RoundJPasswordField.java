package main.java.com.se_tourist.elements;

import java.awt.Graphics;
import java.awt.Shape;
import java.awt.geom.RoundRectangle2D;

import javax.swing.JPasswordField;

/**
 * Field Password được bo góc
 * 
 * @author LeMinhBao
 * @see RoundPanel
 * @see RoundJTextField
 * @see RoundJButton
 * @see #RoundJPasswordField(int)
 */
public class RoundJPasswordField extends JPasswordField {
    /**
     * 
     */
    private static final long serialVersionUID = 269843675684264564L;
    private Shape shape;

    /**
     * Khởi tạo một Field Password được bo góc
     * 
     * @param size Kích thước của Field Password
     */
    public RoundJPasswordField(int size) {
	super(size);
	setOpaque(false); // As suggested by @AVD in comment.
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
