package org.l07g09.Element;

import com.googlecode.lanterna.graphics.TextGraphics;
import org.l07g09.Position;

public abstract class Element {

    protected Position pos;

    protected String color;

    protected Element(int x, int y, String color){
        pos=new Position(x,y);
        this.color = color;
    }

    public abstract void draw(TextGraphics graphics);

    public void setPos(Position p){
        pos=p;
    }

    public Position getPos(){
        return pos;
    }

}