package Library;

import java.util.*;
public class Admin {

	static int id=1;
	private int adminId=1;
	private String Adminname="admin";
	static List<Admin> adminsList=new ArrayList<>();
	
	Admin(){
		if(adminsList.size()==0) {
				adminsList.add(new Admin(adminId,Adminname));
		}
		
	}
	Admin(int adminId,String Adminname){
		this.adminId=adminId;
		this.Adminname=Adminname;
	}
	public boolean checkAdmin(String name,int id) {
		if(Adminname.equals(name) && adminId ==id) {
			return true;
		}
		else {
			return false;
		}
	}
	public void createAdmins(int n) {
		for(int i=0;i<n;i++) {
		Scanner sc=new Scanner(System.in);
		adminId=id++;
		System.out.println("Enter the AdminName: ");
		String adminname=sc.next();
		Adminname=adminname;
		adminsList.add(new Admin(adminId,adminname));
		}
	}
	
}
