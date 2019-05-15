package se.kth.iv1350.pos.dbHandler;
import se.kth.iv1350.pos.DTO.Receipt;
import se.kth.iv1350.pos.model.Sale;

public class Printer {
	Receipt receipt;
	
	public Printer(Receipt newReceipt) {
		receipt = newReceipt;
	}
	
	public void printReceipt() {
		receipt.createReceipt();
		System.out.println(receipt.getFinalReceipt());
	}
}
