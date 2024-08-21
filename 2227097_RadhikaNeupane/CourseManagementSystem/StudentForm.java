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

import java.awt.Font;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class StudentForm extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JLabel lblNewLabel;
	private JTextField studentNametextField;
	private JTextField studentIdtextField;
	private JLabel lblNewLabel_3;
	private JTextField leveltextField;
	private JLabel lblNewLabel_4; 
	private JTextField semestertextField;
	private JTextField addresstextField;
	private JLabel lblNewLabel_5;
	
	private String StudentId ="";
	private String StudentName="";
	private String Address="";
	private String Level="";
	private String Semester="";
	 
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			StudentForm dialog = new StudentForm();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public StudentForm() {
		setBounds(100, 100, 464, 387);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.NORTH);
		{
			lblNewLabel = new JLabel("Registration Form");
			lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		}
		
		JLabel lblNewLabel_1 = new JLabel("Student Name");
		
		studentNametextField = new JTextField();
		studentNametextField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Student ID");
		
		studentIdtextField = new JTextField();
		studentIdtextField.setColumns(10);
		
		lblNewLabel_3 = new JLabel("Level");
		
		leveltextField = new JTextField();
		leveltextField.setColumns(10);
		
		lblNewLabel_4 = new JLabel("Semester");
		
		semestertextField = new JTextField();
		semestertextField.setColumns(10);
		
		addresstextField = new JTextField();
		addresstextField.setColumns(10);
		
		lblNewLabel_5 = new JLabel("Address");
		
		JButton btnNewButton = new JButton("Register");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				

				   StudentId =studentIdtextField.getText().trim();
				   StudentName = studentNametextField.getText().trim();
				   Address = addresstextField.getText().trim();
				   Level = leveltextField.getText().trim();
				   Semester=semestertextField.getText().trim();


				  Statement statement = Database.getStatement();
				  
				  String insertQuery = "INSERT INTO `student` (`StudentId`, `StudentName`, `Address`, `Level`, `Semester`) VALUES ('"+ StudentId +"', '"+StudentName+"', '"+Address +"', '"+Level+"', '"+Semester+"');";
				

				try {
					int insertSuccess = statement.executeUpdate(insertQuery);
					if (insertSuccess == 1) {
						JOptionPane.showMessageDialog(contentPanel, "Saved into database");
					}
			} catch (SQLException e1) {
					// TODO Auto-generated catch block
				e1.printStackTrace();
				}
				
				Dashboard.showStudentDataInJtableFromDb();
		
			}
	
		});
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_contentPanel.createSequentialGroup()
					.addContainerGap(154, Short.MAX_VALUE)
					.addComponent(lblNewLabel)
					.addGap(146))
				.addGroup(Alignment.TRAILING, gl_contentPanel.createSequentialGroup()
					.addGap(55)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addComponent(lblNewLabel_4, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED))
						.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_contentPanel.createSequentialGroup()
								.addComponent(lblNewLabel_3, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED))
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPanel.createSequentialGroup()
									.addComponent(lblNewLabel_5, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED))
								.addGroup(Alignment.TRAILING, gl_contentPanel.createSequentialGroup()
									.addGroup(gl_contentPanel.createParallelGroup(Alignment.TRAILING)
										.addComponent(lblNewLabel_1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 103, Short.MAX_VALUE)
										.addComponent(lblNewLabel_2, GroupLayout.DEFAULT_SIZE, 103, Short.MAX_VALUE))
									.addPreferredGap(ComponentPlacement.RELATED)))))
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(semestertextField, GroupLayout.PREFERRED_SIZE, 180, GroupLayout.PREFERRED_SIZE)
						.addComponent(addresstextField, GroupLayout.PREFERRED_SIZE, 180, GroupLayout.PREFERRED_SIZE)
						.addComponent(studentNametextField, GroupLayout.PREFERRED_SIZE, 180, GroupLayout.PREFERRED_SIZE)
						.addComponent(studentIdtextField, GroupLayout.PREFERRED_SIZE, 180, GroupLayout.PREFERRED_SIZE)
						.addComponent(leveltextField, GroupLayout.PREFERRED_SIZE, 180, GroupLayout.PREFERRED_SIZE))
					.addGap(96))
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGap(179)
					.addComponent(btnNewButton)
					.addContainerGap(188, Short.MAX_VALUE))
		);
		gl_contentPanel.setVerticalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel)
					.addGap(36)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(studentIdtextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_2))
					.addGap(15)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.TRAILING)
						.addComponent(studentNametextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_1))
					.addGap(27)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(addresstextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_5))
					.addGap(18)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(leveltextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_3))
					.addGap(24)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(semestertextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_4))
					.addPreferredGap(ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
					.addComponent(btnNewButton)
					.addContainerGap())
		);
		contentPanel.setLayout(gl_contentPanel);
	}
}
