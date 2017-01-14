package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import java.awt.SystemColor;

public class WarningMessage extends JDialog {

	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			WarningMessage dialog = new WarningMessage();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public WarningMessage() {
		setTitle("Warning");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(SystemColor.inactiveCaption);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			String text = "MESSAGE WARNING TEST!";
		}
		{
			JPanel panel = new JPanel();
			panel.setBounds(10, 10, 414, 207);
			contentPanel.add(panel);
			panel.setLayout(null);
			{
				JLabel lblNewLabel = new JLabel("WARNING!", SwingConstants.CENTER);
				lblNewLabel.setBounds(175, 10, 64, 17);
				panel.add(lblNewLabel);
				lblNewLabel.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 12));
				lblNewLabel.setForeground(Color.RED);
			}
			JLabel lblWarningMessageDisplay = new JLabel("CENTERLIZED WARNING MESSAGE DISPLAY!", SwingConstants.CENTER);
			lblWarningMessageDisplay.setBounds(79, 95, 256, 17);
			panel.add(lblWarningMessageDisplay);
			lblWarningMessageDisplay.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 12));
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(SystemColor.inactiveCaption);
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 12));
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 12));
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

}
