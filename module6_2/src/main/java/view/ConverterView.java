package view;


import controller.ConverterController;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.util.Set;

public class ConverterView extends Application {
    private ConverterController controller;

    public void start(Stage stage){

        ChoiceBox<String> choiceBoxFrom = new ChoiceBox<>();
        ChoiceBox<String> choiceBoxTo = new ChoiceBox<>();

        TextField amount = new TextField();
        Label result = new Label("0");
        Button convert = new Button("convert");

        Label equals = new Label(" = ");
        Label error = new Label();

        Set<String> copy = ConverterController.getKeys();

        for(String key: copy){
            choiceBoxFrom.getItems().add(key);
            choiceBoxTo.getItems().add(key);
        }
        stage.setTitle("currency converter");

        GridPane pane = new GridPane();

        pane.add(amount,0,1);
        pane.add(choiceBoxFrom,1,1);

        pane.add(equals,2,1);
        pane.add(result,3,1);
        pane.add(choiceBoxTo,4,1);

        pane.add(convert,5,1);

        pane.add(error,0,2);

        Scene scene = new Scene(pane);
        stage.setScene(scene);

        stage.setWidth(500);
        stage.show();

        convert.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                String from = choiceBoxFrom.getValue();
                String to = choiceBoxTo.getValue();

                if(from == null || to == null){
                    error.setText("choose currencies!");
                    return;
                }
                try{
                    double amountdouble = Double.parseDouble(amount.getText());
                    result.setText(Double.toString(controller.getAmount(from,to,amountdouble)));
                    error.setText("");
                }catch(Exception e){
                    error.setText("input a double!");
                    return;
                }


            }
        });



        stage.show();
    }
    public void init() {
        controller = new ConverterController(this);
    }
}
