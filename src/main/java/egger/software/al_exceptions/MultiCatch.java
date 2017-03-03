package egger.software.al_exceptions;

public class MultiCatch {

    public static void main(String[] args) {
        try {
            calculateSomething("bar", "bar");
        } catch (IllegalArgumentException | StringsAreEqualException e) {
            System.out.println("expected error");
        } catch (Exception ex) {
            System.out.println("unexpected error");
        }
    }

    private static void calculateSomething(String foo, String bar) {
        if (foo == null || bar == null)
            throw new IllegalArgumentException("foo or bar is null");

        if (foo.equals(bar))
            throw new StringsAreEqualException(foo + " is " + bar);
    }
}
