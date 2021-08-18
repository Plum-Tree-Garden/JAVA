// plum tree garden
// $01SimpleJdbc.java

// creates database, table and inputs data, then queries final grad upon user submission

import java.util.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.*;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;



public class $01SimpleJdbc 
{	
	
	static String s_fname = "";
	static String s_lname = "";
	static String s_studentID = "";
	static String s_SSN = "";
	static String s_courseID = "";
	static String s_grade = "";

	
	public static void main(String args[])
	{



		// TODO: 1 - LOAD DRIVER
		try
		{
			// try loading driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver has loaded");
		}
		
			// catch driver loading error
			catch(ClassNotFoundException e)
			{
				e.printStackTrace();
				System.out.println("Driver failed loading");
			}
		

		try
		{
			// TODO: 2 - ESTABLISH CONNECTION
			String m_password = "12345";
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/",
					"dttrumble3", m_password);
			
			System.out.println("Established Connection Successfully");
			
			
			// TODO: 3 - CREATE STATEMENT, (1) drop existing, (2) create db, (3) create table
			Statement statement = connection.createStatement();
			
			
				// if db already exists, delete/ drop existing 
				String sqlDropDb = "DROP DATABASE myDb";
				statement.executeUpdate(sqlDropDb);
				System.out.println("DB myDb is dropped successfully");
				
				// create database
				String sqlCreateDb = " CREATE DATABASE myDb";
				statement.executeUpdate(sqlCreateDb);
				System.out.println("DB myDb is created successfully");
				
				// First_name, Last_name, student_id, SSN, course_id, Grade 
				// create db table
				String sqlCreateTable = "CREATE TABLE myDb.student (" +
						"id INT NOT NULL PRIMARY KEY," +
						"First_name VARCHAR(45) NULL," + 
						"Last_name VARCHAR(45) NULL," +
						"student_id VARCHAR(10) NULL," +
						"SSN VARCHAR(10) NULL," +
						"course_id VARCHAR(10) NULL," +
						"Grade VARCHAR(4) NULL)";
				
				// update database with table
				statement.executeUpdate(sqlCreateTable);
				System.out.println("Table student is created successfully");
							
				
			// TODO: 4 - PREPARED STATEMENT 
			PreparedStatement pstmt = connection.prepareStatement(" INSERT INTO myDb." +
					" student (id, First_name, Last_name, student_id, SSN, course_id, Grade)" +
					" VALUES (?,?,?,?,?,?,?);");
			
			
					pstmt.setInt(1, 1);
					pstmt.setString(2, "plumtree");
					pstmt.setString(3, "garden");
					pstmt.setString(4, "033887094");
					pstmt.setString(5, "4907881303");
					pstmt.setString(6, "JAC444");
					pstmt.setString(7, "100");
					pstmt.executeUpdate();
					System.out.println("Table student inserted successfully");
				
				
			
			// TODO: 5 - EXECUTE STATEMENT
			String sqlSelect = "SELECT id, First_name, Last_name, student_id, SSN, course_id, Grade " +
					"FROM myDb.student WHERE SSN = '4907881303' && course_id = 'JAC444'";

			// create result set from sqlSelect string
			ResultSet resultSet = statement.executeQuery(sqlSelect);
			System.out.println("Queried student Table successfully");
			
			
			
			
			// TODO: PROCESSING RESULTS
			while(resultSet.next())
			{
				String m_fname = resultSet.getString(2);
				String m_lname = resultSet.getString(3);
				String m_studentID = resultSet.getString(4);
				String m_SSN = resultSet.getString(5);
				String m_courseID = resultSet.getString(6);
				String m_grade = resultSet.getString(7);
					
				s_fname = m_fname;
				s_lname = m_lname;
				s_studentID = m_studentID;
				s_SSN = m_SSN;
				s_courseID = m_courseID;
				s_grade = m_grade;
				
				
				// display processed results
				System.out.println("Stored Query data successfully");
				System.out.println("Please Click - Show Grade");
			}
			
		// try block end	
		}
		
		catch(SQLException e)
		{
			System.err.println(e.getMessage());
		}
		

		
		// TODO: CREATE MAIN FRAME WINDOW
		JFrame mainFrame = new JFrame();
		mainFrame.setSize(800, 175);
		mainFrame.setTitle("FindGrade");
		mainFrame.setLayout(null);
		mainFrame.setLocationRelativeTo(null);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
		// TODO : DISPLAY MAIN PANEL
		JPanel main_panel = new JPanel();
		main_panel.setBounds(20, 30, 700, 70);
	
		GridLayout main_layout = new GridLayout(1,5);
		main_panel.setLayout(main_layout);
		main_layout.setHgap(20);
		
			JLabel ssnLabel = new JLabel("SSN ", SwingConstants.CENTER);
			main_panel.add(ssnLabel);
		
			JTextField ssnTextField = new JTextField("4907881303");
			main_panel.add(ssnTextField);

		
			JLabel courseIdLabel = new JLabel("Course ID ", SwingConstants.CENTER);
			main_panel.add(courseIdLabel);
		
		
			JTextField courseIdTextField = new JTextField("JAC444");
			main_panel.add(courseIdTextField);
		
		
		// TODO : QUERY DB FOR STUDENT DATA ON SUBMIT
		JButton submitButton = new JButton("Show Grade");
		main_panel.add(submitButton);
		
		submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) 
            {
            	System.out.println("\n");
            	System.out.println(s_fname + " " + s_lname + " : " + s_grade + " %");
            	System.out.println("\n");
            	System.out.println("Table structure: \n");
            	System.out.println(s_fname + ", " + 
            						s_lname +  ", " + 
            						s_studentID +  ", " + 
            						s_SSN +  ", " + 
            						s_courseID +  ", " + 
            						s_grade);
            	
            }
        });

		
		// TODO - ADD PANELS TO MAIN FRAME WINDOW
		mainFrame.getContentPane().add(main_panel);
				
		mainFrame.setVisible(true);	
	
		
	// main end	
	}
// class end
}
