package com.example.springbootapplication.Entities;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
@Setter
@Getter
@Builder
@Entity
@Table(name = "roles")
public class JPARole {


        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private long id;

        @Column(length = 60)
        private String name;
    }

