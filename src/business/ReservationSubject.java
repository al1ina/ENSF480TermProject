package src.business;

public interface ReservationSubject {
    void attach(ReservationObserver observer);
    void detach(ReservationObserver observer);
    void notifyObservers(String message);
}
