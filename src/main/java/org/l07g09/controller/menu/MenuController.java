package org.l07g09.controller.menu;

import org.l07g09.Game;
import org.l07g09.controller.Controller;
import org.l07g09.gui.GUI;
import org.l07g09.model.game.arena.ArenaBuilder;
import org.l07g09.model.menu.Menu;
import org.l07g09.states.GameState;

import java.io.IOException;

public class MenuController extends Controller<Menu> {
    public MenuController(Menu menu) {
        super(menu);
    }

    @Override
    public void step(Game game, GUI.Action action, long time) {
        switch (action) {
            case up2:
                getModel().previousEntry();
                break;
            case down2:
                getModel().nextEntry();
                break;
            case select:
                if (getModel().isExit()) game.setState(null);
                if (getModel().isStart()) game.setState(new GameState(new ArenaBuilder().createArena()));
        }
    }
}
