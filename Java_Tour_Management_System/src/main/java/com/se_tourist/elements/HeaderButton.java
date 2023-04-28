package main.java.com.se_tourist.elements;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;

/**
 * Button tùy chỉnh với thiết kế và hiệu ứng thiết lập sẵn
 * 
 * @author LeMinhBao
 * @see #HeaderButton(String, Color, Color)
 */
public class HeaderButton extends JButton {
    /**
     * 
     */
    private static final long serialVersionUID = 3655431176382907577L;
    private Color backgroundColor;
    private Color textColor;
    private boolean hover;
    private boolean click;

    /**
     * Khởi tạo một Button tùy chỉnh với một số thông số mong muốn
     * 
     * @param title           Tiêu đề trên Button
     * @param backgroundColor Màu nền mặc định của Button
     * @param textColor       Màu chữ mặc định của Button
     */
    public HeaderButton(String title, Color backgroundColor, Color textColor) {
	super(title);
	this.backgroundColor = backgroundColor;
	this.textColor = textColor;
	setOpaque(false);
	setContentAreaFilled(false);
	setForeground(this.textColor);
	setBackground(this.backgroundColor);
	setBorderPainted(false);
	setFont(new Font("Arial", Font.BOLD, 13));
	setSize(50, 5);
	addMouseListener(new MouseAdapter() {
	    @Override
	    public void mouseEntered(MouseEvent e) {
		hover = true;
		repaint();
	    }

	    @Override
	    public void mouseExited(MouseEvent e) {
		hover = false;
		click = false;
		repaint();
	    }

	    @Override
	    public void mousePressed(MouseEvent e) {
		click = true;
		repaint();
	    }

	    @Override
	    public void mouseReleased(MouseEvent e) {
		click = false;
		repaint();
	    }
	});
    }

//    @Override
//    protected void paintComponent(Graphics g) {
//	Graphics2D g2 = (Graphics2D) g;
//	g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
//
//	if (getModel().isPressed() || click) {
//	    g2.setColor(new Color(235, 100, 64));
//	    g2.fillRect(0, 0, getWidth(), getHeight());
//	    g2.setColor(this.textColor);
//	    g2.setFont(getFont().deriveFont(Font.ITALIC));
//	    g2.drawString(getText(), (getWidth() - g2.getFontMetrics().stringWidth(getText())) / 2,
//		    (getHeight() + g2.getFontMetrics().getAscent() - g2.getFontMetrics().getDescent()) / 2);
//	} else if (hover) {
//	    g2.setColor(new Color(235, 100, 64));
//	    g2.fillRect(0, 0, getWidth(), getHeight());
//	    g2.setColor(this.textColor);
//	    g2.drawString(getText(), (getWidth() - g2.getFontMetrics().stringWidth(getText())) / 2,
//		    (getHeight() + g2.getFontMetrics().getAscent() - g2.getFontMetrics().getDescent()) / 2);
//	} else {
//	    g2.setColor(getBackground());
//	    g2.fillRect(0, 0, getWidth(), getHeight());
//	    g2.setColor(new Color(235, 100, 64));
//	    g2.drawLine(0, getHeight() - 1, getWidth(), getHeight() - 1);
//	    g2.setColor(this.textColor);
//	    g2.drawString(getText(), (getWidth() - g2.getFontMetrics().stringWidth(getText())) / 2,
//		    (getHeight() + g2.getFontMetrics().getAscent() - g2.getFontMetrics().getDescent()) / 2);
//	}
//    }
    @Override
    protected void paintComponent(Graphics g) {
	super.paintComponent(g);
	Graphics2D g2d = (Graphics2D) g.create();

	g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

	if (getModel().isPressed() || click) {
	    g2d.setColor(new Color(235, 100, 64));
	} else if (hover) {
	    g2d.setColor(new Color(235, 100, 64));
	} else {
	    g2d.setColor(getBackground());
	}

	g2d.fillRect(0, 0, getWidth(), getHeight());
	g2d.setColor(this.textColor);

	FontMetrics fm = g2d.getFontMetrics();
	int x = (getWidth() - fm.stringWidth(getText())) / 2;
	int y = (getHeight() + fm.getAscent() - fm.getDescent()) / 2;

	g2d.drawString(getText(), x, y);
	g2d.dispose();
    }

}
