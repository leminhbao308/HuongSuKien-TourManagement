package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import connect.ConnnectDB;
import models.NhanVien;
import models.TaiKhoan;
import utils.PasswordEncoder;

/**
 * Truy vấn dữ liệu về Tài Khoản
 * 
 * @author Pham Nhat Linh
 *
 */
public class DAO_TaiKhoan {
	public static ArrayList<TaiKhoan> getAllTaiKhoan() {
		ArrayList<TaiKhoan> dsTaiKhoan = new ArrayList<TaiKhoan>();
		try {
			ConnnectDB.connect();
			String sql = "select * from TaiKhoan";
			Connection con = ConnnectDB.getConnection();
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				String maTaiKhoan = rs.getString(1).trim();
				String maDangNhap = rs.getString(2).trim();
				String matKhau = rs.getString(3).trim();
				NhanVien nhanVien = DAO_NhanVien.timKiemNhanVien(rs.getString(4).trim());
				TaiKhoan taiKhoan = new TaiKhoan(maTaiKhoan, maDangNhap, matKhau, nhanVien);
				dsTaiKhoan.add(taiKhoan);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return dsTaiKhoan;
	}

	public static TaiKhoan timKiemTaiKhoan(String ma) {
		ArrayList<TaiKhoan> dsTaiKhoan = getAllTaiKhoan();
		for (TaiKhoan t : dsTaiKhoan) {
			if (t.getMaTaiKhoan().trim().equals(ma))
				return t;
		}
		return null;
	}

	public static boolean themTaiKhoan(TaiKhoan taiKhoan) {
		ConnnectDB.getInstance();
		Connection con = ConnnectDB.getConnection();
		PreparedStatement statement = null;
		String sql = "insert into [dbo].[TaiKhoan]" + " ([maTaiKhoan], [maDangNhap], [matKhau], [maNhanVien])"
				+ " values (?, ?, ?, ?)";
		try {
			statement = con.prepareStatement(sql);
			statement.setString(1, taiKhoan.getMaTaiKhoan());
			statement.setString(2, taiKhoan.getMaDangNhap());
			statement.setString(3, PasswordEncoder.hashPassword(taiKhoan.getMatKhau()));
			statement.setString(4, taiKhoan.getNhanVien().getMaNhanVien());
			statement.executeUpdate();
			statement.close();
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
	}

	public static boolean xoaTaiKhoan(String ma) {
		ConnnectDB.getInstance();
		Connection con = ConnnectDB.getConnection();
		PreparedStatement statement = null;
		String sql = "delete from [dbo].[TaiKhoan]" + " where maTaiKhoan = ?";
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

	public static boolean suaTaiKhoan(TaiKhoan taiKhoan) {
		ConnnectDB.getInstance();
		Connection con = ConnnectDB.getConnection();
		PreparedStatement statement = null;
		String sql = "update [dbo].[TaiKhoan]" + " set [maTaiKhoan]= ?, [maDangNhap]= ?, [matKhau]= ?, [maNhanVien]= ?"
				+ " where [maTaiKhoan] = ?";
		try {
			statement = con.prepareStatement(sql);
			statement.setString(1, taiKhoan.getMaTaiKhoan());
			statement.setString(2, taiKhoan.getMaDangNhap());
			statement.setString(3, PasswordEncoder.hashPassword(taiKhoan.getMatKhau()));
			statement.setString(4, taiKhoan.getNhanVien().getMaNhanVien());
			statement.setString(5, taiKhoan.getMaTaiKhoan());
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