package src.business;

import java.time.LocalDate;

public class PayPalPayment extends Payment {
    //should probably also verify login
    private String cardNumber;
    private LocalDate expiryDate;

    @Override 
    public boolean process() {
        if(cardNumber.length() != 16 || !expiryDate.isBefore(LocalDate.now())) {
            status = "FAILED";
            return false;
        }
        status = "COMPLETED";
        return true;
    }
}
