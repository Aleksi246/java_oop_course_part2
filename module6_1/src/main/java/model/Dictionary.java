package model;

import java.util.HashMap;

public class Dictionary {
    //words are keys and explanations are the values in hashmap<key,value>
    private static HashMap<String,String> dict;

    public Dictionary(HashMap<String,String> dict){
        this.dict = dict;
    }

    public void addWord(String word,String explanation){
        dict.put(word,explanation);
    }
    public String getEx(String key){
        return dict.get(key);
    }

}
