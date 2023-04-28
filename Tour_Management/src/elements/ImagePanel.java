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
 * Táº¡o má»™t Panel vá»›i background lÃ  má»™t hÃ¬nh áº£nh Ä‘Æ°á»£c truyá»�n
 * vÃ o
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
	 * Khá»Ÿi táº¡o má»™t Panel vá»›i background lÃ  hÃ¬nh áº£nh
	 * 
	 * @param img HÃ¬nh áº£nh truyá»�n vÃ o
	 * @see LoadSave
	 */
	public ImagePanel(BufferedImage img) {
		this.image = img;
		this.opacity = 0f;

		setPreferredSize(new Dimension(image.getWidth(), image.getHeight()));

		scaleImage();
	}

	/**
	 * Khá»Ÿi táº¡o má»™t Panel vá»›i background lÃ  hÃ¬nh áº£nh Ä‘Æ°á»£c lÃ m má»�
	 * 
	 * @param img     HÃ¬nh áº£nh truyá»�n vÃ o
	 * @param opacity Ä�á»™ má»� áº£nh (0.5f = 50%)
	 * @see LoadSave
	 */
	public ImagePanel(BufferedImage img, float opacity) {
		this.image = img;
		this.opacity = opacity;

		setPreferredSize(new Dimension(image.getWidth(), image.getHeight()));

		scaleImage();
	}

	/**
	 * CÄƒn chá»‰nh kÃ­ch thÆ°á»›c hÃ¬nh áº£nh láº¥p trá»�n panel
	 */
	private void scaleImage() {
		// Láº¥y kÃ­ch thÆ°á»›c cá»§a mÃ n hÃ¬nh
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int screenWidth = (int) screenSize.getWidth();
		int screenHeight = (int) screenSize.getHeight();

		// Láº¥y kÃ­ch thÆ°á»›c cá»§a hÃ¬nh áº£nh
		int imageWidth = image.getWidth();
		int imageHeight = image.getHeight();

		// TÃ­nh toÃ¡n tá»· lá»‡ giá»¯a chiá»�u rá»™ng cá»§a mÃ n hÃ¬nh vÃ  chiá»�u
		// rá»™ng cá»§a hÃ¬nh áº£nh
		float widthRatio = (float) screenWidth / imageWidth;
		// TÃ­nh toÃ¡n tá»· lá»‡ giá»¯a chiá»�u cao cá»§a mÃ n hÃ¬nh vÃ  chiá»�u cao
		// cá»§a hÃ¬nh áº£nh
		float heightRatio = (float) screenHeight / imageHeight;

		// Chá»�n tá»· lá»‡ nÃ o nhá»� hÆ¡n giá»¯a hai tá»· lá»‡ trÃªn
		float ratio = Math.min(widthRatio, heightRatio);

		// Sá»­ dá»¥ng tá»· lá»‡ Ä‘á»ƒ tÃ­nh toÃ¡n kÃ­ch thÆ°á»›c má»›i cá»§a hÃ¬nh
		// áº£nh
		int newWidth = (int) (imageWidth * ratio);
		int newHeight = (int) (imageHeight * ratio);

		// Cáº­p nháº­t kÃ­ch thÆ°á»›c cá»§a hÃ¬nh áº£nh
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
