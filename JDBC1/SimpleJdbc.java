// Plum Tree Garden
// SampleJdbc.java


// app that creates database, table & table data with corresponding XAMPP database manager. 
// loads driver, establishes connection, create/prepare statements, execute statements & process results



import java.util.*;
import java.sql.*;

// TODO: XAMPP
// (1) create db
// (2) create table
// (3) define column -> fn, ln, email, date
// (4) user account -> privilege -> username / pswd -> grant global access


// TODO: 1 - LOAD DRIVER 		  - (com.mysql.cj.jdbc.Driver)
// TODO: 2 - ESTABLISH CONNECTION - (jdbc:mysql://hostname/dbname | jdbc:mysql://localhost/)
// TODO: 3 - CREATE STATEMENT	  - (1)dropDb, (2)createDb, (3)createTable
// TODO: 4 - PREPARED STATEMENT   - (4)populateTable - execute sql statements in paramaters
// TODO: 5 - EXECUTE STATEMENT    - statement.executeUpdate() | Resultset rs = executeQuery()
// TODO: 6 - PROCESSING RESULTS


public class $01SimpleJdbc 
{	
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
					"plumtree", m_password);
			
			System.out.println("Established Connection Successfully");
			
			
			// TODO: 3 - CREATE STATEMENT, (1) drop existing, (2) create db, (3) create table
			Statement statement = connection.createStatement();
			
				// if db already exists, delete/ drop existing 
				String sqlDropDb = "DROP DATABASE 'myDb';";
				statement.executeUpdate(sqlDropDb);
				System.out.println("DB\"myDb\" is dropped successfully");
				
				// create database
				String sqlCreateDb = " CREATE DATABASE 'myDb';";
				statement.executeUpdate(sqlCreateDb);
				System.out.println("DB\"myDb\" is created successfully");
				
				// create db table
				String sqlCreateTable = " CREATE TABLE 'myDb' . 'student (\r \n" + 
																		 
						" 'id' ID NOT NULL, \r\n" + 
						" 'first_name' VARCHAR(45) NULL, \r\n" +
						" 'last_name' VARCHAR(45) NULL, \r\n" +
						" 'email' VARCHAR(45) NULL, \r\n" +
						"PRIMARY KEY ('id'));";
				
				// update database with table
				statement.executeUpdate(sqlCreateTable);
				System.out.println("Table \"student\" is created successfully");
			
				
			// TODO: 4 - PREPARED STATEMENT 
			PreparedStatement pstmt = connection.prepareStatement("INSERT INTO 'myDb' . 'student' ('id', 'first_name', 'last_name', 'email')"
						+ "VALUES (?, ?, ?, ?);");
			
				// update database with prepared statement
				for(int i = 0; i < 10; i++)
				{
					pstmt.setInt(1, i+1);
					pstmt.setString(2, "plum");
					pstmt.setString(3, "tree");
					pstmt.setString(4, "plumtree@trial");
					pstmt.executeUpdate();
				}
				
				
			
			// TODO: 5 - EXECUTE STATEMENT
			String sqlSelect = "SELECT id, first_name, last_name, email " 
						+ "FROM myDb.student "
						+ "WHERE last_name = 'Smiths'";

			// create result set from sqlSelect string
			ResultSet resultSet = statement.executeQuery(sqlSelect);
			
			
			// TODO: 6 - PROCESSING RESULTS
			while(resultSet.next())
			{
				// (0)id, (1)firstname, (2)lastname, (3)email
				String id = resultSet.getString(1);
				String firstname = resultSet.getString(2);
				String lastname = resultSet.getString(3);
				String email = resultSet.getString(4);
				
				// display processed results
				System.out.println(id + ":" + firstname + " " + lastname + " " + email);
			}
			
		// try block end	
		}
		
		catch(SQLException e)
		{
			System.err.println(e.getMessage());
		}
		
	// main end	
	}
// class end
}


