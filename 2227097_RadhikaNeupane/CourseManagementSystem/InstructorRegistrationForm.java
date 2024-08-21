package CourseManagementSystem;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Backend.Database;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JComboBox;
import java.awt.Font;
import javax.swing.SpringLayout;
import javax.swing.ImageIcon;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class InstructorRegistrationForm extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JLabel lblNewLabel;
	private JTextField fullNametextField;
	private JTextField mobileNumbertextField;
	private JTextField addresstextField;
	private JTextField degreetextField;
	private JTextField moduleltextField;
	private String Name = "";
	private String MobileNumber = "";
	private String Address = "";
	private String Gender = "";
	private String QualifiedDegree = "";
	private String  ModuleAssigned= "";
	private JComboBox gendercomboBox;
	private JButton submitButton;
	private JLabel lblNewLabel_7;
	
	public JComboBox getGendercomboBox() {
		return gendercomboBox;
	}

	public void setGendercomboBox(JComboBox gendercomboBox) {
		this.gendercomboBox = gendercomboBox;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			InstructorRegistrationForm dialog = new InstructorRegistrationForm();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public InstructorRegistrationForm() {
		setBounds(100, 100, 450, 440);
		getContentPane().setLayout(new BorderLayout());
		setTitle("Instructor Form");
		contentPanel.setBackground(new Color(204, 204, 204));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		{
			lblNewLabel = new JLabel("Name");
			lblNewLabel.setBounds(68, 75, 105, 22);
			lblNewLabel.setIcon(new ImageIcon("C:\\Users\\DeLL\\Downloads\\icons8-name-tag-20.png"));
		}
		
		JLabel lblNewLabel_1 = new JLabel("Mobile Number");
		lblNewLabel_1.setBounds(68, 126, 150, 15);
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\DeLL\\Downloads\\icons8-phone-book-20.png"));
		
		JLabel lblNewLabel_2 = new JLabel("Address");
		lblNewLabel_2.setBounds(68, 177, 78, 14);
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\DeLL\\Downloads\\icons8-home-address-20.png"));
		
		JLabel lblNewLabel_3 = new JLabel("Gender");
		lblNewLabel_3.setBounds(68, 217, 84, 15);
		lblNewLabel_3.setIcon(new ImageIcon("C:\\Users\\DeLL\\Downloads\\icons8-female-user-20.png"));
		
		JLabel lblNewLabel_4 = new JLabel("Module Assigned");
		lblNewLabel_4.setBounds(68, 260, 118, 15);
		lblNewLabel_4.setIcon(new ImageIcon("C:\\Users\\DeLL\\Downloads\\icons8-subjects-15.png"));
		
		JLabel lblNewLabel_5 = new JLabel("Qualified Degree");
		lblNewLabel_5.setBounds(66, 309, 150, 15);
		lblNewLabel_5.setIcon(new ImageIcon("C:\\Users\\DeLL\\Downloads\\icons8-diploma-20.png"));
		
		fullNametextField = new JTextField();
		fullNametextField.setBounds(208, 76, 153, 20);
		fullNametextField.setColumns(10);
		
		mobileNumbertextField = new JTextField();
		mobileNumbertextField.setBounds(208, 123, 153, 20);
		mobileNumbertextField.setColumns(10);
		
		addresstextField = new JTextField();
		addresstextField.setBounds(208, 174, 153, 20);
		addresstextField.setColumns(10);
		
		degreetextField = new JTextField();
		degreetextField.setBounds(208, 306, 153, 20);
		degreetextField.setColumns(10);
		
		gendercomboBox = new JComboBox();
		gendercomboBox.setModel(new DefaultComboBoxModel(new String[] {"Male", "Female"}));
		gendercomboBox.setBounds(208, 213, 88, 22);
		
		JLabel lblNewLabel_6 = new JLabel("Registration Form");
		lblNewLabel_6.setIcon(new ImageIcon("C:\\Users\\DeLL\\Downloads\\icons8-task-15.png"));
		lblNewLabel_6.setBounds(157, 26, 153, 14);
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 13));
		contentPanel.setLayout(null);
		contentPanel.add(lblNewLabel);
		contentPanel.add(fullNametextField);
		contentPanel.add(lblNewLabel_1);
		contentPanel.add(lblNewLabel_2);
		contentPanel.add(lblNewLabel_4);
		contentPanel.add(lblNewLabel_5);
		contentPanel.add(lblNewLabel_3);
		contentPanel.add(gendercomboBox);
		contentPanel.add(mobileNumbertextField);
		contentPanel.add(addresstextField);
		contentPanel.add(degreetextField);
		contentPanel.add(lblNewLabel_6);
		
		moduleltextField = new JTextField();
		moduleltextField.setBounds(208, 257, 153, 20);
		moduleltextField.setColumns(10);
		contentPanel.add(moduleltextField);
		
		submitButton = new JButton("Submit");
		submitButton.setActionCommand("Submit");
		submitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getActionCommand().equals("Submit")) {

					if (fullNametextField.getText().isEmpty()) {
						lblNewLabel_7.setVisible(true);
					} else {
						lblNewLabel_7.setVisible(false);
					}
				
			   Name =fullNametextField.getText().trim();
			   MobileNumber =  mobileNumbertextField.getText().trim();
			   Address = addresstextField.getText().trim();
			   ModuleAssigned = moduleltextField.getText().trim();
			   QualifiedDegree = degreetextField.getText().trim();
			   Gender =gendercomboBox.getSelectedItem().toString().trim();
				
			
			Statement statement = Database.getStatement();
			String insertQuery = "INSERT INTO `instructor` (`ID`, `Name`, `MobileNumber`, `Address`, `ModuleAssigned`, `QualifiedDegree`, `Gender`) VALUES (NULL, '"+ Name +"', '"+ MobileNumber +"', '"+ Address +"', '"+ ModuleAssigned+"', '"+QualifiedDegree+"', '"+ Gender+"');";

			try {
				int insertSuccess = statement.executeUpdate(insertQuery);
				if (insertSuccess == 1) {
					JOptionPane.showMessageDialog(contentPanel, "Saved into database");
				}
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			Dashboard.showInstructorDataInTableFromDb();


		}
		}	
			
		});
		submitButton.setBounds(181, 365, 118, 23);
		contentPanel.add(submitButton);
		
		lblNewLabel_7 = new JLabel("Full Name cannnot be empty!");
		lblNewLabel_7.setVisible(false);
		lblNewLabel_7.setForeground(new Color(255, 0, 0));
		lblNewLabel_7.setFont(new Font("Trebuchet MS", Font.PLAIN, 8));
		lblNewLabel_7.setBounds(208, 94, 133, 14);
		contentPanel.add(lblNewLabel_7);
	}

	public JTextField getFullNametextField() {
		return fullNametextField;
	}

	public void setFullNametextField(JTextField fullNametextField) {
		this.fullNametextField = fullNametextField;
	}

	public JTextField getMobileNumbertextField() {
		return mobileNumbertextField;
	}

	public void setMobileNumbertextField(JTextField mobileNumbertextField) {
		this.mobileNumbertextField = mobileNumbertextField;
	}

	public JTextField getAddresstextField() {
		return addresstextField;
	}

	public void setAddresstextField(JTextField addresstextField) {
		this.addresstextField = addresstextField;
	}

	public JTextField getDegreetextField() {
		return degreetextField;
	}

	public void setDegreetextField(JTextField degreetextField) {
		this.degreetextField = degreetextField;
	}

	public JTextField getModuleltextField() {
		return moduleltextField;
	}

	public void setModuleltextField(JTextField moduleltextField) {
		this.moduleltextField = moduleltextField;
	}

	public JButton getSubmitButton() {
		return submitButton;
	}

	public void setSubmitButton(JButton submitButton) {
		this.submitButton = submitButton;
	}
}
