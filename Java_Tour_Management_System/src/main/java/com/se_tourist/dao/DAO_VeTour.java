package main.java.com.se_tourist.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import main.java.com.se_tourist.connect.ConnnectDB;
import main.java.com.se_tourist.models.KhachHang;
import main.java.com.se_tourist.models.VeTour;

public class DAO_VeTour {
    public static ArrayList<VeTour> getAllVeTour() {
	ArrayList<VeTour> dsVeTour = new ArrayList<VeTour>();
	try {
	    ConnnectDB.connect();
	    String sql = "select * from VeTour";
	    Connection con = ConnnectDB.getConnection();
	    Statement statement = con.createStatement();
	    ResultSet rs = statement.executeQuery(sql);
	    while (rs.next()) {
		String maVe = rs.getString(1).trim();
		KhachHang khachHang = DAO_KhachHang.timKiemKhachHang(rs.getString(2).trim());
		VeTour veTour = new VeTour(maVe, khachHang);
		dsVeTour.add(veTour);
	    }
	} catch (Exception e) {
	    // TODO: handle exception
	    e.printStackTrace();
	}
	return dsVeTour;
    }

    public static VeTour timKiemVeTour(String ma) {
	ArrayList<VeTour> dsVeTour = getAllVeTour();
	for (VeTour v : dsVeTour) {
	    if (v.getMaVe().trim().equals(ma))
		return v;
	}
	return null;
    }

    public static boolean themVeTour(VeTour ve) {
	ConnnectDB.getInstance();
	Connection con = ConnnectDB.getConnection();
	PreparedStatement statement = null;
	String sql = "insert into [dbo].[VeTour]" + " ([maVe], [maKhachHang])" + " values (?, ?)";
	try {
	    statement = con.prepareStatement(sql);
	    statement.setString(1, ve.getMaVe());
	    statement.setString(2, ve.getKhachHang().getMaKhachHang());
	    statement.executeUpdate();
	    statement.close();
	    return true;
	} catch (Exception e) {
	    // TODO: handle exception
	    e.printStackTrace();
	    return false;
	}
    }

    public static boolean xoaVeTour(String ma) {
	ConnnectDB.getInstance();
	Connection con = ConnnectDB.getConnection();
	PreparedStatement statement = null;
	String sql = "delete from [dbo].[VeTour]" + " where maVe = ?";
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

    public static boolean suaVeTour(VeTour ve) {
	ConnnectDB.getInstance();
	Connection con = ConnnectDB.getConnection();
	PreparedStatement statement = null;
	String sql = "update [dbo].[VeTour]" + " set [maVe]= ?, [maKhachHang]= ?" + " where [maVe] = ?";
	try {
	    statement = con.prepareStatement(sql);
	    statement.setString(1, ve.getMaVe());
	    statement.setString(2, ve.getKhachHang().getMaKhachHang());
	    statement.setString(3, ve.getMaVe());
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