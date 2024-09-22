public class OrderDetail {
    private Product product;
    private int quantity;
    private double lineTotal;

    // Constructor
    public OrderDetail(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
        this.lineTotal = product.getProductPrice() * quantity; // Calculate line total
    }
    
    public OrderDetail(){
    	this(null,0);
    }

    // Getters
    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getLineTotal() {
        return lineTotal;
    }

    // toString method for displaying order details
    public String toString() {
    	return String.format("%-10s : %-20s\n", "Product", product.getProductName()) +
        	   String.format("%-10s : %-5d\n", "Quantity", quantity) +
           	String.format("%-10s : $%-10.2f", "Line Total", lineTotal);
	}

}