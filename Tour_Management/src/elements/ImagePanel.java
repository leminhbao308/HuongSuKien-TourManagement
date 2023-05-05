package elements;

import java.awt.AlphaComposite;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

import utils.LoadSave;

/**
 * Tạo một panel mới background là một hình ảnh được truyền vào
 * 
 * @author LeMinhBao
 * @author LE HOANG NAM
 * @author TRAN HIEN VINH
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
	 * Khởi tạo panel với background là hình ảnh
	 * 
	 * @param img hình ảnh truyền vào
	 * @see LoadSave
	 */
	public ImagePanel(BufferedImage img) {
		this.image = img;
		this.opacity = 0f;

		setPreferredSize(new Dimension(image.getWidth(), image.getHeight()));

		scaleImage();
	}

	/**
	 * Khởi tạo background là hình ảnh được làm mờ
	 * 
	 * @param img     Hình ảnh truyền vào
	 * @param opacity độ mờ của hình ảnh (0.5f = 50%)
	 * @see LoadSave
	 */
	public ImagePanel(BufferedImage img, float opacity) {
		this.image = img;
		this.opacity = opacity;

		setPreferredSize(new Dimension(image.getWidth(), image.getHeight()));

		scaleImage();
	}

	/**
	 * Căn chỉnh hình ảnh kích thước vừa với panel
	 */
	private void scaleImage() {
		// Lấy kích thước của màn hình
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int screenWidth = (int) screenSize.getWidth();
		int screenHeight = (int) screenSize.getHeight();

		// Lấy kích thước của hình ảnh
		int imageWidth = image.getWidth();
		int imageHeight = image.getHeight();

		// Tính toán tỉ lệ độ rộng
		float widthRatio = (float) screenWidth / imageWidth;
		// Tính toán tỉ lệ chiều cao
		float heightRatio = (float) screenHeight / imageHeight;

		float ratio = Math.min(widthRatio, heightRatio);

		// scale kích thước hình ảnh bằng với tỉ lệ đã tính toán
		int newWidth = (int) (imageWidth * ratio);
		int newHeight = (int) (imageHeight * ratio);

		// Cập nhật lại kích thước hình ảnh
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
