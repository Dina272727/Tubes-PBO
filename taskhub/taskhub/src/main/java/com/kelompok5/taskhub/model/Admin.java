package com.kelompok5.taskhub.model;

public class Admin extends Users {
    public Admin(String username, String password ,String email) {
        super(username, email, password, "admin");
    }

    public void manageSystem() {
        System.out.println("Admin privileges accessed.");
    }
}
