import java.util.*;
public class Admin extends User{
	private String adminID;
	private static int count = 0;
	Scanner sc = new Scanner(System.in);
	
	public Admin(){
		super("","","","");
	}	
	public Admin(String userName, String userPassword, String email, String phNo){
		super(userName,userPassword,email,phNo);
		this.count++;
		this.adminID = String.format("A%04d",count);
	}
	
	public void login(Admin a){
		Scanner sc = new Scanner(System.in);	
		boolean validUser = false;
		boolean validPassword = false;
		
		System.out.println("\nAdmin Login  (X to exit)\n=============");
		do{
			System.out.print("Please enter username > ");
			String name = sc.nextLine();
			if(name.trim().equalsIgnoreCase("X")){		//Exit 
				System.out.println("Bye Bye");
				System.exit(0);	
				break;
			}
			System.out.print("Please enter password > ");
			String password = sc.nextLine();
			
			
			if(name.trim().equals(a.getUserName()))
				validUser = true;
			if(password.trim().equals(a.getUserPassword()))
				validPassword = true;
				
				
			if(validUser == false && validPassword == false)
				System.out.println("\n!! Both username and password are wrong !!");
			else if(validUser == false){
				System.out.println("\nInvalid username, please enter again");
				validPassword = false;
			}
			else if(validPassword == false){
				System.out.println("\nInvalid password, please enter again");
				validUser = false;
			}
			else{
				System.out.println("Login Successful !!");
				System.out.print("\nThis is your admin details:");
				System.out.println(a.toString());
			}			
		}while(validUser == false || validPassword == false);
	}
	public void createUser(){
		System.out.println("Create a User :");
		System.out.print("Fill up username :");
		System.out.print("Enter password :");
		System.out.print("Email :");
		System.out.print("Phone Number:");
	}
	
	public void deleteUser(){
	
	}
	public String toString(){
		return "\nAdmin ID    : " + this.adminID + super.toString();
	}
}