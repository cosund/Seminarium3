package se.kth.iv1350.pos.dbHandler;

import org.junit.Test;
import se.kth.iv1350.pos.DTO.ItemDTO;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class RegistryCreatorTest {

    @Test
    public void getCustomerDiscount() {
        int id = 10;

        CustomerRegistry cust = new CustomerRegistry(10, 30);

        ArrayList<CustomerRegistry> custlist = new ArrayList<>();
        ArrayList<ItemDTO> itemList = new ArrayList<>();
        custlist.add(cust);

        AccountingRegistry newAcc = new AccountingRegistry(30);
        ItemRegistry newItem = new ItemRegistry(itemList);
        InventoryRegistry newInv = new InventoryRegistry(itemList);
        RegistryCreator newReg = new RegistryCreator(custlist, newItem, newAcc, newInv);

        double excpectedDiscount = newReg.getCustomerDiscount(id);

        assertEquals("No discount found for customer.", 30, excpectedDiscount, 0);

    }
}