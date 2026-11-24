package src.business;
import java.time.LocalDate;

public class Reservation {
    private int reservationId;
    private LocalDate reservationDate;
    private boolean status;
    private double price;

    public Reservation(int reservationId, LocalDate reservationDate, boolean status, double price) {
        this.reservationId = reservationId;
        this.reservationDate = reservationDate;
        this.status = status;
        this.price = price;
    }
    public void confirm() {

    }
    public void cancel() {

    }
    public void modify() {

    }
    public void generateConfirmation() {
        if (status){
            System.out.print("Reservation is confirmed. Reservation ID: ");
            System.out.print(this.reservationId);
        }
        else System.out.println("Reservation could not be confirmed.");
    }

}
