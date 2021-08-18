// plum tree garden
// $01SimpleJdbc.java

// acts as database storage / input / retrieval for Ministry of Health of Ontario vaccine counts on a given date and location.

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
	static String s_phizer = "";
	static String s_maderna = "";
	static String s_astra = "";

	
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
				
				// create db table
				String sqlCreateTable = "CREATE TABLE myDb.vaccine (" +
						"id INT NOT NULL PRIMARY KEY," +
						"city VARCHAR(45) NULL," + 
						"month INT (4) NULL," +
						"day INT(4) NULL," +
						"year INT(4) NULL," +
						"phizer INT(4) NULL," +
						"maderna INT(4) NULL," +
						"astrazeneca INT(4) NULL)";
				
				// update database with table
				statement.executeUpdate(sqlCreateTable);
				System.out.println("Table vaccine is created successfully");
							
				
			// TODO: 4 - PREPARED STATEMENT 
			PreparedStatement pstmt = connection.prepareStatement(" INSERT INTO myDb." +
					" vaccine (id, city, month, day, year, phizer, maderna, astrazeneca)" +
					" VALUES (?,?,?,?,?,?,?,?);");
			
			
					pstmt.setInt(1, 1);
					pstmt.setString(2, "markham");
					pstmt.setInt(3, 8);
					pstmt.setInt(4, 13);
					pstmt.setInt(5, 2021);
					pstmt.setInt(6, 24);
					pstmt.setInt(7, 43);
					pstmt.setInt(8, 65);
					pstmt.executeUpdate();
					System.out.println("Table vaccine inserted successfully");
				
				
			
			// TODO: 5 - EXECUTE STATEMENT
			String sqlSelect = "SELECT id, city, month, day, year, phizer, maderna, astrazeneca " +
					"FROM myDb.vaccine WHERE city = 'markham'";

			// create result set from sqlSelect string
			ResultSet resultSet = statement.executeQuery(sqlSelect);
			System.out.println("Queried vaccine Table successfully");
			
			
			
			
			// TODO: 6 - PROCESSING RESULTS
			while(resultSet.next())
			{
				// (0)id, (1)firstname, (2)lastname, (3)email
				String m_phizer = resultSet.getString(6);
				String m_maderna = resultSet.getString(7);
				String m_astra = resultSet.getString(8);
				
				s_phizer = m_phizer;
				s_maderna = m_maderna;
				s_astra = m_astra;
				
				// display processed results
				System.out.println("Stored Query Data Successfully");
				System.out.println("Please Click Submit to Display Data");
			}
			
		// try block end	
		}
		
		catch(SQLException e)
		{
			System.err.println(e.getMessage());
		}
		
		

		
		// TODO: CREATE MAIN FRAME WINDOW
		JFrame mainFrame = new JFrame();
		mainFrame.setSize(630, 550);
		mainFrame.setTitle("Ministry of Health of Ontario");
		mainFrame.setLayout(null);
		mainFrame.setLocationRelativeTo(null);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
		
		// TODO : DISPLAY LABEL EXPLAINING APP
		JPanel info_panel = new JPanel();
		info_panel.setBounds(30, 30, 540, 25);
		GridLayout info_layout = new GridLayout(1,1);
		info_panel.setLayout(info_layout);
		info_panel.setBackground(Color.GREEN);

		JLabel infoLabel = new JLabel("Ministry of Health of Ontario: Managing Covid-19 Vaccines");
		info_panel.add(infoLabel);
		
		
		// TODO : RECEIVE USER INPUT FOR DATE
		JPanel date_panel = new JPanel();
		date_panel.setBounds(30, 100, 200, 25);
		GridLayout date_layout = new GridLayout(1,1);
		date_panel.setLayout(date_layout);
		date_panel.setBackground(Color.GREEN);

		JLabel dateLabel = new JLabel("Date of Vaccination: (dd-mm-yyy)");
		date_panel.add(dateLabel);
		
		JPanel dateInfo_panel = new JPanel();
		dateInfo_panel.setBounds(275, 100, 300, 25);
		GridLayout date_info = new GridLayout(1,3);
		dateInfo_panel.setLayout(date_info);
		//dateInfo_panel.setBackground(Color.GREEN);
		date_info.setHgap(10);

		JTextField monthTextField = new JTextField("8");
		dateInfo_panel.add(monthTextField);
		
		JTextField dayTextField = new JTextField("13");
		dateInfo_panel.add(dayTextField);
		
		JTextField yearTextField = new JTextField("2021");
		dateInfo_panel.add(yearTextField);

		
		// TODO : RECEIVE USER INPUT FOR CITY
		JPanel city_panel = new JPanel();
		city_panel.setBounds(30, 200, 200, 25);
		GridLayout city_layout = new GridLayout(1,1);
		city_panel.setLayout(city_layout);
		city_panel.setBackground(Color.GREEN);

		JLabel cityLabel = new JLabel("Name of City: ");
		city_panel.add(cityLabel);

		
		JPanel cityInfo_panel = new JPanel();
		cityInfo_panel.setBounds(275, 200, 300, 25);
		GridLayout city_info = new GridLayout(1,1);
		cityInfo_panel.setLayout(city_info);
		cityInfo_panel.setBackground(Color.GREEN);
		city_info.setHgap(10);

		JTextField cityTextField = new JTextField("markham");
		cityInfo_panel.add(cityTextField);
		
		
		
		// TODO : DISPLAY VACCINE COUNT
		JPanel vaccine_panel = new JPanel();
		vaccine_panel.setBounds(50, 375, 500, 25);
		GridLayout vaccine_info = new GridLayout(1,3);
		vaccine_panel.setLayout(vaccine_info);
		vaccine_panel.setBackground(Color.GREEN);
		vaccine_info.setHgap(10);

		JLabel vaccinePhizer = new JLabel("Phizer", SwingConstants.CENTER);
		vaccine_panel.add(vaccinePhizer);
		
		JLabel vaccineMaderna = new JLabel("Maderna", SwingConstants.CENTER);
		vaccine_panel.add(vaccineMaderna);
		
		JLabel vaccineAstra = new JLabel("AstraZeneca", SwingConstants.CENTER);
		vaccine_panel.add(vaccineAstra);
		
		
		// TODO DISPLAY COUNT OF EACH VACCINE
		JPanel count_panel = new JPanel();
		count_panel.setBounds(50, 425, 500, 25);
		GridLayout count_info = new GridLayout(1,3);
		count_panel.setLayout(count_info);
		count_panel.setBackground(Color.GREEN);
		count_info.setHgap(10);

		JLabel countPhizer = new JLabel("", SwingConstants.CENTER);
		count_panel.add(countPhizer);
		
		JLabel countMaderna = new JLabel("", SwingConstants.CENTER);
		count_panel.add(countMaderna);
		
		JLabel countAstra = new JLabel("", SwingConstants.CENTER);
		count_panel.add(countAstra);
		
		
		// TODO : SUBMIT DATE / CITY DATA
		JPanel submit_panel = new JPanel();
		submit_panel.setBounds(50, 300, 500, 25);
		GridLayout submit_layout = new GridLayout(1,1);
		submit_panel.setLayout(submit_layout);
		submit_panel.setBackground(Color.GREEN);

		// TODO : QUERY DB FOR VACCINE DATA ON SUBMIT
		JButton submitButton = new JButton("Submit to Retrieve Vaccination Data");
		submit_panel.add(submitButton);
		submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) 
            {
            	countPhizer.setText(s_phizer);
            	countMaderna.setText(s_maderna);
            	countAstra.setText(s_astra);
            	
            	System.out.println("Submission Data Retrieved");
            }
        });
		
		
		// TODO - ADD PANELS TO MAIN FRAME WINDOW
		mainFrame.getContentPane().add(info_panel);
		mainFrame.getContentPane().add(date_panel);
		mainFrame.getContentPane().add(dateInfo_panel);
		mainFrame.getContentPane().add(city_panel);		
		mainFrame.getContentPane().add(cityInfo_panel);		
		mainFrame.getContentPane().add(submit_panel);	
		mainFrame.getContentPane().add(vaccine_panel);		
		mainFrame.getContentPane().add(count_panel);	
		
		mainFrame.setVisible(true);	
		
	// main end	
	}
// class end
}

