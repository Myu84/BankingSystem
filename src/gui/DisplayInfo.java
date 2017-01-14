package gui;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JLabel;

public class DisplayInfo {

	public DisplayInfo(String username,JLabel accountNumber, JLabel firstname, JLabel lastname, JLabel savingBalance, JLabel chequingBalance){

		initialize(username, accountNumber,firstname,lastname,savingBalance,chequingBalance);
	}

	public void initialize(String username,JLabel accountNumber, JLabel firstname, JLabel lastname, JLabel savingBalance, JLabel chequingBalance){
		DbConnection db = new DbConnection();//create connection
		ResultSet rs;
		Statement st = db.st;

		accountNumber.setText(String.valueOf(username)); // set account number = username(from previous page)

		String searchChequing = "SELECT chequing.balance AS chequingBalance "
				+ "From chequing where accountNumber = " + username;

		String searchSaving = "SELECT saving.balance AS savingBalance "
				+ "From saving where accountNumber = " + username;

		String searchFirstName ="SELECT customerFirstname FROM customer, account "
				+ "WHERE customer.customerId = account.customerId AND accountNumber = " + username;

		String searchLastname ="SELECT customerLastname FROM customer, account "
				+ "WHERE customer.customerId = account.customerId AND accountNumber = " + username;

		//set chequing and saving balance (这一大段可以新建class 减少重复)
		try {

			//set first name
			rs = st.executeQuery(searchFirstName);
			while(rs.next()){
				String fname =  rs.getString("customerFirstname");
				firstname.setText(fname);
			}
			rs.close();

			//set last name
			rs = st.executeQuery(searchLastname);
			while(rs.next()){
				String lname =  rs.getString("customerLastname");
				lastname.setText(lname);
			}
			rs.close();

			//set chequing balance
			rs = st.executeQuery(searchChequing);
			while(rs.next()){
				double cheBalance =  rs.getDouble("chequingBalance");
				chequingBalance.setText("$" +String.valueOf(cheBalance));
			}
			rs.close();

			//set saving balance
			rs = st.executeQuery(searchSaving);
			while(rs.next()){
				double savBalance = rs.getDouble("savingBalance");
				savingBalance.setText("$" + String.valueOf(savBalance));
			}
			rs.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
