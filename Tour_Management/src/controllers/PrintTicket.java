package controllers;

import java.io.IOException;

import com.itextpdf.text.DocumentException;

import DAO.DAO_VeTour;
import entity.VeTour;
import utils.LoadSave;
import utils.PDFCreator;

public class PrintTicket {
    public static void printTicket(String maVe) throws DocumentException, IOException {
	VeTour veTour = DAO_VeTour.timKiemVeTour(maVe);

	PDFCreator.createTicketPDF(veTour, LoadSave.GetSpriteAtlas(LoadSave.LOGO_LABEL));
    }
}
