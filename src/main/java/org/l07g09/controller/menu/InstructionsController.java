package org.l07g09.controller.menu;

import org.l07g09.Game;
import org.l07g09.controller.Controller;
import org.l07g09.gui.GUI;
import org.l07g09.model.menu.Instructions;
import org.l07g09.model.menu.Menu;
import org.l07g09.states.InstructionsState;
import org.l07g09.states.MenuState;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

public class InstructionsController extends Controller<Instructions> {
    public InstructionsController(Instructions Instructions) {
        super(Instructions);
    }

    @Override
    public void step(Game game, GUI.Action action) throws IOException, URISyntaxException, FontFormatException {
        if (action == GUI.Action.exit) game.setState(new MenuState(new Menu()));
    }
}