package com.mcelrea.bugworld;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.ArrayList;

public class Main extends Application {

    World world = new World();

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Bug World");
        Group root = new Group();
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        Canvas canvas = new Canvas(800,600);
        root.getChildren().add(canvas);
        GraphicsContext gc = canvas.getGraphicsContext2D();

        //world.addActor(new Actor(10,10,"images/actor.png", world));
        //world.addActor(new Actor(5,10,"images/actor.png", world));
        //world.addActor(new Actor(10,5,"images/actor.png", world));
        //world.addActor(new Actor(0,0,"images/actor.png", world));
        //world.addActor(new Bug(15,0,"images/bug.png", world));
        world.addActor(new Bug(15,10,"images/bug.png", world));
        Bug b = new Bug(0,10,"images/bug.png", world);
        b.setDir(Location.SOUTH);
        world.addActor(b);

        new AnimationTimer() {
            @Override
            public void handle(long now) {
                //clear screen
                gc.setFill(Color.WHITE);
                gc.fillRect(0,0,800,600);

                world.step();
                world.draw(gc);

                //sleep at end of cycle
                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.start();

        //last line of code
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
