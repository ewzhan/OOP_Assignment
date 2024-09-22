

public class Stock {
    private int stockID;  
    private String location;
    private ProductList[] prodList = new ProductList[100];
    public int productCount = 1;
    public static int stockCount = 1;
    
    public Stock() {
    	this("",new ProductList[100]);
    }
    
    public Stock(String location){
    	stockID = stockCount;
    	this.location = location;
    	this.prodList = new ProductList[100];
    	stockCount++;
    }
    
    
    public Stock(String location, ProductList[] prodList){
    	stockID = stockCount;
    	this.location = location;
    	this.prodList = prodList;
    	stockCount++;
    }
    
    public String displayProd(int index){
    	return prodList[index].toString();
    }
    
    public void getProdQty(){
    	
    }
    
    public void setProductInPL(Product product, int quantity){
    	prodList[productCount - 1].setProduct(product);
    	prodList[productCount - 1].addQuantity(quantity);
    	productCount++;
    }
    
    public void addProductInPL(Product product, int quantity){
    	prodList[productCount - 1].addQuantity(quantity);
    }
    
    public void minusProductInPL(Product product, int quantity){
    	prodList[productCount - 1].minusQuantity(quantity);
    }
    
    public ProductList[] getProductList(){
    	return prodList;
    }
    
    public int getStockProdLen(){
    	return prodList.length;
    }
    
public String toString() {
    StringBuilder output = new StringBuilder();
	output.append(String.format("%-12s | %-12s%n", "Stock ID", "Location"));
    output.append(String.format("%-12d | %-12s\n", stockID, location));
    output.append("Product List:\n");
    
    if (prodList != null && prodList.length > 0) {
        output.append(String.format("%-30s%n", "Product Details"));
        output.append(String.format("%-12s | %-20s | %-12s | %-30s | %-5s%n", 
              "Product ID", "Product Name", "Price", "Description", "Quantity"));
        for (ProductList p : prodList) {
            if (p != null) {
                output.append(String.format("%-30s%n", p.toString()));
            }
        }
    } else {
        output.append("No Products List.\n");
    }
    return output.toString();
}



    
}
