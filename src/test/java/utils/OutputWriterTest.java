package utils;

import org.carbonIT.model.*;
import org.carbonIT.model.Map;
import org.carbonIT.utils.OutputWriter;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

import static org.junit.Assert.*;

public class OutputWriterTest {

    @Test
    public void testWriteOutput() throws IOException {
        Cell[][] cells = new Cell[2][2];
        cells[0][0] = new Cell(new Position(0, 0));
        cells[0][1] = new Cell(new Position(1, 0));
        cells[1][0] = new Cell(new Position(0, 1));
        cells[1][1] = new Cell(new Position(1, 1));

        List<Adventurer> adventurers = new ArrayList<>();
        Adventurer adventurer = new Adventurer("Lara", new Position(0, 0), Orientation.N, "AA");
        adventurers.add(adventurer);

        Map map = new Map(2, 2, cells, adventurers);

        String outputFilePath = "src/test/resources/test_output.txt";
        OutputWriter.writeOutput(map, outputFilePath);

        assertTrue(new File(outputFilePath).exists());

        List<String> lines = Files.readAllLines(Paths.get(outputFilePath));
        assertFalse(lines.isEmpty());
        assertEquals("C - 2 - 2", lines.get(0));
        assertEquals("A - Lara - 0 - 0 - N - 0", lines.get(1));
    }
}
