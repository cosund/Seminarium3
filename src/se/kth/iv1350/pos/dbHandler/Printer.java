package se.kth.iv1350.pos.dbHandler;
import se.kth.iv1350.pos.DTO.Receipt;
import se.kth.iv1350.pos.model.Sale;

public class Printer {
	Receipt receipt;
	
	public Printer(Receipt newReceipt) {
		receipt = newReceipt;
	}
	
	public void printReceipt() {
		if(receipt.getSales().getAllItems().isEmpty()){
			System.out.println(receipt.getTotalPrice() + " " + receipt.getCash());
		}
		else if(receipt.getTotalPrice() == 0 & receipt.getCash() == 0){
			System.out.println(receipt.getSales().toString());
		}
	}
}
