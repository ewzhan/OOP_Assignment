public class Branches {
    private String branchesID;
    private String branchAddress;
    private Stock stock; // Assuming Stock is a class representing stock information
    private static int branchesCount = 0;

    // Constructor
    public Branches(String branchAddress) {
    	this.branchesID = "B00" + (branchesCount + 1);
        this.branchAddress = branchAddress;
        this.stock = new Stock(); // Create a new Stock object for this branch
        branchesCount++;
    }

    // Default constructor
    public Branches() {
        this("");
    }

    // Getters and setters
    public String getBranchesID() {
        return branchesID;
    }

    public void setBranchesID(String branchesID) {
        this.branchesID = branchesID;
    }

    public String getBranchAddress() {
        return branchAddress;
    }

    public void setBranchAddress(String branchAddress) {
        this.branchAddress = branchAddress;
    }
	public void setStock(){
		this.stock =stock;
	}
    public Stock getStock() {
        return stock;
    }

    

    // Display branch details
    public String toString() {
    String report = String.format("%-15s : %s\n", "Branch ID", branchesID) +
                    String.format("%-15s : %s\n", "Branch Address", branchAddress) +
                    "Stock:\n";

    if (stock != null) {
        report += stock.toString();  // Assuming Stock class has its own formatted toString method
    } else {
        report += "No stock available.";
    }
    
    return report;
    }

    
}
