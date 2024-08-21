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
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class AssignmentMarksForm extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField questionNo1Marks;
	private JLabel questionNo1Answer;
	private JTextField questionNo2Marks;
	private JLabel TotalMarks;
	private JLabel totalMarksObtainedJLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			AssignmentMarksForm dialog = new AssignmentMarksForm();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 * 
	 * @param studentId
	 * @param instructorId
	 * @param moduleNameForQuery
	 */
	public AssignmentMarksForm(String moduleNameForQuery, int instructorId, int studentId) {
		setTitle("Add Marks Assignment Form");
		setBounds(100, 100, 450, 300);
		SpringLayout springLayout = new SpringLayout();
		springLayout.putConstraint(SpringLayout.NORTH, contentPanel, 0, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, contentPanel, 0, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, contentPanel, 261, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, contentPanel, 434, SpringLayout.WEST, getContentPane());
		getContentPane().setLayout(springLayout);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel);
		SpringLayout sl_contentPanel = new SpringLayout();
		contentPanel.setLayout(sl_contentPanel);
		{
			questionNo1Answer = new JLabel("Fetch from database  answer no 1");
			sl_contentPanel.putConstraint(SpringLayout.NORTH, questionNo1Answer, 53, SpringLayout.NORTH, contentPanel);
			sl_contentPanel.putConstraint(SpringLayout.WEST, questionNo1Answer, 27, SpringLayout.WEST, contentPanel);
			sl_contentPanel.putConstraint(SpringLayout.SOUTH, questionNo1Answer, 67, SpringLayout.NORTH, contentPanel);
			sl_contentPanel.putConstraint(SpringLayout.EAST, questionNo1Answer, 280, SpringLayout.WEST, contentPanel);
			contentPanel.add(questionNo1Answer);
		}

		questionNo1Marks = new JTextField();
		sl_contentPanel.putConstraint(SpringLayout.NORTH, questionNo1Marks, -9, SpringLayout.NORTH, questionNo1Answer);
		sl_contentPanel.putConstraint(SpringLayout.WEST, questionNo1Marks, 36, SpringLayout.EAST, questionNo1Answer);
		sl_contentPanel.putConstraint(SpringLayout.SOUTH, questionNo1Marks, -175, SpringLayout.SOUTH, contentPanel);
		contentPanel.add(questionNo1Marks);
		questionNo1Marks.setColumns(10);

		JLabel lblNewLabel = new JLabel("Marks\r\n");
		sl_contentPanel.putConstraint(SpringLayout.EAST, questionNo1Marks, 0, SpringLayout.EAST, lblNewLabel);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		sl_contentPanel.putConstraint(SpringLayout.NORTH, lblNewLabel, 10, SpringLayout.NORTH, contentPanel);
		sl_contentPanel.putConstraint(SpringLayout.EAST, lblNewLabel, -60, SpringLayout.EAST, contentPanel);
		contentPanel.add(lblNewLabel);

		JLabel questionNo2Answer = new JLabel("Fetch from database  answer no 2\r\n");
		sl_contentPanel.putConstraint(SpringLayout.NORTH, questionNo2Answer, 40, SpringLayout.SOUTH, questionNo1Answer);
		sl_contentPanel.putConstraint(SpringLayout.WEST, questionNo2Answer, 0, SpringLayout.WEST, questionNo1Answer);
		contentPanel.add(questionNo2Answer);

		questionNo2Marks = new JTextField();
		sl_contentPanel.putConstraint(SpringLayout.NORTH, questionNo2Marks, -9, SpringLayout.NORTH, questionNo2Answer);
		sl_contentPanel.putConstraint(SpringLayout.WEST, questionNo2Marks, 0, SpringLayout.WEST, questionNo1Marks);
		sl_contentPanel.putConstraint(SpringLayout.EAST, questionNo2Marks, -60, SpringLayout.EAST, contentPanel);
		questionNo2Marks.setColumns(10);
		contentPanel.add(questionNo2Marks);

		TotalMarks = new JLabel("TotalMarksObtained: ");
		TotalMarks.setFont(new Font("Tahoma", Font.PLAIN, 14));
		sl_contentPanel.putConstraint(SpringLayout.SOUTH, TotalMarks, -64, SpringLayout.SOUTH, contentPanel);
		sl_contentPanel.putConstraint(SpringLayout.EAST, TotalMarks, -127, SpringLayout.EAST, contentPanel);
		contentPanel.add(TotalMarks);

		JButton addMarksButton = new JButton("Add Marks");
		Statement statement = Database.getStatement();

		// Get answers from studentId and moduleNameForQuery
		String getAnswersQuery = "SELECT * FROM `assignmentanswer` " + "WHERE StudentId =" + studentId
				+ " AND ModuleName ='" + moduleNameForQuery + "'";

		try {
			ResultSet resultSet = statement.executeQuery(getAnswersQuery);
			if (resultSet.next()) {
				String questionNo1AnswerFromDb = resultSet.getString("AssignmentAnswer1");
				questionNo1Answer.setText(questionNo1AnswerFromDb);
				String questionNo2AnswerFromDb = resultSet.getString("AssignmentAnswer2");
				questionNo2Answer.setText(questionNo2AnswerFromDb);
			}
		} catch (SQLException e2) {
			e2.printStackTrace();
		}

		addMarksButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Statement statement = Database.getStatement();

				int marksObtainedInQuestionNo1 = Integer.parseInt(questionNo1Marks.getText().trim());
				int marksObtainedInQuestionNo2 = Integer.parseInt(questionNo2Marks.getText().trim());
				int totalMarksObtained = marksObtainedInQuestionNo1 + marksObtainedInQuestionNo2;



				totalMarksObtainedJLabel.setText(String.valueOf(totalMarksObtained));
				totalMarksObtainedJLabel.setVisible(true);
				
				String insertQuery = "INSERT INTO `assignmentmark` "
						+ "(`assignmentmarkid`, `instructorid`, `studentid`, `ModuleName`, `assignmentMarks`, `marksAdded`) "
						+ "VALUES (NULL, "+instructorId+", "+studentId +", '"+moduleNameForQuery +"', "+totalMarksObtained +", 'YES')";

				try {
					int insertSuccess = statement.executeUpdate(insertQuery);
					if (insertSuccess == 1) {
						JOptionPane.showMessageDialog(null, "Marks added successfully");
					} else {
						JOptionPane.showMessageDialog(null, "Something went wrong...");
					}

				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		addMarksButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		sl_contentPanel.putConstraint(SpringLayout.WEST, addMarksButton, 158, SpringLayout.WEST, contentPanel);
		sl_contentPanel.putConstraint(SpringLayout.SOUTH, addMarksButton, -10, SpringLayout.SOUTH, contentPanel);
		contentPanel.add(addMarksButton);

		totalMarksObtainedJLabel = new JLabel("New label");
		totalMarksObtainedJLabel.setVisible(false);
		sl_contentPanel.putConstraint(SpringLayout.SOUTH, questionNo2Marks, -43, SpringLayout.NORTH,
				totalMarksObtainedJLabel);
		sl_contentPanel.putConstraint(SpringLayout.WEST, totalMarksObtainedJLabel, 24, SpringLayout.EAST, TotalMarks);
		sl_contentPanel.putConstraint(SpringLayout.SOUTH, totalMarksObtainedJLabel, 0, SpringLayout.SOUTH, TotalMarks);
		contentPanel.add(totalMarksObtainedJLabel);
	}

	public AssignmentMarksForm() {
		// TODO Auto-generated constructor stub
	}
}