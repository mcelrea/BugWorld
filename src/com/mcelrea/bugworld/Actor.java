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

    private int row;
    private int col;
    private Image northImage, southImage, eastImage, westImage;
    private Image northWestImage, southWestImage,
            northEastImage, southEastImage;
    private int dir = Location.NORTH;

    public Actor(int row, int col, String path) {
        this.row = row;
        this.col = col;

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
            gc.drawImage(northImage,col*25, row*25);
        else if(dir == Location.EAST)
            gc.drawImage(eastImage,col*25, row*25);
        else if(dir == Location.SOUTH)
            gc.drawImage(southImage,col*25, row*25);
        else if(dir == Location.WEST)
            gc.drawImage(westImage,col*25, row*25);
        else if(dir == Location.NORTHWEST)
            gc.drawImage(northWestImage,col*25-6, row*25-6);
        else if(dir == Location.NORTHEAST)
            gc.drawImage(northEastImage,col*25-6, row*25-6);
        else if(dir == Location.SOUTHEAST)
            gc.drawImage(southEastImage,col*25-6, row*25-6);
        else if(dir == Location.SOUTHWEST)
            gc.drawImage(southWestImage,col*25-6, row*25-6);
    }

    public void act() {
        dir++;
        if(dir > 8)
            dir = 1;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public int getDir() {
        return dir;
    }

    public void setDir(int dir) {
        this.dir = dir;
    }
}
