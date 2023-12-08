package org.l07g09.viewer.menu;

import org.l07g09.gui.GUI;
import org.l07g09.model.Position;
import org.l07g09.model.menu.Menu;
import org.l07g09.viewer.Viewer;

public class MenuViewer extends Viewer<Menu> {
    public MenuViewer(Menu menu) {
        super(menu);
    }

    @Override
    public void drawElements(GUI gui) {
        gui.drawText(new Position(12, 4), "TRON", "#FFFFFF");
        int k=10;
        for (int i = 0; i < getModel().getNumberEntries(); i++) {
            if (i == 0) {
                gui.drawText(new Position(2, 10), getModel().getEntry(i), getModel().isSelected(i) ? "#FFD700" : "#FFFFFF");}
            if (i == 1) {
                    gui.drawText(new Position(2, 13), getModel().getEntry(i), getModel().isSelected(i) ? "#FFD700" : "#FFFFFF");
            } else if (i == 2) {
                gui.drawText(new Position(2, 16), getModel().getEntry(i), getModel().isSelected(i) ? "#FFD700" : "#FFFFFF");
            }
        }
    }
}