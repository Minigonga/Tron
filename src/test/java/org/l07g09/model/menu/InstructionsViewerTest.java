package org.l07g09.model.menu;

import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.l07g09.gui.LanternaGUI;
import org.l07g09.viewer.menu.InstructionsViewer;
import org.l07g09.viewer.menu.MenuViewer;
import org.mockito.Mockito;

import static com.googlecode.lanterna.SGR.BOLD;

public class InstructionsViewerTest {
    private InstructionsViewer viewer;
    private Screen screen;
    private LanternaGUI gui;
    private TextGraphics tg;

    @BeforeEach
    void setup() {
        screen = Mockito.mock(Screen.class);
        tg = Mockito.mock(TextGraphics.class);
        Mockito.when(screen.newTextGraphics()).thenReturn(tg);
        gui = new LanternaGUI(screen);

        viewer = new InstructionsViewer(new Instructions());
    }

    @Test
    void drawElements() {
        viewer.drawElements(gui);

        String s1="TRON E UM JOGO EM QUE DOIS JOGADORES ";
        String s2="CONTROLAM UMA MOTO E DEIXAM UM RASTRO ";
        String s3="PELA AREA DE JOGO. SE ALGUEM TOCAR NO ";
        String s4="RASTRO(INCLUINDO O SEU), PERDE.";
        String s5="JOGO FEITO EM BEST OF SEVEN ";
        String s6="(PRIMEIRO A GANHAR 4 JOGOS)";

        Mockito.verify(tg, Mockito.times(1)).putString(14, 2, "Instructions", BOLD);
        Mockito.verify(tg, Mockito.times(1)).putString(1, 6, s1);
        Mockito.verify(tg, Mockito.times(1)).putString(1, 7, s2);
        Mockito.verify(tg, Mockito.times(1)).putString(1, 8, s3);
        Mockito.verify(tg, Mockito.times(1)).putString(1, 9, s4);
        Mockito.verify(tg, Mockito.times(1)).putString(5, 11, s5);
        Mockito.verify(tg, Mockito.times(1)).putString(5, 12, s6);

        String player1="PLAYER 1";
        String player2="PLAYER 2";


        Mockito.verify(tg, Mockito.times(1)).putString(3, 16, player1);
        Mockito.verify(tg, Mockito.times(1)).putString(27, 16, player2);

        String esc="CLIQUE NO ESC PARA VOLTAR AO MENU";

        Mockito.verify(tg, Mockito.times(1)).putString(3, 27, esc);

    }
}
