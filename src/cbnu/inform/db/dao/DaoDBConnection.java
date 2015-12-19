package cbnu.inform.db.dao;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;

public class DaoDBConnection {

	public static Connection tryConnect() {

		String url = "jdbc:mysql://localhost";
		String id = "root";
		String password = "apmsetup";

		Connection con = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("driver success");
			con = DriverManager.getConnection(url, id, password);
			System.out.println("databases connection success");

		} catch (ClassNotFoundException e) {
			System.out.println("no found driver");

		} catch (SQLException e) {
			System.out.println("connection fail");

		}
		return con;

	}

}
