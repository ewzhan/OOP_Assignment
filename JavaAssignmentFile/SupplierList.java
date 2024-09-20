public class SupplierList {
    private Supplier supplier;
    private Product product;
    private int quantity;

    public ProductSupply(Supplier supplier, Product product, int quantity) {
        this.supplier = supplier;
        this.product = product;
        this.quantity = quantity;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }
    
    
    public String toString() {
        return "Supplier: " + supplier.getSupplierName() + ", Product: " + product.getProductName() + ", Quantity: " + quantity;
    }
}