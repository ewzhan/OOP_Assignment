import java.util.*;

public class TestMain {
	
	static Scanner sc = new Scanner(System.in);
	
    static String productName;
	static int productQty;
	static String productDescription;
	static double productPrice;
    static Product[] products = new Product[100];
    
    
    public static void main(String[] args) {
        //addProduct(), listProduct()
        
    }
    
    //Product menu-----------------------------------------------------------------
    public static void productMenu(){
    	//select option------------------------------------------------------------
    	boolean mError = false;
    	int ap, ep;
    	do{
    		System.out.println("Product Menu");
	    	System.out.println("========================");
	    	System.out.println("1. Add Product");
	    	System.out.println("2. Edit Product");
	    	System.out.println("3. Return");
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
	    		break;
	    	}
	    	else {
	    		System.out.println("Incorrect Input, try again.");
	    		mError = true;
	    	}
    	}while(mError == true);
    	
    	
    }
    
    //edit product-----------------------------------------------------------------
    public static int editProduct(){
    	int editSelect;
    	int eSelect;
    	
    	do{
    		listProduct();
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
		    }
		    else if(eSelect == 2){
		    	productQty = editProductQty();
		    }
		    else if(eSelect == 3){
		    	productDescription = editProdDescription();
		    }
		    else if(eSelect == 4){
		    	productPrice = editProdPrice();
		    }
		    else if(eSelect == 5){
		    	break;
		    }
		    else{
		    	System.out.println("Invalid Selection. Try again.");
		    }
	    }while(eSelect < 1 || eSelect > 5);
	    
	    products[editSelect - 1] = new Product(productName, productQty, productDescription, productPrice);
	    
	    System.out.println("Edited Product:");
    	System.out.println("========================");
    	products[editSelect - 1].toStringProd();
    	
    	//prompt enter more products---------------------------------------------
    	int selection;
    	do{
    		System.out.println("Do you want to edit more products?");
	    	System.out.println("1. Yes");
	    	System.out.println("2. No");
	    	selection = sc.nextInt();
		  	sc.nextLine(); // Consume the newline character
		  	if(selection != 1 || selection != 0){
    			System.out.println("Invalid input, try again.");
    		}
    	}while(selection != 1 || selection != 0);
    	
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
		  	if(selection != 1 || selection != 0){
    			System.out.println("Invalid input, try again.");
    		}
    	}while(selection != 1 || selection != 0);
    	
    	return selection;
    }
    
    //list all product
    public static void listProduct() {
        System.out.println("Product List:");
        System.out.println("========================");
        for (int i = 0; i < Product.productCount - 1; i++) {
            products[i].toStringProd();
            System.out.println("========================");
        }
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
