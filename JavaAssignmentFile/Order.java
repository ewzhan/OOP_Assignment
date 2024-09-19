import java.util.Date;
import java.util.ArrayList;
import java.text.DecimalFormat;
import java.util.List;

public class Order {
    private String orderID;
    private List<OrderDetail> orderDetails;
    private Date orderDate;
    private String status;  
    private static int orderCounter = 1;

    //Parameterized Constructor
    public Order(Date orderDate, String status) {
        this.orderID = generateOrderID();
        this.orderDetails = new ArrayList<>();
        this.orderDate = orderDate;
        this.status = status;
    }

    // Add product to order
    public void addProduct(Product product) {
        if (product == null) {
            System.out.println("Product cannot be empty!");
            return;
        }

        if (product.getProductQty() <= 0) {
            System.out.println("Product quantity must be greater than zero!");
            return;
        }

        orderDetails.add(new OrderDetail(product));
        System.out.println("Product added successfully.");
    }

    // Remove product from order based on product ID
    public void removeProduct(String productID) {
        if (productID == null || productID.isEmpty()) {
            System.out.println("Product ID cannot be null or empty.");
            return;
        }
        
        //Assume OrderDetail with Product having productID, call removeProduct(PROD****) 
        //Format productID as PROD**** and compare with parameter value.
        //If matched, it will remove from orderDetails list.
        boolean removed = orderDetails.removeIf(detail ->
            String.format("PROD%04d", detail.getProduct().getProductID()).equals(productID)
        );

        if (removed) {
            System.out.println("Product removed successfully.");
        } else {
            System.out.println("Product with ID " + productID + " not found.");
        }
    }

    // Calculate total cost of all order details
    public double calcTotal() {
        if (orderDetails.isEmpty()) {
            System.out.println("No products in the order.");
            return 0;
        }

        double total = 0;
        for (OrderDetail detail : orderDetails) {
            total += detail.calculateCost();
        }

        System.out.println("Total calculated: " + total);
        return total;
    }

    // Generate a unique Order ID
    private String generateOrderID() {
        DecimalFormat formatter = new DecimalFormat("ORD0000");
        String formattedOrderID = formatter.format(orderCounter);
        orderCounter++;
        return formattedOrderID;
    }

    // Getters and Setters
    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public String getOrderID() {
        return orderID;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public List<OrderDetail> getOrderDetails() {
        return new ArrayList<>(orderDetails); // Return a copy to prevent external modification
    }
}
