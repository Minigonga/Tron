package org.l07g09.model.game.arena;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.l07g09.controller.game.PlayersController;
import org.l07g09.model.PositionTest;
import org.l07g09.model.game.arena.Arena;
import org.l07g09.model.game.element.Player;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ArenaTest {
    private Arena arena;
    private ArenaBuilder builder;
    private PlayersController controller;
    private Player player1;
    private Player player2;
    @BeforeEach
    public void setUp() throws IOException, URISyntaxException, FontFormatException {
        builder = new ArenaBuilder();
        arena = builder.createArena(0,0);
        controller = new PlayersController(arena);
        arena.setPlayer1(new Player(3,0, "#FFFFFF", '1',1));
        arena.setPlayer2(new Player(5,0, "#000FFF", '2',3));

        player1 = arena.getPlayer1();
        player2 = arena.getPlayer2();
    }
    @Test
    public void collision() {
        controller.movePlayer(player1, 1);
        controller.movePlayer(player2, 3);
        arena.collision();
        assertTrue(player1.getCollide());
        assertTrue(player2.getCollide());
    }

    @Test
    public void jumpCD() {
        arena.setJumpCd1(3);
        arena.setJumpCd2(2);

        assertEquals(3, arena.getJumpCd1());
        assertEquals(2, arena.getJumpCd2());
    }

    @Test
    public void boost() {
        arena.setBoost1(3);
        arena.setBoost2(1);

        assertEquals(3, arena.getBoost('1'));
        assertEquals(1, arena.getBoost('2'));

        arena.boostUsed('1');

        assertEquals(2, arena.getBoost('1'));
    }

}
