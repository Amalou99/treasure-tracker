package org.carbonIT.model;

public enum Orientation {
    N, S, E, W;

    public Orientation turnLeft() {
        switch (this) {
            case N:
                return W;
            case S:
                return E;
            case E:
                return N;
            case W:
                return S;
            default:
                throw new IllegalArgumentException("Invalid orientation: " + this);
        }
    }

    public Orientation turnRight() {
        switch (this) {
            case N:
                return E;
            case S:
                return W;
            case E:
                return S;
            case W:
                return N;
            default:
                throw new IllegalArgumentException("Invalid orientation: " + this);
        }
    }
}
