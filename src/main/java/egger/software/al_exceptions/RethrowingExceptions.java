package egger.software.al_exceptions;

public class RethrowingExceptions {

    public static void main(String[] args) {

        System.err.println("Stack trace of an Exception");
        System.err.println("--");
        try {
            normalException();
        } catch (IllegalStateException ex) {
            ex.printStackTrace();
        }

        System.err.println();
        System.err.println("==================");
        System.err.println("Stack trace of an Exception rethrown (points to the original line number)");
        System.err.println("--");
        try {
            rethrownException();
        } catch (IllegalStateException ex) {
            ex.printStackTrace();
        }

        System.err.println();
        System.err.println("==================");
        System.err.println("Stack trace of a wrapped Exception (shows the line number of wrapped exception and the line number of the original)");
        System.err.println("--");
        try {
            wrappedException();
        } catch (IllegalStateException ex) {
            ex.printStackTrace();
        }
    }

    private static void normalException() {
        throw new IllegalStateException("KABOOM");
    }


    private static void rethrownException() {
        try {
            throw new IllegalStateException("KABOOM RETHROWN");
        } catch (IllegalStateException ex) {
            throw ex;
        }
    }

    private static void wrappedException() {
        try {
            throw new IllegalStateException("KABOOM WRAPPED");
        } catch (IllegalStateException ex) {
            throw new IllegalStateException("There was an error.", ex);
        }
    }


}
