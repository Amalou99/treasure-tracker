package org.carbonIT.model;

import java.util.Arrays;
import java.util.List;

public class Map {

    private int width;
    private int height;
    private Cell[][] cells;
    private List<Adventurer> adventurers;

    public Map(int width, int height, Cell[][] cells, List<Adventurer> adventurers) {
        this.width = width;
        this.height = height;
        this.cells = cells;
        this.adventurers = adventurers;
    }

    @Override
    public String toString() {
        return "Map{" +
                "width=" + width +
                ", height=" + height +
                ", cells=" + cells.toString() +
                ", adventurers=" + adventurers +
                '}';
    }

    public Cell getCell(Position position) {
        return cells[position.getY()][position.getX()];
    }

    // Getters, setters
    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public Cell[][] getCells() {
        return cells;
    }

    public void setCells(Cell[][] cells) {
        this.cells = cells;
    }

    public List<Adventurer> getAdventurers() {
        return adventurers;
    }

    public void setAdventurers(List<Adventurer> adventurers) {
        this.adventurers = adventurers;
    }
}
