package main.object;

import main.exception.PositionNotAvailableException;
import main.tool.direction.Direction;
import main.tool.move.Move;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * main.objects.Field class where mowers are
 *
 * @author Joris Charlois
 * @version 1.0.0, 23/01/2022
 */

public class Field {

    /**
     * Height of the field
     */
    private int height;

    /**
     * Width of the field
     */
    private int width;

    /**
     * Set of main.objects.Mower
     */
    private List<Mower> mowerList;

    /**
     * Constructor
     * @since 1.0.0, 23/01/2022
     * @param height height of the filed
     * @param width wifth of the field
     */
    public Field(int height, int width) {
        if (height < 0 || width < 0) {
            throw new IllegalArgumentException("The size of the field couldn't be negative");
        }
        this.height = height;
        this.width = width;
        mowerList = new ArrayList<>();
    }

    /**
     * Getter mower list
     * @since 1.0.0, 23/01/2022
     */
    public List<Mower> getMowerList() {
        return this.mowerList;
    }

    /**
     * Add a mower to a field
     * @since 1.0.0, 23/01/2022
     * @param mower the mower to add
     * @throws PositionNotAvailableException throw when the position in the field is not available for this mower
     */
    public void addMower(Mower mower) throws PositionNotAvailableException {
        Objects.requireNonNull(mower);
        if (isPositionAvailable(mower.getPositionX(), mower.getPositionY())) {
            mowerList.add(mower);
        } else {
            throw new PositionNotAvailableException("A mower couldn't be add to the field because the position is not available");
        }
    }

    /**
     * Make all mowers do all their moves
     * @since 1.0.0 23/01/2022
     */
    public void doAllMoveAllMower() {
        mowerList.forEach(this::doAllMoveMower);
    }

    /**
     * Make a mower do all their moves
     * @since 1.0.0 23/01/2022
     * @param mower the mower
     */
    private void doAllMoveMower(Mower mower) {
        while (mower.isAnyMoveRemaining()) {
            try {
                nextMove(mower);
            } catch (PositionNotAvailableException e) {
                System.out.println("ERROR : error occure during a move");
            }
            mower.setNextMoveComplete();
        }
        System.out.println(mower);
    }

    /**
     * Do the next move on a mower
     * @since 1.0.0 23/01/2022
     * @param mower the mower to move
     * @throws PositionNotAvailableException throw when the position asked by the next move is not available on the field
     */
    private void nextMove(Mower mower) throws PositionNotAvailableException {
        Move move = mower.getNextMove();
        if (move != null) {
            if (move.equals(Move.RIGHT)) {
                mower.goRight();
            } else if (move.equals(Move.LEFT)) {
                mower.goLeft();
            } else {
                int mowerX = mower.getPositionX();
                int mowerY = mower.getPositionY();
                Direction mowerDirection = mower.getDirection();
                switch (mowerDirection) {
                    case NORTH:
                        mowerY += 1;
                        break;
                    case EAST:
                        mowerX += 1;
                        break;
                    case SOUTH:
                        mowerY -= 1;
                        break;
                    case WEST:
                        mowerX -= 1;
                        break;
                }
                if (isPositionAvailable(mowerX, mowerY)) {
                    mower.setPositionX(mowerX);
                    mower.setPositionY(mowerY);
                } else {
                    throw new PositionNotAvailableException("A mower couldn't be move on the position asked because the position is not available");
                }
            }
        }
    }

    /**
     * Check if the position x and y is available on the field
     * @since 1.0.0, 23/01/2022
     * @param x position x to test
     * @param y position y to test
     * @return true if available, else false
     */
    private boolean isPositionAvailable(int x, int y) {
        // if x or y are out of the field
        if (x < 0 || x > height || y < 0 || y > width) {
            return false;
        }
        // if there is no mower at the position x and y
        else if (mowerList.size() == 0 || mowerList.stream().noneMatch(mower -> x == mower.getPositionX() && y == mower.getPositionY())) {
            return true;
        }
        return false;
    }
}
