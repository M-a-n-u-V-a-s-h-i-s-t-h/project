package com.example.springbootapplication.Repository;
import com.example.springbootapplication.Entities.JPAUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

    public interface UserRepository extends JpaRepository<JPAUser, Long> {
        Optional<JPAUser> findByEmail(String email);
        Optional<JPAUser> findByUsernameOrEmail(String username, String email);
        Optional<JPAUser> findByUsername(String username);
        Boolean existsByUsername(String username);
        Boolean existsByEmail(String email);
    }

