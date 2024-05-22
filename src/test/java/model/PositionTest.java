package model;

import org.carbonIT.model.Position;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PositionTest {

    @Test
    public void testPosition() {
        Position position = new Position(1, 2);
        assertEquals(1, position.getX());
        assertEquals(2, position.getY());

        position.setX(3);
        position.setY(4);
        assertEquals(3, position.getX());
        assertEquals(4, position.getY());
    }
}
