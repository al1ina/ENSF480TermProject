package src.business;

public interface ReservationObserver {
    public void update(String message, Reservation reservation);
}
