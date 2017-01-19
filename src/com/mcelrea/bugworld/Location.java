package com.mcelrea.bugworld;

/**
 * Created by mcelrea on 1/17/2017.
 */
public class Location {
    private int row;
    private int col;
    public static final int NORTH=1;
    public static final int NORTHEAST=2;
    public static final int EAST=3;
    public static final int SOUTHEAST=4;
    public static final int SOUTH=5;
    public static final int SOUTHWEST=6;
    public static final int WEST=7;
    public static final int NORTHWEST=8;

    public Location(int row, int col) {
        this.row = row;
        this.col = col;
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

    public Location getForwardLoc(int dir) {
        if(dir == NORTH) {
            return new Location(row-1,col);
        }
        else if(dir == SOUTH) {
            return new Location(row+1,col);
        }
        else if(dir == WEST) {
            return new Location(row,col-1);
        }
        else if(dir == EAST) {
            return new Location(row,col+1);
        }
        else if(dir == NORTHEAST) {
            return new Location(row-1,col+1);
        }
        else if(dir == SOUTHEAST) {
            return new Location(row+1,col+1);
        }
        else if(dir == SOUTHWEST) {
            return new Location(row+1,col-1);
        }
        else if(dir == NORTHWEST) {
            return new Location(row-1,col-1);
        }
        return null;//something went poop
    }
}
