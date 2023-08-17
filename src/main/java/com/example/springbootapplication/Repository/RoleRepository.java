package com.example.springbootapplication.Repository;
import com.example.springbootapplication.Entities.JPARole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<JPARole, Long> {
        Optional<JPARole> findByName(String name);
    }

