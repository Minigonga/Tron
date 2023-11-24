package org.l07g09;

import com.googlecode.lanterna.graphics.TextGraphics;

public abstract class Element {
    protected Position pos;
    Element(int x, int y){
        pos=new Position(x,y);
    }
    public abstract void draw(TextGraphics graphics);
    public void setPos(Position p){
        pos=p;
    }
    public Position getPos(){
        return pos;
    }
}