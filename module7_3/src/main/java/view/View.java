package view;


import controller.Controller;
import dao.CurDao;
import entity.Transaction;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import entity.Currency;
import java.math.BigDecimal;

import java.util.List;
import java.util.Set;

public class View extends Application {
    private Controller controller;

    public void start(Stage stage){

        Currency cur1 = new Currency("USD","united states dollar",new BigDecimal("1.0"));
        controller.update(cur1);
        Currency cur2 = new Currency("EUR","euro",new BigDecimal("0.85"));
        controller.update(cur2);
        Currency cur3 = new Currency("GBP","pound sterling",new BigDecimal("0.74"));
        controller.update(cur3);

        ChoiceBox<String> choiceBoxFrom = new ChoiceBox<>();
        ChoiceBox<String> choiceBoxTo = new ChoiceBox<>();

        TextField amount = new TextField();
        Label result = new Label("0");
        Button convert = new Button("convert");

        Button add = new Button("+");

        Label equals = new Label(" = ");
        Label error = new Label();

        List<String> copy = Controller.getKeys();

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
        pane.add(add,6,1);

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
                    BigDecimal amountdouble = new BigDecimal(amount.getText());
                    result.setText((controller.getAmount(from,to,amountdouble)).toString());
                    Transaction tra = new Transaction((amount.getText() + " " + from + " = " + (controller.getAmount(from,to,amountdouble)).toString() + " " + to));
                    controller.updatet(tra);
                    error.setText("");
                }catch(Exception e){
                    error.setText("input a double!");
                    return;
                }


            }
        });

        add.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                Stage newStage = new Stage();

                Button addtodatabase = new Button("add to database");
                TextField conversionratetoeur = new TextField();
                conversionratetoeur.setPromptText("conversion rate ro EUR");
                TextField abriviation = new TextField();
                abriviation.setPromptText("abreviation");
                TextField name = new TextField();
                name.setPromptText("name of currency");

                Label error2 = new Label();

                GridPane pane2 = new GridPane();

                pane2.add(conversionratetoeur,1,0);
                pane2.add(abriviation,2,0);
                pane2.add(name,3,0);
                pane2.add(addtodatabase,4,0);
                pane2.add(error2,1,1);

                Scene newscene = new Scene(pane2);
                newStage.setScene(newscene);

                newStage.setWidth(500);
                newStage.show();

                addtodatabase.setOnAction(new EventHandler<ActionEvent>() {
                    public void handle(ActionEvent event) {
                        String ab = abriviation.getText();
                        String na = name.getText();
                        String bds =conversionratetoeur.getText();

                        if(ab == "" || na == "" || bds == ""){
                            error2.setText("fill all boxes!!!");
                            return;
                        }
                        try {
                            BigDecimal bd = new BigDecimal(bds);
                            Currency cur = new Currency(abriviation.getText(),name.getText(),bd);
                            controller.update(cur);

                        }catch(Exception e){
                            error2.setText("conversion rate wrong format");
                            return;
                        }


                        List<String> copy = Controller.getKeys();
                        choiceBoxFrom.getItems().clear();
                        choiceBoxTo.getItems().clear();

                        for(String key: copy){
                            choiceBoxFrom.getItems().add(key);
                            choiceBoxTo.getItems().add(key);
                        }
                        newStage.close();


                    }
                });

            }
        });



        stage.show();
    }
    public void init() {
        controller = new Controller(this);
    }
}
