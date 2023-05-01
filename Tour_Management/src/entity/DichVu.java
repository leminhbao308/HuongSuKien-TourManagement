package entity;

import java.util.Objects;

public class DichVu {
	private String maDichVu;
	private String phuongTienDiChuyen;
	private float giaDichVu;

	public DichVu(String maDichVu, String phuongTienDiChuyen, float giaDichVu) {
		super();
		this.maDichVu = maDichVu;
		this.phuongTienDiChuyen = phuongTienDiChuyen;
		this.giaDichVu = giaDichVu;
	}

	public DichVu(String maDichVu) {
		super();
		this.maDichVu = maDichVu;
	}

	public DichVu() {
		super();
		// TODO Auto-generated constructor stub
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

	public float getGiaDichVu() {
		return giaDichVu;
	}

	public void setGiaDichVu(float giaDichVu) {
		this.giaDichVu = giaDichVu;
	}

	@Override
	public int hashCode() {
		return Objects.hash(maDichVu);
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
		return maDichVu + ";" + phuongTienDiChuyen + ";" + giaDichVu + ";";
	}

	public String getTitle() {
		return "Mã Dịch Vụ;Phương Tiện Di Chuyển;Giá Dịch Vụ";
	}
}
