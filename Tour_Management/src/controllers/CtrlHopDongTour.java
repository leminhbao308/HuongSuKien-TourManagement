package controllers;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import entity.HopDongTour;
import entity.HopDongTour;

public class CtrlHopDongTour {
	/**
     * Tìm kiếm các hợp đồng có thông tin liên quan với thông tin 
     * @author : 			Pham Nhat Linh
     * @param dsIn       	Danh sách dữ liệu cần lọc
     * @param thongTin 		Thông tin tìm kiếm
     * @return dsOut		ArrayList sau khi lọc
     */
	public static ArrayList<HopDongTour> locTourTheoThongTinTour(ArrayList<HopDongTour> dsIn, String thongTin) {
		ArrayList<HopDongTour> dsOut = new ArrayList<HopDongTour>();
		for(HopDongTour hopDong :dsIn) {
			Pattern pa = Pattern.compile(".*" + thongTin.toLowerCase() + ".*");
			Matcher ma = pa.matcher(hopDong.toString().toLowerCase());
			if(ma.matches()) {
				dsOut.add(hopDong);
			}
		}
		return dsOut;
	}
	
	/**
     * Lọc hop dong tour theo ngày lap hop dong
     * @author : 			Pham Nhat Linh
     * @param dsIn       	Danh sách dữ liệu cần lọc
     * @param ngayDai      	LocalDate ngày lập họp đồng
     * @return dsOut		ArrayList sau khi lọc
     */
	public static ArrayList<HopDongTour> locTourTheoNgayDi(ArrayList<HopDongTour> dsIn, LocalDate ngayDi) {
		ArrayList<HopDongTour> dsOut = new ArrayList<HopDongTour>();
		for(HopDongTour hopDong :dsIn) {
			if(ngayDi.equals(hopDong.getThoiGianLap())) {
				dsOut.add(hopDong);
			}
		}
		return dsOut;
	}
}
