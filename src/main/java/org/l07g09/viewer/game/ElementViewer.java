package org.l07g09.viewer.game;

import org.l07g09.gui.GUI;
import org.l07g09.model.game.element.Element;

public interface ElementViewer<T extends Element> {
    void draw(T element, GUI gui);
}