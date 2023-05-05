package entity;

import java.util.Objects;

/**
 * 
 * @author LE HOANG NAM
 *
 */
public class DichVu {
	private String maDichVu;
	private String phuongTienDiChuyen;
	private String chiTietDichVu;
	private float giaDichVu;

	public DichVu(String maDichVu, String phuongTienDiChuyen, String chiTietDichVu, float giaDichVu) {
		super();
		this.maDichVu = maDichVu;
		this.phuongTienDiChuyen = phuongTienDiChuyen;
		this.chiTietDichVu = chiTietDichVu;
		this.giaDichVu = giaDichVu;
	}

	public DichVu(String maDichVu) {
		super();
		this.maDichVu = maDichVu;
	}

	public String getMaDichVu() {
		return maDichVu;
	}

	public void setMaDichVu(String maDichVu) {
		this.maDichVu = maDichVu;
	}

	public String getPhuongTienDiChuyen() {
		return phuongTienDiChuyen;
	}

	public void setPhuongTienDiChuyen(String phuongTienDiChuyen) {
		this.phuongTienDiChuyen = phuongTienDiChuyen;
	}

	public String getChiTietDichVu() {
		return chiTietDichVu;
	}

	public void setChiTietDichVu(String chiTietDichVu) {
		this.chiTietDichVu = chiTietDichVu;
	}

	public float getGiaDichVu() {
		return giaDichVu;
	}

	public void setGiaDichVu(float giaDichVu) {
		this.giaDichVu = giaDichVu;
	}

	public DichVu() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DichVu other = (DichVu) obj;
		return Objects.equals(maDichVu, other.maDichVu);
	}

	@Override
	public String toString() {
		return maDichVu + ";" + phuongTienDiChuyen + ";" + chiTietDichVu + ";" + giaDichVu;
	}

	public String getTitle() {
		return "Mã Dịch Vụ;Phương Tiện Di Chuyển;Chi Tiết Dịch Vụ;Giá Dịch Vụ";
	}
}
