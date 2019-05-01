package se.kth.iv1350.pos.dbHandler;

import java.util.ArrayList;

public class RegistryCreator {
	ArrayList<CustomerRegistry> customerRegistries;
	ItemRegistry items;
	AccountingRegistry accountingRegistry;
	InventoryRegistry inventoryRegistry;

	public RegistryCreator(ArrayList newCustomerRegistry, ItemRegistry newItems, AccountingRegistry newAccountingRegistry, InventoryRegistry newInventoryRegistry) {

		customerRegistries = newCustomerRegistry;
		items = newItems;
		accountingRegistry = newAccountingRegistry;
		inventoryRegistry = newInventoryRegistry;
	}

	public double getCustomerDiscount(int customerID) {

		for(int i = 0; i > (customerRegistries.size() - 1); i++){
			double discount = customerRegistries.get(i).findCustomer(customerID);
			if(discount != 0) {
				return discount;
			}
		}
		return 0;
	}
}
