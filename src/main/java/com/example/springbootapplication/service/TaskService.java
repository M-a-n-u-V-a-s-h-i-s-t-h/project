package com.example.springbootapplication.service;


import com.example.springbootapplication.Entities.TaskEntity;
import com.example.springbootapplication.Repository.TaskRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@Slf4j
public class TaskService {
   // private ArrayList<TaskEntity> tasks = new ArrayList<>();
    @Autowired
    TaskRepository T;
    private int taskId = 1;

    private final SimpleDateFormat deadlineFormatter = new SimpleDateFormat("yyyy-MM-dd");

    //public TaskEntity addTask(String title, String description , String deadline) throws ParseException {
        public TaskEntity addTask(String title, String description , String deadline) throws ParseException  {
      /* // DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
      //  Date date =null;
        try {
            date = formatter.parse(deadline);
            task.setDeadline(deadlineFormatter.parse(deadline));

        }
        catch (ParseException e)
        {
           log.error("not able to parse date");
            //date= null;
        }*/
        TaskEntity task =  TaskEntity.builder()
               .id(taskId)
                .title(title)
                .description(description)
                .deadline((deadlineFormatter.parse(deadline)))
                .completed(false)
                .notes(new ArrayList<>())
                .build();
        T.save(task);
           // task.setNotes(new ArrayList<>());

        taskId++;
        return null;}
    public List<TaskEntity> getTasks() {
        return T.findAll();
    }

    public TaskEntity getTaskById(int id) {

       return T.findById(id).get();
        }



    public TaskEntity updateTask(int id, String description, String deadline, Boolean completed) throws ParseException {
        TaskEntity task = getTaskById(id);
        if (task == null) {
            return null;
        }
        if (description != null) {
            task.setDescription(description);
        }
        if (deadline != null) {
            task.setDeadline(deadlineFormatter.parse(deadline));
        }
        if (completed != null) {
            task.setCompleted(completed);
        }
        return task;
    }
}