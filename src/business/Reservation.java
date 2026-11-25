package src.business;
import java.time.LocalDate;
import java.util.*;

public class Reservation{
    //subject to add or remove an observer object
    private int reservationId;
    private int flightId;
    private LocalDate reservationDate;
    private boolean status;
    private double price;

    public Reservation(int reservationId, LocalDate reservationDate, boolean status, double price) {
        this.reservationId = reservationId;
        this.reservationDate = reservationDate;
        this.status = status;
        this.price = price;
    }
    public void confirm(Reservation reservation) {
        status = true;
    }
    public void cancel(Reservation reservation) {
        status = false;
    }
    public void modify(int flightId, LocalDate reservationDate, double price) {
        this.flightId = flightId;
        this.reservationDate = reservationDate;
        this.price = price;
    }
    public void generateConfirmation() {
        //still to implement
    }

    //getters
    public int getReservationId(){
        return reservationId;
    }
    public int getFlightId(){
        return  flightId;
    }
    public LocalDate getReservationDate(){
        return reservationDate;
    }
    public boolean getStatus(){
        return status;
    }
    public double getPrice(){
        return price;
    }
}
