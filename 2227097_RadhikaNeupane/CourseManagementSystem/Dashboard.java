package CourseManagementSystem;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SpringLayout;
import javax.swing.table.DefaultTableModel;

import com.mysql.cj.api.jdbc.Statement;

import Backend.Database;


import javax.swing.JToolBar;
import javax.swing.ImageIcon;

public class Dashboard {
	
	private JFrame frame;
	private JSplitPane mainSplitPane;
	private JPanel panel;
	private JPanel panel_1;
	private JLabel lblNewLabel;
	private JButton btnNewButton_2;
	private JButton btnNewButton_1;
	private JButton btnNewButton_3;
	private JButton btnNewButton;
	private JSplitPane splitPane;
	private JPanel panel_2;
	private final JButton btnNewButton_4 = new JButton("5 Instructors");
	private final JButton btnNewButton_5 = new JButton("10 Students");
	private JLabel lblNewLabel_1;
	private JButton btnNewButton_6;
	private JPanel cardPanel;
	private CardLayout cardLayout=new CardLayout(0, 0);
	private JTable courseJtable;
	private JScrollPane scrollPane_2;
	private JTable coursetable;
	private JScrollPane scrollPane_3;
	private JTable table_1;
	private JTable instructortable;
	
	private static DefaultTableModel instructorDefaultTableModel= new DefaultTableModel(
			new Object[][] {
				{"", "", "", "", "", "", ""},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
			},
			new String[] {
				"ID", "Name", "MobileNumber", "Address", "ModuleAssigned ", "QualifiedDegree", "Gender"
			}
		);
	
	private static DefaultTableModel courseDefaultTableModel= new DefaultTableModel(
			new Object[][] {
				{"", "", "", "", "", ""},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
			},
			new String[] {
				"CourseName", "CourseDescription", "NoOfModules", "LengthOfTheCourse", "CourseType", "IsCourseActivated"
			}
		);
	
	final static CourseForm courseForm = new CourseForm();
	private JTable table;
	
	private static DefaultTableModel studentDefaultTableModel=new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
			},
			new String[] {
				"StudentId", "StudentName", "Address", "Level", "Semester"
			}
		);
	
	
	
	private static DefaultTableModel moduleDefaultTableModel=new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null}
				},
			new String[] {
				"ModuleName", "CourseName", "Level", "Semester", "CreditValue", "OptionalModule"
			}
		);
	final static ModuleForm moduleForm = new ModuleForm();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Dashboard window = new Dashboard();

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Dashboard() {
		initialize();
	}
	
	public static void showInstructorDataInTableFromDb() {
		Statement statement = (Statement) Database.getStatement();

		String selectQuery = "SELECT * FROM `instructor`";

		ResultSet resultSet;
		try {
			resultSet = statement.executeQuery(selectQuery);
			instructorDefaultTableModel.setRowCount(0);
			while (resultSet.next()) {
				int idFromDb = resultSet.getInt("ID");
				String nameFromDb = resultSet.getString("Name");
				String mobileNoFromDb = resultSet.getString("MobileNumber");
				String addressFromDb = resultSet.getString("Address");
		        String moduleAssignedFromDb = resultSet.getString("ModuleAssigned");
		        String qualifiedDegreeFromDb = resultSet.getString("QualifiedDegree");
				String genderFromDb = resultSet.getString("Gender");

				instructorDefaultTableModel.addRow(new Object[] { idFromDb, nameFromDb, mobileNoFromDb, addressFromDb,
						moduleAssignedFromDb,qualifiedDegreeFromDb,genderFromDb });


			}
				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public static void showCourseDataInJtableFromDb() {
		Statement statement = (Statement) Database.getStatement();

		String selectQuery = "SELECT * FROM `course`";

		ResultSet resultSet;
		try {
			resultSet = statement.executeQuery(selectQuery);
			courseDefaultTableModel.setRowCount(0);
			while (resultSet.next()) {
				String courseNameFromDb = resultSet.getString("CourseName");
				String courseDecriptionFromDb = resultSet.getString("CourseDescription");
				int noOfModulesFromDb = resultSet.getInt("NoOfModules");
				int lengthOfTheCourseFromDb = resultSet.getInt("LengthOfTheCourse");
				String courseTypeFromDb = resultSet.getString("CourseType");
				String IsCourseActivatedFromDb = resultSet.getString("IsCourseActivated");

				courseDefaultTableModel.addRow(new Object[] { courseNameFromDb, courseDecriptionFromDb,
						noOfModulesFromDb, lengthOfTheCourseFromDb, courseTypeFromDb, IsCourseActivatedFromDb });

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public static void showStudentDataInJtableFromDb() {
		Statement statement = (Statement) Database.getStatement();

		String selectQuery = "SELECT * FROM `student`";

		ResultSet resultSet;
		try {
			resultSet = statement.executeQuery(selectQuery);
			studentDefaultTableModel.setRowCount(0);
			while (resultSet.next()) {
				int StudentIdFromDb = resultSet.getInt("StudentId");
				String StudentNameFromDb = resultSet.getString("StudentName");
				String AddressFromDb = resultSet.getString("Address");
				String LevelFromDb = resultSet.getString("Level");
				String SemesterFromDb = resultSet.getString("Semester");
				
				studentDefaultTableModel.addRow(new Object[] {StudentIdFromDb ,StudentNameFromDb,
						AddressFromDb ,LevelFromDb ,SemesterFromDb });

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public static void showModuleDataInJtableFromDb() {
		Statement statement = (Statement) Database.getStatement();

		String selectQuery = "SELECT * FROM `module`";

		ResultSet resultSet;
		try {
			resultSet = statement.executeQuery(selectQuery);
			moduleDefaultTableModel.setRowCount(0);
			while (resultSet.next()) {
				
				String ModuleNameFromDb = resultSet.getString("ModuleName");
				String CourseNameFromDb = resultSet.getString("CourseName");
				String LevelFromDb = resultSet.getString("Level");
				String SemesterFromDb = resultSet.getString("Semester");
				int CreditValueFromDb = resultSet.getInt("CreditValue");
				String OptionalModuleFromDb = resultSet.getString("OptionalModule");
				
				moduleDefaultTableModel.addRow(new Object[] { ModuleNameFromDb,CourseNameFromDb,LevelFromDb,SemesterFromDb,CreditValueFromDb,OptionalModuleFromDb});

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("Dashboard");
		frame.setBounds(100, 100, 552, 393);
		mainSplitPane = new JSplitPane();
		mainSplitPane.setDividerSize(0);
		frame.setContentPane(mainSplitPane);

		panel = new JPanel();
		panel.setBackground(Color.GRAY);
		panel.setForeground(Color.GRAY);
		mainSplitPane.setLeftComponent(panel);

		lblNewLabel = new JLabel("Welcome Admin");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\DeLL\\Downloads\\icons8-administrator-male-20.png"));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));

		btnNewButton = new JButton("Instructor");
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\DeLL\\Downloads\\icons8-teachers-15.png"));
		btnNewButton.setBackground(new Color(204, 204, 204));
		btnNewButton.addActionListener(new ActionListener() {
	

			public void actionPerformed(ActionEvent e) {
				cardLayout.show(cardPanel, "name_994193187578700");
							}
		});

		btnNewButton_1 = new JButton("Student");
		btnNewButton_1.setIcon(new ImageIcon("C:\\Users\\DeLL\\Downloads\\icons8-man-reading-a-book-15.png"));
		btnNewButton_1.setBackground(new Color(204, 204, 204));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(cardPanel, "name_994201842460500");
			
			}
		});

		btnNewButton_2 = new JButton("Courses");
		btnNewButton_2.setIcon(new ImageIcon("C:\\Users\\DeLL\\Downloads\\icons8-courses-13.png"));
		btnNewButton_2.setBackground(new Color(204, 204, 204));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(cardPanel,"name_994204579181900");
				

			}
		});

		btnNewButton_3 = new JButton("Log Out");
		btnNewButton_3.setIcon(new ImageIcon("C:\\Users\\DeLL\\Downloads\\icons8-log-out-15.png"));
		btnNewButton_3.setBackground(new Color(204, 204, 204));
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
					int result = JOptionPane.showConfirmDialog(null, "Are you sure want to log out?", "Log out?", JOptionPane.YES_NO_OPTION);
					
					if (result == JOptionPane.YES_OPTION) {
						frame.setVisible(false);
				    } else if (result == JOptionPane.NO_OPTION) {
				    	new JButton("Logout");
				    }
					
				}
				
				
			
		});

		JButton btnNewButton_2_2 = new JButton("Module");
		btnNewButton_2_2.setIcon(new ImageIcon("C:\\Users\\DeLL\\Downloads\\icons8-module-15.png"));
		btnNewButton_2_2.setBackground(new Color(204, 204, 204));
		btnNewButton_2_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(cardPanel, "name_994229881693500");
			}
		});

		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(btnNewButton, GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE)
							.addGap(23))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(btnNewButton_1, GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE)
							.addGap(23))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(btnNewButton_2, GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE)
							.addGap(23))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 141, Short.MAX_VALUE)
							.addContainerGap())
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(btnNewButton_3, GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE)
							.addGap(23))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(btnNewButton_2_2, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE)
							.addContainerGap(23, Short.MAX_VALUE))))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(30)
					.addComponent(lblNewLabel)
					.addGap(35)
					.addComponent(btnNewButton)
					.addGap(30)
					.addComponent(btnNewButton_1)
					.addGap(30)
					.addComponent(btnNewButton_2)
					.addPreferredGap(ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
					.addComponent(btnNewButton_2_2)
					.addGap(30)
					.addComponent(btnNewButton_3)
					.addGap(25))
		);
		panel.setLayout(gl_panel);

		panel_1 = new JPanel();
		mainSplitPane.setRightComponent(panel_1);
		panel_1.setLayout(null);

		splitPane = new JSplitPane();
		splitPane.setDividerSize(0);
		splitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
		splitPane.setBounds(0, 0, 368, 354);
		panel_1.add(splitPane);

		panel_2 = new JPanel();
		panel_2.setBackground(new Color(230, 230, 250));
		splitPane.setLeftComponent(panel_2);
		btnNewButton_4.setBackground(new Color(204, 204, 204));

		panel_2.add(btnNewButton_4);
		btnNewButton_5.setBackground(new Color(204, 204, 204));
		panel_2.add(btnNewButton_5);

		cardPanel = new JPanel();
		splitPane.setRightComponent(cardPanel);
		cardPanel.setLayout(cardLayout);

		JPanel instructorPanel = new JPanel();
		instructorPanel.setBackground(new Color(230, 230, 250));
		cardPanel.add(instructorPanel, "name_994193187578700");

		lblNewLabel_1 = new JLabel("Instructor View");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));

		btnNewButton_6 = new JButton("Add Instructor");
		btnNewButton_6.setBackground(new Color(204, 204, 204));
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InstructorRegistrationForm instructorForm = new InstructorRegistrationForm();
				instructorForm.setVisible(true);
			}
		});

		JScrollPane scrollPane = new JScrollPane();
		GroupLayout gl_instructorPanel = new GroupLayout(instructorPanel);
		gl_instructorPanel.setHorizontalGroup(
			gl_instructorPanel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_instructorPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_instructorPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_instructorPanel.createParallelGroup(Alignment.LEADING)
							.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 366, Short.MAX_VALUE)
							.addGroup(Alignment.TRAILING, gl_instructorPanel.createSequentialGroup()
								.addComponent(lblNewLabel_1)
								.addGap(117)))
						.addGroup(Alignment.TRAILING, gl_instructorPanel.createSequentialGroup()
							.addComponent(btnNewButton_6)
							.addGap(125))))
		);
		gl_instructorPanel.setVerticalGroup(
			gl_instructorPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_instructorPanel.createSequentialGroup()
					.addGap(30)
					.addComponent(lblNewLabel_1)
					.addGap(45)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 121, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
					.addComponent(btnNewButton_6)
					.addGap(31))
		);
		
		instructortable = new JTable();
		instructortable.setBackground(new Color(204, 204, 204));
		instructortable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Object[] options = { "Update", "Delete" };
				int n = JOptionPane.showOptionDialog(null, "Do you want to update or delete instructor's data?",
						"Update or Delete Instructor", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null,
						options, options[0]);
				if (n == 0) {// update

					InstructorRegistrationForm updateInstructorRegistrationForm = new InstructorRegistrationForm();
					updateInstructorRegistrationForm.setVisible(true);
					updateInstructorRegistrationForm.setTitle("Updated Instructor Form");

					JButton updateButton = updateInstructorRegistrationForm.getSubmitButton();
					updateButton.setText("Update");
					
					 String Name = "";
					 String MobileNumber = "";
					 String Address = "";
					 String Gender = "";
					 String QualifiedDegree = "";
					 String  ModuleAssigned= "";
					 int selectedRowNo = instructortable.getSelectedRow();
					for (int columnIndex = 1; columnIndex < instructortable.getColumnCount(); columnIndex++) {
						if (Name.isEmpty()) {
							Name = instructortable.getValueAt(instructortable.getSelectedRow(), columnIndex).toString();
						} 
						else if (MobileNumber.isEmpty()) {
							MobileNumber = instructortable.getValueAt(instructortable.getSelectedRow(), columnIndex).toString();
						} 
						else if (Address.isEmpty()) {
							Address = instructortable.getValueAt(instructortable.getSelectedRow(), columnIndex).toString();
						} 
						else if (ModuleAssigned.isEmpty()) {
							ModuleAssigned= instructortable.getValueAt(instructortable.getSelectedRow(), columnIndex).toString();
						}
						else if (QualifiedDegree.isEmpty()) {
							QualifiedDegree = instructortable.getValueAt(instructortable.getSelectedRow(), columnIndex).toString();
						} 
						else if (Gender.isEmpty()) {
							Gender = instructortable.getValueAt(instructortable.getSelectedRow(), columnIndex).toString();
						} 
					}
					
					updateInstructorRegistrationForm.getFullNametextField().setText(Name);
					updateInstructorRegistrationForm.getMobileNumbertextField().setText(MobileNumber.toString());
					updateInstructorRegistrationForm.getAddresstextField().setText(Address);
					updateInstructorRegistrationForm.getModuleltextField().setText(ModuleAssigned);
					updateInstructorRegistrationForm.getDegreetextField().setText(QualifiedDegree);
					
					updateButton.setActionCommand("Update");
					updateButton.addActionListener(new ActionListener() {
						
						@Override
						public void actionPerformed(ActionEvent e) {
							// TODO Auto-generated method stub
							if (e.getActionCommand().equals("Update")) {
								
								JTextField fullNametextField = updateInstructorRegistrationForm.getFullNametextField();
								JTextField addressTextField = updateInstructorRegistrationForm.getAddresstextField();
								JTextField mobileNoTextField = updateInstructorRegistrationForm.getMobileNumbertextField();
								JTextField assignedmodule = updateInstructorRegistrationForm.getModuleltextField();
								
								String oldMobileNumber = (String) instructortable.getValueAt(instructortable.getSelectedRow(), 2);

								String updatedName = fullNametextField.getText().trim();
								String updatedMobileNo = mobileNoTextField.getText().trim();
								String updatedAddress = addressTextField.getText().trim();
					            String updatedAssignedmodule = assignedmodule.getText().trim();
					            
//					            int updateRowId = selectedRowNo+1;
					            //UPDATE `instructor` SET `MobileNumber` = '9876355674', `Address` = 'Gyaneshwor', `ModuleAssigned` = 'AI' WHERE `instructor`.`ID` = 1;
					            String updateQuery = "UPDATE `instructor` SET `MobileNumber` = '"+updatedMobileNo +"', `Address` = '"+updatedAddress +"', `ModuleAssigned` = '"+ updatedAssignedmodule +"' WHERE `instructor`.`MobileNumber` = "+oldMobileNumber+"";

								Statement statement = (Statement) Database.getStatement();
								try {
									int updateSuccess = statement.executeUpdate(updateQuery);
									if (updateSuccess == 1) {
										JOptionPane.showMessageDialog(scrollPane, "Data is updated!!");
									} else {
										JOptionPane.showMessageDialog(scrollPane,
												"Something went wrong in update operation!!");

									}

								} catch (SQLException e1) {
									e1.printStackTrace();
								}

								Dashboard.showInstructorDataInTableFromDb();

								System.out.println("Update is working....");
						

							}
						
						}
					});

				} else if (n == 1) { // delete

					 String deleteMobileNumber =(String) instructortable.getValueAt(instructortable.getSelectedRow(), 2);

					Statement statement = (Statement) Database.getStatement();

					String deleteQuery = "DELETE FROM instructor WHERE `instructor`.`MobileNumber` = " + deleteMobileNumber+ "";

					try {
						int deleteSuccess = statement.executeUpdate(deleteQuery);
						if (deleteSuccess == 1) {
							JOptionPane.showMessageDialog(scrollPane, "Data is deleted!!");
						} else {
							JOptionPane.showMessageDialog(scrollPane, "Something went wrong in delete operation!!");
						}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

					Dashboard.showInstructorDataInTableFromDb();

				}
			}
		});
					
		
		instructortable.setDefaultEditor(Object.class, null);
		
		
		
		instructortable.setModel(instructorDefaultTableModel);
		instructortable.getColumnModel().getColumn(1).setPreferredWidth(70);
		instructortable.getColumnModel().getColumn(2).setPreferredWidth(83);
		instructortable.getColumnModel().getColumn(4).setPreferredWidth(95);
		instructortable.getColumnModel().getColumn(5).setPreferredWidth(91);
		scrollPane.setViewportView(instructortable);
		instructorPanel.setLayout(gl_instructorPanel);
		
		

		JPanel studentPanel = new JPanel();
		studentPanel.setBackground(new Color(204, 204, 255));
		cardPanel.add(studentPanel, "name_994201842460500");
		
		JLabel lblNewLabel_2 = new JLabel("Student View");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		JScrollPane scrollPane_1 = new JScrollPane();
		
		JButton btnNewButton_7 = new JButton("Add Student");
		btnNewButton_7.setBackground(new Color(192, 192, 192));
		btnNewButton_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StudentForm studentForm = new StudentForm(); 
				studentForm.setVisible(true);
				
			}
		});
		GroupLayout gl_studentPanel = new GroupLayout(studentPanel);
		gl_studentPanel.setHorizontalGroup(
			gl_studentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_studentPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_studentPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_studentPanel.createSequentialGroup()
							.addComponent(scrollPane_1, GroupLayout.DEFAULT_SIZE, 346, Short.MAX_VALUE)
							.addContainerGap())
						.addGroup(Alignment.TRAILING, gl_studentPanel.createSequentialGroup()
							.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 138, GroupLayout.PREFERRED_SIZE)
							.addGap(97))))
				.addGroup(gl_studentPanel.createSequentialGroup()
					.addGap(126)
					.addComponent(btnNewButton_7)
					.addContainerGap(147, Short.MAX_VALUE))
		);
		gl_studentPanel.setVerticalGroup(
			gl_studentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_studentPanel.createSequentialGroup()
					.addGap(27)
					.addComponent(lblNewLabel_2)
					.addGap(35)
					.addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE)
					.addGap(55)
					.addComponent(btnNewButton_7)
					.addContainerGap(67, Short.MAX_VALUE))
		);
		
		table = new JTable();
		table.setBackground(new Color(204, 204, 204));
		table.setModel(studentDefaultTableModel);
		table.getColumnModel().getColumn(1).setPreferredWidth(83);
		scrollPane_1.setViewportView(table);
		studentPanel.setLayout(gl_studentPanel);

		JPanel coursePanel = new JPanel();
		coursePanel.setBackground(new Color(204, 204, 255));
		cardPanel.add(coursePanel, "name_994204579181900");
		coursePanel.setLayout(null);
		
		JLabel lblNewLabel_6 = new JLabel("Course View");
		lblNewLabel_6.setBounds(131, 11, 96, 19);
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 15));
		coursePanel.add(lblNewLabel_6);
		
		JButton btnNewButton_8 = new JButton("BIBM");
		btnNewButton_8.setBackground(new Color(192, 192, 192));
		btnNewButton_8.setBounds(40, 47, 63, 23);
		btnNewButton_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_8.setFont(new Font("Tahoma", Font.BOLD, 11));
		coursePanel.add(btnNewButton_8);
		
		JButton btnNewButton_9 = new JButton("BIT");
		btnNewButton_9.setBackground(new Color(192, 192, 192));
		btnNewButton_9.setBounds(258, 47, 53, 23);
		btnNewButton_9.setFont(new Font("Tahoma", Font.BOLD, 11));
		coursePanel.add(btnNewButton_9);
		
		scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(10, 93, 346, 125);
		coursePanel.add(scrollPane_2);
		
		coursetable = new JTable();
		coursetable.setBackground(new Color(204, 204, 204));
		coursetable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// ColumnIndex = 0 of CourseName in JTable

				String coursename = coursetable.getValueAt(coursetable.getSelectedRow(), 0).toString();

				Object[] options = { "Update Course", "Deactivate Course", "Delete Course", "Add/View Modules" };
				int n = JOptionPane.showOptionDialog(null,
						"Do you want to update or deactivate or delete course or View Modules?",
						" Update ot Deactivate or Delete Course", JOptionPane.DEFAULT_OPTION,
						JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
				if (n == 0) {
					
					 CourseForm updateCourseForm = new CourseForm();
					  updateCourseForm .setVisible(true);
					  updateCourseForm .setTitle("Updated Course Form");
					  


						JButton updateButton = updateCourseForm.getAddCourseButton();	
						updateButton.setText("Update");
						
						 String courseName = "";
					     String courseDescription = "";
					     String lengthOfTheCourse = "";
						 String noOfModules = "";
						 int selectedRowNo = coursetable.getSelectedRow();
						for (int columnIndex = 1; columnIndex < coursetable.getColumnCount(); columnIndex++) {
							if (courseName.isEmpty()) {
								courseName = coursetable.getValueAt(coursetable.getSelectedRow(), columnIndex).toString();
							} 
							else if (courseDescription.isEmpty()) {
								courseDescription = coursetable.getValueAt(coursetable.getSelectedRow(), columnIndex).toString();
							} 
							else if (lengthOfTheCourse.isEmpty()) {
								lengthOfTheCourse= coursetable.getValueAt(coursetable.getSelectedRow(), columnIndex).toString();
							} 
							else if (noOfModules.isEmpty()) {
								noOfModules= coursetable.getValueAt(coursetable.getSelectedRow(), columnIndex).toString();
							}
						}
						

						
						 updateCourseForm.getCourseNameTextField().setText(courseName);
						 updateCourseForm.getCourseDescriptionTextField().setText(courseDescription);
						 updateCourseForm. getLengthOfTheCourseTextField().setText(lengthOfTheCourse);
						 updateCourseForm.getNoOfModulesTextField().setText(noOfModules);
						 
						
						updateButton.setActionCommand("Update");
						updateButton.addActionListener(new ActionListener() {
							
							@Override
							public void actionPerformed(ActionEvent e) {
								// TODO Auto-generated method stub
								if (e.getActionCommand().equals("Update")) {
									
									JTextField	courseNameTextField= updateCourseForm.getCourseNameTextField();
									JTextField courseDescriptionTextField= updateCourseForm.getCourseDescriptionTextField();
									JTextField noOfModulesTextField= updateCourseForm.getNoOfModulesTextField();
									JTextField lengthOfTheCourseTextField= updateCourseForm.getLengthOfTheCourseTextField();
										
									
									String oldMobileNumber = (String) instructortable.getValueAt(instructortable.getSelectedRow(), 2);

									String updatedcourseName = courseNameTextField.getText().trim();
									String updatedcourseDescription =courseDescriptionTextField.getText().trim();
									String updatedlengthOfTheCourse =lengthOfTheCourseTextField.getText().trim();
						            String updatednoOfModules = noOfModulesTextField.getText().trim();
						            
						            
						         
						            String updateQuery = "UPDATE `course` SET `CourseName` = '"+updatedcourseName+"', `CourseDescription` = '"+updatedcourseDescription+"', `NoOfModules` = '"+updatednoOfModules+"', `LengthOfTheCourse` = '"+updatedlengthOfTheCourse+"' WHERE `course`.`CourseName` = '"+coursename+"'";

									Statement statement = (Statement) Database.getStatement();
									try {
										int updateSuccess = statement.executeUpdate(updateQuery);
										if (updateSuccess == 1) {
											JOptionPane.showMessageDialog(scrollPane, "Data is updated!!");
										} else {
											JOptionPane.showMessageDialog(scrollPane,
													"Something went wrong in update operation!!");

										}

									} catch (SQLException e1) {
										e1.printStackTrace();
									}

									Dashboard.showInstructorDataInTableFromDb();

									System.out.println("Update is working....");
							

								}
							
							}
						});
					  
					  
					
				} else if (n == 1) { // Deactivate Course
				

					int yesOrNo = JOptionPane.showConfirmDialog(null, "Are sure you want to deactivate this course?",
							"Deactivate the course?", JOptionPane.YES_NO_OPTION);
					if (yesOrNo == 0) {
						// Update query for particular course
						String updateQuery = "UPDATE `course` SET `IsCourseActivated` = 'NO' "
								+ "WHERE `course`.`CourseName` = '" + coursename + "'";

						Statement statement = (Statement)Database.getStatement();

						try {
							int updateSuccess = statement.executeUpdate(updateQuery);
							if (updateSuccess == 1) {
								JOptionPane.showMessageDialog(coursePanel,
										"Successfully deactivated the course into database!");
							} else {
								JOptionPane.showMessageDialog(coursePanel,
										"Something went wrong in deactivation operation ");
							}
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}

					}

				} else if (n == 2) { 
					
					String deleteQueryForModule = "DELETE FROM module "
							+ "WHERE `module`.`CourseName` = '"+coursename +"'";
					String deleteQueryForCourse = "DELETE FROM course "
							+ "WHERE `course`.`CourseName` = '"+coursename+"'";
					
					Statement statement = (Statement)Database.getStatement();
					try {
						statement.executeUpdate(deleteQueryForModule);
						statement.executeUpdate(deleteQueryForCourse);
						JOptionPane.showMessageDialog(coursePanel,"Successfully deleted course and its realted modules as well from Database!");
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
					
					Dashboard.showCourseDataInJtableFromDb();

				} else if (n == 3) {// Add/View modules
					Object[] moduleOptions = { "Add Modules", "View Modules" };
					int selectedOption = JOptionPane.showOptionDialog(null, "Do you want to view or add Modules?",
							" Add or View Modules", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null,
							moduleOptions, moduleOptions[0]);
					if (selectedOption == 0) { // open add Module form
						ModuleForm moduleForm = new ModuleForm();
						moduleForm.setVisible(true);

					} else if (selectedOption == 1) {
//						ModuleCRUDView moduleCRUDView = new ModuleCRUDView();
//						moduleCRUDView.setVisible(true);
						
					}

				
			}
			}
		});
		coursetable.setModel(courseDefaultTableModel);
		coursetable.getColumnModel().getColumn(0).setPreferredWidth(77);
		coursetable.getColumnModel().getColumn(1).setPreferredWidth(104);
		coursetable.getColumnModel().getColumn(2).setPreferredWidth(76);
		coursetable.getColumnModel().getColumn(3).setPreferredWidth(109);
		coursetable.getColumnModel().getColumn(4).setPreferredWidth(80);
		coursetable.getColumnModel().getColumn(5).setPreferredWidth(102);
		scrollPane_2.setViewportView(coursetable);
		
		JButton addcoursebutton = new JButton("Add Course");
		addcoursebutton.setBackground(new Color(192, 192, 192));
		addcoursebutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CourseForm courseForm = new CourseForm();
				courseForm.setVisible(true);
			}
		});
		addcoursebutton.setBounds(124, 259, 130, 23);
		coursePanel.add(addcoursebutton);

		JPanel modulePanel = new JPanel();
		modulePanel.setBackground(new Color(204, 204, 255));
		cardPanel.add(modulePanel, "name_994229881693500");
		
		JLabel lblNewLabel_3 = new JLabel("Module View");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		scrollPane_3 = new JScrollPane();
		SpringLayout sl_modulePanel = new SpringLayout();
		sl_modulePanel.putConstraint(SpringLayout.NORTH, lblNewLabel_3, 41, SpringLayout.NORTH, modulePanel);
		sl_modulePanel.putConstraint(SpringLayout.WEST, lblNewLabel_3, 121, SpringLayout.WEST, modulePanel);
		sl_modulePanel.putConstraint(SpringLayout.EAST, lblNewLabel_3, 242, SpringLayout.WEST, modulePanel);
		sl_modulePanel.putConstraint(SpringLayout.NORTH, scrollPane_3, 105, SpringLayout.NORTH, modulePanel);
		sl_modulePanel.putConstraint(SpringLayout.WEST, scrollPane_3, 18, SpringLayout.WEST, modulePanel);
		sl_modulePanel.putConstraint(SpringLayout.SOUTH, scrollPane_3, 198, SpringLayout.NORTH, modulePanel);
		sl_modulePanel.putConstraint(SpringLayout.EAST, scrollPane_3, 338, SpringLayout.WEST, modulePanel);
		modulePanel.setLayout(sl_modulePanel);
		modulePanel.add(scrollPane_3);
		
		table_1 = new JTable();
		table_1.setBackground(new Color(204, 204, 204));
		table_1.setModel(moduleDefaultTableModel);
		table_1.setForeground(new Color(0, 0, 0));
		scrollPane_3.setViewportView(table_1);
		modulePanel.add(lblNewLabel_3);

		frame.setVisible(true);
		
		Dashboard.showInstructorDataInTableFromDb();
		Dashboard.showCourseDataInJtableFromDb();
        Dashboard.showStudentDataInJtableFromDb();
        Dashboard.showModuleDataInJtableFromDb();
        
        
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}

