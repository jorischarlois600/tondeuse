package main.tool.move;

import java.util.Objects;

/**
 * Move Parser
 *
 * @author Joris Charlois
 * @version 1.0.0, 23/01/2022
 */

public class MoveParser {

    private static final String FORWARD = "A";
    private static final String RIGHT  = "D";
    private static final String LEFT = "G";

    /**
     * Parse String move into enum
     * @since 1.0.0, 23/01/2022
     * @param str string
     * @return enum move
     */
    public static Move toEnum(String str) {
        Objects.requireNonNull(str);
        Move move = null;
        switch (str) {
            case FORWARD:
                move = Move.FORWARD;
                break;
            case RIGHT:
                move = Move.RIGHT;
                break;
            case LEFT:
                move = Move.LEFT;
                break;
            default:
                throw new IllegalArgumentException("The parameter is not a move known");
        }
        return move;
    }

    /**
     * Parse enum move into String
     * @since 1.0.0, 23/01/2022
     * @param move enum move
     * @return String
     */
    public static String toString(Move move) {
        Objects.requireNonNull(move);
        String str = null;
        switch (move) {
            case FORWARD:
                str = FORWARD;
                break;
            case RIGHT:
                str = RIGHT;
                break;
            case LEFT:
                str = LEFT;
                break;
        }
        return str;
    }
}
