package org.l07g09.states;

import org.l07g09.controller.Controller;
import org.l07g09.controller.menu.InstructionsController;
import org.l07g09.model.menu.Instructions;
import org.l07g09.viewer.Viewer;
import org.l07g09.viewer.menu.InstructionsViewer;

public class InstructionsState extends State<Instructions> {
    public InstructionsState(Instructions model) {
        super(model);
    }

    @Override
    protected Viewer<Instructions> getViewer() {
        return new InstructionsViewer(getModel());
    }

    @Override
    protected Controller<Instructions> getController() {
        return new InstructionsController(getModel());
    }
}

