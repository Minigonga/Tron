package org.l07g09.controller.game;

import org.l07g09.Game;
import org.l07g09.gui.GUI;
import org.l07g09.model.game.arena.Arena;
import org.l07g09.model.game.arena.ArenaBuilder;
import org.l07g09.model.menu.Menu;
import org.l07g09.states.GameState;
import org.l07g09.states.MenuState;


public class ArenaController extends GameController {
    private final PlayersController playersController;

    public ArenaController(Arena arena) {
        super(arena);
        this.playersController = new PlayersController(arena);
    }
    @Override
    public void step(Game game, GUI.Action action) {
        Arena arena = getModel();
        int score1 = arena.getScore1(), score2 = arena.getScore2();
        if (action == GUI.Action.exit) {
            game.setState(null);
        } else {
            playersController.step(game, action);
        }
        arena.collision();
        if (arena.getPlayer1().getCollide()){
            if (!arena.getPlayer2().getCollide()){
                if(score1+1==4 || score2==4) game.setState(null);
                else game.setState(new GameState(new ArenaBuilder().createArena(score1+1, score2)));
            } else {
                game.setState(new GameState(new ArenaBuilder().createArena(score1, score2)));
            }
        }
        else if (arena.getPlayer2().getCollide()) {
            if(score1==4 || score2+1==4) game.setState(null);
            else game.setState(new GameState(new ArenaBuilder().createArena(score1, score2+1)));
        }
    }
}
