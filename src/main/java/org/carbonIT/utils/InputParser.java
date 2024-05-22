package org.carbonIT.utils;

import org.carbonIT.model.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class InputParser {

    public static Map parseMap(String filePath) throws IOException {
        List<String> lines = Files.readAllLines(Paths.get(filePath));
        int width = 0;
        int height = 0;
        List<Mountain> mountains = new ArrayList<>();
        List<Treasure> treasures = new ArrayList<>();
        List<Adventurer> adventurers = new ArrayList<>();

        for (String line : lines) {
            line = line.trim();
            if (line.isEmpty() || line.startsWith("#")) {
                continue; // Skip comments and empty lines
            }

            String[] parts = line.split(" - ");
            switch (parts[0]) {
                case "C":
                    width = Integer.parseInt(parts[1]);
                    height = Integer.parseInt(parts[2]);
                    break;
                case "M":
                    int mountainX = Integer.parseInt(parts[1]);
                    int mountainY = Integer.parseInt(parts[2]);
                    mountains.add(new Mountain(new Position(mountainX, mountainY)));
                    break;
                case "T":
                    int treasureX = Integer.parseInt(parts[1]);
                    int treasureY = Integer.parseInt(parts[2]);
                    int treasureCount = Integer.parseInt(parts[3]);
                    treasures.add(new Treasure(new Position(treasureX, treasureY), treasureCount));
                    break;
                case "A":
                    String name = parts[1];
                    int adventurerX = Integer.parseInt(parts[2]);
                    int adventurerY = Integer.parseInt(parts[3]);
                    Orientation orientation = Orientation.valueOf(parts[4]);
                    String movements = parts[5];
                    adventurers.add(new Adventurer(name, new Position(adventurerX, adventurerY), orientation, movements));
                    break;
            }
        }

        Cell[][] cells = new Cell[height][width];
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                cells[y][x] = new Cell(new Position(x, y));
            }
        }

        for (Mountain mountain : mountains) {
            Position pos = mountain.getPosition();
            cells[pos.getY()][pos.getX()] = mountain;
        }

        for (Treasure treasure : treasures) {
            Position pos = treasure.getPosition();
            cells[pos.getY()][pos.getX()].addTreasures(treasure.getCount());
        }

        Map map = new Map(width, height, cells, adventurers);
        return map;
    }
}
