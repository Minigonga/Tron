import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.l07g09.model.element.Player;
import org.l07g09.model.Position;


import static org.mockito.Mockito.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PlayerTest {
    private Player player = new Player(0,0,"#FFFFFF", "1");
    private Player playerMock = mock(Player.class);
    @Test
    public void getTrail() {
        assertTrue(player.getTrail().isEmpty(), "The ArrayList should be empty");
    }
    @Test
    public void getPos() {
        assertEquals(0, player.getPos().getX());
        assertEquals(0, player.getPos().getY());
    }
    @Test
    public void move() {
        doAnswer(invocation -> {
            Object[] args = invocation.getArguments();
            if (args.length > 0 && args[0] instanceof Integer) {
                player.setDirection((Integer) args[0]);
            }
            return null;
        }).when(playerMock).setDirection(anyInt());
        Position p = new Position(1,0);
        when(playerMock.getPos()).thenReturn(p);
        player.setDirection(0);
        player.move();
        assertTrue(player.getPos().equals(p));
        assertEquals(0, player.getPos().getY());
    }
}
