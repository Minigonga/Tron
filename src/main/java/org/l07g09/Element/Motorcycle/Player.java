package org.l07g09.Element.Motorcycle;

import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import org.l07g09.Element.Trail;
import org.l07g09.Position;

public class Player extends Motorcycle {
    private String number;
    public Player(int x,int y, String color, String number){
        super(x,y, color);
        this.number = number;
    }
    public void draw(TextGraphics graphics) {
        graphics.setForegroundColor(TextColor.Factory.fromString(color));
        graphics.enableModifiers(SGR.BOLD);
        graphics.putString(new TerminalPosition(getPos().getX(), getPos().getY()), number);
        for (Trail trail : trails) {
            trail.draw(graphics);
        }
    }

}