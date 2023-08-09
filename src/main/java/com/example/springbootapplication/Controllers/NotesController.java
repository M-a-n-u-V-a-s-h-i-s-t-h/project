package com.example.springbootapplication.Controllers;
import com.example.springbootapplication.DTO.CreateNoteDTO;
import com.example.springbootapplication.DTO.CreateNoteResponseDTO;
import com.example.springbootapplication.Entities.NoteEntity;
import com.example.springbootapplication.service.NotesService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class NotesController {

    private NotesService notesService;

    public NotesController(NotesService notesService) {
        this.notesService = notesService;
    }

  @GetMapping("/{taskId}/notes")
    public ResponseEntity<List<NoteEntity>> getNotes(@PathVariable("taskId") Integer taskId) {
        var notes = notesService.getNotesForTask(taskId);

        return ResponseEntity.ok(notes);
    }

    @PostMapping("/{taskId}/notes")
    public ResponseEntity<CreateNoteResponseDTO> addNote(
            @PathVariable("taskId") Integer taskId,
            @RequestBody CreateNoteDTO body
    ) {
        var note = notesService.addNoteForTask(taskId, body.getTitle(), body.getBody());

        return ResponseEntity.ok(new CreateNoteResponseDTO(taskId, note));
    }
}