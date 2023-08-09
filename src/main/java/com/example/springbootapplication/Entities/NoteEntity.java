package com.example.springbootapplication.Entities;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
@Entity
@Table
public class NoteEntity {
    @Id
    private Integer id;
    private String title;
    private String body;
    @ManyToOne
    private TaskEntity tasks;
}