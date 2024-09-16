
public class StockControl extends Product {
	
	//variable declaration
	private int stockID;
	private int quantity;
	private int stockLeft;
	private String moveType;
	private String date;
	private static int scCount = 1;
	public Product product;
	//-------------------------------------------------------------
	
	//constructors
    public StockControl() {
    	stockID = scCount;
    	quantity = 0;
    	stockLeft = 0;
    	moveType = "";
    	date = "";
    	scCount++;
    }
    
    public StockControl(int quantity, String moveType, String date, String productName, int productQty, String productDescription, double productPrice){
    	super(productName, productQty, productDescription, productPrice);
    	stockID = scCount;
    	this.quantity = quantity;
    	stockLeft = getProductQty();  //run add/minus productQty first before constructing
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
    	if (this.moveType.equals("Add")){		//if add, minus twice
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
    
    public void setDate(String date){
    	this.date = date;
    }
    
    public String getDate(){
    	return date;
    }
    //-------------------------------------------------------------
    
    
}