package CourseManagementSystem;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Backend.Database;


import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.DefaultComboBoxModel;
import java.awt.CardLayout;
import javax.swing.SpringLayout;
import java.awt.Font;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class AssignmentViewForm extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private final static DefaultTableModel assignmentTable = new DefaultTableModel(
			new Object[][] { { null, null }, { null, null }, { null, null }, },
			new String[] { "ModuleName", "Assignment Submit" });
	private JTextField questionNo1AnswerJTextField;
	private JTextField questionNo2AnswerJTextField;
	private JComboBox moduleSelectComboxBox;
	private JPanel assignmentSubmissionPanel;
	private JButton submitAssignment;
	private JLabel questionNo1JLabel;
	private JLabel questionNo2JLabel;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		try {
//			AssignmentViewForm dialog = new AssignmentViewForm();
//			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
//			dialog.setVisible(true);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}

	/**
	 * Create the dialog.
	 */
	public AssignmentViewForm(int studentId) {
		setTitle("AssignmentView");
		setBounds(100, 100, 450, 347);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);

		moduleSelectComboxBox = new JComboBox();

		moduleSelectComboxBox
				.setModel(new DefaultComboBoxModel(new String[] { "Select Module", "AI ", "NMC", "OODP" }));

		JLabel lblNewLabel = new JLabel("Select Assignment");

		assignmentSubmissionPanel = new JPanel();
		assignmentSubmissionPanel.setVisible(false);

		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup().addContainerGap(32, Short.MAX_VALUE)
						.addComponent(lblNewLabel).addGap(49)
						.addComponent(moduleSelectComboxBox, GroupLayout.PREFERRED_SIZE, 111,
								GroupLayout.PREFERRED_SIZE)
						.addGap(152))
				.addGroup(gl_contentPanel
						.createSequentialGroup().addGap(32).addComponent(assignmentSubmissionPanel,
								GroupLayout.PREFERRED_SIZE, 369, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(23, Short.MAX_VALUE)));
		gl_contentPanel.setVerticalGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPanel
				.createSequentialGroup().addGap(26)
				.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(moduleSelectComboxBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel))
				.addGap(27)
				.addComponent(assignmentSubmissionPanel, GroupLayout.PREFERRED_SIZE, 192, GroupLayout.PREFERRED_SIZE)
				.addContainerGap(33, Short.MAX_VALUE)));

		questionNo1JLabel = new JLabel();
		questionNo1JLabel.setFont(new Font("Tahoma", Font.PLAIN, 10));

		questionNo1AnswerJTextField = new JTextField();
		questionNo1AnswerJTextField.setColumns(10);

		questionNo2JLabel = new JLabel();
		questionNo2JLabel.setFont(new Font("Tahoma", Font.PLAIN, 10));

		questionNo2AnswerJTextField = new JTextField();
		questionNo2AnswerJTextField.setColumns(10);

		submitAssignment = new JButton("Submit Assignment");
		submitAssignment.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String questionNo1Answer = questionNo1AnswerJTextField.getText().trim();
				String questionNo2Answer = questionNo2AnswerJTextField.getText().trim();

				// Get the studentId
				String selectedModuleName = moduleSelectComboxBox.getSelectedItem().toString().trim();

				Statement statement = Database.getStatement();

				String insertQuery = "INSERT INTO `assignmentanswer` "
						+ "(`AssignmentAnswerId`, `StudentId`, `ModuleName`, `AssignmentAnswer1`, `AssignmentAnswer2`, `AssignmentSubmitted`) "
						+ "VALUES (NULL, '" + studentId + "', '" + selectedModuleName + "', '" + questionNo1Answer
						+ "', '" + questionNo2Answer + " ', 'YES')";
				
				try {
					int insertSuccess = statement.executeUpdate(insertQuery);
					if(insertSuccess == 1) {
						JOptionPane.showMessageDialog(null, "Assignment submitted!!");
					}else {
						JOptionPane.showMessageDialog(null, "Something went wrong!");

					}
				} catch (SQLException e1) {
					e1.printStackTrace();
				}

			}
		});
		GroupLayout gl_assignmentSubmissionPanel = new GroupLayout(assignmentSubmissionPanel);
		gl_assignmentSubmissionPanel.setHorizontalGroup(gl_assignmentSubmissionPanel
				.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING,
						gl_assignmentSubmissionPanel.createSequentialGroup().addContainerGap(130, Short.MAX_VALUE)
								.addComponent(submitAssignment).addGap(116))
				.addGroup(gl_assignmentSubmissionPanel.createSequentialGroup()
						.addGroup(gl_assignmentSubmissionPanel.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_assignmentSubmissionPanel.createSequentialGroup().addContainerGap()
										.addComponent(questionNo2AnswerJTextField, GroupLayout.PREFERRED_SIZE, 328,
												GroupLayout.PREFERRED_SIZE))
								.addGroup(Alignment.LEADING,
										gl_assignmentSubmissionPanel.createSequentialGroup().addContainerGap()
												.addComponent(questionNo1JLabel)))
						.addContainerGap(22, Short.MAX_VALUE))
				.addGroup(gl_assignmentSubmissionPanel.createSequentialGroup().addContainerGap()
						.addComponent(questionNo2JLabel, GroupLayout.DEFAULT_SIZE, 349, Short.MAX_VALUE)
						.addContainerGap())
				.addGroup(gl_assignmentSubmissionPanel
						.createSequentialGroup().addGap(19).addComponent(questionNo1AnswerJTextField,
								GroupLayout.PREFERRED_SIZE, 328, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(22, Short.MAX_VALUE)));
		gl_assignmentSubmissionPanel.setVerticalGroup(gl_assignmentSubmissionPanel
				.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_assignmentSubmissionPanel.createSequentialGroup().addGap(18)
						.addComponent(questionNo1JLabel).addGap(23)
						.addComponent(questionNo1AnswerJTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(questionNo2JLabel, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
						.addGap(18).addComponent(questionNo2AnswerJTextField, GroupLayout.PREFERRED_SIZE,
								GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGap(18).addComponent(submitAssignment).addGap(23)));
		assignmentSubmissionPanel.setLayout(gl_assignmentSubmissionPanel);
		moduleSelectComboxBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == 1) {
					
					
					assignmentSubmissionPanel.setVisible(true);
					String selectedModuleName = moduleSelectComboxBox.getSelectedItem().toString().trim();

				
					String query = "SELECT * FROM `assignmentquestionpaper` WHERE ModuleName ='" + selectedModuleName
							+ "'";

					Statement statement = Database.getStatement();

					try {
						ResultSet resultSet = statement.executeQuery(query);
						if (resultSet.next()) {
							questionNo1JLabel.setText("Question No 1 " + resultSet.getString("AssignmentQuestionNo1"));
							questionNo2JLabel.setText("Question No 2 " + resultSet.getString("AssignmentQuestionNo2"));

						}
					} catch (SQLException e1) {
						e1.printStackTrace();
					}

				} else if (moduleSelectComboxBox.getSelectedItem().equals("Select Module")) {
					assignmentSubmissionPanel.setVisible(false);

				}

			}
		});

		contentPanel.setLayout(gl_contentPanel);
	}
}
