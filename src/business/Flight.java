package src.business;
import java.sql.Time;
import java.time.LocalDate;

public class Flight {
    private int flightId;
    private int availableSeats;
    private String airline;
    private LocalDate date;
    private String origin;
    private String destination;
    private double price;
    private String time;

    public Flight(int flightId, String airline, String origin, String destination, LocalDate date, String time) {
        this.flightId = flightId;
        this.airline = airline;
        this.origin = origin;
        this.destination = destination;
        this.date = date;
        this.time = time;
    }
    public int getAvaliableSeats() {
        return availableSeats;
    }
    public int getFlightId() {
        return flightId;
    }
    public String getAirline() {
        return airline;
    }
    public LocalDate getDate() {
        return date;
    }
    public double getPrice() {
        return price;
    }
    public String getDestination() {
        return destination;
    }
    public String getOrigin() {
        return origin;
    }
    public String getTime() {
        return time;
    }

}
