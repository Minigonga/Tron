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
    private Player p1;
    private Player p2;
    private int height;
    private int width;
    private List<Wall> walls;
    private Terminal terminal;
    private Screen screen;
    Game() throws IOException{
        p1 = new Player(40,10,"#FFFFFF");
        p2 = new Player(4,3,"#987654");
        height = 86;
        width = 191;
        this.walls = createWalls();
        TerminalSize terminalSize = new TerminalSize(width, height);
        DefaultTerminalFactory terminalFactory = new DefaultTerminalFactory().setInitialTerminalSize(terminalSize);
        terminal = terminalFactory.createTerminal();
        screen = new TerminalScreen(terminal);
        screen.setCursorPosition(null);
        screen.startScreen();
        screen.doResizeIfNecessary();
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

    public void run() throws IOException{
        byte right = 0;
        byte left = 1;
        byte down = 2;
        byte up = 3;
        long i = 0;
        p1.setDirection(down);
        draw();
        while (true) {
            i++;
            if (i%30000000 == 0) {
                KeyStroke key = terminal.pollInput();
                // Handle keyboard input
                if (key != null) {
                    if (key.getKeyType() == KeyType.ArrowLeft) {
                        System.out.println("a");
                        if(p1.getDirection() != right) {p1.setDirection(left);}
                    } else if (key.getKeyType() == KeyType.ArrowRight) {
                        if(p1.getDirection() != left) {p1.setDirection(right);}
                    } else if (key.getKeyType() == KeyType.ArrowUp) {
                        if(p1.getDirection() != down) {p1.setDirection(up);}
                    } else if (key.getKeyType() == KeyType.ArrowDown) {
                        if(p1.getDirection() != up) {p1.setDirection(down);}
                    } else if (key.getKeyType() == KeyType.Escape) {
                        screen.close();
                    } else if (key.getKeyType()==KeyType.EOF) {
                        break;
                    }
                }
                p1.move();
                draw();
            }

        }
    }
}