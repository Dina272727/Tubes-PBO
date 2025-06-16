package service;

import model.User;
import model.Admin;
import java.util.ArrayList;
import java.util.List;

public class AuthService {
    private List<User> users = new ArrayList<>();

    // Register User baru
    public boolean register(String username, String password, String role) {
        if (getUserByUsername(username) != null) {
            return false; // akan direturn false apabila username sudah digunakan
        }
        if (role.equalsIgnoreCase("admin")) {
            users.add(new Admin(username, password)); // apabila rolenya admin maka akan ditambahkan admin baru
        } else {
            users.add(new User(username, password, "mahasiswa")); // apabila rolenya mahasiswa
        }
        return true;
    }

    public User login(String username, String password) {
        User user = getUserByUsername(username);
        if (user != null && user.checkPassword(password)) {
            return user;
        }
        return null;
    }

    // function mencara user berdasarkan username
    private User getUserByUsername(String username) {
        for (User u : users) {
            if (u.getUsername().equals(username)) {
                return u;
            }
        }
        return null;
    }
}
