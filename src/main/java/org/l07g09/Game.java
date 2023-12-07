package org.l07g09;

import org.l07g09.gui.LanternaGUI;
import org.l07g09.model.game.arena.Arena;
import org.l07g09.model.game.arena.ArenaBuilder;
import org.l07g09.states.GameState;
import org.l07g09.states.MenuState;
import org.l07g09.states.State;
import org.l07g09.model.menu.Menu;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

public class Game {
    private final LanternaGUI gui;
    private State state;

    public Game() throws FontFormatException, IOException, URISyntaxException {
        this.gui = new LanternaGUI(280, 190);
        this.state = new MenuState(new Menu());
    }

    public static void main(String[] args) throws IOException, FontFormatException, URISyntaxException, InterruptedException {
        new Game().start();
    }
    private void start() throws InterruptedException, IOException {
        int FPS = 20;
        long frameTime = 1000 / FPS;
        int i = 0;
        while (this.state != null) {
            i++;
            if(i%20000000==0) {
                long startTime = System.currentTimeMillis();
                state.step(this, gui, startTime);
                long sleepTime = frameTime - System.currentTimeMillis() - startTime;
                if (sleepTime > 0) Thread.sleep(sleepTime);
            }
        }
        gui.close();
    }

    public void setState(State state) {
        this.state = state;
    }

}
