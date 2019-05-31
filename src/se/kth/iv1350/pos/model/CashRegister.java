package se.kth.iv1350.pos.model;

import se.kth.iv1350.pos.DTO.Receipt;
import se.kth.iv1350.pos.dbHandler.AccountingRegistry;
import se.kth.iv1350.pos.dbHandler.InventoryRegistry;
import se.kth.iv1350.pos.dbHandler.Printer;
import se.kth.iv1350.pos.view.TotalRevenueView;

public class CashRegister {
	TotalRevenue totalRevenueObserver;

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
		notifyObservers();

		accountingRegistry.accountingUpdate(totalPrice);
		return change;
	}
	public void addObservers(TotalRevenueView totalRevenueView){
		this.totalRevenueObserver = totalRevenueView;
	}
	private void notifyObservers() {
		totalRevenueObserver.newTotal(this.totalPrice);
	}

	
}
