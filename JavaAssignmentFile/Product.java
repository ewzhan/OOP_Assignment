

public class Product {
	
	//variable declaration
	private int productID;
	private String productName;
	private int productQty;
	private String productDescription;
	private double productPrice;
	public static int productCount = 1;
	//-------------------------------------------------------------
	
	//constructors
    public Product() {
    	productID = productCount;
    	productName = "";
    	productDescription = "";
    	productPrice = 0;
    	productCount++;
    }
    
    public Product(String productName, int productQty, String productDescription, 
    	double productPrice){
    	productID = productCount;
    	this.productName = productName;
    	this.productQty = productQty;
    	this.productDescription = productDescription;
    	this.productPrice = productPrice;
    	productCount++;
    }
    //-------------------------------------------------------------
    
    //functions
    //setters & getters
    public void setProductName(String productName){
    	this.productName = productName;
    }
    
    public String getProductName(){
    	return productName;
    }
    //-------------------------------------------------------------
    public void setProductQty(int productQty){
    	this.productQty = productQty;
    }
    
    public int getProductQty(){
    	return productQty;
    }
    
    //-------------------------------------------------------------
    public void setProductDescription(String productDescription){
    	this.productDescription = productDescription;
    }
    
    public String getProductDescription(){
    	return productDescription;
    }
    //-------------------------------------------------------------
    public void setProductPrice(double productPrice){
    	this.productPrice = productPrice;
    }
    
    public double getProductPrice(){
    	return productPrice;
    }
    //-------------------------------------------------------------
    
    //add/minus productQty
    public void addProductQty(int add){
    	productQty += add;
    }
    
    public void minusProductQty(int minus){
    	productQty -= minus;
    }
    //-------------------------------------------------------------
    
    //Product to string
    public void toStringProd() {
	    System.out.printf("Product ID: PROD%04d\n", productID);
	    System.out.println("Product Name: " + productName);
	    System.out.println("Product Quantity: " + productQty);
	    System.out.println("Product Description: " + productDescription);
	    System.out.printf("Product Price: %.2f\n", productPrice);
	}
}
