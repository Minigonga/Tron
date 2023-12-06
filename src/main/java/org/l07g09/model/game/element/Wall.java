package org.l07g09.model.game.element;

import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import org.l07g09.model.game.element.Element;

public class Wall extends Element {

    public Wall(int x, int y, String color){
        super (x,y, color);
    }

}
