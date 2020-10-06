package bookcasestudy;
import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Bookdblayer {
	int create(Book b) throws Exception 
	{
		
		
		
		Connection con = null;
		Statement stmt = null;
		
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookcases","root","root");
			stmt= con.createStatement();
		} 
		catch (ClassNotFoundException ex) 
		{
			
			ex.printStackTrace();
		}

		
	     
	     
		PreparedStatement pt = con.prepareStatement("insert into Bookdb"
				+ "(ISBN_number,Book_Name,Author_Name,Edition) values \r\n" + 
				"( ?,?,?,?,?)");
		
		pt.setInt(1,b.getISBN_number());
		pt.setString(2,b.getBook_Name());
		pt.setString(3,b.getAuthor_Name());
		pt.setInt(4,b.getEdition());
		int r = pt.executeUpdate();
		stmt.close();
	    con.close();
		return r;
		
	}
	
	void read(Book x) throws Exception 
	{
		Connection con = null;
		Statement stmt = null;
		
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookcases","root","root");
			stmt= con.createStatement();
		} 
		catch (ClassNotFoundException e) 
		{
			
			e.printStackTrace();
		}

		
		ResultSet rs= stmt.executeQuery("select * from Bookdb where ISBN_number="+x.getISBN_number());
		if(rs.first())
		{
			rs= stmt.executeQuery("select * from Bookdb where ISBN_number="+x.getISBN_number());	
		while(rs.next()) {
		
	    System.out.println("ISBN_number : "+rs.getInt("ISBN_number")+
	    		"\nBook_Name : "+rs.getString("Book_Name")+
	    		"\nAuthor_Name : "+rs.getString("Author_Name")+
	    		"\nEdition : "+rs.getInt("Edition")
	    		);
		}}
		else
		{
			System.out.println("Book with givdn Id not found");
		}
		
		stmt.close();
	    con.close();
	
	}
	
	static int update(Book x) throws Exception 
	{
		Connection con = null;
		Statement stmt = null;
		
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookcases","root","root");
			stmt= con.createStatement();
		} 
		catch (ClassNotFoundException e) 
		{
			
			e.printStackTrace();
		}

		PreparedStatement pt = con.prepareStatement(" update employee SET Book_Name = ?, Author_Name = ?, Edition=?\r\n" + 
				" where ISBN_number = ?");
		pt.setInt(4, x.getISBN_number());
		pt.setString(1,x.getBook_Name());
		pt.setString(2,x.getAuthor_Name());
		pt.setInt(3,x.getEdition());
		
		
		int r = pt.executeUpdate();
		
		stmt.close();
	    con.close();
		return r;
		
	}
	
	static int delete(Book x) throws Exception 
	{
		Connection con = null;
		Statement stmt = null;
		
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookcases","root","root");
			stmt= con.createStatement();
		} 
		catch (ClassNotFoundException e) 
		{
			
			e.printStackTrace();
		}

		PreparedStatement pt = con.prepareStatement("delete from Bookdb where ISBN_number = ?");
		pt.setInt(1, x.getISBN_number());
	
		int r = pt.executeUpdate();
		
		stmt.close();
	    con.close();
		return r;
		
	}

}
