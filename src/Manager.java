
public class Manager {

	// issue:如果manager's id and password == customer's id and password 怎么区分。
	private String managerFirstname;
	private String managerLastname;
	
	private int managerId;
	private String password;
	
	public Manager(String firstname,String lastname, int id, String password){
		
		this.managerId = id;
		this.password = password;
		this.managerFirstname = firstname;
		this.managerLastname = lastname;
	}
	
	public String getFirstname(){
		
		return managerFirstname;
	}
	
	public String getLastname(){
		
		return managerLastname;
	}
	
}
