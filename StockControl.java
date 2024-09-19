
public class StockControl extends Product {
	
	//variable declaration
	private int stockID;
	private int quantity;
	private int stockLeft;
	private String moveType;
	private String reference;
	private String date;
	public static int scCount = 1;
	public Product product;
	//-------------------------------------------------------------
	
	//constructors
    public StockControl() {
    	stockID = scCount;
    	quantity = 0;
    	stockLeft = 0;
    	moveType = "";
    	reference = "";
    	date = "";
    	scCount++;
    }
    
    public StockControl(int quantity, int stockLeft, String moveType, String reference, String date, Product product){
    	this.product = product;
    	this.stockID = scCount;
    	this.quantity = quantity;
    	this.stockLeft = stockLeft;  //run add/minus productQty first before constructing
    	this.reference = reference;
    	this.moveType = moveType;
    	this.date = date;
    	scCount++;	
    }
   	//-------------------------------------------------------------
    
    //functions
    //setters & getters
    public void setQuantity(int quantity){
    	if (moveType.equals("Add")){		//if add, add more(or minus)
    		addProductQty(quantity - this.quantity);	
    		this.quantity = quantity;
    	}
    	else {								//if minus, minus more(or add)
    		minusProductQty(quantity - this.quantity);
    		this.quantity = quantity;
    	}
    }
    
    public int getQuantity(){
    	return quantity;
    }
    //-------------------------------------------------------------
    
    public void setMoveType(String moveType){
    	if (this.moveType.equals("Add Stock")){		//if add, minus twice
    		minusProductQty(quantity * 2);
    		this.moveType = moveType;
    	}
    	else{									//else, add twice
    		addProductQty(quantity * 2);
    		this.moveType = moveType;
    	}
    }
    
    public String getMoveType(){
    	return moveType;
    }
    //-------------------------------------------------------------
    
    public void setRef(String reference){
    	this.reference = reference;
    }
    
    public String getRef(){
    	return reference;
    }
    
    //-------------------------------------------------------------
    
    public void setDate(String date){
    	this.date = date;
    }
    
    public String getDate(){
    	return date;
    }
    //-------------------------------------------------------------
    
    //Stock Control to string
	public void toStringInvCtrl() {
	    System.out.println("Stock ID: " + stockID);
		System.out.println("Product Name: " + product.getProductName());
	    System.out.println("Quantity Transfered: " + quantity);
	    System.out.println("Remaining Stock after Movement: " + stockLeft);
	    System.out.println("Move Type: " + moveType);
	    System.out.println("Reference: " + reference);
		System.out.println("Date Transferred: " + date);

	}
}