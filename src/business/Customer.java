package src.business;
import java.util.Date;
import java.util.List;

public class Customer extends User {
    private int passportNumber;
   
    public Customer(int userId, String name, String password) {
        super(userId, name, password);
    }
    
}