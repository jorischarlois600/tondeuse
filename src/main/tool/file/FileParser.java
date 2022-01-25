package main.tool.file;

import main.exception.PositionNotAvailableException;
import main.tool.direction.Direction;
import main.tool.direction.DirectionParser;
import main.tool.move.Move;
import main.tool.move.MoveParser;
import main.object.Field;
import main.object.Mower;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * Parser input file parameters
 *
 * @author Joris Charlois
 * @version 1.0.0, 23/01/2022
 */

public class FileParser {

    /**
     * URI of the file
     */
    private String uri;

    /**
     * main.objects.Field created
     */
    private Field field;

    /**
     * Constructor
     * @since 1.0.0, 23/01/2022
     * @param uri uri of the file
     */
    public FileParser(String uri) {
        Objects.requireNonNull(uri);
        if (uri.isEmpty()) {
            throw new IllegalArgumentException("The URI of the file could not be empty");
        }
        if (!new File(uri).exists()) {
            throw new NullPointerException("The file doesn't exist");
        }
        this.uri = uri;
    }

    /**
     * Getter field
     */
    public Field getField() {
        return field;
    }

    /**
     * Generate all data from the file
     * @since 1.0.0, 23/01/2022
     */
    public void loadData() throws IOException, PositionNotAvailableException {
        File file = new File(uri);
        BufferedReader reader = new BufferedReader(new FileReader(file));
        parseField(reader.readLine());
        String line;
        while ((line = reader.readLine()) != null) {
            Mower mower = parseMower(line, reader);
            field.addMower(mower);
        }
    }

    /**
     * Parse field from the first line
     * @since 1.0.0, 23/01/2022
     * @param line the first line
     */
    private void parseField(String line) {
        String[] sizeStr = line.split(" ");
        field = new Field(Integer.parseInt(sizeStr[0]), Integer.parseInt(sizeStr[1]));
    }

    /**
     * Parse mower from 2 line y mower
     * @since 1.0.0, 23/01/2022
     * @param line first line of mower
     * @param reader reader that permit to read the second line
     * @return the main.objects.Mower
     * @throws IOException when the reader had a problem
     */
    private Mower parseMower(String line, BufferedReader reader) throws IOException {
        String[] sizeStr = line.split(" ");

        int posX = Integer.parseInt(sizeStr[0]);
        int posY = Integer.parseInt(sizeStr[1]);
        Direction direction = DirectionParser.toEnum(sizeStr[2]);

        line = reader.readLine();
        List<Character> listChar = new ArrayList<>();
        for (char charac : line.toCharArray()) {
            listChar.add(charac);
        }

        List<Move> moveList = listChar.stream()
                .map(str -> MoveParser.toEnum(str.toString()))
                .collect(Collectors.toList());

        return new Mower(posX, posY, direction, moveList);
    }
}
