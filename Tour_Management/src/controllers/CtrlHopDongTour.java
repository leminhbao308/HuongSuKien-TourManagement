package controllers;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import entity.HopDongTour;

public class CtrlHopDongTour {
	/**
     * Tìm kiếm các hợp đồng theo mã hợp đồng 
     * @author : 			Pham Nhat Linh
     * @param dsIn       	Danh sách dữ liệu cần lọc
     * @param thongTin 		Thông tin tìm kiếm
     * @return dsOut		ArrayList sau khi lọc
     */
	public static ArrayList<HopDongTour> locHopDongTheoMa(ArrayList<HopDongTour> dsIn, String maHopDong) {
		ArrayList<HopDongTour> dsOut = new ArrayList<HopDongTour>();
		for(HopDongTour hopDong :dsIn) {
			Pattern pa = Pattern.compile(".*" + maHopDong.toLowerCase() + ".*");
			Matcher ma = pa.matcher(hopDong.getMaHopDong().toLowerCase());
			if(ma.matches()) {
				dsOut.add(hopDong);
			}
		}
		return dsOut;
	}
	/**
     * Tìm kiếm các hợp đồng có thông tin liên quan 
     * @author : 			Pham Nhat Linh
     * @param dsIn       	Danh sách dữ liệu cần lọc
     * @param thongTin 		Thông tin tìm kiếm
     * @return dsOut		ArrayList sau khi lọc
     */
	public static ArrayList<HopDongTour> locTourTheoThongTinHopDong(ArrayList<HopDongTour> dsIn, String thongTin) {
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
	public static ArrayList<HopDongTour> locHopDongTheoNgayLap(ArrayList<HopDongTour> dsIn, LocalDate ngayLap) {
		ArrayList<HopDongTour> dsOut = new ArrayList<HopDongTour>();
		for(HopDongTour hopDong :dsIn) {
			if(ngayLap.equals(hopDong.getThoiGianLap())) {
				dsOut.add(hopDong);
			}
		}
		return dsOut;
	}
	
	/**
     * Tìm kiếm các hợp đồng theo thông tin khách hàng 
     * @author : 			Pham Nhat Linh
     * @param dsIn       	Danh sách dữ liệu cần lọc
     * @param thongTin 		Thông tin tìm kiếm
     * @return dsOut		ArrayList sau khi lọc
     */
	public static ArrayList<HopDongTour> locHopDongTheoKH(ArrayList<HopDongTour> dsIn, String tenKH) {
		ArrayList<HopDongTour> dsOut = new ArrayList<HopDongTour>();
		for(HopDongTour hopDong :dsIn) {
			Pattern pa = Pattern.compile(".*" + tenKH.toLowerCase() + ".*");
			Matcher ma = pa.matcher(hopDong.getKhachHang().toString().toLowerCase());
			if(ma.matches()) {
				dsOut.add(hopDong);
			}
		}
		return dsOut;
	}
	
	/**
     * Tìm kiếm các hợp đồng theo thông tin nhân viên lập hợp đồng 
     * @author : 			Pham Nhat Linh
     * @param dsIn       	Danh sách dữ liệu cần lọc
     * @param thongTin 		Thông tin tìm kiếm
     * @return dsOut		ArrayList sau khi lọc
     */
	public static ArrayList<HopDongTour> locHopDongTheoNV(ArrayList<HopDongTour> dsIn, String tenNV) {
		ArrayList<HopDongTour> dsOut = new ArrayList<HopDongTour>();
		for(HopDongTour hopDong :dsIn) {
			Pattern pa = Pattern.compile(".*" + tenNV.toLowerCase() + ".*");
			Matcher ma = pa.matcher(hopDong.getNhanVien().toString().toLowerCase());
			if(ma.matches()) {
				dsOut.add(hopDong);
			}
		}
		return dsOut;
	}
	
	/**
     * Sắp xếp hợp đồng theo tổng tiền tăng
     * @author : 			Pham Nhat Linh
     * @param dsIn       	Danh sách dữ liệu cần lọc
     * @param thongTin 		Thông tin tìm kiếm
     * @return dsOut		ArrayList sau khi lọc
     */
	public static ArrayList<HopDongTour> sapXepHopDongTongTienTang(ArrayList<HopDongTour> dsIn) {
		ArrayList<HopDongTour> dsOut = new ArrayList<HopDongTour>();
		dsOut = dsIn;
		Collections.sort(dsOut, new Comparator<HopDongTour>() {
			@Override
			public int compare(HopDongTour o1, HopDongTour o2) {
				// TODO Auto-generated method stub
				return Float.compare(o1.getTongTien(), o2.getTongTien());
			}
		});
		return dsOut;
	}
	
	/**
     * Sắp xếp hợp đồng theo tổng tiền giảm
     * @author : 			Pham Nhat Linh
     * @param dsIn       	Danh sách dữ liệu cần lọc
     * @param thongTin 		Thông tin tìm kiếm
     * @return dsOut		ArrayList sau khi lọc
     */
	public static ArrayList<HopDongTour> sapXepHopDongTongTienGiam(ArrayList<HopDongTour> dsIn) {
		ArrayList<HopDongTour> dsOut = new ArrayList<HopDongTour>();
		dsOut = dsIn;
		Collections.sort(dsOut, new Comparator<HopDongTour>() {
			@Override
			public int compare(HopDongTour o1, HopDongTour o2) {
				// TODO Auto-generated method stub
				return Float.compare(o2.getTongTien(), o1.getTongTien());
			}
		});
		return dsOut;
	}
	
	/**
     * Sắp xếp hợp đồng theo ngày lập
     * @author : 			Pham Nhat Linh
     * @param dsIn       	Danh sách dữ liệu cần lọc
     * @param thongTin 		Thông tin tìm kiếm
     * @return dsOut		ArrayList sau khi lọc
     */
	public static ArrayList<HopDongTour> sapXepHopDongTheoNgay(ArrayList<HopDongTour> dsIn) {
		ArrayList<HopDongTour> dsOut = new ArrayList<HopDongTour>();
		dsOut = dsIn;
		Collections.sort(dsOut, new Comparator<HopDongTour>() {
			@Override
			public int compare(HopDongTour o1, HopDongTour o2) {
				// TODO Auto-generated method stub
				return o1.getThoiGianLap().compareTo(o2.getThoiGianLap());
			}
		});
		return dsOut;
	}
	
	/**
     * Sắp xếp hợp đồng theo mã 
     * @author : 			Pham Nhat Linh
     * @param dsIn       	Danh sách dữ liệu cần lọc
     * @param thongTin 		Thông tin tìm kiếm
     * @return dsOut		ArrayList sau khi lọc
     */
	public static ArrayList<HopDongTour> sapXepHopDongTheoMa(ArrayList<HopDongTour> dsIn) {
		ArrayList<HopDongTour> dsOut = new ArrayList<HopDongTour>();
		dsOut = dsIn;
		Collections.sort(dsOut, new Comparator<HopDongTour>() {
			@Override
			public int compare(HopDongTour o1, HopDongTour o2) {
				// TODO Auto-generated method stub
				return o1.getMaHopDong().compareTo(o2.getMaHopDong());
			}
		});
		return dsOut;
	}
}
