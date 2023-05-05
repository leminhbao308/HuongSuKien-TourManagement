package entity;

import java.time.LocalDate;
import java.util.Objects;

/**
 * 
 * @author LE HOANG NAM
 *
 */
public class HopDongTour {
	private String maHopDong;
	private LocalDate thoiGianLap;
	private String ghiChu;
	private float tongTien;
	private NhanVien nhanVien;
	private KhachHang khachHang;
	private TourDuLich tourDuLich;
	private DichVu dichVu;

	public HopDongTour(String maHopDong, LocalDate thoiGianLap, String ghiChu, float tongTien, NhanVien nhanVien,
			KhachHang khachHang, TourDuLich tourDuLich, DichVu dichVu) {
		super();
		this.maHopDong = maHopDong;
		this.thoiGianLap = thoiGianLap;
		this.ghiChu = ghiChu;
		this.tongTien = tongTien;
		this.nhanVien = nhanVien;
		this.khachHang = khachHang;
		this.tourDuLich = tourDuLich;
		this.dichVu = dichVu;
	}

	public HopDongTour(String maHopDong) {
		super();
		this.maHopDong = maHopDong;
	}

	public HopDongTour() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getMaHopDong() {
		return maHopDong;
	}

	public void setMaHopDong(String maHopDong) {
		this.maHopDong = maHopDong;
	}

	public LocalDate getThoiGianLap() {
		return thoiGianLap;
	}

	public void setThoiGianLap(LocalDate thoiGianLap) {
		this.thoiGianLap = thoiGianLap;
	}

	public String getGhiChu() {
		return ghiChu;
	}

	public void setGhiChu(String ghiChu) {
		this.ghiChu = ghiChu;
	}

	public float getTongTien() {
		return tongTien;
	}

	public void setTongTien(float tongTien) {
		this.tongTien = tongTien;
	}

	public NhanVien getNhanVien() {
		return nhanVien;
	}

	public void setNhanVien(NhanVien nhanVien) {
		this.nhanVien = nhanVien;
	}

	public KhachHang getKhachHang() {
		return khachHang;
	}

	public void setKhachHang(KhachHang khachHang) {
		this.khachHang = khachHang;
	}

	public TourDuLich getTourDuLich() {
		return tourDuLich;
	}

	public void setTourDuLich(TourDuLich tourDuLich) {
		this.tourDuLich = tourDuLich;
	}

	public DichVu getDichVu() {
		return dichVu;
	}

	public void setDichVu(DichVu dichVu) {
		this.dichVu = dichVu;
	}

	@Override
	public int hashCode() {
		return Objects.hash(maHopDong);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		HopDongTour other = (HopDongTour) obj;
		return Objects.equals(maHopDong, other.maHopDong);
	}

	@Override
	public String toString() {
		return maHopDong + ";" + thoiGianLap + ";" + ghiChu + ";" + tongTien + ";" + nhanVien.getTenNhanVien() + ";"
				+ khachHang.getTenKhachHang() + ";" + tourDuLich.getTenTour() + ";" + dichVu.getGiaDichVu();
	}

	public String getTitle() {
		return "Mã Hợp Đồng;Thời Gian Lập;Ghi Chú;Tổng Tiền;Tên Nhân Viên;Tên Khách Hàng;Tour Du Lịch;Tiền Dịch Vụ";
	}

}
