package main.java.com.se_tourist.elements;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;

import main.java.com.se_tourist.utils.constants.ColorConstant;

/**
 * Button được bo góc với các thiết lập tùy chỉnh
 * 
 * @author LeMinhBao
 * @see RoundPanel
 * @see RoundJTextField
 * @see RoundJPasswordField
 * @see #RoundJButton(String)
 */
public class RoundJButton extends JButton {

    /**
     * 
     */
    private static final long serialVersionUID = -7128508965765743677L;
    Color colorDefault = new Color(235, 100, 64);
    Color colorOver = Color.WHITE;
    Color colorClick = ColorConstant.BACKGROUND_NORMAL;
    Color borderColor = new Color(30, 136, 56);
    boolean over;

    /**
     * Khởi tạo một Button bo góc với tiêu đề tùy chỉnh
     * 
     * @param name Tiêu đề của Button
     */
    public RoundJButton(String name) {
	super(name);
	setBorderPainted(false);
	setOpaque(false);

	setContentAreaFilled(false);
	// Add event mouse
	addMouseListener(new MouseAdapter() {
	    @Override
	    public void mouseEntered(MouseEvent me) {
		setBackground(colorOver);
		setForeground(colorDefault);
		over = true;
	    }

	    @Override
	    public void mouseExited(MouseEvent me) {
		setBackground(colorDefault);
		setForeground(colorOver);
		over = false;

	    }

	    @Override
	    public void mousePressed(MouseEvent me) {
		setBackground(colorClick);
		setForeground(ColorConstant.BUTTON_NORMAL);
	    }

	    @Override
	    public void mouseReleased(MouseEvent me) {
		if (over) {
		    setBackground(colorOver);
		    setForeground(colorDefault);
		} else {
		    setBackground(colorDefault);
		    setForeground(colorOver);
		}
	    }
	});
    }

    public RoundJButton(String name, int width, int height) {
	super(name);
	super.setSize(width, height);
	setBorderPainted(false);
	setOpaque(false);

	setContentAreaFilled(false);
	// Add event mouse
	addMouseListener(new MouseAdapter() {
	    @Override
	    public void mouseEntered(MouseEvent me) {
		setBackground(colorOver);
		setForeground(colorDefault);
		over = true;
	    }

	    @Override
	    public void mouseExited(MouseEvent me) {
		setBackground(colorDefault);
		setForeground(colorOver);
		over = false;

	    }

	    @Override
	    public void mousePressed(MouseEvent me) {
		setBackground(colorClick);
		setForeground(colorDefault);
	    }

	    @Override
	    public void mouseReleased(MouseEvent me) {
		if (over) {
		    setBackground(colorOver);
		    setForeground(colorDefault);
		} else {
		    setBackground(colorDefault);
		    setForeground(colorOver);
		}
	    }
	});
    }

    @Override
    protected void paintComponent(Graphics grphcs) {
	Graphics2D g2 = (Graphics2D) grphcs;
	g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
	// Paint Border
	g2.setColor(getBackground());
	g2.fillRoundRect(0, 0, getWidth(), getHeight(), 20, 20);
	super.paintComponent(grphcs);
    }
}
