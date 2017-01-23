package com.mcelrea.bugworld;

public class BoxBug extends Bug{

    private int sideLength;

    public BoxBug(int row, int col, String path, World world, int sl) {
        super(row, col, path, world);
        sideLength = sl;
    }

    @Override
    public void act() {

    }
}
