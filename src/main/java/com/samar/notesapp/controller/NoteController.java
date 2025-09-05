package com.samar.notesapp.controller;

import com.samar.notesapp.model.Note;
import com.samar.notesapp.service.NoteService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.aggregation.ArrayOperators;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/notes")
@CrossOrigin(origins = {"http://localhost:5173","http://localhost:3000"})
public class NoteController {
    @Autowired
    private NoteService noteService;

    @GetMapping
    public ResponseEntity<List<Note>> getAllNotes(){
        List<Note> notes=noteService.getAllNotes();
        if(notes!=null){
            return new ResponseEntity<>(notes,HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Note> getNote(@PathVariable String id){
        Note note=noteService.getNote(id);
        if(note!=null)
            return new ResponseEntity<>(note,HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @PostMapping
    public ResponseEntity<?> createNote(@RequestBody Note note){
        noteService.createNote(note);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateNote(@PathVariable String id,@RequestBody Note note){
        noteService.updateNote(id,note);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteNote(@PathVariable String id){
        noteService.deleteNote(id);
        return  new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

}
