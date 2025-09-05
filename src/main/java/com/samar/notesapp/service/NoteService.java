package com.samar.notesapp.service;

import com.samar.notesapp.model.Note;
import com.samar.notesapp.repository.NotesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NoteService {
    @Autowired
    private NotesRepository notesRepository;
    public List<Note> getAllNotes() {
        List<Note> notes=notesRepository.findAll();
        return notes;
    }

    public void createNote(Note note) {
        notesRepository.save(note);
    }

    public Note getNote(String id) {
        Optional<Note> note=notesRepository.findById(id);
        return note.get();
    }

    public void updateNote(String id, Note note) {
        Note old=notesRepository.findById(id).get();
        if(old!=null){
            old.setTitle(note.getTitle() != null && !note.getTitle().equals("") ? note.getTitle() : old.getTitle());
            old.setContent(note.getContent() != null && !note.getContent().equals("") ? note.getContent() : old.getContent());
            notesRepository.save(old);
        }

    }

    public void deleteNote(String id) {
        notesRepository.deleteById(id);
    }
}
