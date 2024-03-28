package Library;

import java.util.Scanner;

public class LibraryManagementSystem {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Admin admin = new Admin();
        Library library = new Library();
        User user = new User();
        boolean ans = true;
        while (ans) { 
            System.out.println("1-Admin 2-User 3-Exit");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("--------------Admin Login---------------");
                    System.out.println("Enter the Adminname: ");
                    String name = sc.next();
                    System.out.println("Enter the AdminId: ");
                    int id = sc.nextInt();
                    if (admin.checkAdmin(name, id)) {
                        System.out.println("Successfully Login");
                        System.out.println("----------------------------------------");
                        boolean ans1=true;
                        while(ans1) {
                        	System.out.println("1-Add User 2-Add Books 3-Available Books 4-VerifiedUsers 5-Remove User 6-Main Menu");
                            int adminChoice = sc.nextInt();
                            switch (adminChoice) {
                                case 1:
                                    System.out.println("-------------Add User--------------------");
                                    System.out.println("Enter the name of User: ");
                                    String username = sc.next();
                                    user.Adduser(username);
                                    break;
                                case 2:
                                	System.out.println("------------------Add Books------------------");
                    				System.out.println("Enter the BookName: ");
                    				String BookName=sc.next().toLowerCase();
                    				System.out.println("Enter the BookGenre: ");
                    				String Genre=sc.next().toLowerCase();
                    				library.addBooks(BookName,Genre);
                    				break;
                                case 3:
                                	library.AvailableBooks();
                                	break;
                                case 4:
                                	user.verifiedUsers();
                                	break;
                                case 5:
                                	System.out.println("Enter the UserId for Remove User");
                                	int userid=sc.nextInt();
                                	System.out.println("--------Remove User----------");
                                	user.removeUser(userid);
                                	break;
                                	
                                case 6:
                                	ans1=false;
                                	break;
                                default:
                                	break;	
                                    
                            }
                        }
                        }
                         else {
                        System.out.println("----------------------------------------");
                        System.out.println("Login Failed");
                        System.out.println("----------------------------------------\n");
                    }
                    break;
                case 2:
                    System.out.println("Welcome the User page");
                    System.out.println("Enter the Userid");
                    int userid=sc.nextInt();
                    user.checkUser(library,userid);
                case 3:
                    ans = false; 
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}
