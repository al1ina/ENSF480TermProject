package src.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import src.business.Flight;

public class FlightData {
    public List<Flight> findFlights(String origin, String destination, LocalDate date, String airline) throws SQLException {
        List<Flight> results = new ArrayList<>();
        String sql =
        """
        SELECT * FROM FLIGHTS WHERE origin = ? AND destination = ?
        AND flight_date = ? AND (? IS NULL OR airline = ?)
        """;
        try(Connection conn = DatabaseManager.getInstance().getConnection();
        PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, origin);
            ps.setString(2, destination);
            ps.setString(3, date.toString());
            ps.setString(4, airline);
            ps.setString(5, airline);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Flight flight = new Flight(rs.getInt("flight_id"), rs.getString("airline"), rs.getString("origin"), rs.getString("destination"), rs.getDate("flight_date").toLocalDate(), rs.getString("time"));
                    results.add(flight);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Flight search failed", e);
        }
        return results;
    }
    public void addFlight(Flight flight) {
        int flight_number = flight.getFlightId();
        String airline = flight.getAirline();
        String destination = flight.getDestination();
        String origin = flight.getOrigin();
        String date = flight.getDate().toString();
        double price = flight.getPrice();
        String sql = 
        """
        INSERT INTO FLIGHTS (flight_number, destination, origin, airline, date, price)
        VALUES (?, ?, ?, ?, ?, ?)
        """;

        try(Connection conn = DatabaseManager.getInstance().getConnection();
        PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, flight_number);
            ps.setString(2, destination);
            ps.setString(3, origin);
            ps.setString(4, airline);
            ps.setString(5, date);
            ps.setDouble(6, price);
            ps.setString(7, flight.getTime());
        } catch (SQLException e) {
            throw new RuntimeException("Could not add flight", e);
        }
    }
    public void removeFlight(Flight flight) {
        int flightId = flight.getFlightId();
        String sql = 
        """
        DELETE FROM FLIGHTS WHERE flight_id = ?
        """;

        try(Connection conn = DatabaseManager.getInstance().getConnection();
        PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, flightId);
            int rowsAffected = ps.executeUpdate();
            if (rowsAffected != 1) {
                throw new RuntimeException("Could not delete flight.");
            }
        } catch (SQLException e) {
            throw new RuntimeException("Flight deletion failed", e);
        }
    }
    public void updateFlight(Flight flight) {
        String sql = 
        """
        UPDATE FLIGHTS SET origin = ?, destination = ?, airline = ?, date = ?, price = ?, time = ?
        WHERE flight_id = ?
        """;
        try(Connection conn = DatabaseManager.getInstance().getConnection();
        PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, flight.getFlightId());
            ps.setString(2, flight.getDestination());
            ps.setString(3, flight.getOrigin());
            ps.setString(4, flight.getAirline());
            ps.setString(5, flight.getDate().toString());
            ps.setDouble(6, flight.getPrice());
            ps.setString(7, flight.getTime());
            ps.executeUpdate();
        } 
        catch (SQLException e) {
            throw new RuntimeException("Could not modify flight", e);
        }
    }
}
