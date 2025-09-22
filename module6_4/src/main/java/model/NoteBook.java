package model;

import java.util.ArrayList;
import java.util.Objects;

public class NoteBook {
    private ArrayList<Note> notebook;

    public NoteBook(ArrayList<Note> notebook){
        this.notebook = notebook;
    }

    public void add(Note note){
        notebook.add(note);
    }

    public Note get(String title){
        for(Note note: notebook){
            if(Objects.equals(note.getTitle(), title)){
                return note;
            }
        }
        return null;
    }
    public ArrayList<Note> getList(){
        return notebook;
    }

}
