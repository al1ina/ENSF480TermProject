package src.business;
import java.time.LocalDate;
import java.util.Date;

public abstract class Payment {
    protected int paymentId;
    protected double amount;
    protected LocalDate paymentDate;
    protected String status;

    public abstract boolean process();
}
