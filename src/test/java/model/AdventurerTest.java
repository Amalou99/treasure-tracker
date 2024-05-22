package model;

import org.carbonIT.model.*;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class AdventurerTest {
    private Adventurer adventurer;

    @Before
    public void setUp() {
        adventurer = new Adventurer("Indiana", new Position(1, 1), Orientation.S, "AADADA");
    }

    /**
     * Movement test
     */
    @Test
    public void testNextMove() {
        assertEquals('A', adventurer.nextMove());
        assertEquals('A', adventurer.nextMove());
        assertEquals('D', adventurer.nextMove());
    }

    @Test(expected = IllegalStateException.class)
    public void testNextMoveNoMoreMoves() {
        for (int i = 0; i < 6; i++) {
            adventurer.nextMove();
        }
        adventurer.nextMove();
    }

    @Test
    public void testCollectTreasures() {
        adventurer.collectTreasures(2);
        assertEquals(2, adventurer.getCollectedTreasures());
    }
}
