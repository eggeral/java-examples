package egger.software.ae_classes;

public interface Command {

    public static final String constant = "Consant";

    public void execute();

    static class NestedClass {}

    default void printConstantAndExecute() {
        System.out.println("printConstantAndExecute: " + constant);
        execute();
    }

    static void printConstant() {
        System.out.println("printConstant: " + constant);
        //execute(); //does not work!
    }
}
