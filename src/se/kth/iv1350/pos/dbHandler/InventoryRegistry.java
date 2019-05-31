package se.kth.iv1350.pos.dbHandler;
import se.kth.iv1350.pos.DTO.ItemDTO;

import java.util.ArrayList;

public class InventoryRegistry {

	ArrayList<ItemDTO> items;
	public InventoryRegistry(ArrayList newItems) {
		items = newItems;
	}
	
	public void inventoryUpdate(ItemDTO itemSpecification, int quantity){
		for (int i = 0; i < items.size(); i++) {
			if(items.get(i).getItemIdentifier() == itemSpecification.getItemIdentifier()){
				if(items.get(i).getQuantity() > 0){
					items.get(i).updateQuantity(quantity);
				}
				else{
					items.remove(i);
				}

			}
			//System.out.println(items.get(i).getQuantity());
		}
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < items.size(); i++) {
			sb.append(items.get(i).toString());
		}
		return sb.toString();
	}
}
