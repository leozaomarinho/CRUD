package factory;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DbConnection {
	public static Connection getConnection() throws SQLException,IOException {
		Properties props = new Properties();
		try(FileInputStream fis = new FileInputStream("dbconfig.properties")) {
			props.load(fis);
		}
		
		String url = props.getProperty("db.url");
		String user = props.getProperty("db.user");
		String password = props.getProperty("db.password");
		
		return DriverManager.getConnection(url,user,password);
	
	}
}
