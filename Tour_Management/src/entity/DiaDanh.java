package entity;

public class DiaDanh {
	private String maDiaDanh;
	private String tenDiaDanh;
	private String tinhThanh;

	public DiaDanh() {
	}

	public DiaDanh(String maDiaDanh, String tenDiaDanh, String tinhThanh) {
		this.maDiaDanh = maDiaDanh;
		this.tenDiaDanh = tenDiaDanh;
		this.tinhThanh = tinhThanh;
	}

	public String getMaDiaDanh() {
		return maDiaDanh;
	}

	public void setMaDiaDanh(String maDiaDanh) {
		this.maDiaDanh = maDiaDanh;
	}

	public String getTenDiaDanh() {
		return tenDiaDanh;
	}

	public void setTenDiaDanh(String tenDiaDanh) {
		this.tenDiaDanh = tenDiaDanh;
	}

	public String getTinhThanh() {
		return tinhThanh;
	}

	public void setTinhThanh(String tinhThanh) {
		this.tinhThanh = tinhThanh;
	}

	@Override
	public String toString() {
		return maDiaDanh + ";" + tenDiaDanh + ";" + tinhThanh;
	}

	public String getTitle() {
		return "Mã �?ịa Danh;Tên �?ịa Danh;Tỉnh Thành";
	}
}
