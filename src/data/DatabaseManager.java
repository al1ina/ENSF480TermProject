package src.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

//singleton!!
public class DatabaseManager {
    private static DatabaseManager instance;
    private final String url = "jdbc:sqlite:flightManagmentSystem.db";

    private DatabaseManager() {}

    public static DatabaseManager getInstance() {
        if(instance == null) {
            instance = new DatabaseManager();
        }
        return instance;
    }
    public Connection getConnection() throws SQLException {
        Connection c = DriverManager.getConnection(url);
        try (Statement s = c.createStatement()) {
            // s.execute
        }
        return c;
    }

}
