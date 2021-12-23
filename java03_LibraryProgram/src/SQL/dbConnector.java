package SQL;

import java.sql.*;

public class dbConnector {
	Connection conn;
	Statement stmt = null;

	public dbConnector() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://jdb.deu.mopnster:60001/j20183087", "20183087",
					"!!!!20183087");
			System.out.println("DB����Ϸ�");
			stmt = conn.createStatement();
		} catch (ClassNotFoundException e) {
			System.out.println("JDBC ����̹� �ε� ����");
		} catch (SQLException e) {
			System.out.println("DB���� ����");
		}
	}

	public ResultSet executeQuery(String sql) {
		ResultSet src = null;
		try {
			src = stmt.executeQuery(sql);
		} catch (SQLException e) {
			System.out.println(src);
			System.out.println("SQL ���� ����");
			return null;
		}
		return src;
	}

	public Connection getConnection() {
		if (conn != null) {
			return conn;
		} else {
			return null;
		}
	}
}
