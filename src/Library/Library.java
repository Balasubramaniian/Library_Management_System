package Library;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Library {
	static int id=1001;
	int bookid;
	String Bookname;
	String Genres;
	List<Library> booksList=new ArrayList<>();
	List<String> genrelist=new ArrayList<>();
	LocalDate today=LocalDate.now();
	LocalDate availabledate;
	private static int perdayrate=10;
	private int earning;
	boolean booked;
	int returnDays;
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



	public Library(int bookid, String bookname, String genres) {
		super();
		this.availabledate=today;
		this.bookid = bookid;
		Bookname = bookname;
		Genres = genres;
		booked=true;
	}

	public boolean isBooked() {
		return booked;
	}

	public void setBooked(boolean booked) {
		this.booked = booked;
	}

	public LocalDate getAvailabledate() {
		return availabledate;
	}

	public void setAvailabledate(LocalDate availabledate) {
		this.availabledate = availabledate;
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
			System.out.println("BookeId: "+l.bookid+"\nBookName: "+l.Bookname+"\nBookAvailable: "+(l.booked?"Yes":"No"));
		}
		System.out.println("----------------------------------------");
	}
	
	public void bookingBooks(String bookname) {
		Scanner sc=new Scanner(System.in);
	    boolean bookBooked = true; 
	    for (int i = 0; i < booksList.size(); i++) {
	        if (booksList.get(i).Bookname.equals(bookname)) {
	            if (!booksList.get(i).booked) { 
	                System.out.println("Sorry, this book is already booked.");
	                bookBooked = false; 
	                break; 
	            } else {
	            	System.out.println("Enter the days from current date for return book:");
                    int days = sc.nextInt();
                    LocalDate returnDate = today.plusDays(days);
                    Period period = Period.between(today, returnDate);
                    returnDays = period.getDays();
	                booksList.get(i).setBooked(false);
	                earning += perdayrate * returnDays; 
	                booksList.get(i).availabledate = today.plusDays(returnDays); 
	                bookBooked = true; 
	                System.out.println("Book Booked Successfully");
	                break; 
	            }
	        }
	    }
	    if (!bookBooked) { 
	        System.out.println("kindly book the book after " + returnDays + " days.");
	    }
	}


	
	public void returnBook(String bookname) {
		for(int i=0;i<booksList.size();i++) {
			if(booksList.get(i).Bookname.equals(bookname)) {
				booksList.get(i).booked=true;
			}
		}
	}
	
	public int getEarning() {
		return earning;
	}

	public void setEarning(int earning) {
		this.earning = earning;
	}

	
	
	@Override
	public String toString() {
		return "BookId: " + bookid + "\nBookName=" + Bookname + "\nGenres=" + Genres +"\nBookAvailable= "+ (booked?"Yes":"No");
	}
	
	

}
