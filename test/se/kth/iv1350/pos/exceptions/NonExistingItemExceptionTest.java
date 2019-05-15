package se.kth.iv1350.pos.exceptions;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import se.kth.iv1350.pos.DTO.ItemDTO;
import se.kth.iv1350.pos.dbHandler.ItemRegistry;

import java.util.ArrayList;

public class NonExistingItemExceptionTest {
    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void exceptionTest() throws NonExistingItemException{
        ArrayList<ItemDTO> list = new ArrayList<>();
        list.add(new ItemDTO(10, "mango", 5, 1, 0));

        thrown.expect(NonExistingItemException.class);
        thrown.expectMessage("Itemidentifier " + 5 + " does not exist in the system.");
        listTest(list, 5);
    }

    public void listTest(ArrayList<ItemDTO> reg, int itemIdentifier) throws NonExistingItemException{
        for (int i = 0; i < reg.size(); i++) {
            if(itemIdentifier == reg.get(i).getItemIdentifier()){
                System.out.println("Failure");
            }
        }

        throw new NonExistingItemException("Itemidentifier " + itemIdentifier + " does not exist in the system.", new Throwable("This is info about the missing item"));

    }

}