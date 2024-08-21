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
import javax.swing.SpringLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.table.DefaultTableModel;

import Backend.Database;

import javax.swing.JList;
import javax.swing.AbstractListModel;

public class StudentDashboard {


	private JFrame frmStudentDashboard;
	private CardLayout cl_modulesCardPanel = new CardLayout(0, 0);
	private JPanel modulesCardPanel;
	private static DefaultTableModel teacherDefaultTableModel = new DefaultTableModel(
			new Object[][] { { null, null, null, null, null, null, null, null },
					{ null, null, null, null, null, null, null, null },
					{ null, null, null, null, null, null, null, null }, },
			new String[] { "Id", "Name", "MobileNumber", "Address", "Gender", "ModuleAssigned", "DateOfBirth",
					"IsPartTime" });
	private JTextField questionNo1textField;
	private JTextField questionNo2TextField;

	public JFrame getFrmAdminDashboard() {
		return frmStudentDashboard;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentDashboard window = new StudentDashboard();
					window.frmStudentDashboard.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * 
	 * @wbp.parser.entryPoint
	 */
	public StudentDashboard() {
		initialize();
	}

	public static void showDataInTableFromDb() {
		Statement statement = Database.getStatement();

		String selectQuery = "SELECT * FROM `teacher`";

		ResultSet resultSet;
		try {
			resultSet = statement.executeQuery(selectQuery);
			teacherDefaultTableModel.setRowCount(0);
			while (resultSet.next()) {
				int idFromDb = resultSet.getInt("Id");
			
				String nameFromDb = resultSet.getString("Name");
				BigDecimal mobileNoFromDb = resultSet.getBigDecimal("MobileNumber");
				String addressFromDb = resultSet.getString("Address");
				String genderFromDb = resultSet.getString("Gender");
				String moduleAssignedFromDb = resultSet.getString("ModuleAssigned");
				Date dateFromDb = resultSet.getDate("DateOfBirth");
				String isPartTimeFromDb = resultSet.getString("IsPartTime");

				teacherDefaultTableModel.addRow(new Object[] { idFromDb, nameFromDb, mobileNoFromDb, addressFromDb,
						genderFromDb, moduleAssignedFromDb, dateFromDb, isPartTimeFromDb });



			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * Initialize the contents of the frame.
	 * 
	 * @throws SQLException
	 */
	private void initialize() {
		frmStudentDashboard = new JFrame();

		frmStudentDashboard.setTitle("Teacher Dashboard\r\n");
		frmStudentDashboard.setBounds(100, 100, 1032, 448);
		JSplitPane splitPane = new JSplitPane();
		splitPane.setDividerSize(0);
		frmStudentDashboard.setContentPane(splitPane);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(128, 128, 128));
		splitPane.setLeftComponent(panel);

		JLabel lblNewLabel = new JLabel("Welcome");

		JButton btnNewButton = new JButton("Modules\r\n");
		btnNewButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				cl_modulesCardPanel.show(modulesCardPanel, "name_77250554168900");
			}
		});

		JButton btnNewButton_1 = new JButton("See Result\r\n");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cl_modulesCardPanel.show(modulesCardPanel, "name_8389077655999");
			}
		});

		JButton btnNewButton_2 = new JButton("Logout\r\n");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
              int result = JOptionPane.showConfirmDialog(null, "Are you sure want to log out?", "Log out?", JOptionPane.YES_NO_OPTION);
				
				if (result == JOptionPane.YES_OPTION) {
					frmStudentDashboard.setVisible(false);
			    } else if (result == JOptionPane.NO_OPTION) {
			    	new JButton("Logout");
			    }
				
			}
			
			
		});
		
		JButton btnNewButton_4 = new JButton("View Assignmnet");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
								.addComponent(btnNewButton_4, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 113, Short.MAX_VALUE)
								.addComponent(btnNewButton_2, GroupLayout.DEFAULT_SIZE, 113, Short.MAX_VALUE))
							.addGap(26))
						.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
								.addComponent(btnNewButton, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE)
								.addComponent(btnNewButton_1, GroupLayout.DEFAULT_SIZE, 113, Short.MAX_VALUE))
							.addGap(26))))
				.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
					.addGap(41)
					.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 129, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(21)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
					.addGap(30)
					.addComponent(btnNewButton)
					.addGap(26)
					.addComponent(btnNewButton_1)
					.addGap(42)
					.addComponent(btnNewButton_4)
					.addGap(37)
					.addComponent(btnNewButton_2)
					.addContainerGap(119, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);

		JSplitPane splitPane_1 = new JSplitPane();
		splitPane_1.setDividerSize(0);
		splitPane_1.setOrientation(JSplitPane.VERTICAL_SPLIT);
		splitPane.setRightComponent(splitPane_1);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(230, 230, 250));
		splitPane_1.setLeftComponent(panel_1);
		
		JLabel lblObjectOrientedDesign = new JLabel("Level 5 1st Semseter Autumn 2022\r\n");
		lblObjectOrientedDesign.setOpaque(true);
		lblObjectOrientedDesign.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblObjectOrientedDesign.setBackground(new Color(255, 128, 64));
		panel_1.add(lblObjectOrientedDesign);

		modulesCardPanel = new JPanel();
		splitPane_1.setRightComponent(modulesCardPanel);
		modulesCardPanel.setLayout(cl_modulesCardPanel);

		JPanel aiCardPanel = new JPanel();
		aiCardPanel.setBackground(new Color(230, 230, 250));
		modulesCardPanel.add(aiCardPanel, "name_77231035427800");
		SpringLayout sl_aiCardPanel = new SpringLayout();
		aiCardPanel.setLayout(sl_aiCardPanel);

		JPanel oodpCardPanel = new JPanel();
		modulesCardPanel.add(oodpCardPanel, "name_77250554168900");
		SpringLayout sl_oodpCardPanel = new SpringLayout();
		oodpCardPanel.setLayout(sl_oodpCardPanel);
		
		JLabel lblNewLabel_1 = new JLabel("OODP  Assignment Question Paper\r\n");
		sl_oodpCardPanel.putConstraint(SpringLayout.NORTH, lblNewLabel_1, 27, SpringLayout.NORTH, oodpCardPanel);
		sl_oodpCardPanel.putConstraint(SpringLayout.WEST, lblNewLabel_1, 89, SpringLayout.WEST, oodpCardPanel);
		sl_oodpCardPanel.putConstraint(SpringLayout.SOUTH, lblNewLabel_1, 54, SpringLayout.NORTH, oodpCardPanel);
		sl_oodpCardPanel.putConstraint(SpringLayout.EAST, lblNewLabel_1, 532, SpringLayout.WEST, oodpCardPanel);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 24));
		oodpCardPanel.add(lblNewLabel_1);
		
		questionNo1textField = new JTextField();
		sl_oodpCardPanel.putConstraint(SpringLayout.NORTH, questionNo1textField, 126, SpringLayout.NORTH, oodpCardPanel);
		sl_oodpCardPanel.putConstraint(SpringLayout.WEST, questionNo1textField, 89, SpringLayout.WEST, oodpCardPanel);
		oodpCardPanel.add(questionNo1textField);
		questionNo1textField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Question No 1");
		sl_oodpCardPanel.putConstraint(SpringLayout.NORTH, lblNewLabel_2, 28, SpringLayout.SOUTH, lblNewLabel_1);
		sl_oodpCardPanel.putConstraint(SpringLayout.WEST, lblNewLabel_2, 24, SpringLayout.WEST, oodpCardPanel);
		sl_oodpCardPanel.putConstraint(SpringLayout.SOUTH, lblNewLabel_2, -24, SpringLayout.NORTH, questionNo1textField);
		sl_oodpCardPanel.putConstraint(SpringLayout.EAST, lblNewLabel_2, 136, SpringLayout.WEST, oodpCardPanel);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		oodpCardPanel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("Question No 2\r\n");
		sl_oodpCardPanel.putConstraint(SpringLayout.WEST, lblNewLabel_2_1, 21, SpringLayout.WEST, oodpCardPanel);
		sl_oodpCardPanel.putConstraint(SpringLayout.SOUTH, lblNewLabel_2_1, -157, SpringLayout.SOUTH, oodpCardPanel);
		sl_oodpCardPanel.putConstraint(SpringLayout.SOUTH, questionNo1textField, -29, SpringLayout.NORTH, lblNewLabel_2_1);
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		oodpCardPanel.add(lblNewLabel_2_1);
		
		questionNo2TextField = new JTextField();
		sl_oodpCardPanel.putConstraint(SpringLayout.NORTH, questionNo2TextField, 226, SpringLayout.NORTH, oodpCardPanel);
		sl_oodpCardPanel.putConstraint(SpringLayout.WEST, questionNo2TextField, 89, SpringLayout.WEST, oodpCardPanel);
		sl_oodpCardPanel.putConstraint(SpringLayout.EAST, questionNo2TextField, -160, SpringLayout.EAST, oodpCardPanel);
		sl_oodpCardPanel.putConstraint(SpringLayout.EAST, questionNo1textField, 0, SpringLayout.EAST, questionNo2TextField);
		questionNo2TextField.setColumns(10);
		oodpCardPanel.add(questionNo2TextField);
		
		JButton btnNewButton_3 = new JButton("Submit Assignment");
		sl_oodpCardPanel.putConstraint(SpringLayout.SOUTH, questionNo2TextField, -45, SpringLayout.NORTH, btnNewButton_3);
		sl_oodpCardPanel.putConstraint(SpringLayout.WEST, btnNewButton_3, 309, SpringLayout.WEST, oodpCardPanel);
		sl_oodpCardPanel.putConstraint(SpringLayout.SOUTH, btnNewButton_3, -32, SpringLayout.SOUTH, oodpCardPanel);
		btnNewButton_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		oodpCardPanel.add(btnNewButton_3);
		
		JLabel questionNo1FromDb = new JLabel("From DB question no 1\r\n");
		sl_oodpCardPanel.putConstraint(SpringLayout.NORTH, questionNo1FromDb, 19, SpringLayout.SOUTH, lblNewLabel_1);
		sl_oodpCardPanel.putConstraint(SpringLayout.WEST, questionNo1FromDb, 28, SpringLayout.EAST, lblNewLabel_2);
		sl_oodpCardPanel.putConstraint(SpringLayout.SOUTH, questionNo1FromDb, 0, SpringLayout.SOUTH, lblNewLabel_2);
		questionNo1FromDb.setFont(new Font("Tahoma", Font.PLAIN, 18));
		oodpCardPanel.add(questionNo1FromDb);
		
		JLabel questionNo2FromDb = new JLabel("From DB question No 2");
		sl_oodpCardPanel.putConstraint(SpringLayout.WEST, questionNo2FromDb, 41, SpringLayout.EAST, lblNewLabel_2_1);
		sl_oodpCardPanel.putConstraint(SpringLayout.EAST, questionNo2FromDb, 263, SpringLayout.EAST, lblNewLabel_2_1);
		sl_oodpCardPanel.putConstraint(SpringLayout.NORTH, questionNo2FromDb, 183, SpringLayout.NORTH, oodpCardPanel);
		questionNo2FromDb.setFont(new Font("Tahoma", Font.PLAIN, 20));
		oodpCardPanel.add(questionNo2FromDb);
		
		JLabel lblNewLabel_3 = new JLabel("Ans");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		sl_oodpCardPanel.putConstraint(SpringLayout.NORTH, lblNewLabel_3, 34, SpringLayout.SOUTH, lblNewLabel_2);
		sl_oodpCardPanel.putConstraint(SpringLayout.WEST, lblNewLabel_3, 0, SpringLayout.WEST, lblNewLabel_2);
		oodpCardPanel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_3_1 = new JLabel("Ans");
		sl_oodpCardPanel.putConstraint(SpringLayout.NORTH, lblNewLabel_3_1, 31, SpringLayout.SOUTH, lblNewLabel_2_1);
		sl_oodpCardPanel.putConstraint(SpringLayout.WEST, lblNewLabel_3_1, 0, SpringLayout.WEST, lblNewLabel_2);
		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		oodpCardPanel.add(lblNewLabel_3_1);
		
		JList list = new JList();
		sl_oodpCardPanel.putConstraint(SpringLayout.EAST, questionNo1FromDb, -146, SpringLayout.WEST, list);
		sl_oodpCardPanel.putConstraint(SpringLayout.SOUTH, list, -6, SpringLayout.NORTH, questionNo1textField);
		sl_oodpCardPanel.putConstraint(SpringLayout.NORTH, list, 27, SpringLayout.NORTH, oodpCardPanel);
		sl_oodpCardPanel.putConstraint(SpringLayout.WEST, list, -223, SpringLayout.EAST, oodpCardPanel);
		sl_oodpCardPanel.putConstraint(SpringLayout.EAST, list, -6, SpringLayout.EAST, oodpCardPanel);
		list.setModel(new AbstractListModel() {
			String[] values = new String[] {"Fetch this from Database", "Get teacher name who are assigned OODP module SQL", "Subash Bista", "Rukesh Shrestha", "Pradeep Man Dixit"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		oodpCardPanel.add(list);
		
		JLabel lblNewLabel_4 = new JLabel("Teachers");
		sl_oodpCardPanel.putConstraint(SpringLayout.SOUTH, lblNewLabel_4, -6, SpringLayout.NORTH, list);
		sl_oodpCardPanel.putConstraint(SpringLayout.EAST, lblNewLabel_4, -82, SpringLayout.EAST, oodpCardPanel);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 17));
		oodpCardPanel.add(lblNewLabel_4);
		
		JPanel nmcCardPanel = new JPanel();
		modulesCardPanel.add(nmcCardPanel, "name_6051956625800");
		
		JPanel resultPanel = new JPanel();
		modulesCardPanel.add(resultPanel, "name_8389077655999");
		splitPane.setDividerLocation(150);

		Dashboard.showInstructorDataInTableFromDb();

		frmStudentDashboard.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmStudentDashboard.setVisible(true);
	}
}
