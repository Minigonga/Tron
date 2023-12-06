package org.l07g09.model.game;

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
    final Player p1;
    final Player p2;
    final int height;
    final int width;
    final List<Block> walls;
    final LanternaGUI gui;
    public Arena() throws IOException, FontFormatException, URISyntaxException {
        this.gui = new LanternaGUI(190,240);
        height = 190;
        width = 240;
        p1 = new Player(55,30,"#FFFFFF", '1');
        p2 = new Player(100,40,"#987654", '2');
        this.walls = createWalls();
    }

    private List<Block> createWalls() {
        String color = "#0000FF";
        List<Block> walls = new ArrayList<>();
        for (int c = 0; c < width -50; c++) {
            walls.add(new Block(c, 0, color));
            walls.add(new Block(c, height - 1, color));
        }
        for (int r = 1; r < height - 1; r++) {
            walls.add(new Block(0, r, color));
            walls.add(new Block(width - 51, r, color));
        }
        return walls;
    }

    public List<Block> getWalls(){return this.walls;}

    public Player getPlayer1(){return this.p1;}

    public Player getPlayer2(){return this.p2;}


    public void collision(){
        if (p1.getPos().getX()<1 || p1.getPos().getX()>width-1 || p1.getPos().getY()<1 || p1.getPos().getY()>height-1) p1.setCollide(true);
        if (p2.getPos().getX()<1 || p2.getPos().getX()>width-1 || p2.getPos().getY()<1 || p2.getPos().getY()>height-1) p2.setCollide(true);
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

    public void run() throws IOException{
        long i = 0;
        p1.setDirection(0);
        p2.setDirection(3);
        while (true) {
            i++;
            if (i%20000000 == 0) {
                collision();
                collision();
                if (p1.getCollide() || p2.getCollide()) {
                    break;
                }
            }
        }
        if (p1.getCollide()){
            if (p2.getCollide()){
                System.out.println("Draw");
            }
            else{
                System.out.println("P2 WON");
            }
        }
        else {
            System.out.println("P1 WON");
        }
    }
}