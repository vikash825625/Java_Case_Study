package com.ntt.bookcasestudy;

public class Book {

	private int isbnNumber;
	private int edition;
	private String bookName;
	private String authorName;

	public int getIsbnNumber() {
		return isbnNumber;
	}
	
	public void setIsbnNumber(int isbnNumber) {
		this.isbnNumber = isbnNumber;
	}
	
	public int getEdition() {
		return edition;
	}
	
	public void setEdition(int edition) {
		this.edition = edition;
	}
	
	public String getBookName() {
		return bookName;
	}
	
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	
	public String getAuthorName() {
		return authorName;
	}
	
	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}
	public Book(int	isbnNumber1,String bookName1,String authorName1,int edition1) {
		super();
		isbnNumber=isbnNumber1;
		bookName=bookName1;
		authorName=authorName1;
		edition=edition1;
		
	}
	public Book() {
		super();
	}

}
