package com.ntt.bookcasestudy;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class BookUtility {

	public static Connection createCon()  //Creates connection with mysql
	{		
		Connection con = null;
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookcasestudy?autoReconnect=true&useSSL=false","root","1234");
			
			
		} 
		catch (ClassNotFoundException ex) 
		{
			ex.printStackTrace();  
		} 
		catch (SQLException e) 
		{
			System.out.println("Connection Not established "+e);
		} 
		
		
		return con;  
	}
	
	public static Connection closeCon(Connection con)  //closes connection with mysql
	{
		try
		{
			con.close();
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		} 
		return con;
	}
	
	
}
