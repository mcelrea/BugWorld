package com.mcelrea.bugworld;

import javafx.scene.SnapshotParameters;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * Created by mcelrea on 1/10/2017.
 */
public class Actor {

    private Location myLoc;
    private Image northImage, southImage, eastImage, westImage;
    private Image northWestImage, southWestImage,
            northEastImage, southEastImage;
    private int dir = Location.NORTH;
    private World myWorld;

    public Actor(int row, int col, String path, World world) {
        myLoc = new Location(row,col);
        myWorld = world;

        File file = new File(path);
        try {
            northImage = new Image(new FileInputStream(file));
        } catch (FileNotFoundException e) {
            System.out.println("Cannot load northImage file from within Actor constructor");
            e.printStackTrace();
        }

        ImageView iv = new ImageView(northImage);
        iv.setRotate(45);
        SnapshotParameters params = new SnapshotParameters();
        params.setFill(Color.TRANSPARENT);
        northEastImage = iv.snapshot(params, null);
        iv.setRotate(90);
        eastImage = iv.snapshot(params, null);
        iv.setRotate(135);
        southEastImage = iv.snapshot(params, null);
        iv.setRotate(180);
        southImage = iv.snapshot(params, null);
        iv.setRotate(225);
        southWestImage = iv.snapshot(params, null);
        iv.setRotate(270);
        westImage = iv.snapshot(params, null);
        iv.setRotate(315);
        northWestImage = iv.snapshot(params, null);
    }

    public void draw(GraphicsContext gc) {
        if(dir == Location.NORTH)
            gc.drawImage(northImage,myLoc.getCol()*25, myLoc.getRow()*25);
        else if(dir == Location.EAST)
            gc.drawImage(eastImage,myLoc.getCol()*25, myLoc.getRow()*25);
        else if(dir == Location.SOUTH)
            gc.drawImage(southImage,myLoc.getCol()*25, myLoc.getRow()*25);
        else if(dir == Location.WEST)
            gc.drawImage(westImage,myLoc.getCol()*25, myLoc.getRow()*25);
        else if(dir == Location.NORTHWEST)
            gc.drawImage(northWestImage,myLoc.getCol()*25-6, myLoc.getRow()*25-6);
        else if(dir == Location.NORTHEAST)
            gc.drawImage(northEastImage,myLoc.getCol()*25-6, myLoc.getRow()*25-6);
        else if(dir == Location.SOUTHEAST)
            gc.drawImage(southEastImage,myLoc.getCol()*25-6, myLoc.getRow()*25-6);
        else if(dir == Location.SOUTHWEST)
            gc.drawImage(southWestImage,myLoc.getCol()*25-6, myLoc.getRow()*25-6);
    }

    public Image getImage() {
        if(dir == Location.NORTH)
            return northImage;
        else if(dir == Location.EAST)
            return northImage;
        else if(dir == Location.SOUTH)
            return northImage;
        else if(dir == Location.WEST)
            return northImage;
        else if(dir == Location.NORTHWEST)
            return northImage;
        else if(dir == Location.NORTHEAST)
            return northImage;
        else if(dir == Location.SOUTHEAST)
            return northImage;
        else if(dir == Location.SOUTHWEST)
            return northImage;

        return null;
    }


    public void act() {
        dir++;
        if(dir > 8)
            dir = 1;
    }

    public Location getMyLoc() {
        return myLoc;
    }

    public void setMyLoc(Location myLoc) {
        this.myLoc = myLoc;
    }

    public int getDir() {
        return dir;
    }

    public void setDir(int dir) {
        this.dir = dir;
    }

    public World getMyWorld() {
        return myWorld;
    }
}
