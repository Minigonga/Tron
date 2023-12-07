package org.l07g09.model;

public class Position {
    private int x;
    private int y;
    public Position(int x,int y){
        this.x = x;
        this.y = y;
    }
    public boolean equals(Position p) {return x==p.getX() && y==p.getY();
    }
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Position getNextJumpPos(int direction) {
        if (direction == 0) {return getJumpUp();}
        if (direction == 1) {return getJumpRight();}
        if (direction == 2) {return getJumpDown();}
        if (direction == 3) {return getJumpLeft();}
        return null;
    }
    public Position getJumpUp(){return new Position(x,y-5);}
    public Position getJumpDown(){return new Position(x,y+5);}
    public Position getJumpLeft(){return new Position(x-5,y);}
    public Position getJumpRight(){return new Position(x+5,y);}
    public Position getNextPos(int direction) {
        if (direction == 0) {return getUp();}
        if (direction == 1) {return getRight();}
        if (direction == 2) {return getDown();}
        if (direction == 3) {return getLeft();}
        return null;
    }
    public Position getLeft() {
        return new Position(x - 1, y);
    }

    public Position getRight() {
        return new Position(x + 1, y);
    }

    public Position getUp() {
        return new Position(x, y - 1);
    }

    public Position getDown() {
        return new Position(x, y + 1);
    }
}
