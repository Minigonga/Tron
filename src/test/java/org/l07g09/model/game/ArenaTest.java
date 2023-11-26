package org.l07g09.model.game;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

public class ArenaTest {
    Arena arena;
    @BeforeEach
    public void setUp() throws IOException, URISyntaxException, FontFormatException {
        arena = new Arena();
    }
    @Test
    public void collision() {
        //Por enquanto, não conseguimos testar os métodos da classe Arena, uma vez que esta não está na sua melhor forma para ser testada, pois o construtor cria já os jogadores.
    }

}
