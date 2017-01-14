package gui;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Customer {

	private String customerId; //primary key
	private String customerFirstName;
	private String customerLastName;
	
	public Customer(String customerId, String customerFirstName, String customerLastName){
		this.customerId = customerId;
		this.customerFirstName = customerFirstName;
		this.customerLastName = customerLastName;
	}
	
	public void insert(){
		DbConnection db = new DbConnection();//create connection
		ResultSet rs;
		Statement st = db.st;
		
		String newCustomer = "INSERT INTO customer VALUES("+ customerId + ",'"+ customerFirstName + "','" + customerLastName + "')";
		try {
			st.executeUpdate(newCustomer);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}