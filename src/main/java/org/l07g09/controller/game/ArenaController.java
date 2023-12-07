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
        getModel().collision();
        if (getModel().getPlayer1().getCollide()){
            game.setState(null);
            if (getModel().getPlayer2().getCollide()){
                System.out.println("DRAW");
            }
            else{
                System.out.println("P2 WIN");            }
        }
        else if (getModel().getPlayer2().getCollide()) {
            game.setState(null);
            System.out.println("P1 WIN");
        }
    }
}
