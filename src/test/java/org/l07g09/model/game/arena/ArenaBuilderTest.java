package org.l07g09.model.game.arena;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.l07g09.gui.GUI;
import org.l07g09.viewer.game.GameViewer;
import org.mockito.Mockito;
import org.l07g09.model.game.arena.Arena;
import org.l07g09.model.game.arena.ArenaBuilder;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ArenaBuilderTest {
    private Arena arena;
    private ArenaBuilder buildArena;

    @BeforeEach
    void setup() {
        buildArena = new ArenaBuilder();
    }

    @Test
    void createArena() {
        arena = buildArena.createArena(0,1);

        assertEquals(756, buildArena.createArena(0,0).getWalls().size());

        assertNotNull(arena.getPlayer1());
        assertNotNull(arena.getPlayer2());

        assertEquals(0, arena.getScore1());
        assertEquals(1, arena.getScore2());
    }
}
