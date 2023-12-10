package org.l07g09.model.game.scoreboard;

import org.l07g09.model.game.element.Block;

import java.util.ArrayList;
import java.util.List;

public class ScoreBoard {

    List<Block> score1View, score2View;
    List<Block> boost1View, boost2View;
    public ScoreBoard(int score1, int score2, int boost1, int boost2) {
        makeScore(score1, score2);
        makeBoost(boost1, boost2);
    }
    public void makeScore(int score1, int score2) {
        if (score1 == 0) makeZeroScore(1);
        else if (score1 == 1) makeOneScore(1);
        else if (score1 == 2) makeTwoScore(1);
        else if (score1 == 3) makeThreeScore(1);
        if (score2 == 0) makeZeroScore(2);
        else if (score2 == 1) makeOneScore(2);
        else if (score2 == 2) makeTwoScore(2);
        else if (score2 == 3) makeThreeScore(2);
    }
    public void makeBoost(int boost1, int boost2) {
        if (boost1 == 0) makeZeroBoost(1);
        else if (boost1 == 1) makeOneBoost(1);
        else if (boost1 == 2) makeTwoBoost(1);
        else if (boost1 == 3) makeThreeBoost(1);
        if (boost2 == 0) makeZeroBoost(2);
        else if (boost2 == 1) makeOneBoost(2);
        else if (boost2 == 2) makeTwoBoost(2);
        else if (boost2 == 3) makeThreeBoost(2);
    }

    public void makeZeroScore(int who) {
        String color = "#FFFFFF";
        List<Block> local = new ArrayList<>();
        int y = 70;
        if (who == 2) {
            color = "#987654";
            y = 95;
        }
        for (int c = 0; c < 12; c++) {
            if (c==0 || c == 11) for (int r = 0; r < 12; r++) local.add(new Block(c+228, r + y+1, color));
            if (c==1 || c == 10) for (int r = 0; r < 14; r++) local.add(new Block(c+228, r + y, color));
            if(c>=2 && c<=9) {
                for (int r = 0; r < 2; r++) {
                    local.add(new Block(c + 228, r + y, color));
                    local.add(new Block(c + 228, r + y + 12, color));
                }
            }
        }
        if (who == 1) score1View = local; else score2View = local;
    }
    public void makeOneScore(int who) {
        String color = "#FFFFFF";
        List<Block> local = new ArrayList<>();
        int y = 70;
        if (who == 2) {
            color = "#987654";
            y = 95;
        }
        for (int c = 0; c < 12; c++) {
            if (c <= 3 || c >= 7) for (int r = 0; r < 3; r++) local.add(new Block(c+228, r + y+11, color));
            if (c == 2) for (int r = 0; r < 2; r++) local.add(new Block(c+228, r + y+3, color));
            if (c == 3) for (int r = 0; r < 3; r++) local.add(new Block(c+228, r + y+2, color));
            if (c >= 4 && c <=6) for (int r = 0; r <14; r++) local.add(new Block(c+228, r + y, color));
        }
        if (who == 1) score1View = local; else score2View = local;
    }
    public void makeTwoScore(int who) {
        String color = "#FFFFFF";
        List<Block> local = new ArrayList<>();
        int y = 70;
        if (who == 2) {
            color = "#987654";
            y = 95;
        }
        for (int c = 0; c < 12; c++) {
            for (int r = 0; r < 2; r++) local.add(new Block(c+228, r + y+12, color));
            if (c == 0) for (int r = 0; r < 3; r++) local.add(new Block(c+228, r + y+2, color));
            if (c == 1) {
                for (int r = 0; r < 4; r++) local.add(new Block(c+228, r + y+1, color));
                local.add(new Block(c+228, y+11, color));
            }
            if (c == 2) {
                for (int r = 0; r < 3; r++) local.add(new Block(c+228, r + y, color));
                for (int r = 0; r < 2; r++) local.add(new Block(c+228, r + y+10, color));
            }
            if (c == 3) {
                for (int r = 0; r < 2; r++) local.add(new Block(c+228, r + y, color));
                for (int r = 0; r < 3; r++) local.add(new Block(c+228, r + y+9, color));
            }
            if (c == 4) {
                for (int r = 0; r < 2; r++) local.add(new Block(c+228, r + y, color));
                for (int r = 0; r < 3; r++) local.add(new Block(c+228, r + y+8, color));
            }
            if (c == 5) {
                for (int r = 0; r < 2; r++) local.add(new Block(c+228, r + y, color));
                for (int r = 0; r < 3; r++) local.add(new Block(c+228, r + y+7, color));
            }
            if (c == 6) {
                for (int r = 0; r < 2; r++) local.add(new Block(c+228, r + y, color));
                for (int r = 0; r < 3; r++) local.add(new Block(c+228, r + y+6, color));
            }
            if (c == 7) {
                for (int r = 0; r < 3; r++) local.add(new Block(c+228, r + y, color));
                for (int r = 0; r < 3; r++) local.add(new Block(c+228, r + y+5, color));
            }
            if (c == 8) for (int r = 0; r < 7; r++) local.add(new Block(c+228, r + y, color));
            if (c == 9) for (int r = 0; r < 5; r++) local.add(new Block(c+228, r + y+1, color));
            if (c == 10) for (int r = 0; r < 3; r++) local.add(new Block(c+228, r + y+2, color));
        }
        if (who == 1) score1View = local; else score2View = local;
    }
    public void makeThreeScore(int who) {
        String color = "#FFFFFF";
        List<Block> local = new ArrayList<>();
        int y = 70;
        if (who == 2) {
            color = "#987654";
            y = 95;
        }
        for (int c = 0; c < 12; c++) {
            if (c == 0) {
                for (int r = 0; r < 3; r++) local.add(new Block(c+228, r + y+2, color));
                for (int r = 0; r < 3; r++) local.add(new Block(c+228, r + y+9, color));
            }
            if (c == 1) {
                for (int r = 0; r < 5; r++) local.add(new Block(c+228, r + y, color));
                for (int r = 0; r < 5; r++) local.add(new Block(c+228, r + y+9, color));
            }
            if (c == 2) {
                for (int r = 0; r < 3; r++) local.add(new Block(c+228, r + y, color));
                for (int r = 0; r < 3; r++) local.add(new Block(c+228, r + y+11, color));
            }
            if (c >= 3 && c <=8) {
                for (int r = 0; r < 2; r++) local.add(new Block(c+228, r + y, color));
                for (int r = 0; r < 2; r++) local.add(new Block(c+228, r + y+12, color));
            }
            if (c == 6) for (int r = 0; r < 2; r++) local.add(new Block(c+228, r + y+6, color));
            if (c == 7) for (int r = 0; r < 4; r++) local.add(new Block(c+228, r + y+5, color));
            if (c == 8) for (int r = 0; r < 6; r++) local.add(new Block(c+228, r + y+4, color));
            if (c == 9) {
                for (int r = 0; r < 6; r++) local.add(new Block(c+228, r + y, color));
                for (int r = 0; r < 6; r++) local.add(new Block(c+228, r + y+8, color));
            }
            if (c == 10) {
                for (int r = 0; r < 4; r++) local.add(new Block(c+228, r + y+1, color));
                for (int r = 0; r < 4; r++) local.add(new Block(c+228, r + y+9, color));
            }
        }
        if (who == 1) score1View = local; else score2View = local;
    }
    public void makeZeroBoost(int who) {
        String color = "#FFFFFF";
        List<Block> local = new ArrayList<>();
        int y = 53;
        if (who == 2) {
            y = 119;
            color = "#987654";
        }
        for (int c = 0; c < 5; c++) {
            local.add(new Block(c+231, y, color));
            local.add(new Block(c+231, y+7, color));
        }
        for (int r = 0; r < 8; r++) {
            local.add(new Block(231, r+y, color));
            local.add(new Block(236, r+y, color));
        }
        if (who == 1) boost1View = local;
        else boost2View = local;
    }
    public void makeOneBoost(int who) {
        String color = "#FFFFFF";
        List<Block> local = new ArrayList<>();
        int y = 53;
        if (who == 2) {
            y = 119;
            color = "#987654";
        }
        for (int c = 0; c < 5; c++) {
            if (c != 2) for (int r = 0; r < 2; r++) local.add(new Block(c+231, r + y+6, color));
            if (c == 1) for (int r = 0; r < 1; r++) local.add(new Block(c+231, r + y+2, color));
            if (c == 2) for (int r = 0; r <8; r++) local.add(new Block(c+231, r + y, color));
        }
        if (who == 1) boost1View = local;
        else boost2View = local;
    }
    public void makeTwoBoost(int who) {
        String color = "#FFFFFF";
        List<Block> local = new ArrayList<>();
        int y = 53;
        if (who == 2) {
            y = 119;
            color = "#987654";
        }
        for (int c = 0; c < 5; c++) {
            local.add(new Block(c + 231, y + 7, color));
            if (c == 0){
                for (int r = 0; r < 2; r++) local.add(new Block(c + 231, r + y + 1, color));
                local.add(new Block(c + 231, y + 6, color));
            }
            if (c == 1) {
                for (int r = 0; r < 2; r++) local.add(new Block(c + 231, r + y, color));
                for (int r = 0; r < 2; r++) local.add(new Block(c + 231, r + y + 5, color));
            }
            if (c == 2) {
                local.add(new Block(c + 231, y, color));
                for (int r = 0; r < 2; r++) local.add(new Block(c + 231, r + y + 4, color));
            }
            if (c == 3) {
                for (int r = 0; r < 2; r++) local.add(new Block(c + 231, r + y, color));
                for (int r = 0; r < 2; r++) local.add(new Block(c + 231, r + y + 3, color));
            }
            if (c == 4) {
                for (int r = 0; r < 3; r++) local.add(new Block(c + 231, r + y + 1, color));
            }
            if (who == 1) boost1View = local;
            else boost2View = local;
        }
    }
    public void makeThreeBoost(int who) {
        String color = "#FFFFFF";
        List<Block> local = new ArrayList<>();
        int y = 53;
        if (who == 2) {
            y = 119;
            color = "#987654";
        }
        for (int c = 0; c < 5; c++) {
            if (c == 0) {
                for (int r = 0; r < 2; r++) {
                    local.add(new Block(c + 231, r + y + 1, color));
                    local.add(new Block(c + 231, r + y + 5, color));
                }
            }
            if (c == 1) {
                for (int r = 0; r < 2; r++) {
                    local.add(new Block(c + 231, r + y, color));
                    local.add(new Block(c + 231, r + y + 6, color));
                }
            }
            if (c == 2) {
                local.add(new Block(c + 231,  y, color));
                for (int r = 0; r < 2; r++) local.add(new Block(c + 231,  r + y + 3, color));
                local.add(new Block(c + 231,  y + 7, color));
            }
            if (c == 3) {
                for (int r = 0; r < 8; r++) local.add(new Block(c + 231, r + y, color));
            }
            if (c == 4) {
                for (int r = 0; r < 2; r++) {
                    local.add(new Block(c + 231, r + y + 1, color));
                    local.add(new Block(c + 231, r + y + 5, color));
                }
            }
        }
        if (who == 1) boost1View = local;
        else boost2View = local;
    }

    public List<Block> getScore1View() {
        return score1View;
    }
    public List<Block> getScore2View() {
        return score2View;
    }
    public List<Block> getBoost1View() {
        return boost1View;
    }

    public List<Block> getBoost2View() {
        return boost2View;
    }
}
