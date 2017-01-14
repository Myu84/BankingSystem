package gui;

import java.awt.EventQueue;
import java.sql.*;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import java.awt.SystemColor;
import java.awt.Font;

public class ManagerPage {

	public  JFrame frame;
	private JTextField textAccountSearch;
	private JButton btnSearch;
	private JLabel lblNewLabel_1;
	private JSeparator separator;
	private JTextField textFirstname;
	private JLabel lblFirstName;
	private JLabel lblLastName;
	private JTextField textLastname;
	private JLabel lblId;
	private JTextField textCustomerId;
	private JLabel lblAccountNumber;
	private JTextField textAccountNumber;
	private JCheckBox chckbxChequing;
	private JCheckBox chckbxSaving;
	private JLabel lblCheckBoxWarning;
	private JButton btnLogOut;

	private String username;
	private JPanel panel;
	private JPanel panel_1;
	private JPanel panel_2;
	private JPanel panel_3;
	private JSeparator separator_2;
	private JButton btnNew;
	private JLabel lblPassword;
	private JTextField textPassword;

	private String managerName;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the application.
	 */
	public ManagerPage(String managerName) {
		this.managerName = managerName;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(SystemColor.inactiveCaption);
		frame.setResizable(false);

		DbConnection db = new DbConnection();//create connection


		frame.setTitle(managerName + "'s Account");
		frame.setBounds(100, 100, 800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		separator = new JSeparator();
		separator.setBounds(12, 137, 770, 2);
		frame.getContentPane().add(separator);

		panel = new JPanel();
		panel.setBounds(12, 7, 770, 120);
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lblSearchCustomer = new JLabel("Search");
		lblSearchCustomer.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 12));
		lblSearchCustomer.setBounds(10, 14, 38, 15);
		panel.add(lblSearchCustomer);

		textAccountSearch = new JTextField();
		textAccountSearch.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 12));
		textAccountSearch.setBounds(116, 10, 195, 23);
		panel.add(textAccountSearch);
		textAccountSearch.setColumns(10);

		btnSearch = new JButton("Search");
		btnSearch.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 12));
		btnSearch.setBounds(660, 85, 101, 25);
		panel.add(btnSearch);

		panel_1 = new JPanel();
		panel_1.setBounds(12, 149, 770, 120);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);

		lblFirstName = new JLabel("First Name");
		lblFirstName.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 12));
		lblFirstName.setBounds(10, 51, 60, 17);
		panel_1.add(lblFirstName);

		textFirstname = new JTextField();
		textFirstname.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 12));
		textFirstname.setBounds(116, 48, 195, 23);
		panel_1.add(textFirstname);
		textFirstname.setColumns(10);

		textLastname = new JTextField();
		textLastname.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 12));
		textLastname.setBounds(116, 87, 195, 23);
		panel_1.add(textLastname);
		textLastname.setColumns(10);

		lblLastName = new JLabel("Last Name");
		lblLastName.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 12));
		lblLastName.setBounds(10, 90, 60, 17);
		panel_1.add(lblLastName);

		textAccountNumber = new JTextField();
		textAccountNumber.setBounds(116, 6, 195, 23);
		panel_1.add(textAccountNumber);
		textAccountNumber.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 12));
		textAccountNumber.setColumns(10);

		lblAccountNumber = new JLabel("Account Number");
		lblAccountNumber.setBounds(10, 9, 96, 17);
		panel_1.add(lblAccountNumber);
		lblAccountNumber.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 12));

		btnLogOut = new JButton("LOG OUT");
		btnLogOut.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 12));
		btnLogOut.setBounds(671, 533, 101, 25);
		frame.getContentPane().add(btnLogOut);

		panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBounds(12, 291, 770, 120);
		frame.getContentPane().add(panel_2);

		chckbxSaving = new JCheckBox("Saving Account");
		chckbxSaving.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 12));
		chckbxSaving.setBounds(10, 86, 135, 25);
		panel_2.add(chckbxSaving);

		lblId = new JLabel("Customer ID");
		lblId.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 12));
		lblId.setBounds(10, 10, 69, 17);
		panel_2.add(lblId);

		textCustomerId = new JTextField();
		textCustomerId.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 12));
		textCustomerId.setBounds(116, 7, 195, 23);
		panel_2.add(textCustomerId);
		textCustomerId.setColumns(10);

		chckbxChequing = new JCheckBox("Chequing Account");
		chckbxChequing.setBounds(147, 86, 135, 25);
		panel_2.add(chckbxChequing);
		chckbxChequing.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 12));

		btnNew = new JButton("New");
		btnNew.setBounds(659, 86, 101, 25);
		panel_2.add(btnNew);
		btnNew.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 12));

		lblNewLabel_1 = new JLabel("Create a new Customer");
		lblNewLabel_1.setBounds(630, 69, 130, 15);
		panel_2.add(lblNewLabel_1);
		lblNewLabel_1.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 12));
		lblNewLabel_1.setForeground(SystemColor.controlDkShadow);

		lblCheckBoxWarning = new JLabel("(have to check at least one)");
		lblCheckBoxWarning.setBounds(288, 90, 170, 17);
		panel_2.add(lblCheckBoxWarning);
		lblCheckBoxWarning.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 12));

		lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 12));
		lblPassword.setBounds(10, 52, 54, 15);
		panel_2.add(lblPassword);

		textPassword = new JTextField();
		textPassword.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 12));
		textPassword.setColumns(10);
		textPassword.setBounds(116, 48, 195, 23);
		panel_2.add(textPassword);

		btnNew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if(chckbxSaving.isSelected() || chckbxChequing.isSelected()){
					String firstname = textFirstname.getText();
					String lastname = textLastname.getText();
					String customerId = textCustomerId.getText();
					String accountNumber = textAccountNumber.getText();
					String password = textPassword.getText();
					double balance = 0;

					//create a new customer
					Customer cus = new Customer(customerId, firstname, lastname);
					cus.insert();
					//create a new account
					ActionAccount acc = new ActionAccount(accountNumber, accountNumber);
					acc.newAccount(customerId, password);

					if(chckbxChequing.isSelected()){
						acc.newChequing(accountNumber, balance);
					}
					if(chckbxSaving.isSelected()){
						acc.newSaving(accountNumber, balance);
					}

					//close current window and open new account page
					System.out.println(accountNumber +" " + managerName);
					ManagerCustomerAccount window = new ManagerCustomerAccount(accountNumber,managerName);
					window.frame.setVisible(true);
					frame.dispose();
				}
				else{
					JOptionPane.showMessageDialog(null, "Please Check at least one account to be open!");
				}

			}
		});

		panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBounds(12, 433, 592, 120);
		frame.getContentPane().add(panel_3);

		separator_2 = new JSeparator();
		separator_2.setBounds(12, 421, 770, 2);
		frame.getContentPane().add(separator_2);

		//log out button
		btnLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				LoginPage window = new LoginPage();
				window.frame.setVisible(true);
			}
		});

		//search button
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String username = textAccountSearch.getText(); // get text from input
				ManagerCustomerAccount window = new ManagerCustomerAccount(username, managerName); // pass input to next window
				window.frame.setVisible(true);
				frame.dispose(); // close login page when other page open
			}
		});

	}
}
