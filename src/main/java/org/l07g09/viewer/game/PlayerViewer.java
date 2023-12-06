package org.l07g09.viewer.game;

import org.l07g09.gui.GUI;
import org.l07g09.model.game.element.Player;

public class PlayerViewer implements ElementViewer<Player> {
    @Override
    public void draw(Player player, GUI gui) {
        gui.drawPlayer(player);
    }
}
