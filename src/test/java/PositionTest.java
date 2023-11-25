import org.junit.jupiter.api.Test;
import org.l07g09.model.Position;

import static org.junit.jupiter.api.Assertions.*;

public class PositionTest {
    private Position positionTest = new Position(2,1);
    private Position positionTest2 = new Position(1,0);
    private Position positionTest3 = new Position(1,0);

    @Test
    public void getX() {
        assertEquals(2, positionTest.getX());
        assertEquals(1, positionTest2.getX());
    }

    @Test
    public void getY() {
        assertEquals(1, positionTest.getY());
        assertEquals(0, positionTest2.getY());
    }

    @Test
    public void equals() {
        assertTrue(positionTest2.equals(positionTest3));
        assertFalse(positionTest.equals(positionTest3));
    }

    @Test
    public void setX() {
        positionTest.setX(3);
        assertEquals(3, positionTest.getX());
        positionTest2.setX(10);
        assertEquals(10, positionTest2.getX());
    }

    @Test
    public void setY() {
        positionTest.setY(4);
        assertEquals(4, positionTest.getY());
        positionTest2.setY(10);
        assertEquals(10, positionTest2.getY());
    }


}
