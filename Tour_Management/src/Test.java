import utils.PasswordEncoder;

public class Test {

	public static void main(String args[]) {
		String pass = "LeMinhBao21007881";
		String code = PasswordEncoder.hashPassword(pass);
		System.out.println(code);
		System.out.println(PasswordEncoder.checkPassword(pass, code));
	}
}
