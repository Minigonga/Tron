package org.l07g09.model.game.arena;

import org.l07g09.model.Position;
import org.l07g09.model.game.element.Block;
import org.l07g09.model.game.element.Player;
import org.l07g09.model.game.scoreboard.ScoreBoard;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ArenaBuilder {
    private int width, height;
    public Arena createArena(int score1, int score2)  {
        width = 240;
        height = 190;
        Arena arena = new Arena(width, height);
        Position pos =randomPosLoader();
        int dir = randomDirLoader(pos);
        arena.setPlayer1(createPlayer1(pos,dir));
        if (dir==1 || dir==3) dir = (dir+2)%4;
        arena.setPlayer2(createPlayer2(pos,dir));
        arena.setWalls(createWalls());
        arena.setScore1(score1);
        arena.setScore2(score2);
        arena.setBoost1(3);
        arena.setBoost2(3);
        arena.setJumpCd1(0);
        arena.setJumpCd2(0);
        arena.setSb(new ScoreBoard(score1, score2,3,3));
        return arena;
    }

    private List<Block> createWalls() {
        String color = "#808076";
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
    private Position randomPosLoader(){
        Random rand = new Random();
        int x = rand.nextInt(40);
        int y = rand.nextInt(150);
        int l = rand.nextInt(2);
        if (l==0) return new Position(x+45,y+20);
        else return new Position(x+135,y+20);
    }
    private int randomDirLoader(Position pos){
        int y = pos.getY();
        List <Integer> directions = new ArrayList<>();
        if (y<=150) directions.add(2);
        if (y>=40) directions.add(0);
        if (pos.getX()>=95) directions.add(1);
        else directions.add(3);
        Random rand = new Random();
        return directions.get(rand.nextInt(directions.size()));
    }

    public Player createPlayer1(Position pos, int dir) {
        return new Player(pos.getX(),pos.getY(),"#9DD9F3", '1', dir);
    }

    public Player createPlayer2(Position pos, int dir) {
        return new Player(190-pos.getX(),pos.getY(),"#EC9706", '2', dir);
    }
}

