package se.kth.iv1350.pos.startup;

import se.kth.iv1350.pos.DTO.ItemDTO;
import se.kth.iv1350.pos.controller.Controller;
import se.kth.iv1350.pos.dbHandler.*;
import se.kth.iv1350.pos.model.Sale;

import java.util.ArrayList;

public class Main {
	
	public static void main(String [ ] args) {
		ArrayList<CustomerRegistry> customerRegistries = new ArrayList<CustomerRegistry>();
		customerRegistries.add(new CustomerRegistry(156, 30));
		AccountingRegistry accountingRegistry = new AccountingRegistry(0);

		ItemDTO items = new ItemDTO(12, "apelsin", 15, 12, 1);
		ArrayList<ItemDTO> inventryItems = new ArrayList<>();
		inventryItems.add(items);
		inventryItems.add(items);
		InventoryRegistry inventoryRegistry = new InventoryRegistry(inventryItems);
		ArrayList<ItemDTO> itemInfo = new ArrayList<ItemDTO>();
		itemInfo.add(items);
		ItemRegistry itemS = new ItemRegistry(itemInfo);
		RegistryCreator registryCreator = new RegistryCreator(customerRegistries, itemS, accountingRegistry, inventoryRegistry);

		ArrayList<ItemDTO> sales = new ArrayList<ItemDTO>();
		Sale newSale = new Sale(sales, "Blabla", "Blablagatan", 11, 5, 12, 40, inventoryRegistry);

		Controller controller = new Controller(registryCreator, newSale, itemS, accountingRegistry, inventoryRegistry);
		controller.startNewSales();
	}
}
