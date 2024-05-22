package Simulation;

import org.carbonIT.model.*;
import org.carbonIT.simulation.Simulator;
import org.junit.Test;
import org.junit.*;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class SimulatorTest {


    /**
     * Test 1: basic movement test of 1 adventurer
     * */
    @Test
    public void testSimulateMovement() {
        Cell[][] cells = new Cell[4][4];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                cells[i][j] = new Cell(new Position(i, j));
            }
        }
        Adventurer adventurer = new Adventurer("Maymoun", new Position(0, 0), Orientation.E, "AADAD");
        Map map = new Map(4, 4, cells, List.of(adventurer));
        Simulator.simulate(map);
        assertEquals(2,adventurer.getPosition().getX());
        assertEquals(1,adventurer.getPosition().getY());
    }

    /**
     * Test 2: basic movement test of 1 adventurer with mountain
     * */
    @Test
    public void testSimulateMovementWithMountain() {
        Cell[][] cells = new Cell[4][4];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                cells[i][j] = new Cell(new Position(i, j));
            }
        }

        cells[1][1] = new Mountain(new Position(1, 1));
        Adventurer adventurer = new Adventurer("Maymoun", new Position(0, 0), Orientation.S, "AGADAA");
        Map map = new Map(4, 4, cells, List.of(adventurer));
        Simulator.simulate(map);
        assertEquals(0,adventurer.getPosition().getX());
        assertEquals(3,adventurer.getPosition().getY());
    }

    /**
     * Test 3: basic treasure collect test of 1 adventurer
     * */
    @Test
    public void testSimulateCollectTreasure() {
        Cell[][] cells = new Cell[4][4];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                cells[i][j] = new Cell(new Position(i, j));
            }
        }
        cells[1][1].addTreasures(2);
        Adventurer adventurer = new Adventurer("Maymoun", new Position(0, 0), Orientation.E, "ADA");
        Map map = new Map(4, 4, cells, List.of(adventurer));
        Simulator.simulate(map);
        assertEquals(1, adventurer.getCollectedTreasures());
    }

    /**
     * Test 4: basic treasure collect test of 1 adventurer with Mountain
     * */

    @Test
    public void testSimulateCollectTreasureWithMountain() {
        Cell[][] cells = new Cell[4][4];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                cells[i][j] = new Cell(new Position(i, j));
            }
        }

        cells[1][1] = new Mountain(new Position(1, 1));
        cells[2][0].addTreasures(2);
        Adventurer adventurer = new Adventurer("Maymoun", new Position(0, 0), Orientation.S, "AGADAA");
        Map map = new Map(4, 4, cells, List.of(adventurer));
        Simulator.simulate(map);
        assertEquals(1, adventurer.getCollectedTreasures());
    }

    /**
     * Test 5:collect treasure test of 2 adventurer with Mountain
     * */
    @Test
    public void testCollectTreasureWithTwoAdventurers() {
        Cell[][] cells = new Cell[4][4];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                cells[i][j] = new Cell(new Position(i, j));
            }
        }
        cells[1][1].addTreasures(2);
        cells[1][0] = new Mountain(new Position(1, 0));

        Adventurer adventurer1 = new Adventurer("Maymoun", new Position(0, 0), Orientation.E, "ADADA");
        Adventurer adventurer2 = new Adventurer("ELFAHIM", new Position(0, 1), Orientation.E, "AA");
        Map map = new Map(4, 4, cells, Arrays.asList(adventurer1, adventurer2));
        Simulator.simulate(map);

        assertEquals(1, adventurer1.getCollectedTreasures());
        assertEquals(1, adventurer2.getCollectedTreasures());
    }
}
