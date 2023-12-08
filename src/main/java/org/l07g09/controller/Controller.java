package org.l07g09.controller;

import org.l07g09.Game;
import org.l07g09.gui.GUI;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

public abstract class Controller<T> {
    private final T model;

    public Controller(T model) {
        this.model = model;
    }

    public T getModel() {
        return model;
    }

    public abstract void step(Game game, GUI.Action action) throws IOException, URISyntaxException, FontFormatException;
}
