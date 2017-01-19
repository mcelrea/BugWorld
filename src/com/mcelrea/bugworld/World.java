package com.mcelrea.bugworld;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.util.ArrayList;

public class World {
    Actor[][] actors = new Actor[20][20];

    public void addActor(Actor a) {
        actors[a.getRow()][a.getCol()] = a;
    }

    public void step() {
        //make all Actors act
        for(int i=0; i < actors.length; i++) {
            for(int j=0; j < actors[i].length; j++) {
                if(actors[i][j] != null)
                    actors[i][j].act();
            }
        }
    }

    public void draw(GraphicsContext gc) {
        gc.setStroke(Color.BLACK);//choose a color
        //draw all actors and lines
        for(int i=0; i < actors.length; i++) {
            gc.strokeLine(0,i*25,20*25,i*25);//line
            gc.strokeLine(i*25,0,i*25,20*25);//line
            for(int j=0; j < actors[i].length; j++) {
                if(actors[i][j] != null)
                    actors[i][j].draw(gc);//draw that thing!
            }
        }

        //one more line!!!!!!!!!!!
        gc.strokeLine(0,20*25,20*25,20*25);
        gc.strokeLine(20*25,0,20*25,20*25);
    }

    public boolean isValid(Location loc) {
        return loc.getRow() >= 0 && loc.getRow() < actors.length &&
                loc.getCol() >= 0 && loc.getRow() < actors[loc.getRow()].length;
    }
}
