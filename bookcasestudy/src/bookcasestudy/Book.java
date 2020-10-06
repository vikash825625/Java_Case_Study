package bookcasestudy;

public class Book {

	int	ISBN_number; 
	public int getISBN_number() {
		return ISBN_number;
	}
	public void setISBN_number(int iSBN_number) {
		ISBN_number = iSBN_number;
	}
	String Book_Name;
	public String getBook_Name() {
		return Book_Name;
	}
	public void setBook_Name(String book_Name) {
		Book_Name = book_Name;
	}
	String Author_Name;
	public String getAuthor_Name() {
		return Author_Name;
	}
	public void setAuthor_Name(String author_Name) {
		Author_Name = author_Name;
	}
	int Edition;
	public int getEdition() {
		return Edition;
	}
	public void setEdition(int Edition) {
		Edition = Edition;
	}
	public Book(int	ISBN_number,String Book_Name,String Author_Name,int Edition) {
		super();
		ISBN_number=ISBN_number;
		Book_Name=Book_Name;
		Author_Name=Author_Name;
		Edition=Edition;
		
	}
	public Book() {
		super();
	}

}
