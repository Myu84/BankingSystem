package gui;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class ActionAccount {

	private String username;
	private String accountNumber;
	private String modifiedDate;

	public ActionAccount(String username, String accountNumber){

		this.username = username;
		this.accountNumber = accountNumber;
	}

	public void withdraw(String accountType,double transAmount){

		DbConnection db = new DbConnection();//create connection
		ResultSet rs;
		Statement st = db.st;
		transAmount = transAmount * -1;//convert amount into negative value
		
		modifiedDate= new SimpleDateFormat("yyyyMMdd").format(new Date());

		String withdrawChequing = "INSERT INTO transaction_chequing(accountNumber, amount, transDate) VALUE(" 
				+ username + ","+ transAmount + "," + modifiedDate + ")"; // transaction record

		String wizdrwCheBalance = "UPDATE chequing SET balance = balance + " 
				+ "'" + transAmount +"'" +" WHERE accountNumber = " + username ; //update balance of chequing account after withdraw

		String withdrawSaving = "INSERT INTO transaction_saving(accountNumber, amount, transDate) VALUE(" 
				+ username + ","+ transAmount + "," + modifiedDate + ")"; // transaction record

		String wizdrwSavBalance = "UPDATE saving SET balance = balance + " 
				+ "'" + transAmount +"'" +" WHERE accountNumber = " + username ; //update balance of saving account after withdraw


		try {
			// if account is chequing then act on chequing
			if(accountType == "Chequing Account"){
				st.executeUpdate(withdrawChequing);
				st.executeUpdate(wizdrwCheBalance);
				//DisplayInfo dis = new DisplayInfo(username, accountNumber,firstname,lastname,savingBalance,chequingBalance);
			}
			// if account is saving then act on saving
			if(accountType == "Saving Account"){
				st.executeUpdate(withdrawSaving);
				st.executeUpdate(wizdrwSavBalance);
				//DisplayInfo dis = new DisplayInfo(username, accountNumber,firstname,lastname,savingBalance,chequingBalance);
			}

		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
		try {
			db.con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void deposit(String accountType,double transAmount){

		DbConnection db = new DbConnection();//create connection
		ResultSet rs;
		Statement st = db.st;

		modifiedDate= new SimpleDateFormat("yyyyMMdd").format(new Date());

		String depositChequing = "INSERT INTO transaction_chequing(accountNumber, amount, transDate) VALUE(" 
				+ username + ","+ transAmount + "," + modifiedDate + ")"; // transaction record

		String depoCheBalance = "UPDATE chequing SET balance = balance + " 
				+ "'" + transAmount +"'" +" WHERE accountNumber = " + username ; //update balance of chequing account after withdraw

		String depositSaving = "INSERT INTO transaction_saving(accountNumber, amount, transDate) VALUE(" 
				+ username + ","+ transAmount + "," + modifiedDate + ")"; // transaction record

		String depoSavBalance = "UPDATE saving SET balance = balance + " 
				+ "'" + transAmount +"'" +" WHERE accountNumber = " + username ; //update balance of saving account after withdraw

		try {
			// if account is chequing then act on chequing
			if(accountType == "Chequing Account"){
				st.executeUpdate(depositChequing);
				st.executeUpdate(depoCheBalance);
				//DisplayInfo dis = new DisplayInfo(username, accountNumber,firstname,lastname,savingBalance,chequingBalance);
			}
			// if account is saving then act on saving
			if(accountType == "Saving Account"){
				st.executeUpdate(depositSaving);
				st.executeUpdate(depoSavBalance);
				//DisplayInfo dis = new DisplayInfo(username, accountNumber,firstname,lastname,savingBalance,chequingBalance);
			}
			//depositAmount.setText("");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		try {
			db.con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void newAccount(String customerId, String password){
		DbConnection db = new DbConnection();//create connection
		ResultSet rs;
		Statement st = db.st;
		
		String newAcc = "INSERT INTO account VALUES('"+ accountNumber + "','" + password + "','" + customerId + "')";
		
		try {
			st.executeUpdate(newAcc);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void newChequing(String accountNumber, double balance){
		DbConnection db = new DbConnection();//create connection
		ResultSet rs;
		Statement st = db.st;
		
		String newChequing = "INSERT INTO chequing VALUES('"+accountNumber+"',"+ balance+")";
		
		try {
			st.executeUpdate(newChequing);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void newSaving(String accountNumber, double balance){
		DbConnection db = new DbConnection();//create connection
		ResultSet rs;
		Statement st = db.st;
		
		String newSaving = "INSERT INTO saving VALUES('"+accountNumber+"',"+ balance+")";
		
		try {
			st.executeUpdate(newSaving);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void closeChequing(String accountNumber){
		DbConnection db = new DbConnection();//create connection
		ResultSet rs;
		Statement st = db.st;
		
		String closeChequing = "DELETE FROM chequing WHERE accountNumber ='" + accountNumber+"'";
		
		try {
			st.executeUpdate(closeChequing);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void closeSaving(String accountNumber){
		DbConnection db = new DbConnection();//create connection
		ResultSet rs;
		Statement st = db.st;
		
		String closeSaving = "DELETE FROM saving WHERE accountNumber ='" + accountNumber+"'";
		
		try {
			st.executeUpdate(closeSaving);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}