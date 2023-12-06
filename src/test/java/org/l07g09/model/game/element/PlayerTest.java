package org.l07g09.model.game.element;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.l07g09.model.game.element.Player;
import org.l07g09.model.Position;
import org.mockito.Mockito;

import static org.mockito.Mockito.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PlayerTest {
    private Player player;
    @BeforeEach
    public void setUp() {
        player = new Player(0,0,"#FFFFFF", '1');
    }
    @Test
    public void Player() {
        Player p = new Player(0,0,"#FFFFFF", '1');
        assertTrue(p.getPos().equals(new Position(0,0)));
        assertEquals("#FFFFFF", p.getColor());
    }
    @Test
    public void getTrails() {
        assertTrue(player.getTrails().isEmpty(), "The ArrayList should be empty");
    }
    @Test
    public void getPos() {
        assertEquals(0, player.getPos().getX());
        assertEquals(0, player.getPos().getY());
    }
    @Test
    public void getDirection() {
        assertEquals(-1, player.getDirection(), "Se não deu set, então a direction = -1.");

        player.setDirection(1);
        assertEquals(1, player.getDirection());
    }
    @Test
    public void setDirection() {
        player.setDirection(1);
        assertEquals(1, player.getDirection());
    }
    @Test
    public void getCollide() {
        assertFalse(player.getCollide());
        player.setCollide(true);
        assertTrue(player.getCollide());
    }
    @Test
    public void setCollide() {
        player.setCollide(true);
        assertTrue(player.getCollide());
        player.setCollide(false);
        assertFalse(player.getCollide());
    }
}