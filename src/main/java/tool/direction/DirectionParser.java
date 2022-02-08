package tool.direction;

import java.util.Objects;

/**
 * Direction Parser
 *
 * @author Joris Charlois
 * @version 1.0.0, 23/01/2022
 */

public class DirectionParser {

    private static final String NORTH = "N";
    private static final String EAST  = "E";
    private static final String SOUTH = "S";
    private static final String WEST  = "W";

    /**
     * Parse String direction into enum
     * @since 1.0.0, 23/01/2022
     * @param str string
     * @return enum direction
     */
    public static Direction toEnum(String str) {
        Objects.requireNonNull(str);
        Direction direction = null;
        switch (str) {
            case NORTH:
                direction = Direction.NORTH;
                break;
            case EAST:
                direction = Direction.EAST;
                break;
            case SOUTH:
                direction = Direction.SOUTH;
                break;
            case WEST:
                direction = Direction.WEST;
                break;
            default:
                throw new IllegalArgumentException("The parameter is not a direction known");
        }
        return direction;
    }

    /**
     * Parse enum direction into String
     * @since 1.0.0, 23/01/2022
     * @param direction enum direction
     * @return String
     */
    public static String toString(Direction direction) {
        Objects.requireNonNull(direction);
        String str = null;
        switch (direction) {
            case NORTH:
                str = NORTH;
                break;
            case EAST:
                str = EAST;
                break;
            case SOUTH:
                str = SOUTH;
                break;
            case WEST:
                str = WEST;
                break;
        }
        return str;
    }
}
