package controller;

import model.Pet;
import view.PetView;

public class PetController {
    private PetView view;

    private Pet pet = new Pet(0,0);
    private double targetX = 0;
    private double targetY = 0;

    private boolean mouseinsidecanvas = false;



    public PetController(PetView petView) {
        this.view = petView;
    }

    public void setTarget(double x, double y){
        this.targetX = x;
        this.targetY = y;
    }

    public void updateLocation(){

        if(mouseinsidecanvas){
        double dx = targetX - pet.getX();
        double dy = targetY - pet.getY();
        double distance = Math.sqrt(dx * dx + dy * dy);

        pet.move(pet.getX()+(dx/100),pet.getY()+(dy/100));
        }
    }
    public double getPetX(){
        return pet.getX();
    }
    public double getPetY(){
        return pet.getY();
    }

    public void mousesettrue(){
        mouseinsidecanvas = true;
    }
    public void mousesetfalse(){
        mouseinsidecanvas = false;
    }


}
