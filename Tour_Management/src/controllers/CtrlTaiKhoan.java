package controllers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import entity.TaiKhoan;

public class CtrlTaiKhoan {
	/**
     * Tìm kiếm tài khoản theo mã
     * @author : 			Pham Nhat Linh
     * @param dsIn       	Danh sách dữ liệu cần lọc
     * @param thongTin 		Thông tin tìm kiếm
     * @return dsOut		ArrayList sau khi lọc
     */
	public static ArrayList<TaiKhoan> locTaiKHoanTheoMaNV(ArrayList<TaiKhoan> dsIn, String maTK) {
		ArrayList<TaiKhoan> dsOut = new ArrayList<TaiKhoan>();
		for(TaiKhoan tk :dsIn) {
			Pattern pa = Pattern.compile(".*" + maTK.toLowerCase() + ".*");
			Matcher ma = pa.matcher(tk.getNhanVien().getMaNhanVien().toLowerCase());
			if(ma.matches()) {
				dsOut.add(tk);
			}
		}
		return dsOut;
	}
	
	/**
     * sắp xếp tài khoản theo mã
     * @author : 			Pham Nhat Linh
     * @param dsIn       	Danh sách dữ liệu cần lọc
     * @param thongTin 		Thông tin tìm kiếm
     * @return dsOut		ArrayList sau khi lọc
     */
	public static ArrayList<TaiKhoan> sapXepTaiKhoanTheoMa(ArrayList<TaiKhoan> dsIn) {
		ArrayList<TaiKhoan> dsOut = new ArrayList<TaiKhoan>();
		dsOut = dsIn;
		Collections.sort(dsOut, new Comparator<TaiKhoan>() {
			@Override
			public int compare(TaiKhoan o1, TaiKhoan o2) {
				// TODO Auto-generated method stub
				return o1.getNhanVien().getMaNhanVien().compareTo(o2.getNhanVien().getMaNhanVien());
			}
		});
		return dsOut;
	}
}
