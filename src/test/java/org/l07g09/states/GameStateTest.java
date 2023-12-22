package org.l07g09.states;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.l07g09.model.game.arena.Arena;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GameStateTest {
    GameState state;
    Arena arena;
    @BeforeEach
    public void setUp() {
        arena = new Arena(100, 100);
        state = new GameState(arena);
    }
    @Test
    public void getViewer() {
        assertEquals(arena, state.getViewer().getModel());
    }
}
