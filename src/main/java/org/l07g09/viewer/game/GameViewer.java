package org.l07g09.viewer.game;

import org.l07g09.gui.GUI;
import org.l07g09.model.game.arena.Arena;
import org.l07g09.model.game.element.Element;
import org.l07g09.model.game.element.Player;
import org.l07g09.model.game.scoreboard.ScoreBoard;
import org.l07g09.viewer.Viewer;

import java.util.List;

public class GameViewer extends Viewer<Arena> {
    public GameViewer(Arena arena) {
        super(arena);
    }

    @Override
    public void drawElements(GUI gui) {
        drawElements(gui, getModel().getWalls(), new BlockViewer());
        Player player1 = getModel().getPlayer1();
        Player player2 = getModel().getPlayer2();
        ScoreBoard sb = getModel().getSb();
        drawElements(gui, player1.getTrail(), new BlockViewer());
        drawElements(gui, player2.getTrail(), new BlockViewer());
        drawElement(gui, player1, new PlayerViewer());
        drawElement(gui, player2, new PlayerViewer());
        drawElements(gui, sb.getScore1View(), new BlockViewer());
        drawElements(gui, sb.getScore2View(), new BlockViewer());
        drawElements(gui, sb.getBoost1View(), new BlockViewer());
        drawElements(gui, sb.getBoost2View(), new BlockViewer());
    }

    private <T extends Element> void drawElements(GUI gui, List<T> elements, ElementViewer<T> viewer) {
        for (T element : elements)
            drawElement(gui, element, viewer);
    }

    private <T extends Element> void drawElement(GUI gui, T element, ElementViewer<T> viewer) {
        viewer.draw(element, gui);
    }
}