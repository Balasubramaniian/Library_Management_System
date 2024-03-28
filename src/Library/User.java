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
		System.out.println("---------------User Details-------------\n");
		for(User u:userList) {
			System.out.println(u);
		}
		System.out.println("----------------------------------------\n");
		
	}

	

	@Override
	public String toString() {
		return "UserId: " + userid + "\nName: " + name;
	}
	
}
