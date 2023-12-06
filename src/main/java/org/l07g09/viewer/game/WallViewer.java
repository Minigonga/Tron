package org.l07g09.viewer.game;
import org.l07g09.gui.GUI;
import org.l07g09.model.game.element.Player;
import org.l07g09.model.game.element.Wall;

public class WallViewer implements ElementViewer<Wall> {
    @Override
    public void draw(Wall wall, GUI gui) {
        gui.drawWall(wall);
    }
}