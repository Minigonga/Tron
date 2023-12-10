package org.l07g09.controller.menu;

import org.l07g09.Game;
import org.l07g09.controller.Controller;
import org.l07g09.gui.GUI;
import org.l07g09.model.menu.Instructions;
import org.l07g09.model.menu.Menu;
import org.l07g09.states.MenuState;

public class InstructionsController extends Controller<Instructions> {
    public InstructionsController(Instructions Instructions) {
        super(Instructions);
    }

    @Override
    public void step(Game game, GUI.Action action) {
        if (action == GUI.Action.exit) game.setState(new MenuState(new Menu()));
    }
}