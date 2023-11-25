package org.l07g09.model.game.element;


import java.util.ArrayList;
import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import org.l07g09.model.Position;


public class Player extends Element {
    private int boostCount;
    protected ArrayList<Trail> trails;

    private int direction = -1;

    private boolean collide;

    private String number;

    public Player(int x,int y, String color, String number){
        super(x,y, color);
        this.trails = new ArrayList<>();
        this.collide=false;
        this.number = number;
        this.boostCount = 0;
    }

    public ArrayList<Trail> getTrails() {
        return trails;
    }

    public void draw(TextGraphics graphics) {
        graphics.setForegroundColor(TextColor.Factory.fromString(color));
        graphics.enableModifiers(SGR.BOLD);
        graphics.putString(new TerminalPosition(getPos().getX(), getPos().getY()), number);
        for (Trail trail : trails) {
            graphics.setBackgroundColor(TextColor.Factory.fromString(color));
            graphics.enableModifiers(SGR.BOLD);
            graphics.putString(new TerminalPosition(trail.getPos().getX(), trail.getPos().getY()), " ");
        }
    }
    public void boost() {
        if (boostCount<3) {
            for (int i = 0; i <7; i++) {
                move();
            }
            boostCount++;
        }
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
        trails.add(new Trail(position.getX(),position.getY(),color));
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
}