package com.project.project1.Entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TaskEntity {
    private int id;
    private String title;
    private String description;
    private Date deadline; //TODO PARSING
    private boolean completed;
}