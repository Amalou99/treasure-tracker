package org.carbonIT.utils;

import org.carbonIT.model.*;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class OutputWriter {

    public static void writeOutput(Map map, String outputFilePath) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFilePath))) {
            writer.write("C - " + map.getWidth() + " - " + map.getHeight());
            writer.newLine();

            for (int y = 0; y < map.getHeight(); y++) {
                for (int x = 0; x < map.getWidth(); x++) {
                    Cell cell = map.getCell(new Position(x, y));
                    if (cell instanceof Mountain) {
                        writer.write("M - " + x + " - " + y);
                        writer.newLine();
                    } else if (cell.hasTreasures()) {
                        writer.write("T - " + x + " - " + y + " - " + cell.getTreasureCount());
                        writer.newLine();
                    }
                }
            }

            for (Adventurer adventurer : map.getAdventurers()) {
                writer.write("A - " + adventurer.getName() + " - " + adventurer.getPosition().getX() + " - " + adventurer.getPosition().getY()
                        + " - " + adventurer.getOrientation() + " - " + adventurer.getCollectedTreasures());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
