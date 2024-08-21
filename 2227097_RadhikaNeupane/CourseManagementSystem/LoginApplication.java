package CourseManagementSystem;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.SpringLayout;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Window;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JButton;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.awt.event.ActionEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.JCheckBox;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import java.awt.SystemColor;

public class LoginApplication extends JFrame {
	private JFrame frmCmsLoginApp;
	private JTextField usernametextField;
	private JPasswordField passwordField;
	private static String itemNameFromComboxBox = "";
	protected JLabel passwordtextField;
	private UserRegistration userRegistration = new UserRegistration();
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginApplication window = new LoginApplication();
					window.frmCmsLoginApp.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public LoginApplication() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmCmsLoginApp = new JFrame();
		frmCmsLoginApp.getContentPane().setBackground(new Color(204, 204, 255));
		frmCmsLoginApp.setTitle("CMS Login App");
		frmCmsLoginApp.setBounds(100, 100, 447, 330);
		frmCmsLoginApp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		SpringLayout springLayout = new SpringLayout();
		frmCmsLoginApp.getContentPane().setLayout(springLayout);

		JLabel lblNewLabel_1 = new JLabel("Username\r\n");
		springLayout.putConstraint(SpringLayout.SOUTH, lblNewLabel_1, 161, SpringLayout.NORTH, frmCmsLoginApp.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, lblNewLabel_1, 204, SpringLayout.WEST, frmCmsLoginApp.getContentPane());
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\DeLL\\Downloads\\icons8-username-20.png"));
		frmCmsLoginApp.getContentPane().add(lblNewLabel_1);

		usernametextField = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, lblNewLabel_1, 1, SpringLayout.NORTH, usernametextField);
		springLayout.putConstraint(SpringLayout.EAST, usernametextField, 366, SpringLayout.WEST, frmCmsLoginApp.getContentPane());
		frmCmsLoginApp.getContentPane().add(usernametextField);
		usernametextField.setColumns(10);

		JLabel lblNewLabel_1_1 = new JLabel("Password\r\n");
		springLayout.putConstraint(SpringLayout.WEST, lblNewLabel_1_1, 105, SpringLayout.WEST, frmCmsLoginApp.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, lblNewLabel_1, 0, SpringLayout.WEST, lblNewLabel_1_1);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1.setIcon(new ImageIcon("C:\\Users\\DeLL\\Downloads\\icons8-sign-in-form-password-20.png"));
		frmCmsLoginApp.getContentPane().add(lblNewLabel_1_1);

		passwordField = new JPasswordField();
		springLayout.putConstraint(SpringLayout.WEST, passwordField, 241, SpringLayout.WEST, frmCmsLoginApp.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, lblNewLabel_1_1, -43, SpringLayout.WEST, passwordField);
		springLayout.putConstraint(SpringLayout.EAST, passwordField, -67, SpringLayout.EAST, frmCmsLoginApp.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, usernametextField, 0, SpringLayout.WEST, passwordField);
		springLayout.putConstraint(SpringLayout.SOUTH, usernametextField, -20, SpringLayout.NORTH, passwordField);
		springLayout.putConstraint(SpringLayout.NORTH, lblNewLabel_1_1, -2, SpringLayout.NORTH, passwordField);
		springLayout.putConstraint(SpringLayout.SOUTH, passwordField, -87, SpringLayout.SOUTH, frmCmsLoginApp.getContentPane());
		frmCmsLoginApp.getContentPane().add(passwordField);

		JLabel lblNewLabel_2 = new JLabel("Select User");
		springLayout.putConstraint(SpringLayout.NORTH, lblNewLabel_2, 108, SpringLayout.NORTH, frmCmsLoginApp.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, lblNewLabel_2, 0, SpringLayout.WEST, lblNewLabel_1);
		springLayout.putConstraint(SpringLayout.SOUTH, lblNewLabel_2, -24, SpringLayout.NORTH, lblNewLabel_1);
		springLayout.putConstraint(SpringLayout.EAST, lblNewLabel_2, 216, SpringLayout.WEST, frmCmsLoginApp.getContentPane());
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\DeLL\\Downloads\\icons8-select-users-20.png"));
		frmCmsLoginApp.getContentPane().add(lblNewLabel_2);

		JComboBox comboBox = new JComboBox();
		springLayout.putConstraint(SpringLayout.NORTH, comboBox, -4, SpringLayout.NORTH, lblNewLabel_2);
		springLayout.putConstraint(SpringLayout.WEST, comboBox, 0, SpringLayout.WEST, usernametextField);
		springLayout.putConstraint(SpringLayout.EAST, comboBox, 0, SpringLayout.EAST, usernametextField);
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 14));
		comboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == 1) {
					itemNameFromComboxBox = (String) e.getItem();
					System.out.println(e.getItem());
				}
			}
		});
		comboBox.setModel(new DefaultComboBoxModel(new String[] { "Admin", "Instructor", "Student" }));
		frmCmsLoginApp.getContentPane().add(comboBox);

		JButton btnNewButton = new JButton("Login");
		btnNewButton.setBackground(new Color(204, 204, 204));
		springLayout.putConstraint(SpringLayout.NORTH, btnNewButton, 255, SpringLayout.NORTH, frmCmsLoginApp.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, btnNewButton, -67, SpringLayout.EAST, frmCmsLoginApp.getContentPane());
		btnNewButton.addActionListener(new ActionListener() {

		

		

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String username=usernametextField.getText().trim();
				char[] password= passwordField.getPassword();
				String systemuser = comboBox.getSelectedItem().toString();
				try {
					userRegistration.login(username,new String(password),systemuser);
				}
				catch(Exception ex) {
					ex.printStackTrace();
				}

				
			}
			
		});

		JCheckBox chckbxNewCheckBox = new JCheckBox("Show password");
		springLayout.putConstraint(SpringLayout.WEST, chckbxNewCheckBox, 241, SpringLayout.WEST, frmCmsLoginApp.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, chckbxNewCheckBox, -63, SpringLayout.SOUTH, frmCmsLoginApp.getContentPane());
		chckbxNewCheckBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (chckbxNewCheckBox.isSelected() == true) {
					passwordField.setEchoChar((char) 0);
				} else {
					passwordField.setEchoChar('•');
				}
			}
		});

		chckbxNewCheckBox.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		frmCmsLoginApp.getContentPane().add(chckbxNewCheckBox);

		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		frmCmsLoginApp.getContentPane().add(btnNewButton);
		
		JButton btnRegister = new JButton("Register");
		btnRegister.setBackground(new Color(204, 204, 204));
		springLayout.putConstraint(SpringLayout.WEST, btnRegister, 87, SpringLayout.WEST, frmCmsLoginApp.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, btnRegister, -247, SpringLayout.EAST, frmCmsLoginApp.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, btnNewButton, 72, SpringLayout.EAST, btnRegister);
		springLayout.putConstraint(SpringLayout.NORTH, btnRegister, 254, SpringLayout.NORTH, frmCmsLoginApp.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, btnRegister, -10, SpringLayout.SOUTH, frmCmsLoginApp.getContentPane());
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SignUp signUp = new SignUp();
			}
		});
		btnRegister.setFont(new Font("Tahoma", Font.PLAIN, 15));
		frmCmsLoginApp.getContentPane().add(btnRegister);
				
						JLabel lblNewLabel = new JLabel("Welcome to CMS");
						springLayout.putConstraint(SpringLayout.NORTH, lblNewLabel, 21, SpringLayout.NORTH, frmCmsLoginApp.getContentPane());
						springLayout.putConstraint(SpringLayout.WEST, lblNewLabel, 94, SpringLayout.WEST, frmCmsLoginApp.getContentPane());
						springLayout.putConstraint(SpringLayout.SOUTH, lblNewLabel, -18, SpringLayout.NORTH, comboBox);
						springLayout.putConstraint(SpringLayout.EAST, lblNewLabel, 0, SpringLayout.EAST, chckbxNewCheckBox);
						lblNewLabel.setIcon(new ImageIcon("C:\\Users\\DeLL\\Downloads\\icons8-laptop-shopping-bag-75.png"));
						frmCmsLoginApp.getContentPane().add(lblNewLabel);
						lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 21));
	}
}