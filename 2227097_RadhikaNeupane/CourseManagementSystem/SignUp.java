package CourseManagementSystem;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.ActionEvent;
import javax.swing.SpringLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;

import java.util.Arrays;
import java.util.regex.*;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.SystemColor;
import java.awt.Color;

public class SignUp {

	private JFrame frame;
	private JTextField usernametextField;
	private JTextField firstnameTextfield;
	private JTextField lastnametextfield;
	private JPasswordField passwordField;
	private JPasswordField confirmpasswordField;
	String passwordPattern= "[A-Z][a-z A-Z]+[@ &]+[0-9]";
	private JComboBox usercomboBox;
	private static String itemNameFromComboxBox = "";
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SignUp window = new SignUp();
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
	public SignUp() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(192, 192, 192));
		frame.getContentPane().setForeground(SystemColor.scrollbar);
		frame.setBounds(100, 100, 532, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);

		
	
		
		JLabel userName = new JLabel("Username");
		userName.setFont(new Font("Tahoma", Font.BOLD, 11));
		userName.setIcon(new ImageIcon("C:\\Users\\DeLL\\Downloads\\icons8-female-user-20.png"));
		
		JLabel firstName = new JLabel("Firstname");
		firstName.setIcon(new ImageIcon("C:\\Users\\DeLL\\Downloads\\icons8-name-tag-20.png"));
		firstName.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		JLabel lastName = new JLabel("Lastname");
		lastName.setIcon(new ImageIcon("C:\\Users\\DeLL\\Downloads\\icons8-name-tag-20.png"));
		lastName.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		JLabel passWord = new JLabel("Password");
		passWord.setIcon(new ImageIcon("C:\\Users\\DeLL\\Downloads\\icons8-locked-with-key-20.png"));
		passWord.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		JLabel confirmPassword = new JLabel("Confirmpassword");
		confirmPassword.setIcon(new ImageIcon("C:\\Users\\DeLL\\Downloads\\icons8-locked-with-key-20.png"));
		confirmPassword.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		usernametextField = new JTextField();
		usernametextField.setColumns(10);
		
		firstnameTextfield = new JTextField();
		firstnameTextfield.setColumns(10);
		
		lastnametextfield = new JTextField();
		lastnametextfield.setColumns(10);
		passwordField = new JPasswordField();
		
		confirmpasswordField = new JPasswordField();
		String items[] = {"Male","Female"};
		JComboBox genders = new JComboBox(items);
		
		JLabel lblNewLabel = new JLabel("Gender");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\DeLL\\Downloads\\icons8-drag-gender-neutral-20.png"));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		frame.setVisible(true);

		String selectuser[] = { "Admin", "Instructor", "Student" };
		JComboBox usercomboBox = new JComboBox(selectuser);

		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.setBackground(new Color(192, 192, 192));
		btnSubmit.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnSubmit.addActionListener(new ActionListener() {
			UserRegistration user = new UserRegistration();

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					String username = usernametextField.getText().trim();
					String firstName = firstnameTextfield.getText().trim();
					String lastName = lastnametextfield.getText().trim();
					String gender = genders.getSelectedItem().toString();
					String selectusers = usercomboBox.getSelectedItem().toString();
					char[] password = passwordField.getPassword();
					char[] confirmPassword = confirmpasswordField.getPassword();
					if(username.isEmpty()|| firstName.isEmpty()||lastName.isEmpty()||password.length==0||confirmPassword.length==0) {
						JOptionPane.showMessageDialog(frame, "All fields must be filled", "Warning", JOptionPane.WARNING_MESSAGE);
					}
					else if (!Arrays.equals(password, confirmPassword)) {
						  JOptionPane.showMessageDialog(frame, "Password and confirm password fields do not match", "Warning", JOptionPane.WARNING_MESSAGE);
						}
					else {
						user.insert(username, firstName, lastName, gender, selectusers, new String(password), new String(confirmPassword));
						JOptionPane.showMessageDialog(frame, "User registerd successfully","Information", JOptionPane.INFORMATION_MESSAGE);
						
					}
					
				}catch(Exception ex) {
					JOptionPane.showMessageDialog(frame,"You've made mistake", "Error", JOptionPane.ERROR_MESSAGE );
					System.out.println(ex);
				}
			}
			
		});
		
		JLabel lblNewLabel_1 = new JLabel("Sign Up");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 17));
		

		
		JLabel lblNewLabel_2 = new JLabel("Select Users");
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\DeLL\\Downloads\\icons8-select-users-20.png"));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(147)
							.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 149, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(101)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, 294, GroupLayout.PREFERRED_SIZE)
								.addComponent(confirmPassword, GroupLayout.PREFERRED_SIZE, 142, GroupLayout.PREFERRED_SIZE)
								.addComponent(usernametextField, GroupLayout.PREFERRED_SIZE, 295, GroupLayout.PREFERRED_SIZE)
								.addComponent(userName, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
								.addComponent(firstName, GroupLayout.PREFERRED_SIZE, 117, GroupLayout.PREFERRED_SIZE)
								.addComponent(firstnameTextfield, GroupLayout.PREFERRED_SIZE, 295, GroupLayout.PREFERRED_SIZE)
								.addComponent(lastName, GroupLayout.PREFERRED_SIZE, 114, GroupLayout.PREFERRED_SIZE)
								.addComponent(confirmpasswordField, GroupLayout.PREFERRED_SIZE, 299, GroupLayout.PREFERRED_SIZE)
								.addComponent(lastnametextfield, GroupLayout.PREFERRED_SIZE, 295, GroupLayout.PREFERRED_SIZE)
								.addGroup(groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
											.addComponent(passWord, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
											.addComponent(genders, Alignment.LEADING, 0, 105, Short.MAX_VALUE))
										.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE))
									.addGap(48)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(lblNewLabel_2, GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE)
										.addComponent(usercomboBox, GroupLayout.PREFERRED_SIZE, 129, GroupLayout.PREFERRED_SIZE))))))
					.addContainerGap(118, Short.MAX_VALUE))
				.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
					.addGap(180)
					.addComponent(btnSubmit, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(208, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(23)
					.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(userName, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
					.addGap(6)
					.addComponent(usernametextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(firstName)
					.addGap(5)
					.addComponent(firstnameTextfield, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lastName)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lastnametextfield, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel)
						.addComponent(lblNewLabel_2))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(genders, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
						.addComponent(usercomboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(passWord)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(confirmPassword)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(confirmpasswordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btnSubmit)
					.addContainerGap(21, Short.MAX_VALUE))
		);
		frame.getContentPane().setLayout(groupLayout);
		
	
	}
}
