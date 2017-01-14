package gui;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.PreparedStatement;

public class DbConnection {

	public static Statement st;
	public static Connection con;
	
	public DbConnection()
	{
		connect();
	}
	
	private void connect() {
		try{

			String db = "jdbc:mysql://localhost:3306/bankingsystem?mautoReconnect=true&useSSL=false";
			String username = "root";
			String password = "3161928";
			
			con = DriverManager.getConnection(db, username, password);
			st = con.createStatement();
			System.out.println("DATABASE ACCESS!");
			
		} catch(SQLException e){
			throw new IllegalStateException("Cannot connect the database!",e);
		}
	}
}
