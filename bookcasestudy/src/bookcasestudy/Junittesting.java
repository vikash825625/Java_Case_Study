package bookcasestudy;

import static org.junit.jupiter.api.Assertions.*;
import java.sql.Connection;
import java.sql.DriverManager;

public class Junittesting {
	
	public void testIt() throws Exception {

		  Bookdblayer bk = new Bookdblayer();
		  Book n = new Book(12345,"NEW BOOK","RR",1990);
		  
		  
		  int result =  bk.create(n);
		  assertEquals(1,result); 
		  
		}

}
