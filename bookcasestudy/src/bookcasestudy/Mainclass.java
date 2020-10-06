package bookcasestudy;

import java.util.Scanner;
import java.util.UUID;

public class Mainclass {


	public static void main(String[] args) throws Exception 
	{
		
		Bookdblayer db = new Bookdblayer();
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
			System.out.println("Enter ISBN_number");
		     b.setISBN_number(sc.nextInt());                 
			
		     System.out.println("Enter Book_Name");
		     b.setBook_Name(sc.next());
		     System.out.println("Enter Author_Name");
		     b.setAuthor_Name(sc.next());
		     System.out.println("Enter Edition");
		     b.setEdition(sc.nextInt());
			     int val = db.create(b);
			     if(val==0)
			    	 System.out.println("Book record not Created");
			     else
			    	 System.out.println("Book record Created");
			     break;
		        }
		
		case 2:{
		          System.out.println("Enter ISBN_number");
		          b.setISBN_number(sc.nextInt());
		          db.read(b);
		          break;
		       }
		
		case 3:{
			       System.out.println("Enter ISBN_number to update its details");
			       b.setISBN_number(sc.nextInt());
			       System.out.println("Enter Book_Name");
				     b.setBook_Name(sc.next());
				     System.out.println("Enter Author_Name");
				     b.setAuthor_Name(sc.next());
				     System.out.println("Enter Edition");
		           int val = Bookdblayer.update(b);
		           if(val==0)
		    	    System.out.println("Employee details not Updated");
		           else
		    	    System.out.println("Employee details Updated");
		           break;
			      			
		       }
		case 4:{
		       System.out.println("Enter ISBN_number to Delete employee");
		       b.setISBN_number(sc.nextInt());
		       
	           int val = Bookdblayer.delete(b);
	           if(val==0)
	    	    System.out.println("Book not Deleted");
	           else
	    	    System.out.println("Book Deleted");
	           break;
		      			
	       }
		
		} 
		
		System.out.println("Press 0 to continue");
		choice = sc.nextInt();
		}

	}}


	