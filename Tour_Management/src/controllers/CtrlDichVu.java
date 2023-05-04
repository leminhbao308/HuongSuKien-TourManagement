package controllers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import entity.DichVu;

public class CtrlDichVu {
    /**
     * Tìm kiếm các dịch vụ có thông tin chi tiết và phương tiện liên quan với thông
     * tin nhập vào
     * 
     * @author : Pham Nhat Linh
     * @param dsIn     Danh sách dữ liệu cần lọc
     * @param thongTin Thông tin tìm kiếm
     * @return dsOut ArrayList sau khi lọc
     */
    public static ArrayList<DichVu> locTourTheoThongTinTour(ArrayList<DichVu> dsIn, String tenDichVu) {
	ArrayList<DichVu> dsOut = new ArrayList<DichVu>();
	for (DichVu dv : dsIn) {
	    Pattern pa = Pattern.compile(".*" + tenDichVu.toLowerCase() + ".*");
	    Matcher ma = pa.matcher(dv.getChiTietDichVu().toLowerCase() + " " + dv.getPhuongTienDiChuyen());
	    if (ma.matches()) {
		dsOut.add(dv);
	    }
	}
	return dsOut;
    }

    /**
     * Sắp xếp danh sách dịch vụ tăng dần theo giá
     * 
     * @author : Pham Nhat Linh
     * @param dsIn Danh sách dữ liệu cần sắp xếp
     * @return dsOut ArrayList sau khi sắp xếp
     */
    public static ArrayList<DichVu> sapXepGiaDichVuTang(ArrayList<DichVu> dsIn) {
	ArrayList<DichVu> dsOut = new ArrayList<DichVu>();
	Collections.sort(dsIn, new Comparator<DichVu>() {
	    @Override
	    public int compare(DichVu o1, DichVu o2) {
		// TODO Auto-generated method stub
		return Float.compare(o1.getGiaDichVu(), o2.getGiaDichVu());
	    }
	});
	return dsOut;
    }

    /**
     * Sắp xếp danh sách dịch vụ giảm dần theo giá
     * 
     * @author : Pham Nhat Linh
     * @param dsIn Danh sách dữ liệu cần sắp xếp
     * @return dsOut ArrayList sau khi sắp xếp
     */
    public static ArrayList<DichVu> sapXepGiaDichVuGiam(ArrayList<DichVu> dsIn) {
	ArrayList<DichVu> dsOut = new ArrayList<DichVu>();
	Collections.sort(dsIn, new Comparator<DichVu>() {
	    @Override
	    public int compare(DichVu o1, DichVu o2) {
		// TODO Auto-generated method stub
		return Float.compare(o2.getGiaDichVu(), o1.getGiaDichVu());
	    }
	});
	return dsOut;
    }
}
