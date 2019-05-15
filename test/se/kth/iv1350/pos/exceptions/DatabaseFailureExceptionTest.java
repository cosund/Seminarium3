package se.kth.iv1350.pos.exceptions;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class DatabaseFailureExceptionTest {
    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void exceptionTest() throws DatabaseFailureException{

        thrown.expect(DatabaseFailureException.class);
        thrown.expectMessage("Database failure");
        listTest(1);
    }

    public void listTest(int itemIdentifier) throws DatabaseFailureException{
            if (itemIdentifier == 1){
                throw new DatabaseFailureException("Database failure", new Throwable("More info"));
            }
            else
                System.out.println("Failure");
    }


}