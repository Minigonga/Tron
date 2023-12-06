package org.l07g09.viewer.game;

import org.l07g09.gui.GUI;
import org.l07g09.model.game.Arena;
import org.l07g09.model.game.element.Element;
import org.l07g09.viewer.Viewer;

import java.util.List;

public class GameViewer extends Viewer<Arena> {
    public GameViewer(Arena arena) {
        super(arena);
    }

    @Override
    public void drawElements(GUI gui) {
        drawElements(gui, getModel().getWalls(), new WallViewer());
        drawElement(gui, getModel().getPlayer1(), new PlayerViewer());
        drawElement(gui, getModel().getPlayer2(), new PlayerViewer());
    }

    private <T extends Element> void drawElements(GUI gui, List<T> elements, ElementViewer<T> viewer) {
        for (T element : elements)
            drawElement(gui, element, viewer);
    }

    private <T extends Element> void drawElement(GUI gui, T element, ElementViewer<T> viewer) {
        viewer.draw(element, gui);
    }
}