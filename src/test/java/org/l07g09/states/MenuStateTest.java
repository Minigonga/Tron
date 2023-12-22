package org.l07g09.states;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.l07g09.model.menu.Menu;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MenuStateTest {
    Menu menu;
    MenuState state;

    @BeforeEach
    public void setUp() {
        menu = new Menu();
        state = new MenuState(menu);
    }

    @Test
    public void getViewer() {
        assertEquals(menu, state.getViewer().getModel());
    }
}
