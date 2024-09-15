public class Supplier {
	private int supplierID;
	private String supplierName;
	private String supplierAddress;
	private String supplierContact;
	private Product productSupply;
	private static int supplierCount = 1;

    public Supplier(String supplierName, String supplierAddress, String supplierContact, Product productSupply) {
    	this.supplierID = supplierCount++;
    	this.supplierName = supplierName;
    	this.supplierAddress = supplierAddress;
    	this.supplierContact = supplierContact;
    	this.productSupply = productSupply;
    }
    
    public Supplier(){
    	this("","","",null);
    }
    
    public void supplyProduct(Product productSupply, int quantity, Stock stock) {
        stock.receiveStock(product, quantity);
    }
    
     public void stockInProduct() {
        Scanner scanner = new Scanner(System.in);

        /**System.out.println("Available products: "); //list all product from product list
        for (int i = 0; i < productList.size(); i++) {
            System.out.println(i + 1 + ". " + productList.get(i).getName());
        }**/

        System.out.print("Select a product to stock in (enter number): ");
        int productIndex = scanner.nextInt() - 1;

        if (productIndex >= 0 && productIndex < productList.size()) {
            Product selectedProduct = productList.get(productIndex);
            System.out.print("Enter quantity to stock in: ");
            int quantity = scanner.nextInt();
            
            Stock stock = findStockByProduct(selectedProduct);
            if (stock != null) {
                stock.increaseStock(quantity);
            } else {
                stockList.add(new Stock(selectedProduct, quantity));
            }
            System.out.println("StockIn: Added " + quantity + " units of " + selectedProduct.getName());
        } else {
            System.out.println("Invalid product selection.");
        }
    }
    
     public String toString() {
        return "Supplier ID: " + supplierID + "\nSupplier Name: " + supplierName + "\nSupplier Address: " + supplierAddress + "\nSupplier Contact: " + supplierContact;
    }
    
}