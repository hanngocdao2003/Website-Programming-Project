package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtils {
	public static final Connection getConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://" + DbProperty.getHost() + ":" + DbProperty.getPort()+"/" + DbProperty.getName();
			Connection connection = DriverManager.getConnection(url, DbProperty.getUser(), DbProperty.getPass());
			return connection;
		} catch (SQLException ex) {
			ex.printStackTrace();
		} catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return null;
	}

}
