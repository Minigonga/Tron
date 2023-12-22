package org.l07g09.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.l07g09.Game;
import org.l07g09.controller.game.PlayersController;
import org.l07g09.gui.GUI;
import org.l07g09.model.game.arena.Arena;
import org.l07g09.model.game.element.Player;
import org.l07g09.model.game.scoreboard.ScoreBoard;


import static org.junit.jupiter.api.Assertions.assertEquals;

public class PlayerControllerTest {
    private PlayersController controller;
    private Player player1, player2;
    private Arena arena;
    private ScoreBoard score;
    private Game game;

    @BeforeEach
    public void setUp() {
        arena = new Arena(100, 100);
        score = new ScoreBoard(0,0,3,3);
        arena.setSb(score);
        player1 = new Player(55,30,"#FFFFFF", '1', 2);
        player2 = new Player(20,5,"#000000", '2', 1);
        arena.setPlayer1(player1);
        arena.setPlayer2(player2);
        controller = new PlayersController(arena);
        game = new Game();
    }

    @Test
    public void jumpPlayer() {
        controller.jumpPlayer(player1,2);
        assertEquals(35, player1.getPos().getY());
        controller.jumpPlayer(player2,1);
        assertEquals(25, player2.getPos().getX());
    }

    @Test
    public void movePlayer() {
        controller.movePlayer(player1, 2);
        assertEquals(31, player1.getPos().getY());
        controller.movePlayer(player2, 1);
        assertEquals(21,player2.getPos().getX());
    }

    @Test
    public void setPlayerDirection() {
        controller.setPlayer1Direction(1);
        assertEquals(1, player1.getDirection());
        controller.setPlayer2Direction(3);
        assertEquals(3, player2.getDirection());
    }

    @Test
    public void boostPlayer() {
        controller.boostPlayer(player1, 2);
        assertEquals(55, player1.getPos().getX());
        assertEquals(37, player1.getPos().getY());
    }
    @Test
    public void step1() {
        controller.step(game, GUI.Action.left1);
        assertEquals(54, player1.getPos().getX());
        assertEquals(30, player1.getPos().getY());
    }
    @Test
    public void step2() {
        controller.step(game, GUI.Action.jump1);
        assertEquals(35, player1.getPos().getY());
        assertEquals(21, player2.getPos().getX());
        controller.step(game, GUI.Action.jump2);
        assertEquals(26, player2.getPos().getX());
    }
    @Test
    public void step3_1() {
        controller.step(game, GUI.Action.boost1);
        assertEquals(55, player1.getPos().getX());
        assertEquals(31, player1.getPos().getY());
        arena.setBoost1(1);
        controller.step(game, GUI.Action.boost1);
        assertEquals(38, player1.getPos().getY());
    }
    @Test
    public void step3_2() {
        controller.step(game, GUI.Action.boost2);
        assertEquals(21, player2.getPos().getX());
        assertEquals(5, player2.getPos().getY());
        arena.setBoost2(1);
        controller.step(game, GUI.Action.boost2);
        assertEquals(28, player2.getPos().getX());
    }
}
