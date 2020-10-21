package com.ntt.bookcasestudy;

import java.util.Scanner;


public class Mainclass {


	public static void main(String[] args)
	{
		
		BookOperations bl = new BookOperations();
		Book b = new Book();
		int choice=0;
		
		while(choice==0)
		{
		System.out.println("select the option");
		System.out.println("1 -> Create an Book record");
		System.out.println("2 -> Read Boook record");
		System.out.println("3 -> Update Book record");
		System.out.println("4 -> Delete Book record");
		
		Scanner sc=new Scanner(System.in);
		int option = sc.nextInt();
		
		switch(option)
		{
		
		case 1 :{
		             
		     System.out.println("Enter Book_Name");
		     sc.nextLine();
		      b.setBookName(sc.nextLine());
		     
		     System.out.println("Enter Author_Name");
		      b.setAuthorName(sc.nextLine());
		     System.out.println("Enter Edition");
		     b.setEdition(sc.nextInt());
			     int val = bl.createBookDetails(b);
			     if(val==0)
			    	 System.out.println("Book record not Created");
			     else
			    	 System.out.println("Book record Created");
			     break;
		        }
		
		case 2:{
		          System.out.println("Enter ISBN_number");
		          b.setIsbnNumber(sc.nextInt());
		          bl.readBook(b);
		          break;
		       }
		
		case 3:{
			       System.out.println("Enter ISBN_number to update its details");
			       b.setIsbnNumber(sc.nextInt());
			       System.out.println("Enter Book_Name");
			       sc.nextLine();
				     b.setBookName(sc.nextLine());
				     System.out.println("Enter Author_Name");
				     b.setAuthorName(sc.nextLine());
				     System.out.println("Enter Edition");
				     b.setEdition(sc.nextInt());

		           int val = bl.updateBook(b);
		           if(val==0)
		    	    System.out.println("Employee details not Updated");
		           else
		    	    System.out.println("Employee details Updated");
		           break;
			      			
		       }
		case 4:{
		       System.out.println("Enter ISBN_number to Delete employee");
		       b.setIsbnNumber(sc.nextInt());
		       
	           int val = bl.deleteBook(b);
	           if(val==0)
	    	    System.out.println("Book not Deleted");
	           else
	    	    System.out.println("Book Deleted");
	           break;
		}
		 default:
			    String ex = "Enter Valid Option";
				System.out.println(ex);
			    break;
		      			
	       
		
		} 
		
		System.out.println("Press 0 to continue");
		choice = sc.nextInt();
		}

	}
}


	