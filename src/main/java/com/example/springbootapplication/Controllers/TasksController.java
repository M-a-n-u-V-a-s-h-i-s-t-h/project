
package com.example.springbootapplication.Controllers;

import com.example.springbootapplication.DTO.CreateTaskDTO;
import com.example.springbootapplication.DTO.ErrorResponseDTO;
import com.example.springbootapplication.DTO.UpdateTaskDTO;
import com.example.springbootapplication.Entities.ProjectResponse;
import com.example.springbootapplication.Entities.TaskEntity;
import com.example.springbootapplication.service.TaskService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;



@RestController
@RequestMapping("/tasks")
public class TasksController {
 private final TaskService taskService;

    public TasksController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping("")
    public ResponseEntity<List<TaskEntity>> getTasks() {
        var tasks = taskService.getTasks();

        return ResponseEntity.ok(tasks);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProjectResponse> getTaskById(@PathVariable("id") Integer id) {
        TaskEntity task = taskService.getTaskById(id);
        if (task == null) {

            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(ProjectResponse.builder()
                            .code(HttpStatus.BAD_REQUEST.value())
                            .message("No data found for the given Id")
                            .build());
        }

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(ProjectResponse.builder()
                        .code(HttpStatus.OK.value())
                        .data(task)
                        .build());
    }

    @PostMapping("/add")
    public ResponseEntity<ProjectResponse> addTask(@RequestBody CreateTaskDTO body) throws ParseException {
        taskService.addTask(body.getTitle(), body.getDescription(), body.getDeadline());

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(ProjectResponse.builder()
                        .code(HttpStatus.OK.value())
                        .message("Data store succesfully")
                        .build());
    }
    @PatchMapping("/{id}")
    public ResponseEntity<TaskEntity> updateTask(@PathVariable("id") Integer id, @RequestBody UpdateTaskDTO body) throws ParseException {
        var task = taskService.updateTask(id, body.getDescription(), body.getDeadline(), body.getCompleted());

        if (task == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(task);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponseDTO> handleErrors(Exception e) {
        if (e instanceof ParseException) {
            return ResponseEntity.badRequest().body(new ErrorResponseDTO("Invalid date format"));
        }
        e.printStackTrace();
        return ResponseEntity.internalServerError().body(new ErrorResponseDTO("Internal Server Error"));
    }

}