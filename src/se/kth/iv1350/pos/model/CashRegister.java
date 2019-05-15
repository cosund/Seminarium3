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
	Sale sales;

	public CashRegister(double newTotalPrice, double newCash, AccountingRegistry newAccountingRegistry, InventoryRegistry newInventoryRegistry, Sale newSale){
		totalPrice = newTotalPrice;
		cash = newCash;
		accountingRegistry = newAccountingRegistry;
		inventoryRegistry = newInventoryRegistry;
		sales = newSale;

	}

	public double addPayment() {
		double change = this.cash - this.totalPrice;
		Receipt receipt = new Receipt(this.totalPrice, change, sales);
		Printer print = new Printer(receipt);
		print.printReceipt();

		accountingRegistry.accountingUpdate(totalPrice);
		return change;
	}
	
	
}
