package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import connect.ConnnectDB;
import entity.DichVu;
import entity.HopDongTour;
import entity.KhachHang;
import entity.NhanVien;
import entity.TourDuLich;

/**
 * Truy vấn dữ liệu về Hợp Đồng Tour
 * 
 * @author Pham Nhat Linh
 *
 */
public class DAO_HopDongTour {
	public static ArrayList<HopDongTour> getAllHopDongTour() {
		ArrayList<HopDongTour> dsHopDong = new ArrayList<HopDongTour>();
		try {
			ConnnectDB.connect();
			String sql = "select * from HopDongTour order by thoiGianLap asc";
			Connection con = ConnnectDB.getConnection();
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				String maHopDong = rs.getString(1);
				LocalDate thoiGianLap = LocalDate.parse(rs.getString(2).trim(),DateTimeFormatter.ofPattern("yyyy-MM-dd"));
				String ghiChu = rs.getString(3).trim();
				float tongTien = rs.getFloat(4);
				NhanVien nhanVien = DAO_NhanVien.timKiemNhanVien(rs.getString(6).trim());
				KhachHang khachHang = DAO_KhachHang.timKiemKhachHang(rs.getString(7).trim());
				TourDuLich tour = DAO_TourDuLich.timKiemTour(rs.getString(8).trim());
				DichVu dichVu = DAO_DichVu.timKiemDichVu(rs.getString(9).trim());
				HopDongTour hopDong = new HopDongTour(maHopDong, thoiGianLap, ghiChu, tongTien, nhanVien, khachHang, tour, dichVu);
				dsHopDong.add(hopDong);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return dsHopDong;
	}

	public static HopDongTour timKiemHopDong(String ma) {
		ArrayList<HopDongTour> dsHopDong = getAllHopDongTour();
		for (HopDongTour h : dsHopDong) {
			if (h.getMaHopDong().trim().equals(ma))
				return h;
		}
		return null;
	}

	public static boolean themHopDongTour(HopDongTour hopDongTour) {
		ConnnectDB.getInstance();
		Connection con = ConnnectDB.getConnection();
		PreparedStatement statement = null;
		String sql = "insert into [dbo].[HopDongTour]"
				+ " ([maHopDong], [thoiGianLap], [ghiChu], [tongTien], [maNhanVien], [maKhachHang], [maTour], [maDichVu])"
				+ " values (?, ?, ?, ?, ?, ?, ?, ?)";
		try {
			statement = con.prepareStatement(sql);
			statement.setString(1, hopDongTour.getMaHopDong());
			statement.setDate(2, java.sql.Date.valueOf(hopDongTour.getThoiGianLap()));
			statement.setString(3, hopDongTour.getGhiChu());
			statement.setFloat(4, hopDongTour.getTongTien());
			statement.setString(5, hopDongTour.getNhanVien().getMaNhanVien());
			statement.setString(6, hopDongTour.getKhachHang().getMaKhachHang());
			statement.setString(7, hopDongTour.getTourDuLich().getMaTour());
			statement.setString(8, hopDongTour.getDichVu().getMaDichVu());
			statement.executeUpdate();
			statement.close();
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
	}

	public static boolean xoaHopDongTour(String ma) {
		ConnnectDB.getInstance();
		Connection con = ConnnectDB.getConnection();
		PreparedStatement statement = null;
		String sql = "delete from [dbo].[HopDongTour]" + " where maHopDong = ?";
		try {
			statement = con.prepareStatement(sql);
			statement.setString(1, ma);
			statement.executeUpdate();
			statement.close();
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
	}

	public static boolean suaHopDongTour(HopDongTour hopDongTour) {
		ConnnectDB.getInstance();
		Connection con = ConnnectDB.getConnection();
		PreparedStatement statement = null;
		String sql = "update [dbo].[HopDongTour]"
				+ "set [maHopDong] = ?, [thoiGianLap]= ?, [ghiChu]= ?, [tongTien]= ?, [maNhanVien]= ?, [maKhachHang]= ?, [maTour]=?, [maDichVu]=?"
				+ " where [maHopDong] = ?";
		try {
			statement = con.prepareStatement(sql);
			statement.setString(1, hopDongTour.getMaHopDong());
			statement.setDate(2, java.sql.Date.valueOf(hopDongTour.getThoiGianLap()));
			statement.setString(3, hopDongTour.getGhiChu());
			statement.setFloat(4, hopDongTour.getTongTien());
			statement.setString(5, hopDongTour.getNhanVien().getMaNhanVien());
			statement.setString(6, hopDongTour.getKhachHang().getMaKhachHang());
			statement.setString(7, hopDongTour.getTourDuLich().getMaTour());
			statement.setString(8, hopDongTour.getDichVu().getMaDichVu());
			statement.setString(9, hopDongTour.getMaHopDong());
			statement.executeUpdate();
			statement.close();
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
	}
}
