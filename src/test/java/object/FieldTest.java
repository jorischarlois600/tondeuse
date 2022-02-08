package object;

import exception.PositionNotAvailableException;
import tool.direction.Direction;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FieldTest {

    @Test
    void testContructor() {
        // Test basic
        assertDoesNotThrow(() -> new Field(0, 0));

        // Test negative values
        assertThrows(IllegalArgumentException.class, () -> new Field(-1, -1));
    }

    @Test
    void testAddMower() {
        // Test with correct mower
        Field field = new Field(10, 10);

        Mower mower = new Mower(1, 1, Direction.NORTH, Collections.emptyList());

        assertDoesNotThrow(() -> field.addMower(mower));

        // Test with mower outside negative
        Mower mower2 = new Mower(-1, -1, Direction.NORTH, Collections.emptyList());

        assertThrows(PositionNotAvailableException.class, () -> field.addMower(mower2));

        // Test with mower outside field size
        Mower mower3 = new Mower(20, 20, Direction.NORTH, Collections.emptyList());

        assertThrows(PositionNotAvailableException.class, () -> field.addMower(mower3));

        // Test with mower at the same position of another mower
        Mower mower4 = new Mower(1, 1, Direction.SOUTH, Collections.emptyList());

        assertThrows(PositionNotAvailableException.class, () -> field.addMower(mower4));

        // Test add null mower
        assertThrows(NullPointerException.class, () -> field.addMower(null));

    }

    @Test
    void testGetMowerList() {
        // Test with no mower
        Field field = new Field(10, 10);

        assertTrue(field.getMowerList().isEmpty());

        // Test with one mower
        Mower mower = new Mower(0, 0, Direction.NORTH, Collections.emptyList());
        try {
            field.addMower(mower);
        } catch (PositionNotAvailableException e) {
            e.printStackTrace();
        }

        List<Mower> mowerList = new ArrayList<>();
        mowerList.add(mower);

        assertArrayEquals(mowerList.toArray(), field.getMowerList().toArray());
    }

    @Test
    void testDoAllMoveAllMower() {
        // TODO
    }
}