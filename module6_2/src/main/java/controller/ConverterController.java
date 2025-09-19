package controller;

import model.Converter;
import view.ConverterView;

import java.util.Set;

public class ConverterController {
    private ConverterView view;
    private static Converter conv = new Converter();

    public ConverterController(ConverterView view){
        this.view = view;
    }

    public double getAmount(String from, String to, double amountOfFrom){
        return conv.getAmount(from,to,amountOfFrom);
    }
    public static Set getKeys(){
        return conv.getKeys();
    }

}
