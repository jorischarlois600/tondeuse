package tool.move;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MoveParserTest {

    @Test
    void testToEnum() {
        // Test good String Forward
        assertEquals(Move.FORWARD, MoveParser.toEnum("A"));

        // Test good String Right
        assertEquals(Move.RIGHT, MoveParser.toEnum("D"));

        // Test good String Left
        assertEquals(Move.LEFT, MoveParser.toEnum("G"));

        // Test bad String
        assertThrows(IllegalArgumentException.class, () -> MoveParser.toEnum("X"));

        // Test empty String
        assertThrows(IllegalArgumentException.class, () -> MoveParser.toEnum(""));

        // Test empty String
        assertThrows(NullPointerException.class, () -> MoveParser.toEnum(null));
    }

    @Test
    void testToString() {
        // Test good Enum Forward
        assertEquals("A", MoveParser.toString(Move.FORWARD));

        // Test good Enum Right
        assertEquals("D", MoveParser.toString(Move.RIGHT));

        // Test good Enum Left
        assertEquals("G", MoveParser.toString(Move.LEFT));

        // Test empty String
        assertThrows(NullPointerException.class, () -> MoveParser.toString(null));
    }
}