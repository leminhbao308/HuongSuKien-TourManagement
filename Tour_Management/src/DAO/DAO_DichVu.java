package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

import connect.ConnnectDB;
import models.DichVu;
import models.KhachHang;

public class DAO_DichVu {
    public static ArrayList<DichVu> getAllDichVu() {
	ArrayList<DichVu> list = new ArrayList<DichVu>();
	try {
	    ConnnectDB.connect();
	    Connection con = ConnnectDB.getConnection();
	    String sql = "Select * from DichVu";
	    Statement statement = con.createStatement();
	    ResultSet rs = statement.executeQuery(sql);
	    while (rs.next()) {
		String maDichVu = rs.getString(1).trim();
		String phuongTien = rs.getString(2).trim();
		String ChiTietDichVu = rs.getString(3).trim();
		float giaDichVu = Float.parseFloat(rs.getString(4));
		DichVu dv = new DichVu(maDichVu, phuongTien, ChiTietDichVu, giaDichVu);
		list.add(dv);
	    }
	} catch (SQLException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}
	return list;
    }

    public static DichVu timKiemDichVu(String ma) {
	ArrayList<DichVu> dsDichVu = getAllDichVu();
	for (DichVu d : dsDichVu) {
	    if (d.getMaDichVu().equals(ma))
		return d;
	}
	return null;
    }

    public static boolean themDichVu(DichVu d) {
	ConnnectDB.getInstance();
	ArrayList<DichVu> dsDichVu = getAllDichVu();
	if (dsDichVu.contains(d))
	    return false;
	// kiem tra ma dich vu da ton tai
	Connection con = ConnnectDB.getConnection();
	PreparedStatement statement = null;
	String sql = "INSERT INTO [dbo].[DichVu] ([maDichVu], [phuongTienDiChuyen], [chiTietDichVu], [giaDichVu])\r\n"
		+ " VALUES (?, ?, ?, ?)";
	try {
	    statement = con.prepareStatement(sql);
	    statement.setString(1, d.getMaDichVu());
	    statement.setString(2, d.getPhuongTienDiChuyen());
	    statement.setString(3, d.getChiTietDichVu());
	    statement.setFloat(4, d.getGiaDichVu());
	    int kq = statement.executeUpdate();
	    statement.close();
	    if (kq == 1)
		return true;
	    else
		return false;
	} catch (Exception e) {
	    // TODO: handle exception
	    e.printStackTrace();
	    return false;
	}
    }

    public static boolean xoaDichVu(String ma) {
	ConnnectDB.getInstance();
	Connection con = ConnnectDB.getConnection();
	PreparedStatement statement = null;
	String sql = "DELETE FROM [dbo].[DichVu]" + " WHERE maDichVu=?";
	try {
	    ArrayList<KhachHang> dsKhachHang = DAO_KhachHang.getAllKhachHang();
	    for (KhachHang k : dsKhachHang) {
		if (k.getDichVu().getMaDichVu().equals(ma)) {
		    if (k.getTourDuLich().getNgayDi().after(new Date()))
			return false;
		}
		;
	    }
	    // truong hop dich vu khach hang dang dung tour, khong the xoa.
	    statement = con.prepareStatement(sql);
	    statement.setString(1, ma);
	    statement.executeUpdate();
	    return true;
	} catch (Exception e) {
	    e.printStackTrace();
	    // TODO: handle exception
	    return false;
	}
    }

    public static boolean suaDichVu(DichVu dichVu) {
	ConnnectDB.getInstance();
	Connection con = ConnnectDB.getConnection();
	PreparedStatement statement = null;
	String sql = " UPDATE [dbo].[DichVu] "
		+ " SET [maDichVu] = ?, [phuongTienDiChuyen] = ?, [chiTietDichVu] = ?, [giaDichVu] = ? "
		+ " WHERE [maDichVu] = ?";
	try {
	    statement = con.prepareStatement(sql);
	    statement.setString(1, dichVu.getMaDichVu());
	    statement.setString(2, dichVu.getPhuongTienDiChuyen());
	    statement.setString(3, dichVu.getChiTietDichVu());
	    statement.setFloat(4, dichVu.getGiaDichVu());
	    statement.setString(5, dichVu.getMaDichVu());
	    statement.executeUpdate();
	    return true;
	} catch (Exception e) {
	    // TODO: handle exception
	    e.printStackTrace();
	    return false;
	}
    }
}