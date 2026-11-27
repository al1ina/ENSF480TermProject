package src.business;
import java.util.*;

public class ReservationController{
    //manage observers and helps to make, cancel, and modify reservations
    private List<ReservationObserver> observers = new ArrayList<>();

    public void addObserver(ReservationObserver observer){
        observers.add(observer);
    }
    public void notifyObservers(String message, Reservation reservation){
        for (ReservationObserver observer : observers){
            observer.update(message, reservation);
        }
    }
    public void cancelReservation(Reservation reservation, Flight flight){
        if (!reservation.getStatus()){
            return;
        }

        reservation.cancel();
        flight.releaseSeat();

        notifyObservers("CANCELLED", reservation);
    }
    public void modifyReservation(Reservation reservation, Flight oldFlight, Flight newFlight){
        if (!newFlight.hasAvaliableSeats()){
            throw new IllegalStateException("Flight is full");
        }

        oldFlight.releaseSeat();
        newFlight.reserveSeat();

        reservation.modify(newFlight.getFlightId());
        notifyObservers("MODIFIED", reservation);
    }
}
