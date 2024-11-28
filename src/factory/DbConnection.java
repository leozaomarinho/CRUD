package factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {

	private static final String URL = "jdbc:mysql://localhost:3306/meuBanco";
	private static final String USER = "service";
	private static final String PASSWORD = "service2024";
	
	public static Connection getConnection() {
		try {
			return DriverManager.getConnection(URL,USER,PASSWORD);
		}
		catch(SQLException e) {
			System.err.println("Erro ao conectar: "+ e.getMessage());
		}
		return null;
	}
}
