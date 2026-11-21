package src.data;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.management.RuntimeErrorException;

import src.business.Customer;

public class FlightAgentData {
    public void addNewCustomer(Customer customer) {
        String sql =
        """
        INSERT INTO USERS (name, password, role)
        VALUES (?,  ?, ?)
        """;

        try(Connection conn = DatabaseManager.getInstance().getConnection();
        PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, customer.getName());
            ps.setString(2, customer.getPassword());
            ps.setString(3, "CUSTOMER");
        } catch (SQLException e) {
            throw new RuntimeException("Could not add customer", e);
        }
    }
    public void modifyCustomer(Customer customer) {
        String sql =
        """
        UPDATE USERS SET name = ?, password = ? 
        WHERE user_id = ?
        """;
        try(Connection conn = DatabaseManager.getInstance().getConnection()
        PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, customer.getName());
            ps.setString(2, customer.getPassword());
            ps.setString(3, customer.getUserId());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Could not modify customer details");
        }
    }
}
