package main.object;

import main.tool.direction.Direction;
import main.tool.move.Move;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MowerTest {

    @Test
    public void testConstructor() {

        // Test contructor
        Mower mower = new Mower(0, 0, Direction.NORTH, Collections.emptyList());

        assertEquals(0, mower.getPositionX());
        assertEquals(0, mower.getPositionY());
        assertEquals(Direction.NORTH, mower.getDirection());

        // Test constructor with negative positions
        mower = new Mower(-10, -5, Direction.NORTH, Collections.emptyList());

        assertEquals(-10, mower.getPositionX());
        assertEquals(-5, mower.getPositionY());

        // Test constructor with different positions
        mower = new Mower(15, 7, Direction.NORTH, Collections.emptyList());

        assertEquals(15, mower.getPositionX());
        assertEquals(7, mower.getPositionY());

        // Test with north direction
        mower = new Mower(0, 0, Direction.EAST, Collections.emptyList());

        assertEquals(Direction.EAST, mower.getDirection());

        // Test with east direction
        mower = new Mower(0, 0, Direction.EAST, Collections.emptyList());

        assertEquals(Direction.EAST, mower.getDirection());

        // Test with south direction
        mower = new Mower(0, 0, Direction.SOUTH, Collections.emptyList());

        assertEquals(Direction.SOUTH, mower.getDirection());

        // Test with west direction
        mower = new Mower(0, 0, Direction.WEST, Collections.emptyList());

        assertEquals(Direction.WEST, mower.getDirection());

        // Test with null direction
        Assertions.assertThrows(NullPointerException.class, () -> new Mower(0, 0, null, Collections.emptyList()));

        // Test with empty list of move
        mower = new Mower(0, 0, Direction.WEST, Collections.emptyList());

        // Test with move list
        List<Move> moves = new ArrayList<>();
        moves.add(Move.FORWARD);
        moves.add(Move.LEFT);
        moves.add(Move.RIGHT);
        mower = new Mower(0, 0, Direction.WEST, moves);
    }

    @Test
    void testGetNextMove() {
        // Test with move list
        List<Move> moves = new ArrayList<>();
        moves.add(Move.FORWARD);
        moves.add(Move.LEFT);
        moves.add(Move.RIGHT);
        Mower mower = new Mower(0, 0, Direction.NORTH, moves);

        assertEquals(Move.FORWARD, mower.getNextMove());

        // Test with an empty move list
        mower = new Mower(0, 0, Direction.NORTH, Collections.emptyList());

        assertNull(mower.getNextMove());
    }

    @Test
    void testSetPositionX() {
        // Test set position X
        Mower mower = new Mower(0, 0, Direction.NORTH, Collections.emptyList());
        mower.setPositionX(1);

        assertEquals(1, mower.getPositionX());

        // Test set position X negative
        mower = new Mower(0, 0, Direction.NORTH, Collections.emptyList());
        mower.setPositionX(-1);

        assertEquals(-1, mower.getPositionX());
    }

    @Test
    void testSetPositionY() {
        // Test set position Y
        Mower mower = new Mower(0, 0, Direction.NORTH, Collections.emptyList());
        mower.setPositionY(1);

        assertEquals(1, mower.getPositionY());

        // Test set position Y negative
        mower = new Mower(0, 0, Direction.NORTH, Collections.emptyList());
        mower.setPositionY(-1);

        assertEquals(-1, mower.getPositionY());
    }

    @Test
    void testSetNextMoveComplete() {
        // Test with move list
        List<Move> moves = new ArrayList<>();
        moves.add(Move.FORWARD);
        moves.add(Move.LEFT);
        moves.add(Move.RIGHT);
        Mower mower = new Mower(0, 0, Direction.NORTH, moves);
        mower.setNextMoveComplete();

        assertEquals(Move.LEFT, mower.getNextMove());

        // Test with an empty move list
        assertDoesNotThrow(() -> {
            Mower mower2 = new Mower(0, 0, Direction.NORTH, Collections.emptyList());
            mower2.setNextMoveComplete();
        });
    }

    @Test
    void testIsAnyMoveRemaining() {
        // Test with move list
        List<Move> moves = new ArrayList<>();
        moves.add(Move.FORWARD);
        moves.add(Move.LEFT);
        moves.add(Move.RIGHT);
        Mower mower = new Mower(0, 0, Direction.NORTH, moves);

        assertTrue(mower.isAnyMoveRemaining());

        // Test with an empty move list
        mower = new Mower(0, 0, Direction.NORTH, Collections.emptyList());

        assertFalse(mower.isAnyMoveRemaining());
    }

    @Test
    void testGoRight() {
        // Test started direction North
        Mower mower = new Mower(0, 0, Direction.NORTH, Collections.emptyList());
        mower.goRight();

        assertEquals(Direction.EAST, mower.getDirection());

        // Test started direction East
        mower = new Mower(0, 0, Direction.EAST, Collections.emptyList());
        mower.goRight();

        assertEquals(Direction.SOUTH, mower.getDirection());

        // Test started direction South
        mower = new Mower(0, 0, Direction.SOUTH, Collections.emptyList());
        mower.goRight();

        assertEquals(Direction.WEST, mower.getDirection());

        // Test started direction West
        mower = new Mower(0, 0, Direction.WEST, Collections.emptyList());
        mower.goRight();

        assertEquals(Direction.NORTH, mower.getDirection());
    }

    @Test
    void testGoLeft() {
        // Test started direction North
        Mower mower = new Mower(0, 0, Direction.NORTH, Collections.emptyList());
        mower.goLeft();

        assertEquals(Direction.WEST, mower.getDirection());

        // Test started direction West
        mower = new Mower(0, 0, Direction.WEST, Collections.emptyList());
        mower.goLeft();

        assertEquals(Direction.SOUTH, mower.getDirection());

        // Test started direction South
        mower = new Mower(0, 0, Direction.SOUTH, Collections.emptyList());
        mower.goLeft();

        assertEquals(Direction.EAST, mower.getDirection());

        // Test started direction East
        mower = new Mower(0, 0, Direction.EAST, Collections.emptyList());
        mower.goLeft();

        assertEquals(Direction.NORTH, mower.getDirection());
    }

    @Test
    void testToString() {
        // Test with positive position
        Mower mower = new Mower(1, 1, Direction.NORTH, Collections.emptyList());

        assertEquals("1 1 N", mower.toString());

        // Test with negative position
        mower = new Mower(-1, -1, Direction.NORTH, Collections.emptyList());

        assertEquals("-1 -1 N", mower.toString());

        // Test with North direction
        mower = new Mower(0, 0, Direction.NORTH, Collections.emptyList());

        assertEquals("0 0 N", mower.toString());

        // Test with East direction
        mower = new Mower(0, 0, Direction.EAST, Collections.emptyList());

        assertEquals("0 0 E", mower.toString());

        // Test with South direction
        mower = new Mower(0, 0, Direction.SOUTH, Collections.emptyList());

        assertEquals("0 0 S", mower.toString());

        // Test with West direction
        mower = new Mower(0, 0, Direction.WEST, Collections.emptyList());

        assertEquals("0 0 W", mower.toString());
    }
}