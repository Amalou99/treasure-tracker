package model;

import org.carbonIT.model.Position;
import org.carbonIT.model.Treasure;
import org.junit.Test;

import static org.junit.Assert.*;

public class TreasureTest {

    @Test
    public void testTreasureCreation() {
        Position position = new Position(1, 1);
        Treasure treasure = new Treasure(position, 3);
        assertEquals(position, treasure.getPosition());
        assertEquals(3, treasure.getCount());
    }
}
