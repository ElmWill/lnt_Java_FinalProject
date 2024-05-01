package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DatabaseConnection {
	public Connection connection;
	public Statement statement;
	
	public DatabaseConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/pudding","root","");
			statement = connection.createStatement();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void createMenusTable() {
		String query = "CREATE TABLE IF NOT EXIST Menu("
				+ "MenuID INT AUTO_INCREMENT PRIMARY KEY,"
				+ "Nama VARCHAR(50) NOT NULL,"
				+ "Harga VARCHAR(50) NOT NULL,"
				+ "Stock INT"
				+ ")";
		try {
			exec(query);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void migrateTable() {
		createMenusTable();
	}
	
	public void exec(String query) {
		try {
			statement.execute(query);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
