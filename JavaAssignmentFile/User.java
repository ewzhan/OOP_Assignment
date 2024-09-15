public class User{
	private String userName;
	private String userPassword;
	private String email;
	private String phNo;
	private static int count = 1;
	
	public User(){
		this("","","","");
		this.count++;
	}
	public User(String userName, String userPassword, String email, String phNo){
		this.count++;
		this.userPassword = userPassword;
		this.userName = userName;
		this.email = email;
		this.phNo = phNo;
	}
	
	public String getUserPassword(){
		return this.userPassword;
	}
	public String getUserName(){
		return this.userName;
	}
	public String getEmail(){
		return this.email;
	}
	public String getPhoneNumber(){
		return this.phNo;
	}
	
	public void setUserPassword(String userPassword){
		this.userPassword = userPassword;
	}
	public void setUserName(String userName){
		this.userName = userName;
	}
	public void setEmail(String email){
		this.email = email;
	}
	public void setPhoneNumber(String phNo){
		this.phNo = phNo;
	}
	
	public String toString(){
		return "\nName        : " + this.userName +
			   "\nPassword    : " + "************" +
			   "\nEmail       : " + this.email +
			   "\nPhone Number: " + this.phNo;
	}
}