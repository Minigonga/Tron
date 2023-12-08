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
    private LanternaGUI guiArena;
    private LanternaGUI guiMenu;
    private int finish;
    private State state;

    public Game() throws FontFormatException, IOException, URISyntaxException {
        this.guiMenu = new LanternaGUI(30,25, 30);
        this.state = new MenuState(new Menu());
        this.finish=0;
    }

    public static void main(String[] args) throws IOException, FontFormatException, URISyntaxException, InterruptedException {
        new Game().startMenu();
    }
    private void startMenu() throws IOException, URISyntaxException, FontFormatException {
        int i = 0;
        while (this.state != null) {
            i++;
            if(i%2000000==0) state.step(this, guiMenu);
        }
        guiMenu.close();
        if (finish==1) {
            this.state = new GameState(new ArenaBuilder().createArena());
            this.guiArena = new LanternaGUI(280, 190, 4);
            startArena();
        }
    }
    public void startArena() throws IOException, URISyntaxException, FontFormatException {
        finish=0;
        setState(new GameState(new ArenaBuilder().createArena()));
        while (this.state != null) {
            state.step(this, guiArena);
        }
        guiArena.close();
        guiMenu = new LanternaGUI(30,25,30);
        this.state = new MenuState(new Menu());
        startMenu();
    }

    public void setState(State state) {
        this.state = state;
    }

    public void setFinish(int finish) {
        this.finish = finish;
    }
}
