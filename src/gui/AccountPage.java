package gui;

import java.awt.EventQueue;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import connection.ABA;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import java.awt.SystemColor;
import java.awt.Font;
import java.awt.Color;

public class AccountPage {

	JFrame frame;
	private JTextField withdrawAmount;
	private JTextField depositAmount;

	private static String username;
	
	/**
	 * Create the application.
	 */
	public AccountPage(String username) {
		initialize(username);
	}

	DbConnection db = new DbConnection();//create connection
	ResultSet rs;
	Statement st = db.st;
	private JTextField transAmount;

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(String username) {
		frame = new JFrame();
		frame.getContentPane().setBackground(SystemColor.inactiveCaption);
		frame.setTitle("Customer Account");
		frame.setResizable(false);
		frame.setBounds(100, 100, 800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JSeparator separator = new JSeparator();
		separator.setBounds(12, 140, 770, 2);
		frame.getContentPane().add(separator);

		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(12, 284, 770, 2);
		frame.getContentPane().add(separator_1);

		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(12, 426, 770, 2);
		frame.getContentPane().add(separator_2);

		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.control);
		panel.setBounds(12, 10, 770, 120);
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lblAccountNumber = new JLabel("Account Number:");
		lblAccountNumber.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 12));
		lblAccountNumber.setBounds(10, 10, 110, 17);
		panel.add(lblAccountNumber);

		JLabel accountNumber = new JLabel("DISPLAY ACC#");
		accountNumber.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 12));
		accountNumber.setBounds(130, 10, 100, 17);
		panel.add(accountNumber);

		JLabel lblCustomerName = new JLabel("Customer Name:");
		lblCustomerName.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 12));
		lblCustomerName.setBounds(10, 37, 110, 17);
		panel.add(lblCustomerName);

		JLabel firstname = new JLabel("FIRSTNAME");
		firstname.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 12));
		firstname.setBounds(130, 37, 75, 17);
		panel.add(firstname);

		JLabel lastname = new JLabel("LASTNAME");
		lastname.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 12));
		lastname.setBounds(215, 37, 75, 17);
		panel.add(lastname);

		JLabel lblChequingBalance = new JLabel("Chequing Balance:");
		lblChequingBalance.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 12));
		lblChequingBalance.setBounds(10, 64, 110, 17);
		panel.add(lblChequingBalance);

		JLabel chequingBalance = new JLabel("No Chequing Account");
		chequingBalance.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 12));
		chequingBalance.setBounds(130, 64, 135, 17);
		panel.add(chequingBalance);

		JLabel lblSavingBalance = new JLabel("Saving Balance:");
		lblSavingBalance.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 12));
		lblSavingBalance.setBounds(10, 91, 110, 17);
		panel.add(lblSavingBalance);

		JLabel savingBalance = new JLabel("No Saving Account");
		savingBalance.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 12));
		savingBalance.setBounds(130, 91, 110, 17);
		panel.add(savingBalance);

		// display information from account
		DisplayInfo info = new DisplayInfo(username, accountNumber,firstname,lastname,savingBalance,chequingBalance);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(SystemColor.control);
		panel_1.setBounds(12, 154, 380, 120);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);

		JLabel lblWithdrawFromAccount = new JLabel("Withdraw from Account");
		lblWithdrawFromAccount.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 12));
		lblWithdrawFromAccount.setBounds(10, 10, 150, 17);
		panel_1.add(lblWithdrawFromAccount);

		JLabel lblAmount = new JLabel("Amount ($)");
		lblAmount.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 12));
		lblAmount.setBounds(10, 51, 63, 17);
		panel_1.add(lblAmount);

		JComboBox withdrawBox = new JComboBox();
		withdrawBox.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 12));
		withdrawBox.setBounds(170, 7, 200, 23);
		panel_1.add(withdrawBox);
		withdrawBox.setModel(new DefaultComboBoxModel(new String[] {"Chequing Account", "Saving Account"}));

		withdrawAmount = new JTextField();
		withdrawAmount.setBounds(170, 48, 200, 23);
		panel_1.add(withdrawAmount);
		withdrawAmount.setColumns(10);

		JButton btnWithdraw = new JButton("Finish");
		btnWithdraw.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 12));
		btnWithdraw.setBounds(269, 85, 101, 25);
		panel_1.add(btnWithdraw);

		// withdraw button
		btnWithdraw.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String accNum = accountNumber.getText();
				String accountType = (String) withdrawBox.getSelectedItem(); //show which account to withdraw from 
				double transAmount = Double.parseDouble(withdrawAmount.getText());// show withdraw amount
				
				ActionAccount acc = new ActionAccount(username, accNum);
				acc.withdraw(accountType, transAmount);
			
				withdrawAmount.setText("");
				
				DisplayInfo info = new DisplayInfo(username, accountNumber,firstname,lastname,savingBalance,chequingBalance);
			}
		});

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(SystemColor.control);
		panel_2.setBounds(402, 154, 380, 120);
		frame.getContentPane().add(panel_2);
		panel_2.setLayout(null);

		JLabel lblNewLabel_2 = new JLabel("Deposit into Account");
		lblNewLabel_2.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 12));
		lblNewLabel_2.setBounds(10, 10, 135, 17);
		panel_2.add(lblNewLabel_2);

		JLabel lblAmount_1 = new JLabel("Amount($)");
		lblAmount_1.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 12));
		lblAmount_1.setBounds(10, 51, 60, 17);
		panel_2.add(lblAmount_1);

		JComboBox depositBox = new JComboBox();
		depositBox.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 12));
		depositBox.setBounds(170, 7, 200, 23);
		panel_2.add(depositBox);
		depositBox.setModel(new DefaultComboBoxModel(new String[] {"Chequing Account", "Saving Account"}));

		depositAmount = new JTextField();
		depositAmount.setBounds(170, 48, 200, 23);
		panel_2.add(depositAmount);
		depositAmount.setColumns(10);

		JButton btnDeposit = new JButton("Finish");
		btnDeposit.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 12));
		btnDeposit.setBounds(269, 85, 101, 25);
		panel_2.add(btnDeposit);

		//Deposit Button
		btnDeposit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String accNum = accountNumber.getText();
				String accountType = (String) depositBox.getSelectedItem(); //show which account to withdraw from 
				double transAmount = Double.parseDouble(depositAmount.getText());// show withdraw amount
				
				ActionAccount acc = new ActionAccount(username, accNum);
				acc.deposit(accountType, transAmount);
			
				depositAmount.setText("");
				
				DisplayInfo info = new DisplayInfo(username, accountNumber,firstname,lastname,savingBalance,chequingBalance);
			}
		});

		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBackground(SystemColor.control);
		panel_3.setBounds(12, 296, 770, 120);
		frame.getContentPane().add(panel_3);

		JLabel lblTransferFrom = new JLabel("Transfer From");
		lblTransferFrom.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 12));
		lblTransferFrom.setBounds(10, 10, 135, 17);
		panel_3.add(lblTransferFrom);

		JLabel lblTransAmount = new JLabel("Amount($)");
		lblTransAmount.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 12));
		lblTransAmount.setBounds(10, 51, 60, 17);
		panel_3.add(lblTransAmount);

		JLabel lblTo = new JLabel("To");
		lblTo.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 12));
		lblTo.setBounds(412, 10, 135, 17);
		panel_3.add(lblTo);

		transAmount = new JTextField();
		transAmount.setColumns(10);
		transAmount.setBounds(170, 48, 200, 23);
		panel_3.add(transAmount);

		JComboBox transFromBox = new JComboBox();
		transFromBox.setModel(new DefaultComboBoxModel(new String[] {"Chequing Account", "Saving Account"}));
		transFromBox.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 12));
		transFromBox.setBounds(170, 7, 200, 23);
		panel_3.add(transFromBox);

		JComboBox transToBox = new JComboBox();
		transToBox.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 12));
		transToBox.setBounds(557, 7, 200, 23);
		panel_3.add(transToBox);
		
		// set constrain for Tobox
		transFromBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if((String) transFromBox.getSelectedItem() == "Chequing Account"){
					transToBox.setModel(new DefaultComboBoxModel(new String[] {"Saving Account"}));
				}
				if((String) transFromBox.getSelectedItem() == "Saving Account"){
					transToBox.setModel(new DefaultComboBoxModel(new String[] {"Chequing Account"}));
				}
			}
		});
		
		transFromBox.setSelectedIndex(0);
		transToBox.setSelectedIndex(0);
		
		System.out.println((String) transFromBox.getSelectedItem());
		System.out.println((String) transToBox.getSelectedItem());
		
		JButton btnTrans = new JButton("Finish");
		btnTrans.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 12));
		btnTrans.setBounds(656, 85, 101, 25);
		panel_3.add(btnTrans);

		
		// make transfer
		btnTrans.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				String accNum = accountNumber.getText();
				String accountTypeFrom = (String) transFromBox.getSelectedItem(); //show which account to withdraw from 
				String accountTypeTo = (String) transToBox.getSelectedItem(); //show which account to withdraw from 
				double trans = Double.parseDouble(transAmount.getText());// show withdraw amount
				
				ActionAccount accWith = new ActionAccount(username, accNum);
				accWith.withdraw(accountTypeFrom, trans);
				
				ActionAccount accDepo = new ActionAccount(username, accNum);
				accDepo.deposit(accountTypeTo, trans);
			
				transAmount.setText("");
				
				DisplayInfo info = new DisplayInfo(username, accountNumber,firstname,lastname,savingBalance,chequingBalance);
			}
		});
		

		JButton btnLogOut = new JButton("LOG OUT");
		btnLogOut.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 12));
		btnLogOut.setBounds(681, 537, 101, 25);
		frame.getContentPane().add(btnLogOut);
		
		JPanel panel_4 = new JPanel();
		panel_4.setLayout(null);
		panel_4.setBounds(12, 438, 592, 120);
		frame.getContentPane().add(panel_4);
		
		JLabel lblPrintTransAction = new JLabel("Show Transaction");
		lblPrintTransAction.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 12));
		lblPrintTransAction.setBounds(10, 10, 99, 15);
		panel_4.add(lblPrintTransAction);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 12));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Chequing Account", "Saving Account"}));
		comboBox.setBounds(170, 7, 200, 23);
		panel_4.add(comboBox);
		
		JButton btnFinish = new JButton("Finish");
		btnFinish.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 12));
		btnFinish.setBounds(481, 85, 101, 25);
		panel_4.add(btnFinish);

		//log out button
		btnLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				LoginPage window = new LoginPage();
				window.frame.setVisible(true);
			}
		});
	}
}

