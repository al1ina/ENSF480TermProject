package src.business;
public class User {
    private int userId;
    private String name;
    private String password;

    public User(int userId, String name, String password) {
        this.userId = userId;
        this.name = name;
        this.password = password;
    }
    public void login(String email, String password) {
        if (email == null || password == null || email.isBlank() || password.isBlank()) {
            throw new IllegalArgumentException("Email and password are required.");
        }
        // User user = userData.findByEmail(email.trim().toLowerCase()).filter(password == password)

    }
    public void logout() {
        
    }
    public void getRole() {

    }
    public String getName() {
        return name;
    }
    public String getPassword() {
        return password;
    }
}
