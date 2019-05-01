package se.kth.iv1350.pos.controller;
import se.kth.iv1350.pos.DTO.ItemDTO;
import se.kth.iv1350.pos.dbHandler.*;
import se.kth.iv1350.pos.model.CashRegister;
import se.kth.iv1350.pos.model.Sale;

public class Controller {
	RegistryCreator registerCreator;
	Sale sales;
	ItemRegistry itemRegistry;
	AccountingRegistry accountingRegistry;
	InventoryRegistry inventoryRegistry;
		
		public void startNewSales() {
			System.out.println(addItem(12, 3));
			double totalPrice = checksForDiscount(156, sales.paymentInfo());
			startPayment(200, totalPrice);
		}
		
		public Controller(RegistryCreator newRegisterCreator, Sale newSales, ItemRegistry newItemRegistry, AccountingRegistry newAccountingRegistry, InventoryRegistry newInventoryRegistry) {
			registerCreator = newRegisterCreator;
			sales = newSales;
			itemRegistry = newItemRegistry;
			accountingRegistry = newAccountingRegistry;
			inventoryRegistry = newInventoryRegistry;
		}
		
		public String addItem(int itemIdentifier, int itemQuantity) {
			ItemDTO newItem = itemRegistry.getItemSpecification(itemIdentifier);

			if(newItem == null){
				return "Item does not exist.";
			}

			sales.addItem(newItem, itemQuantity);
			
			return newItem.getName();
		}
		
		public double checksForDiscount(int customerID, double totalPrice) {
			double discount = registerCreator.getCustomerDiscount(customerID);
			return totalPrice - discount;
		}
		
		public double startPayment(double cash, double totalPrice) {
			CashRegister change = new CashRegister(totalPrice, cash, accountingRegistry, inventoryRegistry);
			double finalPrice = change.addPayment();
			return finalPrice;
		}
}
