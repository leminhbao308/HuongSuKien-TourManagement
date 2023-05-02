
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
import DAO.DAO_VeTour;
import entity.DiaDanh;
import entity.DichVu;
import entity.HopDongTour;
import entity.KhachHang;
import entity.NhanVien;
import entity.TaiKhoan;
import entity.TourDuLich;
import entity.VeTour;

public class TestDAO {
	/**
	 * @param args main để test output của phương thức lấy dữ liệu
	 *             từ SQL
	 */
		public static void main(String[] args) {
		ArrayList<HopDongTour> dsHopDong = new ArrayList<HopDongTour>();
		dsHopDong = DAO_HopDongTour.getAllHopDongTour();
		for(HopDongTour hd:dsHopDong) {
			System.out.println(hd.toString());
			System.out.println("-----------------");
			System.out.println("Gia Tien : " + DAO_HopDongTour.getTongTienTour(hd.getDichVu().getMaDichVu(), hd.getTourDuLich().getMaTour()));
			System.out.println("-----------------");
		}
		ArrayList<DiaDanh> dsDD = new ArrayList<DiaDanh>();
		dsDD = DAO_DiaDanh.getAllDiaDanh();
		for(DiaDanh hd:dsDD) {
			System.out.println(hd.toString());
		}
		System.out.println("-----------------");
		ArrayList<DichVu> dsDV = new ArrayList<DichVu>();
		dsDV = DAO_DichVu.getAllDichVu();
		for(DichVu hd:dsDV) {
			System.out.println(hd.toString());
		}
		System.out.println("-----------------");
		
		ArrayList<NhanVien> dsNV = new ArrayList<NhanVien>();
		dsNV = DAO_NhanVien.getAllNhanVien();
		for(NhanVien hd:dsNV) {
			System.out.println(hd.toString());
		}
		System.out.println("-----------------");
		ArrayList<TaiKhoan> dsTK = new ArrayList<TaiKhoan>();
		dsTK = DAO_TaiKhoan.getAllTaiKhoan();
		for(TaiKhoan hd:dsTK) {
			System.out.println(hd.toString());
		}
		System.out.println("-----------------");
		ArrayList<VeTour> dsVT = new ArrayList<VeTour>();
		dsVT = DAO_VeTour.getAllVeTour();
		for(VeTour hd:dsVT) {
			System.out.println(hd.toString());
		}
		
		System.out.println("-----------------");
		ArrayList<TourDuLich> dsT = new ArrayList<TourDuLich>();
		dsT = DAO_TourDuLich.getAllTourDuLich();
		for(TourDuLich hd:dsT) {
			System.out.println(hd.toString());
		}
		TourDuLich t = new TourDuLich("Tets001", "Xin chào", "tses", LocalDate.now(), "Hà Nội", 0, 0, false, DAO_DiaDanh.timDiaDanh("DD001"));
		System.out.println("-----------------");
		//DAO_TourDuLich.themTourDuLich(t);
		//DAO_TourDuLich.xoaTourDuLich("Tets");
		ArrayList<TourDuLich> dsT1 = new ArrayList<TourDuLich>();
		dsT1 = DAO_TourDuLich.getAllTourDuLich();
		for(TourDuLich hd:dsT1) {
			System.out.println(hd.toString());
		}
		System.out.println("-----------------");
		KhachHang k = new KhachHang("test001", "12345678910121", "Tést", false, LocalDate.now(), "linh", "012134567");
		ArrayList<KhachHang> dsKH = new ArrayList<KhachHang>();
		dsKH = DAO_KhachHang.getAllKhachHang();
		for(KhachHang hd:dsKH) {
			System.out.println(hd.toString());
		}
		System.out.println("-----------------");
		DAO_KhachHang.themKhachHang(k);
		ArrayList<KhachHang> dsKHt = new ArrayList<KhachHang>();
		dsKHt = DAO_KhachHang.getAllKhachHang();
		for(KhachHang hd:dsKHt) {
			System.out.println(hd.toString());
		}
	}
}