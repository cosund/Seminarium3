package se.kth.iv1350.pos.DTO;

public class ItemDTO {
	
	int itemIdentifier;
	String itemName;
	double itemPrice;
	double VAT;
	int itemQuantity;
	
	public ItemDTO(int itemIdentifierIn, String itemNameIn,double itemPriceIn,float VATIn,int itemQuantityIn){
		
		itemIdentifier = itemIdentifierIn;
		itemName = itemNameIn;
		itemPrice = itemPriceIn;
		VAT = VATIn;
		itemQuantity = itemQuantityIn;
	}
	public void updateQuantity(int quantity){
		this.itemQuantity += quantity;
	}

	public String getName(){
		return this.itemName;
	}
	public double getPrice(){ return this.itemPrice; }
	public int getQuantity() { return this.itemQuantity;}

	public void setItemQuantity(int itemQuantity) {
		this.itemQuantity = itemQuantity;
	}

	public int getItemIdentifier() {
		return itemIdentifier;
	}

	public String toString() {

		return getName() + ", " + getQuantity() + " x " + getPrice();
	}

	public double getVAT() {
		return VAT;
	}
}
