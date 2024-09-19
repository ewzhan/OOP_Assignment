import java.text.DecimalFormat;
import java.util.Date;

public class Invoice extends Order {
private String invoiceID;
private static int invoiceCounter = 1;

    //Default Constructor
    public Invoice() {
    	this(new Date(),"Pending");  //State status as pending before payment
    }
    
    //Parameterized constructor
     public Invoice(Date orderDate,String status) {
    	super(orderDate,status);
    	this.invoiceID = generateInvoiceID();
    }

    //Generate a unique Invoice ID
    private String generateInvoiceID(){
    	DecimalFormat formatter = new DecimalFormat("INV0000");
    	String formattedInvoiceID = formatter.format(invoiceCounter);
    	invoiceCounter++;
    	return formattedInvoiceID;    	
    	}

    //Getter    
     public String getInvoiceID() {
        return invoiceID;
    }

    //String return    
    public String toString(){
    	return "\nInvoice ID:" + this.invoiceID + " | Order ID:" +super.getOrderID() ;
   	}
}