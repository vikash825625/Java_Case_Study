package com.ntt.bookcasestudy;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;


public class Junittesting {
	
	BookOperations bk = new BookOperations();
	  Book b= new  Book();

	  
	
	  @Test
		void testInsertTrue1() 
		{
			
				b.setBookName("The Rule Breakers");
				b.setAuthorName("Preeti Shenoy");
				b.setEdition(5);
				assertEquals(1,bk.createBookDetails(b));	// This is properly executed returns success					
		}

		@Test
		void testInsertFailure1() // This failure occurs because of null value for author_Name
		{
			b.setBookName("Revolution 2020");
			b.setAuthorName(null); // cannot be null
			b.setEdition(4);
			assertEquals(0,bk.createBookDetails(b));
				
		}
		
		@Test
		void testInsertFailure2() // This failure occurs because of null value for author_Name
		{
				b.setBookName(null);// cannot be null
				b.setAuthorName("Chetan bhagat"); 
				b.setEdition(4);
				assertEquals(0,bk.createBookDetails(b));
		}
		
		@Test
		void testInsertFailure3()  // This failure occurs because Edition should be greater than 0 
		{
				b.setBookName("Revolution 2020");
				b.setAuthorName("Chetan bhagat");
				b.setEdition(0); //should be greater than 0 
				assertEquals(0,bk.createBookDetails(b));	
		}

}
