package pl.edu.pjwstk;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.easymock.EasyMock.*;
import static org.junit.jupiter.api.Assertions.*;

public class NotesServiceImplTest {
    private NotesStorage storage = new NotesStorageImpl();
    private NotesService service = NotesServiceImpl.createWith(storage);

    @Test
    public void addNoteTest() {
        NotesStorage storage = createMock(NotesStorage.class);
        NotesService service = NotesServiceImpl.createWith(storage);

        Note note = new Note("John", 3.5f);
        storage.add(note);
        expectLastCall();
        replay(storage);

        service.add(note);

        verify(storage);
    }

    @Test
    public void averageNoteTest() {
        NotesStorage storage = createMock(NotesStorage.class);
        NotesService service = NotesServiceImpl.createWith(storage);

        Note note1 = new Note("John", 3.5f);
        Note note2 = new Note("John", 4.5f);
        Note note3 = new Note("John", 2.5f);
        List<Note> notes = Arrays.asList(note1, note2, note3);

        expect(storage.getAllNotesOf("John")).andReturn(notes);
        replay(storage);

        float average = service.averageOf("John");
        assertEquals(3.5f, average, 0.001);

        verify(storage);
    }

    @Test
    public void clearNotesTest() {
        NotesStorage storage = createMock(NotesStorage.class);
        NotesService service = NotesServiceImpl.createWith(storage);

        storage.clear();
        expectLastCall();
        replay(storage);

        service.clear();

        verify(storage);
    }


    @Test
    public void noNotesForUserTest() {
        NotesStorage storage = createMock(NotesStorage.class);
        NotesService service = NotesServiceImpl.createWith(storage);

        expect(storage.getAllNotesOf("John")).andReturn(new ArrayList<Note>());
        replay(storage);

        float average = service.averageOf("John");
        assertEquals(Float.NaN, average, 0.01f);

        verify(storage);

    }
}
