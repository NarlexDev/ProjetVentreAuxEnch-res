package fr.eni.dal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCTools {
	public static Connection getConnexion() {
		Connection cnx = null;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			String url= "jdbc:sqlserver://localhost:1433;databasename="
					+ "BDDUSER;user=sa;password=Pa$$w0rd";
			
			cnx = DriverManager.getConnection(url);
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return cnx;
		
	}
}
