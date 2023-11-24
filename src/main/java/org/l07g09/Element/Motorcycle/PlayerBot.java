package org.l07g09.Element.Motorcycle;

import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import org.l07g09.Element.Trail;

public class PlayerBot extends Motorcycle{

    PlayerBot(int x, int y, String color) {
        super(x, y, color);
    }

    @Override
    public void draw(TextGraphics graphics) {
        graphics.setForegroundColor(TextColor.Factory.fromString(color));
        graphics.enableModifiers(SGR.BOLD);
        graphics.putString(new TerminalPosition(getPos().getX(), getPos().getY()), "B");
        for (Trail trail : trails) {
            trail.draw(graphics);
        }
    }
}
