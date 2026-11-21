package src.business;

import src.data.FlightAgentData;

public class FlightAgent extends User{
    private FlightAgentData flightAgentData;
    
    public FlightAgent(int userId, String name, String password) {
        super(userId, name, password);
    }

    public void modifyReservations() {

    }
    public void viewSchedule() {
        
    }
    public void addNewCustomer(Customer customer) {
        flightAgentData.addNewCustomer(customer);
    }
    public void modifyCustomer(Customer customer) {
        flightAgentData.modifyCustomer(customer);
    }
}