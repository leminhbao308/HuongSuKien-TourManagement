package controllers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import entity.KhachHang;

public class CtrlKHachHang {
	/**
     * Tìm kiếm Khách hàng theo mã
     * @author : 			Pham Nhat Linh
     * @param dsIn       	Danh sách dữ liệu cần lọc
     * @param thongTin 		Thông tin tìm kiếm
     * @return dsOut		ArrayList sau khi lọc
     */
	public static ArrayList<KhachHang> locKhachHangTheoMa(ArrayList<KhachHang> dsIn, String maKH) {
		ArrayList<KhachHang> dsOut = new ArrayList<KhachHang>();
		for(KhachHang k :dsIn) {
			Pattern pa = Pattern.compile(".*" + maKH.toLowerCase() + ".*");
			Matcher ma = pa.matcher(k.getMaKhachHang().toLowerCase());
			if(ma.matches()) {
				dsOut.add(k);
			}
		}
		return dsOut;
	}
	
	/**
     * Tìm khách hàng theo số cccd, hộ chiếu
     * @author : 			Pham Nhat Linh
     * @param dsIn       	Danh sách dữ liệu cần lọc
     * @param thongTin 		Thông tin tìm kiếm
     * @return dsOut		ArrayList sau khi lọc
     */
	public static ArrayList<KhachHang> timKhachHangTheoCCCD_HC(ArrayList<KhachHang> dsIn, String cc_hc) {
		ArrayList<KhachHang> dsOut = new ArrayList<KhachHang>();
		for(KhachHang k :dsIn) {
			if(k.getSoCCCD_HC().equals(cc_hc.trim())) {
				dsOut.add(k);
			}
		}
		return dsOut;
	}
	
	/**
     * Sắp xếp khách hàng theo tên
     * @author : 			Pham Nhat Linh
     * @param dsIn       	Danh sách dữ liệu cần lọc
     * @param thongTin 		Thông tin tìm kiếm
     * @return dsOut		ArrayList sau khi lọc
     */
	public static ArrayList<KhachHang> sapXepKhachHangTheoTen(ArrayList<KhachHang> dsIn) {
		ArrayList<KhachHang> dsOut = new ArrayList<KhachHang>();
		dsOut = dsIn;
		Collections.sort(dsOut, new Comparator<KhachHang>() {
			@Override
			public int compare(KhachHang o1, KhachHang o2) {
				// TODO Auto-generated method stub
				return o1.getTenKhachHang().substring(o1.getTenKhachHang().lastIndexOf(" ")+1).compareTo(o2.getTenKhachHang().substring(o2.getTenKhachHang().lastIndexOf(" ")+1));
			}
		});
		return dsOut;
	}
	
	/**
     * Sắp xếp khách hàng theo mã
     * @author : 			Pham Nhat Linh
     * @param dsIn       	Danh sách dữ liệu cần lọc
     * @param thongTin 		Thông tin tìm kiếm
     * @return dsOut		ArrayList sau khi lọc
     */
	public static ArrayList<KhachHang> sapXepKhachHangTheoMa(ArrayList<KhachHang> dsIn) {
		ArrayList<KhachHang> dsOut = new ArrayList<KhachHang>();
		dsOut = dsIn;
		Collections.sort(dsOut, new Comparator<KhachHang>() {
			@Override
			public int compare(KhachHang o1, KhachHang o2) {
				// TODO Auto-generated method stub
				return o1.getMaKhachHang().compareTo(o2.getMaKhachHang());
			}
		});
		return dsOut;
	}
}
