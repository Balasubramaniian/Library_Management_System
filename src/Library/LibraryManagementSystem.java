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
                    System.out.println("--------------Admin Login---------------\n");
                    System.out.println("Enter the Adminname: ");
                    String name = sc.next();
                    System.out.println("Enter the AdminId: ");
                    int id = sc.nextInt();
                    if (admin.checkAdmin(name, id)) {
                        System.out.println("Successfully Login");
                        System.out.println("----------------------------------------\n");
                        boolean ans1=true;
                        while(ans1) {
                        	System.out.println("1-Add User 2-Add Books 3-Available Books 4-Remove User");
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
                    				String BookName=sc.next();
                    				System.out.println("Enter the BookGenre: ");
                    				String Genre=sc.next();
                    				library.addBooks(BookName,Genre);
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
                    System.out.println("------------------Add Books------------------");
                    System.out.println("Enter the Book Name: ");
                    String bookName = sc.next();
                    System.out.println("Enter the Book Genre: ");
                    String genre = sc.next();
                    library.addBooks(bookName, genre);
                    break;
                case 3:
                    ans = false; 
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}
