package connect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import utils.constants.DatabaseConstant;

public class ConnnectDB {
	public static Connection con = null;
	private static ConnnectDB instance = new ConnnectDB();

	public static ConnnectDB getInstance() {
		return instance;
	}

	public static void connect() throws SQLException {
		String url = DatabaseConstant.DB_URL;
		String user = DatabaseConstant.USER;
		String password = DatabaseConstant.PASS;
		con = DriverManager.getConnection(url, user, password);
	}

	public void disconnect() {
		if (con != null)
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}

	public static Connection getConnection() {
		return con;
	}
}
