package pl.edu.pjwstk;

import java.util.List;

public interface NotesStorage {
    void add(Note note);
    List<Note> getAllNotesOf(String name);
    void clear();
}