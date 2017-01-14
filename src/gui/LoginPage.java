package gui;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import net.miginfocom.swing.MigLayout;
import java.awt.SystemColor;
import javax.swing.SwingConstants;
import javax.swing.JSeparator;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.UIManager;
import java.awt.Color;

public class LoginPage {

	JFrame frame;
	private JTextField textUsername;
	private JPasswordField textPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginPage window = new LoginPage();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public LoginPage() {

		initialize();
		//connect();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(SystemColor.inactiveCaption);
		frame.setResizable(false);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// close without exist
		frame.getContentPane().setLayout(null);

		JLabel loginSlogan = new JLabel("Welcome to Banking System");
		loginSlogan.setBackground(SystemColor.text);
		loginSlogan.setFont(new Font("Microsoft JhengHei", Font.BOLD, 14));
		loginSlogan.setForeground(SystemColor.text);
		loginSlogan.setBounds(124, 10, 195, 25);
		frame.getContentPane().add(loginSlogan);

		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.control);
		panel.setBounds(129, 45, 185, 199);
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lblAccountNumber = new JLabel("username");
		lblAccountNumber.setForeground(SystemColor.textInactiveText);
		lblAccountNumber.setBounds(17, 50, 103, 15);
		panel.add(lblAccountNumber);

		JLabel lblPassword = new JLabel("password");
		lblPassword.setForeground(SystemColor.textInactiveText);
		lblPassword.setBounds(17, 95, 80, 15);
		panel.add(lblPassword);

		textUsername = new JTextField();
		textUsername.setBackground(SystemColor.menu);
		textUsername.setBounds(17, 64, 150, 23);
		panel.add(textUsername);
		textUsername.setColumns(10);

		textPassword = new JPasswordField();
		textPassword.setBackground(SystemColor.menu);
		textPassword.setBounds(17, 110, 150, 23);
		panel.add(textPassword);

		JButton btnLogin = new JButton("LOGIN");
		btnLogin.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 12));
		
		btnLogin.setBounds(45, 143, 95, 35);
		panel.add(btnLogin);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(0, 39, 185, 2);
		panel.add(separator);
		
		JLabel lblLogin = new JLabel("Login");
		lblLogin.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 18));
		lblLogin.setForeground(SystemColor.textInactiveText);
		lblLogin.setBounds(69, 10, 47, 27);
		panel.add(lblLogin);


		//add buttion action
		btnLogin.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				try
				{
					//create connection when click button
					DbConnection db = new DbConnection();
					ResultSet rs;
					Statement st = db.st;

					String username = textUsername.getText().trim(); //trim remove blank
					String password = textPassword.getText().trim();
					String identifier;

					// ±ØÐëÓÐ ¿Õ¸ñ AND
					String sqlCustomer = "SELECT * FROM account WHERE accountNumber = " + username 
							+ " AND " + "password = " + password;
					String sqlManager = "SELECT * from manager WHERE managerId = " + username 
							+ " AND " + "password = " + password;

					// check which page to open
					rs = st.executeQuery(sqlCustomer);
					identifier = "customer";

					if (!rs.isBeforeFirst()){
						rs = st.executeQuery(sqlManager);
						identifier = "manager";
					}


					int count = 0;
					while(rs.next()){
						count = count + 1;
					}

					if(count == 1)
					{
						if(identifier == "customer"){
							frame.dispose(); // close login page when other page open
							AccountPage window = new AccountPage(username);
							window.frame.setVisible(true);
						}
						if(identifier == "manager"){
							frame.dispose(); // close login page when other page open
							ManagerPage window = new ManagerPage(username);
							window.frame.setVisible(true);
						}
					}
					else if(count > 1){
						JOptionPane.showMessageDialog(null, "Dupilcate user!");
					}
					else{
						JOptionPane.showMessageDialog(null, "User not found!");
					}
					
				} catch(Exception connectionError){
					
					connectionError.printStackTrace();
				}// end of try
			}

		});//end of listener
	}
}
