import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Main {
	
	static Scanner sc = new Scanner(System.in);
	
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
    }
    
	//STOCK VARIABLE
	static String location;
	static Stock[] stocks = new Stock[100];
	static{
		stocks[0] = new Stock("djgbd",new ProductList[]{prodList[1],prodList[0]});
	}
	static int sIndex;
	

	//MAIN-----------------------------------------------------------------------------
    public static void main(String[] args) {
		//productMenu();
		stockMenu();
    }

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
    
        return 1;  // Return 1 if deletion process completes successfully
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
    
    
    
}
