package org.l07g09.Element.Motorcycle;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.l07g09.Position;


import static org.mockito.Mockito.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PlayerTest {
    private final Player player = new Player(0,0,"#FFFFFF", "1");
    private final Player playerMock = mock(Player.class);
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
    public void move() {
        doAnswer(invocation -> {
            Object[] args = invocation.getArguments();
            if (args.length > 0 && args[0] instanceof Integer) {
                player.setDirection((Integer) args[0]);
            }
            return null;
        }).when(playerMock).setDirection(0);
        Position p = new Position(1,0);
        when(playerMock.getPos()).thenReturn(p);
        player.setDirection(0);
        player.move();
        assertTrue(player.getPos().equals(p));
    }
    @Test
    public void getDirection() {
        assertEquals(-1, player.getDirection(), "Se não deu set, então a direction = -1.");
        doAnswer(invocation -> {
            Object[] args = invocation.getArguments();
            if (args.length > 0 && args[0] instanceof Integer) {
                player.setDirection((Integer) args[0]);
            }
            return null;
        }).when(playerMock).setDirection(1);
        player.setDirection(1);
        assertEquals(1, player.getDirection());
    }
    @Test
    public void setDirection() {
        when(playerMock.getDirection()).thenReturn(playerMock.direction);
        player.setDirection(1);
        assertEquals(1, player.getDirection());
    }
    @Test
    public void getCollide() {
        doAnswer(invocation -> {
            Object[] args = invocation.getArguments();
            if (args.length > 0 && args[0] instanceof Integer) {
                player.setCollide((Boolean) args[0]);
            }
            return null;
        }).when(playerMock).setCollide(true);
        assertFalse(player.getCollide());
        player.setCollide(true);
        assertTrue(player.getCollide());
    }
    @Test
    public void setCollide() {
        when(playerMock.getCollide()).thenReturn(playerMock.collide);
        player.setCollide(true);
        assertTrue(player.getCollide());
        player.setCollide(false);
        assertFalse(player.getCollide());
    }
}
