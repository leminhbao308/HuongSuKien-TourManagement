package main.java.com.se_tourist.models;

public class DichVu {
    private String maDichVu;
    private String phuongTienDiChuyen;
    private String chiTietDichVu;
    private float giaDichVu;

    public DichVu() {
    }

    public DichVu(String maDichVu, String phuongTienDiChuyen, String chiTietDichVu, float giaDichVu) {
	this.maDichVu = maDichVu;
	this.phuongTienDiChuyen = phuongTienDiChuyen;
	this.chiTietDichVu = chiTietDichVu;
	this.giaDichVu = giaDichVu;
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

    @Override
    public String toString() {
	return maDichVu + ";" + phuongTienDiChuyen + ";" + chiTietDichVu + ";" + giaDichVu;
    }

    public String getTitle() {
	return "Mã Dịch Vụ;Phương Tiện Di Chuyển;Chi Tiết Dịch Vụ;Giá Dịch Vụ";
    }
}
