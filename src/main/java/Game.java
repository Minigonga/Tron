import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;

import java.io.IOException;

public class Game {
    private Player p1;
    private Player p2;
    private int heigth;
    private int width;
    Screen screen;
    Game() throws IOException{
        p1 = new Player(1,1,"#123456");
        p2 = new Player(4,3,"#987654");
        heigth = 80;
        width = 80;
        TerminalSize terminalSize = new TerminalSize(width, heigth);
        DefaultTerminalFactory terminalFactory = new DefaultTerminalFactory().setInitialTerminalSize(terminalSize);
        Terminal terminal = terminalFactory.createTerminal();
        screen = new TerminalScreen(terminal);
        screen.setCursorPosition(null);
        screen.startScreen();
        screen.doResizeIfNecessary();
    }

    public void draw() throws IOException{
        screen.clear();
        p1.draw(screen.newTextGraphics());
        p2.draw(screen.newTextGraphics());
        screen.refresh();
    }

    public void run() throws IOException{
            while (true){
                draw();
            }
    }
}
