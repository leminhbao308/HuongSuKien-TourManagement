package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import connect.ConnnectDB;
import entity.DiaDanh;
import entity.TourDuLich;

/**
 * Truy vấn dữ liệu về Tour Du Lịch
 * 
 * @author Pham Nhat Linh
 *
 */ 
public class DAO_TourDuLich {
	public static ArrayList<TourDuLich> getAllTourDuLich() {
		ArrayList<TourDuLich> dsTour = new ArrayList<TourDuLich>();
		try {
			ConnnectDB.connect();
			Connection con = ConnnectDB.getConnection();
			String sql = "select * from TourDuLich order by ngayDi asc";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				String maTour = rs.getString(1).trim();
				String tenTour = rs.getString(2).trim();
				String moTa = rs.getString(3).trim();
				LocalDate ngayDi = LocalDate.parse(rs.getString(4).trim(),DateTimeFormatter.ofPattern("yyyy-MM-dd"));
				String noiDi = rs.getString(5).trim();
				int soNgayDuKien = Integer.parseInt(rs.getString(6));
				float giaTour = rs.getFloat(7);
				boolean trangThaiTour = rs.getString(8).equals("0");
				DiaDanh diaDanh = DAO_DiaDanh.timDiaDanh(rs.getString(9).trim());
				TourDuLich tour = new TourDuLich(maTour, tenTour, moTa, ngayDi, noiDi, soNgayDuKien, giaTour, trangThaiTour, diaDanh);
				dsTour.add(tour);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return dsTour;
	}

	public static TourDuLich timKiemTour(String ma) {
		ArrayList<TourDuLich> dsTour = getAllTourDuLich();
		for (TourDuLich t : dsTour) {
			if (t.getMaTour().trim().equals(ma))
				return t;
		}
		return null;
	}

	public static boolean themTourDuLich(TourDuLich tour) {
		ConnnectDB.getInstance();
		Connection con = ConnnectDB.getConnection();
		PreparedStatement statement = null;
		String sql = "insert into [dbo].[TourDuLich] ([maTour], [tenTour], [moTa], [ngayDi], [noiDi], [soNgayDuKien], [giaTour], [trangThaiTour], [maDiaDanh])"
				+ "values (?,?,?,?,?,?,?,?,?)";
		try {
			statement = con.prepareStatement(sql);
			statement.setString(1, tour.getMaTour());
			statement.setString(2, tour.getTenTour());
			statement.setString(3, tour.getMoTa());
			statement.setDate(4, java.sql.Date.valueOf(tour.getNgayDi()));
			statement.setString(5, tour.getNoiDi());
			statement.setInt(6, tour.getSoNgayDuKien());
			statement.setFloat(7, tour.getGiaTour());
			statement.setBoolean(8, tour.getTrangThaiTour());
			statement.setString(9, tour.getDiaDanh().getMaDiaDanh());
			statement.executeUpdate();
			statement.close();
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
	}

	public static boolean xoaTourDuLich(String ma) {
		ConnnectDB.getInstance();
		Connection con = ConnnectDB.getConnection();
		PreparedStatement statement = null;
		String sql = "delete from [dbo].[TourDuLich]" + "where maTour=?";
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

	public static boolean suaTuorDuLich(TourDuLich tour) {
		ConnnectDB.getInstance();
		Connection con = ConnnectDB.getConnection();
		PreparedStatement statement = null;
		String sql = " update [dbo].[TourDuLich]"
				+ " set [maTour]= ?, [tenTour]= ?, [moTa] = ?, [ngayDi]= ?, [noiDi]= ?, [soNgayDuKien]= ?, [giaTour]= ?, [trangThaiTour]= ?, [maDiaDanh]= ?"
				+ " where [maTour]= ?";
		try {
			statement = con.prepareStatement(sql);
			statement.setString(1, tour.getMaTour());
			statement.setString(2, tour.getTenTour());
			statement.setString(3, tour.getMoTa());
			statement.setDate(4, java.sql.Date.valueOf(tour.getNgayDi()));
			statement.setString(5, tour.getNoiDi());
			statement.setInt(6, tour.getSoNgayDuKien());
			statement.setFloat(7, tour.getGiaTour());
			statement.setBoolean(8, tour.getTrangThaiTour());
			statement.setString(9, tour.getDiaDanh().getMaDiaDanh());
			statement.setString(10, tour.getMaTour());
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