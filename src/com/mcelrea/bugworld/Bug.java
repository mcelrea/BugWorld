package com.mcelrea.bugworld;

public class Bug extends Actor{

    public Bug(int row, int col, String path, World world) {
        //must call super class constructor FIRST
        super(row, col, path, world);
    }

    @Override
    public void act() {
        Location forward = getMyLoc().getForwardLoc(getDir());
        if(getMyWorld().isValid(forward) && (getMyWorld().getActorAtLoc(forward) == null ||
                                                getMyWorld().getActorAtLoc(forward) instanceof Flower)) {
            getMyWorld().changeActorLoc(this,forward);
            getMyWorld().addActor(new Flower(getMyLoc().getRow(),getMyLoc().getCol(),
                    "images/flower.png", getMyWorld()));
            setMyLoc(forward);
        }
        else { //cannot move forward
            super.act(); //move like an Actor
        }
    }

}
