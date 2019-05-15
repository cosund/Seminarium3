package se.kth.iv1350.pos.dbHandler;
import se.kth.iv1350.pos.DTO.ItemDTO;
import se.kth.iv1350.pos.exceptions.DatabaseFailureException;
import se.kth.iv1350.pos.exceptions.NonExistingItemException;

import java.util.ArrayList;
import java.util.NoSuchElementException;

public class ItemRegistry {
	ArrayList<ItemDTO> registryItems;

	public ItemRegistry(ArrayList newItems) {
		registryItems = newItems;
	}

	/**
	 * @param itemIdentifier
	 * @return
	 * @exception NoSuchElementException when itemidentifier does not exist in the database
	 * @exception IllegalStateException when there is a database failure
	 */
	public ItemDTO getItemSpecification(int itemIdentifier)throws NonExistingItemException, DatabaseFailureException {
		if (itemIdentifier == 1){
			throw new DatabaseFailureException("Database failure", new Throwable("This is info about the database failure"));
		}
		for(int i = 0; i < (this.registryItems.size()); i++){
			if(registryItems.get(i).getItemIdentifier() == itemIdentifier){
				return registryItems.get(i);
			}
		}
		throw new NonExistingItemException("Itemidentifier " + itemIdentifier + " does not exist in the system.", new Throwable("This is info about the missing item"));
	}
	public void resetItemRegistry(){
		for (int i = 0; i < this.registryItems.size(); i++) {
			this.registryItems.get(i).setItemQuantity(0);
		}
	}
}
