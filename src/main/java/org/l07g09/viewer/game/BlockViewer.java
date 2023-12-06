package org.l07g09.viewer.game;
import org.l07g09.gui.GUI;
import org.l07g09.model.game.element.Block;


public class BlockViewer implements ElementViewer<Block> {
    @Override
    public void draw(Block block, GUI gui) {
        gui.drawBlock(block);
    }
}