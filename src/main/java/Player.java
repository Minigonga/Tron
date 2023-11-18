import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

import java.util.ArrayList;

public class Player extends Objects {
    private ArrayList<Position> trail;
    private int direction;
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
    public void move() {
        byte right = 0;
        byte left = 1;
        byte down = 2;
        byte up = 3;
        if (direction == right) {
            pos = new Position(pos.getX()+1, pos.getY());
        } else if (direction == left) {
            pos = new Position(pos.getX()-1, pos.getY());
        } else if (direction == down) {
            pos = new Position(pos.getX(), pos.getY()+1);
        } else if (direction == up) {
            pos = new Position(pos.getX(), pos.getY()-1);
        }
    }
    public int getDirection() {return direction;}
    public void setDirection(int direction) {this.direction = direction;}
}