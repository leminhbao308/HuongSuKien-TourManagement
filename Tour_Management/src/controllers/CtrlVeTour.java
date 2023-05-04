package controllers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import entity.VeTour;

public class CtrlVeTour {
	/**
     * Tìm vé tour với mã 
     * @author : 			Pham Nhat Linh
     * @param dsIn       	Danh sách dữ liệu cần lọc
     * @param thongTin 		Thông tin tìm kiếm
     * @return dsOut		ArrayList sau khi lọc
     */
	public static ArrayList<VeTour> locVeTourTheoMaVe(ArrayList<VeTour> dsIn, String maVT) {
		ArrayList<VeTour> dsOut = new ArrayList<VeTour>();
		for(VeTour vt :dsIn) {
			Pattern pa = Pattern.compile(".*" + maVT.toLowerCase() + ".*");
			Matcher ma = pa.matcher(vt.getMaVe().toLowerCase());
			if(ma.matches()) {
				dsOut.add(vt);
			}
		}
		return dsOut;
	}
	
	/**
     * sắp xếp vé tou theo mã
     * @author : 			Pham Nhat Linh
     * @param dsIn       	Danh sách dữ liệu cần lọc
     * @param thongTin 		Thông tin tìm kiếm
     * @return dsOut		ArrayList sau khi lọc
     */
	public static ArrayList<VeTour> sapXepVeTourTheoMa(ArrayList<VeTour> dsIn) {
		ArrayList<VeTour> dsOut = new ArrayList<VeTour>();
		dsOut = dsIn;
		Collections.sort(dsOut, new Comparator<VeTour>() {
			@Override
			public int compare(VeTour o1, VeTour o2) {
				// TODO Auto-generated method stub
				return o1.getMaVe().compareTo(o2.getMaVe());
			}
		});
		return dsOut;
	}
	
	/**
     * sắp xếp vé tou theo ngày đi
     * @author : 			Pham Nhat Linh
     * @param dsIn       	Danh sách dữ liệu cần lọc
     * @param thongTin 		Thông tin tìm kiếm
     * @return dsOut		ArrayList sau khi lọc
     */
	public static ArrayList<VeTour> sapXepVeTourTheoNgay(ArrayList<VeTour> dsIn) {
		ArrayList<VeTour> dsOut = new ArrayList<VeTour>();
		dsOut = dsIn;
		Collections.sort(dsOut, new Comparator<VeTour>() {
			@Override
			public int compare(VeTour o1, VeTour o2) {
				// TODO Auto-generated method stub
				return o1.getHopDong().getTourDuLich().getNgayDi().compareTo(o2.getHopDong().getTourDuLich().getNgayDi());
			}
		});
		return dsOut;
	}
	
	/**
     * sắp xếp vé tou theo tên khách hàng
     * @author : 			Pham Nhat Linh
     * @param dsIn       	Danh sách dữ liệu cần lọc
     * @param thongTin 		Thông tin tìm kiếm
     * @return dsOut		ArrayList sau khi lọc
     */
	public static ArrayList<VeTour> sapVeTourTheoTenKH(ArrayList<VeTour> dsIn) {
		ArrayList<VeTour> dsOut = new ArrayList<VeTour>();
		dsOut = dsIn;
		Collections.sort(dsOut, new Comparator<VeTour>() {
			@Override
			public int compare(VeTour o1, VeTour o2) {
				// TODO Auto-generated method stub
				return o1.getHopDong().getKhachHang().getTenKhachHang().substring(o1.getHopDong().getKhachHang().getTenKhachHang().lastIndexOf(" ")+1).compareTo(o2.getHopDong().getKhachHang().getTenKhachHang().substring(o2.getHopDong().getKhachHang().getTenKhachHang().lastIndexOf(" ")+1));
			}
		});
		return dsOut;
	}
}
