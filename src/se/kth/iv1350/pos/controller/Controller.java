package se.kth.iv1350.pos.controller;
import se.kth.iv1350.pos.DTO.ItemDTO;
import se.kth.iv1350.pos.dbHandler.*;
import se.kth.iv1350.pos.exceptions.DatabaseFailureException;
import se.kth.iv1350.pos.exceptions.NonExistingItemException;
import se.kth.iv1350.pos.model.CashRegister;
import se.kth.iv1350.pos.model.Sale;
import se.kth.iv1350.pos.view.TotalRevenueView;

import java.util.ArrayList;

public class Controller {
	RegistryCreator registerCreator;
	Sale sales;
	private TotalRevenueView totalRevenueObserver;

		
		public Controller(RegistryCreator newRegisterCreator) {
			registerCreator = newRegisterCreator;
		}

		public void startNewSales() {
			sales = new Sale(new ArrayList<>(),"Kista Store", "Kistagatan 20", 2019, 11, 5, 12, 42);

		}

		public String addItem(int itemIdentifier, int itemQuantity) throws NonExistingItemException, DatabaseFailureException {
			ItemDTO newItem = registerCreator.getItems().getItemSpecification(itemIdentifier);

			registerCreator.getInventoryRegistry().inventoryUpdate(newItem, -itemQuantity);
			return sales.addItem(newItem, itemQuantity);
		}
		
		public double checksForDiscount(int customerID, double totalPrice) {
			double discount = registerCreator.getCustomerDiscount(customerID);
			return totalPrice - discount;
		}
		
		public double startPayment(double cash, double totalPrice) {
			CashRegister change = new CashRegister(totalPrice, cash, registerCreator.getAccountingRegistry(), registerCreator.getInventoryRegistry(), sales);
			change.addObservers(totalRevenueObserver);
			double finalPrice = change.addPayment();
			registerCreator.getItems().resetItemRegistry();
			return finalPrice;
		}

	public void addRevenueObserver(TotalRevenueView totalRevenueView){
		totalRevenueObserver = totalRevenueView;

	}
	public Sale getSales() {
		return sales;
	}

}
