package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import connect.ConnnectDB;
import entity.NhanVien;
import entity.TaiKhoan;
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
				NhanVien nhanVien = DAO_NhanVien.timKiemNhanVien(rs.getString(1).trim());
				String matKhau = rs.getString(2).trim();
				TaiKhoan taiKhoan = new TaiKhoan(nhanVien, matKhau);
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
			if (t.getNhanVien().getMaNhanVien().equals(ma))
				return t;
		}
		return null;
	}

	public static boolean themTaiKhoan(TaiKhoan taiKhoan) {
		ConnnectDB.getInstance();
		Connection con = ConnnectDB.getConnection();
		PreparedStatement statement = null;
		String sql = "insert into [dbo].[TaiKhoan]" + " ([maNhanVien],[matKhau])"
				+ " values (?, ?)";
		try {
			statement = con.prepareStatement(sql);
			statement.setString(1, taiKhoan.getNhanVien().getMaNhanVien());
			statement.setString(2, PasswordEncoder.hashPassword(taiKhoan.getMatKhau()));
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
		String sql = "delete from [dbo].[TaiKhoan]" + " where maNhanVien = ?";
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
		String sql = "update [dbo].[TaiKhoan]" + " set [maNhanVien]= ?, [matKhau]= ?"
				+ " where [maNhanVien] = ?";
		try {
			statement = con.prepareStatement(sql);
			statement.setString(1, taiKhoan.getNhanVien().getMaNhanVien());
			statement.setString(2, PasswordEncoder.hashPassword(taiKhoan.getMatKhau()));
			statement.setString(3, taiKhoan.getNhanVien().getMaNhanVien());
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