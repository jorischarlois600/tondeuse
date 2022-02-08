package tool.direction;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DirectionParserTest {

    @Test
    void testToEnum() {
        // Test good String North
        assertEquals(Direction.NORTH, DirectionParser.toEnum("N"));

        // Test good String East
        assertEquals(Direction.EAST, DirectionParser.toEnum("E"));

        // Test good String South
        assertEquals(Direction.SOUTH, DirectionParser.toEnum("S"));

        // Test good String West
        assertEquals(Direction.WEST, DirectionParser.toEnum("W"));

        // Test bad String
        assertThrows(IllegalArgumentException.class, () -> DirectionParser.toEnum("X"));

        // Test empty String
        assertThrows(IllegalArgumentException.class, () -> DirectionParser.toEnum(""));

        // Test bad String
        assertThrows(NullPointerException.class, () -> DirectionParser.toEnum(null));
    }

    @Test
    void testToString() {
        // Test good Enum North
        assertEquals("N", DirectionParser.toString(Direction.NORTH));

        // Test good Enum East
        assertEquals("E", DirectionParser.toString(Direction.EAST));

        // Test good Enum South
        assertEquals("S", DirectionParser.toString(Direction.SOUTH));

        // Test good Enum West
        assertEquals("W", DirectionParser.toString(Direction.WEST));

        assertThrows(NullPointerException.class, () -> DirectionParser.toString(null));
    }
}