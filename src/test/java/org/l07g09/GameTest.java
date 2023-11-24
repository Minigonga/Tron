package org.l07g09;

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.io.IOException;

import static org.mockito.Mockito.*;

class GameTest {
    @Mock
    private TextGraphics graphics;

    @Mock
    private Screen screen;

    @InjectMocks
    private Game game;
    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }
    @Test
    void draw() throws IOException {
        when(screen.newTextGraphics()).thenReturn(graphics);

        // Create any necessary objects (e.g., p1, p2, walls) and set up their behavior

        // Call the method to test
        game.draw();

        // Verify that the expected methods on dependencies were called
        Mockito.verify(graphics).setBackgroundColor(TextColor.Factory.fromString("#000000"));
        Mockito.verify(graphics).fillRectangle(Mockito.any(TerminalPosition.class), Mockito.any(TerminalSize.class), Mockito.eq(' '));
        Mockito.verify(screen).refresh();
    }

    @Test
    void collision() {
    }

    @Test
    void run() {
    }
}