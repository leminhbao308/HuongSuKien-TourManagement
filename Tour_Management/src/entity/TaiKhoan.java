package entity;

import java.util.Objects;

public class TaiKhoan {
    private NhanVien nhanVien;
    private String matKhau;

    public TaiKhoan(NhanVien nhanVien, String matKhau) {
	super();
	this.nhanVien = nhanVien;
	this.matKhau = matKhau;
    }

    public TaiKhoan(NhanVien nhanVien) {
	super();
	this.nhanVien = nhanVien;
    }

    public TaiKhoan() {
	// TODO Auto-generated constructor stub
    }

    public NhanVien getNhanVien() {
	return nhanVien;
    }

    public void setNhanVien(NhanVien nhanVien) {
	this.nhanVien = nhanVien;
    }

    public String getMatKhau() {
	return matKhau;
    }

    public void setMatKhau(String matKhau) {
	this.matKhau = matKhau;
    }

    @Override
    public int hashCode() {
	return Objects.hash(nhanVien);
    }

    @Override
    public String toString() {
	return nhanVien.getMaNhanVien() + ";" + matKhau + ";";
    }

    @Override
    public boolean equals(Object obj) {
	if (this == obj)
	    return true;
	if (obj == null)
	    return false;
	if (getClass() != obj.getClass())
	    return false;
	TaiKhoan other = (TaiKhoan) obj;
	return Objects.equals(nhanVien, other.nhanVien);
    }

    public String getTitle() {
	return "Mã Nhân Viên;Mật Khẩu;";
    }

}
