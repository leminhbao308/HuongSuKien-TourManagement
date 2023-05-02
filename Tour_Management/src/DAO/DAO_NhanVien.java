package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import connect.ConnnectDB;
import entity.NhanVien;

/**
 * Truy vấn dữ liệu về Nhân Viên
 * @author Pham Nhat Linh
 *
 */
public class DAO_NhanVien {
	public static ArrayList<NhanVien> getAllNhanVien() {
		ArrayList<NhanVien> dsNhanVien = new ArrayList<NhanVien>();
		try {
			ConnnectDB.connect();
			String sql = "select * from NhanVien";
			Connection con = ConnnectDB.getConnection();
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				String maNhanVien = rs.getString(1).trim();
				String tenNhanVien = rs.getString(2).trim();
				boolean gioiTinh = rs.getString(3).equals("0");
				LocalDate ngaySinh = LocalDate.parse(rs.getString(4).trim(),DateTimeFormatter.ofPattern("yyyy-MM-dd"));
				String diaChi = rs.getString(5).trim();
				String email = rs.getString(6).trim();
				String soDienThoai = rs.getString(7).trim();
				String chucVu = rs.getString(8).trim();
				
				NhanVien nv = new NhanVien(maNhanVien, tenNhanVien, gioiTinh, ngaySinh, diaChi, email, soDienThoai, chucVu);
				dsNhanVien.add(nv);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return dsNhanVien;
	}

	public static NhanVien timKiemNhanVien(String ma) {
		ArrayList<NhanVien> dsNhanVien = getAllNhanVien();
		for (NhanVien n : dsNhanVien) {
			if (n.getMaNhanVien().trim().equals(ma))
				return n;
		}
		return null;
	}

	public static boolean themNhanVien(NhanVien nhanVien) {
		ConnnectDB.getInstance();
		Connection con = ConnnectDB.getConnection();
		PreparedStatement statement = null;
		String sql = "insert into [dbo].[NhanVien]"
				+ " ([maNhanVien], [tenNhanVien], [gioiTinh], [ngaySinh], [diaChi], [email], [soDienThoai], [chucVu])"
				+ " values (?, ?, ?, ?, ?, ?, ?, ?)";
		try {
			statement = con.prepareStatement(sql);
			statement.setString(1, nhanVien.getMaNhanVien());
			statement.setString(2, nhanVien.getTenNhanVien());
			statement.setBoolean(3, nhanVien.isGioiTinh());
			statement.setDate(4, java.sql.Date.valueOf(nhanVien.getNgaySinh()));
			statement.setString(5, nhanVien.getDiaChi());
			statement.setString(6, nhanVien.getEmail());
			statement.setString(7, nhanVien.getSoDienThoai());
			statement.setString(8, nhanVien.getChucVu());
			statement.executeUpdate();
			statement.close();
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
	}

	public static boolean xoaNhanVien(String ma) {
		ConnnectDB.getInstance();
		Connection con = ConnnectDB.getConnection();
		PreparedStatement statement = null;
		String sql = "delete from [dbo].[NhanVien]" + " where maNhanVien = ?";
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

	public static boolean suaNhanVien(NhanVien nhanVien) {
		ConnnectDB.getInstance();
		Connection con = ConnnectDB.getConnection();
		PreparedStatement statement = null;
		String sql = "update [dbo].[NhanVien]"
				+ " set [maNhanVien], [tenNhanVien], [gioiTinh], [ngaySinh], [diaChi], [email], [soDienThoai], [chucVu]"
				+ " where [maNhanVien] = ?";
		try {
			statement = con.prepareStatement(sql);
			statement.setString(1, nhanVien.getMaNhanVien());
			statement.setString(2, nhanVien.getTenNhanVien());
			statement.setBoolean(3, nhanVien.isGioiTinh());
			statement.setDate(4, java.sql.Date.valueOf(nhanVien.getNgaySinh()));
			statement.setString(5, nhanVien.getDiaChi());
			statement.setString(6, nhanVien.getEmail());
			statement.setString(7, nhanVien.getSoDienThoai());
			statement.setString(8, nhanVien.getChucVu());
			statement.setString(9, nhanVien.getMaNhanVien());
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