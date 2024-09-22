import java.util.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Order {
    private String orderID;
    private OrderDetail[] orderDetails; // Fixed-size array
    private Date orderDate;
    private String status;
    private Supplier supplier;
    private Branches branch;
    private Employee employee;
    private double subtotal;
    private static int orderCount = 1;
    private int productCount = 0; // To track the number of products ordered

    // Constructor for creating an order for a Supplier
    public Order(Supplier supplier, OrderDetail[] orderDetails, Employee employee) {
        this.orderID = String.format("O%04d", orderCount++);
        this.orderDate = new Date(); // Set the order date to current date
        this.status = "Pending"; // Default status
        this.supplier = supplier;
        this.orderDetails = orderDetails;
        this.employee = employee;
        this.branch = null; // Not applicable for supplier order
        this.productCount = orderDetails.length; // Track number of products
        calculateSubtotal(); // Calculate subtotal
    }

    // Constructor for creating an order for a Branch
    public Order(Branches branch, OrderDetail[] orderDetails, Employee employee) {
        this.orderID = String.format("O%04d", orderCount++);
        this.orderDate = new Date(); // Set the order date to current date
        this.status = "Pending"; // Default status
        this.branch = branch;
        this.orderDetails = orderDetails;
        this.employee = employee;
        this.supplier = null; // Not applicable for branch order
        this.productCount = orderDetails.length; // Track number of products
        calculateSubtotal(); // Calculate subtotal
    }
    

    // Method to calculate subtotal
    private void calculateSubtotal() {
        subtotal = 0;
        for (int i = 0; i < productCount; i++) {
            subtotal += orderDetails[i].getLineTotal();
        }
    }

    // Getters and setters
    public String getOrderID() {
        return orderID;
    }

    public OrderDetail[] getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(OrderDetail[] orderDetails) {
        this.orderDetails = orderDetails;
        this.productCount = orderDetails.length; // Update product count
        calculateSubtotal(); // Recalculate subtotal
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    public Branches getBranch() {
        return branch;
    }

    public void setBranch(Branches branch) {
        this.branch = branch;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public double getSubtotal() {
        return subtotal;
    }

    // toString method to display order details
    public String toString() {
        String report = String.format("%-15s : %s\n", "Order ID", orderID) +
                    String.format("%-15s : %s\n", "Order Date", orderDate) +
                    String.format("%-15s : %s\n", "Status", status);
        if (supplier != null) {
            report += "Supplier: " + supplier.getSupplierName() + "\n";
        } else if (branch != null) {
            report += "Branch: " + branch.getBranchAddress() + "\n";
        }
        report += "Order Details:\n";
		
		
        for (int i = 0; i < productCount; i++) {
        	if(orderDetails[i]!=null)
            report += orderDetails[i].toString() + "\n";
        }
		

        report += "Subtotal: " + String.format("%.2f", subtotal);
		
        return report; // Returning the final string
    }
}