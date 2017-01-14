package connection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;

import gui.Customer;
import gui.DbConnection;

public class Test {

	public static void main(String[] args) {
		String accNum = "200";
		String customerId = "123";
		String firstname = "what";
		String lastname = "Geoge";
		Customer cus = new Customer(customerId,"what",lastname);
		
		cus.insert();
		
		
	}

}
