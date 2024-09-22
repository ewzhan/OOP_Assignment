import java.util.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;


public class TestUser {
	static	Scanner sc = new Scanner(System.in);
	//Guan Hong (Employee & Admin)
	static Admin admin = new Admin();
	static Employee employee= new Employee();
    static Admin[] a = new Admin[1];
    static Employee[] e = new Employee[30];
    static {
        a[0] = new Admin("Eu Wen Zhan", "Ewz@5555", "euzenzhan@gmail.com", "012-3456789", new MyDate(2, 4, 2019)); // Hardcoded admin detail
        e[0] = new Employee("Kennard Khoo", "Kkpt&6666", "kennardkhoo@gmail.com", "019-8765432", new MyDate(3, 5, 2019), 5000.00);//Hardcoded employee details
        e[1] = new Employee("Tan Wei Khye", "Twk!2222", "tanweikhye@gmail.com", "019-3627553", new MyDate(8, 12, 2020), 4000.00);
        e[2] = new Employee("Tan Guan Hong", "Tgh*9999", "tanguanhong@gmail.com", "011-3532652", new MyDate(6, 7, 2023), 3000.00);
    }
    
    //Kennard (Stock & Product)
    //UNIVERSAL VARIABLE-----------------------------------------------------------
	static int editSelect;
	
	//PRODUCT VARIABLE-------------------------------------------------------------
    static String productName;
	static String productDescription;
	static double productPrice;
    static Product[] products = new Product[100];
    static{
    	products[0] = new Product("Orange","This is orange",122.32);
    	products[1] = new Product("Apple","This is apple",122.32);
    	products[2] = new Product("Papaya","This is papaya",122.32);
    }
    static ProductList[] prodList = new ProductList[100];
    static{
    	prodList[0] = new ProductList(products[0],0);
    	prodList[1] = new ProductList(products[1],0);
    	prodList[2] = new ProductList(products[2], 100);
    	prodList[3] = new ProductList(products[1], 100);
    	prodList[4] = new ProductList(products[0], 100);
    }
    
	//STOCK VARIABLE
	static String location;
	static Stock[] stocks = new Stock[100];
	static{
		stocks[0] = new Stock("Kuala Lumpur",new ProductList[]{prodList[2],prodList[3],prodList[4]});
		stocks[1] = new Stock("Tanjung Bungah",new ProductList[]{prodList[0],prodList[1]});
	}
	static int sIndex;
	
	
	//BRANCH VARIABLE
	static Branches[] branch = new Branches[2];
    static {
		branch[0] = new Branches("BranchKL");
		branch[1] = new Branches("BranchPNG");
	}
	//SUPPLIER VARIABLE
	static Supplier[] suppliers = new Supplier[3];
    static {
    	suppliers[0] = new Supplier("Danial","010-7072804", products);
    	suppliers[1] = new Supplier("Ong Yi Zhe","011-19563943");
    	suppliers[2] = new Supplier("Wong Liang Han","012-4504660");
    }
    
    //ORDER AND DETAILS VARIABLE
    static OrderDetail[] orderDetails = new OrderDetail[2];
    static {
		orderDetails[0] = new OrderDetail(products[0],5);
		orderDetails[1] = new OrderDetail(products[1],7);
	}
    
    static Order[] orders = new Order[2]; // Assume you have an array of orders
    static {
		orders[0] = new Order(suppliers[2], new OrderDetail[]{orderDetails[0],orderDetails[1]},e[1]);
		orders[1] = new Order(branch[1], new OrderDetail[]{orderDetails[0],orderDetails[1]}, e[0]);
	}
	
	//COUNT VARIABLE
    static int orderCount = 0;
    static int supplierCount = 0;
    static int branchesCount = 0;
    static int detailCount = 0;
    
	
	
	//Admin & Employee function
	public static boolean confirm(){
		boolean condition = false;
		System.out.print("Confirm (C) ->");
		while(true){
			String confirm = sc.nextLine();
			if(confirm.trim().equals("C")){
				condition = true;
				break;
			}
			else if(confirm.trim().equals("c")){
				condition = true;
				break;
			}
			else{
				System.out.print("Please enter 'C' -> ");
				continue;
			}
		}return condition;
	}
	public static void inAdmin(){
		admin.login(a);	
		while(true){
			System.out.println(" ____________________________");
			System.out.println("|___________Admin____________|");
			System.out.println(" 0. Back");
			System.out.println(" 1.	Check Employee List (Display)");
			System.out.println(" 2.	Hire Employees  	(Create)");
			System.out.println(" 3.	Find Employees  	(Search)");
			System.out.println(" 4.	Modify Employees  	(Edit)");
			System.out.println(" 5.	Fire Employee   	(Delete)");
			try{
				System.out.print("\n Your choice ->");
				int adminChoice = sc.nextInt();
				System.out.println("");
				switch(adminChoice){
					case 0:
						login();
						break;
					case 1:
						admin.checkEmployeeList(e);
						break;
					case 2:
						createEmployee();
						break;
					case 3:
						admin.searchEmployee(e);
						break;
					case 4:
						admin.editEmployee(e);
						break;
					case 5:
						admin.deleteEmployee(e);
						break;
					default:
						System.out.println("Please enter a number in range 0-4");
				}
			}
			catch(InputMismatchException ex){
				System.out.println("Invalid choice, please enter a number between(0-4)");
				sc.nextLine();				
			}
			confirm();
		}
	}
	public static void createEmployee(){
		String name;
		String password;
		String email;
		String phone;
		double salary;
		boolean condition = false;
		int countEmp = 0;
		while(condition == false){
			System.out.println("Create Employee: ");
			for(Employee arr:e){
				if(arr!=null){	//Count the employee array
					countEmp++;
				}
			}
			sc.nextLine();	//clear input buffer
			while(true){
				System.out.print("Enter name ->");	//Employee Name
				name = sc.nextLine();
				if(employee.validName(name.trim())){
					break;
				}
			}
			while(true){
				System.out.print("Enter password ->");	//Employee Password
				password = sc.nextLine();
				if(employee.validPassword(password.trim())){
					break;
				}
			}
			while(true){
				System.out.print("Enter email (exp: abc@gmail.com)->");	//Employee email
				email = sc.nextLine();
				if(employee.validEmail(email.trim())){
					break;
				}
			}
			while(true){
				System.out.print("Enter phone number (exp: 012-3456789) ->");	//Employee phone number
				phone = sc.nextLine();
				if(employee.validPhoneNumber(phone.trim())){
					break;
				}
			}
			while(true){
				System.out.print("Salary ->");	//Employee salary
				try{
					salary = sc.nextDouble();
					if(salary < 10000){
						break;
					}
					else{
						System.out.println("Error, Salary exceeded RM10000");						
					}	
				}catch(InputMismatchException ex){
					System.out.println("Please enter numbers below 10000");
					sc.nextLine();
				}
			}
			e[countEmp] = new Employee(name,password,email,phone,new MyDate(),salary);
			System.out.println(e[countEmp].toString());
			System.out.println("\nEmployee created successfull !!\n");
			sc.nextLine();
			while(true){	
				System.out.print("Create another Employee ? (Y/N) ->");
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
	public static void inEmployee(){	
		Employee inEmp = employee.login(e);
		int employeeChoice = 0;
		while(true){
			System.out.println("\n\nWelcome !" + inEmp.getName());
			System.out.println(" _______________________________");
			System.out.println("|___________Employee____________|");
			System.out.println(" 0. Back");
			System.out.println(" 1. Show personal details	(Display)");
			System.out.println(" 2. Edit personal details	(Edit)");
			System.out.println(" 3. Manage Stock");
			System.out.println(" 4. Manage Product");
			System.out.println(" 5. Order Management");
			System.out.println(" 6. Supplier Management");
			System.out.println(" 7. Branch Management");
			System.out.print("\n Your choice ->");
			try{
				employeeChoice = sc.nextInt();
				switch(employeeChoice){
					case 0:
						login();
						break;
					case 1:
						System.out.println(inEmp.toString());
						break;
					case 2:
						inEmp.editDetail();
						break;
					case 3:
						stockMenu();
						break;
					case 4:
						productMenu();
						break;
						case 5:
						orderManagement(inEmp);
						break;
						case 6:
						showSupplier();
						break;
						case 7:
						showBranch();
						break;
					default:
						System.out.println("Please enter a number in range 0-1 -> ");
				}
			}
			catch(InputMismatchException ex){
				System.out.print("Invalid choice, please enter a number between(0-1) -> ");
				sc.nextLine();
			}
			confirm();
		}			
	}
	
	
	//Stock & Product (Kennard's part)
	
	//STOCK SECTION---------------------------------------------------------
	//Stock menu------------------------------------------------------------
	public static void stockMenu(){
		//select option
		boolean loop = true;
    	int ap, ep, cp, dp, ss1, ss2;
    	do{
    		System.out.println("Stock Menu");
	    	System.out.println("========================");
	    	System.out.println("1. Create Stock");
	    	System.out.println("2. Add Product");
	    	System.out.println("3. List Stock");
	    	System.out.println("4. Add Stock");
	    	System.out.println("5. Minus Stock");
			System.out.println("6. Return");
	    	System.out.println("Your s	election: ");
	    	int selection = sc.nextInt();
	    	sc.nextLine(); // Consume the newline character
	    	if (selection == 1){
	    		do{
	    			ap = createStock();
	    		}while (ap == 1);
	    	}
	    	else if (selection == 2){
	    		do{
	    			int choice = stockSelect();
	    			ep = setProduct2Stock(choice);
	    		}while (ep == 1);	
	    	}
	    	else if (selection == 3){
	    		listStock();
	    	}
            else if (selection == 4){
	    		do{
	    			ss1 = stockSelect();
	    			cp = addProduct2Stock(ss1);
	    		}while (cp == 1);	
	    	}
	    	else if (selection == 5){
	    		do{
	    			ss2 = stockSelect();
	    			dp = minusProduct2Stock(ss2);
	    		}while (dp == 1);
	    	}
			else if (selection == 6){
	    		loop = false;
	    	}
	    	else {
	    		System.out.println("Incorrect Input, try again.");
	    	}
    	}while(loop == true);
	}
	
	public static int createStock(){
		int choice, cms;
		System.out.println("Where is the location of the stocks?");
		location = sc.nextLine();
		
		sIndex = Stock.stockCount - 1;
		stocks[Stock.stockCount - 1] = new Stock(location, prodList);
		System.out.println("A new stock have been added");
		
		do{
			System.out.println("Do you want to add product?");
			System.out.println("1. Yes");
			System.out.println("2. No");
			choice = sc.nextInt();
			sc.nextLine();
			if(choice != 1 && choice != 2){
				System.out.println("Incorrect Input,try again");
			}
		}while(choice != 1 && choice != 2);
		
		if(choice == 1){
			setProduct2Stock(sIndex);
		}
		
		
		
		
		do{
			System.out.println("Do you want to create more stock?");
			System.out.println("1. Yes");
			System.out.println("2. No");
			cms = sc.nextInt();
			sc.nextLine();
			if(cms != 1 && cms != 2){
				System.out.println("Incorrect Input,try again");
			}
		}while(choice != 1 && choice != 2);
		
		return cms;
	}
	
	public static int stockSelect(){
		int choice;
		do{
			listStock();
			System.out.println("Select a Stock ID (ex. 0001");
			choice = sc.nextInt() - 1;
		}while(choice < 1 && choice > stocks.length);
		
		return choice;
	}
	
	public static int listStock(){
		int i = 0;
        System.out.println("Stocks List:");
        System.out.println("========================");
        for (i = 0; i < stocks.length; i++) {
        	if(stocks[i]!=null){
            	System.out.println(stocks[i].toString());	
        	}
        }
        
        System.out.println("========================");
		return i;
	}
	
	public static int setProduct2Stock(int sIn){
		int selection, add, addqty;
		do{
			do{
				listProduct();
				System.out.println("Select a product id to add (ex. 1)");
				selection = sc.nextInt() - 1; //index number for product to be add
			}while(selection < 0 || selection > products.length);
			
			do{
				System.out.println("Select how many qty to add");
				addqty = sc.nextInt(); //index number for product to be add
			}while(addqty < 0);
			
			
			stocks[sIn].setProductInPL(products[selection], addqty);
			
			
			
				
			System.out.println("Product added:");
			System.out.println("========================");
			System.out.println(stocks[sIn].toString());
			
			do{
				System.out.println("Do you want to add more product?");
				System.out.println("1. yes");
				System.out.println("2. no");
				add = sc.nextInt();
				sc.nextLine();
				if(add != 1 && add != 2){
					System.out.println("Incorrect Input,try again");
				}
			}while(add != 1 && add != 2);
		}while (add != 2);
		
		return add;
	}
	
	public static int addProduct2Stock(int sIn){
		int selection, add, addqty;
		do{
			do{
				listStock();
				System.out.println("Select a product id to add (ex. 1)");
				selection = sc.nextInt() - 1; //index number for product to be add
			}while(selection < 0 || selection > products.length);
			
			do{
				System.out.println("Select how many qty to add");
				addqty = sc.nextInt(); //index number for product to be add
			}while(addqty < 0);
			
			stocks[sIn].addProductInPL(products[selection], addqty);
			
			
			
			
			System.out.println("Product added:");
			System.out.println("========================");
			System.out.println(stocks[sIn].toString());
			
			do{
				System.out.println("Do you want to add more product?");
				System.out.println("1. yes");
				System.out.println("2. no");
				add = sc.nextInt();
				sc.nextLine();
				if(add != 1 && add != 2){
					System.out.println("Incorrect Input,try again");
				}
			}while(add != 1 && add != 2);
		}while (add != 2);
		
		return add;
	}

	public static int minusProduct2Stock(int sIn){
		int selection, minus, minusqty;
		do{
			do{
				listProduct();
				System.out.println("Select a product id to minus (ex. 1)");
				selection = sc.nextInt() - 1; //index number for product to be add
			}while(selection < 0 || selection > products.length);
			
			do{
				System.out.println("Select how many qty to minus");
				minusqty = sc.nextInt(); //index number for product to be add
			}while(minusqty < 0);
			
			stocks[sIn].setProductInPL(products[selection], (-minusqty));
			
			
			
			
			System.out.println("Product added:");
			System.out.println("========================");
			System.out.println(prodList[selection].toString());
			
			do{
				System.out.println("Do you want to add more product?");
				System.out.println("1. yes");
				System.out.println("2. no");
				minus = sc.nextInt();
				sc.nextLine();
				if(minus != 1 && minus != 2){
					System.out.println("Incorrect Input,try again");
				}
			}while(minus != 1 && minus != 2);
		}while (minus != 2);

		return minus;
	}

    //PRODUCT SECTION--------------------------------------------------------------
    //Product menu-----------------------------------------------------------------
    public static void productMenu(){
    	//select option------------------------------------------------------------
    	boolean loop = true;
    	int ap, ep, cp;
    	do{
    		System.out.println("Product Menu");
	    	System.out.println("========================");
	    	System.out.println("1. Add Product");
	    	System.out.println("2. Edit Product");
	    	System.out.println("3. List Product");
            System.out.println("4. Delete Product");
			System.out.println("5. Return");
	    	System.out.println("Your selection: ");
	    	int selection = sc.nextInt();
	    	sc.nextLine(); // Consume the newline character
	    	if (selection == 1){
	    		do{
	    			ap = addProduct();
	    		}while (ap == 1);
	    	}
	    	else if (selection == 2){
	    		do{
	    			ep = editProduct();
	    		}while (ep == 1);	
	    	}
	    	else if (selection == 3){
	    		listProduct();
	    	}
            else if (selection == 4){
	    		do{
	    			cp = deleteProduct();
	    		}while (cp == 1);	
	    	}
			else if (selection == 5){
	    		loop = false;
	    	}
	    	else {
	    		System.out.println("Incorrect Input, try again.");
	    	}
    	}while(loop == true);
    	
    	
    }

    public static int deleteProduct() {
        int editSelect, selection;
        int confirmation;
    
        do {
            int productCount = listProduct();  // This function should return the number of products available
            if (productCount == 0) {
                System.out.println("No products available, please add more products");
                return 0;
            }
    
            do {
                System.out.println("Select product to delete (enter product number, e.g., 0001):");
                editSelect = sc.nextInt();
                sc.nextLine();  // Consume the newline character
    
                if (editSelect < 1 || editSelect > productCount) {
                    System.out.println("Invalid selection, try again");
                }
            } while (editSelect < 1 || editSelect > productCount);
    
            System.out.println("Product Selected");
            System.out.println("========================");
            System.out.println(products[editSelect - 1].toString());  // Display selected product
    
            System.out.println("Are you sure you want to delete this item?");
            System.out.println("1. Yes");
            System.out.println("2. No");
            confirmation = sc.nextInt();
    
            if (confirmation == 1) {
                // Shift elements to the left to "delete" the product
                for (int i = editSelect - 1; i < productCount - 1; i++) {
                    products[i] = products[i + 1];
                }
                products[productCount - 1] = null;  // Nullify the last element 
    
                // Decrement the product count
                Product.productCount--;
    
                System.out.println("Product deleted successfully!");
            } else {
                System.out.println("Delete aborted, returning...");
                return 0;
            }
    
            System.out.println("Do you want to delete more products?");
            System.out.println("1. Yes");
            System.out.println("2. No");
            selection = sc.nextInt();
            sc.nextLine();  // Consume the newline character
    
            if (selection != 1 && selection != 2) {
                System.out.println("Invalid input, try again.");
            }
    
        } while (selection == 1);
    
        return 0;  // Return 1 if deletion process completes successfully
    }    
    
    //edit product-----------------------------------------------------------------
    public static int editProduct(){
    	int editSelect;
    	int eSelect;
		int i;
    	
    	do{
    		i = listProduct();
			if (i == 0){
				System.out.println("No products available, please add more products");
				return 0;
			}
	    	System.out.println("Select product to edit (ex. 0001)");
		    editSelect = sc.nextInt();
		    sc.nextLine(); // Consume the newline character
		    if(editSelect > Product.productCount - 1){
		    	System.out.println("Invalid selection, try again");
		    }
    	}while(editSelect > Product.productCount - 1 || editSelect < 1);
    	
    	System.out.println("Product Selected");
	    System.out.println("========================");
	    products[editSelect - 1].toString();

		int selection = 0;
	    do{
	    	System.out.println("Edit Selection");
		    System.out.println("========================");
		    System.out.println("1. Edit Name");
		    System.out.println("2. Edit Description");
		    System.out.println("3. Edit Price");
		    System.out.println("4. Return");
		    eSelect = sc.nextInt();
		    sc.nextLine(); // Consume the newline character
	    
		    if(eSelect == 1){
		    	productName = editProductName();
				products[editSelect - 1].setProductName(productName);
		    }
		    else if(eSelect == 2){
		    	productDescription = editProdDescription();
				products[editSelect - 1].setProductDescription(productDescription);
		    }
		    else if(eSelect == 3){
		    	productPrice = editProdPrice();
				products[editSelect - 1].setProductPrice(productPrice);
		    }
		    else if(eSelect == 4){
		    	break;
		    }
		    else{
		    	System.out.println("Invalid Selection. Try again.");
		    }

	    
			System.out.println("Edited Product:");
			System.out.println("========================");
			products[editSelect - 1].toString();
			
			//prompt enter more products---------------------------------------------


    		System.out.println("Do you want to edit more products?");
	    	System.out.println("1. Yes");
	    	System.out.println("2. No");
	    	selection = sc.nextInt();
		  	sc.nextLine(); // Consume the newline character
		  	if(selection != 1 && selection != 2){
    			System.out.println("Invalid input, try again.");
    		}
    	}while(selection != 1 && selection != 2);
    	
    	return selection;
    }
    
    //add product------------------------------------------------------------------
    public static int addProduct(){
    	System.out.println("Add Product");
    	System.out.println("========================");
    	
    	//product name-------------------------------------------------------------
    	productName = editProductName();
    	
    	//product description
    	productDescription = editProdDescription();
    	
    	//product price-------------------------------------------------------------
    	productPrice = editProdPrice();
    	
    	//display created product---------------------------------------------------
    	products[Product.productCount - 1] = new Product(productName, productDescription, productPrice);
    	
    	System.out.println("Entered Product:");
    	System.out.println("========================");
    	products[Product.productCount - 2].toString();
    	
    	//prompt enter more products---------------------------------------------
    	int selection;
    	do{
    		System.out.println("Do you want to enter more products?");
	    	System.out.println("1. Yes");
	    	System.out.println("2. No");
	    	selection = sc.nextInt();
		  	sc.nextLine(); // Consume the newline character
		  	if(selection != 1 && selection != 2){
    			System.out.println("Invalid input, try again.");
    		}
    	}while(selection != 1 && selection != 2);
    	
    	return selection;
    }
    
    //list all product
    public static int listProduct() {
		int i = 0;
        System.out.println("Product List:");
        System.out.println("========================");
        System.out.printf("%-12s | %-20s | %-12s | %-30s%n", 
                      "Product ID", "Product Name", "Product Price", "Product Description");

        for (i = 0; i < products.length; i++) {
        	if(products[i]!=null){
            	System.out.println(products[i].toString());	
        	}
        }
        
        System.out.println("========================");
		return i;
    }
    
    //prod name validation
    public static boolean nameCheck(String productName){
    	if (productName == null || productName.length() < 3 || productName.length() > 20) {
    		System.out.println("Product name must be between 3 and 20 characters.");
    		return true;
    	}
    	else {
    		return false;
    	}
    }
    
    //edit prod name
    public static String editProductName(){
    	boolean error = false;
    	do{
    		System.out.println("Enter product name: ");  
    		productName = sc.nextLine();
    		error = nameCheck(productName);
    		if (error == false){
    			break;
    		}
    	}while(error == true);
    	return productName;
    }
    
    //edit prod description
    public static String editProdDescription(){
    	System.out.println("Enter Product Description");
    	productDescription = sc.nextLine();
    	return productDescription;
    }
    
    //edit product price
    public static double editProdPrice(){
    	
    	boolean validPrice = false;
	    do {
	        System.out.println("Enter product Price (must be a number greater than 0): ");
	        try {
	            productPrice = sc.nextDouble();
	            sc.nextLine(); // Consume newline
	
	            if (productPrice > 0) {
	                validPrice = true;
	            } else {
	                System.out.println("Price must be greater than 0. Please try again.");
	            }
	        } catch (InputMismatchException e) {
	            System.out.println("Invalid input. Please enter a valid number.");
	            sc.nextLine(); // Clear invalid input
	        }
	    } while (!validPrice);
    	
    	return productPrice;
    }
	
	public static void login(){	//Login method
		int choice = 0;
		while(true){
			Scanner sc = new Scanner(System.in);
	        System.out.println("______________________________________");
	        System.out.println("Login to ?");
	        System.out.println("0: End program");
			System.out.println("1: Admin");
	        System.out.println("2: Employee");
	        System.out.print("Your choice -> ");
	        do{  //Loop if user enter any character
	            try {
	                choice = sc.nextInt();
	                switch (choice) {
	                    case 0:	//Exit if choose 0
	                        System.out.println("Bye Bye");
	                        System.exit(0);  
	                        break;
	                    case 1://Login Admin if choose 1
	                        inAdmin();
	                        break;
	                    case 2://Login Employee if choose 2
	                        inEmployee();
	                        break;
	                    default://Else will prompt error message and loop again
	                        System.out.print("Invalid choice. Please enter a number between 0-2 ->");
	                        break;
	                }
	            }
	            catch (InputMismatchException ex) {		//Catch the character input
	                System.out.print("Invalid input. Please enter a number ->");
	                sc.nextLine(); 
	            }
	        }while(choice < 1 || choice > 2);			
		}
	}
	
	
	//wenzhan part
	
    public static void showSupplier(){
    	int choice = -1;
    	while(true){
    	System.out.println("\nShow supplier details:");
    	System.out.println("1. Add supplier");
		System.out.println("2. Show all supplier details");
		System.out.println("3. Search supplier details by ID");
		System.out.println("4. Search supplier details by Name");
		System.out.println("5. Edit supplier details by ID");
		System.out.println("6. Delete supplier by ID");
		System.out.println("7. Return");
		
		do {
	      System.out.print("Enter your choice -> ");
	      try {
	          choice = sc.nextInt();
	          sc.nextLine();  // Consume newline
	          switch (choice) {
	          	case 1:
	          		sc.nextLine();
	          		createSupplier();
	          		break;
	          		
	            case 2:
	            	sc.nextLine();
	              	for (int i = 0; i < suppliers.length; i++) {
	              		if(suppliers[i] != null){
	              		System.out.println(suppliers[i]);
	              		}
	              	}
	                  break;
	              case 3:
	              	sc.nextLine();
				      System.out.print("\nEnter Supplier ID to show: ");
				      
				      String supplierID = sc.next();
				      
				      boolean found = false;
				      for(int i = 0; i < suppliers.length; i++){
						if(suppliers[i] != null && supplierID.trim().equals(suppliers[i].getSupplierID())){
						
						System.out.println(suppliers[i].toString());
						nextOptions(suppliers[i]);
						found = true;
						}
				      }
				      
				      if(!found){
				      	System.out.println("Supplier not found.");
				      }
	                  break;
	
	              case 4:
	              	sc.nextLine();
	                  System.out.print("\nEnter Supplier Name to show: ");
					  String supplierName = sc.nextLine().toLowerCase();
					
					  found = false;
					  for (int i = 0; i < suppliers.length; i++) {
				      if (suppliers[i].getSupplierName().toLowerCase().contains(supplierName)) {
				          System.out.println(suppliers[i]);
				          nextOptions(suppliers[i]);
				          found = true;
					      }
					  }
					
					  if (!found) {
					      System.out.println("No suppliers found with the name: " + supplierName);
					  }
	                  break;
	                  
	              case 5:
	              	sc.nextLine();
	                  System.out.printf("Enter supplier ID to edit > ");
	                  do{
				      supplierID = sc.next();
				      
				      found = false;
				      for(int i = 0; i < suppliers.length; i++){
						if(suppliers[i] != null && supplierID.trim().equals(suppliers[i].getSupplierID())){
						System.out.println(suppliers[i].toString());
						editSupplier(suppliers[i]);
						found = true;
						}
				      }
				      
				      if(!found){
				      	System.out.println("Supplier not found. Please enter again > ");
				      }
				      }while(!found);
	                  break;
	                  
	               case 6:
	               	sc.nextLine();
	               		System.out.printf("Enter supplier ID to Delete > ");
		                do{
					    supplierID = sc.next();
					    
					    found = false;
					    for(int i = 0; i < suppliers.length; i++){
						if(suppliers[i] != null && supplierID.trim().equals(suppliers[i].getSupplierID())){
						System.out.println(suppliers[i].toString());
						deleteSupplier(suppliers[i]);
						found = true;
						}
					    }
					     
					    if(!found){
					     	System.out.println("Supplier not found. Please enter again > ");
					    }
					    }while(!found);
	               		break;
	                  
	               case 7:
	               		return;
	
	              default:
	                  System.out.println("Invalid choice. Please choose again.");
	                  break;
	          }
	      } catch (InputMismatchException e) {
	          System.out.println("Invalid input. Please enter a number.");
	          sc.nextLine();
	      }
	  } while (choice != 7);
    	}

    }
    
    public static void nextOptions(Supplier supplier) {
	  int choice = -1;
	  do {
	      System.out.println("\nNext options for supplier: " + supplier.getSupplierName());
	      System.out.println("1. Edit supplier details");
	      System.out.println("2. Show orders with this supplier");
	      System.out.println("3. Delete this supplier");
	      System.out.println("4. Back to main menu");
	
	      System.out.print("Your choice -> ");
	      try {
	          choice = sc.nextInt();
	          sc.nextLine();  // Consume newline
	
	          switch (choice) {
	              case 1:
	                  editSupplier(supplier);
	                  break;
	
	              case 2:
	                  System.out.println("\nOrders made with supplier: " + supplier.getSupplierName());
					
					  boolean found = false;
					  for (int i = 0; i < orders.length; i++) {
					      if (orders[i]!= null && orders[i].getSupplier().equals(supplier)) {
					          System.out.println(orders[i]);
					          found = true;
					      }
					  }
					
					  if (!found) {
					      System.out.println("No orders found for this supplier.");
					  }
	                  break;
	                  
	              case 3:
	           			deleteSupplier(supplier);
	           			return;
	
	              case 4:
	                  System.out.println("Going back to the menu.");
	                  return;
	
	              default:
	                  System.out.println("Invalid choice. Please choose again.");
	                  break;
	          }
	      } catch (InputMismatchException e) {
	          System.out.println("Invalid input. Please enter a number.");
	          sc.nextLine();
	      }
	  } while (choice != 4);
	}
    
    public static void editSupplier(Supplier suppliers){
    	System.out.println("\nEditing Supplier: " + suppliers.getSupplierName());

	  	// Get new details with validation
	  	System.out.print("\nNew Supplier Name > ");
		String newSupplierName = sc.next();
		System.out.print("\nNew Supplier Contact > ");
		String newSupplierContact = sc.next();
		
		// Update supplier details
		suppliers.setSupplierName(newSupplierName);
		suppliers.setSupplierContact(newSupplierContact);

		System.out.println("Supplier details updated successfully.");
    }
    
    
    public static void deleteSupplier(Supplier supplier){
		System.out.println("Do you want to delete this supplier?(Y/N)");
		String YN = null;
		do{
		YN = sc.next();
		
		if(YN.trim().toUpperCase().equals("Y") == true){
			for(int i = 0; i < suppliers.length;i++){
			if (suppliers[i] != null && supplier.getSupplierID().equals(suppliers[i].getSupplierID())){
				// Shift elements to the left
                for (int j = i; j < suppliers.length - 1; j++) {
                    suppliers[j] = suppliers[j + 1];
                }
                // Set the last element to null
                suppliers[suppliers.length - 1] = null;
                System.out.println("Supplier deleted!");
                break;
			}
			}
		}else if(YN.trim().toUpperCase().equals("N") == true){
			System.out.println("Cancel Delete Supplier.");
			
		}else{
			System.out.println("Please only enter Y or N to take action >");
		}
		}while(YN.trim().toUpperCase().equals("Y")!= true && YN.trim().toUpperCase().equals("N")!=true)	;
    }
    



	public static void createSupplier(){
		String name;
		String contact;
		boolean condition = false;
		int countSupp = 0;
		while(condition == false){
			System.out.println("Create Supplier: ");
			for(Supplier arr:suppliers){
				if(arr!=null){
					countSupp++;
				}
			}
			while(true){
				System.out.print("Enter name ->");
				name = sc.nextLine();
				if(admin.validName(name.trim())){
					break;
				}
			}
			while(true){
				System.out.print("Enter Contact number (exp: 012-3456789) ->");
				contact = sc.nextLine();
				if(admin.validPhoneNumber(contact.trim())){
					break;
				}
			}
			suppliers[countSupp] = new Supplier(name,contact);
			System.out.println(suppliers[countSupp].toString());
			System.out.println("\nSupplier created successfull !!\n");
			sc.nextLine();
			while(true){	
				System.out.print("Create another Supplier ? (Y/N) ->");
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
	
	

	//branch menu
	public static void showBranch() {
        boolean exit = false;
        boolean found = false;

        while (!exit) {
            System.out.println("\n--- Branch Management Menu ---");
            System.out.println("1. Show All Branch");
            System.out.println("2. Create Branch");
            System.out.println("3. Edit Branch");
            System.out.println("4. Search Branch by ID");
            System.out.println("5. Delete Branch by ID");
            System.out.println("6. Exit to Main Menu");
            System.out.print("Choose an option (1-6): ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
            	case 1:
            		for (int i = 0; i < branch.length; i++) {
	              		if(branch[i] != null){
	              		System.out.println(branch[i]);
	              		}
	              	}
            		break;
                case 2:
                    createBranch();
                    break;
                case 3:
                    System.out.print("Enter Branch ID to Edit: ");
                    String editID = sc.nextLine();
                    Branches editBranch = searchBranchByID(editID);
                    if (editBranch != null) {
                        editBranch(editBranch);
                    } else {
                        System.out.println("Branch not found.");
                    }
                    break;
                case 4:
                    System.out.print("Enter Branch ID to Search: ");
                    String searchID = sc.nextLine();
                    Branches foundBranch = searchBranchByID(searchID);
                    if (foundBranch != null) {
                        System.out.println(foundBranch.toString());
                    } else {
                        System.out.println("Branch not found.");
                    }
                    break;
                case 5:
                	System.out.printf("Enter branch ID to edit > ");
                	
					    found = false;
		                do{
					    String branchID = sc.next();
					    
					    for(int i = 0; i < branch.length; i++){
						if(branch[i] != null && branchID.trim().equals(branch[i].getBranchesID())){
						System.out.println(branch[i].toString());
						deleteBranch(branch[i]);
						found = true;
						}
					    }
					     
					    if(!found){
					     	System.out.println("Supplier not found. Please enter again > ");
					    }
					    }while(!found);
                	break;
                case 6:
                    exit = true; // Exit the menu
                    System.out.println("Exiting Branch Management Menu...");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
                    break;
            }
        }
    }
    
    //delete branch
    public static void deleteBranch(Branches branchs){
		System.out.println("Do you want to delete this branch?(Y/N)");
		String YN = null;
		do{
		YN = sc.next();
		
		if(YN.trim().toUpperCase().equals("Y") == true){
			for(int i = 0; i < branch.length;i++){
			if (branch[i] != null && branchs.getBranchesID().equals(branch[i].getBranchesID())){
				// Shift elements to the left
                for (int j = i; j < branch.length - 1; j++) {
                    branch[j] = branch[j + 1];
                }
                // Set the last element to null after shifting
                branch[branch.length - 1] = null;
                System.out.println("Branch deleted!");
                break;
			}
			}
		}else if(YN.trim().toUpperCase().equals("N") == true){
			System.out.println("Cancel Delete Branch.");
			
		}else{
			System.out.println("Please only enter Y or N to take action >");
		}
		}while(YN.trim().toUpperCase().equals("Y")!= true && YN.trim().toUpperCase().equals("N")!=true)	;
    }

    // Create a new branch
    public static void createBranch() {
        boolean condition = false;
        int countBranch = branchesCount;

        System.out.println("Create Branch:");

        sc.nextLine(); // Clear input buffer
        String branchAddress = "";
        
        while (true) {
            System.out.print("Enter Branch Address (e.g., Ipoh) -> ");
            branchAddress = sc.nextLine();
            if (Validation.getStringInput(branchAddress.trim())) { // Assuming Validation is a custom method for input validation
                break;
            } else {
                System.out.println("Invalid input. Please try again.");
            }
        }

        branch[countBranch] = new Branches(branchAddress); // Create a new Branch object
        System.out.println(branch[countBranch].toString());
        branchesCount++;
        System.out.println("\nBranch created successfully!\n");

        while (true) {
            System.out.print("Create another Branch? (Y/N) -> ");
            String another = sc.nextLine();
            if (another.trim().equalsIgnoreCase("Y")) {
                condition = false;
                createBranch();
                break;
            } else if (another.trim().equalsIgnoreCase("N")) {
                condition = true;
                break;
            } else {
                System.out.println("Invalid input. Please enter Y or N.");
            }
        }
    }

    
    public static void editBranch(Branches branch) {
        System.out.println("Editing Branch: " + branch.getBranchAddress());
        System.out.print("Enter new Branch Address: ");
        String newBranchAddress = sc.nextLine();

        branch.setBranchAddress(newBranchAddress);
        System.out.println("Branch details updated successfully.");
    }

    public static Branches searchBranchByID(String branchesID) {
        for (int i = 0; i < branchesCount; i++) {
            if (branch[i] != null && branch[i].getBranchesID().equals(branchesID)) {
                return branch[i];
            }
        }
        return null;
    }

    
    public static class Validation {
        public static boolean getStringInput(String input) {
            return input != null && !input.trim().isEmpty();
        }
    }
	
	
	//weikhye part
	
	 public static void orderManagement(Employee inEmp) {
        int choice = -1;
        while (true) {
            System.out.println("\nOrder Management Menu:");
            System.out.println("1. Create Order");
            System.out.println("2. Show Orders");
            System.out.println("3. Search Order by Date");
            System.out.println("4. Return");

            do {
                System.out.print("Enter your choice -> ");
                try {
                    choice = sc.nextInt();
                    sc.nextLine();
                    switch (choice) {
                        case 1:
                            createOrderMenu(inEmp);
                            break;
                        case 2:
                            showOrderMenu();
                            break;
                        case 3:
                            searchOrderDatebyDate();
                            break;
                        case 4:
                            return;
                        default:
                            System.out.println("Invalid choice. Please choose again.");
                            break;
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input. Please enter a number.");
                    sc.nextLine();
                }
            } while (choice < 1 || choice > 4);
        }
    }

    public static void createOrderMenu(Employee inEmp) {
        int choice = -1;
        while (true) {
            System.out.println("1. Order from Supplier");
            System.out.println("2. Order from Branch");
            System.out.println("3. Return");

            do {
                System.out.print("Enter your choice -> ");
                try {
                    choice = sc.nextInt();
                    sc.nextLine();
                    switch (choice) {
                        case 1:
                       		System.out.print("\nEnter Supplier ID to show: ");
				      
					    	String supplierID = sc.next();
					    	
					    	boolean found = false;
						      for(int i = 0; i < suppliers.length; i++){
								if(suppliers[i] != null && supplierID.trim().equals(suppliers[i].getSupplierID())){
								Supplier oSupplier = suppliers[i];
								found = true;
								orderFromSupplier(oSupplier, inEmp);
								}
						      }
					      
					      if(!found){
					      	System.out.println("Supplier not found.");
					      }
                            
                            break;
                        case 2:
                        	System.out.print("Enter Branch ID to Create Order: ");
		                    String searchID = sc.nextLine();
		                    //compare ID, cannot be branch[0] ID
		                    Branches myBranch = searchBranchByID(searchID);
		                    if (myBranch != null) {
		                        System.out.println(myBranch.toString());
		                    } else {
		                        System.out.println("Branch not found.");
		                    }
                            orderFromBranch(myBranch, inEmp);
                            break;
                        case 3:
                            return;
                        default:
                            System.out.println("Invalid choice. Please choose again.");
                            break;
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input. Please enter a number.");
                    sc.nextLine();
                }
            } while (choice < 1 || choice > 3);
        }
    }

    public static void orderFromSupplier(Supplier oSupplier, Employee inEmp) {
    double subtotal = 0;
    boolean addMore = true;
    

    while (addMore) {
        System.out.println("Enter product ID to order:");
        int orderProductID = sc.nextInt();
        Product selectedProduct = null;

        // Find the product by ID
        for (Product p : products) {
            if (p.getProductID() == orderProductID) {
                selectedProduct = p;
                break;
            }
        }

        if (selectedProduct != null) {
            System.out.println("Enter quantity:");
            int quantity = sc.nextInt();
            sc.nextLine();

            OrderDetail detail = new OrderDetail(selectedProduct, quantity);

            if (detailCount >= orderDetails.length) {
                OrderDetail[] newOrderDetails = new OrderDetail[orderDetails.length * 2];
                for (int i = 0; i < orderDetails.length; i++) {
                    newOrderDetails[i] = orderDetails[i];
                }
                orderDetails = newOrderDetails;
            }

            orderDetails[detailCount++] = detail;
            subtotal += detail.getLineTotal();

            System.out.println("Add another product? (Y/N)");
            String response = sc.nextLine().trim().toUpperCase();
            addMore = response.equals("Y");
        } else {
            System.out.println("Product not found.");
        }
    }

    System.out.println("\nOrder Details:");
    for (int i = 0; i < detailCount; i++) {
        System.out.println(orderDetails[i]);
    }

    System.out.println("Would you like to create this order? (Y/N)");
    String confirmResponse = sc.nextLine().trim().toUpperCase();

    if (confirmResponse.equals("Y")) {
        OrderDetail[] finalOrderDetails = new OrderDetail[detailCount];
        for (int i = 0; i < detailCount; i++) {
            finalOrderDetails[i] = orderDetails[i];
        }
        orders[orderCount++] = new Order(oSupplier, finalOrderDetails, inEmp);
        System.out.println("Order created successfully!");
        System.out.println(orders[orderCount - 1]);
    } else {
        System.out.println("Order not created.");
    }
    }
    
    public static void orderFromBranch(Branches oBranch, Employee inEmp) {
    double subtotal = 0;
    boolean addMore = true;
    int newDetailCount = detailCount;

    while (addMore) {
        System.out.println("Enter product ID to order:");
        int orderProductID = sc.nextInt();
        sc.nextLine();
        Product selectedProduct = null;
        ProductList selectedProductList = null;
        int availableQuantity = 0;
        int quantity=0;
        

        Branches headQuater = branch[0];

        for(int i = 0; i<branch[0].getStock().getProductList().length ; i++){
        	if(branch[0].getStock().getProductList()[i].getProduct().getProductID() == orderProductID){
        		selectedProduct = branch[0].getStock().getProductList()[i].getProduct();
        		availableQuantity = branch[0].getStock().getProductList()[i].getQuantity();
        	}else{
        		continue;
        		}
        }
        
        if (selectedProduct != null) {
            System.out.println("Enter quantity:");
				try{
					quantity = sc.nextInt();
				}catch(InputMismatchException ex){
					System.out.println("Please enter Integer value!");
					sc.nextLine();
				}
            sc.nextLine(); 

            if (availableQuantity >= quantity) {
                OrderDetail detail = new OrderDetail(selectedProduct, quantity);

                if (detailCount >= orderDetails.length) {
                    OrderDetail[] newOrderDetails = new OrderDetail[orderDetails.length * 2];
                    for (int i = 0; i < orderDetails.length; i++) {
                        newOrderDetails[i] = orderDetails[i];
                    }
                    orderDetails = newOrderDetails;
                }

                orderDetails[detailCount++] = detail;
                subtotal += detail.getLineTotal();
                
                System.out.println("Add another product? (Y/N)");
                String response = sc.nextLine().trim().toUpperCase();
                addMore = response.equals("Y");
            } else {
                System.out.println("Not enough stock available. Current stock: " + availableQuantity);
            }
        } else {
            System.out.println("Product not found in the branch.");
        }
    }


    System.out.println("\nOrder Details:");
    for (int i = newDetailCount; i < detailCount; i++) {
        System.out.println(orderDetails[i]);
    }

    System.out.println("Would you like to create this order? (Y/N)");
    String confirmResponse = sc.nextLine().trim().toUpperCase();

    if (confirmResponse.equals("Y")) {
        if (orderCount >= orders.length) {
            Order[] newOrders = new Order[orders.length * 2];
            for (int i = 0; i < orders.length; i++) {
                newOrders[i] = orders[i];
            }
            orders = newOrders;
        }

        OrderDetail[] finalOrderDetails = new OrderDetail[detailCount];
        for (int i = 0; i < detailCount; i++) {
            finalOrderDetails[i] = orderDetails[i];
        }
        orders[orderCount++] = new Order(oBranch, finalOrderDetails, inEmp);
        System.out.println("Order created successfully!");
        System.out.println(orders[orderCount - 1]);
    } else {
        System.out.println("Order not created.");
    }
    }


    public static void showOrderMenu(){
    	int choice = -1;
    	do {
    	System.out.println("\n1. Show all order");
	   	System.out.println("\n2. Show approved order");
	   	System.out.println("\n3. Show rejected order");
	   	System.out.println("\n4. Show pending order");
		System.out.println("\n5. Back");
		
	      System.out.print("Enter your choice -> ");
	      try {
	          choice = sc.nextInt();
	          sc.nextLine();
	          switch (choice) {
	          	case 1:
	          		showAllOrder();
	          		break;
	            case 2:
	            	showApprovedOrder();
	                break;
	            case 3:
	            	showRejectedOrder();
	                break;
	            case 4:
	            	showPendingOrder();
	            	break;
	            case 5:
	            	return;
	              default:
	                  System.out.println("Invalid choice. Please choose again.");
	                  break;
	          }
	      } catch (InputMismatchException e) {
	          System.out.println("Invalid input. Please enter a number.");
	          sc.nextLine();
	      }
	  } while (choice != 5);
  	}

   
   public static void showAllOrder(){

   	  if(orders==null){
   	  	System.out.println("No orders available");
   	  	}
   	  else{
   	  	for(int i=0;i <orders.length;i++){
   	  		System.out.println(orders[i]);
   	  		}
   	  	}
   	  
   	}
   public static void showApprovedOrder(){
   	boolean found = false;
   	for(int i=0; i < orders.length;i++){
   		if(orders[i].getStatus().equals("Approved")){
   			System.out.println(orders[i]);
   			found= true;
   			}
   		}
   		if(!found){
   			System.out.println("No approved orders found!");
   			return;
   			}  	
}
   public static void showRejectedOrder(){
   		boolean found = false;
   	for(int i=0; i < orders.length;i++){
   		if(orders[i].getStatus().equals("Rejected")){
   			System.out.println(orders[i]);
   			}
   		}
   		if(!found){
   			System.out.println("No rejected orders found!");
   			}
   	}
   	
   public static void showPendingOrder(){
   		boolean found = false;
   	for(int i=0; i < orders.length;i++){
   		if(orders[i].getStatus().equals("Pending")){
   			System.out.println(orders[i]);
   			found = true;
   			}
   		}
   		if(!found){
   			System.out.println("No pending orders found!");
   			}
   			
   	//Ask the user to select an order by entering the order ID
   	System.out.println("Enter the order ID you want to approve or reject:");
    String selectedOrderID = sc.nextLine().trim();
    Order selectedOrder = null;

    // Find the selected order by ID
    for (int i = 0; i < orders.length; i++) {
        if (orders[i].getOrderID().equals(selectedOrderID) && orders[i].getStatus().equals("Pending")) {
            selectedOrder = orders[i];
            break;
        }
    }

    if (selectedOrder == null) {
        System.out.println("Invalid Order ID or no pending order found with that ID.");
        return;
    }
    
    //Show the selected order details
    System.out.println("Selected Order Details:");
    System.out.println(selectedOrder);//Order toString

    System.out.println("Do you want to approve or reject this order? (A/R):");
    String action = sc.nextLine().trim().toUpperCase();

    if (action.equals("A")) {
        if (selectedOrder.getSupplier() != null) {
            for (OrderDetail detail : selectedOrder.getOrderDetails()) {
            	
                Product product = detail.getProduct();
                int quantity = detail.getQuantity();
                
            for(int i = 0; i < branch[0].getStock().getProductList().length; i++){
            	if(branch[0].getStock().getProductList()[i]!=null && product.equals(branch[0].getStock().getProductList()[i].getProduct())){
            		branch[0].getStock().getProductList()[i].setQuantity(branch[0].getStock().getProductList()[i].getQuantity()+quantity);
            	}
            }
            }
            selectedOrder.setStatus("Approved");
            System.out.println("Order from supplier approved. Stock added to Branch 1");
            
            
        } else if (selectedOrder.getBranch() != null) {
		    Branches branchOrder = selectedOrder.getBranch();
		    for (OrderDetail detail : selectedOrder.getOrderDetails()) {
		        
		        Product product = detail.getProduct();
		        int quantity = detail.getQuantity();
		        
		        boolean productFoundInHQ = false;
		        for (int i = 0; i < branch[0].getStock().getProductList().length; i++) {
		            if (branch[0].getStock().getProductList()[i]!= null && product.equals(branch[0].getStock().getProductList()[i].getProduct())) {
		                productFoundInHQ = true;
		                branch[0].getStock().getProductList()[i].setQuantity(
		                    branch[0].getStock().getProductList()[i].getQuantity() - quantity
		                );
		                boolean productFoundInBranch = false;
		                for (int j = 0; j < branchOrder.getStock().getProductList().length; j++) {
		                    if (product.equals(branchOrder.getStock().getProductList()[j].getProduct())) {
		                        branchOrder.getStock().getProductList()[j].setQuantity(
		                            branchOrder.getStock().getProductList()[j].getQuantity() + quantity
		                        );
		                        productFoundInBranch = true;
		                        break;
		                    }
		                }
		
		                if (!productFoundInBranch) {
		                    ProductList[] currentStock = branchOrder.getStock().getProductList();
		                    ProductList[] newStock = new ProductList[currentStock.length + 1];
		                    
		                    System.arraycopy(currentStock, 0, newStock, 0, currentStock.length);
		                    
		                    branchOrder.getStock().setProductInPL(product, quantity);
		                }
		                break;
		            }
		        }
		
		        if (!productFoundInHQ) {
		            System.out.println("Product not found in headquarters stock!");
		        }
		    }
		
		    selectedOrder.setStatus("Approved");
		    System.out.println("Branch order approved. Stock transferred.");
		}

    } else if (action.equals("R")) {
        //Reject the order
        selectedOrder.setStatus("Rejected");
        System.out.println("Order has been rejected.");
    } else {
        System.out.println("Returning to the order menu.");
   }	
  }
   	
   public static void searchOrderDatebyDate(){
   	SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
   	Date startDate = null;
    Date endDate = null;
    
    //Input for start date
   	System.out.println("Please enter start date(dd-MM-yyyy)");
   	 try{
   	 	startDate = sdf.parse(sc.nextLine());
   	 	}catch (ParseException e) {
            System.out.println("Invalid start date format.");
            return;
        }
        
    //Input for end date
   	System.out.println("Please enter end date(dd-MM-yyyy)");
   	 try{
   	 	endDate = sdf.parse(sc.nextLine());
   	 	}catch (ParseException e) {
            System.out.println("Invalid end date format.");
            return;
        }
        
        if(startDate.after(endDate)){
        	System.out.println("Start date cannot be after the end date! Please try again.");
        	return;
        	}
        
     boolean found = false;
     
     // Search for orders within the specified date range
        for (int i = 0; i < orders.length; i++) {
            Date orderDate = orders[i].getOrderDate();
            if(orderDate == null && !orderDate.before(startDate) && !orderDate.after(endDate) ) {
                System.out.println(orders[i]);  // Display the order details
                found = true;
            }
        }

        if (!found) {
            System.out.println("No orders found in the specified date range.");
        }
    }
   	
	
	//Main Program run here
	
	
	
    public static void main(String[] args) {
        while(true){
        	System.out.println("\n	!! Welcome to Food Inventory System !!\n");
        	login();	//Login method
        }
    }
}
