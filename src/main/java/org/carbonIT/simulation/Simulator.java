package org.carbonIT.simulation;

import org.carbonIT.model.*;

public class Simulator {

    public static void simulate(Map map) {
        boolean movementsLeft;
        do {
            movementsLeft = false;
            for (Adventurer adventurer : map.getAdventurers()) {
                if (adventurer.hasNextMove()) {
                    movementsLeft = true;
                    executeMovement(map, adventurer);
                }
            }
        } while (movementsLeft);
    }


    private static void executeMovement(Map map, Adventurer adventurer) {
        char movement = adventurer.nextMove();
        switch (movement) {
            case 'A':
                moveForward(map, adventurer);
                break;
            case 'G':
                turnLeft(adventurer);
                break;
            case 'D':
                turnRight(adventurer);
                break;
            default:
                throw new IllegalArgumentException("Invalid movement: " + movement);
        }
        // Remove the executed movement from the string
        //adventurer.setMovements(adventurer.getMovements().substring(1));
    }

    private static void moveForward(Map map, Adventurer adventurer) {
        Position currentPosition = adventurer.getPosition();
        Position newPosition = getNextPosition(currentPosition, adventurer.getOrientation());

        if (isValidMove(map, newPosition)) {
            Cell targetCell = map.getCell(newPosition);

            // Collect treasure if present
            if (targetCell.hasTreasures()) {
                int collected = targetCell.collectTreasure();
                adventurer.collectTreasures(collected);
            }

            adventurer.setPosition(newPosition);
        }
        /*System.out.println("currentPosition => X= "+currentPosition.getX()+" && Y= "+currentPosition.getY());
        System.out.println("newPosition => X= "+newPosition.getX()+" && Y= "+newPosition.getY());*/
    }

    private static void turnLeft(Adventurer adventurer) {
        adventurer.setOrientation(adventurer.getOrientation().turnLeft());
     }

    private static void turnRight(Adventurer adventurer) {
        adventurer.setOrientation(adventurer.getOrientation().turnRight());
    }

    private static Position getNextPosition(Position position, Orientation orientation) {
        switch (orientation) {
            case N:
                return new Position(position.getX(), position.getY() - 1);
            case S:
                return new Position(position.getX(), position.getY() + 1);
            case E:
                return new Position(position.getX() + 1, position.getY());
            case W:
                return new Position(position.getX() - 1, position.getY());
            default:
                throw new IllegalArgumentException("Invalid orientation: " + orientation);
        }
    }

    private static boolean isValidMove(Map map, Position position) {
        if (position.getX() < 0 || position.getX() >= map.getWidth()
                || position.getY() < 0 || position.getY() >= map.getHeight()) {
            return false;
        }

        Cell cell = map.getCell(position);
        return !(cell instanceof Mountain);
    }
}
