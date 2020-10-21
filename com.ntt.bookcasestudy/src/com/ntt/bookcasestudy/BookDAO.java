package com.ntt.bookcasestudy;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public class BookDAO {static PreparedStatement pt;
static ResultSet rs;
/**
 * creates book records
 * @param b
 * @param con
 * @return
 */
public static int createBookDetails(Book b, Connection con)     //inserts a new book details
{
	int ret = 0;
	try 
	{
		pt = con.prepareStatement("insert into Book(Book_Name, Author_Name, Edition) values (?,?,?)");
		pt.setString(1 , b.getBookName());
		pt.setString(2 , b.getAuthorName());
		pt.setInt(3 , b.getEdition());
		ret = pt.executeUpdate();
	} 
	catch (SQLException e) 
	{
		System.out.println(e);
	}	
	finally
	{
		try 
		{
			pt.close();
		} 
		catch (SQLException e) 
		{
			System.out.println(e);
		}
	}
	return ret;
}
/**
 * gets all isbn from db
 * @param b
 * @param con
 * @return
 */
public static int getIsbn(Book b, Connection con)     //gets Isbn of inserted 
{
	int ret = 0;
	try 
	{
		pt = con.prepareStatement("select * from Book where Book_Name = ? and Author_name =? and Edition =?");
		pt.setString(1 , b.getBookName());
		pt.setString(2 , b.getAuthorName());
		pt.setInt(3 , b.getEdition());
		rs = pt.executeQuery();
		while(rs.next()) 
		{
			ret = rs.getInt("Isbn_Number");
		}
	} 
	catch (SQLException e) 
	{
		System.out.println(e);
	}	
	finally
	{
		try 
		{
			 rs.close();
		} 
		catch (SQLException e) 
		{
			System.out.println(e);
		}
	}
	return ret;
}
/**
 * validates given isbn number is in db or not
 * @param b
 * @param con
 * @return
 */
public static boolean validateIsbn(Book b,Connection con)  //checks whether particular isbn is present in table
{
	boolean bool = false;
	try 
	{
		pt = con.prepareStatement("select * from Book where Isbn_number = ?");
		pt.setInt(1 , b.getIsbnNumber());
		rs = pt.executeQuery();
		bool = rs.next();
	} 
	catch (SQLException e) 
	{
		System.out.println(e);
	}
	finally
	{
		try 
		{
			 rs.close();
		} 
		catch (SQLException e) 
		{
			System.out.println(e);
		}
	}
	return (bool);
}
/**
 * reads the particular book details using isbn
 * @param b
 * @param con
 * @return
 */
public static Book readBook(Book b ,Connection con)  
{	
	try 
	{
		con = BookUtility.createCon();

		Statement stmt=con.createStatement();
		
			ResultSet rs= stmt.executeQuery("select * from Book where Isbn_Number="+b.getIsbnNumber());
			
		while(rs.next()) 
		{
			  System.out.println("ISBN_number : "+rs.getInt("Isbn_Number")+
			    		"\nBook_Name : "+rs.getString("Book_Name")+
			    		"\nAuthor_Name : "+rs.getString("Author_Name")+
			    		"\nEdition : "+rs.getInt("Edition")
			    		);
		}	
	} 
	catch (SQLException e) 
	{
		System.out.println(e);
	}
	finally
	{
		try 
		{
			 rs.close();
		} 
		catch (SQLException e) 
		{
			System.out.println(e);
		}
	}
	return b;
}
/**
 * updates new edition number using isbn
 * @param b
 * @param con
 * @return
 */
public static int updateBook(Book b, Connection con)  
{
	int ret = 0;
	try 
	{
		pt = con.prepareStatement(" update Book SET Book_Name = ?, Author_Name = ?, Edition=?\r\n" + 
				" where Isbn_number = ?");
		pt.setString(1 , b.getBookName());
		pt.setString(2 , b.getAuthorName());
		pt.setInt(3 , b.getEdition());
		pt.setInt(4, b.getIsbnNumber());
		ret = pt.executeUpdate();
	} 
	catch (SQLException e) 
	{
		System.out.println(e);
	}
	finally
	{
		try 
		{
			 pt.close();
		} 
		catch (SQLException e) 
		{
			System.out.println(e);
		}
	}
	return ret;
}
/**
 * delete book details using isbn
 * @param bp
 * @param con
 * @return
 */
public static int deleteBook(Book bp, Connection con)  
{
	int ret = 0;
	try
	{
		PreparedStatement pt = con.prepareStatement("delete from Book where Isbn_Number = ?");
		pt.setInt(1,bp.getIsbnNumber());
		ret = pt.executeUpdate();
	}
	catch (SQLException e) 
	{
		System.out.println(e);
	}
	finally
	{
		try 
		{
			 pt.close();
		} 
		catch (SQLException e) 
		{
			System.out.println(e);
		}
	}
	return ret;	
}
}
