package org.l07g09;

import org.l07g09.model.game.Arena;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

public class Game {
    public static void main(String[] args) throws IOException, URISyntaxException, FontFormatException {
        Arena arena = new Arena();
        arena.run();
    }
}