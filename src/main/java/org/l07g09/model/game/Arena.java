package org.l07g09.model.game;

import com.googlecode.lanterna.*;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import com.googlecode.lanterna.terminal.swing.AWTTerminalFontConfiguration;
import org.l07g09.model.Position;
import org.l07g09.model.game.element.Player;
import org.l07g09.model.game.element.Trail;
import org.l07g09.model.game.element.Wall;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class Arena {
    final Player p1;
    final Player p2;
    final int height;
    final int width;
    final List<Wall> walls;
    final Terminal terminal;
    final Screen screen;
    public Arena() throws IOException, FontFormatException, URISyntaxException {
        height = 190;
        width = 240;
        URL resource = getClass().getClassLoader().getResource("square.ttf");
        File fontFile = new File(resource.toURI());
        Font font =  Font.createFont(Font.TRUETYPE_FONT, fontFile);

        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        ge.registerFont(font);

        DefaultTerminalFactory factory = new DefaultTerminalFactory();

        Font loadedFont = font.deriveFont(Font.PLAIN, 4);
        AWTTerminalFontConfiguration fontConfig = AWTTerminalFontConfiguration.newInstance(loadedFont);
        factory.setTerminalEmulatorFontConfiguration(fontConfig);
        factory.setForceAWTOverSwing(true);
        factory.setInitialTerminalSize(new TerminalSize(width, height));

        terminal = factory.createTerminal();
        screen = new TerminalScreen(terminal);
        screen.setCursorPosition(null);   // we don't need a cursor
        screen.startScreen();             // screens must be started
        screen.doResizeIfNecessary();     // resize screen if necessary

        screen.refresh();

        p1 = new Player(55,30,"#FFFFFF", "1");
        p2 = new Player(100,40,"#987654", "2");
        this.walls = createWalls();
    }

    private List<Wall> createWalls() {
        String color = "#0000FF";
        List<Wall> walls = new ArrayList<>();
        for (int c = 0; c < width -50; c++) {
            walls.add(new Wall(c, 0, color));
            walls.add(new Wall(c, height - 1, color));
        }
        for (int r = 1; r < height - 1; r++) {
            walls.add(new Wall(0, r, color));
            walls.add(new Wall(width - 51, r, color));
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
    public void collision(){
        for (Wall wall : walls){
            if (p1.getPos().equals(wall.getPos())){p1.setCollide(true);}
            if (p2.getPos().equals(wall.getPos())){p2.setCollide(true);}
        }
        for (Trail trail: p1.getTrails()){
            Position position = trail.getPos();
            if (p1.getPos().equals(position)){p1.setCollide(true);}
            if (p2.getPos().equals(position)){p2.setCollide(true);}
        }
        for (Trail trail: p2.getTrails()){
            Position position = trail.getPos();
            if (p1.getPos().equals(position)){p1.setCollide(true);}
            if (p2.getPos().equals(position)){p2.setCollide(true);}
        }
        if (p1.getPos()==p2.getPos()){
            p1.setCollide(true);
            p2.setCollide(true);
        }
    }
    public void run() throws IOException{
        byte right = 0;
        byte left = 1;
        byte down = 2;
        byte up = 3;
        long i = 0;
        p1.setDirection(right);
        p2.setDirection(up);
        draw();
        while (true) {
            i++;
            if (i%20000000 == 0) {
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
                    }else if (key.getKeyType() == KeyType.Character && (key.getCharacter()=='a' || key.getCharacter()=='A')) {
                        if(p2.getDirection() != right) {p2.setDirection(left);}
                    } else if (key.getKeyType() == KeyType.Character && (key.getCharacter()=='d' || key.getCharacter()=='D')) {
                        if(p2.getDirection() != left) {p2.setDirection(right);}
                    } else if (key.getKeyType() == KeyType.Character && (key.getCharacter()=='w' || key.getCharacter()=='W')) {
                        if(p2.getDirection() != down) {p2.setDirection(up);}
                    } else if (key.getKeyType() == KeyType.Character && (key.getCharacter()=='s' || key.getCharacter()=='S')) {
                        if (p2.getDirection() != up) {p2.setDirection(down);}
                    }else if (key.getKeyType() == KeyType.Escape) {
                        screen.close();
                    } else if (key.getKeyType()==KeyType.EOF) {
                        break;
                    }
                }
                p1.move();
                collision();
                p2.move();
                collision();
                if (p1.getCollide() || p2.getCollide()) {
                    break;
                }
                draw();
            }
        }
        if (p1.getCollide()){
            if (p2.getCollide()){
                System.out.println("Draw");
            }
            else{
                System.out.println("P2 WON");
            }
        }
        else {
            System.out.println("P1 WON");
        }
        screen.close();
    }
}