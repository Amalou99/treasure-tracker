package org.carbonIT.model;

public class Cell {

    private Position position;
    private int treasureCount = 0;

    public Cell(Position position) {
        this.position = position;
    }
    public int getTreasureCount() {
        return treasureCount;
    }
    public void addTreasures(int count) {
        this.treasureCount += count;
    }

    public boolean hasTreasures() {
        return treasureCount > 0;
    }

    public int collectTreasure() {
        if (treasureCount > 0) {
            treasureCount--;
            return 1;
        }
        return 0;
    }

    // Getters, setters
    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

}
