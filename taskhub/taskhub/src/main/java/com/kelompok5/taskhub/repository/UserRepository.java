package com.kelompok5.taskhub.repository;

import com.kelompok5.taskhub.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Users, Long> {
    Users findByUsername(String username);
}