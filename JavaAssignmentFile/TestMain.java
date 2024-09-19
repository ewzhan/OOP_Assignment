import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class TestMain {
	
	static Scanner sc = new Scanner(System.in);
	
	//UNIVERSAL VARIABLE-----------------------------------------------------------
	static int editSelect;

	//PRODUCT VARIABLE-------------------------------------------------------------
    static String productName;
	static int productQty;
	static String productDescription;
	static double productPrice;
    static Product[] products = new Product[100];
	
	//INV CTRL VARIABLE------------------------------------------------------------
	static int quantity;
	static int stockLeft;
	static String moveType;
	static String reference;
	static String date;
	static StockControl[] stockCtrl = new StockControl[100];

	//MAIN-----------------------------------------------------------------------------
    public static void main(String[] args) {
        //addProduct(), listProduct()
		productMenu();
        invCtrlMenu();
    }
    
    //STOCK CONTROL SECTION--------------------------------------------------------
    public static void invCtrlMenu(){
		//select option------------------------------------------------------------
    	boolean loop = true;
    	int nic, eic;

		do{
			System.out.println("Inventory Control Menu");
			System.out.println("========================");
			System.out.println("1. New Inventory Control");
			System.out.println("2. Edit Inventory Control");
			System.out.println("3. List Inventory Control");
			System.out.println("4. Return");
			System.out.println("Your selection: ");
			int selection = sc.nextInt();
			sc.nextLine();
			if (selection == 1){
				do{
					nic = newInvCtrl();
				}while (nic == 1);
			}
			else if (selection == 2){
				do{
					eic = editInvCtrl();
				}while (eic == 1);	
			}
			else if (selection == 3){
				listInvCtrl();
			}
			else if (selection == 4){
				loop = false;
			}
			else {
				System.out.println("Incorrect Input, try again.");
			}
		}while (loop == true);
    }

	public static int editInvCtrl(){
		int editSelect;
    	int eSelect;
		int i;
    	
    	do{
    		i = listInvCtrl();
			if (i == 0){
				System.out.println("No Movement available, please add more Control Movement");
				return 0;
			}
	    	System.out.println("Select product to edit (ex. 0001)");
		    editSelect = sc.nextInt();
		    sc.nextLine(); // Consume the newline character
		    if(editSelect > StockControl.scCount - 1){
		    	System.out.println("Invalid selection, try again");
		    }
    	}while(editSelect > StockControl.scCount - 1);

		System.out.println("Stock Control Selected");
	    System.out.println("========================");
	    stockCtrl[editSelect - 1].toStringInvCtrl();

		int selection = 0;
	    do{
	    	System.out.println("Edit Selection");
		    System.out.println("========================");
		    System.out.println("1. Edit Quantity Transfered");
		    System.out.println("2. Edit Move Type");
		    System.out.println("3. Edit Reference");
		    System.out.println("4. Return");
		    eSelect = sc.nextInt();
		    sc.nextLine(); // Consume the newline character
	    
		    if(eSelect == 1){
				stockCtrl[editSelect - 1].setQuantity(-quantity);
		    	quantity = editInvCtrlQty();
				stockCtrl[editSelect - 1].setQuantity(quantity);
		    }
		    else if(eSelect == 2){
		    	moveType = editInvCtrlMType();
				stockCtrl[editSelect - 1].setMoveType(moveType);
		    }
		    else if(eSelect == 3){
		    	reference = editProdDescription();
				stockCtrl[editSelect - 1].setRef(reference);
		    }
		    else if(eSelect == 4){
		    	break;
		    }
		    else{
		    	System.out.println("Invalid Selection. Try again.");
		    }

			System.out.println("Edited Inventory Control:");
			System.out.println("========================");
			stockCtrl[StockControl.productCount - 2].toStringProd();

			//prompt edit more stock control---------------------------------------------


    		System.out.println("Do you want to edit more stock control?");
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
    public static int listInvCtrl() {
		int i = 0;
        System.out.println("Inventory Movement List:");
        System.out.println("========================");
        for (i = 0; i < StockControl.scCount - 1; i++) {
            products[i].toStringProd();
            System.out.println("========================");
        }
		return i;
    }

	public static int newInvCtrl(){
		System.out.println("Add New Inventory");
    	System.out.println("========================");
		
		int i;
		boolean available = false;
    	
    	do {
			// List the available products
			i = listProduct();
			if (i == 0) {
				System.out.println("No products available, please add more products.");
				return 0; 
			}
			
			System.out.println("Select product to adjust (ex. 1 for first product): ");
			try {
				editSelect = sc.nextInt(); 
				sc.nextLine(); 
		
				// Check if the selected product is valid
				if (editSelect < 1 || editSelect > Product.productCount) {
					System.out.println("Invalid selection, try again.");
				} 
				else if (products[editSelect - 1].getProductQty() == 0) {
					System.out.println("Error. Insufficient Product Quantity.");
					return 0; // Exit if selected product has no stock
				} 
				else {
					available = true; // Valid selection and available stock
				}
			} catch (InputMismatchException e) {
				System.out.println("Invalid input. Please enter a valid product number.");
				sc.nextLine(); // Clear invalid input
			}
		} while (!available);
    	
    	System.out.println("Product Selected");
	    System.out.println("========================");
	    products[editSelect - 1].toStringProd();

		//inv ctrl moveType
		moveType = editInvCtrlMType();

		//inv ctrl quantity
		quantity = editInvCtrlQty();

		//inv ctrl stockLeft
		stockLeft = editStockLeft();

		//inv ctrl reference
		reference = editInvCtrlRef();

		//inv ctrl date
		date = editInvCtrlDate();

		//display created invctrl
		stockCtrl[StockControl.productCount - 1] = new StockControl(quantity, stockLeft, moveType, reference, date, products[editSelect - 1]);

		System.out.println("Entered Inventory Control:");
    	System.out.println("========================");
    	stockCtrl[StockControl.productCount - 2].toStringInvCtrl();

		int selection;
    	do{
    		System.out.println("Do you want to enter more movement control?");
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

	public static String editInvCtrlDate(){
		// Create a LocalDate object for today's date
        LocalDate today = LocalDate.now();
        
        // Define the desired date format
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        
        // Format the LocalDate object as a string
        date = today.format(formatter);

		return date;
	}
    
	//edit invctrl reference
	public static String editInvCtrlRef(){
		System.out.println("Enter Movement Reference (if any)");
		reference = sc.nextLine();
		return reference;
	}

	//edit invctrl stockLeft
	public static int editStockLeft(){
		if (moveType.equals("Add Stock")){		//if add, add more(or minus)
    		stockLeft = products[editSelect - 1].addProductQty(quantity);
			return stockLeft;
    	}
		else{
			stockLeft = products[editSelect - 1].minusProductQty(quantity);
			return stockLeft;
		}
	}

	//edit invctrl moveType
	public static String editInvCtrlMType(){
		int selection;
    	do{
    		System.out.println("Which Movement Type?");
	    	System.out.println("1. Add Stock");
	    	System.out.println("2. Deduct Stock");
	    	selection = sc.nextInt();
		  	sc.nextLine(); // Consume the newline character
		  	if(selection != 1 && selection != 2){
    			System.out.println("Invalid input, try again.");
    		}
    	}while(selection != 1 && selection != 2);
    	
		if (selection == 1){
			moveType = "Add Stock";
		}
		else {
			moveType = "Deduct Stock";
		}

    	return moveType;
	}

    //edit invctrl quantity
	public static int editInvCtrlQty(){
    	boolean validQty = false;
		if(moveType == "Add Stock"){
			do {
				System.out.println("Enter movement Qty (must be an integer greater than 0): ");
				try {
					quantity = sc.nextInt();
					sc.nextLine(); // Consume the newline character
		
					if (quantity > 0 ) {
						validQty = true; // Valid quantity entered
					} else{
						System.out.println("Quantity must be greater than 0. Please try again.");
					} 
				} catch (InputMismatchException e) {
					System.out.println("Invalid input. Please enter a valid integer.");
					sc.nextLine(); // Clear the invalid input from the scanner
				}
			} while (!validQty);
		}
		else{
			do {
				System.out.println("Enter movement Qty (must be an integer greater than 0): ");
				try {
					quantity = sc.nextInt();
					sc.nextLine(); // Consume the newline character
		
					if (quantity > 0 && quantity <= products[editSelect - 1].getProductQty()) {
						validQty = true; // Valid quantity entered
					} else if (quantity < 0){
						System.out.println("Quantity must be greater than 0. Please try again.");
					} else{
						System.out.println("Error, such product does not have that much stock.");
					}
				} catch (InputMismatchException e) {
					System.out.println("Invalid input. Please enter a valid integer.");
					sc.nextLine(); // Clear the invalid input from the scanner
				}
			} while (!validQty);
		}
	    
	    return quantity;
    }

    //PRODUCT SECTION--------------------------------------------------------------
    //Product menu-----------------------------------------------------------------
    public static void productMenu(){
    	//select option------------------------------------------------------------
    	boolean loop = true;
    	int ap, ep;
    	do{
    		System.out.println("Product Menu");
	    	System.out.println("========================");
	    	System.out.println("1. Add Product");
	    	System.out.println("2. Edit Product");
	    	System.out.println("3. List Product");
			System.out.println("4. Return");
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
	    		loop = false;
	    	}
	    	else {
	    		System.out.println("Incorrect Input, try again.");
	    	}
    	}while(loop == true);
    	
    	
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
    	}while(editSelect > Product.productCount - 1);
    	
    	System.out.println("Product Selected");
	    System.out.println("========================");
	    products[editSelect - 1].toStringProd();

		int selection = 0;
	    do{
	    	System.out.println("Edit Selection");
		    System.out.println("========================");
		    System.out.println("1. Edit Name");
		    System.out.println("2. Edit Quantity");
		    System.out.println("3. Edit Description");
		    System.out.println("4. Edit Price");
		    System.out.println("5. Return");
		    eSelect = sc.nextInt();
		    sc.nextLine(); // Consume the newline character
	    
		    if(eSelect == 1){
		    	productName = editProductName();
				products[editSelect - 1].setProductName(productName);
		    }
		    else if(eSelect == 2){
		    	productQty = editProductQty();
				products[editSelect - 1].setProductQty(productQty);
		    }
		    else if(eSelect == 3){
		    	productDescription = editProdDescription();
				products[editSelect - 1].setProductDescription(productDescription);
		    }
		    else if(eSelect == 4){
		    	productPrice = editProdPrice();
				products[editSelect - 1].setProductPrice(productPrice);
		    }
		    else if(eSelect == 5){
		    	break;
		    }
		    else{
		    	System.out.println("Invalid Selection. Try again.");
		    }

	    
			System.out.println("Edited Product:");
			System.out.println("========================");
			products[editSelect - 1].toStringProd();
			
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
    	
    	//product quantity---------------------------------------------------------
    	productQty = editProductQty();
    	
    	//product description
    	productDescription = editProdDescription();
    	
    	//product price-------------------------------------------------------------
    	productPrice = editProdPrice();
    	
    	//display created product---------------------------------------------------
    	products[Product.productCount - 1] = new Product(productName, productQty, productDescription, productPrice);
    	
    	System.out.println("Entered Product:");
    	System.out.println("========================");
    	products[Product.productCount - 2].toStringProd();
    	
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
        for (i = 0; i < Product.productCount - 1; i++) {
            products[i].toStringProd();
            System.out.println("========================");
        }
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
    		System.out.println("Enter product name: ");  //can add auto kick after 3 attempts
    		productName = sc.nextLine();
    		error = nameCheck(productName);
    		if (error == false){
    			break;
    		}
    	}while(error == true);
    	return productName;
    }
    
    //edit prod quantity
    public static int editProductQty(){
    	boolean validQty = false;
	    do {
	        System.out.println("Enter product Qty (must be an integer greater than 0): ");
	        try {
	            productQty = sc.nextInt();
	            sc.nextLine(); // Consume the newline character
	
	            if (productQty > 0) {
	                validQty = true; // Valid quantity entered
	            } else {
	                System.out.println("Quantity must be greater than 0. Please try again.");
	            }
	        } catch (InputMismatchException e) {
	            System.out.println("Invalid input. Please enter a valid integer.");
	            sc.nextLine(); // Clear the invalid input from the scanner
	        }
	    } while (!validQty);
	    return productQty;
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
