package controllers;

import DAO.DAO_NhanVien;
import DAO.DAO_TaiKhoan;
import entity.NhanVien;
import entity.TaiKhoan;
import utils.PasswordEncoder;

public class CtrlLogin {

    /**
     * Kiểm tra mật khẩu đăng nhập
     * 
     * @author Le Minh Bao
     * 
     * @param username Mã nhân viên
     * @param password Mật khẩu
     * @return <b>True</b> Nếu tài khoản và mật khẩu đúng <br>
     *         <b>False</b> Nếu tài khoản hoặc mật khẩu sai
     */
    public static boolean checkLoginStatus(String username, String password) {
	TaiKhoan account = DAO_TaiKhoan.timKiemTaiKhoan(username);
	if (account == null)
	    return false;
	if (PasswordEncoder.checkPassword(password, account.getMatKhau()))
	    return true;
	else
	    return false;
    }

    /**
     * Kiểm tra quyền hạn của người đăng nhập
     * 
     * @author Le Minh Bao
     * 
     * @param username Mã nhân viên
     * @return <b>0</b> Nếu không tồm tại mã nhân viên <br>
     *         <b>1</b> Nếu là quản lý <br>
     *         <b>2</b> Nếu là nhân viên
     */
    public static int checkAccountType(String username) {
	NhanVien account = DAO_NhanVien.timKiemNhanVien(username);
	if (account == null)
	    return 0;
	if (account.getChucVu().equalsIgnoreCase("quản lý kinh doanh"))
	    return 1;
	if (account.getChucVu().equalsIgnoreCase("nhân viên bán hàng"))
	    return 2;
	return 0;
    }
}
