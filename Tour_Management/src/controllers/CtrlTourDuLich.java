package controllers;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import DAO.DAO_TourDuLich;
import entity.TourDuLich;

public class CtrlTourDuLich {
	/**
     * Tìm kiếm các tour có thông tin liên quan với thông tin nhập vào theo thông tin liên quan
     * @author : 			Pham Nhat Linh
     * @param dsIn       	Danh sách dữ liệu cần lọc
     * @param thongTin 		Thông tin tìm kiếm
     * @return dsOut		ArrayList sau khi lọc
     */
	public static ArrayList<TourDuLich> locTourTheoThongTinTour(ArrayList<TourDuLich> dsIn, String thongTin) {
		ArrayList<TourDuLich> dsOut = new ArrayList<TourDuLich>();
		for(TourDuLich tour :dsIn) {
			Pattern pa = Pattern.compile(".*" + thongTin.toLowerCase() + ".*");
			Matcher ma = pa.matcher(tour.toString().toLowerCase());
			if(ma.matches()) {
				dsOut.add(tour);
			}
		}
		return dsOut;
	}
	
	/**
     * Lọc Tour theo tên tour hoặc mô tả, dùng cho lọc 
     * @author : 			Pham Nhat Linh
     * @param dsIn       	Danh sách dữ liệu cần lọc
     * @param thongTin 		Thông tin tìm kiếm
     * @return dsOut		ArrayList sau khi lọc
     */
	public static ArrayList<TourDuLich> locTourTheoTenTour(ArrayList<TourDuLich> dsIn, String tenTimKiem) {
		ArrayList<TourDuLich> dsOut = new ArrayList<TourDuLich>();
		for(TourDuLich tour :dsIn) {
			Pattern pa = Pattern.compile(".*" + tenTimKiem.toLowerCase() + ".*");
			Matcher t = pa.matcher(tour.getTenTour().toLowerCase()+ " " + tour.getMoTa().toLowerCase());
			if(t.matches()) {
				dsOut.add(tour);
			}
		}
		return dsOut;
	}
	
	public static ArrayList<TourDuLich> locTourTheoTinhThanh(ArrayList<TourDuLich> dsIn, String tinhThanh) {
		ArrayList<TourDuLich> dsOut = new ArrayList<TourDuLich>();
		for(TourDuLich tour :dsIn) {
			Pattern pa = Pattern.compile(".*" + tinhThanh.toLowerCase() + ".*");
			Matcher t = pa.matcher(tour.getDiaDanh().getTinhThanh().toLowerCase());
			if(t.matches()) {
				dsOut.add(tour);
			}
		}
		return dsOut;
	}
	
	public static ArrayList<TourDuLich> locTourTheoDiaDanh(ArrayList<TourDuLich> dsIn, String diaDanh) {
		ArrayList<TourDuLich> dsOut = new ArrayList<TourDuLich>();
		for(TourDuLich tour :dsIn) {
			Pattern pa = Pattern.compile(".*" + diaDanh.toLowerCase() + ".*");
			Matcher t = pa.matcher(tour.getDiaDanh().getTenDiaDanh() .toLowerCase());
			if(t.matches()) {
				dsOut.add(tour);
			}
		}
		return dsOut;
	}
	
	public static ArrayList<TourDuLich> locTourTheoNgayDi(ArrayList<TourDuLich> dsIn, LocalDate ngayDi) {
		ArrayList<TourDuLich> dsOut = new ArrayList<TourDuLich>();
		for(TourDuLich tour :dsIn) {
			if(ngayDi.equals(tour.getNgayDi())) {
				dsOut.add(tour);
			}
		}
		return dsOut;
	}
	
	public static ArrayList<TourDuLich> locTourDangMo(ArrayList<TourDuLich> dsIn) {
		ArrayList<TourDuLich> dsOut = new ArrayList<TourDuLich>();
		for(TourDuLich tour :dsIn) {
			if(tour.getTrangThaiTour()) {
				dsOut.add(tour);
			}
		}
		return dsOut;
	}
	
	public static ArrayList<TourDuLich> locTourDaDong(ArrayList<TourDuLich> dsIn) {
		ArrayList<TourDuLich> dsOut = new ArrayList<TourDuLich>();
		for(TourDuLich tour :dsIn) {
			if(!tour.getTrangThaiTour()) {
				dsOut.add(tour);
			}
		}
		return dsOut;
	}
	
	public static void main(String[] args) {
		// test lọc tour => ok
		System.out.println("----------------------");
		ArrayList<TourDuLich> ds = new ArrayList<TourDuLich>();
		ds = DAO_TourDuLich.getAllTourDuLich();
		for (TourDuLich t: ds ) {
			System.out.println(t.toString());
		}
		System.out.println("----------------------");
		ArrayList<TourDuLich> dsr = new ArrayList<TourDuLich>();
		//dsr = locTourTongHopTheoChuoi(ds, "Hội An");
		//dsr = locTourTheoTenTour(ds, "Tour Phú Quốc");
		//dsr = locTourTheoDiaDanh(ds, " rồng");
		//dsr = locTourTheoNgayDi(ds, LocalDate.of(2023, 6, 8));
		//dsr = locTourDangMo(ds);
		for (TourDuLich t: dsr) {
			System.out.println(t.toString());
		}
		System.out.println("----------------------");
	}
}
