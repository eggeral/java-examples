package egger.software.al_exceptions;


public class UsingCustomExceptions {
    public static void main(String[] args) {
        calculateSomething("bar", "bar");
    }

    private static void calculateSomething(String foo, String bar) {
        if (foo.equals(bar))
            throw new StringsAreEqualException(foo + " is " + bar);
    }

}
