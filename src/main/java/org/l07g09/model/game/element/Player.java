package org.l07g09.model.game.element;


import java.util.ArrayList;
import java.util.List;

import org.l07g09.model.Position;


public class Player extends Element {
    private final int boostCount;
    protected ArrayList<Block> trail;

    private int direction;

    private boolean collide;

    private final char number;

    public Player(int x,int y, String color, char number, int dir){
        super(x,y, color);
        this.trail = new ArrayList<>();
        this.collide=false;
        this.number = number;
        this.boostCount = 0;
        this.direction = dir;
    }

    public List<Block> getTrail() {
        return trail;
    }

    public void incTrail(Position p, String c){
        trail.add(new Block(p.getX(),p.getY(),c));
    }
    public int getDirection() {return direction;}

    public void setDirection(int direction) {this.direction = direction;}

    public boolean getCollide() {
        return collide;
    }

    public void setCollide(boolean collide) {
        this.collide = collide;
    }

    public int getBoostCount() {return boostCount;}
    public char getNumber() {return number;}
}