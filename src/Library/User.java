package Library;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class User {
	static int id=1;
	int userid;
	String name;
	
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

	

	@Override
	public String toString() {
		return "UserId: " + userid + "\nName: " + name;
	}
	
}
