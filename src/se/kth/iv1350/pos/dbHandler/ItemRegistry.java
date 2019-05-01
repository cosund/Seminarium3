package se.kth.iv1350.pos.dbHandler;
import se.kth.iv1350.pos.DTO.ItemDTO;

import java.util.ArrayList;

public class ItemRegistry {
	ArrayList<ItemDTO> items;

	public ItemRegistry(ArrayList newItems) {
		items = newItems;
	}
	
	public ItemDTO getItemSpecification(int itemIdentifier) {
		for(int i = 0; i < (this.items.size()); i++){
			if(items.get(i).getItemIdentifier() == itemIdentifier){
				return items.get(i);
			}
		}
		return null;
	}
}
