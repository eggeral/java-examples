package egger.software.al_exceptions;


public class StringsAreEqualException extends RuntimeException {
    public StringsAreEqualException(String msg) {
        super (msg);
    }

    public StringsAreEqualException(String msg, Throwable cause) {
        super (msg, cause);
    }
}
