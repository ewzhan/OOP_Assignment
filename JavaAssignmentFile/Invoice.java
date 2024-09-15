
public class Invoice extends Order {
private int invoiceID;
    public Invoice() {
    	this("",null,null,"",0);
    }
    
     public Invoice(String orderID,OrderDetail orderDetail,Date orderDate,String status,int invoiceID) {
    	super(orderID,orderDetail,orderDate,status);
    	this.invoiceID = invoiceID;
    }
    
    public void setInvoiceID(int invoiceID){
    	this.invoiceID = invoiceID;
    	}
    
     public int getInvoiceID() {
        return invoiceID;
    }
     
    public String toString(){
    	return "Invoice ID:" + invoiceID;
    	}
}