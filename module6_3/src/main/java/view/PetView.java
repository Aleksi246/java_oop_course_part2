package view;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import controller.PetController;
import model.Pet;

public class PetView extends Application {

    private Canvas canvas = new Canvas(1500, 1000);

    private GraphicsContext gc = canvas.getGraphicsContext2D();
    private Image image = new Image("frog.png");
    private PetController controller;


    // no idea how this actually works shamelesly stolen drom internet
    private AnimationTimer timer = new AnimationTimer() {
        public void handle(long now) {
            controller.updateLocation();

            gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());

            gc.drawImage(image, controller.getPetX() - image.getWidth() / 2, controller.getPetY()- image.getHeight() / 2);
        }
    };

    public void init() {
        controller = new PetController(this);
    }

    public void start(Stage primaryStage) {
        StackPane root = new StackPane(canvas);
        Scene scene = new Scene(root, 1500, 1000);

        primaryStage.setTitle("Park");

        primaryStage.setScene(scene);
        primaryStage.show();

        canvas.setOnMouseMoved(event -> {
            //should set new target for pet

            double x = event.getX();
            double y = event.getY();

            controller.setTarget(x,y);
        });
        scene.setOnMouseEntered(event -> {
            controller.mousesettrue();
        });

        scene.setOnMouseExited(event -> {
            controller.mousesetfalse();
        });


        timer.start();
    }

}