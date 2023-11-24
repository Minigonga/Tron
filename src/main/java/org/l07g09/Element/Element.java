package org.l07g09.Element;

import com.googlecode.lanterna.graphics.TextGraphics;
import org.l07g09.Position;

public abstract class Element {
    protected Position pos;
    protected Element(int x, int y){
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