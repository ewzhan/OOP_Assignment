import java.util.*;
public class Employee extends User{ 
	private	String employeeID;
	private	double salary;
	private	static int count = 0;	//Used to Format employeeID
	
	public Employee(){		//Default constructor
		this("","","","",new MyDate(),0.00);
	}
	public Employee(String userName, String	userPassword, String email,	String phNo,MyDate date,double salary){//constructor with parameter
		super(userName,userPassword,email,phNo,date);
		this.employeeID	= String.format("E%04d",count);	//Format the employeeID by counting the employees
		this.salary	= salary;
		this.count++;
	}
	
	public String getEmployeeID(){
		return this.employeeID;
	}
	public double getSalary(){	//accessors
		return this.salary;
	}
	public int getEmployeeCount(){
		return this.count;
	}
	
	public void	setSalary(double salary){	//mutators
		this.salary	= salary;
	}    
	public Employee	login(Employee[] emp){	//Login employee method
		Scanner	sc = new Scanner(System.in);	
		boolean	validUser =	false;
		boolean	validPassword =	false;
		
		System.out.println("\nEmployee Login  (X to	exit)\n=============");
		do{//Loop if either username or password are wrong
			try{
				System.out.print("Please enter username	> ");
				String name	= sc.nextLine();
				
				System.out.print("Please enter password	> ");
				String password	= sc.nextLine();
				for(int	i=0;i<emp.length;i++){	//Loop the array of employees
					if(emp[i]!=null && name.trim().equals(emp[i].userName)){	//If one of the employee's name match with the user input username
						validUser =	true;							//return true
						if(password.trim().equals(emp[i].userPassword)){	//If the following employee's password match with the input password
							validPassword =	true;								//return true
							return emp[i];
						}break;
					}
				}
			}
			catch(NullPointerException ex){			
				System.out.println("Invalid username, please try again");
			}
					
				
			if(validUser ==	false && validPassword == false)		//If username and password are wrong
				System.out.println("\n!! Both username and password	are	wrong !!");
			else if(validUser == false){							//if username are wrong
				System.out.println("\nInvalid username,	please enter again");
				validPassword =	false;
			}
			else if(validPassword == false){						//if password are wrong
				System.out.println("\nInvalid password,	please enter again");
				validUser =	false;
			}			
		}while(validUser ==	false || validPassword == false);		//Loop if either username or password are wrong
		return null;
	}
	
	public void	editDetail(){
		Scanner sc = new Scanner(System.in);
		boolean condition = false;
		System.out.println("\n_________________________________");
		System.out.println("Which detail you want to change ?");
		System.out.println(" 1. Name");
		System.out.println(" 2. Password");
		System.out.println(" 3. Email");
		System.out.println(" 4. Phone Number");
		while(condition == false){
			try{
				System.out.print("Your choice ->");
				int choice = sc.nextInt();
				sc.nextLine();	//clear the buffer
				switch(choice){
					case 1:
						while(true){
							System.out.print("Enter name ->");
							String name = sc.nextLine();
							if(validName(name)){
								setName(name);
								System.out.println(toString());
								break;
							}
						}
						condition = true;
						break;
					case 2:
						while(true){
							System.out.print("Enter password ->");
							String password = sc.nextLine();
							if(validPassword(password)){
								setPassword(password);
								System.out.println(toString());
								break;
							}
						}
						condition = true;
						break;
					case 3:
						while(true){
							System.out.print("Enter email (eg.abc@gmail.com)->");
							String email = sc.nextLine();
							if(validEmail(email)){
								setEmail(email);
								System.out.println(toString());
								break;
							}
						}
						condition = true;
						break;
					case 4:
						while(true){
							System.out.print("Enter phone number (eg. 012-3456789)->");
							String phone = sc.nextLine();
							if(validPhoneNumber(phone)){
								setPhone(phone);
								System.out.println(toString());
								break;
							}
						}
						condition = true;
						break;
					default:
						System.out.println("Please enter number in range (1-4)");
						break;
				}
			}
			catch(InputMismatchException ex){
				System.out.println("Character detected, please enter numbers");
				sc.nextLine();
			}
			System.out.println("\nDetail changed !!\n");
			System.out.println("Do you want to change another detail ?");
			while(true){
				System.out.print("Your choice ->");
				String yn = sc.nextLine();
				if(yn.trim().equals("Y") || yn.trim().equals("y")){
					condition = false;
					break;
				}
				else if(yn.trim().equals("N") || yn.trim().equals("n")){
					condition = true;
					break;
				}
				else{
					System.out.println("Invalid choice, please enter (Y or N)");
				}
			}
		}
	} 
	
	public String toString(){
		return "\n--------------Employee details--------------\nEmployee ID :	" +	this.employeeID	+ 
				"\nName        : " + userName +
			   "\nPassword    : " + "************" +
			   "\nEmail       : " + email +
			   "\nPhone Number: " + phNo +
			   "\nStart Date  : " + date.toDate() +
			  	"\nSalary		: RM" +	this.salary;
	}
}