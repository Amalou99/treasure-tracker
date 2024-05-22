package org.carbonIT.model;

import java.util.Queue;

public class Adventurer {

    private String name;
    private Position position;
    private Orientation orientation;
    private String movements;
    private int collectedTreasures;
    private int currentMoveIndex;

    public Adventurer(String name, Position position, Orientation orientation, String movements) {
        this.name = name;
        this.position = position;
        this.orientation = orientation;
        this.movements = movements;
        this.collectedTreasures = 0;
        this.currentMoveIndex = 0;
    }

    public boolean hasNextMove() {
        return currentMoveIndex < movements.length();
    }

    public char nextMove() {
        if (hasNextMove()) {
            return movements.charAt(currentMoveIndex++);
        }
        throw new IllegalStateException("No more movements left for adventurer " + name);
    }


    public void collectTreasures(int count) {
        this.collectedTreasures += count;
    }

    // Getters, setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Orientation getOrientation() {
        return orientation;
    }

    public void setOrientation(Orientation orientation) {
        this.orientation = orientation;
    }

    public String getMovements() {
        return movements;
    }

    public void setMovements(String movements) {
        this.movements = movements;
    }

    public int getCollectedTreasures() {
        return collectedTreasures;
    }

    public void setCollectedTreasures(int collectedTreasures) {
        this.collectedTreasures = collectedTreasures;
    }
}
