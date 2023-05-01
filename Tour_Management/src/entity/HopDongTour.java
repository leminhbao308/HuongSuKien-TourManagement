package models;

import java.util.Date;

public class HopDongTour {
	private String maHopDong;
	private Date thoiGianLap;
	private String ghiChu;
	private float tongTien;
	private float daThanhToan;
	private NhanVien nhanVien;
	private KhachHang khachHang;

	public HopDongTour() {
	}

	public HopDongTour(String maHopDong, Date thoiGianLap, String ghiChu, float tongTien, float daThanhToan,
			NhanVien nhanVien, KhachHang khachHang) {
		super();
		this.maHopDong = maHopDong;
		this.thoiGianLap = thoiGianLap;
		this.ghiChu = ghiChu;
		this.tongTien = tongTien;
		this.daThanhToan = daThanhToan;
		this.nhanVien = nhanVien;
		this.khachHang = khachHang;
	}

	public String getMaHopDong() {
		return maHopDong;
	}

	public void setMaHopDong(String maHopDong) {
		this.maHopDong = maHopDong;
	}

	public Date getThoiGianLap() {
		return thoiGianLap;
	}

	public void setThoiGianLap(Date thoiGianLap) {
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

	public float getDaThanhToan() {
		return daThanhToan;
	}

	public void setDaThanhToan(float daThanhToan) {
		this.daThanhToan = daThanhToan;
	}

	public NhanVien getNhanVien() {
		return nhanVien;
	}

	public void setMaNhanVien(NhanVien maNhanVien) {
		this.nhanVien = maNhanVien;
	}

	public KhachHang getKhachHang() {
		return khachHang;
	}

	public void setMaKhachHang(KhachHang khachHang) {
		this.khachHang = khachHang;
	}

	@Override
	public String toString() {
		return maHopDong + ";" + thoiGianLap + ";" + ghiChu + ";" + tongTien + ";" + daThanhToan + ";"
				+ nhanVien.getMaNhanVien() + ";" + khachHang.getMaKhachHang();
	}

	public String getTitle() {
		return "Mã Hợp Đồng;Thời Gian Lập;Ghi Chú;Tổng Tiền;Trạng Thái;Mã Nhân Viên;Mã Khách Hàng";
	}

}
