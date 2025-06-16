package com.kelompok5.taskhub.service;

import com.kelompok5.taskhub.model.Users;
import com.kelompok5.taskhub.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;

//    .csrf().disable() //  CSRF di matiin buat pake form login manual
//    .formLogin().disable() // Matiin login dari SecuritySpringboot
//      Ini gunanya buat service kalo login nya error
    public boolean login(String username, String password) {
        Users user = userRepository.findByUsername(username.trim());
        if (user == null) {
            System.out.println("❌ Username tidak ditemukan: " + username);
            return false;
        }

        return user.getPassword().equals(password.trim());
    }
}
