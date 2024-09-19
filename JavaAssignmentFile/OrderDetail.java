
public class OrderDetail{
private Product product;

    //Parameterized Constructor
    public OrderDetail(Product product) {
    	if (product == null) {
            throw new IllegalArgumentException("Product cannot be null.");  //If product is not available
        }
        this.product = product;       
    }
    
//Calculate cost of the product in the order   
 public double calculateCost() {
 	if (product.getProductQty() <= 0) {
            throw new IllegalStateException("Product quantity must be greater than zero."); //If quantity is zero
        }
        
 	return product.getProductPrice() * product.getProductQty();  //ProductPrice x ProductQuantity and return
 	}
     
 //getter 
 public Product getProduct(){
 	return product;
 	}    
        
}