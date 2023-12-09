package org.l07g09.model.game.scoreboard;

import org.l07g09.model.Position;
import org.l07g09.model.game.element.Block;

import java.util.ArrayList;
import java.util.List;


public class ScoreBoard {

    List<Block> score1View;


    List<Block> score2View;
    List<Block> player1View, player2View;
    List<Block> boost1View, boost2View;
    List<Block> boostLeftView;
    List<Block> backMenuView;
    public ScoreBoard(int score1, int score2, int boost1, int boost2) {
        makeScore(score1, score2);
        makeBoost(boost1, boost2);
    }
    public void makeScore(int score1, int score2) {
        makeZeroScore(2);
        makeOneScore(1);
        /*if (score1 == 0) makeZeroScore(1);
        else if (score1 == 1) makeOneScore(1);
        else if (score1 == 2) makeTwoScore(1);
        else if (score1 == 3) makeThreeScore(1);
        if (score2 == 0) makeZeroScore(2);
        else if (score2 == 1) makeOneScore(2);
        else if (score2 == 2) makeTwoScore(2);
        else if (score2 == 3) makeThreeScore(2);*/
    }

    private void makeBoost(int boost1, int boost2) {
    }

    public void makeZeroScore(int who) {
        String color = "#FFFFFF";
        List<Block> local = new ArrayList<>();
        int y;
        if (who == 1) y = 70; else y=95;
        for (int c = 0; c < 12; c++) {
            local.add(new Block(c+228, y, color));
            local.add(new Block(c+228, y+13, color));
        }
        for (int r = 0; r < 14; r++) {
            local.add(new Block(228, r+y, color));
            local.add(new Block(239, r+y, color));
        }
        if (who == 1) score1View = local; else score2View = local;
    }

    public void makeTwoScore(int who) {

    }
    public void makeThreeScore(int who) {

    }
    public List<Block> getScore1View() {
        return score1View;
    }
    public List<Block> getScore2View() {
        return score2View;
    }
}
