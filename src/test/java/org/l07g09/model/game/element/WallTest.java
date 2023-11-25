package org.l07g09.model.game.element;

import org.junit.jupiter.api.Test;
import org.l07g09.model.Position;

import static org.junit.jupiter.api.Assertions.*;

public class WallTest {
    @Test
    public void Wall() {
        Wall wall = new Wall(0,0,"#000000");
        assertTrue(wall.getPos().equals(new Position(0,0)));
        assertEquals("#000000", wall.getColor());
    }
}
