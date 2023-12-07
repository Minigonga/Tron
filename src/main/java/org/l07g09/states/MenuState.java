package org.l07g09.states;

import org.l07g09.controller.Controller;
import org.l07g09.controller.menu.MenuController;
import org.l07g09.model.menu.Menu;
import org.l07g09.viewer.Viewer;
import org.l07g09.viewer.menu.MenuViewer;

public class MenuState extends State<Menu> {
    public MenuState(Menu model) {
        super(model);
    }

    @Override
    protected Viewer<Menu> getViewer() {
        return new MenuViewer(getModel());
    }

    @Override
    protected Controller<Menu> getController() {
        return new MenuController(getModel());
    }
}
