package main.tool.file;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FileParserTest {

    @Test
    void testConstructor() {
        // Test good
        assertDoesNotThrow(() -> new FileParser("test-ressource/good-data.txt"));

        // Test empty
        assertThrows(IllegalArgumentException.class, () -> new FileParser(""));

        // Test null
        assertThrows(NullPointerException.class, () -> new FileParser(null));

        // Test not found
        assertThrows(NullPointerException.class, () -> new FileParser("test-ressource/doesnt-exist.txt"));
    }

    @Test
    void testLoadData() {
        // Test good data
        assertDoesNotThrow(() -> new FileParser("test-ressource/good-data.txt").loadData());

        // Test bad size Field
        assertThrows(NumberFormatException.class, () -> new FileParser("test-ressource/not-a-size-data.txt").loadData());

        // Test bad position Mower
        assertThrows(NumberFormatException.class, () -> new FileParser("test-ressource/not-a-position-data.txt").loadData());

        // Test bad direction Mower
        assertThrows(IllegalArgumentException.class, () -> new FileParser("test-ressource/not-a-direction-data.txt").loadData());

        // Test bad move Mower
        assertThrows(IllegalArgumentException.class, () -> new FileParser("test-ressource/not-a-move-data.txt").loadData());

        // Test bad move Mower
        assertThrows(IllegalArgumentException.class, () -> new FileParser("test-ressource/not-a-move-data.txt").loadData());

        // Test miss field line
        assertThrows(NullPointerException.class, () -> new FileParser("test-ressource/miss-field-line.txt").loadData());

        // Test miss mower line
        assertThrows(NumberFormatException.class, () -> new FileParser("test-ressource/miss-mower-line.txt").loadData());
    }
}