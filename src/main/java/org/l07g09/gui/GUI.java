package org.l07g09.gui;

import org.l07g09.model.Position;
import org.l07g09.model.game.element.Block;
import org.l07g09.model.game.element.Player;

import java.io.IOException;

public interface GUI {

    void drawPlayer(Player player);

    void drawBlock(Block block);

    void drawText(Position position, String text, String color);

    void close() throws IOException;

}
