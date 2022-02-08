package exception;

/**
 * Exception could appear if a position asked is not avalable on a field
 *
 * @author Joris Charlois
 * @version 1.0.0, 23/01/2022
 */

public class PositionNotAvailableException extends Exception {
    public PositionNotAvailableException(String message) {super(message);}
}
