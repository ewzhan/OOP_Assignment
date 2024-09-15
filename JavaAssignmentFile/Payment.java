
public class Payment extends Invoice {
private String paymentMethod;
private double amount;

    public Payment() {
    	this(0,"",0.00);
    }

    public Payment(int invoiceID,String paymentMethod,double amount) {
    	super(invoiceID);
    	this.paymentMethod = paymentMethod;
    	this.amount = amount;
    }
    
    public void setPaymentMethod(String paymentMethod){
    	if(paymentMethod.equalsIgnoreCase("Cash")|| paymentMethod.equalsIgnoreCase("CreditCard")|| 
    		paymentMethod.equalsIgnoreCase("ECash")){    		
    	this.paymentMethod = paymentMethod;
    	}else{
    		System.out.println("Invalid payment Method : " +paymentMethod+ ". Please enter valid choice." ); // Display invalid message along with their error input
    		}
    }
        
    public void setAmount(int amount){
    	if(amount >= 0){
    	this.amount = amount;
    	}else{
    		System.out.println("Invalid amount. Value cannot be nagative.");
    		}
    }
    
    public String getPaymentMethod(){
    	return paymentMethod;
    	}
    	
    public double getAmount(){
    	return amount;
    	}
    
    public void receipt(){
    	System.out.println("Receipt\t\t\t"+super.toString());
    	System.out.println("\n============================================");
    	System.out.println("\nPayment Method: " + paymentMethod);
    	System.out.println("\nAmount: " + amount);
    	}
    
}