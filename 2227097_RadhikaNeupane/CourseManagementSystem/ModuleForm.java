package CourseManagementSystem;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Backend.Database;

import javax.swing.SpringLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

public class ModuleForm extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField moduleNametextField;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_2_1;
	private JComboBox courseSelectedComboBox;
	private JComboBox levelSelectedComboBox;
	private JTextField creditValueTextField;
	private JLabel lblNewLabel_3;
	private JComboBox semesterSelectedComboBox;
	private JCheckBox isOptionalModuleCheckBox;
	private Statement statement;
	private JButton addModuleButton;
	
	


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ModuleForm dialog = new ModuleForm();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ModuleForm() {
		setTitle("Module Form");
		setBounds(100, 100, 557, 432);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(192, 192, 192));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		{
			lblNewLabel = new JLabel("Module Name\r\n");
			lblNewLabel.setIcon(new ImageIcon("C:\\Users\\DeLL\\Downloads\\icons8-module-15 (1).png"));
		}
		{
			moduleNametextField = new JTextField();
			moduleNametextField.setColumns(10);
		}
		{
			lblNewLabel_1 = new JLabel("Course Name");
			lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\DeLL\\Downloads\\icons8-knowledge-sharing-15.png"));
		}
		{
			courseSelectedComboBox = new JComboBox();
			
			//Get course name from Course table
			statement = Database.getStatement();
			
			String selectQuery = "SELECT CourseName FROM `course`";
			
			String courseNames [] = new String[2];
			int i = 0;
			try {
				ResultSet resultSet = statement.executeQuery(selectQuery);
				while(resultSet.next()) {
					String courseNameFromDB = resultSet.getString("CourseName");
					courseNames[i] = courseNameFromDB;
					i++;
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			courseSelectedComboBox.setModel(new DefaultComboBoxModel(new String[] {"Select Course",courseNames[0],courseNames[1]}));
		}
		{
			lblNewLabel_2 = new JLabel("Level");
			lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\DeLL\\Downloads\\icons8-stairs-up-15.png"));
		}
		{
			lblNewLabel_2_1 = new JLabel("Semester\r\n");
			lblNewLabel_2_1.setIcon(new ImageIcon("C:\\Users\\DeLL\\Downloads\\icons8-calendar-14.png"));
		}
		{
			levelSelectedComboBox = new JComboBox();
			levelSelectedComboBox.setModel(new DefaultComboBoxModel(new String[] {"Select Level", "Level 4", "Level 5", "Level 6"}));
		}
		{
			semesterSelectedComboBox = new JComboBox();
			semesterSelectedComboBox.setModel(new DefaultComboBoxModel(new String[] {"Select Semester", "1st Semester", "2nd Semester"}));
		}
		{
			lblNewLabel_3 = new JLabel("CreditValue\r\n");
			lblNewLabel_3.setIcon(new ImageIcon("C:\\Users\\DeLL\\Downloads\\icons8-timer-15.png"));
		}
		{
			creditValueTextField = new JTextField();
			creditValueTextField.setColumns(10);
		}
		{
			isOptionalModuleCheckBox = new JCheckBox("Optional Module");
		}
		{
			addModuleButton = new JButton("Add Module");
			addModuleButton.addActionListener(new ActionListener() {

				public void actionPerformed(ActionEvent e) {
					String moduleName = moduleNametextField.getText().trim();
					String selectedCourseName = courseSelectedComboBox.getSelectedItem().toString();
					String selectedLevel = levelSelectedComboBox.getSelectedItem().toString();
					String creditValue = creditValueTextField.getText().trim();
					String selectedSemester = semesterSelectedComboBox.getSelectedItem().toString();
					String isOptionalModule = "";
					if(isOptionalModuleCheckBox.isSelected()) {
						isOptionalModule ="YES";
					}else {
						isOptionalModule ="NO";
					}
				
					Statement statement2 = Database.getStatement();
					
					String insertQuery = "INSERT INTO `module` (`ModuleName`, `CourseName`, `Level`, `Semester`, `CreditValue`, `OptionalModule`) "
					+ "VALUES ('"+moduleName +"', '"+selectedCourseName +"', '"+selectedLevel +"', '"+selectedSemester +"', '"+ creditValue+"', '"+isOptionalModule +"')";
					
					
					try {
						int insertSuccess = statement2.executeUpdate(insertQuery);
						if(insertSuccess == 1) {
							JOptionPane.showMessageDialog(contentPanel, "Saved into database!");

						}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					//Refresh the JTable sync with Database table data
					Dashboard.showModuleDataInJtableFromDb();

					//Close the courseForm
					Dashboard.moduleForm.setVisible(false);

				}
			});
		}
		
		JLabel lblNewLabel_4 = new JLabel("Registration Form");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 13));
		SpringLayout sl_contentPanel = new SpringLayout();
		sl_contentPanel.putConstraint(SpringLayout.NORTH, isOptionalModuleCheckBox, -4, SpringLayout.NORTH, lblNewLabel_3);
		sl_contentPanel.putConstraint(SpringLayout.EAST, isOptionalModuleCheckBox, -62, SpringLayout.EAST, contentPanel);
		sl_contentPanel.putConstraint(SpringLayout.NORTH, creditValueTextField, -3, SpringLayout.NORTH, lblNewLabel_3);
		sl_contentPanel.putConstraint(SpringLayout.WEST, creditValueTextField, 28, SpringLayout.EAST, lblNewLabel_3);
		sl_contentPanel.putConstraint(SpringLayout.EAST, creditValueTextField, 286, SpringLayout.WEST, contentPanel);
		sl_contentPanel.putConstraint(SpringLayout.NORTH, lblNewLabel_3, 59, SpringLayout.SOUTH, lblNewLabel_2_1);
		sl_contentPanel.putConstraint(SpringLayout.WEST, lblNewLabel_3, 0, SpringLayout.WEST, lblNewLabel);
		sl_contentPanel.putConstraint(SpringLayout.NORTH, lblNewLabel_2, 3, SpringLayout.NORTH, levelSelectedComboBox);
		sl_contentPanel.putConstraint(SpringLayout.WEST, lblNewLabel_2, 98, SpringLayout.WEST, contentPanel);
		sl_contentPanel.putConstraint(SpringLayout.SOUTH, lblNewLabel, 0, SpringLayout.SOUTH, moduleNametextField);
		sl_contentPanel.putConstraint(SpringLayout.EAST, lblNewLabel, -54, SpringLayout.WEST, moduleNametextField);
		sl_contentPanel.putConstraint(SpringLayout.WEST, lblNewLabel_1, 86, SpringLayout.WEST, contentPanel);
		sl_contentPanel.putConstraint(SpringLayout.NORTH, lblNewLabel_1, 3, SpringLayout.NORTH, courseSelectedComboBox);
		sl_contentPanel.putConstraint(SpringLayout.NORTH, addModuleButton, 363, SpringLayout.NORTH, contentPanel);
		sl_contentPanel.putConstraint(SpringLayout.WEST, addModuleButton, 210, SpringLayout.WEST, contentPanel);
		sl_contentPanel.putConstraint(SpringLayout.NORTH, courseSelectedComboBox, 126, SpringLayout.NORTH, contentPanel);
		sl_contentPanel.putConstraint(SpringLayout.WEST, courseSelectedComboBox, 236, SpringLayout.WEST, contentPanel);
		sl_contentPanel.putConstraint(SpringLayout.EAST, courseSelectedComboBox, 394, SpringLayout.WEST, contentPanel);
		sl_contentPanel.putConstraint(SpringLayout.NORTH, moduleNametextField, 78, SpringLayout.NORTH, contentPanel);
		sl_contentPanel.putConstraint(SpringLayout.WEST, moduleNametextField, 236, SpringLayout.WEST, contentPanel);
		sl_contentPanel.putConstraint(SpringLayout.EAST, moduleNametextField, 389, SpringLayout.WEST, contentPanel);
		sl_contentPanel.putConstraint(SpringLayout.NORTH, levelSelectedComboBox, 172, SpringLayout.NORTH, contentPanel);
		sl_contentPanel.putConstraint(SpringLayout.WEST, levelSelectedComboBox, 240, SpringLayout.WEST, contentPanel);
		sl_contentPanel.putConstraint(SpringLayout.EAST, levelSelectedComboBox, 394, SpringLayout.WEST, contentPanel);
		sl_contentPanel.putConstraint(SpringLayout.NORTH, semesterSelectedComboBox, 225, SpringLayout.NORTH, contentPanel);
		sl_contentPanel.putConstraint(SpringLayout.WEST, semesterSelectedComboBox, 236, SpringLayout.WEST, contentPanel);
		sl_contentPanel.putConstraint(SpringLayout.EAST, semesterSelectedComboBox, 390, SpringLayout.WEST, contentPanel);
		sl_contentPanel.putConstraint(SpringLayout.NORTH, lblNewLabel_2_1, 228, SpringLayout.NORTH, contentPanel);
		sl_contentPanel.putConstraint(SpringLayout.WEST, lblNewLabel_2_1, 107, SpringLayout.WEST, contentPanel);
		sl_contentPanel.putConstraint(SpringLayout.NORTH, lblNewLabel_4, 15, SpringLayout.NORTH, contentPanel);
		sl_contentPanel.putConstraint(SpringLayout.WEST, lblNewLabel_4, 200, SpringLayout.WEST, contentPanel);
		contentPanel.setLayout(sl_contentPanel);
		contentPanel.add(lblNewLabel);
		contentPanel.add(lblNewLabel_1);
		contentPanel.add(lblNewLabel_4);
		contentPanel.add(lblNewLabel_3);
		contentPanel.add(lblNewLabel_2);
		contentPanel.add(lblNewLabel_2_1);
		contentPanel.add(semesterSelectedComboBox);
		contentPanel.add(creditValueTextField);
		contentPanel.add(isOptionalModuleCheckBox);
		contentPanel.add(levelSelectedComboBox);
		contentPanel.add(moduleNametextField);
		contentPanel.add(courseSelectedComboBox);
		contentPanel.add(addModuleButton);
	}
}