package entity;

import java.time.LocalDate;

public class HopDongTour {
	private String maHopDong;
	private LocalDate thoiGianLap;
	private String ghiChu;
	private float tongTien;
	private float daThanhToan;
	private NhanVien nhanVien;
	private KhachHang khachHang;
	
	@Override
	public String toString() {
		return maHopDong + ";" + thoiGianLap + ";" + ghiChu + ";" + tongTien + ";" + daThanhToan + ";"
				+ nhanVien.getMaNhanVien() + ";" + khachHang.getMaKhachHang();
	}

	public String getTitle() {
		return "Mã Hợp �?ồng;Th�?i Gian Lập;Ghi Chú;Tổng Ti�?n;Trạng Thái;Mã Nhân Viên;Mã Khách Hàng";
	}

}
