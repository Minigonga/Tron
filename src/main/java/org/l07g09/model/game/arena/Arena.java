package org.l07g09.model.game.arena;

import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import org.l07g09.gui.LanternaGUI;
import org.l07g09.model.Position;
import org.l07g09.model.game.element.Block;
import org.l07g09.model.game.element.Player;


import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

public class Arena {
    Player p1;
    Player p2;
    int height;
    int width;
    List<Block> walls;
    public Arena(int w,int h) {
        width = w;
        height = h;
    }

    public List<Block> getWalls(){return this.walls;}
    public void setWalls(List<Block> walls) {this.walls = walls;}
    public Player getPlayer1(){return this.p1;}

    public Player getPlayer2(){return this.p2;}
    public void setPlayer1(Player p1) {this.p1 = p1;}
    public void setPlayer2 (Player p2) {this.p2 = p2;}

    public void collision(){
        if (p1.getPos().getX()<1 || p1.getPos().getX()>width-51 || p1.getPos().getY()<1 || p1.getPos().getY()>height-1) p1.setCollide(true);
        if (p2.getPos().getX()<1 || p2.getPos().getX()>width-51 || p2.getPos().getY()<1 || p2.getPos().getY()>height-1) p2.setCollide(true);
        for (Block trail: p1.getTrails()){
            Position position = trail.getPos();
            if (p1.getPos().equals(position)){p1.setCollide(true);}
            if (p2.getPos().equals(position)){p2.setCollide(true);}
        }
        for (Block trail: p2.getTrails()){
            Position position = trail.getPos();
            if (p1.getPos().equals(position)){p1.setCollide(true);}
            if (p2.getPos().equals(position)){p2.setCollide(true);}
        }
        if (p1.getPos()==p2.getPos()){
            p1.setCollide(true);
            p2.setCollide(true);
        }
    }
}