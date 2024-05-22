package model;

import org.carbonIT.model.*;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.*;

public class MapTest {

    @Test
    public void testMapInitialization() {
        Cell[][] cells = new Cell[2][2];
        cells[0][0] = new Cell(new Position(0, 0));
        cells[0][1] = new Cell(new Position(1, 0));
        cells[1][0] = new Cell(new Position(0, 1));
        cells[1][1] = new Cell(new Position(1, 1));

        List<Adventurer> adventurers = new ArrayList<>();
        adventurers.add(new Adventurer("Lara", new Position(0, 0), Orientation.N, "A"));

        Map map = new Map(2, 2, cells, adventurers);

        assertEquals(2, map.getWidth());
        assertEquals(2, map.getHeight());
        assertEquals(1, map.getAdventurers().size());
    }

    @Test
    public void testGetCell() {
        Cell[][] cells = new Cell[2][2];
        cells[0][0] = new Cell(new Position(0, 0));
        cells[0][1] = new Cell(new Position(1, 0));
        cells[1][0] = new Cell(new Position(0, 1));
        cells[1][1] = new Cell(new Position(1, 1));

        List<Adventurer> adventurers = new ArrayList<>();
        adventurers.add(new Adventurer("Lara", new Position(0, 0), Orientation.N, "A"));

        Map map = new Map(2, 2, cells, adventurers);
        assertEquals(cells[1][1], map.getCell(new Position(1, 1)));
    }
}
