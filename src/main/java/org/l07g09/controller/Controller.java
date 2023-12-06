package org.l07g09.controller;

import org.l07g09.Game;
import org.l07g09.gui.GUI;

import java.io.IOException;

public abstract class Controller<T> {
    private final T model;

    public Controller(T model) {
        this.model = model;
    }

    public T getModel() {
        return model;
    }

    public abstract void step(Game game, GUI.Action action, long time) throws IOException;
}
