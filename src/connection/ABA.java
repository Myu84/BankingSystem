package connection;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class ABA {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ABA window = new ABA();
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
	public ABA() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lbl = new JLabel("DISPLAY");
		lbl.setBounds(209, 74, 194, 19);
		frame.getContentPane().add(lbl);
		
		JComboBox box1 = new JComboBox();
		
		box1.setModel(new DefaultComboBoxModel(new String[] {"A", "B", "C"}));
		box1.setBounds(10, 10, 119, 21);
		frame.getContentPane().add(box1);
		
		JComboBox box2 = new JComboBox();
		box2.setBounds(10, 41, 119, 21);
		frame.getContentPane().add(box2);
		
		box1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if((String) box1.getSelectedItem() == "A"){
					box2.setModel(new DefaultComboBoxModel(new String[] {"a", "aa", "aaa"}));
				}
				if((String) box1.getSelectedItem() == "B"){
					box2.setModel(new DefaultComboBoxModel(new String[] {"b", "bb", "bbb"}));
				}
				if((String) box1.getSelectedItem() == "C"){
					box2.setModel(new DefaultComboBoxModel(new String[] {"c", "c", "ccc"}));
				}
			}
		});
		
		box1.setSelectedIndex(0);
		box2.setSelectedIndex(0);
		
		System.out.println((String) box1.getSelectedItem());
		System.out.println((String) box2.getSelectedItem());
		
		JButton btn = new JButton("New button");
		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				lbl.setText((String)box2.getSelectedItem() + "\t" + (String)box1.getSelectedItem());
			}
		});
		btn.setBounds(10, 72, 93, 23);
		frame.getContentPane().add(btn);
		
	}
}
