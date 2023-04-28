package utils;

import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JTextField;

import utils.constants.ElementConstant;

public class AddList {
	public static ArrayList<JLabel> getListLblAddDiaDanh() {
		ArrayList<JLabel> listDiaDanh = new ArrayList<JLabel>();
		listDiaDanh.add(ElementConstant.LBL_ADD_DD_MADIADANH);
		listDiaDanh.add(ElementConstant.LBL_ADD_DD_TENDIADANH);
		listDiaDanh.add(ElementConstant.LBL_ADD_DD_TINHTHANH);

		return listDiaDanh;
	}

	public static ArrayList<JTextField> getListTxtAddDiaDanh() {
		ArrayList<JTextField> listDiaDanh = new ArrayList<JTextField>();
		listDiaDanh.add(ElementConstant.TXT_ADD_DD_MADIADANH);
		listDiaDanh.add(ElementConstant.TXT_ADD_DD_TENDIADANH);
		listDiaDanh.add(ElementConstant.TXT_ADD_DD_TINHTHANH);

		return listDiaDanh;
	}

	public static ArrayList<JLabel> getListLblAddKhachHang() {
		ArrayList<JLabel> listKhachHang = new ArrayList<JLabel>();
		listKhachHang.add(ElementConstant.LBL_ADD_KH_MAKH);
		listKhachHang.add(ElementConstant.LBL_ADD_KH_TENKH);
		listKhachHang.add(ElementConstant.LBL_ADD_KH_NGAYSINH);
		listKhachHang.add(ElementConstant.LBL_ADD_KH_CCCD_HC);
		listKhachHang.add(ElementConstant.LBL_ADD_KH_SDT);
		listKhachHang.add(ElementConstant.LBL_ADD_KH_EMAIL);
		listKhachHang.add(ElementConstant.LBL_ADD_KH_DIACHI);
		listKhachHang.add(ElementConstant.LBL_ADD_KH_GIOITINH);
		listKhachHang.add(ElementConstant.LBL_ADD_KH_MATOUR);
		listKhachHang.add(ElementConstant.LBL_ADD_KH_MADV);
		listKhachHang.add(ElementConstant.LBL_ADD_KH_TIENTOUR);

		return listKhachHang;
	}

	public static ArrayList<JTextField> getListTxtAddKhachHang() {
		ArrayList<JTextField> listKhachHang = new ArrayList<JTextField>();
		listKhachHang.add(ElementConstant.TXT_ADD_KH_MAKH);
		listKhachHang.add(ElementConstant.TXT_ADD_KH_TENKH);
		listKhachHang.add(ElementConstant.TXT_ADD_KH_NGAYSINH);
		listKhachHang.add(ElementConstant.TXT_ADD_KH_CCCD_HC);
		listKhachHang.add(ElementConstant.TXT_ADD_KH_SDT);
		listKhachHang.add(ElementConstant.TXT_ADD_KH_EMAIL);
		listKhachHang.add(ElementConstant.TXT_ADD_KH_DIACHI);
		listKhachHang.add(ElementConstant.TXT_ADD_KH_GIOITINH);
		listKhachHang.add(ElementConstant.TXT_ADD_KH_MATOUR);
		listKhachHang.add(ElementConstant.TXT_ADD_KH_MADV);
		listKhachHang.add(ElementConstant.TXT_ADD_KH_TIENTOUR);

		return listKhachHang;
	}

	public static ArrayList<JLabel> getListLblAddHopDong() {
		ArrayList<JLabel> listHopDong = new ArrayList<JLabel>();
		listHopDong.add(ElementConstant.LBL_ADD_HD_MAHD);
		listHopDong.add(ElementConstant.LBL_ADD_HD_MAKH);
		listHopDong.add(ElementConstant.LBL_ADD_HD_MANV);
		listHopDong.add(ElementConstant.LBL_ADD_HD_THOIGIAN);
		listHopDong.add(ElementConstant.LBL_ADD_HD_TONGTIEN);
		listHopDong.add(ElementConstant.LBL_ADD_HD_TRANGTHAI);
		listHopDong.add(ElementConstant.LBL_ADD_HD_GHICHU);

		return listHopDong;
	}

	public static ArrayList<JTextField> getListTxtAddHopDong() {
		ArrayList<JTextField> listHopDong = new ArrayList<JTextField>();
		listHopDong.add(ElementConstant.TXT_ADD_HD_MAHD);
		listHopDong.add(ElementConstant.TXT_ADD_HD_MAKH);
		listHopDong.add(ElementConstant.TXT_ADD_HD_MANV);
		listHopDong.add(ElementConstant.TXT_ADD_HD_THOIGIAN);
		listHopDong.add(ElementConstant.TXT_ADD_HD_TONGTIEN);
		listHopDong.add(ElementConstant.TXT_ADD_HD_TRANGTHAI);
		listHopDong.add(ElementConstant.TXT_ADD_HD_GHICHU);

		return listHopDong;
	}

	public static ArrayList<JLabel> getListLblAddDichVu() {
		ArrayList<JLabel> listDichVu = new ArrayList<JLabel>();
		listDichVu.add(ElementConstant.LBL_ADD_DV_MADV);
		listDichVu.add(ElementConstant.LBL_ADD_DV_CHITIETDV);
		listDichVu.add(ElementConstant.LBL_ADD_DV_PHUONGTIEN);
		listDichVu.add(ElementConstant.LBL_ADD_DV_GIADV);

		return listDichVu;
	}

	public static ArrayList<JTextField> getListTxtAddDichVu() {
		ArrayList<JTextField> listDichVu = new ArrayList<JTextField>();
		listDichVu.add(ElementConstant.TXT_ADD_DV_MADV);
		listDichVu.add(ElementConstant.TXT_ADD_DV_CHITIETDV);
		listDichVu.add(ElementConstant.TXT_ADD_DV_PHUONGTIEN);
		listDichVu.add(ElementConstant.TXT_ADD_DV_GIADV);

		return listDichVu;
	}

	public static ArrayList<JLabel> getListLblAddTaiKhoan() {
		ArrayList<JLabel> listTaiKhoan = new ArrayList<JLabel>();
		listTaiKhoan.add(ElementConstant.LBL_ADD_TK_MATK);
		listTaiKhoan.add(ElementConstant.LBL_ADD_TK_MANV);
		listTaiKhoan.add(ElementConstant.LBL_ADD_TK_TAIKHOAN);
		listTaiKhoan.add(ElementConstant.LBL_ADD_TK_MATKHAU);

		return listTaiKhoan;
	}

	public static ArrayList<JTextField> getListTxtAddTaiKhoan() {
		ArrayList<JTextField> listTaiKhoan = new ArrayList<JTextField>();
		listTaiKhoan.add(ElementConstant.TXT_ADD_TK_MATK);
		listTaiKhoan.add(ElementConstant.TXT_ADD_TK_MANV);
		listTaiKhoan.add(ElementConstant.TXT_ADD_TK_TAIKHOAN);
		listTaiKhoan.add(ElementConstant.TXT_ADD_TK_MATKHAU);

		return listTaiKhoan;
	}

	public static ArrayList<JLabel> getListLblAddTourDuLich() {
		ArrayList<JLabel> listTour = new ArrayList<JLabel>();
		listTour.add(ElementConstant.LBL_ADD_TDL_MATOUR);
		listTour.add(ElementConstant.LBL_ADD_TDL_TENTOUR);
		listTour.add(ElementConstant.LBL_ADD_TDL_MOTA);
		listTour.add(ElementConstant.LBL_ADD_TDL_NOIDI);
		listTour.add(ElementConstant.LBL_ADD_TDL_NGAYDI);
		listTour.add(ElementConstant.LBL_ADD_TDL_SONGAY);
		listTour.add(ElementConstant.LBL_ADD_TDL_GIATOUR);
		listTour.add(ElementConstant.LBL_ADD_TDL_MADIADANH);
		listTour.add(ElementConstant.LBL_ADD_TDL_TRANGTHAI);

		return listTour;
	}

	public static ArrayList<JTextField> getListTxtAddTourDuLich() {
		ArrayList<JTextField> listTour = new ArrayList<JTextField>();
		listTour.add(ElementConstant.TXT_ADD_TDL_MATOUR);
		listTour.add(ElementConstant.TXT_ADD_TDL_TENTOUR);
		listTour.add(ElementConstant.TXT_ADD_TDL_MOTA);
		listTour.add(ElementConstant.TXT_ADD_TDL_NOIDI);
		listTour.add(ElementConstant.TXT_ADD_TDL_NGAYDI);
		listTour.add(ElementConstant.TXT_ADD_TDL_SONGAY);
		listTour.add(ElementConstant.TXT_ADD_TDL_GIATOUR);
		listTour.add(ElementConstant.TXT_ADD_TDL_MADIADANH);
		listTour.add(ElementConstant.TXT_ADD_TDL_TRANGTHAI);

		return listTour;
	}

	public static ArrayList<JLabel> getListLblAddNhanVien() {
		ArrayList<JLabel> listNhanVien = new ArrayList<JLabel>();
		listNhanVien.add(ElementConstant.LBL_ADD_NV_MANV);
		listNhanVien.add(ElementConstant.LBL_ADD_NV_TENNV);
		listNhanVien.add(ElementConstant.LBL_ADD_NV_NGAYSINH);
		listNhanVien.add(ElementConstant.LBL_ADD_NV_GIOITINH);
		listNhanVien.add(ElementConstant.LBL_ADD_NV_SDT);
		listNhanVien.add(ElementConstant.LBL_ADD_NV_EMAIL);
		listNhanVien.add(ElementConstant.LBL_ADD_NV_DIACHI);
		return listNhanVien;
	}

	public static ArrayList<JTextField> getListTxtAddNhanVien() {
		ArrayList<JTextField> listNhanVien = new ArrayList<JTextField>();
		listNhanVien.add(ElementConstant.TXT_ADD_NV_MANV);
		listNhanVien.add(ElementConstant.TXT_ADD_NV_TENNV);
		listNhanVien.add(ElementConstant.TXT_ADD_NV_NGAYSINH);
		listNhanVien.add(ElementConstant.TXT_ADD_NV_GIOITINH);
		listNhanVien.add(ElementConstant.TXT_ADD_NV_SDT);
		listNhanVien.add(ElementConstant.TXT_ADD_NV_EMAIL);
		listNhanVien.add(ElementConstant.TXT_ADD_NV_DIACHI);
		return listNhanVien;
	}

	public static ArrayList<JLabel> getListLblAddVe() {
		ArrayList<JLabel> listVe = new ArrayList<JLabel>();
		listVe.add(ElementConstant.LBL_ADD_VX_MAVE);
		listVe.add(ElementConstant.LBL_ADD_VX_MAKH);
		return listVe;
	}

	public static ArrayList<JTextField> getListTxtAddVe() {
		ArrayList<JTextField> listVe = new ArrayList<JTextField>();
		listVe.add(ElementConstant.TXT_ADD_VX_MAVE);
		listVe.add(ElementConstant.TXT_ADD_VX_MAKH);

		return listVe;
	}

	public static ArrayList<JLabel> getListLblDeleteDiaDanh() {
		ArrayList<JLabel> listDiaDanh = new ArrayList<JLabel>();
		listDiaDanh.add(ElementConstant.LBL_DELETE_DD_MADIADANH);
		listDiaDanh.add(ElementConstant.LBL_DELETE_DD_TENDIADANH);
		listDiaDanh.add(ElementConstant.LBL_DELETE_DD_TINHTHANH);

		return listDiaDanh;
	}

	public static ArrayList<JTextField> getListTxtDeleteDiaDanh() {
		ArrayList<JTextField> listDiaDanh = new ArrayList<JTextField>();
		listDiaDanh.add(ElementConstant.TXT_DELETE_DD_MADIADANH);
		listDiaDanh.add(ElementConstant.TXT_DELETE_DD_TENDIADANH);
		listDiaDanh.add(ElementConstant.TXT_DELETE_DD_TINHTHANH);

		return listDiaDanh;
	}

	public static ArrayList<JLabel> getListLblDeleteKhachHang() {
		ArrayList<JLabel> listKhachHang = new ArrayList<JLabel>();
		listKhachHang.add(ElementConstant.LBL_DELETE_KH_MAKH);
		listKhachHang.add(ElementConstant.LBL_DELETE_KH_TENKH);
		listKhachHang.add(ElementConstant.LBL_DELETE_KH_NGAYSINH);
		listKhachHang.add(ElementConstant.LBL_DELETE_KH_CCCD_HC);
		listKhachHang.add(ElementConstant.LBL_DELETE_KH_SDT);
		listKhachHang.add(ElementConstant.LBL_DELETE_KH_EMAIL);
		listKhachHang.add(ElementConstant.LBL_DELETE_KH_DIACHI);
		listKhachHang.add(ElementConstant.LBL_DELETE_KH_GIOITINH);
		listKhachHang.add(ElementConstant.LBL_DELETE_KH_MATOUR);
		listKhachHang.add(ElementConstant.LBL_DELETE_KH_MADV);
		listKhachHang.add(ElementConstant.LBL_DELETE_KH_TIENTOUR);

		return listKhachHang;
	}

	public static ArrayList<JTextField> getListTxtDeleteKhachHang() {
		ArrayList<JTextField> listKhachHang = new ArrayList<JTextField>();
		listKhachHang.add(ElementConstant.TXT_DELETE_KH_MAKH);
		listKhachHang.add(ElementConstant.TXT_DELETE_KH_TENKH);
		listKhachHang.add(ElementConstant.TXT_DELETE_KH_NGAYSINH);
		listKhachHang.add(ElementConstant.TXT_DELETE_KH_CCCD_HC);
		listKhachHang.add(ElementConstant.TXT_DELETE_KH_SDT);
		listKhachHang.add(ElementConstant.TXT_DELETE_KH_EMAIL);
		listKhachHang.add(ElementConstant.TXT_DELETE_KH_DIACHI);
		listKhachHang.add(ElementConstant.TXT_DELETE_KH_GIOITINH);
		listKhachHang.add(ElementConstant.TXT_DELETE_KH_MATOUR);
		listKhachHang.add(ElementConstant.TXT_DELETE_KH_MADV);
		listKhachHang.add(ElementConstant.TXT_DELETE_KH_TIENTOUR);

		return listKhachHang;
	}

	public static ArrayList<JLabel> getListLblDeleteHopDong() {
		ArrayList<JLabel> listHopDong = new ArrayList<JLabel>();
		listHopDong.add(ElementConstant.LBL_DELETE_HD_MAHD);
		listHopDong.add(ElementConstant.LBL_DELETE_HD_MAKH);
		listHopDong.add(ElementConstant.LBL_DELETE_HD_MANV);
		listHopDong.add(ElementConstant.LBL_DELETE_HD_THOIGIAN);
		listHopDong.add(ElementConstant.LBL_DELETE_HD_TONGTIEN);
		listHopDong.add(ElementConstant.LBL_DELETE_HD_TRANGTHAI);
		listHopDong.add(ElementConstant.LBL_DELETE_HD_GHICHU);

		return listHopDong;
	}

	public static ArrayList<JTextField> getListTxtDeleteHopDong() {
		ArrayList<JTextField> listHopDong = new ArrayList<JTextField>();
		listHopDong.add(ElementConstant.TXT_DELETE_HD_MAHD);
		listHopDong.add(ElementConstant.TXT_DELETE_HD_MAKH);
		listHopDong.add(ElementConstant.TXT_DELETE_HD_MANV);
		listHopDong.add(ElementConstant.TXT_DELETE_HD_THOIGIAN);
		listHopDong.add(ElementConstant.TXT_DELETE_HD_TONGTIEN);
		listHopDong.add(ElementConstant.TXT_DELETE_HD_TRANGTHAI);
		listHopDong.add(ElementConstant.TXT_DELETE_HD_GHICHU);

		return listHopDong;
	}

	public static ArrayList<JLabel> getListLblDeleteDichVu() {
		ArrayList<JLabel> listDichVu = new ArrayList<JLabel>();
		listDichVu.add(ElementConstant.LBL_DELETE_DV_MADV);
		listDichVu.add(ElementConstant.LBL_DELETE_DV_CHITIETDV);
		listDichVu.add(ElementConstant.LBL_DELETE_DV_PHUONGTIEN);
		listDichVu.add(ElementConstant.LBL_DELETE_DV_GIADV);

		return listDichVu;
	}

	public static ArrayList<JTextField> getListTxtDeleteDichVu() {
		ArrayList<JTextField> listDichVu = new ArrayList<JTextField>();
		listDichVu.add(ElementConstant.TXT_DELETE_DV_MADV);
		listDichVu.add(ElementConstant.TXT_DELETE_DV_CHITIETDV);
		listDichVu.add(ElementConstant.TXT_DELETE_DV_PHUONGTIEN);
		listDichVu.add(ElementConstant.TXT_DELETE_DV_GIADV);

		return listDichVu;
	}

	public static ArrayList<JLabel> getListLblDeleteTaiKhoan() {
		ArrayList<JLabel> listTaiKhoan = new ArrayList<JLabel>();
		listTaiKhoan.add(ElementConstant.LBL_DELETE_TK_MATK);
		listTaiKhoan.add(ElementConstant.LBL_DELETE_TK_MANV);
		listTaiKhoan.add(ElementConstant.LBL_DELETE_TK_TAIKHOAN);
		listTaiKhoan.add(ElementConstant.LBL_DELETE_TK_MATKHAU);

		return listTaiKhoan;
	}

	public static ArrayList<JTextField> getListTxtDeleteTaiKhoan() {
		ArrayList<JTextField> listTaiKhoan = new ArrayList<JTextField>();
		listTaiKhoan.add(ElementConstant.TXT_DELETE_TK_MATK);
		listTaiKhoan.add(ElementConstant.TXT_DELETE_TK_MANV);
		listTaiKhoan.add(ElementConstant.TXT_DELETE_TK_TAIKHOAN);
		listTaiKhoan.add(ElementConstant.TXT_DELETE_TK_MATKHAU);

		return listTaiKhoan;
	}

	public static ArrayList<JLabel> getListLblDeleteTourDuLich() {
		ArrayList<JLabel> listTour = new ArrayList<JLabel>();
		listTour.add(ElementConstant.LBL_DELETE_TDL_MATOUR);
		listTour.add(ElementConstant.LBL_DELETE_TDL_TENTOUR);
		listTour.add(ElementConstant.LBL_DELETE_TDL_MOTA);
		listTour.add(ElementConstant.LBL_DELETE_TDL_NOIDI);
		listTour.add(ElementConstant.LBL_DELETE_TDL_NGAYDI);
		listTour.add(ElementConstant.LBL_DELETE_TDL_SONGAY);
		listTour.add(ElementConstant.LBL_DELETE_TDL_GIATOUR);
		listTour.add(ElementConstant.LBL_DELETE_TDL_MADIADANH);
		listTour.add(ElementConstant.LBL_DELETE_TDL_TRANGTHAI);

		return listTour;
	}

	public static ArrayList<JTextField> getListTxtDeleteTourDuLich() {
		ArrayList<JTextField> listTour = new ArrayList<JTextField>();
		listTour.add(ElementConstant.TXT_DELETE_TDL_MATOUR);
		listTour.add(ElementConstant.TXT_DELETE_TDL_TENTOUR);
		listTour.add(ElementConstant.TXT_DELETE_TDL_MOTA);
		listTour.add(ElementConstant.TXT_DELETE_TDL_NOIDI);
		listTour.add(ElementConstant.TXT_DELETE_TDL_NGAYDI);
		listTour.add(ElementConstant.TXT_DELETE_TDL_SONGAY);
		listTour.add(ElementConstant.TXT_DELETE_TDL_GIATOUR);
		listTour.add(ElementConstant.TXT_DELETE_TDL_MADIADANH);
		listTour.add(ElementConstant.TXT_DELETE_TDL_TRANGTHAI);

		return listTour;
	}

	public static ArrayList<JLabel> getListLblDeleteNhanVien() {
		ArrayList<JLabel> listNhanVien = new ArrayList<JLabel>();
		listNhanVien.add(ElementConstant.LBL_DELETE_NV_MANV);
		listNhanVien.add(ElementConstant.LBL_DELETE_NV_TENNV);
		listNhanVien.add(ElementConstant.LBL_DELETE_NV_NGAYSINH);
		listNhanVien.add(ElementConstant.LBL_DELETE_NV_GIOITINH);
		listNhanVien.add(ElementConstant.LBL_DELETE_NV_SDT);
		listNhanVien.add(ElementConstant.LBL_DELETE_NV_EMAIL);
		listNhanVien.add(ElementConstant.LBL_DELETE_NV_DIACHI);
		return listNhanVien;
	}

	public static ArrayList<JTextField> getListTxtDeleteNhanVien() {
		ArrayList<JTextField> listNhanVien = new ArrayList<JTextField>();
		listNhanVien.add(ElementConstant.TXT_DELETE_NV_MANV);
		listNhanVien.add(ElementConstant.TXT_DELETE_NV_TENNV);
		listNhanVien.add(ElementConstant.TXT_DELETE_NV_NGAYSINH);
		listNhanVien.add(ElementConstant.TXT_DELETE_NV_GIOITINH);
		listNhanVien.add(ElementConstant.TXT_DELETE_NV_SDT);
		listNhanVien.add(ElementConstant.TXT_DELETE_NV_EMAIL);
		listNhanVien.add(ElementConstant.TXT_DELETE_NV_DIACHI);
		return listNhanVien;
	}

	public static ArrayList<JLabel> getListLblDeleteVe() {
		ArrayList<JLabel> listVe = new ArrayList<JLabel>();
		listVe.add(ElementConstant.LBL_DELETE_VX_MAVE);
		listVe.add(ElementConstant.LBL_DELETE_VX_MAKH);
		return listVe;
	}

	public static ArrayList<JTextField> getListTxtDeleteVe() {
		ArrayList<JTextField> listVe = new ArrayList<JTextField>();
		listVe.add(ElementConstant.TXT_DELETE_VX_MAVE);
		listVe.add(ElementConstant.TXT_DELETE_VX_MAKH);

		return listVe;
	}

	public static ArrayList<JLabel> getListLblModifyDiaDanh() {
		ArrayList<JLabel> listDiaDanh = new ArrayList<JLabel>();
		listDiaDanh.add(ElementConstant.LBL_MODIFY_DD_MADIADANH);
		listDiaDanh.add(ElementConstant.LBL_MODIFY_DD_TENDIADANH);
		listDiaDanh.add(ElementConstant.LBL_MODIFY_DD_TINHTHANH);

		return listDiaDanh;
	}

	public static ArrayList<JTextField> getListTxtModifyDiaDanh() {
		ArrayList<JTextField> listDiaDanh = new ArrayList<JTextField>();
		listDiaDanh.add(ElementConstant.TXT_MODIFY_DD_MADIADANH);
		listDiaDanh.add(ElementConstant.TXT_MODIFY_DD_TENDIADANH);
		listDiaDanh.add(ElementConstant.TXT_MODIFY_DD_TINHTHANH);

		return listDiaDanh;
	}

	public static ArrayList<JLabel> getListLblModifyKhachHang() {
		ArrayList<JLabel> listKhachHang = new ArrayList<JLabel>();
		listKhachHang.add(ElementConstant.LBL_MODIFY_KH_MAKH);
		listKhachHang.add(ElementConstant.LBL_MODIFY_KH_TENKH);
		listKhachHang.add(ElementConstant.LBL_MODIFY_KH_NGAYSINH);
		listKhachHang.add(ElementConstant.LBL_MODIFY_KH_CCCD_HC);
		listKhachHang.add(ElementConstant.LBL_MODIFY_KH_SDT);
		listKhachHang.add(ElementConstant.LBL_MODIFY_KH_EMAIL);
		listKhachHang.add(ElementConstant.LBL_MODIFY_KH_DIACHI);
		listKhachHang.add(ElementConstant.LBL_MODIFY_KH_GIOITINH);
		listKhachHang.add(ElementConstant.LBL_MODIFY_KH_MATOUR);
		listKhachHang.add(ElementConstant.LBL_MODIFY_KH_MADV);
		listKhachHang.add(ElementConstant.LBL_MODIFY_KH_TIENTOUR);

		return listKhachHang;
	}

	public static ArrayList<JTextField> getListTxtModifyKhachHang() {
		ArrayList<JTextField> listKhachHang = new ArrayList<JTextField>();
		listKhachHang.add(ElementConstant.TXT_MODIFY_KH_MAKH);
		listKhachHang.add(ElementConstant.TXT_MODIFY_KH_TENKH);
		listKhachHang.add(ElementConstant.TXT_MODIFY_KH_NGAYSINH);
		listKhachHang.add(ElementConstant.TXT_MODIFY_KH_CCCD_HC);
		listKhachHang.add(ElementConstant.TXT_MODIFY_KH_SDT);
		listKhachHang.add(ElementConstant.TXT_MODIFY_KH_EMAIL);
		listKhachHang.add(ElementConstant.TXT_MODIFY_KH_DIACHI);
		listKhachHang.add(ElementConstant.TXT_MODIFY_KH_GIOITINH);
		listKhachHang.add(ElementConstant.TXT_MODIFY_KH_MATOUR);
		listKhachHang.add(ElementConstant.TXT_MODIFY_KH_MADV);
		listKhachHang.add(ElementConstant.TXT_MODIFY_KH_TIENTOUR);

		return listKhachHang;
	}

	public static ArrayList<JLabel> getListLblModifyHopDong() {
		ArrayList<JLabel> listHopDong = new ArrayList<JLabel>();
		listHopDong.add(ElementConstant.LBL_MODIFY_HD_MAHD);
		listHopDong.add(ElementConstant.LBL_MODIFY_HD_MAKH);
		listHopDong.add(ElementConstant.LBL_MODIFY_HD_MANV);
		listHopDong.add(ElementConstant.LBL_MODIFY_HD_THOIGIAN);
		listHopDong.add(ElementConstant.LBL_MODIFY_HD_TONGTIEN);
		listHopDong.add(ElementConstant.LBL_MODIFY_HD_TRANGTHAI);
		listHopDong.add(ElementConstant.LBL_MODIFY_HD_GHICHU);

		return listHopDong;
	}

	public static ArrayList<JTextField> getListTxtModifyHopDong() {
		ArrayList<JTextField> listHopDong = new ArrayList<JTextField>();
		listHopDong.add(ElementConstant.TXT_MODIFY_HD_MAHD);
		listHopDong.add(ElementConstant.TXT_MODIFY_HD_MAKH);
		listHopDong.add(ElementConstant.TXT_MODIFY_HD_MANV);
		listHopDong.add(ElementConstant.TXT_MODIFY_HD_THOIGIAN);
		listHopDong.add(ElementConstant.TXT_MODIFY_HD_TONGTIEN);
		listHopDong.add(ElementConstant.TXT_MODIFY_HD_TRANGTHAI);
		listHopDong.add(ElementConstant.TXT_MODIFY_HD_GHICHU);

		return listHopDong;
	}

	public static ArrayList<JLabel> getListLblModifyDichVu() {
		ArrayList<JLabel> listDichVu = new ArrayList<JLabel>();
		listDichVu.add(ElementConstant.LBL_MODIFY_DV_MADV);
		listDichVu.add(ElementConstant.LBL_MODIFY_DV_CHITIETDV);
		listDichVu.add(ElementConstant.LBL_MODIFY_DV_PHUONGTIEN);
		listDichVu.add(ElementConstant.LBL_MODIFY_DV_GIADV);

		return listDichVu;
	}

	public static ArrayList<JTextField> getListTxtModifyDichVu() {
		ArrayList<JTextField> listDichVu = new ArrayList<JTextField>();
		listDichVu.add(ElementConstant.TXT_MODIFY_DV_MADV);
		listDichVu.add(ElementConstant.TXT_MODIFY_DV_CHITIETDV);
		listDichVu.add(ElementConstant.TXT_MODIFY_DV_PHUONGTIEN);
		listDichVu.add(ElementConstant.TXT_MODIFY_DV_GIADV);

		return listDichVu;
	}

	public static ArrayList<JLabel> getListLblModifyTaiKhoan() {
		ArrayList<JLabel> listTaiKhoan = new ArrayList<JLabel>();
		listTaiKhoan.add(ElementConstant.LBL_MODIFY_TK_MATK);
		listTaiKhoan.add(ElementConstant.LBL_MODIFY_TK_MANV);
		listTaiKhoan.add(ElementConstant.LBL_MODIFY_TK_TAIKHOAN);
		listTaiKhoan.add(ElementConstant.LBL_MODIFY_TK_MATKHAU);

		return listTaiKhoan;
	}

	public static ArrayList<JTextField> getListTxtModifyTaiKhoan() {
		ArrayList<JTextField> listTaiKhoan = new ArrayList<JTextField>();
		listTaiKhoan.add(ElementConstant.TXT_MODIFY_TK_MATK);
		listTaiKhoan.add(ElementConstant.TXT_MODIFY_TK_MANV);
		listTaiKhoan.add(ElementConstant.TXT_MODIFY_TK_TAIKHOAN);
		listTaiKhoan.add(ElementConstant.TXT_MODIFY_TK_MATKHAU);

		return listTaiKhoan;
	}

	public static ArrayList<JLabel> getListLblModifyTourDuLich() {
		ArrayList<JLabel> listTour = new ArrayList<JLabel>();
		listTour.add(ElementConstant.LBL_MODIFY_TDL_MATOUR);
		listTour.add(ElementConstant.LBL_MODIFY_TDL_TENTOUR);
		listTour.add(ElementConstant.LBL_MODIFY_TDL_MOTA);
		listTour.add(ElementConstant.LBL_MODIFY_TDL_NOIDI);
		listTour.add(ElementConstant.LBL_MODIFY_TDL_NGAYDI);
		listTour.add(ElementConstant.LBL_MODIFY_TDL_SONGAY);
		listTour.add(ElementConstant.LBL_MODIFY_TDL_GIATOUR);
		listTour.add(ElementConstant.LBL_MODIFY_TDL_MADIADANH);
		listTour.add(ElementConstant.LBL_MODIFY_TDL_TRANGTHAI);

		return listTour;
	}

	public static ArrayList<JTextField> getListTxtModifyTourDuLich() {
		ArrayList<JTextField> listTour = new ArrayList<JTextField>();
		listTour.add(ElementConstant.TXT_MODIFY_TDL_MATOUR);
		listTour.add(ElementConstant.TXT_MODIFY_TDL_TENTOUR);
		listTour.add(ElementConstant.TXT_MODIFY_TDL_MOTA);
		listTour.add(ElementConstant.TXT_MODIFY_TDL_NOIDI);
		listTour.add(ElementConstant.TXT_MODIFY_TDL_NGAYDI);
		listTour.add(ElementConstant.TXT_MODIFY_TDL_SONGAY);
		listTour.add(ElementConstant.TXT_MODIFY_TDL_GIATOUR);
		listTour.add(ElementConstant.TXT_MODIFY_TDL_MADIADANH);
		listTour.add(ElementConstant.TXT_MODIFY_TDL_TRANGTHAI);

		return listTour;
	}

	public static ArrayList<JLabel> getListLblModifyNhanVien() {
		ArrayList<JLabel> listNhanVien = new ArrayList<JLabel>();
		listNhanVien.add(ElementConstant.LBL_MODIFY_NV_MANV);
		listNhanVien.add(ElementConstant.LBL_MODIFY_NV_TENNV);
		listNhanVien.add(ElementConstant.LBL_MODIFY_NV_NGAYSINH);
		listNhanVien.add(ElementConstant.LBL_MODIFY_NV_GIOITINH);
		listNhanVien.add(ElementConstant.LBL_MODIFY_NV_SDT);
		listNhanVien.add(ElementConstant.LBL_MODIFY_NV_EMAIL);
		listNhanVien.add(ElementConstant.LBL_MODIFY_NV_DIACHI);
		return listNhanVien;
	}

	public static ArrayList<JTextField> getListTxtModifyNhanVien() {
		ArrayList<JTextField> listNhanVien = new ArrayList<JTextField>();
		listNhanVien.add(ElementConstant.TXT_MODIFY_NV_MANV);
		listNhanVien.add(ElementConstant.TXT_MODIFY_NV_TENNV);
		listNhanVien.add(ElementConstant.TXT_MODIFY_NV_NGAYSINH);
		listNhanVien.add(ElementConstant.TXT_MODIFY_NV_GIOITINH);
		listNhanVien.add(ElementConstant.TXT_MODIFY_NV_SDT);
		listNhanVien.add(ElementConstant.TXT_MODIFY_NV_EMAIL);
		listNhanVien.add(ElementConstant.TXT_MODIFY_NV_DIACHI);
		return listNhanVien;
	}

	public static ArrayList<JLabel> getListLblModifyVe() {
		ArrayList<JLabel> listVe = new ArrayList<JLabel>();
		listVe.add(ElementConstant.LBL_MODIFY_VX_MAVE);
		listVe.add(ElementConstant.LBL_MODIFY_VX_MAKH);
		return listVe;
	}

	public static ArrayList<JTextField> getListTxtModifyVe() {
		ArrayList<JTextField> listVe = new ArrayList<JTextField>();
		listVe.add(ElementConstant.TXT_MODIFY_VX_MAVE);
		listVe.add(ElementConstant.TXT_MODIFY_VX_MAKH);

		return listVe;
	}

}
