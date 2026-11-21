package src.business;
import java.util.List;


import src.data.FlightData;


public class SystemAdministrator extends User{
    private FlightData flightData;
    public SystemAdministrator(int userId, String name, String password) {
        super(userId, name, password);
    }
    public void addFlight(Flight flight) {
        flightData.addFlight(flight);
    }
    public void updateFlight(Flight flight) {
        flightData.updateFlight(flight);
    }
    public void removeFlight(Flight flight) {
        flightData.removeFlight(flight);
    }
}
