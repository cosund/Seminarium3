package se.kth.iv1350.pos.dbHandler;

public class AccountingRegistry {
	double amount;

	public AccountingRegistry(double newAmount) {
		amount = newAmount;
	}
	
	public void accountingUpdate(double totalPrice){
		amount += totalPrice;
	}
}
