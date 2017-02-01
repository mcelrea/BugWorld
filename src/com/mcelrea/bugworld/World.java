package com.mcelrea.bugworld;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.util.ArrayList;


public class World {
    int time = 1;
    Actor[][] actors = new Actor[20][20];

    public void addActor(Actor a) {
        actors[a.getMyLoc().getRow()][a.getMyLoc().getCol()] = a;
    }

    public void step() {
        //make all Actors act
        ArrayList<Actor> allActors = getAllActors();
        for(int i=0; i < allActors.size(); i++) {
            allActors.get(i).act();
        }
    }

    public Actor getActorAtLoc(Location loc) {
        if(isValid(loc)) {
            return actors[loc.getRow()][loc.getCol()];
        }
        return null;
    }

    public ArrayList<Actor> getAllActors() {
        ArrayList<Actor> list = new ArrayList<Actor>();

        for(int i=0; i < actors.length; i++) {
            for(int j=0; j < actors[i].length; j++) {
                if(actors[i][j] != null) {
                    list.add(actors[i][j]);
                }
            }
        }
        return list;
    }

    public ArrayList<Actor> getNeighbors(Location loc) {
        ArrayList<Actor> list = new ArrayList<Actor>();
        for(int row=loc.getRow()-1; row <= loc.getRow()+1; row++) {
            for(int col=loc.getCol()-1; col <= loc.getCol()+1; col++) {
                Location temp = new Location(row,col);
                if(isValid(temp) && row != loc.getRow() && col != loc.getCol()) {//this location exists
                    Actor a = actors[row][col];
                    if(a != null) { //if there is an actor
                        list.add(a);
                    }
                }
            }
        }
        return list;
    }

    public ArrayList<Location> getEmptyLocsAround(Location loc) {
        ArrayList<Location> list = new ArrayList<Location>();
        for(int row=loc.getRow()-1; row <= loc.getRow()+1; row++) {
            for(int col=loc.getCol()-1; col <= loc.getCol()+1; col++) {
                Location temp = new Location(row,col);
                if(isValid(temp) && row != loc.getRow() && col != loc.getCol()) {//this location exists
                    Actor a = actors[row][col];
                    if(a == null || a instanceof Flower) { //if its empty or a Flower
                        list.add(temp);
                    }
                }
            }
        }
        return list;
    }

    public void removeActor(Actor a) {
        actors[a.getMyLoc().getRow()][a.getMyLoc().getCol()] = null;
    }

    public void changeActorLoc(Actor a, Location newLoc) {
        actors[newLoc.getRow()][newLoc.getCol()] = null;
        actors[a.getMyLoc().getRow()][a.getMyLoc().getCol()] = null;
        actors[newLoc.getRow()][newLoc.getCol()] = a;
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
                loc.getCol() >= 0 && loc.getCol() < actors[loc.getRow()].length;
    }
}
