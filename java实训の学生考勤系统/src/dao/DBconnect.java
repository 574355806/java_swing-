package dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBconnect {
	Connection conn = null;

	public Connection getConn() {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(
					"jdbc:sqlserver://localhost:1433;database=Student","sa","123");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}

}
