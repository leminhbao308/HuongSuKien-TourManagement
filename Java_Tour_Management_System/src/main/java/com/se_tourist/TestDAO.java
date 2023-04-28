package main.java.com.se_tourist;

import java.util.ArrayList;
import java.util.Date;

import main.java.com.se_tourist.dao.DAO_DiaDanh;
import main.java.com.se_tourist.dao.DAO_DichVu;
import main.java.com.se_tourist.dao.DAO_HopDongTour;
import main.java.com.se_tourist.dao.DAO_KhachHang;
import main.java.com.se_tourist.dao.DAO_NhanVien;
import main.java.com.se_tourist.dao.DAO_TaiKhoan;
import main.java.com.se_tourist.dao.DAO_TourDuLich;
import main.java.com.se_tourist.models.DichVu;
import main.java.com.se_tourist.models.HopDongTour;
import main.java.com.se_tourist.models.KhachHang;
import main.java.com.se_tourist.models.NhanVien;
import main.java.com.se_tourist.models.TaiKhoan;
import main.java.com.se_tourist.models.TourDuLich;

public class TestDAO {
    /**
     * @param args main để test output của phương thức lấy dữ liệu từ SQL
     */
    public static void main(String[] args) {
	ArrayList<KhachHang> dsKH = new ArrayList<KhachHang>();
	dsKH = DAO_KhachHang.getAllKhachHang();
	ArrayList<TourDuLich> dsTour = new ArrayList<TourDuLich>();
	dsTour = DAO_TourDuLich.getAllTourDuLich();
	ArrayList<DichVu> dsDv = new ArrayList<DichVu>();
	dsDv = DAO_DichVu.getAllDichVu();
	ArrayList<NhanVien> dsNv = new ArrayList<NhanVien>();
	dsNv = DAO_NhanVien.getAllNhanVien();
	ArrayList<HopDongTour> dsHD = new ArrayList<HopDongTour>();
	dsHD = DAO_HopDongTour.getAllHopDongTour();
	ArrayList<TaiKhoan> dsTK = new ArrayList<TaiKhoan>();
	dsTK = DAO_TaiKhoan.getAllTaiKhoan();

	DichVu dv = new DichVu("DV0010", "May bay", "Test add dich vu", 5000000);
	TourDuLich t = new TourDuLich("test035", "test", "test", new Date(), "test", 1, 1, false,
		DAO_DiaDanh.timDiaDanh("DD001"));
	KhachHang kh = new KhachHang("KH_Test2", "test", "test", false, new Date(), "test", "test", "test", 100,
		DAO_TourDuLich.timKiemTour("TDL001"), DAO_DichVu.timKiemDichVu("DV001"));
	HopDongTour hd = new HopDongTour("HD_test00", new Date(), "test", 500, 500,
		DAO_NhanVien.timKiemNhanVien("NV001"), DAO_KhachHang.timKiemKhachHang("KH001"));
	// HopDongTour hd = new HopDongTour(null, null, null, 0, 0, null, kh);
	// DAO_DichVu.themDichVu(dv);
	// DAO_DichVu.xoaDichVu("DV0010");
	// DAO_DichVu.suaThongTin("DV0010", "Tau hoa", "ok", 5000000);
	// DAO_TourDuLich.xoaTourDuLich("test035");
	// DAO_TourDuLich.suaTuorDuLich("test111", "test success", "test", new Date(),
	// "test", 1, 1, false, DAO_DiaDanh.timDiaDanh("DD001"));
	// dsTour = DAO_TourDuLich.getAllTourDuLich();
	System.out.println("-------------------");
	for (TourDuLich d : dsTour) {
	    System.out.println(d.toString());
	}
	System.out.println("-------------------");
	for (DichVu d : dsDv) {
	    System.out.println(d.toString());
	}
	System.out.println("-------------------");
	dsDv = DAO_DichVu.getAllDichVu();
	for (KhachHang d : dsKH) {
	    System.out.println(d.toString());
	}
	System.out.println("-------------------");
	dsDv = DAO_DichVu.getAllDichVu();
	for (NhanVien d : dsNv) {
	    System.out.println(d.toString());
	}
	System.out.println("-------------------");
	for (HopDongTour d : dsHD) {
	    System.out.println(d.toString());
	}
	// Thêm tài khoản mới
	DAO_TaiKhoan.themTaiKhoan(new TaiKhoan("AD000", "admin", "00000000",
		new NhanVien("AD000", "ADMIN", true, new Date(2000, 01, 01), null, null, null)));

	System.out.println("-------------------");
	for (TaiKhoan tk : dsTK) {
	    System.out.println(tk.toString());
	}
	System.out.println("-------------------");
	// DAO_KhachHang.suaKhachHang("KH_Test2", "test succes", "test", false, new
	// Date(), "test", "test", "test", 100, DAO_TourDuLich.timKiemTour("TDL001"),
	// DAO_DichVu.timKiemDichVu("DV001"));
	// DAO_HopDongTour.themHopDongTour(hd);
	// DAO_HopDongTour.xoaHopDongTour("HD_test00");
	ArrayList<HopDongTour> dsHDn = new ArrayList<HopDongTour>();
	dsHDn = DAO_HopDongTour.getAllHopDongTour();
	for (HopDongTour d : dsHDn) {
	    System.out.println(d.toString());
	}
	System.out.println("-------------------");
    }
}