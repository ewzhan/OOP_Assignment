import java.util.*;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
public abstract class User {
	protected String userName;
	protected String userPassword;
	protected String email;
	protected String phNo;
	protected MyDate date;
	public abstract String toString();
	
	public User(){
		this("","","","",new MyDate());
	}
	public User(String userName, String userPassword, String email, String phNo,MyDate date){	//constructor with parameter
		this.userPassword = userPassword;
		this.userName = userName;
		this.email = email;
		this.phNo = phNo;
		this.date = date;
	}
	public String getName(){
		return userName;
	}
	public String getEmail(){
		return email;
	}
	public MyDate getDate(){
		return date;
	}
	public String getPhone(){
		return phNo;
	}
	public void setPassword(String userPassword){	//mutators
		this.userPassword = userPassword;
	}
	public void setName(String userName){
		this.userName = userName;
	}
	public void setEmail(String email){
		this.email = email;
	}
	public void setPhone(String phNo){
		this.phNo = phNo;
	}
	
	public boolean validName(String name) {
        String namePattern = "^[a-zA-Z ]+$";
        if(name == null){
        	System.out.println("Please fill in name");
        	return false;
        }
        else if(name.length() < 10){
        	System.out.println("Name must contain at least 10 characters");
        	return false;
        }
        else if (!Pattern.matches(namePattern, name)) {
            System.out.println("Invalid, name must contain combination of uppercase, lowercase and spaces");
            return false;
        } 
        else {
            return true;
        }
    }
    public boolean validPassword(String password){
    	String passwordPattern = "^[a-zA-Z0-9]+$";
    	if(password == null){
        	System.out.println("Please enter password");
    		return false;
    	}
    	else if(password.length() < 8){
        	System.out.println("password length must have at least 8 character");
    		return false;
    	}
    	else if(!Pattern.matches(passwordPattern,password)){
        	System.out.println("Password must contain number,uppercase and lowercase letter");
  			return false;  		
    	}
    	else{
    		return true;
    	}
    }
    public boolean validEmail(String email){
    	String emailPattern = "^[a-zA-Z]+@gmail.com$";
    	if(email == null){
    		System.out.println("Please fill in email");
    		return false;
    	}
    	else if(!Pattern.matches(emailPattern,email)){
    		System.out.println("Invalid, must follow the email format");
    		return false;
    	}
    	else{
    		return true;
    	}
    }
    public boolean validPhoneNumber(String phone){
    	String phonePattern = "^01[0-9]-[0-9]{7,8}$";
    	if(phone == null){
    		System.out.println("Please fill in phone number");
    		return false;
    	}
    	else if(!Pattern.matches(phonePattern,phone)){
    		System.out.println("Invalid phone number format");
    		return false;
    	}
    	else{
    		return true;
    	}
    }
}