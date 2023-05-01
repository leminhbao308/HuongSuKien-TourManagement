/**
 * 
 */
package models;

import java.util.Date;

/**
 * @author LeMinhBao
 *
 */
public class NhanVien {
	private String maNhanVien;
	private String tenNhanVien;
	private boolean gioiTinh;
	private Date ngaySinh;
	private String diaChi;
	private String email;
	private String soDienThoai;

	public NhanVien() {
	}

	public NhanVien(String maNhanVien, String tenNhanVien, boolean gioiTinh, Date ngaySinh, String diaChi, String email,
			String soDienThoai) {
		this.maNhanVien = maNhanVien;
		this.tenNhanVien = tenNhanVien;
		this.gioiTinh = gioiTinh;
		this.ngaySinh = ngaySinh;
		this.diaChi = diaChi;
		this.email = email;
		this.soDienThoai = soDienThoai;
	}

	public String getMaNhanVien() {
		return maNhanVien;
	}

	public void setMaNhanVien(String maNhanVien) {
		this.maNhanVien = maNhanVien;
	}

	public String getTenNhanVien() {
		return tenNhanVien;
	}

	public void setTenNhanVien(String tenNhanVien) {
		this.tenNhanVien = tenNhanVien;
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

	@Override
	public String toString() {
		return maNhanVien + ";" + tenNhanVien + ";" + gioiTinh + ";" + ngaySinh + ";" + diaChi + ";" + email + ";"
				+ soDienThoai;
	}

	public String getTitle() {
		return "Mã Nhân Viên;Tên Nhân Viên;Giới Tính;Ngày Sinh;Địa Chỉ;Email;Số Điện Thoại";
	}

}
