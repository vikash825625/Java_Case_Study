package com.ntt.bookcasestudy;
import java.sql.Connection;

public interface Businesslayer {
	
int createBookDetails(Book b);
Book readBook(Book b);
int updateBook(Book b);
int deleteBook(Book b);
}


 class BookOperations implements Businesslayer
{
	Connection con;
	int ret;
	@Override
    public int createBookDetails(Book b)     //inserts a new book details 
	{
		con = BookUtility.createCon();
		ret = BookDAO.createBookDetails(b, con);
		int y = BookDAO.getIsbn(b, con);
		if(y != 0)
			System.out.println("Isbn Number generated for new insertion is : "+y);
		con = BookUtility.closeCon(con);
		return ret;
	}
	
	@Override
	public  Book readBook(Book b)    //reads the particular book details using isbn
	{
		con = BookUtility.createCon();
		Book b1 = null;
		if(BookDAO.validateIsbn(b, con))
			b1 = BookDAO.readBook(b, con);		   
		else
			System.out.println("Invalid Isbn_Number!!!.....");
		con = BookUtility.closeCon(con);
		return b1 ;
	}
	
	@Override
	public int updateBook(Book b)  //updates new edition number using isbn
	{
		con = BookUtility.createCon();
		
		if(BookDAO.validateIsbn(b, con))
			ret = BookDAO.updateBook(b, con);
		else
			System.out.println("Invalid Isbn_Number!!!.....");
		con = BookUtility.closeCon(con);
		return ret ;
	}
	
	@Override
	public int deleteBook(Book b)   //deletes book details using isbn
	{
		con = BookUtility.createCon();
		if(BookDAO.validateIsbn(b,con))
			 ret = BookDAO.deleteBook(b, con);
		else
			System.out.println("Invalid Isbn_Number!!!.....");
		con = BookUtility.closeCon(con);
		return ret ;
	}

	
}
