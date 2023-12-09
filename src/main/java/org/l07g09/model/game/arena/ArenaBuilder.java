package org.l07g09.model.game.arena;

import org.l07g09.model.game.element.Block;
import org.l07g09.model.game.element.Player;
import org.l07g09.model.game.scoreboard.ScoreBoard;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

public class ArenaBuilder {
    private int width, height;
    public Arena createArena(int score1, int score2)  {
        width = 240;
        height = 190;
        Arena arena = new Arena(width, height);
        arena.setPlayer1(createPlayer1());
        arena.setPlayer2(createPlayer2());
        arena.setWalls(createWalls());
        arena.setScore1(score1);
        arena.setScore2(score2);
        arena.setBoost1(3);
        arena.setBoost2(3);
        arena.setSb(new ScoreBoard(score1, score2,3,3));
        return arena;
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
    public Player createPlayer1() {
        return new Player(55,30,"#FFFFFF", '1', 2);
    }

    public Player createPlayer2() {
        return new Player(100,40,"#987654", '2', 2);
    }
}

