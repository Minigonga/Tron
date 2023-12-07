package org.l07g09.gui;

import org.l07g09.model.Position;
import org.l07g09.model.game.element.Block;
import org.l07g09.model.game.element.Player;

import java.io.IOException;

public interface GUI {

    void drawPlayer(Player player);

    void drawBlock(Block block);

    void drawText(Position position, String text, String color);

    Action getNextAction()throws IOException;
    void clear();
    void refresh() throws IOException;
    void close() throws IOException;

    enum Action {up1, down1, right1, left1, jump1, boost1, up2, down2, right2, left2, jump2, boost2, exit, select, none}
}
