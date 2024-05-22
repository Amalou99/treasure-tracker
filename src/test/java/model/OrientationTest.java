package model;

import org.carbonIT.model.Orientation;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class OrientationTest {
    @Test
    public void testTurnLeft() {
        assertEquals(Orientation.W, Orientation.N.turnLeft());
        assertEquals(Orientation.E, Orientation.S.turnLeft());
        assertEquals(Orientation.N, Orientation.E.turnLeft());
        assertEquals(Orientation.S, Orientation.W.turnLeft());
    }

    @Test
    public void testTurnRight() {
        assertEquals(Orientation.E, Orientation.N.turnRight());
        assertEquals(Orientation.W, Orientation.S.turnRight());
        assertEquals(Orientation.S, Orientation.E.turnRight());
        assertEquals(Orientation.N, Orientation.W.turnRight());
    }
}
