package org.l07g09.states;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.l07g09.model.menu.Instructions;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class InstructionsStateTest {
    InstructionsState state;
    Instructions instructions;

    @BeforeEach
    public void setUp() {
        instructions = new Instructions();
        state = new InstructionsState(instructions);
    }
    @Test
    public void getViwer() {
        assertEquals(instructions, state.getViewer().getModel());
    }
}
