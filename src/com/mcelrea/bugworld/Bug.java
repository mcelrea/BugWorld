package com.mcelrea.bugworld;

public class Bug extends Actor{

    public Bug(int row, int col, String path, World world) {
        //must call super class constructor FIRST
        super(row, col, path, world);
    }

    @Override
    public void act() {
        Location forward = getMyLoc().getForwardLoc(getDir());
        if(getMyWorld().isValid(forward)) {
            getMyWorld().changeActorLoc(this,forward);
            setMyLoc(forward);
        }
        else { //cannot move forward
            super.act(); //move like an Actor
        }
    }

}
