package se.kth.iv1350.pos.DTO;

public class ItemDTO {
	
	int itemIdentifier;
	String itemName;
	double itemPrice;
	float VAT;
	int itemQuantity;
	
	public ItemDTO(int itemIdentifierIn, String itemNameIn,double itemPriceIn,float VATIn,int itemQuantityIn){
		
		itemIdentifier = itemIdentifierIn;
		itemName = itemNameIn;
		itemPrice = itemPriceIn;
		VAT = VATIn;
		itemQuantity = itemQuantityIn;
	}

	public String getName(){
		return this.itemName;
	}
	public double getPrice(){ return this.itemPrice; }
	public int getQuantity() { return this.itemQuantity;}

	public int getItemIdentifier() {
		return itemIdentifier;
	}

	public String toString() {

		return getName() + " ";
	}
}
