package se.kth.iv1350.pos.dbHandler;
import se.kth.iv1350.pos.DTO.ItemDTO;

import java.util.ArrayList;

public class InventoryRegistry {

	ArrayList<ItemDTO> items;
	public InventoryRegistry(ArrayList newItems) {
		items = newItems;
	}
	
	public void inventoryUpdate(ItemDTO itemSpecification){
		for (int i = 0; i < items.size(); i++) {
			if(items.get(i).getItemIdentifier() == itemSpecification.getItemIdentifier()){
				items.remove(i);
			}
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
