package org.l07g09.gui;

import org.l07g09.model.Position;
import org.l07g09.model.game.element.Player;
import org.l07g09.model.game.element.Trail;
import org.l07g09.model.game.element.Wall;

import java.io.IOException;

public interface GUI {

    void drawPlayer(Player player);

    void drawWall(Wall wall);

    void drawTrail(Trail trail);

    void drawText(Position position, String text, String color);

    void close() throws IOException;

}
