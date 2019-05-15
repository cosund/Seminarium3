package se.kth.iv1350.pos.startup;

import se.kth.iv1350.pos.DTO.ItemDTO;
import se.kth.iv1350.pos.dbHandler.*;
import se.kth.iv1350.pos.view.*;
import se.kth.iv1350.pos.controller.*;

import java.util.ArrayList;

public class Main {
	
	public static void main(String [ ] args) {

		ArrayList<CustomerRegistry> customerRegistries = new ArrayList<CustomerRegistry>();
		customerRegistries.add(new CustomerRegistry(156, 30));
		AccountingRegistry accountingRegistry = new AccountingRegistry(0);

		//varor
		ItemDTO items = new ItemDTO(12, "Apelsin", 15, 1, 5);
		ItemDTO items1 = new ItemDTO(12, "Apelsin", 15, 1, 0);

		ItemDTO items2 = new ItemDTO(15, "Banan", 7, 3, 5);
		ItemDTO items3 = new ItemDTO(15, "Banan", 7, 3, 0);

		ArrayList<ItemDTO> inventryItems = new ArrayList<>();
		inventryItems.add(items);
		inventryItems.add(items2);
		InventoryRegistry inventoryRegistry = new InventoryRegistry(inventryItems);
		ArrayList<ItemDTO> itemInfo = new ArrayList<ItemDTO>();
		itemInfo.add(items1);
		itemInfo.add(items3);
		ItemRegistry itemS = new ItemRegistry(itemInfo);
		RegistryCreator registryCreator = new RegistryCreator(customerRegistries, itemS, accountingRegistry, inventoryRegistry);

		Controller contr = new Controller(registryCreator);

		View view = new View(contr);

		view.StartSale();
	}
}
