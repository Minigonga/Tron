package org.l07g09.controller.game;

import org.l07g09.Game;
import org.l07g09.gui.GUI;
import org.l07g09.model.Position;
import org.l07g09.model.game.arena.Arena;
import org.l07g09.model.game.element.Player;


public class PlayersController extends GameController {

    public PlayersController(Arena arena) {super(arena);}

    public void jumpPlayer(Player player, int dir) {
        Position pos = player.getPos();
        player.setPos(pos.getNextJumpPos(dir));
    }
    void boostPlayer(Player player, int dir) {
        getModel().boostUsed(player.getNumber());
        getModel().changeBoostsSb();
        for (int i = 0; i < 7; i++) {
            movePlayer(player, dir);
            getModel().collision();
        }
    }
    public void movePlayer(Player player, int dir1) {
        Position pos = player.getPos();
        player.setPos(pos.getNextPos(dir1));
        player.incTrail(pos, player.getColor());
    }
    public void setPlayer1Direction(int direction) {
        getModel().getPlayer1().setDirection(direction);
    }
    public void setPlayer2Direction(int direction) {
        getModel().getPlayer2().setDirection(direction);
    }
    @Override
    public void step(Game game, GUI.Action action) {
        Player p1 = getModel().getPlayer1();
        Player p2 = getModel().getPlayer2();
        int mov1=0;
        int mov2=0;
        int dir1 = p1.getDirection(), dir2 = p2.getDirection();
        if (action == GUI.Action.up1 && dir1 != 2) setPlayer1Direction(0);
        if (action == GUI.Action.right1 && dir1 != 3) setPlayer1Direction(1);
        if (action == GUI.Action.down1 && dir1 != 0) setPlayer1Direction(2);
        if (action == GUI.Action.left1 && dir1 != 1) setPlayer1Direction(3);
        if (action == GUI.Action.jump1){mov1=1;}
        if (action == GUI.Action.boost1){mov1=2;}

        if (action == GUI.Action.up2 && dir2 != 2) setPlayer2Direction(0);
        if (action == GUI.Action.right2 && dir2 != 3) setPlayer2Direction(1);
        if (action == GUI.Action.down2 && dir2 != 0) setPlayer2Direction(2);
        if (action == GUI.Action.left2 && dir2 != 1) setPlayer2Direction(3);
        if (action == GUI.Action.jump2){mov2=1;}
        if (action == GUI.Action.boost2){mov2=2;}

        if (mov1 == 0) movePlayer(p1,dir1);
        else if (mov1 == 1) jumpPlayer(p1, dir1);
        else {
            if(getModel().getBoost(p1.getNumber())==0) movePlayer(p1,dir1);
            else boostPlayer(p1, dir1);
        }

        if (mov2 == 0) movePlayer(p2,dir2);
        else if (mov2 == 1) jumpPlayer(p2, dir2);
        else {
            if(getModel().getBoost(p2.getNumber())==0) movePlayer(p2,dir2);
            else boostPlayer(p2, dir2);
        }
    }
}
