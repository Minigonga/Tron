package org.l07g09.gui;

import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.l07g09.model.Position;
import org.l07g09.model.game.element.Block;
import org.l07g09.model.game.element.Player;
import org.l07g09.model.menu.Menu;
import org.l07g09.viewer.menu.MenuViewer;
import org.mockito.Mockito;

import static com.googlecode.lanterna.SGR.BLINK;
import static com.googlecode.lanterna.SGR.BOLD;

public class LanternaGUITest {
    private Screen screen;
    private LanternaGUI gui;
    private TextGraphics tg;
    private Menu menu;
    private MenuViewer viewMenu;

    @BeforeEach
    public void setUp() {
        screen = Mockito.mock(Screen.class);
        tg = Mockito.mock(TextGraphics.class);
        menu = new Menu();
        viewMenu = new MenuViewer(menu);

        Mockito.when(screen.newTextGraphics()).thenReturn(tg);
        gui = new LanternaGUI(screen);
    }

    @Test
    public void drawPlayer() {
        gui.drawPlayer(new Player(55,30,"#FFFFFF", '1', 2));

        Mockito.verify(tg, Mockito.times(1)).setBackgroundColor(TextColor.Factory.fromString("#FFFFFF"));
        Mockito.verify(tg, Mockito.times(1)).putString(55, 30, "" + '1');

        gui.drawPlayer(new Player(23,12,"#000000", '2', 1));

        Mockito.verify(tg, Mockito.times(1)).setBackgroundColor(TextColor.Factory.fromString("#000000"));
        Mockito.verify(tg, Mockito.times(1)).putString(23, 12, "" + '2');
    }

    @Test
    public void drawBlock() {
        gui.drawBlock(new Block(1,2,"#0000FF"));

        Mockito.verify(tg, Mockito.times(1)).setBackgroundColor(TextColor.Factory.fromString("#0000FF"));
    }

    @Test
    public void drawText() {
        gui.drawText(new Position(5,5),"Teste","#0000FF");

        Mockito.verify(tg, Mockito.times(1)).setForegroundColor(TextColor.Factory.fromString("#0000FF"));
        Mockito.verify(tg, Mockito.times(1)).putString(5,5, "Teste");

        gui.drawText(new Position(3425,12344), "Teste2", "#FFFFFF");

        Mockito.verify(tg, Mockito.times(1)).setForegroundColor(TextColor.Factory.fromString("#FFFFFF"));
        Mockito.verify(tg, Mockito.times(1)).putString(3425,12344, "Teste2");
    }

    @Test
    public void drawMenu() {
        viewMenu.drawElements(gui);

        Mockito.verify(tg, Mockito.times(1)).setForegroundColor(TextColor.Factory.fromString("#0000FF"));
        Mockito.verify(tg, Mockito.times(1)).putString(18,4, "TRON", BOLD);

        Mockito.verify(tg, Mockito.times(1)).setForegroundColor(TextColor.Factory.fromString("#FFD700"));
        Mockito.verify(tg, Mockito.times(1)).putString(2,10, "Start", BLINK);

        Mockito.verify(tg, Mockito.times(2)).setForegroundColor(TextColor.Factory.fromString("#FFFFFF"));
        Mockito.verify(tg, Mockito.times(1)).putString(2,13, "Instructions");

        Mockito.verify(tg, Mockito.times(2)).setForegroundColor(TextColor.Factory.fromString("#FFFFFF"));
        Mockito.verify(tg, Mockito.times(1)).putString(2,16, "Exit");

        menu.nextEntry();
        viewMenu.drawElements(gui);

        Mockito.verify(tg, Mockito.times(2)).setForegroundColor(TextColor.Factory.fromString("#0000FF"));
        Mockito.verify(tg, Mockito.times(2)).putString(18,4, "TRON", BOLD);

        Mockito.verify(tg, Mockito.times(4)).setForegroundColor(TextColor.Factory.fromString("#FFFFFF"));
        Mockito.verify(tg, Mockito.times(1)).putString(2,10, "Start");

        Mockito.verify(tg, Mockito.times(2)).setForegroundColor(TextColor.Factory.fromString("#FFD700"));
        Mockito.verify(tg, Mockito.times(1)).putString(2,13, "Instructions", BLINK);

        Mockito.verify(tg, Mockito.times(4)).setForegroundColor(TextColor.Factory.fromString("#FFFFFF"));
        Mockito.verify(tg, Mockito.times(2)).putString(2,16, "Exit");

        menu.nextEntry();
        viewMenu.drawElements(gui);

        Mockito.verify(tg, Mockito.times(3)).setForegroundColor(TextColor.Factory.fromString("#0000FF"));
        Mockito.verify(tg, Mockito.times(3)).putString(18,4, "TRON", BOLD);

        Mockito.verify(tg, Mockito.times(6)).setForegroundColor(TextColor.Factory.fromString("#FFFFFF"));
        Mockito.verify(tg, Mockito.times(2)).putString(2,10, "Start");

        Mockito.verify(tg, Mockito.times(6)).setForegroundColor(TextColor.Factory.fromString("#FFFFFF"));
        Mockito.verify(tg, Mockito.times(2)).putString(2,13, "Instructions");

        Mockito.verify(tg, Mockito.times(3)).setForegroundColor(TextColor.Factory.fromString("#FFD700"));
        Mockito.verify(tg, Mockito.times(1)).putString(2,16, "Exit", BLINK);
    }

}
