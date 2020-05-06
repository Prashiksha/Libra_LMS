package com.lms.dto;

public class BooksDTO {
	
	String ISBN;
	String book_title;
	String author;
	String genre;
	String language;
	int cost;
	//int shelf_number;
	int quantity_initial;
	//int quantity_current;
	
	
	public String getISBN() {
		return ISBN;
	}
	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}
	public String getBook_title() {
		return book_title;
	}
	public void setBook_title(String book_title) {
		this.book_title = book_title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public int getCost() {
		return cost;
	}
	public void setCost(int cost) {
		this.cost = cost;
	}
	/*public int getShelf_number() {
		return shelf_number;
	}
	public void setShelf_number(int shelf_number) {
		this.shelf_number = shelf_number;
	}*/
	
	public int getQuantity_initial() {
		return quantity_initial;
	}
	public void setQuantity_initial(int quantity_initial) {
		this.quantity_initial = quantity_initial;
	}
	/*public int getQuantity_current() {
		return quantity_current;
	}
	public void setQuantity_current(int quantity_current) {
		this.quantity_current = quantity_current;
	}
	*/
	

}
