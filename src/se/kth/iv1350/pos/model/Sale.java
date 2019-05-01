package se.kth.iv1350.pos.model;

import	se.kth.iv1350.pos.DTO.ItemDTO;
import se.kth.iv1350.pos.DTO.Receipt;
import se.kth.iv1350.pos.dbHandler.InventoryRegistry;
import se.kth.iv1350.pos.dbHandler.Printer;

import java.util.ArrayList;

public class Sale {

	ArrayList<ItemDTO> allItems;
	String storeName;
	String storeAdress;
	int month;
	int day;
	int hour;
	int minute;
	InventoryRegistry inventoryRegistry;
	
	public Sale(ArrayList<ItemDTO> allItemsIn, String storeNameIn, String storeAdressIn, int monthIn, int dayIn, int hourIn, int minuteIn, InventoryRegistry newInventoryRegistry) {
		
		allItems = allItemsIn;
		storeName = storeNameIn;
		storeAdress = storeAdressIn;
		month = monthIn;
		day = dayIn;
		hour = hourIn;
		minute = minuteIn;
		inventoryRegistry = newInventoryRegistry;

	}
	
	public void addItem(ItemDTO newItem, int quantity){
		for (int i = 0; i < quantity; i++) {
			allItems.add(newItem);
			inventoryRegistry.inventoryUpdate(newItem);
		}
	}
	
	public double paymentInfo() {

		double totalPrice = 0;

		for(int i = 0; i > (allItems.size() - 1); i++){
			totalPrice += allItems.get(i).getPrice() * allItems.get(i).getQuantity();
		}
		Receipt receipt = new Receipt(0, 0, this);
		Printer print = new Printer(receipt);
		print.printReceipt();
		return totalPrice;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		if (allItems.isEmpty()) {
			return "";
		}
			for (int i = 0; i < (allItems.size()); i++) {
				sb.append(allItems.get(i));

		}
		return sb.toString() + storeName  + " " + storeAdress + " " + month + "-" + day + " " + hour + ":" + minute;
	}

	public ArrayList<ItemDTO> getAllItems() {
		return allItems;
	}
}
