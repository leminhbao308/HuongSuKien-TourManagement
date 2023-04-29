import java.io.IOException;
import java.util.Date;

import com.itextpdf.text.DocumentException;

import controllers.PDFCreator;
import models.DiaDanh;
import models.DichVu;
import models.KhachHang;
import models.TourDuLich;
import models.VeTour;
import utils.LoadSave;
import utils.PasswordEncoder;

public class Test {

    public static void main(String args[]) {
	try {
	    PDFCreator.createTicketPDF(
		    new VeTour("VT001", new KhachHang("KH001", "051203000318", "Lê Minh Bảo", true,
			    new Date(2003 - 1900, 8, 3), "Gò Vấp", "leminhbao.iuh@gmail.com", "0399405711", 1900000f,
			    new TourDuLich("TOUR001", "Quảng Ngãi", "Tour Quảng Ngãi", new Date(2023 - 1900, 8, 3),
				    "Quảng Ngãi", 3, 1900000f, false, new DiaDanh("DD001", "Quảng Ngãi", "Quảng Ngãi")),
			    new DichVu("DV001", "Xe Khách 40 chỗ", "Có khách sạn 3 sao", 1000000f))),
		    LoadSave.GetSpriteAtlas(LoadSave.LOGO_LABEL));
	} catch (DocumentException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	} catch (IOException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}
    }
}
