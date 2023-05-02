package entity;

import java.time.LocalDate;
import java.util.Objects;

/**
 * @author Pham Nhat Linh
 *
 */
public class NhanVien {
	private String maNhanVien;
	private String tenNhanVien;
	private boolean gioiTinh;
	private LocalDate ngaySinh;
	private String diaChi;
	private String email;
	private String soDienThoai;
	private String chucVu;

	public NhanVien(String maNhanVien, String tenNhanVien, boolean gioiTinh, LocalDate ngaySinh, String diaChi,
			String email, String soDienThoai, String chucVu) {
		super();
		this.maNhanVien = maNhanVien;
		this.tenNhanVien = tenNhanVien;
		this.gioiTinh = gioiTinh;
		this.ngaySinh = ngaySinh;
		this.diaChi = diaChi;
		this.email = email;
		this.soDienThoai = soDienThoai;
		this.chucVu = chucVu;
	}

	public NhanVien() {
		super();
		// TODO Auto-generated constructor stub
	}

	public NhanVien(String maNhanVien) {
		super();
		this.maNhanVien = maNhanVien;
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

	public String getChucVu() {
		return chucVu;
	}

	public void setChucVu(String chucVu) {
		this.chucVu = chucVu;
	}

	@Override
	public int hashCode() {
		return Objects.hash(maNhanVien);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		NhanVien other = (NhanVien) obj;
		return Objects.equals(maNhanVien, other.maNhanVien);
	}

	@Override
	public String toString() {
		return maNhanVien + ";" + tenNhanVien + ";" + gioiTinh + ";" + ngaySinh + ";" + diaChi + ";" + email + ";"
				+ soDienThoai + ";" + chucVu + ";" ;
	}

	public String getTitle() {
		return "Mã Nhân Viên;Tên Nhân Viên;Giới Tính;Ngày Sinh;Địa Chỉ;Email;Số Điện Thoại;Chức Vụ";
	}

}
