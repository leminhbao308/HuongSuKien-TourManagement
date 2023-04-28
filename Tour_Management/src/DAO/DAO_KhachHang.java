package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import connect.ConnnectDB;
import models.DichVu;
import models.KhachHang;
import models.TourDuLich;

public class DAO_KhachHang {
	public static ArrayList<KhachHang> getAllKhachHang() {
		ArrayList<KhachHang> dsKhachHang = new ArrayList<KhachHang>();
		try {
			ConnnectDB.connect();
			Connection con = ConnnectDB.getConnection();
			String sql = "select * from KhachHang";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				String maKhachHang = rs.getString(1).trim();
				String soCCCD_HC = rs.getString(2).trim();
				String tenKhachHang = rs.getString(3).trim();
				boolean gioiTinh = rs.getString(4).equals("0");
				Date ngaySinh = new SimpleDateFormat("yyyy-MM-dd").parse(rs.getString(5));
				String diaChi = rs.getString(6).trim();
				String email = rs.getString(7).trim();
				String soDienThoai = rs.getString(8).trim();
				float tienTour = Float.parseFloat(rs.getString(9).trim());
				TourDuLich tourDuLich = DAO_TourDuLich.timKiemTour(rs.getString(10).trim());
				DichVu dichVu = DAO_DichVu.timKiemDichVu(rs.getString(11).trim());
				KhachHang khachHang = new KhachHang(maKhachHang, soCCCD_HC, tenKhachHang, gioiTinh, ngaySinh, diaChi,
						email, soDienThoai, tienTour, tourDuLich, dichVu);
				dsKhachHang.add(khachHang);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dsKhachHang;
	}

	public static KhachHang timKiemKhachHang(String ma) {
		ArrayList<KhachHang> dsKhachHang = getAllKhachHang();
		for (KhachHang k : dsKhachHang) {
			if (k.getMaKhachHang().trim().equals(ma))
				return k;
		}
		return null;
	}

	public static boolean themKhachHang(KhachHang k) {
		ConnnectDB.getInstance();
		Connection con = ConnnectDB.getConnection();
		PreparedStatement statement = null;
		String sql = "insert into [dbo].[KhachHang]"
				+ " ([maKhachHang], [soCCCD_HC], [tenKhachHang], [gioiTinh], [ngaySinh], [diaChi], [email], [soDienThoai], [tienTour], [maTour], [maDichVu])"
				+ " values (?, ?, ?, ?, ? ,?, ?, ?, ?, ?, ?)";
		try {
			statement = con.prepareStatement(sql);
			statement.setString(1, k.getMaKhachHang());
			statement.setString(2, k.getSoCCCD_HC());
			statement.setString(3, k.getTenKhachHang());
			statement.setBoolean(4, k.getGioiTinh());
			statement.setDate(5, new java.sql.Date(k.getNgaySinh().getTime()));
			statement.setString(6, k.getDiaChi());
			statement.setString(7, k.getEmail());
			statement.setString(8, k.getSoDienThoai());
			statement.setFloat(9, k.getTienTour());
			statement.setString(10, k.getTourDuLich().getMaTour());
			statement.setString(11, k.getDichVu().getMaDichVu());
			statement.executeUpdate();
			statement.close();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public static boolean xoaKhachHang(String ma) {
		ConnnectDB.getInstance();
		Connection con = ConnnectDB.getConnection();
		PreparedStatement statement = null;
		String sql = "delete from [dbo].[KhachHang]" + " where maKhachHang = ?";
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

	public static boolean suaKhachHang(KhachHang khachHang) {
		ConnnectDB.getInstance();
		Connection con = ConnnectDB.getConnection();
		PreparedStatement statement = null;
		String sql = "update [dbo].[KhachHang]"
				+ " set [maKhachHang]= ?, [soCCCD_HC]= ?, [tenKhachHang]= ?, [gioiTinh]= ?, [ngaySinh]= ?, [diaChi]= ?, [email]= ?, [soDienThoai]= ?, [tienTour]= ?, [maTour]= ?, [maDichVu]= ?"
				+ " where maKhachHang = ?";
		try {
			statement = con.prepareStatement(sql);
			statement.setString(1, khachHang.getMaKhachHang());
			statement.setString(2, khachHang.getSoCCCD_HC());
			statement.setString(3, khachHang.getTenKhachHang());
			statement.setBoolean(4, khachHang.getGioiTinh());
			statement.setDate(5, new java.sql.Date(khachHang.getNgaySinh().getTime()));
			statement.setString(6, khachHang.getDiaChi());
			statement.setString(7, khachHang.getEmail());
			statement.setString(8, khachHang.getSoDienThoai());
			statement.setFloat(9, khachHang.getTienTour());
			statement.setString(10, khachHang.getTourDuLich().getMaTour());
			statement.setString(11, khachHang.getDichVu().getMaDichVu());
			statement.setString(12, khachHang.getMaKhachHang());
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