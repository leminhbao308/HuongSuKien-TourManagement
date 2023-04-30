package models;

public class VeTour {
	private String maVe;
	private KhachHang khachHang;

	public VeTour(String maVe, KhachHang khachHang) {
		this.maVe = maVe;
		this.khachHang = khachHang;
	}

	public VeTour() {
		// TODO Auto-generated constructor stub
	}

	public String getMaVe() {
		return maVe;
	}

	public void setMaVe(String maVe) {
		this.maVe = maVe;
	}

	public KhachHang getKhachHang() {
		return khachHang;
	}

	public void setKhachHang(KhachHang khachHang) {
		this.khachHang = khachHang;
	}

	@Override
	public String toString() {
		return maVe + ";" + khachHang.getMaKhachHang();
	}

	public String getTitle() {
		return "Mã Vé;Mã Khách Hàng";
	}

}
