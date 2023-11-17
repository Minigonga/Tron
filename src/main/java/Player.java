import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

import java.util.ArrayList;

public class Player {
    private Position playerPos;
    private ArrayList<Position> trail;
    Player(int x,int y){
        playerPos = new Position(x,y);
    }

    public Position getPlayerPos() {
        return playerPos;
    }

    public void setPlayerPos(Position playerPos) {
        this.playerPos = playerPos;
    }

    public ArrayList<Position> getTrail() {
        return trail;
    }

    public void setTrail(ArrayList<Position> trail) {
        this.trail = trail;
    }
    public void draw(TextGraphics graphics){
        graphics.setForegroundColor(TextColor.Factory.fromString("#999999"));
        graphics.enableModifiers(SGR.BOLD);
        graphics.putString(new TerminalPosition(playerPos.getX(), playerPos.getY()), "P");
    }
}
