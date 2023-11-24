package org.l07g09.Element.Motorcycle;

import org.l07g09.Element.Element;
import org.l07g09.Element.Trail;
import org.l07g09.Position;

import java.util.ArrayList;

public abstract class Motorcycle extends Element {
    protected ArrayList<Trail> trails;
    protected int direction;
    protected boolean collide;
    protected String color;
    public Motorcycle(int x, int y, String color) {
        super(x, y);
        this.trails = new ArrayList<>();
        this.color = color;
        this.collide=false;
    }

    public void move() {
        byte right = 0;
        byte left = 1;
        byte down = 2;
        byte up = 3;
        Position position = pos;
        if (direction == right) {
            pos = new Position(pos.getX()+1, pos.getY());
        } else if (direction == left) {
            pos = new Position(pos.getX()-1, pos.getY());
        } else if (direction == down) {
            pos = new Position(pos.getX(), pos.getY()+1);
        } else if (direction == up) {
            pos = new Position(pos.getX(), pos.getY()-1);
        }
        trails.add(new Trail(position.getX(), position.getY(), color));
    }

    public ArrayList<Trail> getTrails() {
        return trails;
    }

    public void setTrail(ArrayList<Trail> trails) {
        this.trails = trails;
    }

    public int getDirection() {return direction;}
    public void setDirection(int direction) {this.direction = direction;}

    public boolean getCollide() {
        return collide;
    }

    public void setCollide(boolean collide) {
        this.collide = collide;
    }
}
