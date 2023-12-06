package org.l07g09;

import org.l07g09.gui.LanternaGUI;
import org.l07g09.states.State;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

public class Game {
    private final LanternaGUI gui;
    private State state;

    public Game() throws FontFormatException, IOException, URISyntaxException {
        this.gui = new LanternaGUI(20, 20);
        //this.state = new GameState(new Menu());
    }

    public static void main(String[] args) throws IOException, FontFormatException, URISyntaxException, InterruptedException {
        new Game().start();
    }

    public void setState(State state) {
        this.state = state;
    }

    private void start() throws InterruptedException, IOException {
        int FPS = 20;
        int frameTime = 1000 / FPS;
        while (this.state != null) {
            long startTime = System.currentTimeMillis();
            state.step(this, gui, startTime);
            long sleepTime = frameTime - System.currentTimeMillis() - startTime;
            if (sleepTime > 0) Thread.sleep(sleepTime);
        }
        gui.close();
    }
}
