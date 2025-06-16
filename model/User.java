package model;

public class User{
    protected String username;
    protected String password;
    protected String role;

    public User(String username, String password, String role) {
        this.username = username;
        this.password = password;
        this.role = role; // Role isinya "mahasiswa" atau "admin"
    }

    // getter username
    public String getUsername() {
        return username;
    }

    public boolean checkPassword(String inputPassword) {
        return password.equals(inputPassword);
    }

    // role getter
    public String getRole() {
        return role;
    }
}
