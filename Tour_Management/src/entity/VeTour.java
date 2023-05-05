package entity;

import java.util.Objects;

/**
 * 
 * @author LE HOANG NAM
 *
 */
public class VeTour {
	private String maVe;
	private HopDongTour hopDong;

	public VeTour(String maVe, HopDongTour hopDong) {
		super();
		this.maVe = maVe;
		this.hopDong = hopDong;
	}

	public VeTour(String maVe) {
		super();
		this.maVe = maVe;
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

	public HopDongTour getHopDong() {
		return hopDong;
	}

	public void setHopDong(HopDongTour hopDong) {
		this.hopDong = hopDong;
	}

	@Override
	public int hashCode() {
		return Objects.hash(maVe);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		VeTour other = (VeTour) obj;
		return Objects.equals(maVe, other.maVe);
	}

	@Override
	public String toString() {
		return maVe + ";" + hopDong.getKhachHang().getTenKhachHang() + ";" + hopDong.getTourDuLich().getTenTour() + ";"
				+ hopDong.getTourDuLich().getNgayDi();
	}

	public String getTitle() {
		return "Mã Vé;Tên Khách Hàng;Tên Tour;Ngày Đi";
	}

}
