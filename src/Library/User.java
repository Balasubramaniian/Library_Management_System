package Library;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class User {
	static int id=1;
	int userid;
	String name;
	LocalDate today=LocalDate.now();
	List<User> userList=new ArrayList<>();
	
	User(){
		
	}
	public User(int userid, String name) {
		this.userid = userid;
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
	
	public void Adduser(String Name){
		name=Name;
		userid=id++;
		userList.add(new User(userid,name));
		System.out.println("Successfully Created\n");
	}
	public void verifiedUsers() {
		System.out.println("---------------User Details-------------");
		for(User u:userList) {
			System.out.println(u+"\n");
		}
		System.out.println("----------------------------------------");
	}

	public void removeUser(int userid) {
	    boolean removed = false; 
	    for (int i = 0; i < userList.size(); i++) {
	        if (userList.get(i).userid == userid) {
	            userList.remove(i);
	            removed = true;
	            System.out.println("------------------------Removed Successfully--------------------");
	            break; 
	        }
	    }
	    if (!removed) {
	        System.out.println("User with ID " + userid + " not found");
	    }
	}

	public void checkUser(Library library,int userid) {
		boolean ans=false;
		Scanner sc = new Scanner(System.in);
	  for(int i=0;i<userList.size();i++) {
		  if(userList.get(i).userid==userid) {
			  System.out.println("Welcome "+userList.get(i).name);
			  ans=true;
		  }
	  }
			  while(ans) {
				  System.out.println("1-AvailableBooks 2-GetBook 3-ReturnBook  4-Exit");
		            int choice = sc.nextInt();
		            switch (choice) {
		                case 1:
		                	library.AvailableBooks();
		                	break;
		                case 2:
		                	boolean bookAvailable = false;
		                    System.out.println("Enter the BookName:");
		                    String bookName = sc.next().toLowerCase();

		                    for (int index = 0; index < library.booksList.size(); index++) {
		                        if (library.booksList.get(index).getBookname().equals(bookName)) {
		                            bookAvailable = true; 
		                            library.bookingBooks(bookName);
		                            break;
		                        }
		                    }

		                    if (!bookAvailable) {
		                        System.out.println("Sorry, the entered book name is invalid.");
		                    }
		                    break;

		                case 3:
		                	System.out.println("bookname: ");
		                	String bookname=sc.next();
		                	library.returnBook(bookname);
		                	break;
		                case 4:
		                	ans=false;
		                	break;
		                default:
		                    break;
		            } 
	  }
	  
	  
	}
	

	@Override
	public String toString() {
		return "UserId: " + userid + "\nName: " + name;
	}
	
}
