package org.l07g09.model.game.element;

import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import org.l07g09.model.game.element.Element;

public class Trail extends Element {
    public Trail(int x, int y, String color) {
        super(x, y, color);
    }
    @Override
    public void draw(TextGraphics graphics) {
        graphics.setBackgroundColor(TextColor.Factory.fromString(color));
        graphics.enableModifiers(SGR.BOLD);
        graphics.putString(new TerminalPosition(pos.getX(), pos.getY()), " ");
    }
}
