
public class Product {
	
	//variable declaration
	private int productID;
	private String productName;
	private String productDescription;
	private double productPrice;
	public static int productCount = 1;
	//-------------------------------------------------------------
	
	//constructors
    public Product() {
    	this("","",0.00);
    }
    
    public Product(String productName, String productDescription,double productPrice){
    	productID = productCount;
    	this.productName = productName;
    	this.productDescription = productDescription;
    	this.productPrice = productPrice;
    	productCount++;
    }
    //-------------------------------------------------------------
    
    //functions
    //setters & getters
    public void setProductID(int productID){
    	this.productID = productID;
    }
    
    public int getProductID(){
    	return this.productID;
    }
    
    public int getProductCount(){
    	return productCount;
    }
    public void setProductName(String productName){
    	this.productName = productName;
    }
    
    public String getProductName(){
    	return productName;
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
    
    //Product to string
public String toString() {
    return String.format("%-12d | %-20s | $%-11.2f | %-30s", 
                         productID, productName, productPrice, productDescription);
}



}