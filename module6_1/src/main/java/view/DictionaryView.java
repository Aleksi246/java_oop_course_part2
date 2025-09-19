package view;

import controller.DictionaryController;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.event.EventHandler;
import javafx.scene.layout.FlowPane;


public class DictionaryView extends Application {
    private DictionaryController controller;

    public void start(Stage stage) {

        TextField search = new TextField("");
        Label explanation = new Label("explanation");

        Button searchButton = new Button("search");
        FlowPane pane = new FlowPane();

        stage.setTitle("dictionary");

        pane.getChildren().add(search);
        pane.getChildren().add(searchButton);
        pane.getChildren().add(explanation);
        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();

        searchButton.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                if(search.getText() == ""){
                    explanation.setText("input a word");
                }
                else if(controller.find(search.getText()) == null){
                    explanation.setText("word not in dictionary");
                }else{
                explanation.setText(controller.find(search.getText()));
            }
            }
        });

        stage.show();
    }

    public void init() {
        controller = new DictionaryController(this);
    }

}