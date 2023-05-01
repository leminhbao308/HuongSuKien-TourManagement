package entity;

public class TaiKhoan {
	private String maTaiKhoan;
	private String maDangNhap;
	private String matKhau;
	private NhanVien nhanVien;

	public TaiKhoan() {
	}

	public TaiKhoan(String maTaiKhoan, String maDangNhap, String matKhau, NhanVien nhanVien) {
		super();
		this.maTaiKhoan = maTaiKhoan;
		this.maDangNhap = maDangNhap;
		this.matKhau = matKhau;
		this.nhanVien = nhanVien;
	}

	public String getMaTaiKhoan() {
		return maTaiKhoan;
	}

	public void setMaTaiKhoan(String maTaiKhoan) {
		this.maTaiKhoan = maTaiKhoan;
	}

	public String getMaDangNhap() {
		return maDangNhap;
	}

	public void setMaDangNhap(String taiKhoan) {
		this.maDangNhap = taiKhoan;
	}

	public String getMatKhau() {
		return matKhau;
	}

	public void setMatKhau(String matKhau) {
		this.matKhau = matKhau;
	}

	public NhanVien getNhanVien() {
		return nhanVien;
	}

	public void setNhanVien(NhanVien nhanVien) {
		this.nhanVien = nhanVien;
	}

	@Override
	public String toString() {
		return maTaiKhoan + ";" + maDangNhap + ";" + matKhau + ";" + nhanVien.getMaNhanVien();
	}

	public String getTitle() {
		return "Mã Tài Khoản;Tài Khoản;Mật Khẩu;Mã Nhân Viên";
	}

}
