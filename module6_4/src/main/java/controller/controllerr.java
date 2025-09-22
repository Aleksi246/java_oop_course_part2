package controller;

import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import model.Note;
import model.NoteBook;
import view.vieww;
import javafx.fxml.FXML;


import java.util.ArrayList;
import java.util.Locale;

public class controllerr {

    NoteBook notebook = new NoteBook(new ArrayList<Note>());

    @FXML
    private TextField title;

    @FXML
    private TextArea text;

    @FXML
    private ScrollPane scroll;

    @FXML
    private VBox vbox;


    @FXML
    public void onButtonPress(MouseEvent event){
        Note note = new Note(title.getText(),text.getText());
        notebook.add(note);

        Label notelabel = new Label("Title: " + note.getTitle() + "\n" + note.getText());

        vbox.getChildren().add(0,notelabel);
    }

    public static void main(String[] args) {
        vieww.launch(vieww.class);
    }
}
