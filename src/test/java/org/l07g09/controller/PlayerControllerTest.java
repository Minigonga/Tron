package org.l07g09.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.l07g09.controller.game.PlayersController;
import org.l07g09.model.game.arena.Arena;
import org.l07g09.model.game.element.Player;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PlayerControllerTest {
    private PlayersController controller;
    private Player player1, player2;
    private Arena arena;

    @BeforeEach
    public void setUp() {
        arena = new Arena(20, 20);
        player1 = new Player(55,30,"#FFFFFF", '1', 2);
        player2 = new Player(20,5,"#000000", '2', 1);
        arena.setPlayer1(player1);
        arena.setPlayer2(player2);
        controller = new PlayersController(arena);
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
}
