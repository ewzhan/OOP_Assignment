import java.util.*;
public class Employee extends User{
	private String employeeID;
	private double salary;
	private String startDate;
	private static int count = 0;
	
	public Employee(){
		this("","","","",0.00,"");
	}
	public Employee(String userName, String userPassword, String email, String phNo,double salary, String startDate){
		super(userName,userPassword,email,phNo);
		this.employeeID = String.format("E%04d",count);
		this.salary = salary;
		this.startDate = startDate;
		this.count++;
	}
	
	public double getSalary(){
		return this.salary;
	}
	public String getStartDate(){
		return this.startDate;
	}
	
	public void setSalary(double salary){
		this.salary = salary;
	}
	public void setStartDate(String startDate){
		this.startDate = startDate;
	}
	
	public void login(Employee[] emp){
		Scanner sc = new Scanner(System.in);	
		boolean validUser = false;
		boolean validPassword = false;
		
		System.out.println("\nEmployee Login  (X to exit)\n=============");
		do{
			System.out.print("Please enter username > ");
			String name = sc.nextLine();
			if(name.trim().equalsIgnoreCase("X")){		
				System.out.println("Bye Bye");	
				break;
			}
			System.out.print("Please enter password > ");
			String password = sc.nextLine();
			
			for(int i=0;i<emp.length;i++){
				if(name.trim().equals(emp[i].getUserName())){
					validUser = true;
					if(password.trim().equals(emp[i].getUserPassword())){
						validPassword = true;
						System.out.println("Login Successful !!");
						System.out.println("\nThis is your employee details:");
						System.out.println(emp[i].toString());
						break;
					}continue;
				}
				
			}		
				
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
		}while(validUser == false || validPassword == false);
	}
	
	public String toString(){
		return "\nEmployee    : " + this.employeeID + super.toString() + "\nSalary      : " + this.salary + "";
	}
}