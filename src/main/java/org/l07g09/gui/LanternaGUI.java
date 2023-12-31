package org.l07g09.gui;

import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import com.googlecode.lanterna.terminal.swing.AWTTerminalFontConfiguration;
import org.l07g09.model.Position;
import org.l07g09.model.game.element.Block;
import org.l07g09.model.game.element.Player;


import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;


public class LanternaGUI implements GUI {
    private final Screen screen;

    public LanternaGUI(Screen screen) {
        this.screen = screen;
    }

    public LanternaGUI(int width, int height, int size) throws IOException, FontFormatException, URISyntaxException {
        AWTTerminalFontConfiguration fontConfig = loadSquareFont(size);
        Terminal terminal = createTerminal(width, height, fontConfig);
        this.screen = createScreen(terminal);
    }

    private Screen createScreen(Terminal terminal) throws IOException {
        final Screen screen;
        screen = new TerminalScreen(terminal);
        screen.setCursorPosition(null);
        screen.startScreen();
        screen.doResizeIfNecessary();
        return screen;
    }

    private Terminal createTerminal(int width, int height, AWTTerminalFontConfiguration fontConfig) throws IOException {
        TerminalSize terminalSize = new TerminalSize(width, height);
        DefaultTerminalFactory terminalFactory = new DefaultTerminalFactory()
                .setInitialTerminalSize(terminalSize);
        terminalFactory.setForceAWTOverSwing(true);
        terminalFactory.setTerminalEmulatorFontConfiguration(fontConfig);
        return terminalFactory.createTerminal();
    }

    private AWTTerminalFontConfiguration loadSquareFont(int size) throws URISyntaxException, FontFormatException, IOException {
        URL resource = getClass().getClassLoader().getResource("square.ttf");
        assert resource != null;
        File fontFile = new File(resource.toURI());
        Font font = Font.createFont(Font.TRUETYPE_FONT, fontFile);

        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        ge.registerFont(font);
        Font loadedFont = font.deriveFont(Font.PLAIN, size);
        return AWTTerminalFontConfiguration.newInstance(loadedFont);
    }

    @Override
    public void drawPlayer(Player player) {
        drawCharacter(player.getPos(), player.getNumber(), player.getColor());
    }

    @Override
    public void drawBlock(Block block) {
        drawCharacter(block.getPos(),' ', block.getColor());
    }

    @Override
    public void drawBoldText(Position position, String text, String color){
        TextGraphics tg = screen.newTextGraphics();
        tg.setForegroundColor(TextColor.Factory.fromString(color));
        tg.putString(position.getX(), position.getY(), text, SGR.BOLD);
    }

    @Override
    public void drawBlinkText(Position position, String text, String color){
        TextGraphics tg = screen.newTextGraphics();
        tg.setForegroundColor(TextColor.Factory.fromString(color));
        tg.putString(position.getX(), position.getY(), text, SGR.BLINK);
    }
    @Override
    public void drawText(Position position, String text, String color) {
        TextGraphics tg = screen.newTextGraphics();
        tg.setForegroundColor(TextColor.Factory.fromString(color));
        tg.putString(position.getX(), position.getY(), text);
    }

    private void drawCharacter(Position p, char c, String color) {
        TextGraphics tg = screen.newTextGraphics();
        tg.setBackgroundColor(TextColor.Factory.fromString(color));
        tg.putString(p.getX(), p.getY(), "" +c);
    }

    public Action getNextAction() throws IOException {
        KeyStroke key = screen.pollInput();
        if (key == null) return Action.none;

        if (key.getKeyType() == KeyType.Character && (key.getCharacter()=='w' || key.getCharacter()=='W')) {return Action.up1;}
        if (key.getKeyType() == KeyType.Character && (key.getCharacter()=='s' || key.getCharacter()=='S')) {return Action.down1;}
        if (key.getKeyType() == KeyType.Character && (key.getCharacter()=='d' || key.getCharacter()=='D')) {return Action.right1;}
        if (key.getKeyType() == KeyType.Character && (key.getCharacter()=='a' || key.getCharacter()=='A')) {return Action.left1;}
        if (key.getKeyType() == KeyType.Character && key.getCharacter()==' ') {return Action.jump1;}
        if (key.getKeyType() == KeyType.Character && (key.getCharacter()=='x' || key.getCharacter()=='X')) {return Action.boost1;}

        if (key.getKeyType() == KeyType.ArrowUp) return Action.up2;
        if (key.getKeyType() == KeyType.ArrowDown) return Action.down2;
        if (key.getKeyType() == KeyType.ArrowRight) return Action.right2;
        if (key.getKeyType() == KeyType.ArrowLeft) return Action.left2;
        if (key.getKeyType() == KeyType.Character && (key.getCharacter()=='l' || key.getCharacter()=='L')) {return Action.jump2;}
        if (key.getKeyType() == KeyType.Character && (key.getCharacter()=='p' || key.getCharacter()=='P')) {return Action.boost2;}

        if (key.getKeyType() == KeyType.EOF) return Action.exit;
        if (key.getKeyType() == KeyType.Escape) return Action.exit;
        if (key.getKeyType() == KeyType.Enter) return Action.select;

        return Action.none;
    }
    @Override
    public void clear() {
        screen.clear();
    }

    @Override
    public void refresh() throws IOException {
        screen.refresh();
    }

    @Override
    public void close() throws IOException {
        screen.close();
    }
}
