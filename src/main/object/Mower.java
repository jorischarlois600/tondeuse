package main.object;

import main.tool.direction.Direction;
import main.tool.direction.DirectionParser;
import main.tool.move.Move;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * main.objects.Mower class
 *
 * @author Joris Charlois
 * @version 1.0.0, 23/01/2022
 */

public class Mower {

    /**
     * Position X axis
     */
    private int positionX;

    /**
     * Position y axis
     */
    private int positionY;

    /**
     * Direction
     */
    private Direction direction;

    /**
     * List of move remaning
     */
    private List<Move> moveListRemaining;

    /**
     * List of move already did
     */
    private List<Move> moveListAlreadyDid;

    /**
     * Constructor
     * @param postionX position X
     * @param positionY position Y
     * @param direction direction, not null
     * @param moveList list of move, not null
     */
    public Mower(int postionX, int positionY, Direction direction, List<Move> moveList) {
        Objects.requireNonNull(direction);
        Objects.requireNonNull(moveList);
        this.positionX = postionX;
        this.positionY = positionY;
        this.direction = direction;
        this.moveListRemaining = new ArrayList<>(moveList);
        this.moveListAlreadyDid = new ArrayList<>();
    }

    /**
     * Getter position X axix
     */
    public int getPositionX() {
        return positionX;
    }

    /**
     * Getter position Y axis
     */
    public int getPositionY() {
        return positionY;
    }

    /**
     * Getter direction
     */
    public Direction getDirection() {
        return direction;
    }

    /**
     * Getter next move to do
     */
    public Move getNextMove() {
        if (moveListRemaining.isEmpty()) {
            return null;
        }
        return moveListRemaining.get(0);
    }

    /**
     * Setter position X axis
     */
    public void setPositionX(int positionX) {
        this.positionX = positionX;
    }

    /**
     * Setter position Y axis
     */
    public void setPositionY(int positionY) {
        this.positionY = positionY;
    }

    /**
     * Move next move from list that are already did
     */
    public void setNextMoveComplete() {
        if (!moveListRemaining.isEmpty()) {
            moveListAlreadyDid.add(moveListRemaining.get(0));
            moveListRemaining.remove(0);
        }
    }

    /**
     * Check if there is any move remaining
     */
    public boolean isAnyMoveRemaining() {
        return !moveListRemaining.isEmpty();
    }

    /**
     * Turn the mower to the right
     * @since 1.0.0, 23/01/2022
     */
    public void goRight() {
        switch (direction) {
            case NORTH :
                direction = Direction.EAST;
                break;
            case EAST :
                direction = Direction.SOUTH;
                break;
            case SOUTH :
                direction = Direction.WEST;
                break;
            case WEST :
                direction = Direction.NORTH;
                break;
        }
    }

    /**
     * Turn the mower to the left
     * @since 1.0.0, 23/01/2022
     */
    public void goLeft() {
        switch (direction) {
            case NORTH :
                direction = Direction.WEST;
                break;
            case WEST :
                direction = Direction.SOUTH;
                break;
            case SOUTH :
                direction = Direction.EAST;
                break;
            case EAST :
                direction = Direction.NORTH;
                break;
        }
    }

    /**
     * Printable result
     * @return
     */
    @Override
    public String toString() {
        return positionX + " " + positionY + " " + DirectionParser.toString(direction);
    }
}
