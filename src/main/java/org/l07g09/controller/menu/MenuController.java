package org.l07g09.controller.menu;

import org.l07g09.Game;
import org.l07g09.controller.Controller;
import org.l07g09.gui.GUI;
import org.l07g09.model.menu.Instructions;
import org.l07g09.model.menu.Menu;
import org.l07g09.states.InstructionsState;

public class MenuController extends Controller<Menu> {
    public MenuController(Menu menu) {
        super(menu);
    }

    @Override
    public void step(Game game, GUI.Action action) {
        switch (action) {
            case up2:
                getModel().previousEntry();
                break;
            case down2:
                getModel().nextEntry();
                break;
            case select:
                if (getModel().isExit()) {
                    game.setState(null);
                }
                else if (getModel().isStart()) {
                    game.setState(null);
                    game.setFinish(1);
                }
                else {
                    game.setState(new InstructionsState(new Instructions()));
                }
        }
    }
}
