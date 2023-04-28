package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import connect.ConnnectDB;
import models.HopDongTour;
import models.KhachHang;
import models.NhanVien;

public class DAO_HopDongTour {
	public static ArrayList<HopDongTour> getAllHopDongTour() {
		ArrayList<HopDongTour> dsHopDong = new ArrayList<HopDongTour>();
		try {
			ConnnectDB.connect();
			String sql = "select * from HopDongTour";
			Connection con = ConnnectDB.getConnection();
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				String maHopDong = rs.getString(1);
				Date thoiGianLap = new SimpleDateFormat("yyyy-MM-dd").parse(rs.getString(2).trim());
				String ghiChu = rs.getString(3).trim();
				float tongTien = Float.parseFloat(rs.getString(4).trim());
				float daThanhToan = Float.parseFloat(rs.getString(5).trim());
				NhanVien nhanVien = DAO_NhanVien.timKiemNhanVien(rs.getString(6).trim());
				KhachHang khachHang = DAO_KhachHang.timKiemKhachHang(rs.getString(7).trim());
				HopDongTour hopDong = new HopDongTour(maHopDong, thoiGianLap, ghiChu, tongTien, daThanhToan, nhanVien,
						khachHang);
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
				+ " ([maHopDong], [thoiGianLap], [ghiChu], [tongTien], [daThanhToan], [maNhanVien], [maKhachHang])"
				+ " values (?, ?, ?, ?, ?, ?, ?)";
		try {
			statement = con.prepareStatement(sql);
			statement.setString(1, hopDongTour.getMaHopDong());
			statement.setDate(2, new java.sql.Date(hopDongTour.getThoiGianLap().getTime()));
			statement.setString(3, hopDongTour.getGhiChu());
			statement.setFloat(4, hopDongTour.getTongTien());
			statement.setFloat(5, hopDongTour.getDaThanhToan());
			statement.setString(6, hopDongTour.getNhanVien().getMaNhanVien());
			statement.setString(7, hopDongTour.getKhachHang().getMaKhachHang());
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
				+ "set [maHopDong] = ?, [thoiGianLap]= ?, [ghiChu]= ?, [tongTien]= ?, [daThanhToan]= ?, [maNhanVien]= ?, [maKhachHang]= ?"
				+ " where [maHopDong] = ?";
		try {
			statement = con.prepareStatement(sql);
			statement.setString(1, hopDongTour.getMaHopDong());
			statement.setDate(2, new java.sql.Date(hopDongTour.getThoiGianLap().getTime()));
			statement.setString(3, hopDongTour.getGhiChu());
			statement.setFloat(4, hopDongTour.getTongTien());
			statement.setFloat(5, hopDongTour.getDaThanhToan());
			statement.setString(6, hopDongTour.getNhanVien().getMaNhanVien());
			statement.setString(7, hopDongTour.getKhachHang().getMaKhachHang());
			statement.setString(8, hopDongTour.getMaHopDong());
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
