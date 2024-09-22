import java.util.*;

public class Supplier {
	private String supplierID;
	private String supplierName;
	private String supplierContact;
	private Product[] productSupply;
	private int productCount = 0;
	private static int supplierCount = 1;
    
    public Supplier(String supplierName, String supplierContact) {
    	this.supplierID =  String.format("S%04d",supplierCount);
    	this.supplierName = supplierName;
    	this.supplierContact = supplierContact;
    	this.productSupply = null;
    	supplierCount++;
    }
    
    public Supplier(String supplierName, String supplierContact, Product[] productSupply) {
    	this.supplierID =  String.format("S%04d",supplierCount);
    	this.supplierName = supplierName;
    	this.supplierContact = supplierContact;
    	this.productSupply = productSupply;
    	supplierCount++;
    }
    
    
    public Supplier(){
    	this("","");
    }
    
     public String getSupplierID() {
        return supplierID;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public String getSupplierContact() {
        return supplierContact;
    }

    public void setSupplierContact(String supplierContact) {
        this.supplierContact = supplierContact;
    }
    
    public void addProduct(Product product) {
    	productSupply[productCount] = product;
    	productCount++;
    }

    public Product[] getSupplyProducts() {
        return productSupply;
    }
    
   	public String toString() {
     	String report = String.format("%-15s : %s\n", "Supplier ID", supplierID) +
                    String.format("%-15s : %s\n", "Supplier Name", supplierName) +
                    String.format("%-15s : %s\n", "Supplier Contact", supplierContact) +
                    "Products Supplied:\n" +
                    String.format("%-12s | %-20s | %-11s | %-30s\n", 
                                  "Product ID", "Product Name", "Price", "Description"); 
    if (productSupply != null && productSupply.length > 0) {
            for (Product product : productSupply) {
            	if(product!= null){
            	
                report += product.toString() + "\n";  // Concatenating product details
            }
            }
        } else {
            report += "No products supplied.\n";
        }
    return report;  // Returning the final string
   	}
    
}

