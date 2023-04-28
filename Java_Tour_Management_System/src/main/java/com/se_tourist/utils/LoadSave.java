package main.java.com.se_tourist.utils;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

/**
 * Load các tài nguyên (Hình Ảnh) vào ứng dụng
 * 
 * @author LeMinhBao
 * 
 */
public class LoadSave {
    /**
     * Tạo các đường dẫn theo cú pháp: "folderLocation/name.extension"
     */
    public static final String LOGO_PIC = "logo/logo.png";
    public static final String LOGO_ICON = "logo/logo01.png";
    public static final String LOGO_LABEL = "logo/logo02.png";
    public static final String PROFILE_ICON = "icon/profile.png";
    public static final String BACKGROUND_DASHBOARD = "background/background-dashboard.jpg";
    public static final String CARD_PRODUCT = "background/card-product.png";
    public static final String ICON_CONTACT = "icon/contact.png";
    public static final String ICON_MAIL = "icon/mail.png";
    public static final String ICON_LOCATION = "icon/location.png";
    public static final String ICON_PROFILE = "icon/profile.png";
    public static final String ICON_SEARCH = "icon/search.png";

    /**
     * Lấy hình ảnh từ đường dẫn
     * 
     * @param fileName Đường dẫn file
     * @return Hình ảnh tại đường dẫn
     */
    public static BufferedImage GetSpriteAtlas(String fileName) {

	BufferedImage img = null;
	InputStream is = LoadSave.class.getResourceAsStream("/" + fileName);

	try {
	    img = ImageIO.read(is);
	} catch (IOException e) {
	    e.printStackTrace();
	} finally {
	    try {
		is.close();
	    } catch (IOException e) {
		e.printStackTrace();
	    }
	}
	return img;
    }
}
