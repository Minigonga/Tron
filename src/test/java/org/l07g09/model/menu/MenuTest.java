package org.l07g09.model.menu;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MenuTest {
    private Menu menu;

    @BeforeEach
    public void setUp() {
        menu = new Menu();
    }

    @Test
    public void isSelected() {
        assertTrue(menu.isSelected(0));
        assertFalse(menu.isSelected(1));
    }

    @Test
    public void NextEntry() {
        assertTrue(menu.isStart());
        menu.nextEntry();
        assertTrue(menu.isInstructions());
        menu.nextEntry();
        assertTrue(menu.isExit());
        menu.nextEntry();
        assertTrue(menu.isStart());
    }

    @Test
    public void PreviousEntry() {
        assertTrue(menu.isStart());
        menu.previousEntry();
        assertTrue(menu.isExit());
        menu.previousEntry();
        assertTrue(menu.isInstructions());
    }

    @Test
    public void getEntry() {
        assertEquals("Start", menu.getEntry(0));
        assertEquals("Instructions", menu.getEntry(1));
        assertEquals("Exit", menu.getEntry(2));
    }
}
