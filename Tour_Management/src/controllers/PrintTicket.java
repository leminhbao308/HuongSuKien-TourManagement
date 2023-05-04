package controllers;

import java.io.IOException;
import com.itextpdf.text.DocumentException;

import DAO.DAO_HopDongTour;
import DAO.DAO_VeTour;
import entity.HopDongTour;
import entity.VeTour;
import utils.PDFCreator;

public class PrintTicket {
    public static void printTicket(String maVe, String path) throws DocumentException, IOException {
	VeTour veTour = DAO_VeTour.timKiemVeTour(maVe);

	PDFCreator.createTicketPDF(veTour, path);
    }

//    public static void printContract(String maHopDong) throws FileNotFoundException, DocumentException {
    public static void printContract(String maHDT, String path) throws DocumentException, IOException {
//	HopDongTour hopDongTour = DAO_HopDongTour.timKiemHopDong(maHopDong);

	HopDongTour hopDongTour = DAO_HopDongTour.timKiemHopDong(maHDT);

	PDFCreator.createContract(hopDongTour, path);
    }
}
