package entity;

import java.time.LocalDate;
import java.util.Objects;

public class KhachHang {
	private String maKhachHang;
	private String soCCCD_HC;
	private String tenKhachHang;
	private boolean gioiTinh;
	private LocalDate ngaySinh;
	private String email;
	private String soDienThoai;

	public KhachHang(String maKhachHang, String soCCCD_HC, String tenKhachHang, boolean gioiTinh, LocalDate ngaySinh,
			String email, String soDienThoai) {
		super();
		this.maKhachHang = maKhachHang;
		this.soCCCD_HC = soCCCD_HC;
		this.tenKhachHang = tenKhachHang;
		this.gioiTinh = gioiTinh;
		this.ngaySinh = ngaySinh;
		this.email = email;
		this.soDienThoai = soDienThoai;
	}

	public KhachHang(String maKhachHang) {
		super();
		this.maKhachHang = maKhachHang;
	}

	public KhachHang() {
		super();
		// TODO Auto-generated constructor stub
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

	public boolean isGioiTinh() {
		return gioiTinh;
	}

	public void setGioiTinh(boolean gioiTinh) {
		this.gioiTinh = gioiTinh;
	}

	public LocalDate getNgaySinh() {
		return ngaySinh;
	}

	public void setNgaySinh(LocalDate ngaySinh) {
		this.ngaySinh = ngaySinh;
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

	@Override
	public int hashCode() {
		return Objects.hash(maKhachHang);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		KhachHang other = (KhachHang) obj;
		return Objects.equals(maKhachHang, other.maKhachHang);
	}

	@Override
	public String toString() {
		return maKhachHang + ";" + soCCCD_HC + ";" + tenKhachHang+ ";" + gioiTinh + ";" + ngaySinh + ";" + email + ";"
				+ soDienThoai + ";";
	}

	public String getTitle() {
		return "Mã Khách Hàng;CCCD/HC;Tên Khách Hàng;Giới Tính;Ngày Sinh;Email;Số Điện Thoại";
	}

}
