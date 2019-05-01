package se.kth.iv1350.pos.model;

import se.kth.iv1350.pos.DTO.ItemDTO;
import se.kth.iv1350.pos.DTO.Receipt;
import se.kth.iv1350.pos.dbHandler.AccountingRegistry;
import se.kth.iv1350.pos.dbHandler.InventoryRegistry;
import se.kth.iv1350.pos.dbHandler.Printer;

import java.util.ArrayList;

public class CashRegister {
	double totalPrice;
	double cash;
	AccountingRegistry accountingRegistry;
	InventoryRegistry inventoryRegistry;

	public CashRegister(double newTotalPrice, double newCash, AccountingRegistry newAccountingRegistry, InventoryRegistry newInventoryRegistry){
		totalPrice = newTotalPrice;
		cash = newCash;
		accountingRegistry = newAccountingRegistry;
		inventoryRegistry = newInventoryRegistry;
	}

	public double addPayment() {
		double change = this.cash - this.totalPrice;
		ArrayList<ItemDTO> item = new ArrayList<ItemDTO>();
		Sale sale = new Sale(item, "", "", 0, 0 , 0, 0, inventoryRegistry);
		Receipt receipt = new Receipt(this.totalPrice, change, sale);
		Printer print = new Printer(receipt);
		print.printReceipt();

		accountingRegistry.accountingUpdate(totalPrice);
		return change;
	}
	
	
}
