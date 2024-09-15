public class Branches {
	private String branchesID;
	private String branchesName;
	private String branchesEmail;
	private String phoneNum;
	private OrderList orders;
	//check stock level with product quantity in the stock of this branch
	private static int branchesCount = 0;

    public Branches(String branchesID, String branchesName, String branchesEmail, String phoneNum, OrderList orders) {
    	this.branchesID = branchesID;
    	this.brancesName = brancesName;
    	this.branchesEmail = branchesEmail;
    	this.phoneNum = phoneNum;
    	
    }
    
    public String getBranchesID(){
    	return branchesID;
    }
    
    public String getBranchesName(){
    	return branchesName;
    }
    
    public String getBranchesEmail(){
    	return branchesEmail;
    }
    
    public String getBranchesPhoneNum(){
    	return this.phoneNum;
    }
    
    public void setBranchesID(String branchesID){
    	this.branchesID = branchesID;
    }
    
    public void setBranchesName(String branchesName){
    	this.branchesName = branchesName;
    }
    
    public void setBranchesEmail(String branchesEmail){
    	this.branchesEmail = branchesEmail;
    }
    
    public void setBranchesPhoneNum(String phoneNum){
    	this.phoneNum = phoneNum;
    }
    
    public void addBranch(){
    	/**System.out.println("1. Add branch");
    	System.out.println("2. Back");
    	System.out.print("Enter the option > ");**/
    	addBranch
    	
    }
    
    
    
    public void receiveStock(Product product, int quantity) {
        stockLevels.put(product, stockLevels.getOrDefault(product, 0) + quantity);
        System.out.println("Branch " + branchId + " received " + quantity + " units of " + product.getName());
    }
    
    public void 
    
    
}