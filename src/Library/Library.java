package Library;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Library {
	static int id=1001;
	int bookid;
	String Bookname;
	String Genres;
	List<Library> booksList=new ArrayList<>();
	List<String> genrelist=new ArrayList<>();
//	int bookrack;
//	static int bookrackid=1;
//	
//	Map<String,Integer> bookracksgenrevise=new HashMap<>();
	
	Library(){
		
	}

	public String getBookname() {
		return Bookname;
	}

	public void setBookname(String bookname) {
		Bookname = bookname;
	}

	public String getGenres() {
		return Genres;
	}

	public void setGenres(String genres) {
		Genres = genres;
	}

//	public int getBookrack() {
//		return bookrack;
//	}
//
//	public void setBookrack(int bookrack) {
//		this.bookrack = bookrack;
//	}

	public Library(int bookid, String bookname, String genres) {
		super();
		this.bookid = bookid;
		Bookname = bookname;
		Genres = genres;
	}

	public void addBooks(String bookname,String genres) {
		bookid=id++;
		if(!genrelist.contains(genres)) {
			genrelist.add(genres);
		}
		booksList.add(new Library(bookid,bookname,genres));
		System.out.println("Sucessfully Added Book");
		
	}
	
	public void AvailableBooks() {
		System.out.println("--------------Book Details-------------");
		for(Library l:booksList) {
			System.out.println(l+"\n");
		}
		System.out.println("----------------------------------------");
	}
	@Override
	public String toString() {
		return "BookId: " + bookid + "\nBookName=" + Bookname + "\nGenres=" + Genres ;
	}
	
	

}
