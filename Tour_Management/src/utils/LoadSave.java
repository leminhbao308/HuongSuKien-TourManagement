package utils;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

/**
 * Load cÃ¡c tÃ i nguyÃªn (HÃ¬nh áº¢nh) vÃ o á»©ng dá»¥ng
 * 
 * @author LeMinhBao
 * 
 */
public class LoadSave {
    /**
     * Táº¡o cÃ¡c Ä‘Æ°á»�ng dáº«n theo cÃº phÃ¡p: "folderLocation/name.extension"
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
    public static final String ICON_LOGIN = "icon/login.png";
    public static final String ICON_LOGOUT = "icon/logout.png";
    public static final String ICON_EMPLOYEE = "icon/employees.png";
    public static final String ICON_COSTUMER = "icon/costumer.png";
    public static final String ICON_TOUR = "icon/tour.png";
    public static final String ICON_SERVICE = "icon/service.png";
    public static final String ICON_CONTRACT = "icon/contract.png";
    public static final String ICON_TICKET = "icon/ticket.png";
    public static final String ICON_ADD = "icon/add.png";
    public static final String ICON_CANCEL = "icon/cancel.png";
    public static final String ICON_PASS = "icon/pass.png";

    /**
     * Láº¥y hÃ¬nh áº£nh tá»« Ä‘Æ°á»�ng dáº«n
     * 
     * @param fileName Ä�Æ°á»�ng dáº«n file
     * @return HÃ¬nh áº£nh táº¡i Ä‘Æ°á»�ng dáº«n
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
