package CourseManagementSystem;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Backend.Database;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JComboBox;
import javax.swing.ButtonModel;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.SpringLayout;
import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.ImageIcon;

public class CourseForm extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField courseNameTextField;
	private JTextField courseDescriptionTextField;
	private JLabel lblNoOfModules;
	private JTextField noOfModulesTextField;
	private JTextField lengthOfTheCourseTextField;
	private JLabel lblLengthOfThe;
	private JLabel lblNewLabel_1;
	private String courseName = "";
	private String courseDescription = "";
	private String lengthOfTheCourse = "";
	private String noOfModules = "";
	private String courseType = "";
	private String isCourseActivated = "";
	private JButton addCourseButton;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			CourseForm dialog = new CourseForm();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public CourseForm() {
		setTitle("Course Form");
		setBounds(100, 100, 578, 408);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(192, 192, 192));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);

		JLabel lblNewLabel = new JLabel("Course Name\r\n");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\DeLL\\Downloads\\icons8-knowledge-sharing-15.png"));

		courseNameTextField = new JTextField();
		courseNameTextField.setColumns(10);

		JLabel lblCourseDescription = new JLabel("Course Description\r\n\r\n");
		lblCourseDescription.setIcon(new ImageIcon("C:\\Users\\DeLL\\Downloads\\icons8-description-15.png"));

		courseDescriptionTextField = new JTextField();
		courseDescriptionTextField.setColumns(10);

		lblNoOfModules = new JLabel("No Of Modules");
		lblNoOfModules.setIcon(new ImageIcon("C:\\Users\\DeLL\\Downloads\\icons8-module-15 (1).png"));

		noOfModulesTextField = new JTextField();
		noOfModulesTextField.setColumns(10);

		lengthOfTheCourseTextField = new JTextField();
		lengthOfTheCourseTextField.setColumns(10);

		lblLengthOfThe = new JLabel("Length of the Course(in Years)\r\n");
		lblLengthOfThe.setIcon(new ImageIcon("C:\\Users\\DeLL\\Downloads\\icons8-courses-15.png"));

		lblNewLabel_1 = new JLabel("CourseType\r\n");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\DeLL\\Downloads\\icons8-user-typing-using-typewriter-15.png"));

		JComboBox courseTypecomboBox = new JComboBox();
		courseTypecomboBox.setModel(new DefaultComboBoxModel(new String[] {"Select course type", "UnderGraduate", "PostGraduate"}));
		SpringLayout sl_contentPanel = new SpringLayout();
		sl_contentPanel.putConstraint(SpringLayout.WEST, lblCourseDescription, 86, SpringLayout.WEST, contentPanel);
		sl_contentPanel.putConstraint(SpringLayout.EAST, lblCourseDescription, -46, SpringLayout.WEST, courseDescriptionTextField);
		sl_contentPanel.putConstraint(SpringLayout.NORTH, lengthOfTheCourseTextField, 24, SpringLayout.SOUTH, courseDescriptionTextField);
		sl_contentPanel.putConstraint(SpringLayout.SOUTH, lengthOfTheCourseTextField, -189, SpringLayout.SOUTH, contentPanel);
		sl_contentPanel.putConstraint(SpringLayout.WEST, courseDescriptionTextField, 0, SpringLayout.WEST,
				courseNameTextField);
		sl_contentPanel.putConstraint(SpringLayout.WEST, lengthOfTheCourseTextField, 27, SpringLayout.EAST,
				lblLengthOfThe);
		sl_contentPanel.putConstraint(SpringLayout.NORTH, courseDescriptionTextField, 25, SpringLayout.SOUTH, courseNameTextField);
		sl_contentPanel.putConstraint(SpringLayout.SOUTH, courseDescriptionTextField, -250, SpringLayout.SOUTH, contentPanel);
		sl_contentPanel.putConstraint(SpringLayout.NORTH, noOfModulesTextField, 32, SpringLayout.SOUTH, lblCourseDescription);
		sl_contentPanel.putConstraint(SpringLayout.SOUTH, noOfModulesTextField, -62, SpringLayout.NORTH, courseTypecomboBox);
		sl_contentPanel.putConstraint(SpringLayout.NORTH, lblNoOfModules, 40, SpringLayout.SOUTH, lblCourseDescription);
		sl_contentPanel.putConstraint(SpringLayout.EAST, courseTypecomboBox, -300, SpringLayout.EAST, contentPanel);
		sl_contentPanel.putConstraint(SpringLayout.WEST, courseTypecomboBox, 31, SpringLayout.EAST, lblNewLabel_1);
		sl_contentPanel.putConstraint(SpringLayout.NORTH, courseTypecomboBox, -3, SpringLayout.NORTH, lblNewLabel_1);
		sl_contentPanel.putConstraint(SpringLayout.NORTH, lblNewLabel_1, 73, SpringLayout.SOUTH, lblNoOfModules);
		sl_contentPanel.putConstraint(SpringLayout.WEST, lblNewLabel_1, 0, SpringLayout.WEST, lblNoOfModules);
		sl_contentPanel.putConstraint(SpringLayout.EAST, lengthOfTheCourseTextField, 0, SpringLayout.EAST,
				courseNameTextField);
		sl_contentPanel.putConstraint(SpringLayout.WEST, noOfModulesTextField, 0, SpringLayout.EAST, lblNoOfModules);
		sl_contentPanel.putConstraint(SpringLayout.EAST, noOfModulesTextField, -369, SpringLayout.EAST, contentPanel);
		sl_contentPanel.putConstraint(SpringLayout.NORTH, lblLengthOfThe, 0, SpringLayout.NORTH, lblNoOfModules);
		sl_contentPanel.putConstraint(SpringLayout.WEST, lblLengthOfThe, 67, SpringLayout.EAST, noOfModulesTextField);
		sl_contentPanel.putConstraint(SpringLayout.WEST, lblNoOfModules, 21, SpringLayout.WEST, contentPanel);
		sl_contentPanel.putConstraint(SpringLayout.EAST, lblNoOfModules, -421, SpringLayout.EAST, contentPanel);
		sl_contentPanel.putConstraint(SpringLayout.WEST, courseNameTextField, 91, SpringLayout.EAST, lblNewLabel);
		sl_contentPanel.putConstraint(SpringLayout.EAST, courseNameTextField, -52, SpringLayout.EAST, contentPanel);
		sl_contentPanel.putConstraint(SpringLayout.EAST, courseDescriptionTextField, 0, SpringLayout.EAST,
				courseNameTextField);
		sl_contentPanel.putConstraint(SpringLayout.NORTH, lblCourseDescription, 40, SpringLayout.SOUTH, lblNewLabel);
		sl_contentPanel.putConstraint(SpringLayout.NORTH, lblNewLabel, 8, SpringLayout.NORTH, courseNameTextField);
		sl_contentPanel.putConstraint(SpringLayout.WEST, lblNewLabel, 86, SpringLayout.WEST, contentPanel);
		sl_contentPanel.putConstraint(SpringLayout.NORTH, courseNameTextField, 27, SpringLayout.NORTH, contentPanel);
		sl_contentPanel.putConstraint(SpringLayout.SOUTH, courseNameTextField, 57, SpringLayout.NORTH, contentPanel);
		contentPanel.setLayout(sl_contentPanel);
		contentPanel.add(lblNoOfModules);
		contentPanel.add(lblNewLabel_1);
		contentPanel.add(courseTypecomboBox);
		contentPanel.add(noOfModulesTextField);
		contentPanel.add(lblLengthOfThe);
		contentPanel.add(lengthOfTheCourseTextField);
		contentPanel.add(lblCourseDescription);
		contentPanel.add(lblNewLabel);
		contentPanel.add(courseNameTextField);
		contentPanel.add(courseDescriptionTextField);

		JCheckBox courseActivatedCheckBox = new JCheckBox("Activated");
		sl_contentPanel.putConstraint(SpringLayout.NORTH, courseActivatedCheckBox, -4, SpringLayout.NORTH,
				lblNewLabel_1);
		sl_contentPanel.putConstraint(SpringLayout.WEST, courseActivatedCheckBox, 98, SpringLayout.EAST,
				courseTypecomboBox);
		sl_contentPanel.putConstraint(SpringLayout.SOUTH, courseActivatedCheckBox, -105, SpringLayout.SOUTH,
				contentPanel);
		sl_contentPanel.putConstraint(SpringLayout.EAST, courseActivatedCheckBox, -123, SpringLayout.EAST,
				contentPanel);
		contentPanel.add(courseActivatedCheckBox);
		
		
		addCourseButton = new JButton("Add Course");
		sl_contentPanel.putConstraint(SpringLayout.WEST, addCourseButton, 202, SpringLayout.WEST, contentPanel);
		sl_contentPanel.putConstraint(SpringLayout.SOUTH, addCourseButton, -33, SpringLayout.SOUTH, contentPanel);
		addCourseButton.setActionCommand("AddCourse");
		addCourseButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getActionCommand().equals("AddCourse")) {
					// Get the Course Form data
					courseName = courseNameTextField.getText().trim();
					courseDescription = courseDescriptionTextField.getText().trim();
					lengthOfTheCourse = lengthOfTheCourseTextField.getText().trim();
					noOfModules = noOfModulesTextField.getText().trim();

					ComboBoxModel courseTypeBoxModel = courseTypecomboBox.getModel();
					courseType = courseTypeBoxModel.getSelectedItem().toString();

					if (courseActivatedCheckBox.isSelected()) {
						isCourseActivated = "YES";
					} else {
						isCourseActivated = "NO";
					}

					// Write the SQL insert query

					String insertQuery = "INSERT INTO `course`"
							+ " (`CourseId`, `CourseName`, `CourseDescription`, `NoOfModules`, `LengthOfTheCourse`, `CourseType`, `IsCourseActivated`) "
							+ "VALUES (NULL, '" + courseName + "', '" + courseDescription + "', '" + noOfModules
							+ "', '" + lengthOfTheCourse + "', '" + courseType + "', '" + isCourseActivated + "')";

					// Execute the SQL insert query
					Statement statement = Database.getStatement();

					try {
						int insertSuccess = statement.executeUpdate(insertQuery);
						if (insertSuccess == 1) {
							JOptionPane.showMessageDialog(contentPanel, "Saved into database!");
						}
					} catch (SQLException e1) {
						e1.printStackTrace();
					}

					//Refresh the JTable sync with Database table data
					Dashboard.showCourseDataInJtableFromDb();

					//Close the courseForm
					Dashboard.courseForm.setVisible(false);


				}

			}
		});
		contentPanel.add(addCourseButton);
	}

	public JButton getAddCourseButton() {
		return addCourseButton;
	}

	public void setAddCourseButton(JButton addCourseButton) {
		this.addCourseButton = addCourseButton;
	}

	public JTextField getCourseNameTextField() {
		return courseNameTextField;
	}

	public void setCourseNameTextField(JTextField courseNameTextField) {
		this.courseNameTextField = courseNameTextField;
	}

	public JTextField getCourseDescriptionTextField() {
		return courseDescriptionTextField;
	}

	public void setCourseDescriptionTextField(JTextField courseDescriptionTextField) {
		this.courseDescriptionTextField = courseDescriptionTextField;
	}

	public JTextField getNoOfModulesTextField() {
		return noOfModulesTextField;
	}

	public void setNoOfModulesTextField(JTextField noOfModulesTextField) {
		this.noOfModulesTextField = noOfModulesTextField;
	}

	public JTextField getLengthOfTheCourseTextField() {
		return lengthOfTheCourseTextField;
	}

	public void setLengthOfTheCourseTextField(JTextField lengthOfTheCourseTextField) {
		this.lengthOfTheCourseTextField = lengthOfTheCourseTextField;
	}
}