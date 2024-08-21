package CourseManagementSystem;


import java.awt.CardLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.math.BigDecimal;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Enumeration;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.ComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.GroupLayout.Alignment;
import javax.swing.table.DefaultTableModel;

import Backend.Database;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SpringLayout;

public class InstructorDashboard {

	private JFrame frmInstructorDashboard ;
	private CardLayout cl_cardPanel = new CardLayout(0, 0);
	private JPanel cardPanel;

	private static String moduleNameForQuery = "";
	private JTextField questionNo1textField;
	private JTextField questionNo2TextField;
	private JLabel moduleNameTextField;
	private JLabel instructorNameJLabel;
	private static DefaultTableModel studentDefaultTableModel = new DefaultTableModel(
			new Object[][] { { null, null }, { null, null }, { null, null }, },
			new String[] { "StudentId", "Submitted" });
	private JTextField studentIdTextFeild;
	private JTextField totalMarksTextField;
	private JLabel questionNo2JLabel;
	private JLabel questionNo1AnswerJLabel;
	private JLabel questionNo2AnswerJLabel;
	private JLabel questionNo1JLabel;

	public JFrame getFrmDashboard() {
		return frmInstructorDashboard ;
	}

	public static void showStudentAssignmentInJtableFromDb() {
		Statement statement = Database.getStatement();

		String selectQuery = "SELECT * FROM `assignmentanswer` WHERE ModuleName ='" + moduleNameForQuery
				+ "' AND AssignmentSubmitted = 'YES'";
		studentDefaultTableModel.setRowCount(0);
		try {
			ResultSet resultSet = statement.executeQuery(selectQuery);

			while (resultSet.next()) {
				int studentIdFromDb = resultSet.getInt("StudentId");
				String assignmentSubmittedFromDb = resultSet.getString("AssignmentSubmitted");
				studentDefaultTableModel.addRow(new Object[] { studentIdFromDb, assignmentSubmittedFromDb });
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InstructorDashboard  window = new InstructorDashboard ("subash", "OODP", 3);
					window.frmInstructorDashboard .setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * 
	 * @param instructorId
	 * 
	 * @wbp.parser.entryPoint
	 */
	public InstructorDashboard (String instructorName, String moduleName, int instructorId) {
		moduleNameForQuery = moduleName;
		initialize(instructorName, moduleName, instructorId);
	}

	public InstructorDashboard() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Initialize the contents of the frame.
	 * 
	 * @param moduleName
	 * @param instructorName
	 * @param instructorId
	 * 
	 * @throws SQLException
	 */
	private void initialize(String instructorName, String moduleName, int instructorId) {
		frmInstructorDashboard  = new JFrame();

		frmInstructorDashboard .setTitle("Instructor Dashboard\r\n");
		frmInstructorDashboard .setBounds(100, 100, 1032, 448);
		JSplitPane splitPane = new JSplitPane();
		splitPane.setDividerSize(0);
		frmInstructorDashboard .setContentPane(splitPane);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(128, 128, 128));
		splitPane.setLeftComponent(panel);

		instructorNameJLabel = new JLabel("Welcome");
		instructorNameJLabel.setFont(new Font("Tahoma", Font.BOLD, 13));

		JButton btnNewButton = new JButton("Mark Assignment");
		btnNewButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				cl_cardPanel.show(cardPanel, "name_77231035427800");
			}
		});

		JButton btnNewButton_1 = new JButton("Add Assignment\r\n");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cl_cardPanel.show(cardPanel, "name_77250554168900");
			}
		});

		JButton btnNewButton_2 = new JButton("Logout\r\n");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int result = JOptionPane.showConfirmDialog(null, "Are you sure want to log out?", "Log out?", JOptionPane.YES_NO_OPTION);
				
				if (result == JOptionPane.YES_OPTION) {
					frmInstructorDashboard.setVisible(false);
			    } else if (result == JOptionPane.NO_OPTION) {
			    	new JButton("Logout");
			    }

			}
		});
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(instructorNameJLabel, GroupLayout.DEFAULT_SIZE, 129, Short.MAX_VALUE)
							.addContainerGap())
						.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
								.addComponent(btnNewButton_2, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 113, Short.MAX_VALUE)
								.addComponent(btnNewButton_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
							.addGap(26))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(btnNewButton)
							.addContainerGap())))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(20)
					.addComponent(instructorNameJLabel, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
					.addGap(61)
					.addComponent(btnNewButton)
					.addGap(35)
					.addComponent(btnNewButton_1)
					.addGap(55)
					.addComponent(btnNewButton_2)
					.addContainerGap(127, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);

		JSplitPane splitPane_1 = new JSplitPane();
		splitPane_1.setDividerSize(0);
		splitPane_1.setOrientation(JSplitPane.VERTICAL_SPLIT);
		splitPane.setRightComponent(splitPane_1);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(230, 230, 250));
		splitPane_1.setLeftComponent(panel_1);

		moduleNameTextField = new JLabel(moduleName);
		moduleNameTextField.setOpaque(true);
		moduleNameTextField.setFont(new Font("Tahoma", Font.PLAIN, 25));
		moduleNameTextField.setBackground(new Color(255, 128, 64));
		panel_1.add(moduleNameTextField);

		cardPanel = new JPanel();
		splitPane_1.setRightComponent(cardPanel);
		cardPanel.setLayout(cl_cardPanel);

		JPanel studentCardPanel = new JPanel();
		studentCardPanel.setBackground(new Color(230, 230, 250));
		cardPanel.add(studentCardPanel, "name_77231035427800");

		JLabel lblStudent = new JLabel("5 students");
		lblStudent.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblStudent.setOpaque(true);
		lblStudent.setBackground(new Color(0, 255, 64));

		JLabel lblNewLabel = new JLabel("Enter Student Id");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));

		studentIdTextFeild = new JTextField();
		studentIdTextFeild.setColumns(10);

		JButton viewAssignmentAnswerButton = new JButton("View Assignment");
		viewAssignmentAnswerButton.setFont(new Font("Tahoma", Font.PLAIN, 14));

		JPanel studentAssignmentPanel = new JPanel();
		studentAssignmentPanel.setVisible(false);
		GroupLayout gl_studentCardPanel = new GroupLayout(studentCardPanel);
		gl_studentCardPanel.setHorizontalGroup(gl_studentCardPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_studentCardPanel.createSequentialGroup().addGroup(gl_studentCardPanel
						.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_studentCardPanel.createSequentialGroup().addGap(354).addComponent(lblStudent,
								GroupLayout.PREFERRED_SIZE, 129, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_studentCardPanel.createSequentialGroup().addGap(84).addComponent(lblNewLabel)
								.addGap(26)
								.addComponent(studentIdTextFeild, GroupLayout.PREFERRED_SIZE, 140,
										GroupLayout.PREFERRED_SIZE)
								.addGap(54).addComponent(viewAssignmentAnswerButton, GroupLayout.PREFERRED_SIZE, 147,
										GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_studentCardPanel.createSequentialGroup().addGap(71).addComponent(
								studentAssignmentPanel, GroupLayout.PREFERRED_SIZE, 542, GroupLayout.PREFERRED_SIZE)))
						.addContainerGap(250, Short.MAX_VALUE)));
		gl_studentCardPanel.setVerticalGroup(gl_studentCardPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_studentCardPanel.createSequentialGroup().addGap(30).addComponent(lblStudent).addGap(25)
						.addGroup(gl_studentCardPanel.createParallelGroup(Alignment.BASELINE).addComponent(lblNewLabel)
								.addComponent(studentIdTextFeild, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(viewAssignmentAnswerButton, GroupLayout.PREFERRED_SIZE, 23,
										GroupLayout.PREFERRED_SIZE))
						.addGap(18).addComponent(studentAssignmentPanel, GroupLayout.DEFAULT_SIZE, 226, Short.MAX_VALUE)
						.addContainerGap()));

		questionNo1AnswerJLabel = new JLabel();

		questionNo2AnswerJLabel = new JLabel();

		totalMarksTextField = new JTextField();
		totalMarksTextField.setColumns(10);

		JLabel lblNewLabel_4 = new JLabel("Total marks");

		JButton btnNewButton_4 = new JButton("Add Marks");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String studentId = studentIdTextFeild.getText().trim();

				String totalMarks = totalMarksTextField.getText().trim();

				String insertQuery = "INSERT INTO `assignmentmark`"
						+ " (`assignmentmarkid`, `instructorid`, `studentid`, `ModuleName`, `assignmentMarks`, `marksAdded`) "
						+ "VALUES (NULL, '2', '"+ studentId+"', '"+moduleName +"', '"+totalMarks +"', 'YES')";
				
				Statement statement = Database.getStatement();
				try {
					int insertSuccess = statement.executeUpdate(insertQuery);
					if(insertSuccess == 1) {
						JOptionPane.showMessageDialog(null, "Saved into database");
					}else {
						JOptionPane.showMessageDialog(null, "Something went wrong...");

					}
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});

		String selectQuery = "SELECT * FROM `assignmentquestionpaper` " + "WHERE ModuleName ='" + moduleName + "'";

		Statement statement = Database.getStatement();
		questionNo2JLabel = new JLabel("Question No 2\r\n");
		questionNo1JLabel = new JLabel("Question No 2");

		try {
			ResultSet resultSet = statement.executeQuery(selectQuery);
			if (resultSet.next()) {
				questionNo1JLabel.setText(resultSet.getString("AssignmentQuestionNo1"));
				questionNo2JLabel.setText(resultSet.getString("AssignmentQuestionNo2"));
			}

		} catch (SQLException e2) {
			e2.printStackTrace();
		}

		GroupLayout gl_studentAssignmentPanel = new GroupLayout(studentAssignmentPanel);
		gl_studentAssignmentPanel.setHorizontalGroup(gl_studentAssignmentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_studentAssignmentPanel.createSequentialGroup().addGroup(gl_studentAssignmentPanel
						.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_studentAssignmentPanel.createSequentialGroup().addGap(33)
								.addGroup(gl_studentAssignmentPanel.createParallelGroup(Alignment.TRAILING, false)
										.addGroup(gl_studentAssignmentPanel.createSequentialGroup()
												.addComponent(lblNewLabel_4)
												.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE,
														Short.MAX_VALUE)
												.addComponent(totalMarksTextField, GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
										.addGroup(gl_studentAssignmentPanel.createSequentialGroup()
												.addComponent(questionNo2JLabel, GroupLayout.PREFERRED_SIZE, 482,
														GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(ComponentPlacement.RELATED))
										.addComponent(questionNo1AnswerJLabel, Alignment.LEADING,
												GroupLayout.PREFERRED_SIZE, 422, GroupLayout.PREFERRED_SIZE)
										.addComponent(questionNo2AnswerJLabel, Alignment.LEADING,
												GroupLayout.PREFERRED_SIZE, 414, GroupLayout.PREFERRED_SIZE)
										.addComponent(questionNo1JLabel, Alignment.LEADING)))
						.addGroup(gl_studentAssignmentPanel.createSequentialGroup().addGap(209)
								.addComponent(btnNewButton_4)))
						.addContainerGap(27, Short.MAX_VALUE)));
		gl_studentAssignmentPanel.setVerticalGroup(gl_studentAssignmentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_studentAssignmentPanel.createSequentialGroup().addContainerGap()
						.addComponent(questionNo1JLabel).addGap(3)
						.addComponent(questionNo1AnswerJLabel, GroupLayout.PREFERRED_SIZE, 39,
								GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.UNRELATED).addComponent(questionNo2JLabel).addGap(13)
						.addComponent(
								questionNo2AnswerJLabel, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addGroup(gl_studentAssignmentPanel.createParallelGroup(Alignment.LEADING)
								.addComponent(totalMarksTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_studentAssignmentPanel.createSequentialGroup().addComponent(lblNewLabel_4)
										.addGap(17).addComponent(btnNewButton_4)))
						.addContainerGap()));
		studentAssignmentPanel.setLayout(gl_studentAssignmentPanel);
		studentCardPanel.setLayout(gl_studentCardPanel);
		viewAssignmentAnswerButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String searchStudentId = studentIdTextFeild.getText().trim();
				if (questionNo1AnswerJLabel.getText().isEmpty() && questionNo2AnswerJLabel.getText().isEmpty()
						&& searchStudentId.isEmpty()) {
					studentAssignmentPanel.setVisible(false);
				}

				Statement statement2 = Database.getStatement();

				String searchQuery = "SELECT * FROM `assignmentanswer`" + " WHERE StudentId = " + searchStudentId
						+ " AND ModuleName ='" + moduleName + "'";

				try {
					ResultSet resultSet = statement2.executeQuery(searchQuery);
					if (resultSet.next()) {
						questionNo1AnswerJLabel.setText(resultSet.getString("AssignmentAnswer1"));
						questionNo2AnswerJLabel.setText(resultSet.getString("AssignmentAnswer2"));
						studentAssignmentPanel.setVisible(true);
					}

				} catch (SQLException e1) {
					e1.printStackTrace();
				}

			}
		});
		JPanel assignmentCardPanel = new JPanel();
		cardPanel.add(assignmentCardPanel, "name_77250554168900");
		SpringLayout sl_assignmentCardPanel = new SpringLayout();
		assignmentCardPanel.setLayout(sl_assignmentCardPanel);

		JLabel lblNewLabel_1 = new JLabel("Add Assignment Question Paper\r\n");
		sl_assignmentCardPanel.putConstraint(SpringLayout.NORTH, lblNewLabel_1, 27, SpringLayout.NORTH,
				assignmentCardPanel);
		sl_assignmentCardPanel.putConstraint(SpringLayout.WEST, lblNewLabel_1, 202, SpringLayout.WEST,
				assignmentCardPanel);
		sl_assignmentCardPanel.putConstraint(SpringLayout.SOUTH, lblNewLabel_1, 54, SpringLayout.NORTH,
				assignmentCardPanel);
		sl_assignmentCardPanel.putConstraint(SpringLayout.EAST, lblNewLabel_1, 604, SpringLayout.WEST,
				assignmentCardPanel);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 24));
		assignmentCardPanel.add(lblNewLabel_1);

		questionNo1textField = new JTextField();
		sl_assignmentCardPanel.putConstraint(SpringLayout.WEST, questionNo1textField, 89, SpringLayout.WEST,
				assignmentCardPanel);
		sl_assignmentCardPanel.putConstraint(SpringLayout.SOUTH, questionNo1textField, -208, SpringLayout.SOUTH,
				assignmentCardPanel);
		sl_assignmentCardPanel.putConstraint(SpringLayout.EAST, questionNo1textField, 703, SpringLayout.WEST,
				assignmentCardPanel);
		assignmentCardPanel.add(questionNo1textField);
		questionNo1textField.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("Question No 1");
		sl_assignmentCardPanel.putConstraint(SpringLayout.NORTH, lblNewLabel_2, 84, SpringLayout.NORTH,
				assignmentCardPanel);
		sl_assignmentCardPanel.putConstraint(SpringLayout.WEST, lblNewLabel_2, 88, SpringLayout.WEST,
				assignmentCardPanel);
		sl_assignmentCardPanel.putConstraint(SpringLayout.NORTH, questionNo1textField, 20, SpringLayout.SOUTH,
				lblNewLabel_2);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		assignmentCardPanel.add(lblNewLabel_2);

		JLabel lblNewLabel_2_1 = new JLabel("Question No 2\r\n");
		sl_assignmentCardPanel.putConstraint(SpringLayout.NORTH, lblNewLabel_2_1, 84, SpringLayout.SOUTH,
				lblNewLabel_2);
		sl_assignmentCardPanel.putConstraint(SpringLayout.WEST, lblNewLabel_2_1, 89, SpringLayout.WEST,
				assignmentCardPanel);
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		assignmentCardPanel.add(lblNewLabel_2_1);

		questionNo2TextField = new JTextField();
		sl_assignmentCardPanel.putConstraint(SpringLayout.NORTH, questionNo2TextField, 18, SpringLayout.SOUTH,
				lblNewLabel_2_1);
		sl_assignmentCardPanel.putConstraint(SpringLayout.WEST, questionNo2TextField, 89, SpringLayout.WEST,
				assignmentCardPanel);
		sl_assignmentCardPanel.putConstraint(SpringLayout.SOUTH, questionNo2TextField, 50, SpringLayout.SOUTH,
				lblNewLabel_2_1);
		sl_assignmentCardPanel.putConstraint(SpringLayout.EAST, questionNo2TextField, 0, SpringLayout.EAST,
				questionNo1textField);
		questionNo2TextField.setColumns(10);
		assignmentCardPanel.add(questionNo2TextField);

		JButton postAssignmentButton = new JButton("Post Assignment");
		postAssignmentButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Insert into AssignmentQuestionPaper Table
				String questionNo1 = questionNo1textField.getText().trim();
				String questionNo2 = questionNo2TextField.getText().trim();

				String insertQuery = "INSERT INTO `assignmentquestionpaper` "
						+ "(`AssignmentId`, `AssignmentQuestionNo1`, `AssignmentQuestionNo2`, `ModuleName`)"
						+ " VALUES (NULL, '" + questionNo1 + "', '" + questionNo2 + "', '" + moduleName + "')";

				Statement statement = Database.getStatement();
				try {
					int insertSuccess = statement.executeUpdate(insertQuery);
					if (insertSuccess == 1) {
						JOptionPane.showMessageDialog(null, "Assignement saved into database!");
					} else {
						JOptionPane.showMessageDialog(null, "Something went wrong!");
					}

				} catch (SQLException e1) {
					e1.printStackTrace();
				}

			}
		});
		sl_assignmentCardPanel.putConstraint(SpringLayout.WEST, postAssignmentButton, 343, SpringLayout.WEST,
				assignmentCardPanel);
		sl_assignmentCardPanel.putConstraint(SpringLayout.SOUTH, postAssignmentButton, -36, SpringLayout.SOUTH,
				assignmentCardPanel);
		postAssignmentButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		assignmentCardPanel.add(postAssignmentButton);
		splitPane.setDividerLocation(150);

		InstructorDashboard .showStudentAssignmentInJtableFromDb();

		frmInstructorDashboard .setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmInstructorDashboard .setVisible(true);
	}
}