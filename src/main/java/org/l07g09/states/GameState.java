package org.l07g09.states;

import org.l07g09.controller.Controller;
import org.l07g09.controller.game.ArenaController;
import org.l07g09.model.game.Arena;
import org.l07g09.viewer.Viewer;
import org.l07g09.viewer.game.GameViewer;

public class GameState extends State<Arena> {
    public GameState(Arena arena) {
        super(arena);
    }

    @Override
    protected Viewer<Arena> getViewer() {
        return new GameViewer(getModel());
    }

    @Override
    protected Controller<Arena> getController() {
        return new ArenaController(getModel());
    }
}
