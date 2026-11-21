package src.business;
import java.time.LocalDate;

public class CreditCardPayment extends Payment {
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
