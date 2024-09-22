import java.util.*;
public class Admin extends User implements Task{
	private String adminID;
	private static int count = 0;	//Used to format adminID
	Scanner sc = new Scanner(System.in);
	
	public Admin(){		//Default constructor
		this("","","","",new MyDate());
	}	
	public Admin(String userName, String userPassword, String email, String phNo,MyDate date){//constructor with parameter
		super(userName,userPassword,email,phNo,date);
		this.count++;
		this.adminID = String.format("A%04d",count);		//Format adminID by counting the admins
	}
	
	public void checkEmployeeList(Employee[] e){
    	double total=0.00;
		System.out.println("Employee ID | Name            | Email                   | Phone Number | Start Date | Salary (RM)");
    	System.out.println("-------------------------------------------------------------------------------------------------");
   		for (int i = 0; i < e.length; i++) {
   			if(e[i] != null){
   				System.out.printf("%-11s | %-15s | %-23s | %-12s | %-10s | %.2f\n", 
	         	e[i].getEmployeeID(), 
	            e[i].userName, 
	            e[i].email, 
	            e[i].phNo, 
	            e[i].date.toDate(), 
	            e[i].getSalary());
	            total = total + e[i].getSalary();
   			}
    	}System.out.println("\nTotal salary have to pay to all employees -----------------------------------------> "+total);
	}
		
	public void searchEmployee(Employee[] e){
		String empID;	
		boolean condition = false;
		System.out.println("Search Employee:");
		while(condition == false){
			System.out.print("Enter Employee ID (exp. E0001)-> ");
			empID = sc.nextLine();
			for(int i = 0; i < e.length; i++){
				if(e[i] != null && empID.trim().equals(e[i].getEmployeeID())){
					System.out.println("Employee Found !");
					System.out.println(e[i].toString());
					condition = true;
					break;
				}
			}
			if(condition == false){
				System.out.println("Employee ID does not found");	
			}
			else{
				while(true){	
					System.out.print("Search another Employee ? (Y/N) ->");
					String another = sc.nextLine();
					if(another.trim().equals("Y") || another.trim().equals("y")){
						condition = false;
						break;
					}
					else if(another.trim().equals("N") || another.trim().equals("n")){
						condition = true;
						break;
					}
					else{
						System.out.print("Invalid input (Y/N) ->");
					}
				}
			}
		}	
	}
	
	public void editEmployee(Employee[] e){
		int choice;
		boolean condition = false;
		boolean valid = false;
		boolean found = false;
		System.out.println("Which employee you want to modify?");
		while(condition == false){
			String empID;
			System.out.print("Enter the ID (eg. E0001) ->");
			empID = sc.nextLine();
			for(int i = 0; i < e.length; i++){
				if(e[i]!=null && empID.trim().equals(e[i].getEmployeeID())){
				String name = e[i].getName();
				String email = e[i].getEmail();
				String phone = e[i].getPhone();
				double salary = e[i].getSalary();
					System.out.println("\n\nEmployee found !!");
					found = true;
					while(true){
						System.out.println(e[i].toString());
						System.out.println("Which detail you want to edit?");
						System.out.println("1. Name");
						System.out.println("2. Email");
						System.out.println("3. Phone Number");
						System.out.println("4. Salary");
						while(valid == false){
							try{
								System.out.print("Your choice ->");
								choice = sc.nextInt();
								switch(choice){
									case 1:
										sc.nextLine();	//clear the buffer
										while(true){
											System.out.print("Name	->");
											name = sc.nextLine();
											if(validName(name.trim())){
												e[i].setName(name);
												valid = true;
												break;
											}
										}
										break;
									case 2:
										sc.nextLine();	//clear the buffer
										while(true){
											System.out.print("Email	(eg.abc@gmail.com)->");
											email = sc.nextLine();
											if(validEmail(email.trim())){
												e[i].setEmail(email);
												valid = true;	
												break;
											}
										}
										break;
									case 3:
										sc.nextLine();	//clear the buffer
										while(true){
											System.out.print("Phone	(eg.012-3456789)->");
											phone = sc.nextLine();
											if(validPhoneNumber(phone.trim())){
												e[i].setPhone(phone);
												valid = true;
												break;
											}											
										}
										break;
									case 4:
										sc.nextLine();	//clear the buffer
										while(true){
											try{
												System.out.print("Salary (eg.2000)	->");
												salary = sc.nextDouble();
												if(salary > 10000){
													System.out.println("Invalid, salary exceeded RM10000");
													continue;	
												}
												else{
													e[i].setSalary(salary);
													valid = true;
													break;
												}
											}
											catch(InputMismatchException ex){
												System.out.println("Character detected!, please enter digit numbers");
												sc.nextLine();
											}
										}
										break;
									default:
										System.out.println("Invalid choice, please enter again");
										break;
								}
							}
							catch(InputMismatchException ex){
								System.out.println("Invalid input, please select a number in range 1-4");
								sc.nextLine();
							}
							System.out.println("\nEmployee " +empID + " edited !!");
						}
						System.out.println(e[i].toString());
						valid = false;
						break;
					}
				}
			}
			
			if(!found){
				System.out.println(" !! Employee not found !!");
			}
			
			System.out.print("Edit another employee? (Y/N) ->");
			while(true){
				String yn = sc.nextLine();
				if(yn.trim().equals("Y") || yn.trim().equals("y")){
					condition = false;
					break;
				}
				else if(yn.trim().equals("N") || yn.trim().equals("n")){
					sc.nextLine();
					condition = true;
					break;
				}
				else{
					System.out.print("Invalid choice, please enter (Y or N) ->");
				}
			}
		}
	}
	
	public void deleteEmployee(Employee[] e){
		boolean condition = false;
		System.out.println("Which employee you want to fire?");
		while(condition == false){
			System.out.print("Employee ID (eg.E0001) ->");
			String id = sc.nextLine();
			for(int i = 0; i < e.length;i++){
				if(e[i]!=null && id.trim().equals(e[i].getEmployeeID())){
					System.out.println(e[i].toString());
					System.out.println("\nThis employee was fired !!");
					e[i] = null;
					condition = true;
				}
			}
			if(!condition){
				System.out.println("Employee ID not found !");
			}
			
			System.out.print("Do you want to fire another employee? (Y/N) ->");
			while(true){
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
					System.out.print("Invalid choice, please enter (Y or N) ->");
				}
			}
		}
	}
	
	public void	login(Admin[] a){	//Login admin method
		Scanner	sc = new Scanner(System.in);	
		boolean	validUser =	false;
		boolean	validPassword =	false;
		
		System.out.println("\nAdmin Login\n=============");
		do{//Loop if either username or password are wrong
			try{
				System.out.print("Please enter username	> ");
				String name	= sc.nextLine();
				
				System.out.print("Please enter password	> ");
				String password	= sc.nextLine();
				for(int	i=0;i<a.length;i++){	//Loop the array of admin
					if(name.trim().equals(a[i].userName)){	//If one of the admin's name match with the user input username
						validUser =	true;							//return true
						if(password.trim().equals(a[i].userPassword)){	//If the following admin's password match with the input password
							validPassword =	true;								//return true
							System.out.println("Login Successful !!");
							System.out.println("\n\nWelcome "+a[i].userName);
							break;												//break the loop
						}continue;
					}
				}
			}
			catch(InputMismatchException ex){			
				System.out.println("Invalid username, please try again");
				sc.nextLine();
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
	}
	
	public String toString(){
		return "\n--------------Admin Details--------------\nAdmin ID    : " + this.adminID + 
				"\nName        : " + userName +
			   "\nPassword    : " + "************" +
			   "\nEmail       : " + email +
			   "\nPhone Number: " + phNo +
			   "\nStart Date  : " + date.toDate();
	}
}