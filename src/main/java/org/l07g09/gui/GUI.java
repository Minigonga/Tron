package org.l07g09.gui;

import org.l07g09.model.Position;

import java.io.IOException;

public interface GUI {

    void drawPlayer(Position position);

    void drawWall(Position position);

    void drawTrail(Position position);

    void drawText(Position position, String text, String color);

    void close() throws IOException;

}
