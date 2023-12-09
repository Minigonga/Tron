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

    public Game() {
        this.finish=0;
    }

    public static void main(String[] args) throws IOException, FontFormatException, URISyntaxException, InterruptedException {
        new Game().startMenu();
    }
    private void startMenu() throws IOException, URISyntaxException, FontFormatException {
        guiMenu = new LanternaGUI(40,30,25);
        this.state = new MenuState(new Menu());
        int i = 0;
        while (this.state != null) {
            i++;
            if(i%2000000==0) state.step(this, guiMenu);
        }
        guiMenu.close();
        if (finish==1) {
            startArena();
        }
    }
    public void startArena() throws IOException, URISyntaxException, FontFormatException {
        finish=0;
        this.guiArena = new LanternaGUI(280, 190, 4);
        setState(new GameState(new ArenaBuilder().createArena(0, 0)));
        while (this.state != null) {
            state.step(this, guiArena);
        }
        guiArena.close();
        startMenu();
    }

    public void setState(State state) {
        this.state = state;
    }

    public void setFinish(int finish) {
        this.finish = finish;
    }
}
