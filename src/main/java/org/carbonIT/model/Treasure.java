package org.carbonIT.model;

public class Treasure {

    private Position position;
    private int count;

    public Treasure(Position position, int count) {
        this.position = position;
        this.count = count;
    }


    // Getters, setters
    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }


}
