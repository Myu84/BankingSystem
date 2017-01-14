package gui;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.JPanel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.SystemColor;
import java.awt.Font;

public class ManagerCustomerAccount {

	JFrame frame;

	private String username;
	private String managerName;
	private JTextField withdrawAmount;
	private JTextField depositAmount;

	/**
	 * Create the application.
	 */
	public ManagerCustomerAccount(String username, String managerName) {
		this.username = username;
		this.managerName = managerName;
		initialize();
	}

	DbConnection db = new DbConnection();//create connection
	ResultSet rs;
	Statement st = db.st;
	private JTextField transAmount;

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(SystemColor.inactiveCaption);
		frame.setTitle(managerName + ": Under" + username +"'s Account");
		frame.setResizable(false);
		frame.setBounds(100, 100, 800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JSeparator separator = new JSeparator();
		separator.setBounds(12, 142, 770, 2);
		frame.getContentPane().add(separator);

		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(12, 284, 770, 2);
		frame.getContentPane().add(separator_1);

		JButton btnLogOut = new JButton("LOG OUT");
		btnLogOut.setBounds(681, 533, 101, 25);
		frame.getContentPane().add(btnLogOut);

		JButton btnBack = new JButton("BACK");
		btnBack.setBounds(568, 533, 101, 25);
		frame.getContentPane().add(btnBack);

		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(12, 426, 772, 2);
		frame.getContentPane().add(separator_2);

		JPanel panel_2 = new JPanel();
		panel_2.setForeground(SystemColor.control);
		panel_2.setBounds(12, 10, 770, 120);
		frame.getContentPane().add(panel_2);
		panel_2.setLayout(null);

		JLabel lblAccountNumber = new JLabel("Account Number:");
		lblAccountNumber.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 12));
		lblAccountNumber.setBounds(10, 10, 110, 17);
		panel_2.add(lblAccountNumber);

		JLabel accountNumber = new JLabel("DISPLAY ACC#");
		accountNumber.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 12));
		accountNumber.setBounds(130, 10, 100, 17);
		panel_2.add(accountNumber);

		JLabel lblCustomerName = new JLabel("Customer Name:");
		lblCustomerName.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 12));
		lblCustomerName.setBounds(10, 37, 110, 17);
		panel_2.add(lblCustomerName);

		JLabel lblChequingBalance = new JLabel("Chequing Balance:");
		lblChequingBalance.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 12));
		lblChequingBalance.setBounds(10, 64, 110, 17);
		panel_2.add(lblChequingBalance);

		JLabel lblNewLabel_1 = new JLabel("Saving Balance:");
		lblNewLabel_1.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(10, 91, 110, 17);
		panel_2.add(lblNewLabel_1);

		JLabel firstname = new JLabel("FIRSTNAME");
		firstname.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 12));
		firstname.setBounds(130, 37, 75, 17);
		panel_2.add(firstname);

		JLabel lastname = new JLabel("LASTNAME");
		lastname.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 12));
		lastname.setBounds(215, 37, 75, 17);
		panel_2.add(lastname);

		JLabel chequingBalance = new JLabel("No Chequing Account");
		chequingBalance.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 12));
		chequingBalance.setBounds(130, 64, 135, 17);
		panel_2.add(chequingBalance);

		JLabel savingBalance = new JLabel("No Saving Account");
		savingBalance.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 12));
		savingBalance.setBounds(130, 91, 110, 17);
		panel_2.add(savingBalance);

		// display infomation for the page
		DisplayInfo info = new DisplayInfo(username, accountNumber,firstname,lastname,savingBalance,chequingBalance);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(402, 154, 380, 120);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);

		JLabel label = new JLabel("Deposit into Account");
		label.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 12));
		label.setBounds(10, 10, 135, 17);
		panel_1.add(label);

		JComboBox depositBox = new JComboBox();
		depositBox.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 12));
		depositBox.setModel(new DefaultComboBoxModel(new String[] {"Chequing Account", "Saving Account"}));
		depositBox.setBounds(170, 7, 195, 23);
		panel_1.add(depositBox);

		depositAmount = new JTextField();
		depositAmount.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 12));
		depositAmount.setColumns(10);
		depositAmount.setBounds(170, 48, 195, 23);
		panel_1.add(depositAmount);

		JLabel label_1 = new JLabel("Amount");
		label_1.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 12));
		label_1.setBounds(10, 51, 58, 17);
		panel_1.add(label_1);

		JButton btnDeposit = new JButton("Finish");
		btnDeposit.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 12));
		btnDeposit.setBounds(264, 85, 101, 25);
		panel_1.add(btnDeposit);

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

		JPanel panel_4 = new JPanel();
		panel_4.setLayout(null);
		panel_4.setBackground(SystemColor.menu);
		panel_4.setBounds(12, 296, 770, 120);
		frame.getContentPane().add(panel_4);

		JLabel label_4 = new JLabel("Transfer From");
		label_4.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 12));
		label_4.setBounds(10, 10, 135, 17);
		panel_4.add(label_4);

		JLabel label_5 = new JLabel("Amount($)");
		label_5.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 12));
		label_5.setBounds(10, 51, 60, 17);
		panel_4.add(label_5);

		JLabel label_6 = new JLabel("To");
		label_6.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 12));
		label_6.setBounds(412, 10, 135, 17);
		panel_4.add(label_6);

		transAmount = new JTextField();
		transAmount.setColumns(10);
		transAmount.setBounds(170, 48, 200, 23);
		panel_4.add(transAmount);

		JComboBox transFromBox = new JComboBox();
		transFromBox.setModel(new DefaultComboBoxModel(new String[] {"Chequing Account", "Saving Account"}));
		//comboBox_2.setSelectedIndex(0);
		transFromBox.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 12));
		transFromBox.setBounds(170, 7, 200, 23);
		panel_4.add(transFromBox);

		JComboBox transToBox = new JComboBox();
		//comboBox_3.setSelectedIndex(0);
		transToBox.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 12));
		transToBox.setBounds(557, 7, 200, 23);
		panel_4.add(transToBox);

		JButton btnTrans = new JButton("Finish");
		btnTrans.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 12));
		btnTrans.setBounds(656, 85, 101, 25);
		panel_4.add(btnTrans);

		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.control);
		panel.setBounds(12, 154, 380, 120);
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		JLabel label_2 = new JLabel("Withdraw from Account");
		label_2.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 12));
		label_2.setBounds(10, 10, 150, 17);
		panel.add(label_2);

		JComboBox withdrawBox = new JComboBox();
		withdrawBox.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 12));
		withdrawBox.setModel(new DefaultComboBoxModel(new String[] {"Chequing Account", "Saving Account"}));
		withdrawBox.setBounds(175, 7, 195, 23);
		panel.add(withdrawBox);

		withdrawAmount = new JTextField();
		withdrawAmount.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 12));
		withdrawAmount.setColumns(10);
		withdrawAmount.setBounds(175, 48, 195, 23);
		panel.add(withdrawAmount);

		JLabel label_3 = new JLabel("Amount");
		label_3.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 12));
		label_3.setBounds(10, 51, 58, 17);
		panel.add(label_3);

		JButton btnWithdraw = new JButton("Finish");
		btnWithdraw.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 12));
		btnWithdraw.setBounds(269, 85, 101, 25);
		panel.add(btnWithdraw);

		JPanel panel_3 = new JPanel();
		panel_3.setBounds(12, 438, 440, 120);
		frame.getContentPane().add(panel_3);
		panel_3.setLayout(null);

		JButton btnOpen = new JButton("Open");
		btnOpen.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 12));
		btnOpen.setBounds(329, 4, 101, 25);
		panel_3.add(btnOpen);

		JLabel lblOpenAChequing = new JLabel("Open Account");
		lblOpenAChequing.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 12));
		lblOpenAChequing.setBounds(10, 9, 81, 15);
		panel_3.add(lblOpenAChequing);

		JButton btnDelete = new JButton("Delete");
		btnDelete.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 12));
		btnDelete.setBounds(329, 62, 101, 25);
		panel_3.add(btnDelete);

		JComboBox openAccountBox = new JComboBox();
		openAccountBox.setModel(new DefaultComboBoxModel(new String[] {"Chequing Account", "Saving Account"}));
		openAccountBox.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 12));
		openAccountBox.setBounds(101, 5, 195, 23);
		panel_3.add(openAccountBox);

		JComboBox closeAccountBox = new JComboBox();
		closeAccountBox.setModel(new DefaultComboBoxModel(new String[] {"Chequing Account", "Saving Account"}));
		closeAccountBox.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 12));
		closeAccountBox.setBounds(101, 63, 195, 23);
		panel_3.add(closeAccountBox);

		JLabel lblDeleteAccount = new JLabel("Close Account");
		lblDeleteAccount.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 12));
		lblDeleteAccount.setBounds(10, 67, 81, 15);
		panel_3.add(lblDeleteAccount);

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


		// withdraw button
		btnWithdraw.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String accNum = accountNumber.getText();
				String accountType = (String) withdrawBox.getSelectedItem(); //show which account to withdraw from 
				double tAmount = Double.parseDouble(withdrawAmount.getText());// show withdraw amount

				ActionAccount acc = new ActionAccount(username, accNum);
				acc.withdraw(accountType, tAmount);

				withdrawAmount.setText("");

				DisplayInfo info = new DisplayInfo(username, accountNumber,firstname,lastname,savingBalance,chequingBalance);

			}
		});
		
		btnTrans.addActionListener(new ActionListener() {
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
		

		btnLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				LoginPage window = new LoginPage();
				window.frame.setVisible(true);
			}
		});

		btnBack.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				ManagerPage window = new ManagerPage(managerName);
				window.frame.setVisible(true);

			}
		});
	}
}
