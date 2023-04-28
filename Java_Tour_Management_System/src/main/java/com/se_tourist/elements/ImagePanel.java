package main.java.com.se_tourist.elements;

import java.awt.AlphaComposite;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

import main.java.com.se_tourist.utils.LoadSave;

/**
 * Tạo một Panel với background là một hình ảnh được truyền vào
 * 
 * @author LeMinhBao
 * @see #ImagePanel(BufferedImage)
 * @see #ImagePanel(BufferedImage, float)
 */
public class ImagePanel extends JPanel {

    /**
     * 
     */
    private static final long serialVersionUID = 6097395849505121852L;
    private BufferedImage image;
    private float opacity;

    /**
     * Khởi tạo một Panel với background là hình ảnh
     * 
     * @param img Hình ảnh truyền vào
     * @see LoadSave
     */
    public ImagePanel(BufferedImage img) {
	this.image = img;
	this.opacity = 0f;

	setPreferredSize(new Dimension(image.getWidth(), image.getHeight()));

	scaleImage();
    }

    /**
     * Khởi tạo một Panel với background là hình ảnh được làm mờ
     * 
     * @param img     Hình ảnh truyền vào
     * @param opacity Độ mờ ảnh (0.5f = 50%)
     * @see LoadSave
     */
    public ImagePanel(BufferedImage img, float opacity) {
	this.image = img;
	this.opacity = opacity;

	setPreferredSize(new Dimension(image.getWidth(), image.getHeight()));

	scaleImage();
    }

    /**
     * Căn chỉnh kích thước hình ảnh lấp trọn panel
     */
    private void scaleImage() {
	// Lấy kích thước của màn hình
	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	int screenWidth = (int) screenSize.getWidth();
	int screenHeight = (int) screenSize.getHeight();

	// Lấy kích thước của hình ảnh
	int imageWidth = image.getWidth();
	int imageHeight = image.getHeight();

	// Tính toán tỷ lệ giữa chiều rộng của màn hình và chiều rộng của hình ảnh
	float widthRatio = (float) screenWidth / imageWidth;
	// Tính toán tỷ lệ giữa chiều cao của màn hình và chiều cao của hình ảnh
	float heightRatio = (float) screenHeight / imageHeight;

	// Chọn tỷ lệ nào nhỏ hơn giữa hai tỷ lệ trên
	float ratio = Math.min(widthRatio, heightRatio);

	// Sử dụng tỷ lệ để tính toán kích thước mới của hình ảnh
	int newWidth = (int) (imageWidth * ratio);
	int newHeight = (int) (imageHeight * ratio);

	// Cập nhật kích thước của hình ảnh
	setPreferredSize(new Dimension(newWidth, newHeight));
    }

    @Override
    protected void paintComponent(Graphics g) {
	super.paintComponent(g);
	Graphics2D g2 = (Graphics2D) g;
	int imgWidth = image.getWidth();
	int imgHeight = image.getHeight();

	double panelWidth = getWidth();
	double panelHeight = getHeight();

	double sx = panelWidth / imgWidth;
	double sy = panelHeight / imgHeight;

	double scale = Math.max(sx, sy);

	int scaledWidth = (int) (scale * imgWidth);
	int scaledHeight = (int) (scale * imgHeight);

	int x = (int) ((panelWidth - scaledWidth) / 2);
	int y = (int) ((panelHeight - scaledHeight) / 2);

	AlphaComposite alphaComposite = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, opacity);
	g2.setComposite(alphaComposite);
	g2.drawImage(image, x, y, scaledWidth, scaledHeight, null);
    }

}
