package org.l07g09.states;

import org.l07g09.Game;
import org.l07g09.controller.Controller;
import org.l07g09.gui.GUI;
import org.l07g09.gui.LanternaGUI;
import org.l07g09.viewer.Viewer;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

public abstract class State<T> {
    private final T model;
    private final Controller<T> controller;
    private final Viewer<T> viewer;

    public State(T model) {
        this.model = model;
        this.viewer = getViewer();
        this.controller = getController();
    }

    protected abstract Viewer<T> getViewer();

    protected abstract Controller<T> getController();

    public T getModel() {
        return model;
    }

    public void step(Game game, GUI gui) throws IOException, URISyntaxException, FontFormatException {
        GUI.Action action = gui.getNextAction();
        controller.step(game, action);
        viewer.draw(gui);
    }
}
