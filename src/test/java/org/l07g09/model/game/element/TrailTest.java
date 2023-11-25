package org.l07g09.model.game.element;

import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.graphics.TextGraphics;
import org.junit.jupiter.api.Test;
import org.l07g09.model.Position;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.mockito.stubbing.OngoingStubbing;

import static org.junit.jupiter.api.Assertions.*;


public class TrailTest {
    @Test
    public void Trail() {
        Trail trail = new Trail(0,0,"#FFFFFF");
        assertTrue(trail.getPos().equals(new Position(0,0)));
        assertEquals("#FFFFFF", trail.getColor());
    }
}
