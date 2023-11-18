import com.googlecode.lanterna.graphics.TextGraphics;

public abstract class Objects {
    protected Position pos;
    Objects(int x, int y){
        pos=new Position(x,y);
    }
    public abstract void draw(TextGraphics graphics);
    public void setPos(Position p){
        pos=p;
    }
    public Position getPos(){
        return pos;
    }
}
