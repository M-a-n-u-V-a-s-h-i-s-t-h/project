package com.example.springbootapplication.Repository;
import com.example.springbootapplication.DTO.CreateTaskDTO;
import com.example.springbootapplication.DTO.ErrorResponseDTO;
import com.example.springbootapplication.DTO.TaskResponseDTO;
import com.example.springbootapplication.DTO.UpdateTaskDTO;
import com.example.springbootapplication.Entities.NoteEntity;
import com.example.springbootapplication.Entities.ProjectResponse;
import com.example.springbootapplication.Entities.TaskEntity;
import com.example.springbootapplication.service.NotesService;
import com.example.springbootapplication.service.TaskService;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;
@Repository
public interface TaskRepository extends JpaRepository<TaskEntity, Integer>
{

}