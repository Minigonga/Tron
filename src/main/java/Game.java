import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Game {
    final Player p1;
    final Player p2;
    final int height;
    final int width;
    final List<Wall> walls;
    final Terminal terminal;
    final Screen screen;
    Game() throws IOException{
        height = 50;
        width = 150;
        TerminalSize terminalSize = new TerminalSize(width, height);
        DefaultTerminalFactory terminalFactory = new DefaultTerminalFactory().setInitialTerminalSize(terminalSize);
        terminal = terminalFactory.createTerminal();
        screen = new TerminalScreen(terminal);
        screen.setCursorPosition(null);
        screen.startScreen();
        screen.doResizeIfNecessary();
        p1 = new Player(65,30,"#FFFFFF");
        p2 = new Player(125,30,"#987654");
        this.walls = createWalls();
    }

    private List<Wall> createWalls() {
        List<Wall> walls = new ArrayList<>();
        for (int c = 0; c < width; c++) {
            walls.add(new Wall(c, 0));
            walls.add(new Wall(c, height - 1));
        }
        for (int r = 1; r < height - 1; r++) {
            walls.add(new Wall(0, r));
            walls.add(new Wall(width - 1, r));
        }
        return walls;
    }

    public void draw() throws IOException{
        TextGraphics graphics = screen.newTextGraphics();
        graphics.setBackgroundColor(TextColor.Factory.fromString("#000000"));
        graphics.fillRectangle(new TerminalPosition(0, 0), new TerminalSize(width, height), ' ');
        p1.draw(graphics);
        p2.draw(graphics);
        for (Wall wall: walls){
            wall.draw(graphics);
        }
        screen.refresh();
    }
    public boolean collision(Player p){
        for (Wall wall : walls){
            if (p.getPos().equals(wall.getPos())){return true;}
        }
        for (Position position: p1.getTrail()){
            if (p.getPos().equals(position)){return true;}
        }
        for (Position position: p2.getTrail()){
            if (p.getPos().equals(position)){return true;}
        }
        return p1.getPos().equals(p2.getPos());
    }
    public void run() throws IOException{
        byte right = 0;
        byte left = 1;
        byte down = 2;
        byte up = 3;
        long i = 0;
        p1.setDirection(down);
        p2.setDirection(right);
        draw();
        boolean flag= true;
        while (flag) {
            i++;
            if (collision(p1)){
                flag=false;
                if (collision(p2)){
                    System.out.println("Draw");
                }
                else{
                    System.out.println("P2 WON");
                    break;
                }
            }
            else if (collision(p2)) {
                System.out.println("P1 WON");
                flag = false;
            }
            if (i%90000 == 0) {
                KeyStroke key = terminal.pollInput();
                // Handle keyboard input
                if (key != null) {
                    if (key.getKeyType() == KeyType.ArrowLeft) {
                        if(p1.getDirection() != right) {p1.setDirection(left);}
                    } else if (key.getKeyType() == KeyType.ArrowRight) {
                        if(p1.getDirection() != left) {p1.setDirection(right);}
                    } else if (key.getKeyType() == KeyType.ArrowUp) {
                        if(p1.getDirection() != down) {p1.setDirection(up);}
                    } else if (key.getKeyType() == KeyType.ArrowDown) {
                        if(p1.getDirection() != up) {p1.setDirection(down);}
                    }else if (key.getKeyType() == KeyType.Character && key.getCharacter()=='a') {
                        if(p2.getDirection() != right) {p2.setDirection(left);}
                    } else if (key.getKeyType() == KeyType.Character && key.getCharacter()=='d') {
                        if(p2.getDirection() != left) {p2.setDirection(right);}
                    } else if (key.getKeyType() == KeyType.Character && key.getCharacter()=='w') {
                        if(p2.getDirection() != down) {p2.setDirection(up);}
                    } else if (key.getKeyType() == KeyType.Character && key.getCharacter()=='s') {
                        if (p2.getDirection() != up) {p2.setDirection(down);}
                    }else if (key.getKeyType() == KeyType.Escape) {
                        screen.close();
                    } else if (key.getKeyType()==KeyType.EOF) {
                        break;
                    }
                }
                p1.move();
                p2.move();
                draw();
            }
        }
        screen.close();
    }
}