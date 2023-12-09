package org.l07g09.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.l07g09.model.Position;
import org.l07g09.model.game.element.Player;


import static org.junit.jupiter.api.Assertions.*;

public class PositionTest {
    private Position positionTest1, positionTest2, positionTest3;

    @BeforeEach
    public void setUp() {
        positionTest1 = new Position(2, 1);
        positionTest2 = new Position(1, 0);
        positionTest3 = new Position(1, 0);
    }
    @Test
    public void getX() {
        assertEquals(2, positionTest1.getX());
        assertEquals(1, positionTest2.getX());
    }

    @Test
    public void getY() {
        assertEquals(1, positionTest1.getY());
        assertEquals(0, positionTest2.getY());
    }

    @Test
    public void equals() {
        assertTrue(positionTest2.equals(positionTest3));
        assertFalse(positionTest1.equals(positionTest3));
    }

    @Test
    public void setX() {
        positionTest1.setX(3);
        assertEquals(3, positionTest1.getX());
        positionTest2.setX(10);
        assertEquals(10, positionTest2.getX());
    }

    @Test
    public void setY() {
        positionTest1.setY(4);
        assertEquals(4, positionTest1.getY());
        positionTest2.setY(10);
        assertEquals(10, positionTest2.getY());
    }

    @Test
    public void getNextJumpPos() {
        positionTest1 = positionTest1.getNextJumpPos(2);
        assertEquals(new Position(2, 6).getY(), positionTest1.getY());
        assertEquals(new Position(2, 6).getX(), positionTest1.getX());
        positionTest2 = positionTest2.getNextJumpPos(1);
        assertEquals(new Position(6,0).getX(), positionTest2.getX());
        assertEquals(new Position(6,0).getY(), positionTest2.getY());
    }

    @Test
    public void getNextPos() {
        positionTest1 = positionTest1.getNextPos(2);
        assertEquals(new Position(2,2).getY(), positionTest1.getY());
        assertEquals(new Position(2,2).getX(), positionTest1.getX());
        positionTest2 = positionTest2.getNextPos(1);
        assertEquals(new Position(2,0).getY(), positionTest2.getY());
        assertEquals(new Position(2,0).getX(), positionTest2.getX());
    }


}