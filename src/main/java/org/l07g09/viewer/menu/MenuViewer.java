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
        gui.drawBoldText(new Position(18, 4), "TRON", "#FFFFFF");
        for (int i = 0; i < getModel().getNumberEntries(); i++) {
            if (i == 0) {
                if (getModel().isSelected(i)) gui.drawBlinkText(new Position(2, 10), getModel().getEntry(i), "#FFD700");
                else gui.drawText(new Position(2, 10), getModel().getEntry(i), "#FFFFFF");
            }
            else if (i == 1) {
                if (getModel().isSelected(i)) gui.drawBlinkText(new Position(2, 13), getModel().getEntry(i), "#FFD700");
                else gui.drawText(new Position(2, 13), getModel().getEntry(i), "#FFFFFF");
            }
            else {
                if (getModel().isSelected(i)) gui.drawBlinkText(new Position(2, 16), getModel().getEntry(i), "#FFD700");
                else gui.drawText(new Position(2, 16), getModel().getEntry(i), "#FFFFFF");
            }
        }
    }
}