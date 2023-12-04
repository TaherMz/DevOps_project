package com.example.devopsproject.repps;


import com.example.devopsproject.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findByRoleu(String roleu);
}
