package se.kth.iv1350.pos.dbHandler;

import org.junit.Test;

import static org.junit.Assert.*;

public class CustomerRegistryTest {

    @Test
    public void findCustomer() {
        int id = 10;
        CustomerRegistry newReg = new CustomerRegistry(10, 5);
        double expResult = 5;
        double result = newReg.findCustomer(id);

        assertEquals("User with this customerID not found.", result, expResult, 0);


    }
}