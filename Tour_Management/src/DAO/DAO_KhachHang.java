package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import connect.ConnnectDB;
import entity.KhachHang;

/**
 * Truy vấn dữ liệu về Khách Hàng
 * 
 * @author Pham Nhat Linh
 *
 */
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
				LocalDate ngaySinh = LocalDate.parse(rs.getString(5).trim(),DateTimeFormatter.ofPattern("yyyy-MM-dd"));
				String email = rs.getString(6).trim();
				String soDienThoai = rs.getString(7).trim();
				KhachHang khachHang = new KhachHang(maKhachHang, soCCCD_HC, tenKhachHang, gioiTinh, ngaySinh, email, soDienThoai);
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
				+ " ([maKhachHang], [soCCCD_HC], [tenKhachHang], [gioiTinh], [ngaySinh], [email], [soDienThoai])"
				+ " values (?, ?, ?, ?, ? ,?, ?)";
		try {
			statement = con.prepareStatement(sql);
			statement.setString(1, k.getMaKhachHang());
			statement.setString(2, k.getSoCCCD_HC());
			statement.setString(3, k.getTenKhachHang());
			statement.setBoolean(4, k.isGioiTinh());
			statement.setDate(5, java.sql.Date.valueOf(k.getNgaySinh()));
			statement.setString(6, k.getEmail());
			statement.setString(7, k.getSoDienThoai());
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
				+ " set [maKhachHang]= ?, [soCCCD_HC]= ?, [tenKhachHang]= ?, [gioiTinh]= ?, [ngaySinh]= ?, [email]= ?, [soDienThoai]= ?"
				+ " where [maKhachHang] = ?";
		try {
			statement = con.prepareStatement(sql);
			statement.setString(1, khachHang.getMaKhachHang());
			statement.setString(2, khachHang.getSoCCCD_HC());
			statement.setString(3, khachHang.getTenKhachHang());
			statement.setBoolean(4, khachHang.isGioiTinh());
			statement.setDate(5, java.sql.Date.valueOf(khachHang.getNgaySinh()));
			statement.setString(6, khachHang.getEmail());
			statement.setString(7, khachHang.getSoDienThoai());
			statement.setString(8, khachHang.getMaKhachHang());
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