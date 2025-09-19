package controller;

import model.Dictionary;
import view.DictionaryView;

import java.util.HashMap;

public class DictionaryController {
    private DictionaryView gui;
    private Dictionary dict = new Dictionary(new HashMap<String,String>());

    public DictionaryController(DictionaryView dictionaryView) {
        this.gui = dictionaryView;
        dict.addWord("cat","not a dog");
    }

    public String find(String text){
        return dict.getEx(text);
    }
}
