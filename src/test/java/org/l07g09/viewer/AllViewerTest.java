package org.l07g09.viewer;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.l07g09.gui.GUI;
import org.l07g09.model.Position;
import org.l07g09.model.game.arena.Arena;
import org.l07g09.model.game.element.Block;
import org.l07g09.model.game.element.Player;
import org.l07g09.model.game.scoreboard.ScoreBoard;
import org.l07g09.viewer.game.GameViewer;
import org.mockito.Mockito;

import java.io.IOException;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AllViewerTest {
    private GUI gui;
    private GameViewer viewer;
    private Arena arena;
    private Block block1, block2, block3;
    private ScoreBoard score;

    @BeforeEach
    public void setUp() {
        arena = new Arena(20, 20);
        score = new ScoreBoard(0,0,3,3);
        arena.setSb(score);
        gui = Mockito.mock(GUI.class);
        viewer = new GameViewer(arena);
        block1 = new Block(1, 2, "#0000FF");
        block2 = new Block(2, 3, "#0000FF");
        block3 = new Block(3, 4, "#0000FF");

        arena.setWalls(Arrays.asList(block1, block2, block3));
        arena.setPlayer1(new Player(3, 0, "#FFFFFF", '1', 2));
        arena.setPlayer2(new Player(10, 5, "#987654", '2', 1));
        arena.getPlayer1().incTrail(new Position(1, 1), "#FFFFFF");
        arena.getPlayer2().incTrail(new Position(2, 2), "#987654");
    }

    @Test
    public void drawBlock() {
        viewer.drawElements(gui);

        Mockito.verify(gui, Mockito.times(1)).drawBlock(block1);
        Mockito.verify(gui, Mockito.times(1)).drawBlock(block2);
        Mockito.verify(gui, Mockito.times(1)).drawBlock(block3);
        //221 por causa dos scores serem blocos
        Mockito.verify(gui, Mockito.times(221)).drawBlock(Mockito.any(Block.class));
    }

    @Test
    public void drawPlayers() {
        viewer.drawElements(gui);

        Mockito.verify(gui, Mockito.times(1)).drawPlayer(arena.getPlayer1());
        Mockito.verify(gui, Mockito.times(1)).drawPlayer(arena.getPlayer2());
        Mockito.verify(gui, Mockito.times(2)).drawPlayer(Mockito.any(Player.class));
    }

    @Test
    public void refreshClear() throws IOException {
        viewer.draw(gui);

        Mockito.verify(gui, Mockito.times(1)).clear();
        Mockito.verify(gui, Mockito.times(1)).refresh();
    }

    @Test
    public void drawMakeScore() {
        score.makeScore(0,0);
        assertEquals(84, score.getScore1View().size());
        assertEquals(84, score.getScore2View().size());

        score.makeScore(1,1);
        assertEquals(74, score.getScore1View().size());
        assertEquals(74, score.getScore2View().size());

        score.makeScore(2,2);
        assertEquals(78, score.getScore1View().size());
        assertEquals(78, score.getScore2View().size());

        score.makeScore(3,3);
        assertEquals(78, score.getScore1View().size());
        assertEquals(78, score.getScore2View().size());
    }

    @Test
    public void drawMakeBoost() {
        score.makeBoost(3,3);
        assertEquals(24, score.getBoost1View().size());
        assertEquals(24, score.getBoost2View().size());

        score.makeBoost(2,2);
        assertEquals(22, score.getBoost1View().size());
        assertEquals(22, score.getBoost2View().size());

        score.makeBoost(1,1);
        assertEquals(17, score.getBoost1View().size());
        assertEquals(17, score.getBoost2View().size());

        score.makeBoost(0,0);
        assertEquals(26, score.getBoost1View().size());
        assertEquals(26, score.getBoost2View().size());
    }

}




