package org.l07g09.model.game.element;
import com.googlecode.lanterna.graphics.TextGraphics;
import org.l07g09.model.Position;

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
    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
    public Position getPos(){
        return pos;
    }

}