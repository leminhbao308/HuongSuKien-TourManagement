package models;

import java.util.Date;

public class KhachHang {
	private String maKhachHang;
	private String soCCCD_HC;
	private String tenKhachHang;
	private boolean gioiTinh;
	private Date ngaySinh;
	private String diaChi;
	private String email;
	private String soDienThoai;
	private float tienTour;
	private TourDuLich tourDuLich;
	private DichVu dichVu;

	public KhachHang() {
	}

	public KhachHang(String maKhachHang, String soCCCD_HC, String tenKhachHang, boolean gioiTinh, Date ngaySinh,
			String diaChi, String email, String soDienThoai, float tienTour, TourDuLich tourDuLich, DichVu dichVu) {
		super();
		this.maKhachHang = maKhachHang;
		this.soCCCD_HC = soCCCD_HC;
		this.tenKhachHang = tenKhachHang;
		this.gioiTinh = gioiTinh;
		this.ngaySinh = ngaySinh;
		this.diaChi = diaChi;
		this.email = email;
		this.soDienThoai = soDienThoai;
		this.tienTour = tienTour;
		this.tourDuLich = tourDuLich;
		this.dichVu = dichVu;
	}

	public String getMaKhachHang() {
		return maKhachHang;
	}

	public void setMaKhachHang(String maKhachHang) {
		this.maKhachHang = maKhachHang;
	}

	public String getSoCCCD_HC() {
		return soCCCD_HC;
	}

	public void setSoCCCD_HC(String soCCCD_HC) {
		this.soCCCD_HC = soCCCD_HC;
	}

	public String getTenKhachHang() {
		return tenKhachHang;
	}

	public void setTenKhachHang(String tenKhachHang) {
		this.tenKhachHang = tenKhachHang;
	}

	public boolean getGioiTinh() {
		return gioiTinh;
	}

	public void setGioiTinh(boolean gioiTinh) {
		this.gioiTinh = gioiTinh;
	}

	public Date getNgaySinh() {
		return ngaySinh;
	}

	public void setNgaySinh(Date ngaySinh) {
		this.ngaySinh = ngaySinh;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSoDienThoai() {
		return soDienThoai;
	}

	public void setSoDienThoai(String soDienThoai) {
		this.soDienThoai = soDienThoai;
	}

	public float getTienTour() {
		return tienTour;
	}

	public void setTienTour(float tienTour) {
		this.tienTour = tienTour;
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
	public String toString() {
		return maKhachHang + ";" + soCCCD_HC + ";" + tenKhachHang + ";" + gioiTinh + ";" + ngaySinh + ";" + diaChi + ";"
				+ email + ";" + soDienThoai + ";" + tienTour + ";" + tourDuLich.getMaTour() + ";"
				+ dichVu.getMaDichVu();
	}

	public String getTitle() {
		return "MÃ£ KhÃ¡ch HÃ ng;CCCD/HC;TÃªn KhÃ¡ch HÃ ng;Giá»›i TÃ­nh;NgÃ y Sinh;Ä�á»‹a Chá»‰;Email;Sá»‘ Ä�iá»‡n Thoáº¡i;Tiá»�n Tour;MÃ£ Tour;MÃ£ Dá»‹ch Vá»¥";
	}

}
