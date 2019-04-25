package Service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Database {
	public static Statement selectStatement = null;
	public static ResultSet results = null;
	public static Connection cn = null;

	public static Connection getConnection() {
		final String URL = "jdbc:mysql://127.0.0.1:3306/mydb?serverTimezone=Asia/Seoul";
		final String USER = "root";
		final String PASS = "lapapa88";

		try {

			Connection conn = DriverManager.getConnection(URL, USER, PASS);

			return conn;

		} catch (Exception e) {
			System.out.println("error!" + e.getMessage());
		} finally {
			if (selectStatement != null && cn != null && results != null) {
				try {
					selectStatement.close();
					cn.close();
					results.close();

				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
			}

		}
		return null;

	}
}
