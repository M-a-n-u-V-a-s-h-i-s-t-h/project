package com.example.springbootapplication.service;


import com.example.springbootapplication.Entities.TaskEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

@Service
@Slf4j
public class TaskService {
    private ArrayList<TaskEntity> tasks = new ArrayList<>();
    private int taskId = 1;

    public void addTask(String title, String description , String deadline)  {
        DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        Date date =null;
        try {
             date = formatter.parse(deadline);
        }
        catch (ParseException e)
        {
           log.error("not able to parse date");
            date= null;
        }
        TaskEntity task =  TaskEntity.builder()
                .id(taskId)
                .title(title)
                .description(description)
                .deadline(date)
                .completed(false)
                .build();
        tasks.add(task);
        taskId++;
    }

    public ArrayList<TaskEntity> getTasks() {
        return tasks;
    }

    public TaskEntity getTaskById(int id) {
        for (TaskEntity task : tasks) {
            if (task.getId() == id) {
                return task;
            }
        }
        return null;
    }
}