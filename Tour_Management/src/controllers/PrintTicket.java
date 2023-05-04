package controllers;

import java.io.IOException;
import java.time.LocalDate;

import com.itextpdf.text.DocumentException;

import DAO.DAO_DichVu;
import DAO.DAO_HopDongTour;
import DAO.DAO_KhachHang;
import DAO.DAO_NhanVien;
import DAO.DAO_TourDuLich;
import DAO.DAO_VeTour;
import entity.HopDongTour;
import entity.VeTour;
import utils.LoadSave;
import utils.PDFCreator;

public class PrintTicket {
    public static void printTicket(String maVe) throws DocumentException, IOException {
	VeTour veTour = DAO_VeTour.timKiemVeTour(maVe);

	PDFCreator.createTicketPDF(veTour, LoadSave.GetSpriteAtlas(LoadSave.LOGO_LABEL));
    }

//    public static void printContract(String maHopDong) throws FileNotFoundException, DocumentException {
    public static void printContract(String maHDT) throws DocumentException, IOException {
//	HopDongTour hopDongTour = DAO_HopDongTour.timKiemHopDong(maHopDong);

	HopDongTour hopDongTour = DAO_HopDongTour.timKiemHopDong(maHDT);

	PDFCreator.createContract(hopDongTour);
    }
}
