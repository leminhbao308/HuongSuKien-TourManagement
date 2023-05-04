package controllers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import DAO.DAO_NhanVien;
import entity.NhanVien;

public class CtrlNhanVien {
		/**
	     * Tìm kiếm Nhân viên theo mã nhân viên
	     * @author : 			Pham Nhat Linh
	     * @param dsIn       	Danh sách dữ liệu cần lọc
	     * @param thongTin 		Thông tin tìm kiếm
	     * @return dsOut		ArrayList sau khi lọc
	     */
		public static ArrayList<NhanVien> locNhanVienTheoMa(ArrayList<NhanVien> dsIn, String maNv) {
			ArrayList<NhanVien> dsOut = new ArrayList<NhanVien>();
			for(NhanVien nv :dsIn) {
				Pattern pa = Pattern.compile(".*" + maNv.toLowerCase() + ".*");
				Matcher ma = pa.matcher(nv.getMaNhanVien().toLowerCase());
				if(ma.matches()) {
					dsOut.add(nv);
				}
			}
			return dsOut;
		}
		
		/**
	     * Lọc Nhân viên theo bất kì thông tin gì được truyền vào liên qua tới nhân viên đó
	     * @author : 			Pham Nhat Linh
	     * @param dsIn       	Danh sách dữ liệu cần lọc
	     * @param thongTin 		Thông tin tìm kiếm
	     * @return dsOut		ArrayList sau khi lọc
	     */
		public static ArrayList<NhanVien> locNhanVienTheoThongTin(ArrayList<NhanVien> dsIn, String thongTin) {
			ArrayList<NhanVien> dsOut = new ArrayList<NhanVien>();
			for(NhanVien nv :dsIn) {
				Pattern pa = Pattern.compile(".*" + thongTin.toLowerCase() + ".*");
				Matcher t = pa.matcher(nv.toString().toLowerCase());
				if(t.matches()) {
					dsOut.add(nv);
				}
			}
			return dsOut;
		}
		
		/**
	     * Lọc Nhân viên theo chức vụ
	     * @author : 			Pham Nhat Linh
	     * @param dsIn       	Danh sách dữ liệu cần lọc
	     * @param thongTin 		Thông tin tìm kiếm
	     * @return dsOut		ArrayList sau khi lọc
	     */
		public static ArrayList<NhanVien> locNhanVienTheoChucVu(ArrayList<NhanVien> dsIn, String chucVu) {
			ArrayList<NhanVien> dsOut = new ArrayList<NhanVien>();
			for(NhanVien nv :dsIn) {
				Pattern pa = Pattern.compile(".*" + chucVu.toLowerCase() + ".*");
				Matcher t = pa.matcher(nv.getChucVu().toLowerCase());
				if(t.matches()) {
					dsOut.add(nv);
				}
			}
			return dsOut;
		}
		
		/**
	     * Sắp xếp nhân viên theo tên nhân viên
	     * @author : 			Pham Nhat Linh
	     * @param dsIn       	Danh sách dữ liệu cần lọc
	     * @param thongTin 		Thông tin tìm kiếm
	     * @return dsOut		ArrayList sau khi lọc
	     */
		public static ArrayList<NhanVien> sapXepNhanVienTheoTen(ArrayList<NhanVien> dsIn) {
			ArrayList<NhanVien> dsOut = new ArrayList<NhanVien>();
			dsOut = dsIn;
			Collections.sort(dsOut, new Comparator<NhanVien>() {
				@Override
				public int compare(NhanVien o1, NhanVien o2) {
					// TODO Auto-generated method stub
					return o1.getTenNhanVien().substring(o1.getTenNhanVien().lastIndexOf(" ")+1).compareTo(o2.getTenNhanVien().substring(o2.getTenNhanVien().lastIndexOf(" ")+1));
				}
			});
			return dsOut;
		}
		
		/**
	     * Sắp xếp nhân viên theo mã nhân viên
	     * @author : 			Pham Nhat Linh
	     * @param dsIn       	Danh sách dữ liệu cần lọc
	     * @param thongTin 		Thông tin tìm kiếm
	     * @return dsOut		ArrayList sau khi lọc
	     */
		public static ArrayList<NhanVien> sapXepNhanVienTheoMa(ArrayList<NhanVien> dsIn) {
			ArrayList<NhanVien> dsOut = new ArrayList<NhanVien>();
			dsOut = dsIn;
			Collections.sort(dsOut, new Comparator<NhanVien>() {
				@Override
				public int compare(NhanVien o1, NhanVien o2) {
					// TODO Auto-generated method stub
					return o1.getMaNhanVien().compareTo(o2.getMaNhanVien());
				}
			});
			return dsOut;
		}
		
		public static void main(String[] args) {
			ArrayList<NhanVien> ds = new ArrayList<NhanVien>();
			ds = DAO_NhanVien.getAllNhanVien();
			for(NhanVien v:ds) {
				System.out.println(v.toString());
			}
			System.out.println("----------");
			ArrayList<NhanVien> dst = new ArrayList<NhanVien>();
			dst = locNhanVienTheoChucVu(ds, "Nhân viên bán hàng");
			for(NhanVien v:dst) {
				System.out.println(v.toString());
			}
		}
		
}
