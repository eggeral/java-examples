package egger.software.al_exceptions;

public class Finally {
    public static void main(String[] args) {
        try {
            calculateSomething("bar", "bar");
            throw new StringsAreEqualException("bar is bar");
        } catch (IllegalArgumentException | StringsAreEqualException e) {
            System.out.println("expected error");
        } catch (Exception ex) {
            System.out.println("unexpected error");
        } finally {
            System.out.println("Always! gets called");
        }
    }

    private static void calculateSomething(String foo, String bar) {
        try {
            return;
        } finally {
            System.out.println("Called after return.");
        }
    }
}
