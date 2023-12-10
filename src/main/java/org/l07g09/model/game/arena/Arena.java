package org.l07g09.model.game.arena;

import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import org.l07g09.gui.LanternaGUI;
import org.l07g09.model.Position;
import org.l07g09.model.game.element.Block;
import org.l07g09.model.game.element.Player;
import org.l07g09.model.game.scoreboard.ScoreBoard;


import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

public class Arena {
    Player p1, p2;
    int height, width;
    List<Block> walls;
    int score1, score2;
    int boost1, boost2;
    ScoreBoard sb;
    public Arena(int w,int h) {
        width = w;
        height = h;
    }

    public List<Block> getWalls() {return this.walls;}
    public void setWalls(List<Block> walls) {this.walls = walls;}
    public Player getPlayer1(){return this.p1;}
    public Player getPlayer2(){return this.p2;}
    public void setPlayer1(Player p1) {this.p1 = p1;}
    public void setPlayer2 (Player p2) {this.p2 = p2;}

    public int getScore1() {
        return score1;
    }
    public void setScore1(int score1) {
        this.score1 = score1;
    }
    public int getScore2() {
        return score2;
    }
    public void setScore2(int score2) {
        this.score2 = score2;
    }

    public void setSb(ScoreBoard sb) {
        this.sb = sb;
    }
    public ScoreBoard getSb() {
        return sb;
    }
    public void changeBoostsSb() {
        sb.makeBoost(boost1, boost2);
    }

    public void setBoost1(int boost1) {
        this.boost1 = boost1;
    }
    public void setBoost2(int boost2) {
        this.boost2 = boost2;
    }
    public int getBoost(char who) {
        if (who == '1') return boost1;
        else return boost2;
    }
    public void boostUsed(char who) {
        if (who == '1') boost1--;
        else boost2--;
    }

    public void collision(){
        if (p1.getPos().getX()<1 || p1.getPos().getX()>width-52 || p1.getPos().getY()<1 || p1.getPos().getY()>height-1) p1.setCollide(true);
        if (p2.getPos().getX()<1 || p2.getPos().getX()>width-52 || p2.getPos().getY()<1 || p2.getPos().getY()>height-1) p2.setCollide(true);
        for (Block trail: p1.getTrail()){
            Position position = trail.getPos();
            if (p1.getPos().equals(position)){p1.setCollide(true);}
            if (p2.getPos().equals(position)){p2.setCollide(true);}
        }
        for (Block trail: p2.getTrail()){
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
