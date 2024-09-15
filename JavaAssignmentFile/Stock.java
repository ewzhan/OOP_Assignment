import java.util.*;

public class Stock {
    private String hqId;
    private String location;
    private List<Stock> stockList;
    private List<Branch> branches;

    public Stock(String hqId, String location) {
        this.stockId = stockId;
        this.location = location;
        this.stockList = new ArrayList<>();
        this.branches = new ArrayList<>();
    }

    public void receiveStock(Product product, int quantity) {
        Stock stock = findStockByProduct(product);
        if (stock != null) {
            stock.increaseStock(quantity);
        } else {
            stockList.add(new Stock(product, quantity));
        }
        System.out.println("StockIn: Received " + quantity + " units of " + product.getName());
    }

    public void distributeStock(Product product, int quantity, Branch branch) {
        Stock stock = findStockByProduct(product);
        if (stock != null && stock.getQuantity() >= quantity) {
            stock.decreaseStock(quantity);
            branch.receiveStock(product, quantity);
            System.out.println("StockOut: Sent " + quantity + " units of " + product.getName() + " to branch: " + branch.getBranchId());
        } else {
            System.out.println("Insufficient stock to distribute.");
        }
    }

    private Stock findStockByProduct(Product product) {
        for (Stock stock : stockList) {
            if (stock.getProduct().equals(product)) {
                return stock;
            }
        }
        return null;
    }

    // Getters and setters
}
