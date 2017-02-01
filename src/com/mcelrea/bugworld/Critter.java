package com.mcelrea.bugworld;

import java.util.ArrayList;

/**
 * Created by mcelrea on 1/31/2017.
 */
public class Critter extends Bug{

    public Critter(int row, int col, String path, World world) {
        super(row, col, path, world);
    }

    @Override
    public void act() {
        ArrayList<Actor> actors = getActors();
        processActors(actors);
        ArrayList<Location> moveLocs = getPossibleMoveLocs();
        chooseAndMove(moveLocs);
    }

    private void chooseAndMove(ArrayList<Location> moveLocs) {
        int choice = (int) (Math.random() * moveLocs.size());
        getMyWorld().changeActorLoc(this, moveLocs.get(choice));
        setMyLoc(moveLocs.get(choice));
    }

    private ArrayList<Location> getPossibleMoveLocs() {
        return getMyWorld().getEmptyLocsAround(getMyLoc());
    }

    private void processActors(ArrayList<Actor> actors) {
        for(int i=0; i < actors.size(); i++) {
            getMyWorld().removeActor(actors.get(i));
        }
    }

    //returns a list of all Bugs around me
    private ArrayList<Actor> getActors() {
        ArrayList<Actor> actors = getMyWorld().getNeighbors(getMyLoc());
        for(int i=0; i < actors.size(); i++) {
            Actor a = actors.get(i);
            if(a instanceof Flower || a instanceof Critter) {
                actors.remove(i);
                i--;//so we don't skip an entry
            }
        }
        return actors;
    }
}
