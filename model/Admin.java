package model;

public class Admin extends User {
    public Admin(String username, String password) {
        super(username, password, "admin");
    }

    public void manageSystem() {
        System.out.println("Admin privileges accessed.");
    }
}
