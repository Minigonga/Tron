import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

import java.awt.*;
import java.util.ArrayList;

public class Player extends Objects {
    private ArrayList<Position> trail;
    private String color;
    Player(int x,int y, String color){
        super(x,y);
        this.color = color;
    }

    public ArrayList<Position> getTrail() {
        return trail;
    }

    public void setTrail(ArrayList<Position> trail) {
        this.trail = trail;
    }
    public void draw(TextGraphics graphics){
        graphics.setForegroundColor(TextColor.Factory.fromString(color));
        graphics.enableModifiers(SGR.BOLD);
        graphics.putString(new TerminalPosition(getPos().getX(), getPos().getY()), "P");
    }
}
