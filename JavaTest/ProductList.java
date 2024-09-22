public class ProductList{
	
	private Product product;
	private int quantity; 
	
	public ProductList(){
		this(new Product(),0);
	}
	public ProductList(Product product,int quantity){
		this.product = product;
		this.quantity = quantity;
	}
	
	public void setProduct(Product product){
		this.product = product;
	}
	
	public Product getProduct(){
		return product;
	}
	
	public void setQuantity(int quantity){
		this.quantity = quantity;
	}
	
	public void addQuantity(int quantity){
		this.quantity += quantity;
	}
	
	public void minusQuantity(int quantity){
		this.quantity -= quantity;
	}
	
	public int getQuantity(){
		return quantity;
	}
	
public String toString() {
    return String.format("%-12s | %-12d", product.toString(), quantity);
}

}