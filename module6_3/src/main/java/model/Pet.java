package model;

import javafx.util.Pair;

public class Pet {
    public double x;
    public double y;

    public Pet(double x, double y){
        this.x = x;
        this.y = y;
    }

    //50 50 to 890 570

    public void move(double tox, double toy){
        this.x = tox;
        this.y = toy;
    }
    public double getX(){
        return this.x;
    }
    public double getY(){
        return this.y;
    }
}
