package pl.edu.pjwstk;

public class Note {
    private String name;
    private float note;

    public Note(String name, float note) {
        this.name = name;
        this.note = note;
    }

    public String getName() {
        return name;
    }

    public float getNote() {
        return note;
    }
}

