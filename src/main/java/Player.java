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
}
