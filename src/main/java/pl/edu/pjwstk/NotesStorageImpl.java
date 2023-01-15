package pl.edu.pjwstk;

import java.util.ArrayList;
import java.util.List;

public class NotesStorageImpl implements NotesStorage {
    private List<Note> notes = new ArrayList<>();

    @Override
    public void add(Note note) {
        notes.add(note);
    }

    @Override
    public List<Note> getAllNotesOf(String name) {
        List<Note> result = new ArrayList<>();
        for (Note note : notes) {
            if (note.getName().equals(name)) {
                result.add(note);
            }
        }
        return result;
    }

    @Override
    public void clear() {
        notes.clear();
    }
}
