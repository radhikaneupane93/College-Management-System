package CourseManagementSystem;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import Backend.Database;

public class UserRegistration {
	private Connection con;


	public UserRegistration(){
		con = Database.getDBConnection();
	}

	//Registration
	public void insert(String username, String firstName, String lastName, String gender,String systemuser, String password,
			String confirmPassword) {
		try {
			String insert = "INSERT INTO users (username, first_name, last_name, gender, systemusers, password, confirmPassword)"
					+ "VALUES(?,?,?,?,?,?,?)";
			PreparedStatement statement = con.prepareStatement(insert);
			statement.setString(1, username);
			statement.setString(2, firstName);
			statement.setString(3, lastName);
			statement.setString(4, gender);
			statement.setString(5, systemuser);
			statement.setString(6, password);
			statement.setString(7, confirmPassword);

			statement.executeUpdate();
			statement.close();

		} catch (SQLException ex) {
			ex.printStackTrace();

		}

	}

	//Login or Sign In
	ResultSet login(String username, String password, String systemuser) {
		String select = "SELECT * FROM users where username = ? and password = ? and systemusers=?";
		try {
			PreparedStatement statement  = con.prepareStatement(select);
			statement.setString(1, username);
			statement.setString(2, password);
			statement.setString(3, systemuser);
			ResultSet rs = statement.executeQuery();
			if(rs.next()) {
	
				JOptionPane.showMessageDialog(null, "Logged in Successfully", "Information", JOptionPane.INFORMATION_MESSAGE);
				if(systemuser.equals("Admin")) {
					new Dashboard();
				}
				else if(systemuser.equals("Instructor")) {
					new InstructorDashboard();
				}
				else if(systemuser.equals("Student")) {
					new StudentDashboard();
				}
				
			}else {
				JOptionPane.showMessageDialog(null, "Invalid Username or password", "Error", JOptionPane.ERROR_MESSAGE);
			}
		}catch(SQLException ex) {
			ex.printStackTrace();
		}
		return null;
	}

}
