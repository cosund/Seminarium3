package se.kth.iv1350.pos.model;

import	se.kth.iv1350.pos.DTO.ItemDTO;

import java.util.ArrayList;

public class Sale {

	ArrayList<ItemDTO> allItems;
	String storeName;
	String storeAdress;
	int year;
	int month;
	int day;
	int hour;
	int minute;
	
	public Sale(ArrayList<ItemDTO> newAllItems, String storeNameIn, String storeAdressIn, int newYear, int monthIn, int dayIn, int hourIn, int minuteIn) {
		allItems = newAllItems;
		storeName = storeNameIn;
		storeAdress = storeAdressIn;
		year = newYear;
		month = monthIn;
		day = dayIn;
		hour = hourIn;
		minute = minuteIn;

	}
	
	public String addItem(ItemDTO newItem, int quantity){
		if(allItems == null){
			allItems = new ArrayList<>();
			allItems.add(newItem);
		}
		for (int i = 0; i < allItems.size(); i++) {
			if(allItems.get(i) == newItem){
				allItems.get(i).updateQuantity(quantity);


				return newItem.getName() + " x" + allItems.get(i).getQuantity();
			}
		}
		allItems.add(newItem);
		allItems.get(allItems.size()-1).updateQuantity(quantity);

		return newItem.getName() + " x" + newItem.getQuantity();
	}

	public double paymentInfo() {

		double totalPrice = 0;

		for(int i = 0; i < allItems.size(); i++){
			totalPrice += allItems.get(i).getPrice() * allItems.get(i).getQuantity();
		}

		return totalPrice;
	}

	public double totalVAT(){
		double totalVAT = 0;

		for(int i = 0; i < allItems.size(); i++){
			totalVAT+= allItems.get(i).getVAT() * allItems.get(i).getQuantity();
		}

		return totalVAT;
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

	public int getDay() {
		return day;
	}

	public int getHour() {
		return hour;
	}

	public int getMinute() {
		return minute;
	}

	public int getMonth() {
		return month;
	}

	public String getStoreAdress() {
		return storeAdress;
	}

	public String getStoreName() {
		return storeName;
	}

	public int getYear() {
		return year;
	}
}
