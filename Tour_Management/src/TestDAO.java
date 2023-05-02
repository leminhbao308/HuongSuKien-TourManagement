
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

import DAO.DAO_DiaDanh;
import DAO.DAO_DichVu;
import DAO.DAO_HopDongTour;
import DAO.DAO_KhachHang;
import DAO.DAO_NhanVien;
import DAO.DAO_TaiKhoan;
import DAO.DAO_TourDuLich;
import entity.DiaDanh;
import entity.DichVu;
import entity.HopDongTour;
import entity.KhachHang;
import entity.NhanVien;
import entity.TaiKhoan;
import entity.TourDuLich;

public class TestDAO {
	/**
	 * @param args main để test output của phương thức lấy dữ liệu
	 *             từ SQL
	 */
		public static void main(String[] args) {
//		ArrayList<KhachHang> dsKH = new ArrayList<KhachHang>();
//		dsKH = DAO_KhachHang.getAllKhachHang();
//		ArrayList<TourDuLich> dsTour = new ArrayList<TourDuLich>();
//		dsTour = DAO_TourDuLich.getAllTourDuLich();
//		ArrayList<DichVu> dsDv = new ArrayList<DichVu>();
//		dsDv = DAO_DichVu.getAllDichVu();
//		ArrayList<NhanVien> dsNv = new ArrayList<NhanVien>();
//		dsNv = DAO_NhanVien.getAllNhanVien();
//		ArrayList<HopDongTour> dsHD = new ArrayList<HopDongTour>();
//		dsHD = DAO_HopDongTour.getAllHopDongTour();
//		ArrayList<TaiKhoan> dsTK = new ArrayList<TaiKhoan>();
//		dsTK = DAO_TaiKhoan.getAllTaiKhoan();
//
//		
//		// HopDongTour hd = new HopDongTour(null, null, null, 0, 0, null, kh);
//		// DAO_DichVu.themDichVu(dv);
//		// DAO_DichVu.xoaDichVu("DV0010");
//		// DAO_DichVu.suaThongTin("DV0010", "Tau hoa", "ok", 5000000);
//		// DAO_TourDuLich.xoaTourDuLich("test035");
//		// DAO_TourDuLich.suaTuorDuLich("test111", "test success", "test", new Date(),
//		// "test", 1, 1, false, DAO_DiaDanh.timDiaDanh("DD001"));
//		// dsTour = DAO_TourDuLich.getAllTourDuLich();
//		System.out.println("-------------------");
//		for (TourDuLich d : dsTour) {
//			System.out.println(d.toString());
//		}
//		System.out.println("-------------------");
//		for (DichVu d : dsDv) {
//			System.out.println(d.toString());
//		}
//		System.out.println("-------------------");
//		dsDv = DAO_DichVu.getAllDichVu();
//		for (KhachHang d : dsKH) {
//			System.out.println(d.toString());
//		}
//		System.out.println("-------------------");
//		dsDv = DAO_DichVu.getAllDichVu();
//		for (NhanVien d : dsNv) {
//			System.out.println(d.toString());
//		}
//		System.out.println("-------------------");
//		for (HopDongTour d : dsHD) {
//			System.out.println(d.toString());
//		}
//		// Thêm tài khoản mới
//		
//		System.out.println("-------------------");
//		for (TaiKhoan tk : dsTK) {
//			System.out.println(tk.toString());
//		}
//		System.out.println("-------------------");
		// DAO_KhachHang.suaKhachHang("KH_Test2", "test succes", "test", false, new
		// Date(), "test", "test", "test", 100, DAO_TourDuLich.timKiemTour("TDL001"),
		// DAO_DichVu.timKiemDichVu("DV001"));
		// DAO_HopDongTour.themHopDongTour(hd);
		// DAO_HopDongTour.xoaHopDongTour("HD_test00");
//		ArrayList<HopDongTour> dsHDn = new ArrayList<HopDongTour>();
//		dsHDn = DAO_HopDongTour.getAllHopDongTour();
//		for (HopDongTour d : dsHDn) {
//			System.out.println(d.toString());
//		}
//		System.out.println("-------------------");
//		ArrayList<DiaDanh> dsDD = new ArrayList<DiaDanh>();
//		dsDD = DAO_DiaDanh.getAllDiaDanh();
//		for (DiaDanh d : dsDD) {
//			System.out.println(d.toString());
//		}
//		System.out.println("-------------------");
	
		ArrayList<HopDongTour> dsHopDong = new ArrayList<HopDongTour>();
		dsHopDong = DAO_HopDongTour.getAllHopDongTour();
		for(HopDongTour hd:dsHopDong) {
			System.out.println(hd.toString());
			System.out.println("-----------------");
			System.out.println("Gia Tien : " + DAO_HopDongTour.getTongTienTour(hd.getDichVu().getMaDichVu(), hd.getTourDuLich().getMaTour()));
			System.out.println("-----------------");
		}
		
	}
}