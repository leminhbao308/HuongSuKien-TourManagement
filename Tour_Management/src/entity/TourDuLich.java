package entity;

import java.util.Date;

public class TourDuLich {
	private String maTour;
	private String tenTour;
	private String moTa;
	private Date ngayDi;
	private String noiDi;
	private int soNgayDuKien;
	private float giaTour;
	private boolean trangThaiTour;
	private DiaDanh diaDanh;

	public TourDuLich(String maTour, String tenTour, String moTa, Date ngayDi, String noiDi, int soNgayDuKien,
			float giaTour, boolean trangThaiTour, DiaDanh diaDanh) {
		super();
		this.maTour = maTour;
		this.tenTour = tenTour;
		this.moTa = moTa;
		this.ngayDi = ngayDi;
		this.noiDi = noiDi;
		this.soNgayDuKien = soNgayDuKien;
		this.giaTour = giaTour;
		this.trangThaiTour = trangThaiTour;
		this.diaDanh = diaDanh;
	}

	public TourDuLich() {
		// TODO Auto-generated constructor stub
	}

	public String getMaTour() {
		return maTour;
	}

	public void setMaTour(String maTour) {
		this.maTour = maTour;
	}

	public String getTenTour() {
		return tenTour;
	}

	public void setTenTour(String tenTour) {
		this.tenTour = tenTour;
	}

	public String getMoTa() {
		return moTa;
	}

	public void setMoTa(String moTa) {
		this.moTa = moTa;
	}

	public Date getNgayDi() {
		return ngayDi;
	}

	public void setNgayDi(Date ngayDi) {
		this.ngayDi = ngayDi;
	}

	public String getNoiDi() {
		return noiDi;
	}

	public void setNoiDi(String noiDi) {
		this.noiDi = noiDi;
	}

	public int getSoNgayDuKien() {
		return soNgayDuKien;
	}

	public void setSoNgayDuKien(int soNgayDuKien) {
		this.soNgayDuKien = soNgayDuKien;
	}

	public float getGiaTour() {
		return giaTour;
	}

	public void setGiaTour(float giaTour) {
		this.giaTour = giaTour;
	}

	public boolean getTrangThaiTour() {
		return trangThaiTour;
	}

	public void setTrangThaiTour(boolean trangThaiTour) {
		this.trangThaiTour = trangThaiTour;
	}

	public DiaDanh getDiaDanh() {
		return diaDanh;
	}

	public void setDiaDanh(DiaDanh diaDanh) {
		this.diaDanh = diaDanh;
	}

	@Override
	public String toString() {
		return maTour + ";" + tenTour + ";" + moTa + ";" + ngayDi + ";" + noiDi + ";" + soNgayDuKien + ";" + giaTour
				+ ";" + trangThaiTour + ";" + diaDanh.getMaDiaDanh();
	}

	public String getTitle() {
		return "Mã Tour;Tên Tour;Mô Tả;Ngày �?i;Nơi �?i;Số Ngày Dự Kiến;Giá Tour;Trạng Thái Tour;Mã �?ịa Danh";
	}
}
