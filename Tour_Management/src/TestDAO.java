
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

@SuppressWarnings("unused")
public class TestDAO {
    /**
     * @param args main để test output của phương thức lấy dữ liệu từ SQL
     */
    public static void main(String[] args) {
	ArrayList<DiaDanh> dsDD = new ArrayList<DiaDanh>();
	dsDD = DAO_DiaDanh.getAllDiaDanh();
	for (DiaDanh hd : dsDD) {
	    System.out.println(hd.toString());
	}
	DAO_DiaDanh.xoaDiaDanh("DD003");
	ArrayList<DiaDanh> dsDDt = new ArrayList<DiaDanh>();
	dsDDt = DAO_DiaDanh.getAllDiaDanh();
	for (DiaDanh hd : dsDDt) {
	    System.out.println(hd.toString());
	}
//		
//		
//		ArrayList<NhanVien> dsNV = new ArrayList<NhanVien>();
//		dsNV = DAO_NhanVien.getAllNhanVien();
//		for(NhanVien hd:dsNV) {
//			System.out.println(hd.toString());
//		}

//		ArrayList<VeTour> dsVT = new ArrayList<VeTour>();
//		dsVT = DAO_VeTour.getAllVeTour();
//		for(VeTour hd:dsVT) {
//			System.out.println(hd.toString());
//		}
//		
//		
//		
//		
//		System.out.println("-----------------");
//		KhachHang k = new KhachHang("test001", "12345678910121", "Tést success", false, LocalDate.now(), "linh", "012134567");
//		ArrayList<KhachHang> dsKH = new ArrayList<KhachHang>();
//		dsKH = DAO_KhachHang.getAllKhachHang();
//		for(KhachHang hd:dsKH) {
//			System.out.println(hd.toString());
//		}
//		System.out.println("-----------------");
//		//DAO_KhachHang.themKhachHang(k);
//		//DAO_KhachHang.suaKhachHang(k);
//		ArrayList<KhachHang> dsKHt = new ArrayList<KhachHang>();
//		dsKHt = DAO_KhachHang.getAllKhachHang();
//		for(KhachHang hd:dsKHt) {
//			System.out.println(hd.toString());
//		}
//		
//		
//		
//		System.out.println("-----------------");
//		ArrayList<HopDongTour> dsHopDong = new ArrayList<HopDongTour>();
//		dsHopDong = DAO_HopDongTour.getAllHopDongTour();
//		for(HopDongTour hd:dsHopDong) {
//			System.out.println(hd.toString());
//			System.out.println("-----------------");
//			System.out.println("Gia Tien : " + DAO_HopDongTour.getTongTienTour(hd.getDichVu().getMaDichVu(), hd.getTourDuLich().getMaTour()));
//			System.out.println("-----------------");
//		}
//		System.out.println("-----------------");
//		HopDongTour h = new HopDongTour("test003", LocalDate.now(), "Test sua", 0, DAO_NhanVien.timKiemNhanVien("NV001"), DAO_KhachHang.timKiemKhachHang("KH001"), DAO_TourDuLich.timKiemTour("TDL001"), DAO_DichVu.timKiemDichVu("DV001"));
//		//DAO_HopDongTour.themHopDongTour(h);
//		//DAO_HopDongTour.xoaHopDongTour("test003");
//		//DAO_HopDongTour.suaHopDongTour(h);
//		ArrayList<HopDongTour> dsHopDongT = new ArrayList<HopDongTour>();
//		dsHopDongT = DAO_HopDongTour.getAllHopDongTour();
//		for(HopDongTour hd:dsHopDongT) {
//			System.out.println(hd.toString());
//			System.out.println("-----------------");
//			System.out.println("Gia Tien : " + DAO_HopDongTour.getTongTienTour(hd.getDichVu().getMaDichVu(), hd.getTourDuLich().getMaTour()));
//			System.out.println("-----------------");
//		}
//		System.out.println("-----------------");
//		System.out.println("-----------------");
//		ArrayList<TourDuLich> dsT = new ArrayList<TourDuLich>();
//		dsT = DAO_TourDuLich.getAllTourDuLich();
//		for(TourDuLich hd:dsT) {
//			System.out.println(hd.toString());
//		}
//		TourDuLich t = new TourDuLich("Tets001", "Xin chào", "tses ", LocalDate.now(), "Hà Nội", 0, 0, false, DAO_DiaDanh.timDiaDanh("DD001"));
//		System.out.println("-----------------");
//		//DAO_TourDuLich.themTourDuLich(t);
//		//DAO_TourDuLich.xoaTourDuLich("Tets");
//		DAO_TourDuLich.suaTuorDuLich(t);
//		ArrayList<TourDuLich> dsT1 = new ArrayList<TourDuLich>();
//		dsT1 = DAO_TourDuLich.getAllTourDuLich();
//		for(TourDuLich hd:dsT1) {
//			System.out.println(hd.toString());
//		}
//		System.out.println("-----------------");
//		ArrayList<DichVu> dsDV = new ArrayList<DichVu>();
//		dsDV = DAO_DichVu.getAllDichVu();
//		for(DichVu hd:dsDV) {
//			System.out.println(hd.toString());
//		}
//		System.out.println("-----------------");
//		DichVu dt = new DichVu("DVT", "Thành công", "Update success", 5);
	// DAO_DichVu.themDichVu(dt);
	// DAO_DichVu.suaDichVu(dt);
	// DAO_DichVu.xoaDichVu("DV005");
	System.out.println("-----------------");
//		ArrayList<DichVu> dsDVt = new ArrayList<DichVu>();
//		dsDVt = DAO_DichVu.getAllDichVu();
//		for(DichVu hd:dsDVt) {
//			System.out.println(hd.toString());
//		}
//		
//			System.out.println("-----------------");
//			ArrayList<TaiKhoan> dsTK = new ArrayList<TaiKhoan>();
//			dsTK = DAO_TaiKhoan.getAllTaiKhoan();
//			for(TaiKhoan hd:dsTK) {
//				System.out.println(hd.toString());
//			}
//			System.out.println("-----------------");
//			NhanVien nv = new NhanVien("testtk001", "t", false, LocalDate.now(), "abc", "abc", "0132", "ksd");
//			//DAO_NhanVien.themNhanVien(nv);
//			ArrayList<NhanVien> dsNV = new ArrayList<NhanVien>();
//			dsNV = DAO_NhanVien.getAllNhanVien();
//			for(NhanVien hd:dsNV) {
//				System.out.println(hd.toString());
//			}
//			System.out.println("-----------------");
//			TaiKhoan tk = new TaiKhoan(DAO_NhanVien.timKiemNhanVien("NV000"), "1288000");
//			//DAO_TaiKhoan.themTaiKhoan(tk);
//			DAO_TaiKhoan.suaTaiKhoan(tk);
//			ArrayList<TaiKhoan> dsTKt = new ArrayList<TaiKhoan>();
//			dsTKt = DAO_TaiKhoan.getAllTaiKhoan();
//			for(TaiKhoan hd:dsTKt) {
//				System.out.println(hd.toString());
//			}
//			System.out.println("-----------------");
//			System.out.println("-----------------");
//			ArrayList<DichVu> dsDV = new ArrayList<DichVu>();
//			dsDV = DAO_DichVu.getAllDichVu();
//			for(DichVu hd:dsDV) {
//				System.out.println(hd.toString());
//			}
//			System.out.println("-----------------");
//		
    }
}