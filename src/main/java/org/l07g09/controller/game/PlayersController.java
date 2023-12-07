package org.l07g09.controller.game;

import org.l07g09.Game;
import org.l07g09.gui.GUI;
import org.l07g09.model.Position;
import org.l07g09.model.game.arena.Arena;
import org.l07g09.model.game.element.Player;

public class PlayersController extends GameController {

    public PlayersController(Arena arena) {super(arena);}
    void movePlayers(Position pos1, int dir1, Position pos2, int dir2) {
        getModel().getPlayer1().setPos(pos1.getNextPos(dir1));
        getModel().getPlayer2().setPos(pos2.getNextPos(dir2));
    }
    void setPlayer1Direction(int direction) {
        getModel().getPlayer1().setDirection(direction);
    }
    void setPlayer2Direction(int direction) {
        getModel().getPlayer2().setDirection(direction);
    }
    @Override
    public void step(Game game, GUI.Action action, long time) {
        Player p1 = getModel().getPlayer1();
        Player p2 = getModel().getPlayer2();
        int dir1 = p1.getDirection(), dir2 = p2.getDirection();
        if (action == GUI.Action.up1 && dir1 != 2) setPlayer1Direction(0);
        if (action == GUI.Action.right1 && dir1 != 3) setPlayer1Direction(1);
        if (action == GUI.Action.down1 && dir1 != 0) setPlayer1Direction(2);
        if (action == GUI.Action.left1 && dir1 != 1) setPlayer1Direction(3);
        if (action == GUI.Action.up2 && dir2 != 2) setPlayer2Direction(0);
        if (action == GUI.Action.right2 && dir2 != 3) setPlayer2Direction(1);
        if (action == GUI.Action.down2 && dir2 != 0) setPlayer2Direction(2);
        if (action == GUI.Action.left2 && dir2 != 1) setPlayer2Direction(3);
        movePlayers(p1.getPos(), dir1, p2.getPos(), dir2);
    }
}
