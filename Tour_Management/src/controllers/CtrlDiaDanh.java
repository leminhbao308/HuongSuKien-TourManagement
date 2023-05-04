package controllers;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import entity.DiaDanh;

public class CtrlDiaDanh {
	/**
     * Tìm kiếm địa danh theo mã địa danh cần tìm
     * @author : 			Pham Nhat Linh
     * @param dsIn       	Danh sách dữ liệu cần lọc
     * @param thongTin 		Thông tin tìm kiếm
     * @return dsOut		ArrayList sau khi lọc
     */
	public static ArrayList<DiaDanh> loTheoMaDiaDanh(ArrayList<DiaDanh> dsIn, String maDiaDanh) {
		ArrayList<DiaDanh> dsOut = new ArrayList<DiaDanh>();
		for(DiaDanh diaDanh :dsIn) {
			Pattern pa = Pattern.compile(".*" + maDiaDanh.toLowerCase() + ".*");
			Matcher ma = pa.matcher(diaDanh.getMaDiaDanh().toLowerCase());
			if(ma.matches()) {
				dsOut.add(diaDanh);
			}
		}
		return dsOut;
	}
	
	/**
     * Lọc địa danh theo tên địa danh 
     * @author : 			Pham Nhat Linh
     * @param dsIn       	Danh sách dữ liệu cần lọc
     * @param thongTin 		Thông tin tìm kiếm
     * @return dsOut		ArrayList sau khi lọc
     */
	public static ArrayList<DiaDanh> locDiaDanhTheoTen(ArrayList<DiaDanh> dsIn, String ten) {
		ArrayList<DiaDanh> dsOut = new ArrayList<DiaDanh>();
		for(DiaDanh diaDanh :dsIn) {
			Pattern pa = Pattern.compile(".*" + ten.toLowerCase() + ".*");
			Matcher t = pa.matcher(diaDanh.toString().toLowerCase());
			if(t.matches()) {
				dsOut.add(diaDanh);
			}
		}
		return dsOut;
	}
	
	/**
     * Lọc địa danh theo tên địa danh hoặc tỉnh thành
     * @author : 			Pham Nhat Linh
     * @param dsIn       	Danh sách dữ liệu cần lọc
     * @param thongTin 		Thông tin tìm kiếm
     * @return dsOut		ArrayList sau khi lọc
     */
	public static ArrayList<DiaDanh> locDiaDanhTheoTinhThanh(ArrayList<DiaDanh> dsIn, String tinhThanh) {
		ArrayList<DiaDanh> dsOut = new ArrayList<DiaDanh>();
		for(DiaDanh diaDanh :dsIn) {
			Pattern pa = Pattern.compile(".*" + tinhThanh.toLowerCase() + ".*");
			Matcher t = pa.matcher(diaDanh.getTinhThanh().toLowerCase());
			if(t.matches()) {
				dsOut.add(diaDanh);
			}
		}
		return dsOut;
	}
}
