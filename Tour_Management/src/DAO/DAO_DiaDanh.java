package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import connect.ConnnectDB;
import entity.DiaDanh;
import entity.TourDuLich;

/**
 * Truy vấn dữ liệu về Địa Danh
 * 
 * @author Pham Nhat Linh
 *
 */
public class DAO_DiaDanh {
	/**
	 * @return ArrayList<DiaDanh> 
	 */
	public static ArrayList<DiaDanh> getAllDiaDanh() {
		ArrayList<DiaDanh> dsDiaDanh = new ArrayList<DiaDanh>();
		try {
			ConnnectDB.connect();
			Connection con = ConnnectDB.getConnection();
			String sql = "select * from DiaDanh";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				String maDiaDanh = rs.getString(1).trim();
				String tenDiaDanh = rs.getString(2).trim();
				String tinhThanh = rs.getString(3).trim();
				DiaDanh d = new DiaDanh(maDiaDanh, tenDiaDanh, tinhThanh);
				dsDiaDanh.add(d);
			}
			statement.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return dsDiaDanh;
	}

	/**
	 * @param ma Mã Địa Danh
	 * @return DiaDanh Địa Danh có mã cần tìm
	 */
	public static DiaDanh timDiaDanh(String ma) {
		ArrayList<DiaDanh> ds = getAllDiaDanh();
		for (DiaDanh d : ds) {
			if (d.getMaDiaDanh().trim().equals(ma))
				return d;
		}
		return null;
	}

	public static boolean themDiaDanh(DiaDanh d) {
		ConnnectDB.getInstance();
		Connection con = ConnnectDB.getConnection();
		PreparedStatement statement = null;
		String sql = "insert into [dbo].[DiaDanh] ([maDiaDanh], [tenDiaDanh], [tinhThanh])" + " values (?, ?, ?)";
		try {
			statement = con.prepareStatement(sql);
			statement.setString(1, d.getMaDiaDanh());
			statement.setString(2, d.getTenDiaDanh());
			statement.setString(3, d.getTinhThanh());
			int r = statement.executeUpdate();
			statement.close();
			if (r == 1)
				return true;
			else
				return false;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
	}

	public static boolean xoaDiaDanh(String ma) {
		ConnnectDB.getInstance();
		Connection con = ConnnectDB.getConnection();
		PreparedStatement statement = null;
		String sql = "delete from [dbo].[DiaDanh]" + "where maDiaDanh=?";
		try {
			ArrayList<TourDuLich> dsTour = DAO_TourDuLich.getAllTourDuLich();
			for (TourDuLich tour : dsTour) {
				if (tour.getDiaDanh().getMaDiaDanh().equals(ma))
					return false;
			}
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

	public static boolean suaDiaDanh(DiaDanh diaDanh) {
		ConnnectDB.getInstance();
		Connection con = ConnnectDB.getConnection();
		PreparedStatement statement = null;
		String sql = "update [dbo].[DiaDanh]" + " set [maDiaDanh] = ?, [tenDiaDanh] = ?, [tinhThanh] = ?"
				+ " where [maDiaDanh] = ? ";
		try {
			statement = con.prepareStatement(sql);
			statement.setString(1, diaDanh.getMaDiaDanh());
			statement.setString(2, diaDanh.getTenDiaDanh());
			statement.setString(3, diaDanh.getTinhThanh());
			statement.setString(4, diaDanh.getMaDiaDanh());
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