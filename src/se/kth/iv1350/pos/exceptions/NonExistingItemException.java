package se.kth.iv1350.pos.exceptions;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class NonExistingItemException extends Exception {
    public NonExistingItemException(String errorMessage, Throwable err){
        super(errorMessage, err);
        createLog(errorMessage, err);
    }
    private void createLog(String errorMessage, Throwable err){
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        System.out.println("Log time: " + date.toString() + "\n" + "Log Details: " + errorMessage + "\nMore info: " + err.toString());
    }
}
