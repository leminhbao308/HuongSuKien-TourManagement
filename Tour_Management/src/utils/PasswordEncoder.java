package utils;

import org.mindrot.jbcrypt.BCrypt;

/**
 * Lớp mã hóa và kiểm tra Mật khẩu để bảo mật
 * 
 * @author LeMinhBao
 */
public class PasswordEncoder {

	/**
	 * Hàm mã hóa mật khẩu
	 * 
	 * @param plainTextPassword Chuỗi mật khẩu cần mã hóa
	 * @return Chuỗi mật khẩu đã được mã hóa
	 */
	public static String hashPassword(String plainTextPassword) {
		String salt = BCrypt.gensalt();
		return BCrypt.hashpw(plainTextPassword, salt);
	}

	/**
	 * Kiểm tra mật khẩu với mật khẩu được mã hóa
	 * 
	 * @param plainTextPassword Chuỗi mật khẩu cần kiểm tra
	 * @param hashedPassword    Chuỗi mật khẩu gốc được mã hóa
	 * @return <b>True</b> nếu mật khẩu trùng khớp với mật khẩu
	 *         được mã hóa, <b>False</b> nếu mật khẩu không trùng
	 *         khớp
	 */
	public static boolean checkPassword(String plainTextPassword, String hashedPassword) {
		return BCrypt.checkpw(plainTextPassword, hashedPassword);
	}
}
