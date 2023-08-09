package com.example.springbootapplication.Entities;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table
public class TaskEntity {
    @Id
    private Integer id;
    private String title;
    private String description;
    private Date deadline;
    private boolean completed;
    @OneToMany
    private List<NoteEntity> notes;
}