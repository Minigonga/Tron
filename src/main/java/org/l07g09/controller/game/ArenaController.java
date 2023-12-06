package org.l07g09.controller.game;

import org.l07g09.Game;
import org.l07g09.gui.GUI;
import org.l07g09.model.game.Arena;


public class ArenaController extends GameController {
    private final PlayersController playersController;

    public ArenaController(Arena arena) {
        super(arena);
        this.playersController = new PlayersController(arena);
    }
    @Override
    public void step(Game game, GUI.Action action, long time) {
        if (action == GUI.Action.exit) {
            game.setState(null);
        } else {
            playersController.step(game, action, time);
        }
    }
}
